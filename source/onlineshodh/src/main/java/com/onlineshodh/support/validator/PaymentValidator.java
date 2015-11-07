package com.onlineshodh.support.validator;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlineshodh.supportclass.PaymentStatus;

@Component
public class PaymentValidator implements Validator{

	@Value("${mandatory}")
	String mandatory;
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
			return PaymentStatus.class.isAssignableFrom(clazz) ;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"payment.status", "11", mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"payment.remark", "11", mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"payment.payeeName", "11", mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"check.bankName", "11", mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"check.checkNo", "11", mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"payment.transactionid", "11", mandatory);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"check.checkDate", "11", mandatory);
		
		
	}

}
