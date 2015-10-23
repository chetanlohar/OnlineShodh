package com.onlineshodh.support.validator;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlineshodh.entity.BusinessSearchEntity;

@Component
public class BusinessSearchEntityValidator implements Validator{
	@Value("${mandatory}")
	String mandatory;
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		
		return BusinessSearchEntity.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BusinessSearchEntity businessSearchEntity=(BusinessSearchEntity)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "searchText", "11",mandatory);
		
	}

	
}
