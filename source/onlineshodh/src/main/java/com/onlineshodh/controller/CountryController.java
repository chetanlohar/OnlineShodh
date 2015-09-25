package com.onlineshodh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineshodh.entity.CountryEntity;
import com.onlineshodh.service.CountryService;

@Controller
@RequestMapping(value="/countries")
public class CountryController {

	@Autowired
	public CountryService countryService;
	
	@RequestMapping(value={"/",""})
	public String showManageCountries(ModelMap model)
	{
		List<CountryEntity> countries = countryService.getAllCountries();
		model.addAttribute("countries", countries);
		model.addAttribute("country",new CountryEntity());
		return "country/manageCountries";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCountry(ModelMap model,@Valid @ModelAttribute("country") CountryEntity country, BindingResult result)
	{
		System.out.println(country);
		if(result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError error:errors)
				System.out.println(error.getDefaultMessage());
		}
		else
		{
			try
			{
				countryService.updateCountry(country);
				return "redirect:/countries";
			}
			catch(DataIntegrityViolationException e)
			{
				FieldError countryNameAvailableError;
				if(e.getMostSpecificCause().getMessage().contains("unique"))
					countryNameAvailableError = new FieldError("country","countryName","*CountryName is already Exists!");
				else
					countryNameAvailableError = new FieldError("country","countryName","*Only Alphabets allowed for Country Name!");
				result.addError(countryNameAvailableError);
			}
		}
		model.addAttribute("countries", countryService.getAllCountries());
		return "country/manageCountries";
	}
	
	@RequestMapping(value="/edit/{countryId}", method=RequestMethod.GET)
	public String editCountry(ModelMap model, @PathVariable("countryId") Integer countryId)
	{
		CountryEntity country = countryService.getCountryById(countryId);
		model.addAttribute("country", country);
		return "country/updateCountry";
	}
	
	@RequestMapping(value="/delete/{countryId}", method=RequestMethod.GET)
	public String deleteCountry(ModelMap model, @PathVariable("countryId") Integer countryId)
	{
		countryService.deleteCountry(countryId);
		return "redirect:/countries";
	}
}
