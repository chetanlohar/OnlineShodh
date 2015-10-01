package com.onlineshodh.support.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.onlineshodh.entity.UserEntity;

@Component
public class UserEntityValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println();
		UserEntity user = (UserEntity)target;
		if(user.getUserName()==null || user.getUserName()=="")
			errors.rejectValue("userName", "11", "*UserName is Mandatory");
	}
}
