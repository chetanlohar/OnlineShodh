package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.ws.BindingType;

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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.onlineshodh.entity.BannerEntity;
import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.entity.StateEntity;
import com.onlineshodh.service.BannerService;
import com.onlineshodh.service.CategoryService;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.CountryService;
import com.onlineshodh.service.StateService;
import com.onlineshodh.service.TownService;

@Controller
@RequestMapping(value = "/admin/banners")
public class BannerController {

	private static final Logger logger = Logger
			.getLogger(BannerController.class);

	@Autowired
	WebApplicationContext context;

	@Autowired
	CountryService countryService;

	@Autowired
	StateService stateService;

	@Autowired
	CityService cityService;

	@Autowired
	TownService townService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	BannerService bannerService;

	@Value("${onlyAlphabets}")
	String onlyAlphabets;

	@Value("${alreadyExist}")
	String alreadyExist;

	@Value("${mandatory}")
	String mandatory;

	@RequestMapping(value = { "/", "" })
	public String showManageBanner(ModelMap model) {
		model.addAttribute("banner", new BannerEntity());
		model.addAttribute("countries", countryService.getAllCountries());
		model.addAttribute("categories", categoryService.getAllCategories());
		System.out.println(" list of Banners" + bannerService.getAllBanners());
		model.addAttribute("banners", bannerService.getAllBanners());
		return "banner/manageBanner";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String saveBanner() {
		return "redirect:/admin/banners";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBanner(ModelMap model,
			@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute("banner") BannerEntity banner,
			BindingResult result) throws IOException {
		boolean flag = false;

		System.out.println(banner);
		logger.info(file.isEmpty());
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				logger.info(error.getDefaultMessage());
			}
		}

		if (banner.getCategory().getCategoryId() == 0) {
			FieldError categoryNotSelected = new FieldError("banner",
					"category.categoryId", mandatory);
			result.addError(categoryNotSelected);
			flag = true;
		}
		if (banner.getCity().getState().getCountry().getCountryId() == 0) {
			FieldError countryNotSelected = new FieldError("banner",
					"city.state.country.countryId", mandatory);
			result.addError(countryNotSelected);
			flag = true;
		}
		if (banner.getCity().getState().getStateId() == 0) {
			FieldError stateNotSelected = new FieldError("banner",
					"city.state.stateId", mandatory);
			result.addError(stateNotSelected);
			flag = true;
		}
		if (banner.getCity().getCityId() == 0) {
			FieldError cityNotSelected = new FieldError("banner",
					"city.cityId", mandatory);
			result.addError(cityNotSelected);
			flag = true;
		}
		if (banner.getUrlLink().equalsIgnoreCase("")) {
			FieldError urlLinkNotEnter = new FieldError("banner", "urlLink",
					mandatory);
			result.addError(urlLinkNotEnter);
			flag = true;
		}
		try {
			if (banner.getStartDate().getDate() == 0) {
				logger.info("Start Date Empty");

			}
		} catch (NullPointerException e) {
			FieldError DateNotEnter = new FieldError("banner", "startDate",
					"Please Enter Start Date");
			result.addError(DateNotEnter);
			flag = true;
		} catch (java.lang.IllegalArgumentException exception) {
			FieldError DateNotEnter = new FieldError("banner", "startDate",
					"Please Enter Start Date");
			result.addError(DateNotEnter);
			flag = true;
		}
		try {
			if (banner.getExpiryDate().getDate() == 0) {
				logger.info("Expiry Date Empty");
			}
		} catch (NullPointerException e) {
			FieldError DateNotEnter = new FieldError("banner", "expiryDate",
					"Please Enter Expiry Date");
			result.addError(DateNotEnter);
			flag = true;
		} catch (java.lang.IllegalArgumentException exception) {
			FieldError DateNotEnter = new FieldError("banner", "expiryDate",
					"Please  Enter Expiry Date");
			result.addError(DateNotEnter);
			flag = true;
		}
		try {
			if (banner.getRegDate().getDate() == 0) {
				logger.info("Register Date Empty");
			}
		} catch (NullPointerException e) {
			FieldError DateNotEnter = new FieldError("banner", "regDate",
					"Please Enter Register Date");
			result.addError(DateNotEnter);
			flag = true;
		} catch (java.lang.IllegalArgumentException exception) {
			FieldError DateNotEnter = new FieldError("banner", "regDate",
					"Please Enter Register Date");
			result.addError(DateNotEnter);
			flag = true;
		}

		if (flag) {
			model.addAttribute("categories", categoryService.getAllCategories());
			model.addAttribute("banners", bannerService.getAllBanners());
			model.addAttribute("countries", countryService.getAllCountries());
			model.addAttribute(
					"states",
					stateService.getAllStates(banner.getCity().getState()
							.getCountry().getCountryId()));
			model.addAttribute(
					"cities",
					cityService.getAllCities(banner.getCity().getState()
							.getStateId()));

			return "banner/manageBanner";
		} else {
			if (!file.isEmpty()) {
				byte[] bannerLogo = file.getBytes();
				banner.setBannerLogo(bannerLogo);
			}

			System.out.println(" Banner Link" + banner.getUrlLink());
			banner.setTotalHit(1);
			banner.setStatus("Uploaded");
			try {
				bannerService.saveBanner(banner);
				return "redirect:/admin/banners";
			} catch (DataIntegrityViolationException e) {

				FieldError bannerAvailableError = null;
				if (e.getMostSpecificCause().getMessage().contains("unique")) {
					bannerAvailableError = new FieldError("banner", "banner",
							alreadyExist);
					logger.info(alreadyExist);
				}
				result.addError(bannerAvailableError);

			} catch (Exception e) {
				logger.debug("Exception Occured!", new Exception(e));
			}
		}

		return "banner/manageBanner";
	}

	@RequestMapping("/load/logo/{bannerId}")
	public String downloadPicture(@PathVariable("bannerId") Integer bannerId,
			HttpServletResponse response) {

		BannerEntity banner = bannerService.getBannerById(bannerId);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\""
					+ banner.getCategory().getCategoryName() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType("image/gif");
			ByteArrayInputStream bis = new ByteArrayInputStream(
					banner.getBannerLogo());
			IOUtils.copy(bis, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			logger.info("File Not Found");
		}
		return null;
	}

	@RequestMapping(value = "/edit/{bannerId}", method = RequestMethod.GET)
	public String editCity(ModelMap model,
			@PathVariable("bannerId") Integer bannerId) {

		List<StateEntity> states = null;
		List<CityEntity> cities = null;
		states = stateService.getAllStates();
		cities = cityService.getAllCities();
		for (StateEntity state : states)
			System.out.println(" States :" + bannerId);
		model.addAttribute("banner", bannerService.getBannerById(bannerId));
		model.addAttribute("cities", cities);
		model.addAttribute("states", states);
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("countries", countryService.getAllCountries());
		return "banner/updateBanner";
	}

	@RequestMapping(value = "/delete/{bannerId}", method = RequestMethod.GET)
	public String deleteTown(ModelMap model,
			@PathVariable("bannerId") Integer bannerId) {
		bannerService.deleteBanner(bannerId);
		return "redirect:/admin/banners";
	}

}
