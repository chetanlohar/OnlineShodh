package com.onlineshodh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.service.BusinessDetailsService;

@Controller
@RequestMapping(value="/admin/search")
public class SearchController {
	
	@Autowired
	BusinessDetailsService businessDetailsService;
	
	@RequestMapping(value="/business")
	public String serachClient()
	{
		return "business/addNewBusiness";
	}
	
	@RequestMapping(value="business/client",method=RequestMethod.POST)
	public @ResponseBody List<BusinessDetailsEntity> serachClient(@RequestParam("keyword") String keyword, @RequestParam("searchBy") Integer searchBy)
	{
		System.out.println("searchBy: "+searchBy);
		System.out.println("keyword: "+keyword);
		
		List<BusinessDetailsEntity> list = new ArrayList<BusinessDetailsEntity>();
		list.add(businessDetailsService.getBusinessDetails(Long.valueOf(keyword)));
		
		
		return list;
		
	}

}
