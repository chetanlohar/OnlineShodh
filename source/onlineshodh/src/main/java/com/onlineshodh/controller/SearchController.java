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
	BusinessSearchEntityValidator validator;
	
	@Autowired
	public SearchController(BusinessSearchEntityValidator validator) {
		super();
		this.validator = validator;
	}

	@RequestMapping(value = "/business")
	public String serachClient() {
		return "business/addNewBusiness";
	}

	
	@RequestMapping(value = "business/client", method = RequestMethod.POST)
	public @ResponseBody List<UserDetailsEntity> serachClient(
			@RequestParam("keyword") String keyword,
			@RequestParam("searchBy") Integer searchBy) {
		//validator.validate(target, errors);
		
		System.out.println("searchBy: " + searchBy);
		System.out.println("keyword: " + keyword);

		
		List<UserDetailsEntity> clientList = new ArrayList<UserDetailsEntity>();
		List<BusinessDetailsEntity> clientListByBusinessName;
		
		if(searchBy==1){
			clientList.clear();
			clientList.add(userDetailsService.getUserDetails(Integer.parseInt(keyword)));
			return clientList;
		}
		else if(searchBy==2)
		{
			List<UserDetailsEntity> clientListByName; 
			clientListByName=userDetailsService.getUserDeatilsByName(keyword);
			return clientListByName; 
		}
		else if(searchBy==3)
		{
			UserEntity user=userService.getUserByName(keyword);
			clientList.clear();
			clientList.add(userDetailsService.getUserDetailsByUserId(user.getUserId()));
			return clientList; 
		}
		else{
			
			clientList.clear();
			clientListByBusinessName=businessDetailsService.getBusinessDetailsByBusinessName(keyword);
			for(BusinessDetailsEntity bussiness:clientListByBusinessName){
				UserDetailsEntity user=new UserDetailsEntity();
				user.setUserDetailsId(bussiness.getUserDetails().getUserDetailsId());
				clientList.add(userDetailsService.getUserDetails(user.getUserDetailsId()));
			}
			System.out.println("clientList "+clientList.size());
			return clientList; 
		}
		
	}

	@ExceptionHandler(java.lang.NumberFormatException.class)
	public String handleNumberFormatException(java.lang.NumberFormatException ex) {
		System.out.println("NumberFormatException 1");
		return "redirect:/admin/search/exception";
	}

	@RequestMapping(value = "/exception",method=RequestMethod.GET)
	public String HandleException(ModelMap model,@ModelAttribute("SearchBusiness")BusinessSearchEntity businessSearch,BindingResult result) {
		
		FieldError searchKeywordError=new FieldError("businessSearch", "searchText"," Please Enter Valid Keywords.." );
		result.addError(searchKeywordError);
		model.addAttribute("SearchBusiness", context.getBean("businessSearchEntity",BusinessSearchEntity.class));
		System.out.println("model");
		 return "business/BusinessManagement";
		
	}

}
