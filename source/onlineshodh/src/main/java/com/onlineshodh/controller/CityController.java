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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.entity.StateEntity;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.CountryService;
import com.onlineshodh.service.StateService;
import com.onlineshodh.support.validator.CityEntityValidator;

@Controller
@RequestMapping(value = "/admin/cities")
public class CityController {

	private static final Logger logger=Logger.getLogger(CityController.class);
	
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

	CityEntityValidator cityEntityValidator;

	@Autowired
	public CityController(CityEntityValidator cityEntityValidator) {
		super();
		this.cityEntityValidator = cityEntityValidator;
	}

	@RequestMapping(value = { "", "/" })
	public String showManageCities(ModelMap model) {
		model.addAttribute("countries", countryService.getAllCountries());
		model.addAttribute("states", stateService.getAllStates());
		model.addAttribute("cities", cityService.getAllCities());
		model.addAttribute("City", new CityEntity());
		return "city/manageCities";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String redirectTosaveCity() {
		return "redirect:/admin/cities";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCity(ModelMap model,
			@Valid @ModelAttribute(value = "City") CityEntity city,
			BindingResult result) {
		boolean flag = false;

		

		cityEntityValidator.validate(city, result);
		if (result.hasErrors()) {

			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors){
				System.out.println(error.getDefaultMessage());
			logger.info(error.getDefaultMessage());
			logger.error(error.getDefaultMessage());
			}
			flag = true;
		}
		try {
			if(city.getState().getCountry().getCountryId()==0){
				FieldError error=new FieldError("city","state.country.countryId", mandatory);
				result.addError(error);
				flag=true;
				/*errors.rejectValue("state.country.countryId", "11", mandatory);*/
			}if(city.getState().getStateId()==0){
				/*errors.rejectValue("state.stateId", "11", mandatory);*/
				FieldError error=new FieldError("city","state.stateId", mandatory);
				result.addError(error);
				flag=true;
			}
		} catch (NullPointerException e) {
			flag=true;
		}
		
		if (flag) {
			model.addAttribute("countries", countryService.getAllCountries());
			model.addAttribute(
					"states",
					stateService.getAllStates(city.getState().getCountry()
							.getCountryId()));

			return "city/manageCities";
		} else {

			try{
			cityService.updateCity(city);
			return "redirect:/admin/cities";
			}
			catch (DataIntegrityViolationException exception) {
				FieldError cityNameAvailableError;
				System.out.println(exception.getMostSpecificCause()
						.getMessage());
				if (exception.getMostSpecificCause().getMessage()
						.contains("unique")){
					cityNameAvailableError = new FieldError("city", "cityName",
							alreadyExist);
				logger.info( cityNameAvailableError);
				}
				else
					cityNameAvailableError = new FieldError("city", "cityName",
							onlyAlphabets);
				result.addError(cityNameAvailableError);{
					logger.info( cityNameAvailableError);
				}

			}
			return "city/manageCities";

		}

	}

	@RequestMapping(value = "/showstates", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<StateEntity> showStates(ModelMap model,
			@RequestParam("countryID") Integer countryData) {
		List<StateEntity> states = null;
		states = stateService.getAllStates(countryData);
		for (StateEntity state : states)
			System.out.println(" States :" + state.getStateName());

		return states;
	}

	@RequestMapping(value = "/edit/{cityId}/{countryId}", method = RequestMethod.GET)
	public String editCity(ModelMap model,
			@PathVariable("cityId") Integer cityId,
			@PathVariable("countryId") Integer countryId) {

		List<StateEntity> states = null;
		states = stateService.getAllStates(countryId);
		for (StateEntity state : states)
			System.out.println(" States :" + state.getStateName());
		CityEntity city = cityService.getCityById(cityId);
		model.addAttribute("city", city);
		model.addAttribute("states", states);
		model.addAttribute("countries", countryService.getAllCountries());
		return "city/updateCity";
	}

	@RequestMapping(value = "/delete/{cityId}", method = RequestMethod.GET)
	public String deleteCity(ModelMap model,
			@PathVariable("cityId") Integer cityId) {
		System.out.println("In Delete File :" + cityId);
		cityService.deleteCity(cityId);
		return "redirect:/admin/cities";
	}

	/*@RequestMapping(value = "/exception/{excetiontype}")
	public String HandleException(ModelMap model,
			@PathVariable("excetiontype") String exception,
			@ModelAttribute("City") CityEntity city, BindingResult result) {
		FieldError cityNameAvailableError;

		if (exception.equalsIgnoreCase("unique")) {
			cityNameAvailableError = new FieldError("city", "cityName",
					alreadyExist);
		} else {
			cityNameAvailableError = new FieldError("city", "cityName",
					onlyAlphabets);
		}
		result.addError(cityNameAvailableError);

		model.addAttribute("countries", countryService.getAllCountries());
		model.addAttribute("cities", cityService.getAllCities());
		return "city/manageCities";

	}*/

}
