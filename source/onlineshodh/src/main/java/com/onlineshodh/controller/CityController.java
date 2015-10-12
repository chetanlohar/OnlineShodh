package com.onlineshodh.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.entity.StateEntity;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.CountryService;
import com.onlineshodh.service.StateService;


@Controller
@RequestMapping(value = "/admin/cities")
public class CityController {

	@Autowired
	WebApplicationContext context;

	@Autowired
	CityService cityService;

	@Autowired
	StateService stateService;

	@Autowired
	CountryService countryService;
	
	@Value("${onlyAlphabets}")
	String onlyAlphabets;  
	
	@Value("${alreadyExist}")
	String alreadyExist;   
	
	
	@Value("${mandatory}")
	String mandatory;
	
	
	

	@RequestMapping(value = { "", "/" })
	public String showManageCities(ModelMap model) {
		model.addAttribute("countries", countryService.getAllCountries());
		model.addAttribute("states", stateService.getAllStates());
		model.addAttribute("cities", cityService.getAllCities());
		model.addAttribute("City", new CityEntity());
		return "city/manageCities";
	}

	@RequestMapping(value="/save",method=RequestMethod.GET)
	public String redirectTosaveCity(){
		return "redirect:/admin/cities";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCity(ModelMap model,
			@Valid @ModelAttribute(value = "City") CityEntity city,
			BindingResult result) {
		boolean flag=false;
		
		System.out.println(city);
		

		
		if (result.hasErrors()) {

			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors)
				System.out.println(error.getDefaultMessage());
		}
		if(city.getState().getCountry().getCountryId()==0){
			FieldError countryNotSelected=new FieldError("city", "state.country.countryId", mandatory);
		    result.addError(countryNotSelected); 
		    flag=true;
		}if(city.getState().getStateId()==0){
			
			FieldError stateNotSelected=new FieldError("city", "state.stateId", mandatory);
			result.addError(stateNotSelected);
			flag=true;
		}if(city.getCityName().equalsIgnoreCase("")){
			FieldError cityNameNotEnter= new FieldError("city","cityName",mandatory);
			result.addError(cityNameNotEnter);
			flag=true;
		}
		
		if(flag){
			model.addAttribute("countries", countryService.getAllCountries());
			 model.addAttribute("states",stateService.getAllStates(city.getState().getCountry().getCountryId()));       	
			  
			return "city/manageCities";	
		}
		else {

			try {

				
				cityService.updateCity(city);
				return "redirect:/admin/cities";

			} catch (DataIntegrityViolationException e) {
				FieldError cityNameAvailableError;
				System.out.println(" Cause "+e.getMostSpecificCause().getMessage());
				if (e.getMostSpecificCause().getMessage().contains("unique"))
					cityNameAvailableError = new FieldError("city", "cityName",	alreadyExist);
				else
					cityNameAvailableError = new FieldError("city", "cityName",	onlyAlphabets);
				
				result.addError(cityNameAvailableError);
			}

		}

		return "city/manageCities";

	}

	@RequestMapping(value = "/showstates", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<StateEntity> showStates(ModelMap model,@RequestParam("countryID")Integer countryData) {
		List<StateEntity> states=null;
		 states = stateService.getAllStates(countryData);
		for (StateEntity state : states)
			System.out.println(" States :" + state.getStateName());

		return states;
	}
	
	@RequestMapping(value="/edit/{cityId}/{countryId}",method=RequestMethod.GET)
	public String editCity(ModelMap model,@PathVariable("cityId")Integer cityId,@PathVariable("countryId")Integer countryId)
	{
		 
		List<StateEntity> states=null;
		states = stateService.getAllStates(countryId);
		for (StateEntity state : states)
			System.out.println(" States :" + state.getStateName());
		CityEntity city=cityService.getCityById(cityId);
		model.addAttribute("city", city);
		model.addAttribute("states",states);
		model.addAttribute("countries",countryService.getAllCountries());
		System.out.println(" In UpDate Controller");
		return "city/updateCity";
	}
	
	@RequestMapping(value="/delete/{cityId}", method=RequestMethod.GET)
	public String deleteCity(ModelMap model, @PathVariable("cityId") Integer cityId)
	{
		System.out.println("In Delete File :"+cityId);
		cityService.deleteCity(cityId);
		return "redirect:/admin/cities";
	}
	

}
