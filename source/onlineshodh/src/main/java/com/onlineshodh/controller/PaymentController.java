package com.onlineshodh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.PaymentEntity;
import com.onlineshodh.service.PaymentModeService;


@Controller
@RequestMapping(value="/admin/payments") 
public class PaymentController {

	@Autowired
	WebApplicationContext context;
	
	@Autowired
	PaymentModeService paymentModeService;
	
	@RequestMapping(value={"","/"})
	public String showManagePayment(ModelMap model){
		model.addAttribute("payment",context.getBean("paymentEntity",PaymentEntity.class));
	/*	model.addAttribute("payment", new PaymentEntity());*/
		model.addAttribute("paymentmodes", paymentModeService.getAllPaymentMode());
		return "payment/managePayment";
	}
	
	
}
