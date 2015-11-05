package com.onlineshodh.support.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlineshodh.entity.BannerEntity;

@Component
public class BannerEntityValidator implements Validator {

	@Value("${mandatory}")
	String mandatory;

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		return BannerEntity.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		BannerEntity banner = (BannerEntity) target;
		if (banner.getCategory().getCategoryId() == 0)
			errors.rejectValue("category.categoryId", "11", mandatory);

		if (banner.getCity().getState().getCountry().getCountryId() == 0) {
			errors.rejectValue("city.state.country.countryId", "11", mandatory);
		}
		if (banner.getCity().getState().getStateId() == 0) {
			errors.rejectValue("city.state.stateId", "11", mandatory);
		}
		if (banner.getCity().getCityId() == 0) {
			errors.rejectValue("city.cityId", "11", mandatory);
		}/*if(banner.getBannerLogo().length==0){
			System.out.println("Banner Image Not Selected");
			errors.rejectValue("bannerLogo", "11", mandatory);
		}*/
		/*if(banner.getBannerLogo().length>100000){
			System.out.println("Banner Image Size Greater");
			errors.rejectValue("bannerLogo", "11", "Please Select Image Less than 100000 Bytes");
		}
		
*/		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bannerName", "11",
				mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "urlLink", "11",
				mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "11",
				mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expiryDate", "11",
				mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "regDate", "11",
				mandatory);
	}
}
