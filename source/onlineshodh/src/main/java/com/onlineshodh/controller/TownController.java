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
import com.onlineshodh.entity.TownEntity;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.CountryService;
import com.onlineshodh.service.StateService;
import com.onlineshodh.service.TownService;
import com.onlineshodh.entity.StateEntity;


@Controller
@RequestMapping(value="/admin/towns")
public class TownController {

	private static final Logger logger=Logger.getLogger(TownController.class);
	
	@Autowired
	WebApplicationContext context;

	@Autowired
	CountryService countryService;
	
	@Autowired
	StateService stateService;

	@Autowired
	CityService cityService;
	
	@Autowired
	TownService townService;
	
	@Value("${onlyAlphabets}")
	String onlyAlphabets;  
	
	@Value("${alreadyExist}")
	String alreadyExist;    
	
	@Value("${mandatory}")
	String mandatory;
	
	
	
	
	
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)  
	public String showManageTowns(ModelMap model){
		model.addAttribute("towns", townService.getAllTowns());
		model.addAttribute("Town", new TownEntity());
		model.addAttribute("countries", countryService.getAllCountries());
		return "town/manageTowns";
	}
	
	@RequestMapping(value="/showStates",method=RequestMethod.POST,produces="application/json" )
	public @ResponseBody List<StateEntity> getAllStates(ModelMap model,@RequestParam("countryID")Integer countryId){
		return stateService.getAllStates(countryId);
	}
	
	@RequestMapping(value="/showCities",method=RequestMethod.POST,produces="application/json" )
	public @ResponseBody List<CityEntity> getAllCities(ModelMap model,@RequestParam("stateID")Integer stateId){
		return cityService.getAllCities(stateId);
	}
	
	@RequestMapping(value="/save",method=RequestMethod.GET)
	public String saveTown(ModelMap model){
	return "redirect:/admin/towns"; 
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveTown(ModelMap model,@Valid @ModelAttribute("Town")TownEntity town,BindingResult result){
		boolean flag=false;
		System.out.println(town);
		if(result.hasErrors()){
			List<FieldError> errors=result.getFieldErrors();
            for(FieldError error:errors){
            	logger.info(error.getDefaultMessage());
            }
            
		}
		if(town.getCity().getState().getCountry().getCountryId()==0){
			FieldError countryNotSelected=new FieldError("town", "city.state.country.countryId", mandatory);
			result.addError(countryNotSelected);
			flag=true;
		}
		if(town.getCity().getState().getStateId()==0){
			FieldError stateNotSelected=new FieldError("town", "city.state.stateId", mandatory);
			result.addError(stateNotSelected);
			flag=true;
		}if(town.getCity().getCityId()==0){
			FieldError cityNotSelected=new FieldError("town", "city.cityId", mandatory);
			result.addError(cityNotSelected);
			flag=true;
		}if(town.getTownName().equalsIgnoreCase("")){
			FieldError townNameNotEnter=new FieldError("town", "townName", mandatory);
			result.addError(townNameNotEnter);
			flag=true;
		}
		
		if(flag){
			model.addAttribute("countries", countryService.getAllCountries());
			 model.addAttribute("states",stateService.getAllStates(town.getCity().getState().getCountry().getCountryId())); 
			 model.addAttribute("cities",cityService.getAllCities(town.getCity().getState().getStateId()));
			 
			 return "town/manageTowns";
		}
		else{
			 
			//try{
				//System.out.println(town);
				townService.updateTown(town);
				return "redirect:/admin/towns";
				
			/*}catch(DataIntegrityViolationException e){
				FieldError townNameAvailableError;
				if(e.getMostSpecificCause().getMessage().contains("unique"))
					townNameAvailableError=new FieldError("town", "townName", alreadyExist);
				else
					townNameAvailableError = new FieldError("town", "townName",
							onlyAlphabets);
				result.addError(townNameAvailableError);	
			}
*/		}
		
		//return "town/manageTowns";
	}
	
	@RequestMapping(value="/edit/{townId}/{countryId}/{stateId}",method=RequestMethod.GET)
	public String editCity(ModelMap model,@PathVariable("townId")Integer townId,@PathVariable("countryId")Integer countryId,@PathVariable("stateId")Integer stateId)
	{
		
		List<StateEntity> states=null;
		List<CityEntity> cities=null;
		states = stateService.getAllStates(countryId);
		cities=cityService.getAllCities(stateId);
		for (StateEntity state : states)
			System.out.println(" States :" + state.getStateName());
		model.addAttribute("Town", townService.getTownById(townId));
		model.addAttribute("cities", cities);
		model.addAttribute("states",states);
		model.addAttribute("countries",countryService.getAllCountries());
		
		return "town/updateTown";
	}
	
	
	@RequestMapping(value="/delete/{townId}", method=RequestMethod.GET)
	public String deleteTown(ModelMap model, @PathVariable("townId") Integer townId)
	{
		System.out.println("In Delete File :"+townId);
		townService.deleteTown(townId);
		return "redirect:/admin/towns";
	}
	
	@RequestMapping(value="/exception/{excetiontype}")
	public String HandleException(ModelMap model,@PathVariable("excetiontype")String exception,@ModelAttribute("Town") TownEntity town, BindingResult result)
	{
		FieldError townNameAvailableError;
		
		if(exception.equalsIgnoreCase("unique")){
			townNameAvailableError=new FieldError("town", "townName", alreadyExist);
			}else{
				townNameAvailableError = new FieldError("town", "townName",
						onlyAlphabets);
			}
		result.addError(townNameAvailableError);
		model.addAttribute("countries", countryService.getAllCountries());
		model.addAttribute("towns", townService.getAllTowns());
		return "town/manageTowns";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
