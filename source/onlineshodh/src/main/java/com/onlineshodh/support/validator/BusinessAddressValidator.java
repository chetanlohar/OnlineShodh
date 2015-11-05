package com.onlineshodh.support.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlineshodh.entity.AddressEntity;

@Component
public class BusinessAddressValidator implements Validator {


	@Value("${mandatory}")
	String mandatory;
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		
		/*return BusinessAddressEntity.class.isAssignableFrom(clazz);*/
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		AddressEntity Address=(AddressEntity)target;
		try{
		 if (Address.getCity().getState().getCountry().getCountryId() == 0 ) {
				
				errors.rejectValue("city.state.country.countryId", "11", mandatory);
				
			}
			 if (Address.getCity().getState().getStateId() == 0 ) {
				
				errors.rejectValue("city.state.stateId", "11", mandatory);
			}
			  if (Address.getTown().getTownId() == 0 ) {
				errors.rejectValue("town.townId", "11", mandatory);
			}
			 if (Address.getCity().getCityId() == 0 ) {
				errors.rejectValue("city.cityId", "11", mandatory);
			}
		} catch(NullPointerException e ){
			System.out.println(" caught in Business Address validator");
		 }
			 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address","11",mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street","11",mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pincode","11",mandatory);
		
	}

}
