package com.onlineshodh.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxFiles.FileMetadata;
import com.dropbox.core.v2.DbxFiles.Metadata;
import com.dropbox.core.v2.DbxUsers.FullAccount;
import com.dropbox.core.v2.DbxUsers.GetCurrentAccountException;
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
import com.onlineshodh.support.validator.FLBusinessValidator;
import com.onlineshodh.support.validator.FlBusinessAddressValidator;

@Controller
@RequestMapping(value = { "/freelisting", "/admin/Freelisting" })
public class FreeListingController {

	static final String ACCESS_TOKEN = "CLYM2AeSMvAAAAAAAAAABtAeGrRghvyirnOVGPWXkG1bs-A_dN6byd4Yzy-fPcoN";

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
		flEntity.setRegdate(new Date());
		model.addAttribute("flDetails", flEntity);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "free listing/fl_details_new";
	}

	@RequestMapping(value = { "/flsucess" })
	public String sucessOnFreeListing(ModelMap model) {
		return "free listing/FreeListingSucess";
	}

	@RequestMapping(value = { "/view/categories", "/view/categories/" }, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<Integer, String> listCategories(
			@RequestParam("categoryId") Long categoryId) {
		System.out.println(" category Id " + categoryId);
		
		List<SubCategoryEntity> subCategories =  subCategoryService.listSubCategoriesByCategoryId(categoryId.intValue());
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		for(SubCategoryEntity subcat:subCategories)
			map.put(subcat.getSubCategoryId(), subcat.getSubCategoryName());
		return map;
	}

	@RequestMapping(value = { "/business/save", "" }, method = RequestMethod.GET)
	public String redirectToFlBusiness() {
		return "redirect:/freelisting/";
	}

	@RequestMapping(value = { "/business/save", "" }, method = RequestMethod.POST)
	public String saveFreeListingBusinessDetails(
			@Valid @ModelAttribute("flDetails") FreeListingBusinessEntity flDetails,
			ModelMap model, @RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult result) throws IOException,
			MaxUploadSizeExceededException {
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
		if (file.isEmpty() && flDetails.getLogo().length == 0) {
			FieldError logoNotSelected = new FieldError("flDetails", "logo",
					"mandatory");
			result.addError(logoNotSelected);
			flag = true;
		}
		if (flag) {
			model.addAttribute("categories", categoryService.getAllCategories());
			return "free listing/fl_details_new";
		} else {
			if (!file.isEmpty()) {
				flDetails.setLogo(null);
			}
			Long freelistingId = freeListingService
					.saveFreeListingBusinessDetails(flDetails);
			System.out.println("freelistingId " + freelistingId);
			int startindex = file.getOriginalFilename().lastIndexOf(".");
			String extension = file.getOriginalFilename().substring(startindex);
			String imageName = freelistingId + "-logo" + extension;
			try {

				String filePath = uploadToDropBox(imageName,
						file.getInputStream());
				filePath = filePath.replace("www.dropbox.com",
						"dl.dropboxusercontent.com");
				System.out.println("filePath: " + filePath);
				flDetails.setFreelistingbusinessdetailsId(freelistingId);
				flDetails.setImagename(imageName);
				flDetails.setImagepath(filePath);
			} catch (DbxException e) {
				e.printStackTrace();
			}
			freeListingService.updateFreeListingBusinessDetails(flDetails);

			return "redirect:/freelisting/address/show/" + freelistingId;
		}
	}

	public String uploadToDropBox(String fileName, InputStream in)
			throws GetCurrentAccountException, DbxException, IOException {
		DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial",
				"en_US");
		DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
		FullAccount account = client.users.getCurrentAccount();
		System.out.println(account.name.displayName);
		// Get files and folder metadata from Dropbox root directory
		ArrayList<Metadata> entries = client.files.listFolder("").entries;
		for (Metadata metadata : entries) {
			System.out.println(metadata.pathLower);
		}
		FileMetadata metadata = client.files.uploadBuilder(
				"/freelisting/business_logo/" + fileName).run(in);
		System.out.println("Hi:" + metadata.toStringMultiline());
		DbxClientV1 dbxClient = new DbxClientV1(config, ACCESS_TOKEN);
		String sharedLink = dbxClient.createShareableUrl(metadata.pathLower);
		System.out.println("sharedLink: " + sharedLink);
		return sharedLink;
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
			@Valid @ModelAttribute("FreeListing_Address") FreeListingAddressEntity address,
			BindingResult result) {
		boolean flag = false;

		addressValidator.validate(address, result);
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			System.out.println(" Error Count :" + result.getErrorCount());
			for (FieldError error : errors) {
				logger.info(error.getDefaultMessage());
			}

			flag = true;
		}

		Long businessId = address.getBusinessEntity()
				.getFreelistingbusinessdetailsId();
		System.out.println(" freelisting address bean " + address);

		if (flag) {
			model.addAttribute("cities", cityService.getAllCities());
			return "free listing/fl_address_details_new";
		} else {

			// try {
			freeListingAddressService.saveFreeListingAddress(address);
			// } catch (Exception e) {
			// logger.info(e.getMessage());
			// return "redirect:/freelisting/address/show/" + businessId;
			// }
			return "redirect:/freelisting/" + businessId + "/phone";
		}
	}

	@RequestMapping(value = "/address/save", method = RequestMethod.GET)
	public String redirectToAddressShow() {

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

		boolean flag = false;
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
			if (e.getMessage().contains("ConstraintViolationException")) {
				flag = true;
			}
		}
		List<FreeListingPhoneEntity> phoneList = new ArrayList<FreeListingPhoneEntity>();

		phoneList = freeListingPhoneService
				.getAllFLBusinessPhonesByBusinessId(freelistingbusinessdetailsId);

		phoneList = freeListingPhoneService
				.getAllFLBusinessPhonesByBusinessId(freelistingbusinessdetailsId);
		for (FreeListingPhoneEntity entity : phoneList) {
			System.out.println(" Business Phones: " + entity.getPhone());
		}
		if (flag == true) {
			System.out.println(" Duplicate ");
			phoneList.add(new FreeListingPhoneEntity());
		} else {
			phoneList = freeListingPhoneService
					.getAllFLBusinessPhonesByBusinessId(freelistingbusinessdetailsId);
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
			@PathVariable("phoneId") Long phoneId, HttpServletRequest request,
			HttpServletResponse response) {

		boolean flag = false;
		try {
			FreeListingPhoneEntity phoneEntity = freeListingPhoneService
					.getPhoneById(phoneId);
			phoneEntity.setPhone(contact.toString());
			phoneEntity.setPhonetype(phonetype);
			System.out.println(" Phone Bean " + phoneEntity.toString());
			freeListingPhoneService.updateFreeListingPhoneDetails(phoneEntity);
		} catch (NullPointerException e) {
			logger.info(e.getLocalizedMessage());
		} catch (DataIntegrityViolationException exception) {
			flag = true;
		}
		List<FreeListingPhoneEntity> phoneList = new ArrayList<FreeListingPhoneEntity>();

		phoneList = freeListingPhoneService
				.getAllFLBusinessPhonesByBusinessId(freelistingbusinessdetailsId);

		phoneList = freeListingPhoneService
				.getAllFLBusinessPhonesByBusinessId(freelistingbusinessdetailsId);
		for (FreeListingPhoneEntity entity : phoneList) {
			System.out.println(" Business Phones: " + entity.getPhone());
		}
		if (flag == true) {
			phoneList.add(new FreeListingPhoneEntity());
		} else {
			phoneList = freeListingPhoneService
					.getAllFLBusinessPhonesByBusinessId(freelistingbusinessdetailsId);
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
		boolean flag = false;

		if (feature.equalsIgnoreCase("") || feature.equalsIgnoreCase(null)) {
			logger.info("Feature is Empty");
			flag = true;

		}
		if (flag) {
			logger.info("Feature is Empty");
		} else {
			System.out
					.println("In Update" + feature
							+ " freelistingbusinessdetailsId "
							+ freelistingbusinessdetailsId + " feature id "
							+ featureId);
			FreeListingBusinessFeatureEntity businessFeatureEntity = freeListingBusinessFeatureService
					.getFeature(featureId);
			businessFeatureEntity.setFreelistingBusinessFeature(feature.trim()
					.toUpperCase());
			System.out.println(" Feature Entity "
					+ businessFeatureEntity.toString());
			freeListingBusinessFeatureService
					.updateFLBFeature(businessFeatureEntity);
		}
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

	@RequestMapping(value = "/listfl", method = RequestMethod.GET)
	public String getAllFreeListingBusiness(ModelMap model) {

		model.addAttribute("FlBusiness",
				freeListingService.getALlFreeListingBusiness());
		return "free listing/ListFLBusiness";
	}
	
	@RequestMapping(value="/verify/{flBusinessId}",method=RequestMethod.GET)
	public String verifyFLBusiness(ModelMap model,@PathVariable("flBusinessId")Long flBusinessId){
		System.out.println("flBusinessId "+flBusinessId);
		FreeListingBusinessEntity fLEntity=freeListingService.getFeelistingEntityById(flBusinessId);
		List<FreeListingPhoneEntity> phonelist=freeListingPhoneService.getAllFLBusinessPhonesByBusinessId(flBusinessId);
	    List<FreeListingAddressEntity> addresslist=freeListingAddressService.getBusinessFeatureDetailByBusinessId(flBusinessId); 
	    model.addAttribute("addressList",addresslist);
	    model.addAttribute("phoneList",phonelist);
		model.addAttribute("fLBEntity",fLEntity);
		return "free listing/verifyFl";
	} 
	
	

}
