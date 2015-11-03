package com.onlineshodh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.TownEntity;
import com.onlineshodh.model.SuggestBusiness;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.TownService;
import com.onlineshodh.service.UserDetailsService;
import com.onlineshodh.service.UserService;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	BusinessDetailsService businessDetailsService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	UserService userService;

	@Value("${onlyAlphabets}")
	String onlyAlphabets;

	@Autowired
	WebApplicationContext context; 
	
	@Autowired
	TownService townService;
	
	@RequestMapping(value="/dosearch",method = RequestMethod.GET)
	@ResponseBody
	public List<String> doSearch(@RequestParam("term") String tagName)
	{
		SuggestBusiness suggestBusiness=context.getBean("suggestBusiness",SuggestBusiness.class);
		List<String> l = suggestBusiness.doAutoSuggest(tagName);
		for(String str:l)
			System.out.println(str);
		return l;
	}
	
	@RequestMapping(value="/doCitySearch",method = RequestMethod.GET)
	@ResponseBody
	public List<String> doCitySearch(@RequestParam("term") String cityName)
	{
		List<String> l = new ArrayList<String>();
		List<TownEntity> towns = townService.getTownsByCityName(cityName);
		
		for(TownEntity town:towns)
			l.add(town.getCity().getCityName()+" ("+town.getTownName()+")");
		return l;
	}
	
}
