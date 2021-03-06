package com.onlineshodh.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
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
import com.onlineshodh.support.validator.BusinessPlanValidator;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping("admin/plans")
public class PlanController {

	private static final Logger logger=Logger.getLogger(PlanController.class);

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
	
	
	
	
	BusinessPlanValidator businessPlanValidator;
	
	@Autowired
	public PlanController(BusinessPlanValidator businessPlanValidator) {
		super();
		this.businessPlanValidator = businessPlanValidator;
	}

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
			for (FieldError error : errors){
				System.out.println(error.getDefaultMessage());
				logger.info(error.getDefaultMessage());
			}
		} else {
			try {
				planservice.savePlan(Plan);
				return "redirect:/admin/plans";
			} catch (DataIntegrityViolationException exception) {
				FieldError planNameAvailableError;
				System.out.println(exception.getMostSpecificCause()
						.getMessage());
				if (exception.getMostSpecificCause().getMessage()
						.contains("unique")){
					planNameAvailableError = new FieldError("plan", "planName",
							alreadyExist);
					logger.debug(planNameAvailableError.getDefaultMessage());
				}
				else
					planNameAvailableError = new FieldError("plan", "planName",
							alphaNumeric);{
				result.addError(planNameAvailableError);
				logger.debug(planNameAvailableError.getDefaultMessage());
				
							}
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
		
		PlanEntity planEntity = planservice.getPlan(planId);
		model.addAttribute("plan", planEntity);
		return "plan/edit_plan";
		/*return "plan/updatePlan";*/
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String redirectPlanAfterUpdate(ModelMap model)		
	{
		model.addAttribute("plans", planservice.getAllPlans());
		return "plan/planupadate";
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
						.contains("unique")){
					planNameAvailableError = new FieldError("plan", "planName",
							alreadyExist);
					logger.debug(planNameAvailableError);
				}
				else
					planNameAvailableError = new FieldError("plan", "planName",
							alphaNumeric);{
				result.addError(planNameAvailableError);
				logger.debug(planNameAvailableError);
			}

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
	
	@RequestMapping(value="/assignPlan/{BusineesId}",method=RequestMethod.GET)
	public String redirectToAssignedPlan(ModelMap model,@PathVariable("BusineesId")Long busineesId){
	
		model.addAttribute("plans", planservice.getAllPlans());
		model.addAttribute("business", businessDetailsService.getBusinessDetails(busineesId));
		model.addAttribute("businessPlan", context.getBean("businessPlanEntity",BusinessPlanEntity.class));
		return "plan/assign";
	}
	
	
	@RequestMapping(value="/assignPlan/{BusineesId}",method=RequestMethod.POST)
	public String assignBusinessPlan(ModelMap model,@PathVariable("BusineesId")Long busineesId,@ModelAttribute("businessPlan")BusinessPlanEntity businessPlan,BindingResult result){
		
		boolean flag1=false;
		boolean flag=false;
	 businessPlanValidator.validate(businessPlan, result);
	 
		if(result.hasErrors()){
		
			System.out.println("Error Count :"+result.getErrorCount());
			List<FieldError> errors=result.getFieldErrors();
			for (FieldError error:errors) {
				logger.info(error.getDefaultMessage());
			}
			flag1=true;
		}
		
		
		if(businessPlan.getPlan().getPlanId()==0)
		{
			FieldError error=new FieldError("businessPlan", "plan.planId", "Please Select Plan"); 
		     result.addError(error);
		     flag1=true;
		}
		System.out.println("ststus"+businessPlan.getStatus());
		if(businessPlan.getStatus().equalsIgnoreCase("0"))
		{
			FieldError error1=new FieldError("businessPlan", "status", "Please Select Status"); 
		     result.addError(error1);
		     flag1=true;
		}/*if(businessPlan.getStartdate()==null){
			FieldError error=new FieldError("businessPlan", "startdate", "Please Select Start Date"); 
		     result.addError(error);
		     flag1=true;
		}if(businessPlan.getEnddate()==null){
			FieldError error=new FieldError("businessPlan", "enddate", "Please Select end Date"); 
		     result.addError(error);
		     flag1=true;
		}*/
		
		if(flag1){
			model.addAttribute("business", businessDetailsService.getBusinessDetails(busineesId));
			model.addAttribute("plans", planservice.getAllPlans());
			model.addAttribute("businessPlan", businessPlan);
			return "plan/assign"; 	
		}
		
		try{
			System.out.println(businessPlan);
          flag=businessPlanService.assignBusinessPlan(businessPlan);
        System.out.println("assign Plan"+flag);
        model.addAttribute("business", businessDetailsService.getBusinessDetails(busineesId));
		model.addAttribute("plans", planservice.getAllPlans());
		}catch(DataIntegrityViolationException exception){
			FieldError planNameAlreadyAssignError;
			FieldError	planNameAlreadyError;
		     
			if (exception.getMostSpecificCause().getMessage()
					.contains("unique")){
				planNameAlreadyAssignError = new FieldError("businessPlan", "plan.planId",
						alreadyExist);
				logger.debug(planNameAlreadyAssignError);
			result.addError(planNameAlreadyAssignError);
			planNameAlreadyError = new FieldError("businessPlan", "plan.planId",
					"Please Upgrade Plan"); 	
			result.addError(planNameAlreadyError);
			logger.debug(planNameAlreadyAssignError);
			model.addAttribute("business", businessDetailsService.getBusinessDetails(busineesId));
			model.addAttribute("plans", planservice.getAllPlans());
			model.addAttribute("businessPlan", businessPlan);

			}
			return "plan/assign"; 	
		}
		catch(Exception exception){
			System.out.println(" Error Ocurs "+exception.getMessage());
			FieldError error=new FieldError("businessPlan", "enddate", "Please Enter Valid Input"); 
		     result.addError(error);
				logger.debug(error.getDefaultMessage());

		     return "plan/assign";
		     
		}
		if(flag){
		model.addAttribute("msg",flag);
		}else{
			//model.addAttribute("msg","Plan Not Assigned...");
		}
		return "plan/assign";
	}
	
	@RequestMapping(value="/assignPlan",method=RequestMethod.GET)
	public String redirectToAssignPlan(){
		return "plan/Assignplan";
	}
	
	@RequestMapping(value="/planAssign",method=RequestMethod.GET)
	public String assignPlan(){
		return "plan/Assignplan";
	}
	
	
}
