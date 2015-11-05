package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.onlineshodh.entity.BannerEntity;

import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.entity.StateEntity;
import com.onlineshodh.service.BannerService;
import com.onlineshodh.service.CategoryService;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.CountryService;
import com.onlineshodh.service.StateService;
import com.onlineshodh.service.TownService;
import com.onlineshodh.support.validator.BannerEntityValidator;

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
	
	BannerEntityValidator bannerEntityValidator; 

	@Autowired
	public BannerController(BannerEntityValidator bannerEntityValidator) {
		super();
		this.bannerEntityValidator = bannerEntityValidator;
	}

	@RequestMapping(value = { "/", "" })
	public String showManageBanner(ModelMap model) {
		BannerEntity banner=new BannerEntity();
	    banner.setStatus("NotActive");
	    banner.setRegDate(new Date());      
		model.addAttribute("banner",banner);
		model.addAttribute("countries", countryService.getAllCountries());
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("banners", bannerService.getAllBanners());
		return "banner/bannermanage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String saveBanner() {
		return "redirect:/admin/banners";
	}
	
	@RequestMapping(value = "/searchBanner", method = RequestMethod.GET)
	public @ResponseBody List<String> serachBannerData(@RequestParam("term") String keyword) {
		
		List<String> list=new ArrayList<String>();
		List<BannerEntity> ListByBannerName;
		list.clear();
		ListByBannerName=bannerService.getBannerByBannerName(keyword);
		System.out.println("Size OF BusinessName List"+ListByBannerName.size());
		for(BannerEntity banner:ListByBannerName){
			System.out.println(" List value"+banner.getBannerName());
			list.add(banner.getBannerName());
		}
		return list; 
		
	}

	
	@RequestMapping(value = "/exception")
	public String HandleFileSizeExceedException(ModelMap model,
			@ModelAttribute("banner") BannerEntity banner, BindingResult result) {
		FieldError FileSizeExceedException;
		model.addAttribute("countries", countryService.getAllCountries());
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("banners", bannerService.getAllBanners());
		FileSizeExceedException = new FieldError("banner", "bannerLogo",
				"Please Select Image Less 3 MB");
		
		
		result.addError(FileSizeExceedException);
		return "banner/bannermanage";

	}
	
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBanner(ModelMap model,
			@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute("banner") BannerEntity banner,
			BindingResult result) throws IOException,MaxUploadSizeExceededException {
		boolean flag = false;

		System.out.println(banner);
		bannerEntityValidator.validate(banner, result);
		logger.info(file.isEmpty());
		
		if (result.hasErrors()) {
			System.out.println("Total Errors: "+result.getErrorCount());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				logger.info(error.getDefaultMessage());
				flag = true;
			}
		}
		if(file.isEmpty() && banner.getBannerLogo().length==0){
			FieldError bannerNotSelected = new FieldError("banner", "bannerLogo", mandatory);
			result.addError(bannerNotSelected);
			flag=true;
		}
			if (flag) {
			model.addAttribute("categories", categoryService.getAllCategories());
			model.addAttribute("banners", bannerService.getAllBanners());
			model.addAttribute("countries", countryService.getAllCountries());
			/*model.addAttribute(
					"states",
					stateService.getAllStates(banner.getCity().getState()
							.getCountry().getCountryId()));
			model.addAttribute(
					"cities",
					cityService.getAllCities(banner.getCity().getState()
							.getStateId()));*/

			return "banner/bannermanage";
		} else {
			if (!file.isEmpty()) {
				byte[] bannerLogo = file.getBytes();
				banner.setBannerLogo(bannerLogo);
				System.out.println(" file lenght"+file.getBytes().length);
				System.out.println(" file size "+file.getSize());
			}

			banner.setTotalHit(1);
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

		return "banner/bannermanage";
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
		return "banner/Bannerupdate";
	}

	@RequestMapping(value = "/delete/{bannerId}", method = RequestMethod.GET)
	public String deleteTown(ModelMap model,
			@PathVariable("bannerId") Integer bannerId) {
		bannerService.deleteBanner(bannerId);
		return "redirect:/admin/banners";
	}

	
}
