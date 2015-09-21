package com.onlineshodh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.CountryEntity;
import com.onlineshodh.service.CountryService;

@Controller
@RequestMapping(value="/countries")
public class CountryController {

	@Autowired
	WebApplicationContext context;
	
	@Autowired
	public CountryService countryService;
	
	@RequestMapping(value="/manageCountries")
	public String showManageCountries(Map<String,Object> map)
	{
		List<CountryEntity> countries = countryService.getAllCountries();
		System.out.println(countries.size());
		for(CountryEntity country:countries)
			System.out.println(country.getCountryName());
		
		CountryEntity country = context.getBean("countryEntity", CountryEntity.class);
		country.setCountryId(4);
		country.setCountryName("Germany");
		System.out.println(country);
		countryService.saveCountry(country);
		return "login";
	}
	
	@RequestMapping(value="/saveCountry", method=RequestMethod.POST)
	public String saveCountry()
	{
		return "";
	}
	
	@RequestMapping(value="/editCountry", method=RequestMethod.POST)
	public String editCountry()
	{
		
		return "";
	}
	
}
