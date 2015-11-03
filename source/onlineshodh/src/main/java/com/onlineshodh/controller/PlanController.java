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
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.BusinessPlanEntity;
import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.entity.CountryEntity;
import com.onlineshodh.entity.PlanEntity;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.BusinessPlanService;
import com.onlineshodh.service.PlanService;
import com.onlineshodh.service.impl.BusinessDetailsServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

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
	
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	BusinessDetailsService businessDetailsService;
	
	@Autowired
	BusinessPlanService businessPlanService;  

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String redirectTosaveCity() {
		return "redirect:/admin/plans";
	}

	@RequestMapping(value = { "", "/" })
	public String showManagePlan(ModelMap model) {
		model.addAttribute("plan", new PlanEntity());
		model.addAttribute("plans", planservice.getAllPlans());
		return "plan/Create_plan";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePlan(ModelMap model,
			@Valid @ModelAttribute("plan") PlanEntity Plan, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors)
				System.out.println(error.getDefaultMessage());

		} else {
			try {
				planservice.savePlan(Plan);
				return "redirect:/admin/plans";
			} catch (DataIntegrityViolationException exception) {
				FieldError planNameAvailableError;
				System.out.println(exception.getMostSpecificCause()
						.getMessage());
				if (exception.getMostSpecificCause().getMessage()
						.contains("unique"))
					planNameAvailableError = new FieldError("plan", "planName",
							alreadyExist);
				else
					planNameAvailableError = new FieldError("plan", "planName",
							alphaNumeric);
				result.addError(planNameAvailableError);

			}
		}
		return "plan/Create_plan";

	}

	/*
	 * @RequestMapping(value="/exception/{excetiontype}") public String
	 * HandleException(ModelMap model,@PathVariable("excetiontype")String
	 * exception,@ModelAttribute("plan") PlanEntity plan, BindingResult result)
	 * { FieldError planNameAvailableError;
	 * 
	 * if(exception.equalsIgnoreCase("unique")){ planNameAvailableError = new
	 * FieldError("plan", "planName", alreadyExist); } else{
	 * planNameAvailableError = new FieldError("plan", "planName",alphaNumeric);
	 * }
	 * 
	 * result.addError(planNameAvailableError); return "plan/managePlans";
	 * 
	 * }
	 */
	@RequestMapping(value = "/edit/{planId}", method = RequestMethod.GET)
	public String editPlan(ModelMap model,
			@PathVariable("planId") Integer planId) {
		System.out.println(" i am in Plan Edit");
		PlanEntity planEntity = planservice.getPlan(planId);
		model.addAttribute("plan", planEntity);
		return "plan/edit_plan";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePlan(ModelMap model,
			@Valid @ModelAttribute("plan") PlanEntity Plan, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors)
				System.out.println(error.getDefaultMessage());

		} else {
			try {
				planservice.savePlan(Plan);
				model.addAttribute("plans", planservice.getAllPlans());
				return "plan/plantable";
			} catch (DataIntegrityViolationException exception) {
				FieldError planNameAvailableError;
				System.out.println(exception.getMostSpecificCause()
						.getMessage());
				if (exception.getMostSpecificCause().getMessage()
						.contains("unique"))
					planNameAvailableError = new FieldError("plan", "planName",
							alreadyExist);
				else
					planNameAvailableError = new FieldError("plan", "planName",
							alphaNumeric);
				result.addError(planNameAvailableError);

			}
		}
		return "plan/plantable";

	}
	
	@RequestMapping(value = "/delete/{planId}", method = RequestMethod.GET)
	public String deletePlan(ModelMap model,
			@PathVariable("planId") Integer planId) {
		planservice.deletePlan(planId);
		return "redirect:/admin/plans";
	}

	@RequestMapping(value = "/getPlans")
	public String viewPlansAndPrices(ModelMap model) {
		model.addAttribute("plans", planservice.getAllPlans());
		return "plan/plantable";
	}

	@RequestMapping(value = "/updatePlans")
	public String updatePlans(ModelMap model) {
		model.addAttribute("plans", planservice.getAllPlans());
		return "plan/planupadate";
	}
	
	@RequestMapping(value="/select/assign/{businessId}",method=RequestMethod.GET)
    public String selectBusinessPlan(ModelMap model,@PathVariable("businessId")Long businessId)    
    {
		/*model.addAttribute("PlanEntity",context.getBean("PlanEntity",PlanEntity.class));*/
		BusinessDetailsEntity business=businessDetailsService.getBusinessDetails(businessId);
		model.addAttribute("business",business);
		BusinessPlanEntity businessPlan=new BusinessPlanEntity();
		businessPlan.setBusiness(business);
		model.addAttribute("businessPlan",businessPlan);
		model.addAttribute("plans", planservice.getAllPlans());
		
		return "plan/assign";
    }
	
	@RequestMapping(value="/assignPlan",method=RequestMethod.POST)
	public String assignBusinessPlan(ModelMap model,@ModelAttribute("businessPlan")BusinessPlanEntity businessPlan,BindingResult result){
		
		System.out.println(" Plan B "+businessPlan.getBusiness().getBusinessId());
        boolean flag=businessPlanService.assignBusinessPlan(businessPlan);
        System.out.println("assign Plan"+flag);
		return "plan/assign";
	}
	
}
