package com.onlineshodh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.service.BusinessDetailsService;

@Controller
@RequestMapping("admin/business")
public class BusinessController {
	
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	BusinessDetailsService businessService;
	
	@RequestMapping(value={"/",""})
	public String manageBusinessDetails(ModelMap model)
	{
		model.addAttribute("businessDetails", context.getBean("businessDetailsEntity",BusinessDetailsEntity.class));
		return "";
	}
	
	public String saveBusinessDetails(@Valid @ModelAttribute BusinessDetailsEntity businessDetails, BindingResult result)
	{
		
		
		return "";
	}
	

}
