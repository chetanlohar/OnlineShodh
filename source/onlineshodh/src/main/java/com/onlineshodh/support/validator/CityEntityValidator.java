package com.onlineshodh.support.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlineshodh.entity.CityEntity;


@Component
public class CityEntityValidator implements Validator {
	
	@Value("${mandatory}")
	String mandatory;

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		return CityEntity.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		CityEntity city = (CityEntity) target;
		
		
		
		if(city.getState().getCountry().getCountryId()==0){
			errors.rejectValue("state.country.countryId", "11", mandatory);
		}if(city.getState().getStateId()==0){
			errors.rejectValue("state.stateId", "11", mandatory);
			
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cityName", "11",
				mandatory);
		
	}

}
