package com.onlineshodh.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping(value="/admin/countries")
public class CountryController {

	private static final Logger logger=Logger.getLogger(CountryController.class);
	@Autowired
	public CountryService countryService;
	
	@Value("${onlyAlphabets}")
	String onlyAlphabets;  
	
	@Value("${alreadyExist}")
	String alreadyExist; 
	
	/*@RequestMapping(value="/exception/{excetiontype}")
	public String HandleException(ModelMap model,@PathVariable("excetiontype")String exception,@ModelAttribute("country") CountryEntity country, BindingResult result)
	{
		FieldError countryNameAvailableError;
		if(exception.equalsIgnoreCase("unique")){
		countryNameAvailableError = new FieldError("country","countryName",alreadyExist);
		result.addError(countryNameAvailableError);
		}else{
			//countryNameAvailableError = new FieldError("country","countryName",onlyAlphabets);
		}
		
		
		model.addAttribute("countries", countryService.getAllCountries());
		return "country/manageCountries";
		
	}*/
	
	@RequestMapping(value={"/",""})
	public String showManageCountries(ModelMap model)
	{
		List<CountryEntity> countries = countryService.getAllCountries();
		model.addAttribute("countries", countries);
		model.addAttribute("country",new CountryEntity());
		return "country/manageCountries";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public String saveCountry(ModelMap model)
	{
		return "redirect:/admin/countries";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCountry(ModelMap model,@Valid @ModelAttribute("country") CountryEntity country, BindingResult result)
	{
		System.out.println(country);
		if(result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError error:errors){
				System.out.println(error.getDefaultMessage());
				logger.info(error.getDefaultMessage());
			}
		}
		else
		{
			try
			{
				countryService.updateCountry(country);
				return "redirect:/admin/countries";
			}
			catch(DataIntegrityViolationException e)
			{
				FieldError countryNameAvailableError;
				if(e.getMostSpecificCause().getMessage().contains("unique")){
					countryNameAvailableError = new FieldError("country","countryName",alreadyExist);
					logger.debug(countryNameAvailableError.getDefaultMessage());
					result.addError(countryNameAvailableError);
				}
				else{
					countryNameAvailableError = new FieldError("country","countryName",onlyAlphabets);
				result.addError(countryNameAvailableError);
				logger.debug(countryNameAvailableError.getDefaultMessage());
				}
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
		return "redirect:/admin/countries";
	}
}
