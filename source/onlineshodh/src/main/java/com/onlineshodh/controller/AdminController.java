package com.onlineshodh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.service.UserDetailsService;
import com.onlineshodh.service.UserService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	private static final Logger logger = Logger
			.getLogger(BannerController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@RequestMapping(value={"","/","/home"})
	public String home(ModelMap model,HttpSession session)
	{
		
		UserDetails activeUser = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<UserEntity> users = userService.getUserByName(activeUser.getUsername());
		if(users.size()==1)
		{
			logger.info("Logged Admin: "+users.get(0).getUserName());
			Integer userDeailsId = userDetailsService.getUserDetailsByUserId(users.get(0).getUserId()).getUserDetailsId();
			model.addAttribute("userDeailsId", userDeailsId);
			session.setAttribute("userDeailsId", userDeailsId);
		}
		return "admin/admin";
	}
}
