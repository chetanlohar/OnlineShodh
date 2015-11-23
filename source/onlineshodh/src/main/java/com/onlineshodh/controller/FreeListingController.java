package com.onlineshodh.controller;

import java.util.List;

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

import com.onlineshodh.entity.FreeListingAddressEntity;
import com.onlineshodh.entity.FreeListingBusinessEntity;
import com.onlineshodh.entity.FreeListingBusinessFeatureEntity;
import com.onlineshodh.entity.FreeListingPhoneEntity;
import com.onlineshodh.entity.SubCategoryEntity;
import com.onlineshodh.entity.TownEntity;
import com.onlineshodh.service.CategoryService;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.FreeListingAddressService;
import com.onlineshodh.service.FreeListingBusinessFeatureService;
import com.onlineshodh.service.FreeListingPhoneService;
import com.onlineshodh.service.FreeListingService;
import com.onlineshodh.service.SubCategoryService;
import com.onlineshodh.service.TownService;
import com.onlineshodh.service.impl.FreeListingAddresServiceImpl;

@Controller
@RequestMapping(value = "/freelisting")
public class FreeListingController {

	@Autowired
	WebApplicationContext context;

	@Autowired
	SubCategoryService subCategoryService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	FreeListingService freeListingService;

	@Autowired
	CityService cityService;

	@Autowired
	TownService townService;

	@Autowired
	FreeListingAddressService freeListingAddressService;
	
	@Autowired
	FreeListingPhoneService freeListingPhoneService; 
	
	@Autowired
	FreeListingBusinessFeatureService freeListingBusinessFeatureService;

 	@RequestMapping(value = { "/", "" })
	public String freeListing(ModelMap model) {
		FreeListingBusinessEntity flEntity = context.getBean(
				"freeListingBusinessEntity", FreeListingBusinessEntity.class);
		model.addAttribute("flDetails", flEntity);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "fl_details_new";
	}

	@RequestMapping(value = { "/view/categories", "/view/categories/" }, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<SubCategoryEntity> listCategories(
			@RequestParam("categoryId") Long categoryId) {
		return subCategoryService.listSubCategoriesByCategoryId(categoryId
				.intValue());
	}

	@RequestMapping(value = { "/business/save", "" }, method = RequestMethod.POST)
	public String saveFreeListingBusinessDetails(
			@ModelAttribute("flDetails") FreeListingBusinessEntity flDetails) {
		System.out.println(flDetails);
		Long freelistingId = freeListingService
				.saveFreeListingBusinessDetails(flDetails);
		System.out.println("freelistingId " + freelistingId);
		return "redirect:/freelisting/address/show/" + freelistingId;
	}

	@RequestMapping(value = "/showTowns", method = RequestMethod.POST)
	public @ResponseBody List<TownEntity> showTowns(ModelMap model,
			@RequestParam("cityId") Integer cityId) {
		System.out.println("Town ");
		for (TownEntity town : townService.getAllTowns(cityId)) {
			System.out.println("Town " + town.getTownName());
		}

		return townService.getAllTowns(cityId);
	}

	@RequestMapping(value = "/address/show/{freelistingId}", method = RequestMethod.GET)
	public String manageFLAddress(ModelMap model,
			@PathVariable("freelistingId") Long freelistingId) {
		model.addAttribute("cities", cityService.getAllCities());
		System.out.println("Free Listing Id before set to address bean "
				+ freelistingId);
		FreeListingAddressEntity freeListingAddressEntity = context.getBean(
				"freeListingAddressEntity", FreeListingAddressEntity.class);
		FreeListingBusinessEntity businessEntity = freeListingService
				.getFeelistingEntityById(freelistingId);
		System.out.println(" fl business bean " + businessEntity.toString());
		freeListingAddressEntity.setBusinessEntity(businessEntity);
		System.out.println(" freelisting address bean before save " + freeListingAddressEntity);
		model.addAttribute("FreeListing_Address", freeListingAddressEntity);
		return "fl_address";
	}

	@RequestMapping(value = "/address/save", method = RequestMethod.POST)
	public String saveFLAddress(
			ModelMap model,
			@ModelAttribute("FreeListing_Address") FreeListingAddressEntity address,
			BindingResult result) {
          Long businessId=address.getBusinessEntity().getFreelistingbusinessdetailsId();
		System.out.println(" freelisting address bean " + address);
		
		freeListingAddressService.saveFreeListingAddress(address);
		return "redirect:/freelisting/"+businessId+"/phone";
	}
	@RequestMapping(value="/{businessId}/phone",method=RequestMethod.GET)
	public String phoneDetails(ModelMap model,@PathVariable("businessId")Long businessId){
		model.addAttribute("freeListingBusiness", freeListingService.getFeelistingEntityById(businessId));
		model.addAttribute("flphones",freeListingPhoneService.getAllFLBusinessPhonesByBusinessId(businessId));
		model.addAttribute("flfeatures",freeListingBusinessFeatureService.getAllFeturesByBusinessID(businessId));   

  
		return "fl_phoneDetails";
	}
	@RequestMapping(value="{freelistingbusinessdetailsId}/savephone",method=RequestMethod.POST)
	public @ResponseBody List<FreeListingPhoneEntity> savePhone(ModelMap model,@RequestParam("phonetype")String phonetype,@RequestParam("contact")String contact,@PathVariable("freelistingbusinessdetailsId")Long freelistingbusinessdetailsId){
		//model.addAttribute("freeListingBusiness", freeListingService.getFeelistingEntityById(businessId));
		//return "fl_phoneDetails";
		System.out.println(" hi am here "+phonetype+" dfsdf"+contact+"freelistingbusinessdetailsId "+freelistingbusinessdetailsId);
		FreeListingPhoneEntity phoneEntity=context.getBean("freeListingPhoneEntity", FreeListingPhoneEntity.class);
		phoneEntity.setPhone(contact);
		phoneEntity.setPhonetype(phonetype);
		phoneEntity.setFreeListingBusinessEntity(freeListingService.getFeelistingEntityById(freelistingbusinessdetailsId));
		System.out.println(" Phone Bean "+phoneEntity.toString());
		freeListingPhoneService.saveFreeListingPhoneDetails(phoneEntity);
		List<FreeListingPhoneEntity> phoneList =freeListingPhoneService.getAllFLBusinessPhonesByBusinessId(freelistingbusinessdetailsId);
	   for (FreeListingPhoneEntity entity:phoneList) {
		System.out.println(" Business Phones: "+entity.getPhone());
	} 
		return phoneList;
	}
	
	@RequestMapping(value="{freelistingbusinessdetailsId}/savefeature",method=RequestMethod.POST)
	public @ResponseBody List<FreeListingBusinessFeatureEntity> saveFeature(ModelMap model,@RequestParam("feature")String feature,@PathVariable("freelistingbusinessdetailsId")Long freelistingbusinessdetailsId){
		System.out.println(" hi am here "+feature+" freelistingbusinessdetailsId "+freelistingbusinessdetailsId);
		FreeListingBusinessFeatureEntity businessFeatureEntity=context.getBean("freeListingBusinessFeatureEntity",FreeListingBusinessFeatureEntity.class);
		businessFeatureEntity.setFreelistingBusinessFeature(feature);
		businessFeatureEntity.setBusiness(freeListingService.getFeelistingEntityById(freelistingbusinessdetailsId));
		System.out.println(" Feature Entity "+businessFeatureEntity.toString());
		freeListingBusinessFeatureService.saveFreeListingBusinessFeature(businessFeatureEntity);
		List<FreeListingBusinessFeatureEntity> fetureList=freeListingBusinessFeatureService.getAllFeturesByBusinessID(freelistingbusinessdetailsId);   
	    for(FreeListingBusinessFeatureEntity entity:fetureList){
       System.out.println(" Feature List "+entity.getFreelistingBusinessFeature());	    	
	    }
	    return fetureList;
	}

}
