package com.onlineshodh.controller;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshodh.entity.StateEntity;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public String handleDatatIntegrityViolExcep(
			DataIntegrityViolationException ex) {
		String exceptionType = null;

		if (ex.getMostSpecificCause().getMessage().contains("unique")) {
			exceptionType = "unique";
		} else {
			exceptionType = "Integer";
		}
		if (ex.getMostSpecificCause().getMessage()
				.contains("UNQ_country_countryName")
				|| ex.getMostSpecificCause().getMessage()
						.contains("chk_country_countryname")) {
			return "redirect:/admin/countries/exception/" + exceptionType;
		}
		if (ex.getMostSpecificCause().getMessage()
				.contains("unq_state_statename")
				|| ex.getMostSpecificCause().getMessage()
						.contains("chk_state_statename")) {
			return "redirect:/admin/states/exception/" + exceptionType;
		}
		if (ex.getMostSpecificCause().getMessage()
				.contains("unq_city_cityname")
				|| ex.getMostSpecificCause().getMessage()
						.contains("chk_city_cityname")) {
			return "redirect:/admin/cities/exception/" + exceptionType;
		}
		if (ex.getMostSpecificCause().getMessage()
				.contains("unq_town_townname")
				|| ex.getMostSpecificCause().getMessage()
						.contains("chk_town_townname")) {
			return "redirect:/admin/towns/exception/" + exceptionType;
		}
		if (ex.getMostSpecificCause().getMessage()
				.contains("unq_Plan_details_planname")
				|| ex.getMostSpecificCause().getMessage()
						.contains("chk_Plan_details_planname")) {
			return "redirect:/admin/plans/exception/" + exceptionType;
		}
		if (ex.getMostSpecificCause().getMessage()
				.contains("UNQ_category_categoryname")
				|| ex.getMostSpecificCause().getMessage()
						.contains("chk_category_categoryname")) {
			return "redirect:/admin/categories/exception/" + exceptionType;
		}
		if (ex.getMostSpecificCause().getMessage()
				.contains("UNQ_category_categoryname")
				|| ex.getMostSpecificCause().getMessage()
						.contains("chk_category_categoryname")) {
			return "redirect:/admin/categories/exception/" + exceptionType;
		}

		return "redirect:/admin/";
	}

	@ExceptionHandler(TransactionSystemException.class)
	public String HandleBeanException(TransactionSystemException ex) {
		String exceptionType = null;
		return "redirect:/admin/states/exception/" + exceptionType;

	}

	/*
	 * @ExceptionHandler(Exception.class) public ModelAndView
	 * handleAllException(Exception ex) {
	 * 
	 * ModelAndView model = new ModelAndView("error/generic_error");
	 * model.addObject("errMsg", "this is Exception.class"); return model;
	 * 
	 * }
	 */

}