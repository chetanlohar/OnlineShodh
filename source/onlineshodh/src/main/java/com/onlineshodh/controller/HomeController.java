package com.onlineshodh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshodh.service.TownService;

@Controller
public class HomeController {
	
	@Autowired
	TownService townService;
	
	/*@Autowired
	C*/
	
	@RequestMapping(value={"/",""})
	public String showHome(ModelMap model)
	{
		return "index";
	}

}
