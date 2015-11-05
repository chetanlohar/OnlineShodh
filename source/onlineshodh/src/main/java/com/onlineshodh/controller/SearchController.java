package com.onlineshodh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.TownEntity;
import com.onlineshodh.model.SuggestBusiness;
import com.onlineshodh.model.SuggestSubCategory;
import com.onlineshodh.service.BusinessAddressService;
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
	
	@Autowired
	BusinessAddressService businessAddressService;
	
	List<TownEntity> towns;
	private List<String> strTownsWithCity;
	
	@PostConstruct
	public void init()
	{
		towns = townService.getAllTowns();
		strTownsWithCity = new ArrayList<String>();
		for(TownEntity town:towns)
		{
			strTownsWithCity.add(town.getCity().getCityName()+" ("+town.getTownName()+")");
		}
	}
	 
	@RequestMapping(value="/dosearch",method = RequestMethod.GET)
	@ResponseBody
	public List<String> doSearch(@RequestParam("term") String tagName,@RequestParam("cityName") String cityName)
	{
		System.out.println("cityName: "+cityName);
		SuggestBusiness suggestBusiness=context.getBean("suggestBusiness",SuggestBusiness.class);
		SuggestSubCategory suggestSubCategory = context.getBean("suggestSubCategory",SuggestSubCategory.class);
		List<String> l = new ArrayList<String>();
		l.addAll(suggestSubCategory.doAutoSuggest(tagName.trim()));
		l.addAll(suggestBusiness.doAutoSuggest(tagName.trim(),cityName.trim()));
		for(String str:l)
			System.out.println(str);
		return l;
	}
	
	@RequestMapping(value="/doCitySearch",method = RequestMethod.GET)
	@ResponseBody
	public List<String> doCitySearch(@RequestParam("term") String str)
	{
		List<String> matches = new ArrayList<String>();
		for(String citytown:strTownsWithCity)
			if(citytown.toUpperCase().contains(str.toUpperCase()))
				matches.add(citytown);
		return matches;
	}
	
	@RequestMapping(value={"/businesses"})
	public String getBusinessDetails(@RequestParam("tagName") String tagName,@RequestParam("cityName") String cityName, ModelMap model)
	{
		System.out.println("tagName: "+tagName+"\n"+"cityName: "+cityName);
		return "redirect:/";
	}
}
