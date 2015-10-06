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
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.StateEntity;
import com.onlineshodh.service.CountryService;
import com.onlineshodh.service.StateService;

@Controller
@RequestMapping(value = "/states")
public class StateController {

	@Autowired
	WebApplicationContext context;
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
	
	@RequestMapping(value = { "/", "" })
	public String ShowManageStates(ModelMap model) {
       model.addAttribute("states",stateService.getAllStates());
       model.addAttribute("countries",countryService.getAllCountries());
	   model.addAttribute("state", new StateEntity());
		return "state/manageStates";
	}

	@RequestMapping(value = "/save",method=RequestMethod.POST)
	public String saveState(ModelMap model,
			@Valid @ModelAttribute(value = "state") StateEntity state,
			BindingResult result) {
		boolean flag=false;
		System.out.println(state);
		if (result.hasErrors()) {

			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors)
				System.out.println(error.getDefaultMessage());
		}
		
		try{
		if(state.getCountry().getCountryId()==0){
			FieldError countryNotSelected=new FieldError("state", "country.countryId",mandatory);
			result.addError(countryNotSelected);
			flag=true; 
		}if(state.getStateName().equalsIgnoreCase("")){
			
			FieldError stateNameNotSelected=new  FieldError("state", "stateName", mandatory);
			result.addError(stateNameNotSelected);
			flag=true;
		}
		}catch(NullPointerException e){
			FieldError CountryIdNullError=null;
			if(e.getMessage().contains("Null"))
 			CountryIdNullError =new FieldError("state","country.countryId" , "Country  Not Selected!");
			result.addError(CountryIdNullError);
		}
		if(flag){
		   model.addAttribute("countries",countryService.getAllCountries());
			return "state/manageStates"; 
			/*return "redirect:/states";*/
		}
		
		else {

			try {
				System.out.println("CountryID : "+state.getCountry().getCountryId());
				stateService.updateState(state);
				return "redirect:/states";
			} catch (DataIntegrityViolationException exception) {
				FieldError stateNameAvailableError;
				System.out.println(exception.getMostSpecificCause()
						.getMessage());
				if (exception.getMostSpecificCause().getMessage()
						.contains("unique"))
					stateNameAvailableError = new FieldError("state",
							"stateName", alreadyExist);
				else
					stateNameAvailableError = new FieldError("state",
							"stateName",
							onlyAlphabets);
				result.addError(stateNameAvailableError);

			}
		}

		model.addAttribute("states",stateService.getAllStates());
		return "state/manageStates";
	}
	
	@RequestMapping(value="/edit/{stateId}/{countryId}",method=RequestMethod.GET)
	public String editState(ModelMap model,@PathVariable("stateId")Integer stateId,@PathVariable("countryId")Integer countryId)
	{
		StateEntity state=stateService.getStateById(stateId);
		model.addAttribute("state", state);
		model.addAttribute("countries",countryService.getAllCountries());
		System.out.println(" In UpDate Controller"+state.getCountry().getCountryName());
		return "state/updateState";
	}
	@RequestMapping(value="/delete/{stateId}", method=RequestMethod.GET)
	public String deleteState(ModelMap model, @PathVariable("stateId") Integer stateId)
	{
		System.out.println("In Delete File :"+stateId);
		stateService.deleteState(stateId);
		return "redirect:/states";
	}
	
	@RequestMapping(value = "/save",method=RequestMethod.GET)
	public String saveState(ModelMap model){
		return "redirect:/states";
	}

}
