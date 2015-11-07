package com.onlineshodh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.BannerEntity;
import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.CheckEntity;
import com.onlineshodh.entity.PaymentEntity;
import com.onlineshodh.service.BannerService;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.CheckService;
import com.onlineshodh.service.PaymentModeService;
import com.onlineshodh.service.PaymentService;
import com.onlineshodh.support.validator.PaymentValidator;
import com.onlineshodh.supportclass.PaymentStatus;

@Controller
@RequestMapping(value = "/admin/payments")
public class PaymentController {

	@Autowired
	WebApplicationContext context;

	@Autowired
	PaymentModeService paymentModeService;

	@Autowired
	PaymentService paymentService;

	@Autowired
	BusinessDetailsService businessDetailsService;

	@Autowired
	BannerService bannerService;

	@Autowired
	CheckService checkService;
	

	PaymentValidator paymentValidator; 

	@Autowired
	public PaymentController(WebApplicationContext context,
			PaymentValidator paymentValidator) {
		super();
		this.context = context;
		this.paymentValidator = paymentValidator;
	}

	@RequestMapping(value = { "", "/" })
	public String showManagePayment(ModelMap model) {
		model.addAttribute("paymentStatus",
				context.getBean("paymentStatus", PaymentStatus.class));
		model.addAttribute("paymentmodes",
				paymentModeService.getAllPaymentMode());
		return "payment/paymanet_mode";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.GET)
	public String RedirectSavePayment(ModelMap model,@ModelAttribute("paymentStatus") PaymentStatus paymentStatus){
		model.addAttribute("paymentmodes",
				paymentModeService.getAllPaymentMode());
		return "payment/paymanet_mode";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePayment(
			@RequestParam("businessName") String businessName,
			@RequestParam("bannerName") String bannerName,
			ModelMap model,
			@Valid @ModelAttribute("paymentStatus") PaymentStatus paymentStatus,
			BindingResult result) {

		Integer paymentId = 0;
         boolean flag=false;
         
		paymentValidator.validate(paymentStatus, result);
		 
		if (result.hasErrors()) {
			System.out.println(" Error Count :" + result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println("Error: " + error.getDefaultMessage());
			}
			flag=true;
		} 
		
		if(flag){
			
			model.addAttribute("paymentmodes",
					paymentModeService.getAllPaymentMode());
			return "payment/paymanet_mode";
		}
		
		
		else {
			if (paymentStatus.getPayment().getPaymentfor()
					.equalsIgnoreCase("BusinessAdvertisement")) {
				List<BusinessDetailsEntity> list = businessDetailsService
						.getBusinessDetailsByBusinessName(businessName
								.toLowerCase().trim());

				System.out.println("list Size:" + list.size());
				for (BusinessDetailsEntity business : list) {
					System.out.println(" Business Id :"
							+ business.getBusinessId());
					paymentStatus.getPayment().setBusinessId(
							business.getBusinessId());
					paymentStatus.getPayment().setBannerId(null);
				}
				paymentStatus.getPayment().setBusiness(true);
				System.out.println(" Payment :" + paymentStatus.getPayment());

				paymentId = paymentService.savePayment(paymentStatus
						.getPayment());
				System.out.println("PayMent Staus :"
						+ paymentStatus.getPayment().toString());
				if (paymentStatus.getPayment().getPaymentMode()
						.getPaymentModeid() == 2) {

					CheckEntity checkEntity = paymentStatus.getCheck();
					checkEntity.setPaymentId(paymentId);
					checkService.saveCheck(checkEntity);
				}
				
			} else {
				List<BannerEntity> list = bannerService
						.getBannerByBannerName(bannerName.toLowerCase().trim());
				for (BannerEntity banner : list) {
					paymentStatus.getPayment()
							.setBannerId(banner.getBannerId());
					paymentStatus.getPayment().setBusinessId(null);
				}
				paymentStatus.getPayment().setBusiness(false);

				Integer lastPaymentId = 0;
				lastPaymentId = paymentService.savePayment(paymentStatus
						.getPayment());
				if (paymentStatus.getPayment().getPaymentMode()
						.getPaymentModeid() == 2) {

					CheckEntity checkEntity = paymentStatus.getCheck();
					checkEntity.setPaymentId(lastPaymentId);
					checkService.saveCheck(checkEntity);
				}
			}
			
		}
		return "payment/paymanet_mode";
	}

}
