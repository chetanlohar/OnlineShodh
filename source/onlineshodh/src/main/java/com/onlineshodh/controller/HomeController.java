package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.entity.TownEntity;
import com.onlineshodh.service.CategoryService;
import com.onlineshodh.service.SubCategoryService;
import com.onlineshodh.service.TownService;

@Controller
public class HomeController {
	
	private static final Logger logger=Logger.getLogger(PlanController.class);
	
	@Autowired
	TownService townService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCatService;
	
	List<CategoryEntity> categories;
	Map<Integer,CategoryEntity> categories_map;
	
	@PostConstruct
	public void init()
	{
		categories = categoryService.getAllCategories();
		categories_map = new HashMap<Integer,CategoryEntity>();
		for(CategoryEntity cat: categories)
			categories_map.put(cat.getCategoryId(), cat);
	}
	
	@RequestMapping(value={"/",""})
	public String showHome(HttpServletRequest request,ModelMap model)
	{
		init();
		String iconsPath = request.getServletContext().getInitParameter(
				"category_icons");
		String webapppath = request.getServletContext().getRealPath("/");
		List<String> iconList = new ArrayList<String>();
		File iconDir = new File(webapppath+iconsPath);
		System.out.println("iconDir: "+iconDir);
		
		for (File imageFile : iconDir.listFiles()) {
			iconList.add(imageFile.getName());
		}
		
		model.addAttribute("icons", iconList);
		model.addAttribute("categories", categories);
		
		SearchController.towns = townService.getAllTowns();
		SearchController.strTownsWithCity = new ArrayList<String>();
		for (TownEntity town : SearchController.towns) {
			SearchController.strTownsWithCity.add(town.getCity().getCityName() + " ("
					+ town.getTownName() + ")");
		}
		model.addAttribute("cities", SearchController.strTownsWithCity);
		SearchController.subCats = subCatService.getAllSubCategories();
		return "index";
	}
	
	@RequestMapping("/categories/load/logo/{categoryId}")
	public String downloadPicture(
			@PathVariable("categoryId") Integer categoryId,
			HttpServletResponse response) {
		CategoryEntity category = categories_map.get(categoryId);
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

}
