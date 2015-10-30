package com.onlineshodh.support.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ClientEntityValidator implements Validator   {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
