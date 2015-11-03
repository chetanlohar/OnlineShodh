package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.onlineshodh.entity.AddressEntity;
import com.onlineshodh.entity.BusinessAddressEntity;
import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.BusinessGeneralInfoEntity;
import com.onlineshodh.entity.BusinessPhoneEntity;
import com.onlineshodh.entity.BusinessSearchEntity;
import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.entity.SubCategoryEntity;
import com.onlineshodh.service.AddressService;
import com.onlineshodh.service.BusinessAddressService;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.BusinessGeneralInfoService;
import com.onlineshodh.service.BusinessPhoneService;
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
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	BusinessPhoneService businessPhoneService;
	
	@Autowired
	BusinessGeneralInfoService businessGeneralInfoService;
	
	@RequestMapping(value = { "/", "" })
	public String manageBusinessDetails(ModelMap model) {
		model.addAttribute("businessDetails", context.getBean(
				"businessDetailsEntity", BusinessDetailsEntity.class));
		model.addAttribute("SearchBusiness", context.getBean(
				"businessSearchEntity", BusinessSearchEntity.class));
		/*return "business/BusinessManagement";*/
		return "business/addbusiness";
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
		List<BusinessDetailsEntity> l = businessService.getBusinessDetailsByUserDetailsId(userDetailsId);
		model.addAttribute("businessDetails",l);
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
		model.addAttribute("businessPhones", businessPhoneService.getBusinessPhoneDetailByBusinessId(businessId));
		model.addAttribute("businessGeneralInfo", businessGeneralInfoService.getBusinessGeneralInfoByBusinessId(businessId));
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
	
	@RequestMapping("{businessId}/update/address")
	public String showBusinessAddress(@PathVariable("businessId") Long businessId,ModelMap model)
	{
		model.addAttribute("countries", countryService.getAllCountries());
		BusinessAddressEntity businessAddress=businessAddressService.getBusinessAddressByBusinessId(businessId);
		if(businessAddress==null)
		{
			model.addAttribute("businessAddress", context.getBean("addressEntity",AddressEntity.class));
			model.addAttribute("states", stateService.getAllStates());
			model.addAttribute("cities", cityService.getAllCities());
			model.addAttribute("towns", townService.getAllTowns());
		}
		else
		{
			model.addAttribute("states", stateService.getAllStates(businessAddress.getAddress().getCity().getState().getCountry().getCountryId()));
			model.addAttribute("cities", cityService.getAllCities(businessAddress.getAddress().getCity().getState().getStateId()));
			model.addAttribute("towns", townService.getAllTowns(businessAddress.getAddress().getCity().getCityId()));
			model.addAttribute("businessAddress", businessAddress.getAddress());
		}
		
		model.addAttribute("businessId", businessId);
		return "business/busiaddressupdate";
	}
	
	@RequestMapping("{businessId}/save/address")
	public String saveBusinessAddress(@PathVariable("businessId") Long businessId,@ModelAttribute("businessAddress") AddressEntity address,ModelMap model)
	{
		BusinessDetailsEntity business = businessService.getBusinessDetails(businessId);
		if(address.getAddressId()!=null)
			addressService.updateAddress(address);
		else
		{
			addressService.saveAddress(address);
			AddressEntity address1 = addressService.getAddress(address.getAddressId());
			BusinessAddressEntity businessAddress = context.getBean("businessAddressEntity",BusinessAddressEntity.class);
			businessAddress.setBusiness(business);
			businessAddress.setAddress(address1);
			businessAddress.setAddressType("Head Office");
			businessAddressService.saveBusinessAddress(businessAddress);
		}
		return "redirect:/admin/business/"+business.getUserDetails().getUserDetailsId()+"/update/"+businessId;
	}
	
	@RequestMapping(value="/{businessId}/phone/save",method=RequestMethod.POST,produces="application/json")
	public @ResponseBody List<BusinessPhoneEntity> saveBusinessPhoneDetails(@PathVariable("businessId") Long businessId,@RequestParam("businessPhone") Long businessPhone)
	{
		BusinessDetailsEntity business = businessService.getBusinessDetails(businessId);
		BusinessPhoneEntity businesPhoneEntity = context.getBean("businessPhoneEntity",BusinessPhoneEntity.class);
		businesPhoneEntity.setPhone(businessPhone.toString());
		businesPhoneEntity.setBusiness(business);
		businessPhoneService.saveBusinessPhoneDetails(businesPhoneEntity);
		List<BusinessPhoneEntity> l = businessPhoneService.getBusinessPhoneDetailByBusinessId(businessId);
		for(BusinessPhoneEntity b:l)
			System.out.println(b.getPhone());
		return l;
	}
	
	@RequestMapping(value="/{businessId}/feature/save",method=RequestMethod.POST,produces="application/json")
	public @ResponseBody List<BusinessGeneralInfoEntity> saveBusinessGeneralInfo(@PathVariable("businessId") Long businessId,@RequestParam("generalInfo") String generalInfo)
	{
		BusinessDetailsEntity business = businessService.getBusinessDetails(businessId);
		BusinessGeneralInfoEntity entity = context.getBean("businessGeneralInfoEntity",BusinessGeneralInfoEntity.class);
		entity.setGeneralInfoName(generalInfo);
		entity.setBusiness(business);
		businessGeneralInfoService.saveBusinessGeneralInfo(entity);
		List<BusinessGeneralInfoEntity> l = businessGeneralInfoService.getBusinessGeneralInfoByBusinessId(businessId);
		for(BusinessGeneralInfoEntity b:l)
			System.out.println(b.getGeneralInfoName());
		return l;
	}
	/*
	@RequestMapping(value="/{businessId}/features/save",method=RequestMethod.POST,produces="application/json")
	public @ResponseBody List<BusinessGeneralInfoEntity> saveBusinessGeneralInfo(@PathVariable("businessId") Long businessId,@RequestParam("generalInfo") String generalInfo)
	{
		BusinessDetailsEntity business = businessService.getBusinessDetails(businessId);
		BusinessGeneralInfoEntity entity = context.getBean("businessGeneralInfoEntity",BusinessGeneralInfoEntity.class);
		entity.setGeneralInfoName(generalInfo);
		entity.setBusiness(business);
		businessGeneralInfoService.saveBusinessGeneralInfo(entity);
		List<BusinessGeneralInfoEntity> l = businessGeneralInfoService.getBusinessGeneralInfoByBusinessId(businessId);
		for(BusinessGeneralInfoEntity b:l)
			System.out.println(b.getGeneralInfoName());
		return l;
	}*/
	
	@RequestMapping(value = "/searchBusiness", method = RequestMethod.GET)
	public @ResponseBody List<String> serachBusinesData(@RequestParam("term") String keyword) {
		List<String> list=new ArrayList<String>();
		List<BusinessDetailsEntity> clientListByBusinessName;
		list.clear();
		clientListByBusinessName=businessService.getBusinessDetailsByBusinessName(keyword);
		System.out.println("Size OF BusinessName List"+clientListByBusinessName.size());
		for(BusinessDetailsEntity bussiness:clientListByBusinessName){
			System.out.println(" List value"+bussiness.getBusinessName());
			list.add(bussiness.getBusinessName());
		}
		return list; 
		
	}
	
	@RequestMapping(value="/getBusiness",method=RequestMethod.POST)
	public @ResponseBody List<BusinessDetailsEntity> getBusinessData(@RequestParam("keyword")String keyword){
		List<BusinessDetailsEntity> clientListByBusinessName;
		clientListByBusinessName=businessService.findBusinessDetailsByBusinessName(keyword);
		System.out.println("After Search List Size In Table"+clientListByBusinessName);
		return clientListByBusinessName; 
	}
	
	
	
	
	
}
