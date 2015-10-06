package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.onlineshodh.entity.UserDetailsEntity;
import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.exception.ConstraintViolationException;
import com.onlineshodh.service.UserDetailsService;
import com.onlineshodh.service.UserService;
import com.onlineshodh.supportclass.ClientDetails;

@Controller
@RequestMapping(value="/admin/clients")
public class ClientController {
	private static final Logger logger = Logger
			.getLogger(ClientController.class);
	
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Value("${mandatory}")
	String mandatory;
	
	@RequestMapping(value={"/",""})
	public String manageClients(ModelMap model)
	{
		model.addAttribute("clientdetails", context.getBean("clientDetails",ClientDetails.class));
		model.addAttribute("userDetails", userDetailsService.getAllUserDetails());
		return "client/manageClients";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveClient(ModelMap model,@RequestParam("file") MultipartFile file,@Valid @ModelAttribute("clientdetails") ClientDetails clientdetails, BindingResult result)
	{
		model.addAttribute("userDetails", userDetailsService.getAllUserDetails());
		if(result.hasErrors())
		{
			for(FieldError error:result.getFieldErrors())
				System.out.println(error.getDefaultMessage());
		}
		if(file.isEmpty() && clientdetails.getUserDetails().getPhotograph()==null)
		{
			FieldError categoryNotSelected = new FieldError("clientdetails", "userDetails.photograph", mandatory);
			result.addError(categoryNotSelected);
		}
		else
		{
			UserEntity user = clientdetails.getUser();
			FieldError error;
			try
			{
				userService.saveUser(user);
				UserDetailsEntity userDetails = clientdetails.getUserDetails();
				userDetails.setUserId(user.getUserId());
				userDetails.setEmail(user.getUserName());
				String name = userDetails.getName().toUpperCase();
				userDetails.setName(name);
				try {
					if(!file.isEmpty())
						userDetails.setPhotograph(file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				userDetailsService.saveUserDetails(userDetails);
			}
			catch(ConstraintViolationException e)
			{
				error = new FieldError("clientdetails", "user."+e.getField(), e.getMsg());
				result.addError(error);
				return "client/manageClients";
			}
			catch(Exception e)
			{
				error = new FieldError("clientdetails", "user.userName", "*Invalid Data");
				e.printStackTrace();
			}
			return "redirect:/admin/clients";
		}
		return "client/manageClients";
	}
	
	@RequestMapping("/load/logo/{userDetailsId}")
	public String downloadPicture(@PathVariable("userDetailsId") Integer userDetailsId,HttpServletResponse response) {
		UserDetailsEntity userDetails = userDetailsService.getUserDetails(userDetailsId);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\""
					+ userDetails.getName() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType("image/gif");
			ByteArrayInputStream bis = new ByteArrayInputStream(
					userDetails.getPhotograph());
			IOUtils.copy(bis, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
			logger.info("File Not Found for subCategoryId: "+userDetailsId);
		}
		return null;
	}

}
