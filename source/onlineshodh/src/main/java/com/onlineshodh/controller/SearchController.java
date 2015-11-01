package com.onlineshodh.controller;

import java.util.ArrayList;
import java.util.List;










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.BusinessSearchEntity;
import com.onlineshodh.entity.UserDetailsEntity;
import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.UserDetailsService;
import com.onlineshodh.service.UserService;
import com.onlineshodh.support.validator.BusinessSearchEntityValidator;

@Controller
@RequestMapping(value = "/admin/search")
public class SearchController {

	@Autowired
	BusinessDetailsService businessDetailsService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	UserService userService;

	@Value("${onlyAlphabets}")
	String onlyAlphabets;

	@Autowired
	WebApplicationContext context; 
	

	
}
