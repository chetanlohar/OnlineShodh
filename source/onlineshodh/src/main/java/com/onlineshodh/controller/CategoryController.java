package com.onlineshodh.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.service.CategoryService;

@Controller
@RequestMapping(value="/categories")
public class CategoryController {


	private static final Logger logger = Logger.getLogger(CategoryController.class);
	
	@Autowired
	public WebApplicationContext context;
	
	@Autowired
	public CategoryService categoryService;
	
	@RequestMapping(value={"/",""})
	public String showManageCategory(ModelMap model)
	{
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("category", context.getBean("categoryEntity", CategoryEntity.class));
		return "category/manageCategories";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCategory(ModelMap model,@RequestParam("file") MultipartFile file,@Valid @ModelAttribute("category") CategoryEntity category, BindingResult result) throws IOException
	{
		System.out.println(category);
		if(result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError error:errors)
			{
				logger.info(error.getDefaultMessage());
			}
		}
		else
		{
			byte [] categoryLogo = file.getBytes();
			category.setCategoryLogo(categoryLogo);
			String categoryName = category.getCategoryName().toUpperCase();
			category.setCategoryName(categoryName);
			String categoryDesc = category.getCategoryDesc().toUpperCase();
			category.setCategoryDesc(categoryDesc);
			if(category.getPopularity()==null)
				category.setPopularity(0);
			try
			{
				categoryService.saveCategory(category);
			}
			catch(DataIntegrityViolationException e)
			{
				FieldError countryNameAvailableError;
				if(e.getMostSpecificCause().getMessage().contains("unique"))
				{
					countryNameAvailableError = new FieldError("category","categoryName","*CategoryName is already Exists!");
					logger.info("*CategoryName is already Exists!",new Exception("*CategoryName is already Exists!"));
				}
				else
				{
					countryNameAvailableError = new FieldError("category","categoryName","*Only Alphabets allowed for Country Name!");
					logger.info("*Only Alphabets allowed for Country Name!",new Exception("*Only Alphabets allowed for Country Name!"));
				}
				result.addError(countryNameAvailableError);
			}
			catch(Exception e)
			{
				logger.debug("Exception Occured!",new Exception(e));
			}
		}
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		return "category/manageCategories";
	}
	
}
