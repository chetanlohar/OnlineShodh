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
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@Value("${mandatory}")
	String mandatory;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String showManageSubCategories(ModelMap model)
	{
		List<SubCategoryEntity> subcategories=subCategoryService.getAllSubCategories();
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("subcategories", subcategories);
		model.addAttribute("categories", categories);
		model.addAttribute("subcategory",context.getBean("subCategoryEntity", SubCategoryEntity.class));
		return "category/subcatmanage";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String saveCategoryGET(ModelMap model)
	{
		return "redirect:/admin/subcategories";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCategory(ModelMap model,	@RequestParam("operationType") String operationType,@RequestParam("file") MultipartFile file,@Valid @ModelAttribute("subcategory") SubCategoryEntity subCategory,BindingResult result) throws IOException {
		
		boolean flag = false;
		
		model.addAttribute("subcategories", subCategoryService.getAllSubCategories());
		model.addAttribute("categories", categoryService.getAllCategories());
		
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				logger.info(error.getDefaultMessage());
			}
			flag = true;
		}
		if(file.isEmpty() && subCategory.getSubCategoryLogo()==null)
		{
			FieldError categoryNotSelected = new FieldError("subCategory", "subCategoryLogo", mandatory);
			result.addError(categoryNotSelected);
			flag = true;
		}
		if(subCategory.getCategory().getCategoryId()==0)
		{
			FieldError categoryNotSelected = new FieldError("subCategory", "category.categoryId", mandatory);
			result.addError(categoryNotSelected);
			flag = true;
		}
		if(flag)
			return "category/subcatmanage";
		else {
			if (!file.isEmpty()) {
				logger.info("file is not empty...");
				byte[] subCategoryLogo = file.getBytes();
				subCategory.setSubCategoryLogo(subCategoryLogo);
			}
			String subCategoryName = subCategory.getSubCategoryName().toUpperCase();
			subCategory.setSubCategoryName(subCategoryName);
			String subCategoryDesc = subCategory.getSubCategoryDesc().toUpperCase();
			subCategory.setSubCategoryDesc(subCategoryDesc);
			if (subCategory.getPopularity() == null)
				subCategory.setPopularity(0);
			try {
				subCategoryService.saveSubCategory(subCategory);
				return "redirect:/admin/subcategories";
			} catch (DataIntegrityViolationException e) {
				FieldError countryNameAvailableError;
				System.out.println(e.getMostSpecificCause().getMessage());
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
		}
		if(operationType.equalsIgnoreCase("save"))
			return "category/subcatmanage";
		else
			return "category/Subcategoryupdate";
	}

	@RequestMapping(value = "/edit/{subCategoryId}", method = RequestMethod.GET)
	public String editSubCategory(ModelMap model,@PathVariable("subCategoryId") Integer subCategoryId) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("subcategory",subCategoryService.getSubCategoryById(subCategoryId));
		return "category/Subcategoryupdate";
	}

	@RequestMapping(value = "/delete/{subCategoryId}", method = RequestMethod.GET)
	public String deleteSubCategory(ModelMap model,
			@PathVariable("subCategoryId") Integer subCategoryId) {
		subCategoryService.deleteSubCategory(subCategoryId);
		return "redirect:/admin/subcategories";
	}

	@RequestMapping("/load/logo/{subCategoryId}")
	public String downloadPicture(@PathVariable("subCategoryId") Integer subCategoryId,HttpServletResponse response) {
		SubCategoryEntity subCategory = subCategoryService.getSubCategoryById(subCategoryId);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\""
					+ subCategory.getSubCategoryName() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType("image/gif");
			ByteArrayInputStream bis = new ByteArrayInputStream(
					subCategory.getSubCategoryLogo());
			IOUtils.copy(bis, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
			logger.info("File Not Found for subCategoryId: "+subCategoryId);
		}
		return null;
	}
	
	@RequestMapping(value={"/view/categories","/view/categories/"},method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<SubCategoryEntity> listCategories(@RequestParam("categoryId") Long categoryId)
	{
		return subCategoryService.listSubCategoriesByCategoryId(categoryId.intValue());
	}
	
	
	@RequestMapping(value = "/exception")
	public String HandleFileSizeExceedException(ModelMap model,
			@ModelAttribute("subcategory") SubCategoryEntity subCategory, BindingResult result) {
		FieldError FileSizeExceedException;
		List<SubCategoryEntity> subcategories=subCategoryService.getAllSubCategories();
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("subcategories", subcategories);
		model.addAttribute("categories", categories);
		FileSizeExceedException = new FieldError("subcategory", "subCategoryLogo",
				"Less than 300KB");
		
		
		result.addError(FileSizeExceedException);
		return "category/subcatmanage";

	}
	
}
