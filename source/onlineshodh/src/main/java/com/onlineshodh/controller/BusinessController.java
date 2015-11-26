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
import org.springframework.beans.factory.annotation.Value;
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

import com.onlineshodh.entity.AddressEntity;
import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.BusinessEnquiryEntity;
import com.onlineshodh.entity.BusinessGeneralInfoEntity;
import com.onlineshodh.entity.BusinessPhoneEntity;
import com.onlineshodh.entity.BusinessSearchEntity;
import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.entity.SubCategoryEntity;
import com.onlineshodh.service.AddressService;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.BusinessEnquiryService;
import com.onlineshodh.service.BusinessGeneralInfoService;
import com.onlineshodh.service.BusinessPhoneService;
import com.onlineshodh.service.CategoryService;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.CountryService;
import com.onlineshodh.service.StateService;
import com.onlineshodh.service.SubCategoryService;
import com.onlineshodh.service.TownService;
import com.onlineshodh.service.UserDetailsService;
import com.onlineshodh.support.validator.BusinessAddressValidator;
import com.onlineshodh.support.validator.BusinessDetailsValidator;

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
	
	@Autowired
	BusinessEnquiryService businessEnquiryService;

	@Value("${mandatory}")
	String mandatory;

	BusinessDetailsValidator businessDetailsValidator;

	BusinessAddressValidator businessAddressValidator;
	
	

	@Autowired
	public BusinessController(
			BusinessDetailsValidator businessDetailsValidator,
			BusinessAddressValidator businessAddressValidator) {
		super();
		this.businessDetailsValidator = businessDetailsValidator;
		this.businessAddressValidator = businessAddressValidator;
	}

	@RequestMapping(value = { "/", "" })
	public String manageBusinessDetails(ModelMap model) {
		model.addAttribute("businessDetails", context.getBean(
				"businessDetailsEntity", BusinessDetailsEntity.class));
		model.addAttribute("SearchBusiness", context.getBean(
				"businessSearchEntity", BusinessSearchEntity.class));
		/* return "business/BusinessManagement"; */
		return "business/addbusiness";
	}

	@RequestMapping(value = "/new/save", method = RequestMethod.GET)
	public String redirectToSaveBusiness(ModelMap model) {
		model.addAttribute("businessdetail", new BusinessDetailsEntity());
		return "business/businessadd";
	}

	@RequestMapping(value = "/new/save", method = RequestMethod.POST)
	public String saveBusinessDetails(
			@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute("businessdetail") BusinessDetailsEntity businessDetails,
			BindingResult result) throws IOException {

		if (!file.isEmpty())
			businessDetails.setBusinessLogo(file.getBytes());
		boolean flag = false;

		/*
		 * if(file.isEmpty()) { FieldError error=new
		 * FieldError("businessDetails", "businessLogo", "please select Image");
		 * result.addError(error); flag=true; }
		 */

		businessDetailsValidator.validate(businessDetails, result);

		if (result.hasErrors()) {
			System.out.println("Errror Count" + result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println(" Error :" + error.getDefaultMessage());
				flag = true;
			}
		}

		if (businessDetails.getSubCategory().getCategory().getCategoryId() == 0) {

			// ValidationUtils.rejectIfEmptyOrWhitespace(errors,
			// "subCategory.category.categoryId", "11",mandatory);
			FieldError error1 = new FieldError("businessDetails",
					"subCategory.category.categoryId", mandatory);
			flag = true;
			result.addError(error1);
		}
		if (businessDetails.getSubCategory().getSubCategoryId() == 0) {
			// ValidationUtils.rejectIfEmptyOrWhitespace(errors,
			// "subCategory.subCategoryId", "11",mandatory);
			FieldError error2 = new FieldError("businessDetails",
					"subCategory.subCategoryId", mandatory);
			result.addError(error2);
			flag = true;
		}

		if (flag) {
			/* model.addAttribute("businessdetail", ) */
			return "business/businessadd";
		}

		else {
			businessService.saveBusinessDetails(businessDetails);
			return "redirect:/admin/business/"
					+ businessDetails.getUserDetails().getUserDetailsId()
					+ "/update/" + businessDetails.getBusinessId();
		}
		/* return "business/businessadd"; */
		/*
		 * return "redirect:/admin/business/"+businessDetails.getUserDetails().
		 * getUserDetailsId()+"/update/"+businessDetails.getBusinessId();
		 */
	}

	/*
	 * @RequestMapping(value="/new/save",method=RequestMethod.GET) public String
	 * redirectToAddBusiness(){
	 * 
	 * return
	 * "redirect:/admin/business/"+businessDetails.getUserDetails().getUserDetailsId
	 * ()+"/update/"+businessDetails.getBusinessId();
	 * 
	 * }
	 */

	@RequestMapping("/load/logo/{businessId}")
	public String downloadPicture(@PathVariable("businessId") Long businessId,
			HttpServletResponse response) {

		BusinessDetailsEntity business = businessService
				.getBusinessDetails(businessId);

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
	public String businessDetails(
			@PathVariable("userDetailsId") Long userDetailsId, ModelMap model) {
		model.addAttribute("userdetails",
				userDetailsService.getUserDetails(userDetailsId.intValue()));
		List<BusinessDetailsEntity> l = businessService
				.getBusinessDetailsByUserDetailsId(userDetailsId);
		model.addAttribute("businessDetails", l);
		for (BusinessDetailsEntity b : l)
			System.out.println(b.getKeywords());
		return "business/BusinessDetails";
	}

	@RequestMapping("/{userDetailsId}/update/{businessId}")
	public String updateBusinessDetails(
			@PathVariable("userDetailsId") Long userDetailsId,
			@PathVariable("businessId") Long businessId, ModelMap model) {
		BusinessDetailsEntity business = businessService
				.getBusinessDetails(businessId);
		model.addAttribute("business", business);
		model.addAttribute("businessPhones", businessPhoneService
				.getBusinessPhoneDetailByBusinessId(businessId));
		model.addAttribute("businessGeneralInfo", businessGeneralInfoService
				.getBusinessGeneralInfoByBusinessId(businessId));
		return "business/businessdetailupdate";
	}

	@RequestMapping("/view/client/{userDetailsId}")
	public String viewClientDetails(
			@PathVariable("userDetailsId") Long userDetailsId, ModelMap model) {
		model.addAttribute("userdetails",
				userDetailsService.getUserDetails(userDetailsId.intValue()));
		return "business/BusinessDetails";
	}

	@RequestMapping("/new/add/{userDetailsId}")
	public String addNewBusiness(
			@PathVariable("userDetailsId") Long userDetailsId, ModelMap model) {
		System.out.println("userDetailsId: " + userDetailsId);
		model.addAttribute("userDetailsId", userDetailsId);
		return "business/newbusiness";

	}

	@RequestMapping("/update/info/{userDetailsId}")
	public String addBusinessInfo(
			@PathVariable("userDetailsId") Long userDetailsId, ModelMap model) {
		model.addAttribute("businessdetail", context.getBean(
				"businessDetailsEntity", BusinessDetailsEntity.class));
		List<SubCategoryEntity> subcategories = subCategoryService
				.getAllSubCategories();
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("subcategories", subcategories);
		model.addAttribute("categories", categories);
		model.addAttribute("userDetailsId", userDetailsId);
		return "business/businessadd";
	}

	@RequestMapping("/update/businessinfo/{businessId}")
	public String updateBusinessInfo(
			@PathVariable("businessId") Long businessId, ModelMap model) {
		BusinessDetailsEntity businessdetails = businessService.getBusinessDetails(businessId); 
		model.addAttribute("businessdetail",businessdetails);
		List<SubCategoryEntity> subcategories = subCategoryService
				.listSubCategoriesByCategoryId(businessdetails.getSubCategory().getCategory().getCategoryId());
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("subcategories", subcategories);
		model.addAttribute("categories", categories);
		return "business/businessadd";
	}
	

	@RequestMapping(value = "/new/exception")
	public String HandleFileSizeExceedException(ModelMap model,
			@ModelAttribute("businessdetail") BusinessDetailsEntity businessDetails,
			BindingResult result) {
		FieldError FileSizeExceedException;
		FileSizeExceedException = new FieldError("businessdetail",
				"businessLogo",
				"Less than 300 KB");
		model.addAttribute("categories",categoryService.getAllCategories());
		result.addError(FileSizeExceedException);
		return "business/businessadd";

	}
	@RequestMapping("{businessId}/update/address")
	public String showBusinessAddress(
			@PathVariable("businessId") Long businessId, ModelMap model) {
		model.addAttribute("countries", countryService.getAllCountries());
		BusinessDetailsEntity business = businessService
				.getBusinessDetails(businessId);
		if (business.getAddress() == null) {
			model.addAttribute("businessAddress",
					context.getBean("addressEntity", AddressEntity.class));
			model.addAttribute("states", stateService.getAllStates());
			model.addAttribute("cities", cityService.getAllCities());
			model.addAttribute("towns", townService.getAllTowns());
		} else {
			model.addAttribute(
					"states",
					stateService.getAllStates(business.getAddress().getCity()
							.getState().getCountry().getCountryId()));
			model.addAttribute(
					"cities",
					cityService.getAllCities(business.getAddress().getCity()
							.getState().getStateId()));
			model.addAttribute(
					"towns",
					townService.getAllTowns(business.getAddress().getCity()
							.getCityId()));
			model.addAttribute("businessAddress", business.getAddress());
		}

		model.addAttribute("businessId", businessId);
		return "business/busiaddressupdate";
	}

	@RequestMapping("{businessId}/save/address")
	public String saveBusinessAddress(
			@PathVariable("businessId") Long businessId,
			@ModelAttribute("businessAddress") AddressEntity address,
			ModelMap model, BindingResult result) {
		BusinessDetailsEntity business = businessService
				.getBusinessDetails(businessId);
		boolean flag = false;

		businessAddressValidator.validate(address, result);

		if (result.hasErrors()) {
			System.out.println("Errror Count" + result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println(" Error :" + error.getDefaultMessage());
				flag = true;
			}
		}

		/*
		 * if(businessAddress.getSubCategory().getCategory().getCategoryId()==0){
		 * 
		 * //ValidationUtils.rejectIfEmptyOrWhitespace(errors,
		 * "subCategory.category.categoryId", "11",mandatory); FieldError
		 * error1=new FieldError("businessDetails",
		 * "subCategory.category.categoryId", mandatory); flag=true;
		 * result.addError(error1); }
		 * if(businessDetails.getSubCategory().getSubCategoryId()==0){
		 * //ValidationUtils.rejectIfEmptyOrWhitespace(errors,
		 * "subCategory.subCategoryId", "11",mandatory); FieldError error2=new
		 * FieldError("businessDetails", "subCategory.subCategoryId",
		 * mandatory); result.addError(error2); flag=true; }
		 */

		if (flag) {
			/* model.addAttribute("businessdetail", ) */
			return "business/busiaddressupdate";
		}
		else {

			if (address.getAddressId() != null)
				addressService.updateAddress(address);
			else {
				addressService.saveAddress(address);
				AddressEntity address1 = addressService.getAddress(address.getAddressId());
				business.setAddress(address1);
				businessService.updateBusinessDetails(business);
				

				/*
				 * BusinessAddressEntity businessAddress =
				 * context.getBean("businessAddressEntity"
				 * ,BusinessAddressEntity.class);
				 * businessAddress.setBusiness(business);
				 * businessAddress.setAddress(address1);
				 * businessAddress.setAddressType("Head Office");
				 * businessAddressService.saveBusinessAddress(businessAddress);
				 */
			}
		}
		return "redirect:/admin/business/"
				+ business.getUserDetails().getUserDetailsId() + "/update/"
				+ businessId;
	}

	@RequestMapping(value = "/{businessId}/phone/save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<BusinessPhoneEntity> saveBusinessPhoneDetails(
			@PathVariable("businessId") Long businessId,
			@RequestParam("businessPhone") Long businessPhone, @RequestParam("phonetype") String phonetype) {
		try{
		BusinessDetailsEntity business = businessService
				.getBusinessDetails(businessId);
		BusinessPhoneEntity businesPhoneEntity = context.getBean(
				"businessPhoneEntity", BusinessPhoneEntity.class);
		businesPhoneEntity.setPhone(businessPhone.toString());
		businesPhoneEntity.setPhonetype(phonetype);
		businesPhoneEntity.setBusiness(business);
		businessPhoneService.saveBusinessPhoneDetails(businesPhoneEntity);
		}catch(NullPointerException e){
			System.out.println(e.getLocalizedMessage());
		}
		List<BusinessPhoneEntity> l = businessPhoneService
				.getBusinessPhoneDetailByBusinessId(businessId);
		for (BusinessPhoneEntity b : l)
			System.out.println(b.getPhone());
		return l;
	}
	
	
	@RequestMapping(value = "/{businessId}/phone/update/{phoneId}", method = RequestMethod.POST, produces = "application/json")
	public void updateBusinessPhoneDetails(
			@PathVariable("businessId") Long businessId,
			@RequestParam("businessPhone") Long businessPhone, @RequestParam("phonetype") String phonetype,@PathVariable("phoneId")Long phoneId) {
		//try{
		/*BusinessDetailsEntity business = businessService
				.getBusinessDetails(businessId);*/
		System.out.println("In update");	
		BusinessPhoneEntity businesPhoneEntity = businessPhoneService.getBusinessPhoneByPhoneId(phoneId);
		System.out.println(" yes here "+phoneId+" business phone Entity"+businesPhoneEntity);
		businesPhoneEntity.setPhone(businessPhone.toString());
		businesPhoneEntity.setPhonetype(phonetype);
		/*businesPhoneEntity.setBusiness(business);*/
		
		businessPhoneService.updateBusinessPhoneDetails(businesPhoneEntity);
		
		//}catch(NullPointerException e){
			//System.out.println(e.getLocalizedMessage());
		//}
		/*List<BusinessPhoneEntity> l = businessPhoneService
				.getBusinessPhoneDetailByBusinessId(businessId);
		for (BusinessPhoneEntity b : l)
			System.out.println(b.getPhone());
		return l;*/
	}
	
	
	
	

	@RequestMapping(value = "/{businessId}/feature/save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<BusinessGeneralInfoEntity> saveBusinessGeneralInfo(
			@PathVariable("businessId") Long businessId,
			@RequestParam("generalInfo") String generalInfo) {
		boolean flag = false;

		if (generalInfo.equalsIgnoreCase("") || generalInfo.equalsIgnoreCase(null)) {
			/*logger.info("Feature is Empty");*/
			flag = true;

		}
		if (flag) {
			/*logger.info("Feature is Empty");*/
		} else {
		BusinessDetailsEntity business = businessService
				.getBusinessDetails(businessId);
		BusinessGeneralInfoEntity entity = context.getBean(
				"businessGeneralInfoEntity", BusinessGeneralInfoEntity.class);
		entity.setGeneralInfoName(generalInfo);
		entity.setBusiness(business);
		businessGeneralInfoService.saveBusinessGeneralInfo(entity);
		}
		List<BusinessGeneralInfoEntity> l = businessGeneralInfoService
				.getBusinessGeneralInfoByBusinessId(businessId);
		for (BusinessGeneralInfoEntity b : l)
			System.out.println(b.getGeneralInfoName());
		return l;
	}

	/*
	 * @RequestMapping(value="/{businessId}/features/save",method=RequestMethod.POST
	 * ,produces="application/json") public @ResponseBody
	 * List<BusinessGeneralInfoEntity>
	 * saveBusinessGeneralInfo(@PathVariable("businessId") Long
	 * businessId,@RequestParam("generalInfo") String generalInfo) {
	 * BusinessDetailsEntity business =
	 * businessService.getBusinessDetails(businessId); BusinessGeneralInfoEntity
	 * entity =
	 * context.getBean("businessGeneralInfoEntity",BusinessGeneralInfoEntity
	 * .class); entity.setGeneralInfoName(generalInfo);
	 * entity.setBusiness(business);
	 * businessGeneralInfoService.saveBusinessGeneralInfo(entity);
	 * List<BusinessGeneralInfoEntity> l =
	 * businessGeneralInfoService.getBusinessGeneralInfoByBusinessId
	 * (businessId); for(BusinessGeneralInfoEntity b:l)
	 * System.out.println(b.getGeneralInfoName()); return l; }
	 */

	@RequestMapping(value = "/searchBusiness", method = RequestMethod.GET)
	public @ResponseBody List<String> serachBusinesData(
			@RequestParam("term") String keyword) {
		List<String> list = new ArrayList<String>();
		List<BusinessDetailsEntity> clientListByBusinessName;
		list.clear();
		clientListByBusinessName = businessService
				.getBusinessDetailsByBusinessName(keyword);
		System.out.println("Size OF BusinessName List"
				+ clientListByBusinessName.size());
		for (BusinessDetailsEntity bussiness : clientListByBusinessName) {
			System.out.println(" List value" + bussiness.getBusinessName());
			list.add(bussiness.getBusinessName());
		}
		return list;

	}

	@RequestMapping(value = "/getBusiness", method = RequestMethod.POST)
	public @ResponseBody List<BusinessDetailsEntity> getBusinessData(
			@RequestParam("keyword") String keyword) {
		List<BusinessDetailsEntity> clientListByBusinessName;
		clientListByBusinessName = businessService
				.findBusinessDetailsByBusinessName(keyword);
		System.out.println("After Search List Size In Table"
				+ clientListByBusinessName);
		return clientListByBusinessName;
	}
	
	@RequestMapping(value="/getAllBusiness",method=RequestMethod.GET) 
	public String getAllBusiness(ModelMap model) {
	      	
	 	model.addAttribute("businessList", businessService.getAllBusinessDetais());
		return "business/ListAllBusiness";
	} 
	
	@RequestMapping(value="/Businessenqury",method=RequestMethod.GET) 
	public String Businessenqury(ModelMap model) {
		List<BusinessEnquiryEntity> enquiries = businessEnquiryService.getAllEnquiries();
		model.addAttribute("enquiries", enquiries);
		return "business/Enquiry";
	} 
	
	

}
