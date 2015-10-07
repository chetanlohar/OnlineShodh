package com.onlineshodh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@RequestMapping(value={"/","/home"})
	public String home()
	{
		return "admin/admin";
	}
	
	@RequestMapping(value="/oldhome")
	public String home1()
	{
		return "admin/adminHome";
	}

}
