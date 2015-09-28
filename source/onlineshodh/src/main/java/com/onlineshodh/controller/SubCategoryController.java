package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.entity.SubCategoryEntity;
import com.onlineshodh.service.CategoryService;
import com.onlineshodh.service.SubCategoryService;

@Controller
@RequestMapping(value="/admin/subcategories")
public class SubCategoryController {
	
	private static final Logger logger = Logger
			.getLogger(SubCategoryController.class);
	
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	CategoryService categoryService;
	
	@Value("${onlyAlphabets}")
	String onlyAlphabets;
	
	@Value("${alreadyExist}")
	String alreadyExist;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String showManageSubCategories(ModelMap model)
	{
		List<SubCategoryEntity> subcategories=subCategoryService.getAllSubCategories();
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("subcategories", subcategories);
		model.addAttribute("categories", categories);
		model.addAttribute("subcategory",context.getBean("subCategoryEntity", SubCategoryEntity.class));
		return "category/manageSubCategory";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCategory(ModelMap model,	@RequestParam("file") MultipartFile file,@Valid @ModelAttribute("subcategory") SubCategoryEntity subCategory,BindingResult result) throws IOException {
		
		logger.info("file isEmpty: "+file.isEmpty());
		logger.info(subCategory);
		
		model.addAttribute("subcategories", subCategoryService.getAllSubCategories());
		model.addAttribute("categories", categoryService.getAllCategories());
		
		/*if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				logger.info(error.getDefaultMessage());
			}
		} else {
			if (!file.isEmpty()) {
				byte[] sbuCategoryLogo = file.getBytes();
				subCategory.setSubCategoryLogo(sbuCategoryLogo);
			}
			
			String subCategoryName = subCategory.getSubCategoryName().toUpperCase();
			subCategory.setSubCategoryName(subCategoryName);
			String subCategoryDesc = subCategory.getSubCategoryDesc().toUpperCase();
			subCategory.setSubCategoryDesc(subCategoryDesc);
			if (subCategory.getPopularity() == null)
				subCategory.setPopularity(0);
			try {
				categoryService.saveCategory(category);
				return "redirect:/categories/";
			} catch (DataIntegrityViolationException e) {
				FieldError countryNameAvailableError;
				if (e.getMostSpecificCause().getMessage().contains("unique")) {
					countryNameAvailableError = new FieldError("subCategory","subCategoryName", alreadyExist);
					logger.info(alreadyExist);
				} else {
					countryNameAvailableError = new FieldError("subCategory","subCategoryName",onlyAlphabets);
					logger.info(onlyAlphabets);
				}
				result.addError(countryNameAvailableError);
			} catch (Exception e) {
				logger.debug("Exception Occured!", new Exception(e));
			}
		}*/
		return "category/manageSubCategories";
	}

	/*@RequestMapping(value = "/edit/{subCategoryId}", method = RequestMethod.GET)
	public String editCountry(ModelMap model,
			@PathVariable("subCategoryId") Integer subCategoryId) {
		model.addAttribute("category",categoryService.getCategoryById(subCategoryId));
		return "category/updateSubCategory";
	}*/

	/*@RequestMapping(value = "/delete/{subCategoryId}", method = RequestMethod.GET)
	public String deleteCountry(ModelMap model,
			@PathVariable("subCategoryId") Integer subCategoryId) {
		categoryService.deleteCategory(subCategoryId);
		return "redirect:/categories";
	}*/

	/*@RequestMapping("/load/logo/{subCategoryId}")
	public String downloadPicture(
			@PathVariable("subCategoryId") Integer subCategoryId,
			HttpServletResponse response) {
		CategoryEntity category = categoryService.getCategoryById(categoryId);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\""
					+ category.getCategoryName() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType("image/gif");
			ByteArrayInputStream bis = new ByteArrayInputStream(
					category.getCategoryLogo());
			IOUtils.copy(bis, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
			logger.info("File Not Found");
		}
		return null;
	}*/
}
