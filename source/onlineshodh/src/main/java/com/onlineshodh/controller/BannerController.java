package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxFiles.FileMetadata;
import com.dropbox.core.v2.DbxFiles.Metadata;
import com.dropbox.core.v2.DbxUsers.FullAccount;
import com.dropbox.core.v2.DbxUsers.GetCurrentAccountException;
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
	static final String ACCESS_TOKEN = "CLYM2AeSMvAAAAAAAAAABtAeGrRghvyirnOVGPWXkG1bs-A_dN6byd4Yzy-fPcoN";


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
				"Less 3 MB");
		logger.info(FileSizeExceedException);
		logger.error(FileSizeExceedException);
		result.addError(FileSizeExceedException);
		return "banner/bannermanage";

	}
	
	
	@RequestMapping(value="/showBanners",method=RequestMethod.GET)
	public String ListAllBanners(ModelMap model){
		
	   model.addAttribute("banners", bannerService.getAllBanners());
		return "banner/ListAllBanners";
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
				logger.error(error.getDefaultMessage());
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
			model.addAttribute(
					"states",
					stateService.getAllStates(banner.getCity().getState()
							.getCountry().getCountryId()));
			model.addAttribute(
					"cities",
					cityService.getAllCities(banner.getCity().getState()
							.getStateId()));

			return "banner/bannermanage";
		} else {
			if (!file.isEmpty()) {
				byte[] bannerLogo = file.getBytes();
				/*banner.setBannerLogo(bannerLogo);
				System.out.println(" file lenght"+file.getBytes().length);
				System.out.println(" file size "+file.getSize());*/
				banner.setBannerLogo(null);
			}

			banner.setTotalHit(1);
			try {
				Integer bannerId=bannerService.saveBanner(banner);
				int startIndex=file.getOriginalFilename().lastIndexOf(".");
				String extension=file.getOriginalFilename().substring(startIndex);
				String fileName=bannerId+"-logo"+extension;
				try {

					String filePath = uploadToDropBox(fileName,
							file.getInputStream());
					filePath = filePath.replace("www.dropbox.com",
							"dl.dropboxusercontent.com");
					System.out.println("filePath: " + filePath);
					banner.setBannerId(bannerId);
					banner.setBannerFileName(fileName);
					banner.setBannerFilePath(filePath);
				} catch (DbxException e) {
					e.printStackTrace();
				}
				bannerService.updateBanner(banner);
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
				"/banner/banner_logo/" + fileName).run(in);
		System.out.println("Hi:" + metadata.toStringMultiline());
		DbxClientV1 dbxClient = new DbxClientV1(config, ACCESS_TOKEN);
		String sharedLink = dbxClient.createShareableUrl(metadata.pathLower);
		System.out.println("sharedLink: " + sharedLink);
		return sharedLink;
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
			logger.error("File Not Found");
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
