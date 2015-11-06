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

import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.PaymentEntity;
import com.onlineshodh.service.BannerService;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.PaymentModeService;
import com.onlineshodh.service.PaymentService;


@Controller
@RequestMapping(value="/admin/payments") 
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
	
	@RequestMapping(value={"","/"})
	public String showManagePayment(ModelMap model){
		model.addAttribute("payment",context.getBean("paymentEntity",PaymentEntity.class));
	/*	model.addAttribute("payment", new PaymentEntity());*/
		model.addAttribute("paymentmodes", paymentModeService.getAllPaymentMode());
		return "payment/managePayment";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePayment(@RequestParam("businessName") String businessName,@RequestParam("bannerName") String bannerName, ModelMap model,@Valid @ModelAttribute("payment") PaymentEntity payment,BindingResult result){

		if(result.hasErrors()){
			System.out.println(" Error Count :"+result.getErrorCount());
			List<FieldError> errors= result.getFieldErrors();
			for (FieldError error:errors) {
				System.out.println("Error: "+error.getDefaultMessage());	
			}
		}
		else{
			if(payment.getPaymentfor().equalsIgnoreCase("BusinessAdvertisement")){
				List<BusinessDetailsEntity> list=businessDetailsService.getBusinessDetailsByBusinessName(businessName.toLowerCase().trim());
				
				System.out.println("list Size:"+list.size());
				for(BusinessDetailsEntity business:list){
					System.out.println(" Business Id :"+business.getBusinessId());
					payment.setBusinessId(business.getBusinessId());
					payment.setBannerId(null);
				}
				payment.setBusiness(true);
				System.out.println(" Payment :"+payment);
				paymentService.savePayment(payment);
			}
			/*else{
				List<BannerEntity> list=bannerService.getBannerByBannerName(payment.getBanner().getBannerName().toLowerCase().trim());
				for(BannerEntity banner:list){
					System.out.println(" Banner Id :"+banner.getBannerId());
					BannerEntity bannerEntity=payment.getBanner();
					BannerEntity bannerEntity=new BannerEntity();
					bannerEntity.setBannerId(banner.getBannerId());
					System.out.println("Busines Entity"+bannerEntity.toString());
				     payment.setBanner(bannerEntity);
				}
				payment.setBusiness(false);
				System.out.println(" df");
				paymentService.savePayment(payment);
			   }*/
			System.out.println(payment.toString());
		     
		}
		return "payment/managePayment";
	}
	
	
	
}
