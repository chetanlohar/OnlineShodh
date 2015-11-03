package com.onlineshodh.support.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlineshodh.entity.BusinessPlanEntity;

@Component 
public class BusinessPlanValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		
		return BusinessPlanEntity.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BusinessPlanEntity businessPlanEntity=(BusinessPlanEntity)target;
		/*if(businessPlanEntity.getStartdate()==null){
			errors.rejectValue("startdate", "11", "Please Select Start Date");
			
		}if(businessPlanEntity.getEnddate()==null){
			errors.rejectValue("enddate", "11", "Please Select End Date");
		}*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "11", "Please Enter Status ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startdate", "11", "Please Select Start Date");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "enddate", "11", "Please Select End Date");
		
		
	}

}
