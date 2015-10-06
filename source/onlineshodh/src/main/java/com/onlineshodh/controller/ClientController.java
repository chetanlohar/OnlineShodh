package com.onlineshodh.controller;

import java.io.IOException;

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
import org.springframework.web.multipart.MultipartFile;

import com.onlineshodh.entity.UserDetailsEntity;
import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.service.UserService;
import com.onlineshodh.supportclass.ClientDetails;

@Controller
@RequestMapping(value="/admin/clients")
public class ClientController {
	
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/",""})
	public String manageClients(ModelMap model)
	{
		model.addAttribute("clientdetails", context.getBean("clientDetails",ClientDetails.class));
		return "client/manageClients";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveClient(ModelMap model,@RequestParam("file") MultipartFile file,@Valid @ModelAttribute("clientdetails") ClientDetails clientdetails, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			for(FieldError error:result.getFieldErrors())
				System.out.println(error.getDefaultMessage());
		}
		else
		{
			UserEntity user = clientdetails.getUser();
			System.out.println(user);
			
			userService.saveUser(user);
			
			/*UserDetailsEntity userDetails = clientdetails.getUserDetails();
			userDetails.setEmail(user.getUserName());
			try {
				if(!file.isEmpty())
					userDetails.setPhotograph(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			
			
			
		}
		
		return "client/manageClients";
	}

}
