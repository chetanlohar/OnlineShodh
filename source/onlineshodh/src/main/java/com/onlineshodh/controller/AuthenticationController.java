package com.onlineshodh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/security")
public class AuthenticationController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("welcome");
		return model;

	}
	
	@RequestMapping(value="/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,ModelMap model)
	{
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}
	
	@RequestMapping(value="/role1")
	public String role1(ModelMap model)
	{
		System.out.println("came in role1");
		model.addAttribute("title", "Java Developer");
		model.addAttribute("message", "Developes the Java Applications");
		return "home";
	}
	
}
