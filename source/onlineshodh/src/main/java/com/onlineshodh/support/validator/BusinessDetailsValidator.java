package com.onlineshodh.support.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlineshodh.entity.BusinessDetailsEntity;

@Component
public class BusinessDetailsValidator implements Validator{

	@Value("${mandatory}")
	String mandatory;
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		
		return BusinessDetailsEntity.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		BusinessDetailsEntity businessDetailsEntity=(BusinessDetailsEntity)target;
		
		/*if(businessDetailsEntity.getSubCategory().getCategory().getCategoryId()==0){
			System.out.println(""); 
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subCategory.category.categoryId", "11",mandatory);
		}
		if(businessDetailsEntity.getSubCategory().getSubCategoryId()==0){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subCategory.subCategoryId", "11",mandatory);
		}*/
		
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "businessName", "11",mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personName", "11",mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "website", "11",mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "businessDesc", "11",mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "11",mandatory);*/
		
	}

	
}
