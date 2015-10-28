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

import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.entity.CountryEntity;
import com.onlineshodh.entity.PlanEntity;
import com.onlineshodh.service.PlanService;



@Controller
@RequestMapping("admin/plans")
public class PlanController {
	
	@Autowired
	PlanService planservice;
	
	@Value("${onlyAlphabets}")
	String onlyAlphabets;  
	
	@Value("${alreadyExist}")
	String alreadyExist;   
	
	@Value("${alphaNumeric}") 
	String alphaNumeric;
	
	@RequestMapping(value="/save",method=RequestMethod.GET)
	public String redirectTosaveCity(){
		return "redirect:/admin/plans";
	}
	
	@RequestMapping(value={"","/"})
	public String showManagePlan(ModelMap model){
		model.addAttribute("plan", new PlanEntity());
		model.addAttribute("plans", planservice.getAllPlans());
		return "plan/managePlan";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePlan(ModelMap model,@Valid@ModelAttribute("plan")PlanEntity Plan,BindingResult result){
		
		if(result.hasErrors()){
			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors)
				System.out.println(error.getDefaultMessage());
			
		}else{
			try{
			planservice.savePlan(Plan);
			return "redirect:/admin/plans";
			}catch (DataIntegrityViolationException exception) {
				FieldError planNameAvailableError;
				System.out.println(exception.getMostSpecificCause()
						.getMessage());
				if (exception.getMostSpecificCause().getMessage()
						.contains("unique"))
					planNameAvailableError = new FieldError("plan", "planName",	alreadyExist);
				else
					planNameAvailableError = new FieldError("plan", "planName",alphaNumeric);
				result.addError(planNameAvailableError);

			}
		}
		return "plan/managePlan";
		
	}
	
	/*@RequestMapping(value="/exception/{excetiontype}")
	public String HandleException(ModelMap model,@PathVariable("excetiontype")String exception,@ModelAttribute("plan") PlanEntity plan, BindingResult result)
	{
		FieldError planNameAvailableError;
		
		if(exception.equalsIgnoreCase("unique")){
			planNameAvailableError = new FieldError("plan", "planName",	alreadyExist);
		}
		else{
				planNameAvailableError = new FieldError("plan", "planName",alphaNumeric);
			}
		
		result.addError(planNameAvailableError);
		return "plan/managePlans";
		
	}*/
	@RequestMapping(value="/edit/{planId}",method=RequestMethod.GET)
	public String editPlan(ModelMap model,@PathVariable("planId")Integer planId){
		PlanEntity planEntity=planservice.getPlan(planId);
		model.addAttribute("plan",planEntity);
		return "plan/updatePlan";
	}   
	
	@RequestMapping(value="/delete/{planId}",method=RequestMethod.GET)
	public String deletePlan(ModelMap model,@PathVariable("planId")Integer planId){
		planservice.deletePlan(planId);
		return "redirect:/admin/plans";
	}
	
}
