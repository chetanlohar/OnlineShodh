package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.BusinessEnquiryEntity;
import com.onlineshodh.entity.SubCategoryEntity;
import com.onlineshodh.entity.TownEntity;
import com.onlineshodh.model.BusinessComparator;
import com.onlineshodh.model.SuggestBusiness;
import com.onlineshodh.model.SuggestSubCategory;
import com.onlineshodh.service.BannerService;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.BusinessEnquiryService;
import com.onlineshodh.service.BusinessGeneralInfoService;
import com.onlineshodh.service.BusinessPhoneService;
import com.onlineshodh.service.EmailNotificationService;
import com.onlineshodh.service.SubCategoryService;
import com.onlineshodh.service.TownService;
import com.onlineshodh.service.UserDetailsService;
import com.onlineshodh.service.UserService;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

	private static final Logger logger = Logger
			.getLogger(BannerController.class);

	@Autowired
	BusinessDetailsService businessDetailsService;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	BusinessDetailsService businessService;

	@Autowired
	UserService userService;

	@Value("${onlyAlphabets}")
	String onlyAlphabets;

	@Autowired
	WebApplicationContext context;

	@Autowired
	TownService townService;

	@Autowired
	SubCategoryService subCatService;

	@Autowired
	BusinessPhoneService businessPhoneService;

	@Autowired
	BusinessGeneralInfoService businessGeneralInfoService;

	@Autowired
	BusinessEnquiryService businessEnquiryService;
	
	@Autowired
	@Qualifier(value="emailNotificationService")
	EmailNotificationService emailService;
	
	@Autowired
	BannerService bannerService;

	static List<TownEntity> towns;

	static List<SubCategoryEntity> subCats;

	static List<String> strTownsWithCity;

	@PostConstruct
	public void init() {
		towns = townService.getAllTowns();
		strTownsWithCity = new ArrayList<String>();
		for (TownEntity town : towns) {
			strTownsWithCity.add(town.getCity().getCityName() + " ("
					+ town.getTownName() + ")");
		}
		subCats = subCatService.getAllSubCategories();
	}

	@RequestMapping(value = "/dosearch", method = RequestMethod.GET)
	@ResponseBody
	public List<String> doSearch(@RequestParam("term") String tagName,
			@RequestParam("cityName") String cityName) {
		SuggestBusiness suggestBusiness = context.getBean("suggestBusiness",
				SuggestBusiness.class);
		SuggestSubCategory suggestSubCategory = context.getBean(
				"suggestSubCategory", SuggestSubCategory.class);
		List<String> l = new ArrayList<String>();
		l.addAll(suggestSubCategory.doAutoSuggest(tagName.trim()));
		l.addAll(suggestBusiness.doAutoSuggest(tagName.trim(), cityName.trim()));
		return l;
	}

	@RequestMapping(value = "/doCitySearch", method = RequestMethod.GET)
	@ResponseBody
	public List<String> doCitySearch(@RequestParam("term") String str) {
		List<String> matches = new ArrayList<String>();
		for (String citytown : strTownsWithCity)
			if (citytown.toUpperCase().contains(str.toUpperCase()))
				matches.add(citytown);
		return matches;
	}

	@RequestMapping(value = { "/businesses" }, method = RequestMethod.GET)
	public String getBusinessDetails(@RequestParam("tagName") String tagName,
			@RequestParam("cityName") String cityName, ModelMap model) {
		boolean flag = false;
		Long subCatId = 0l;
		List<BusinessDetailsEntity> businesses = new ArrayList<BusinessDetailsEntity>();
		List<BusinessDetailsEntity> allCategoryLevelBusinesses = new ArrayList<BusinessDetailsEntity>();
		List<BusinessDetailsEntity> matchedBusinesses = new ArrayList<BusinessDetailsEntity>();
		List<BusinessDetailsEntity> matchedCityOnly = new ArrayList<BusinessDetailsEntity>();
		for (SubCategoryEntity subCat : subCats) {
			flag = tagName.toLowerCase().trim().contains(subCat.getSubCategoryName().toLowerCase().trim());
			if (flag == true) {
				subCatId = subCat.getSubCategoryId().longValue();
				break;
			}
		}
		if (flag) {
			businesses = businessDetailsService
					.getBusinessBySubCategoryId(subCatId);
			matchedCityOnly = new ArrayList<BusinessDetailsEntity>();
			for (BusinessDetailsEntity b : businesses) {
				String city = b.getAddress().getTown().getCity().getCityName();
				String town = b.getAddress().getTown().getTownName();
				String cityTown = city + " (" + town + ")";
				if (cityTown.equalsIgnoreCase(cityName))
					matchedBusinesses.add(b);
				else if (cityTown.trim().toLowerCase().contains(cityName.trim().toLowerCase())) {
					matchedCityOnly.add(b);
				}
			}
			Collections.sort(matchedBusinesses, new BusinessComparator());
			Collections.sort(matchedCityOnly, new BusinessComparator());
			matchedBusinesses.addAll(matchedCityOnly);
			if (matchedBusinesses.size() != 0) {
				model.addAttribute("subCategory", matchedBusinesses.get(0)
						.getSubCategory());
				model.addAttribute(
						"subCategories",
						subCatService
								.listSubCategoriesByCategoryId(matchedBusinesses
										.get(0).getSubCategory().getCategory()
										.getCategoryId()));
			} else {
				/*SubCategoryEntity subCat1 = subCatService
						.getSubCategory(tagName.trim().toLowerCase());*/
				allCategoryLevelBusinesses = businessService.getBusinessBySubCategoryId(subCatId);
				SubCategoryEntity subCatentity = subCatService.getSubCategoryById(subCatId.intValue());
				model.addAttribute("subCategory", subCatentity);
				model.addAttribute(
						"subCategories",
						subCatService.listSubCategoriesByCategoryId(subCatentity.getCategory().getCategoryId()));
			}
		} else {
			businesses = businessService
					.getBusinessDetailsByBusinessName(tagName.trim()
							.toLowerCase());
			if (businesses.size() != 0) {
				for (BusinessDetailsEntity b : businesses) {
					String city = b.getAddress().getTown().getCity()
							.getCityName();
					String town = b.getAddress().getTown().getTownName();
					String cityTown = city + " (" + town + ")";
					if (cityTown.equals(cityName))
						matchedBusinesses.add(b);
					else if (cityName.contains(city)) {
						matchedCityOnly.add(b);
					}
				}
				Collections.sort(matchedBusinesses, new BusinessComparator());
				Collections.sort(matchedCityOnly, new BusinessComparator());
				matchedBusinesses.addAll(matchedCityOnly);
				model.addAttribute("subCategory", businesses.get(0)
						.getSubCategory());
				model.addAttribute(
						"subCategories",
						subCatService
								.listSubCategoriesByCategoryId(businesses
										.get(0).getSubCategory().getCategory()
										.getCategoryId()));
			}
		}
		model.addAttribute("cityName", cityName);
		model.addAttribute("businesses", matchedBusinesses);
		model.addAttribute("byCategory",false);
		System.out.println(bannerService.getBannerById(185).getBannerFileName());
		return "Search_result/Business_listing";
	}

	@RequestMapping(value = { "/business/{businessId}" })
	public String businessDetails(@PathVariable Long businessId, ModelMap model) {
		model.addAttribute("businessEnquiry", context.getBean(
				"businessEnquiryEntity", BusinessEnquiryEntity.class));

		model.addAttribute("business",
				businessService.getBusinessDetails(businessId));

		model.addAttribute("phones", businessPhoneService
				.getBusinessPhoneDetailByBusinessId(businessId));

		model.addAttribute("generalinfo", businessGeneralInfoService
				.getBusinessGeneralInfoByBusinessId(businessId));
		
		return "Search_result/businessdetail";

	}

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

	@RequestMapping(value = { "/business/enquiry/save/{businessId}" }, method = RequestMethod.POST)
	public String saveEnquiry(@PathVariable Long businessId, ModelMap model,
			@ModelAttribute("businessEnquiry") BusinessEnquiryEntity enquiry,
			BindingResult result) {
		System.out.println("Enquiry: " + enquiry);
		BusinessDetailsEntity businessentity = businessService
				.getBusinessDetails(businessId);
		enquiry.setBusiness(businessentity);
		businessEnquiryService.saveEnquiry(enquiry);
		
		/*Email Sending*/
		
		emailService.sendEnquiryNotification(enquiry);

		model.addAttribute("businessEnquiry", context.getBean(
				"businessEnquiryEntity", BusinessEnquiryEntity.class));

		model.addAttribute("business",
				businessService.getBusinessDetails(businessId));

		model.addAttribute("phones", businessPhoneService
				.getBusinessPhoneDetailByBusinessId(businessId));

		model.addAttribute("generalinfo", businessGeneralInfoService
				.getBusinessGeneralInfoByBusinessId(businessId));

		model.addAttribute("successMsgEnquiry",
				"Thank you for Enquiry, we will contact you soon.!");
		return "Search_result/businessdetail";
	}

	@RequestMapping(value = { "/business/category/{categoryId}/city/{cityName}" })
	public String searchBusinessByCategory(@PathVariable Long categoryId,
			@PathVariable("cityName") String cityName, ModelMap model) {
		List<BusinessDetailsEntity> matchedBusinesses = new ArrayList<BusinessDetailsEntity>();
		List<BusinessDetailsEntity> matchedCityOnly = new ArrayList<BusinessDetailsEntity>();
		System.out.println("cityTown");
		List<BusinessDetailsEntity> businesses = businessService
				.getBusinessByCategoryId(categoryId);

		for (BusinessDetailsEntity b : businesses) {
			String city = b.getAddress().getTown().getCity().getCityName();
			String town = b.getAddress().getTown().getTownName();
			String cityTown = city + " (" + town + ")";
			if (cityTown.equals(cityName))
				matchedBusinesses.add(b);
			else if (cityName.contains(city)) {
				matchedCityOnly.add(b);
			}
		}
		Collections.sort(matchedBusinesses, new BusinessComparator());
		Collections.sort(matchedCityOnly, new BusinessComparator());
		matchedBusinesses.addAll(matchedCityOnly);
		model.addAttribute("subCategory", businesses.get(0).getSubCategory());
		model.addAttribute(
				"subCategories",
				subCatService.listSubCategoriesByCategoryId(businesses.get(0)
						.getSubCategory().getCategory().getCategoryId()));
		model.addAttribute("businesses", matchedBusinesses);
		return "Search_result/Business_listing";
	}

	@RequestMapping(value = { "/business/category/{categoryId}" })
	public String searchBusinessByCategory1(@PathVariable Long categoryId,
			ModelMap model) {
		List<BusinessDetailsEntity> businesses = businessService
				.getBusinessByCategoryId(categoryId);
		Collections.sort(businesses, new BusinessComparator());
		if (businesses.size() != 0) {
			model.addAttribute("subCategory", businesses.get(0)
					.getSubCategory());
			model.addAttribute(
					"subCategories",
					subCatService.listSubCategoriesByCategoryId(businesses
							.get(0).getSubCategory().getCategory()
							.getCategoryId()));
			model.addAttribute("businesses", businesses);
			model.addAttribute("byCategory",true);
		}
		model.addAttribute("banners",bannerService.getBanners(categoryId.intValue()));
		return "Search_result/Business_listing";
	}
}
