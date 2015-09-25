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

	@RequestMapping(value = { "/", "" })
	public String ShowManageStates(ModelMap model) {
       model.addAttribute("states",stateService.getAllStates());
       model.addAttribute("countries",countryService.getAllCountries());
	   model.addAttribute("state", new StateEntity());
		return "state/manageStates";
	}

	@RequestMapping(value = "/save")
	public String saveState(ModelMap model,
			@Valid @ModelAttribute(value = "state") StateEntity state,
			BindingResult result) {
		System.out.println(state);
		if (result.hasErrors()) {

			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors)
				System.out.println(error.getDefaultMessage());
		} else {

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
							"stateName", "*stateName is already Exists!");
				else
					stateNameAvailableError = new FieldError("state",
							"stateName",
							"*Only Alphabets allowed for State Name!");
				result.addError(stateNameAvailableError);

			}
		}

		return "manageStates";
	}
	
	@RequestMapping(value="/edit/{stateId}/{countryId}",method=RequestMethod.GET)
	public String editState(ModelMap model,@PathVariable("stateId")Integer stateId,@PathVariable("countryId")Integer countryId)
	{
		StateEntity state=stateService.getStateById(stateId);
		//state.setCountryId(countryId);
		//System.out.println("State Country ID"+countryId);
		model.addAttribute("state", state);
		System.out.println(" In UpDate Controller");
		return "state/updateState";
	}
	@RequestMapping(value="/delete/{stateId}", method=RequestMethod.GET)
	public String deleteCountry(ModelMap model, @PathVariable("stateId") Integer stateId)
	{
		System.out.println("In Delete File :"+stateId);
		stateService.deleteState(stateId);
		return "redirect:/states";
	}
	

}
