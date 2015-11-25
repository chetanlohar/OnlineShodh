package com.onlineshodh.controller;

import java.util.List;
import java.util.Map;

import javax.mail.Flags.Flag;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.onlineshodh.support.validator.FLBusinessValidator;
import com.onlineshodh.support.validator.FlBusinessAddressValidator;

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

	FLBusinessValidator businessValidator;
	FlBusinessAddressValidator addressValidator;

	@Autowired
	public FreeListingController(FLBusinessValidator businessValidator,
			FlBusinessAddressValidator addressValidator) {
		super();
		this.businessValidator = businessValidator;
		this.addressValidator = addressValidator;
	}

	private static final Logger logger = Logger
			.getLogger(FreeListingController.class);

	@RequestMapping(value = { "/", "" })
	public String freeListing(ModelMap model) {
		FreeListingBusinessEntity flEntity = context.getBean(
				"freeListingBusinessEntity", FreeListingBusinessEntity.class);
		model.addAttribute("flDetails", flEntity);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "free listing/fl_details_new";
	}
	
	@RequestMapping(value = {"/flsucess" })
	public String sucessOnFreeListing(ModelMap model) {
		return "free listing/FreeListingSucess";
	}

	@RequestMapping(value = { "/view/categories", "/view/categories/" }, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<SubCategoryEntity> listCategories(
			@RequestParam("categoryId") Long categoryId) {
		return subCategoryService.listSubCategoriesByCategoryId(categoryId
				.intValue());
	}

	@RequestMapping(value = { "/business/save", "" }, method = RequestMethod.GET)
	public String redirectToFlBusiness() {
		return "redirect:/freelisting/";
	}

	@RequestMapping(value = { "/business/save", "" }, method = RequestMethod.POST)
	public String saveFreeListingBusinessDetails(
			@Valid @ModelAttribute("flDetails") FreeListingBusinessEntity flDetails,
			ModelMap model, BindingResult result) {
		boolean flag = false;
		System.out.println(flDetails);
		businessValidator.validate(flDetails, result);

		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				logger.info(error.getDefaultMessage());
			}
			flag = true;
		}
		if (flag) {
			model.addAttribute("categories", categoryService.getAllCategories());
			return "free listing/fl_details_new";
		} else {
			Long freelistingId = freeListingService
					.saveFreeListingBusinessDetails(flDetails);
			System.out.println("freelistingId " + freelistingId);

			return "redirect:/freelisting/address/show/" + freelistingId;
		}
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
		System.out.println(" freelisting address bean before save "
				+ freeListingAddressEntity);
		model.addAttribute("FreeListing_Address", freeListingAddressEntity);
		return "free listing/fl_address_details_new";
	}

	@RequestMapping(value = "/address/save", method = RequestMethod.POST)
	public String saveFLAddress(
			ModelMap model,
			@Valid@ModelAttribute("FreeListing_Address") FreeListingAddressEntity address,
			BindingResult result) {
		boolean flag = false;

		addressValidator.validate(address, result);
		if(result.hasErrors()){
			List<FieldError> errors=result.getFieldErrors();
			System.out.println(" Error Count :"+result.getErrorCount());
			for(FieldError error:errors){
				logger.info(error.getDefaultMessage());
			}
			
			flag=true;
		}
		
		Long businessId = address.getBusinessEntity()
				.getFreelistingbusinessdetailsId();
		System.out.println(" freelisting address bean " + address);
         
		
		
		if (flag) {
			model.addAttribute("cities", cityService.getAllCities());
			return "free listing/fl_address_details_new";
		} else {

			//try {
				freeListingAddressService.saveFreeListingAddress(address);
			//} catch (Exception e) {
				//logger.info(e.getMessage());
				//return "redirect:/freelisting/address/show/" + businessId;
			//}
			return "redirect:/freelisting/" + businessId + "/phone";
		}
	}

	@RequestMapping(value = "/address/save", method = RequestMethod.GET)
	public String redirectToAddressShow(){
		
		return "redirect:/freelisting";
		
	}
	
	
	
	@RequestMapping(value = "/{businessId}/phone", method = RequestMethod.GET)
	public String phoneDetails(ModelMap model,
			@PathVariable("businessId") Long businessId) {
		model.addAttribute("freeListingBusiness",
				freeListingService.getFeelistingEntityById(businessId));
		model.addAttribute("flphones", freeListingPhoneService
				.getAllFLBusinessPhonesByBusinessId(businessId));
		model.addAttribute("flfeatures", freeListingBusinessFeatureService
				.getAllFeturesByBusinessID(businessId));

		return "free listing/fl_phone_feature_detail";
	}

	@RequestMapping(value = "{freelistingbusinessdetailsId}/savephone", method = RequestMethod.POST)
	public @ResponseBody List<FreeListingPhoneEntity> savePhone(
			ModelMap model,
			@RequestParam("phonetype") String phonetype,
			@RequestParam("contact") Long contact,
			@PathVariable("freelistingbusinessdetailsId") Long freelistingbusinessdetailsId) {
		try {
			System.out.println(" hi am here " + phonetype + " dfsdf" + contact
					+ "freelistingbusinessdetailsId "
					+ freelistingbusinessdetailsId);
			FreeListingPhoneEntity phoneEntity = context.getBean(
					"freeListingPhoneEntity", FreeListingPhoneEntity.class);
			phoneEntity.setPhone(contact.toString());
			phoneEntity.setPhonetype(phonetype);
			phoneEntity.setFreeListingBusinessEntity(freeListingService
					.getFeelistingEntityById(freelistingbusinessdetailsId));
			System.out.println(" Phone Bean " + phoneEntity.toString());
			freeListingPhoneService.saveFreeListingPhoneDetails(phoneEntity);
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		List<FreeListingPhoneEntity> phoneList = freeListingPhoneService
				.getAllFLBusinessPhonesByBusinessId(freelistingbusinessdetailsId);
		for (FreeListingPhoneEntity entity : phoneList) {
			System.out.println(" Business Phones: " + entity.getPhone());
		}

		return phoneList;
	}

	@RequestMapping(value = "{freelistingbusinessdetailsId}/savefeature", method = RequestMethod.POST)
	public @ResponseBody List<FreeListingBusinessFeatureEntity> saveFeature(
			ModelMap model,
			@RequestParam("feature") String feature,
			@PathVariable("freelistingbusinessdetailsId") Long freelistingbusinessdetailsId) {
		boolean flag = false;

		if (feature.equalsIgnoreCase("") || feature.equalsIgnoreCase(null)) {
			logger.info("Feature is Empty");
			flag = true;

		}
		if (flag) {
			logger.info("Feature is Empty");
		} else {
			System.out.println(" hi am here " + feature
					+ " freelistingbusinessdetailsId "
					+ freelistingbusinessdetailsId);
			FreeListingBusinessFeatureEntity businessFeatureEntity = context
					.getBean("freeListingBusinessFeatureEntity",
							FreeListingBusinessFeatureEntity.class);
			businessFeatureEntity.setFreelistingBusinessFeature(feature.trim()
					.toUpperCase());
			businessFeatureEntity.setBusiness(freeListingService
					.getFeelistingEntityById(freelistingbusinessdetailsId));
			System.out.println(" Feature Entity "
					+ businessFeatureEntity.toString());
			freeListingBusinessFeatureService
					.saveFreeListingBusinessFeature(businessFeatureEntity);
		}
		List<FreeListingBusinessFeatureEntity> fetureList = freeListingBusinessFeatureService
				.getAllFeturesByBusinessID(freelistingbusinessdetailsId);
		for (FreeListingBusinessFeatureEntity entity : fetureList) {
			System.out.println(" Feature List "
					+ entity.getFreelistingBusinessFeature());
		}

		return fetureList;
	}

	@RequestMapping(value = "/updatephone/{freelistingbusinessdetailsId}/{phoneId}", method = RequestMethod.POST)
	public @ResponseBody List<FreeListingPhoneEntity> updatePhone(
			ModelMap model,
			@RequestParam("phonetype") String phonetype,
			@RequestParam("contact") Long contact,
			@PathVariable("freelistingbusinessdetailsId") Long freelistingbusinessdetailsId,
			@PathVariable("phoneId") Long phoneId) {

		FreeListingPhoneEntity phoneEntity = freeListingPhoneService
				.getPhoneById(phoneId);
		phoneEntity.setPhone(contact.toString());
		phoneEntity.setPhonetype(phonetype);
		System.out.println(" Phone Bean " + phoneEntity.toString());
		freeListingPhoneService.updateFreeListingPhoneDetails(phoneEntity);
		List<FreeListingPhoneEntity> phoneList = freeListingPhoneService
				.getAllFLBusinessPhonesByBusinessId(freelistingbusinessdetailsId);
		for (FreeListingPhoneEntity entity : phoneList) {
			System.out.println(" Business Phones: " + entity.getPhone());
		}
		return phoneList;
	}

	@RequestMapping(value = "{flBusinessId}/{phoneId}/deletePhone", method = RequestMethod.GET)
	public String deletePhoneDetails(ModelMap model,
			@PathVariable("phoneId") Long phoneId,
			@PathVariable("flBusinessId") Long flBusinessId) {
		System.out.println(" PhoneId " + phoneId);
		try {
			freeListingPhoneService.deletePhone(phoneId);
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("flfeatures", freeListingBusinessFeatureService
					.getAllFeturesByBusinessID(flBusinessId));
			model.addAttribute("flphones", freeListingPhoneService
					.getAllFLBusinessPhonesByBusinessId(flBusinessId));
		}
		model.addAttribute("flphones", freeListingPhoneService
				.getAllFLBusinessPhonesByBusinessId(flBusinessId));
		/* return "free listing/fl_phone_feature_detail"; */
		return "redirect:/freelisting/" + flBusinessId + "/phone";
	}

	@RequestMapping(value = "/updateFeature/{freelistingbusinessdetailsId}/{featureId}", method = RequestMethod.POST)
	public @ResponseBody List<FreeListingBusinessFeatureEntity> updateFeature(
			ModelMap model,
			@RequestParam("feature") String feature,
			@PathVariable("freelistingbusinessdetailsId") Long freelistingbusinessdetailsId,
			@PathVariable("featureId") Long featureId) {
		System.out.println("In Update" + feature
				+ " freelistingbusinessdetailsId "
				+ freelistingbusinessdetailsId + " feature id " + featureId);
		FreeListingBusinessFeatureEntity businessFeatureEntity = freeListingBusinessFeatureService
				.getFeature(featureId);
		businessFeatureEntity.setFreelistingBusinessFeature(feature.trim()
				.toUpperCase());
		System.out.println(" Feature Entity "
				+ businessFeatureEntity.toString());
		freeListingBusinessFeatureService
				.updateFLBFeature(businessFeatureEntity);
		List<FreeListingBusinessFeatureEntity> fetureList = freeListingBusinessFeatureService
				.getAllFeturesByBusinessID(freelistingbusinessdetailsId);
		for (FreeListingBusinessFeatureEntity entity : fetureList) {
			System.out.println(" Feature List "
					+ entity.getFreelistingBusinessFeature());
		}
		return fetureList;
	}

	@RequestMapping(value = "{flBusinessId}/{featureId}/deleteFeature", method = RequestMethod.GET)
	public String deleteFeatureDetails(ModelMap model,
			@PathVariable("featureId") Long featureId,
			@PathVariable("flBusinessId") Long flBusinessId) {
		System.out.println(" featureId " + featureId);
		try {
			freeListingBusinessFeatureService.deleteFLBFeature(featureId);
			model.addAttribute("flfeatures", freeListingBusinessFeatureService
					.getAllFeturesByBusinessID(flBusinessId));
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("flfeatures", freeListingBusinessFeatureService
					.getAllFeturesByBusinessID(flBusinessId));
			model.addAttribute("flphones", freeListingPhoneService
					.getAllFLBusinessPhonesByBusinessId(flBusinessId));
		}
		/* return "free listing/fl_phone_feature_detail"; */
		return "redirect:/freelisting/" + flBusinessId + "/phone";
	}

}
