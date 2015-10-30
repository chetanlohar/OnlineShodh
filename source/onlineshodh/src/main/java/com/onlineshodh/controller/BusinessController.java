package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.onlineshodh.entity.AddressEntity;
import com.onlineshodh.entity.BusinessAddressEntity;
import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.BusinessSearchEntity;
import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.entity.SubCategoryEntity;
import com.onlineshodh.service.BusinessAddressService;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.CategoryService;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.CountryService;
import com.onlineshodh.service.StateService;
import com.onlineshodh.service.SubCategoryService;
import com.onlineshodh.service.TownService;
import com.onlineshodh.service.UserDetailsService;

@Controller
@RequestMapping("admin/business")
public class BusinessController {

	@Autowired
	WebApplicationContext context;

	@Autowired
	BusinessDetailsService businessService;

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	BusinessAddressService businessAddressService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	StateService stateService;

	@Autowired
	CityService cityService;
	
	@Autowired
	TownService townService;

	@RequestMapping(value = { "/", "" })
	public String manageBusinessDetails(ModelMap model) {
		model.addAttribute("businessDetails", context.getBean(
				"businessDetailsEntity", BusinessDetailsEntity.class));
		model.addAttribute("SearchBusiness", context.getBean(
				"businessSearchEntity", BusinessSearchEntity.class));
		return "business/BusinessManagement";
	}

	@RequestMapping(value = "/new/save")
	public String saveBusinessDetails(@RequestParam("file") MultipartFile file,@Valid @ModelAttribute BusinessDetailsEntity businessDetails,	BindingResult result) throws IOException {
		
		System.out.println();
		if(!file.isEmpty())
			businessDetails.setBusinessLogo(file.getBytes());
		
		businessService.saveBusinessDetails(businessDetails);
		
		/*return "business/businessadd";*/
		return "redirect:/admin/business/"+businessDetails.getUserDetails().getUserDetailsId()+"/update/"+businessDetails.getBusinessId();
	}

	
	@RequestMapping("/load/logo/{businessId}")
	public String downloadPicture(
			@PathVariable("businessId") Long businessId,
			HttpServletResponse response) {
		
		BusinessDetailsEntity business = businessService.getBusinessDetails(businessId);
		
		try {
			response.setHeader("Content-Disposition", "inline;filename=\""
					+ business.getBusinessName() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType("image/gif");
			ByteArrayInputStream bis = new ByteArrayInputStream(
					business.getBusinessLogo());
			IOUtils.copy(bis, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			// logger.info("File Not Found");
		}
		return null;
	}
	
	@RequestMapping("/{userDetailsId}")
	public String businessDetails(@PathVariable("userDetailsId") Long userDetailsId, ModelMap model)
	{
		model.addAttribute("userdetails",userDetailsService.getUserDetails(userDetailsId.intValue()));
		model.addAttribute("businessDetails",businessService.getBusinessDetailsByUserDetailsId(userDetailsId));
		return "business/BusinessDetails";
	}
	
	@RequestMapping("/{userDetailsId}/update/{businessId}")
	public String updateBusinessDetails(@PathVariable("userDetailsId") Long userDetailsId,@PathVariable("businessId") Long businessId,ModelMap model)
	{
		BusinessAddressEntity businessAddress = businessAddressService.getBusinessAddressByBusinessId(businessId);
		
		System.out.println("businessAddress: "+businessAddress);
		BusinessDetailsEntity business = businessService.getBusinessDetails(businessId);

		model.addAttribute("business", business);
		model.addAttribute("businessDetails",businessAddress);
		return "business/businessdetailupdate";
	}
	
	@RequestMapping("/view/client/{userDetailsId}")
	public String viewClientDetails(@PathVariable("userDetailsId") Long userDetailsId, ModelMap model)
	{
		model.addAttribute("userdetails", userDetailsService.getUserDetails(userDetailsId.intValue()));
		return "business/BusinessDetails";
	}
	
	@RequestMapping("/new/add/{userDetailsId}")
	public String addNewBusiness(@PathVariable("userDetailsId") Long userDetailsId,ModelMap model)
	{
		System.out.println("userDetailsId: "+userDetailsId);
		model.addAttribute("userDetailsId", userDetailsId);
		return "business/newbusiness";
		
	}
	
	@RequestMapping("/update/info/{userDetailsId}")
	public String addBusinessInfo(@PathVariable("userDetailsId") Long userDetailsId, ModelMap model)
	{
		model.addAttribute("businessdetail", context.getBean("businessDetailsEntity",BusinessDetailsEntity.class));
		List<SubCategoryEntity> subcategories=subCategoryService.getAllSubCategories();
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("subcategories", subcategories);
		model.addAttribute("categories", categories);
		model.addAttribute("userDetailsId", userDetailsId);
		return "business/businessadd";
	}
	
	@RequestMapping("/update/businessinfo/{businessId}")
	public String updateBusinessInfo(@PathVariable("businessId") Long businessId, ModelMap model)
	{
		model.addAttribute("businessdetail", businessService.getBusinessDetails(businessId));
		List<SubCategoryEntity> subcategories=subCategoryService.getAllSubCategories();
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("subcategories", subcategories);
		model.addAttribute("categories", categories);
		return "business/businessadd";
	}
	
	@RequestMapping("/update/address/{businessId}")
	public String showBusinessAddress(@PathVariable("businessId") Long businessId,ModelMap model)
	{
		model.addAttribute("countries", countryService.getAllCountries());
		model.addAttribute("states", stateService.getAllStates());
		model.addAttribute("cities", cityService.getAllCities());
		model.addAttribute("towns", townService.getAllTowns());
		BusinessAddressEntity businessAddress=businessAddressService.getBusinessAddressByBusinessId(businessId);
		System.out.println("businessAddress1: "+businessAddress);
		
		if(businessAddress==null)
			model.addAttribute("businessAddress", context.getBean("addressEntity",AddressEntity.class));
		else
			model.addAttribute("businessAddress", businessAddress.getAddress());
		
		return "business/busiaddressupdate";
	}
	
	public String updateBusinessAddress()
	{
		return "";
	}
}
