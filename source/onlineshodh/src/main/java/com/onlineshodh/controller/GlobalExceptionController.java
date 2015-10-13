package com.onlineshodh.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;



@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public String handleDatatIntegrityViolExcep(DataIntegrityViolationException ex){
		String exceptionType=null;
		if(ex.getMostSpecificCause().getMessage().contains("unique")){
			exceptionType="unique";
		}
		else{
			exceptionType="Integer";
		}
		return "redirect:/admin/countries/exception/"+exceptionType;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "this is Exception.class");
		return model;

	}
	
}