package com.onlineshodh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value={"/",""})
	public String showManageCountries(ModelMap model)
	{
		List<CountryEntity> countries = countryService.getAllCountries();
		model.addAttribute("countries", countries);
		model.addAttribute("country",new CountryEntity());
		return "manageCountries";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCountry(ModelMap model,@Valid @ModelAttribute("country") CountryEntity country, BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError error:errors)
				System.out.println(error.getDefaultMessage());
		}
		else
			countryService.saveCountry(country);
		List<CountryEntity> countries = countryService.getAllCountries();
		model.addAttribute("countries", countries);
		model.addAttribute("country",new CountryEntity());
		return "manageCountries";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editCountry()
	{
		
		return "";
	}
	
}
