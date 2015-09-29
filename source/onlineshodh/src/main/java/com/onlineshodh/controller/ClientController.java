package com.onlineshodh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/clients")
public class ClientController {
	
	@RequestMapping(value={"/",""})
	public String manageClients()
	{
		return "";
	}
	

}
