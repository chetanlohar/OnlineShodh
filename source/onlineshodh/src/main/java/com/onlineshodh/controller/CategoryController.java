package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.mockito.internal.stubbing.answers.ThrowsException;
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

import com.onlineshodh.entity.BannerEntity;
import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.entity.PlanEntity;
import com.onlineshodh.service.CategoryService;

@Controller
@RequestMapping(value = "/admin/categories")
public class CategoryController {

	private static final Logger logger = Logger
			.getLogger(CategoryController.class);

	@Autowired
	public WebApplicationContext context;

	@Autowired
	public CategoryService categoryService;
	
	@Value("${onlyAlphabets}")
	String onlyAlphabets;
	
	@Value("${alreadyExist}")
	String alreadyExist;
	
	@Value("${mandatory}")
	String mandatory;

	@RequestMapping(value = { "/", "" })
	public String showManageCategory(ModelMap model) {
		//model.addAttribute("category",context.getBean("categoryEntity", CategoryEntity.class));
         model.addAttribute("category",new CategoryEntity());  		
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		return "category/categorymanage";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String redirectToSaveCategory(ModelMap model){
		return "redirect:/admin/categories";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCategory(ModelMap model,
			@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute("category") CategoryEntity category,
			BindingResult result) throws IOException {
		boolean flag = false;
		logger.info(file.isEmpty());
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				logger.info(error.getDefaultMessage());
			}
		} 
		if(file.isEmpty() && category.getCategoryLogo()==null)
		{
			FieldError categoryNotSelected = new FieldError("category", "categoryLogo", mandatory);
			result.addError(categoryNotSelected);
			flag = true;
		}if(flag)
			return "category/categorymanage";
		else {
			if (!file.isEmpty()) {
				byte[] categoryLogo = file.getBytes();
				category.setCategoryLogo(categoryLogo);
			}
			String categoryName = category.getCategoryName().toUpperCase();
			category.setCategoryName(categoryName);
			String categoryDesc = category.getCategoryDesc().toUpperCase();
			category.setCategoryDesc(categoryDesc);
			if (category.getPopularity() == null){
				category.setPopularity(0);
			}
			
			try {
				categoryService.saveCategory(category);
				return "redirect:/admin/categories/";
			} catch (DataIntegrityViolationException e) {
				FieldError countryNameAvailableError;
				if (e.getMostSpecificCause().getMessage().contains("unique")) {
					countryNameAvailableError = new FieldError("category","categoryName", alreadyExist);
					logger.info(alreadyExist);
				} else {
					countryNameAvailableError = new FieldError("category","categoryName",onlyAlphabets);
					logger.info(onlyAlphabets);
				}
				result.addError(countryNameAvailableError);
			} catch (Exception e) {
				logger.debug("Exception Occured!", new Exception(e));
			}
		}
		return "category/categorymanage";
	}

	@RequestMapping(value = "/edit/{categoryId}", method = RequestMethod.GET)
	public String editCategory(ModelMap model,
			@PathVariable("categoryId") Integer categoryId) {
		model.addAttribute("category",
				categoryService.getCategoryById(categoryId));
		return "category/categoryupdate";
	}

	@RequestMapping(value = "/delete/{categoryId}", method = RequestMethod.GET)
	public String deleteCategory(ModelMap model,
			@PathVariable("categoryId") Integer categoryId) {
		try{
		categoryService.deleteCategory(categoryId);
		}catch (Exception e) {
			System.out.println("Exception Caught");
		}
		return "redirect:/admin/categories";
	}

	@RequestMapping("/load/logo/{categoryId}")
	public String downloadPicture(
			@PathVariable("categoryId") Integer categoryId,
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
	}
	
	
	@RequestMapping(value = "/exception")
	public String HandleFileSizeExceedException(ModelMap model,
			@ModelAttribute("category") CategoryEntity category, BindingResult result) {
		FieldError FileSizeExceedException;
		model.addAttribute("categories", categoryService.getAllCategories());
		FileSizeExceedException = new FieldError("category", "categoryLogo",
				"Please Select Image Less than 300 KB");
		
		
		result.addError(FileSizeExceedException);
		return "category/categorymanage";

	}
	
	
	/*@RequestMapping(value = "/exception")
	public String redirectAfterException() {
		return "redirect:/admin/categories";
	}
	*/
	
	/*@RequestMapping(value="/exception/{excetiontype}")
	public String HandleException(ModelMap model,@PathVariable("excetiontype")String exception,@ModelAttribute("category") CategoryEntity category, BindingResult result)
	{
		System.out.println(" In category Controoleer Exception :"+exception);
		FieldError categoryNameAvailableError;
		if(exception.equalsIgnoreCase("unique")){
			System.out.println(" In category Controoleer Exception :"+exception);
			categoryNameAvailableError = new FieldError("category","categoryName", alreadyExist);
			logger.info(alreadyExist);
			
		
		}else{
			System.out.println(" In category Controoleer Exception :"+exception);
			categoryNameAvailableError = new FieldError("category","categoryName",onlyAlphabets);
			logger.info(onlyAlphabets);
			}
		result.addError(categoryNameAvailableError);
		return "category/categorymanage";
	
	}
	@RequestMapping(value={"/exception/Integer","/exception/unique"})
	public String redirectAfterException()
	{
		return "redirect:/admin/categories";
	}
	*/
		
}
