package com.onlineshodh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.PaymentEntity;


@Controller
@RequestMapping(value="/admin/payments") 
public class PaymentController {

	WebApplicationContext context;
	
	@RequestMapping(value={"","/"})
	public String showManagePayment(ModelMap model){
/*		model.addAttribute("payment", context.getBean("payment",PaymentEntity.class));
*/		return "payment/managePayment";
	}
	
	
}
