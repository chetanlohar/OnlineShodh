package com.onlineshodh.support.validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlineshodh.entity.FreeListingAddressEntity;

@Component
public class FlBusinessAddressValidator implements Validator {

	private static final Logger logger=Logger.getLogger(FlBusinessAddressValidator.class); 
	
	@Value("${mandatory}")
	String mandatory;
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		
		return FreeListingAddressEntity.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FreeListingAddressEntity entity=(FreeListingAddressEntity)target;
		try{
		if(entity.getCity().getCityId()==0||entity.getCity()==null){
			errors.rejectValue("city.cityId", "11", mandatory);
		}
		if(entity.getTown().getTownId()==0||entity.getTown()==null){
			errors.rejectValue("town.townId", "11", mandatory);
		}
		}catch(NullPointerException e){
			logger.info(e.getStackTrace());
			logger.info(e.getMessage());
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fl_Address", "11", mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fl_Street", "11", mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pincode", "11", mandatory);
		
		
	}

}
