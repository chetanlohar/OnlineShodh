package com.onlineshodh.utility;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.onlineshodh.entity.CountryEntity;

public class WebAppInitializer implements WebApplicationInitializer {

	@Autowired
	WebApplicationContext context;
	
	WebApplicationContext springContext;
	
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
	}

}
