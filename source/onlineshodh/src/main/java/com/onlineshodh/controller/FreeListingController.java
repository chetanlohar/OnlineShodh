package com.onlineshodh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.FreeListingBusinessEntity;
import com.onlineshodh.entity.SubCategoryEntity;
import com.onlineshodh.service.CategoryService;
import com.onlineshodh.service.FreeListingService;
import com.onlineshodh.service.SubCategoryService;

@Controller
@RequestMapping(value="/freelisting")
public class FreeListingController {

	@Autowired
	WebApplicationContext context;
	
	@Autowired
	SubCategoryService subCategoryService;

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	FreeListingService freeListingService;
	
	@RequestMapping(value={"/",""})
	public String freeListing(ModelMap model)
	{
		FreeListingBusinessEntity flEntity = context.getBean("freeListingBusinessEntity",FreeListingBusinessEntity.class);
		model.addAttribute("flDetails", flEntity);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "fl_details_new";
	}
	
	@RequestMapping(value={"/view/categories","/view/categories/"},method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<SubCategoryEntity> listCategories(@RequestParam("categoryId") Long categoryId)
	{
		return subCategoryService.listSubCategoriesByCategoryId(categoryId.intValue());
	}
	
	@RequestMapping(value={"/business/save",""},method=RequestMethod.POST)
	public String saveFreeListingBusinessDetails(@ModelAttribute("flDetails") FreeListingBusinessEntity flDetails)	
	{
		System.out.println(flDetails);
		freeListingService.saveFreeListingBusinessDetails(flDetails);
		return "fl_details_new";
	}
	
	
}
