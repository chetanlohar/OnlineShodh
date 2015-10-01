package com.onlineshodh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.supportclass.ClientDetails;

@Controller
@RequestMapping(value="/admin/clients")
public class ClientController {
	
	@Autowired
	WebApplicationContext context;
	
	@RequestMapping(value={"/",""})
	public String manageClients(ModelMap model)
	{
		model.addAttribute("clientdetails", context.getBean("clientDetails",ClientDetails.class));
		return "client/manageClients";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveClient(ModelMap model,@Valid @ModelAttribute("clientdetails") ClientDetails clientdetails, BindingResult result)
	{
		/*UserEntityValidator userValidator = context.getBean("userEntityValidator",UserEntityValidator.class);
		userValidator.validate(clientdetails.getUser(), result);*/
		
		if(result.hasErrors())
		{
			for(FieldError error:result.getFieldErrors())
				System.out.println(error.getDefaultMessage());
		}
		
		System.out.println("user: "+clientdetails.getCountry());
		System.out.println("Test: "+clientdetails.getUser());
		return "client/manageClients";
	}

}
