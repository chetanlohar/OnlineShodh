package com.onlineshodh.support.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlineshodh.entity.FreeListingBusinessEntity;

@Component
public class FLBusinessValidator implements Validator {


	@Value("${mandatory}")
	String mandatory;
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		
		return FreeListingBusinessEntity.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		FreeListingBusinessEntity entity=(FreeListingBusinessEntity)target;
		if(entity.getSubCategory().getCategory().getCategoryId()==0){
			errors.rejectValue("subCategory.category.categoryId", "11",mandatory);
		}
		if(entity.getSubCategory().getSubCategoryId()==0){
			errors.rejectValue("subCategory.subCategoryId", "11",mandatory);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "businessName", "11", mandatory); 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personName", "11", mandatory); 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "11", mandatory); 
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "website", "11", mandatory); */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subCategory.category.categoryId", "11", mandatory); 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subCategory.subCategoryId", "11", mandatory); 
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "keywords", "11", mandatory);*/ 
		
		
	}

}
