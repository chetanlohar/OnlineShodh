package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxFiles.FileMetadata;
import com.dropbox.core.v2.DbxFiles.Metadata;
import com.dropbox.core.v2.DbxUsers.FullAccount;
import com.dropbox.core.v2.DbxUsers.GetCurrentAccountException;
import com.onlineshodh.entity.AddressEntity;
import com.onlineshodh.entity.BannerEntity;
import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.BusinessSearchEntity;
import com.onlineshodh.entity.TownEntity;
import com.onlineshodh.entity.UserDetailsEntity;
import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.exception.ConstraintViolationException;
import com.onlineshodh.service.AddressService;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.TownService;
import com.onlineshodh.service.UserDetailsService;
import com.onlineshodh.service.UserService;
import com.onlineshodh.supportclass.ClientDetails;

@Controller
@RequestMapping(value = "/admin/clients")
public class ClientController {
	private static final Logger logger = Logger
			.getLogger(ClientController.class);

	@Autowired
	WebApplicationContext context;

	@Autowired
	UserService userService;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	CityService cityService;

	@Autowired
	TownService townService;

	@Autowired
	BusinessDetailsService businessDetailsService;

	@Autowired
	AddressService addressService;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Value("${mandatory}")
	String mandatory;

	@Value("${alreadyExist}")
	String alreadyExist;

	@Value("${onlyDigits}")
	String onlyDigits;
	
	static final String ACCESS_TOKEN = "CLYM2AeSMvAAAAAAAAAABtAeGrRghvyirnOVGPWXkG1bs-A_dN6byd4Yzy-fPcoN";

	

	@RequestMapping(value = { "/", "" })
	public String manageClients(ModelMap model) {
		model.addAttribute("clientdetails",
				context.getBean("clientDetails", ClientDetails.class));
		model.addAttribute("userDetails",
				userDetailsService.getAllUserDetails());
		model.addAttribute("cities", cityService.getAllCities());
		return "client/createClient";
	}

	@RequestMapping(value = "/business")
	public String serachClient(ModelMap model) {
		return "business/addNewBusiness";

	}

	@RequestMapping(value = "/showTowns", method = RequestMethod.POST)
	public @ResponseBody List<TownEntity> showTowns(ModelMap model,
			@RequestParam("cityId") Integer cityId) {
		System.out.println("Town ");
		for(TownEntity town:townService.getAllTowns(cityId)){
			 System.out.println("Town "+town.getTownName());	
		}
        
		return townService.getAllTowns(cityId);
	}

	@RequestMapping(value = "/searchClient", method = RequestMethod.GET)
	public @ResponseBody List<String> serachClientData(
			@RequestParam("term") String keyword,
			@RequestParam("searchBy") Integer searchBy) {
		List<BusinessDetailsEntity> clientListByBusinessName;
		List<UserEntity> userList;
		List<String> list = new ArrayList<String>();
		if (searchBy == 2) {
			System.out.println(" In search Box" + searchBy);
			List<UserDetailsEntity> clientListByName;
			clientListByName = userDetailsService.getUserDeatilsByName(keyword
					.toUpperCase());
			System.out.println(" List value" + clientListByName);
			for (UserDetailsEntity userDetails : clientListByName) {
				System.out.println(" List value" + userDetails.getName());
				list.add(userDetails.getName());
			}
			return list;
		} else if (searchBy == 3) {
			userList = userService.getUserByName(keyword.toLowerCase());
			list.clear();
			for (UserEntity user : userList) {
				System.out.println(" List value" + user.getUserName());
				list.add(user.getUserName());
			}

			return list;
		} else {
			System.out.println("Search By " + searchBy);
			list.clear();
			clientListByBusinessName = businessDetailsService
					.getBusinessDetailsByBusinessName(keyword.toLowerCase());

			for (BusinessDetailsEntity bussiness : clientListByBusinessName) {
				System.out.println(" List value" + bussiness.getBusinessName());
				list.add(bussiness.getBusinessName());
			}
			return list;
		}

	}

	@RequestMapping(value = "/getClient", method = RequestMethod.POST)
	public @ResponseBody List<UserDetailsEntity> serachClient(
			@RequestParam("keyword") String keyword,
			@RequestParam("searchBy") Integer searchBy) {
		// validator.validate(target, errors);

		System.out.println("searchBy: " + searchBy);
		System.out.println("keyword: " + keyword);

		List<UserDetailsEntity> clientList = new ArrayList<UserDetailsEntity>();
		List<BusinessDetailsEntity> clientListByBusinessName;

		if (searchBy == 1) {
			clientList.clear();
			clientList.add(userDetailsService.getUserDetails(Integer
					.parseInt(keyword)));
			System.out.println("After Search List Size In Table" + clientList);
			return clientList;
		} else if (searchBy == 2) {
			List<UserDetailsEntity> clientListByName;
			clientListByName = userDetailsService
					.findUserDeatilsByName(keyword);
			System.out.println("After Search List Size In Table"
					+ clientListByName);
			return clientListByName;
		} else if (searchBy == 3) {
			UserEntity user = userService.getUserByUserName(keyword);
			clientList.clear();
			clientList.add(userDetailsService.getUserDetailsByUserId(user
					.getUserId()));
			System.out.println("After Search List Size In Table" + clientList);
			return clientList;
		} else {

			clientList.clear();
			clientListByBusinessName = businessDetailsService
					.findBusinessDetailsByBusinessName(keyword);
			for (BusinessDetailsEntity bussiness : clientListByBusinessName) {
				UserDetailsEntity user = new UserDetailsEntity();
				user.setUserDetailsId(bussiness.getUserDetails()
						.getUserDetailsId());
				clientList.add(userDetailsService.getUserDetails(user
						.getUserDetailsId()));
			}
			System.out.println("After Search List Size In Table" + clientList);
			return clientList;
		}

	}

	@ExceptionHandler(java.lang.NumberFormatException.class)
	public @ResponseBody String handleNumberFormatException(
			java.lang.NumberFormatException ex) {
		System.out.println("NumberFormatException 1");
		logger.info(ex.getMessage());
		return "Please Enter Valid keywords";
	}

	/*
	 * @RequestMapping(value = "/exception",method=RequestMethod.GET) public
	 * @ResponseBody String HandleException(ModelMap
	 * model,@ModelAttribute("SearchBusiness")BusinessSearchEntity
	 * businessSearch,BindingResult result) {
	 * 
	 * FieldError searchKeywordError=new FieldError("businessSearch",
	 * "searchText"," Please Enter Valid Keywords.." );
	 * result.addError(searchKeywordError); model.addAttribute("SearchBusiness",
	 * context.getBean("businessSearchEntity",BusinessSearchEntity.class));
	 * System.out.println("model"); return "business/BusinessManagement";
	 * 
	 * }
	 */
	/*
	 * @RequestMapping(value = "/exception",method=RequestMethod.GET) public
	 * @ResponseBody String HandleException() { return
	 * "business/BusinessManagement"; }
	 */

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String redirectToClients() {

		return "redirect:/admin/clients";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveClient(
			ModelMap model,
			@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute("clientdetails") ClientDetails clientdetails,
			BindingResult result) throws IOException {
		System.out.println(clientdetails);

		logger.info(clientdetails.getUser().getPassword());

		model.addAttribute("userDetails",
				userDetailsService.getAllUserDetails());
		UserEntity user = clientdetails.getUser();
		UserDetailsEntity userDetails = clientdetails.getUserDetails();
		AddressEntity addressEntity = clientdetails.getAddress();
		System.out.println("phone1" + userDetails.getPhone1());
		System.out.println("phone2" + userDetails.getPhone2());
		boolean flag = false;
		String regex = "[0-9]+";

		if (!userDetails.getPhone1().matches(regex)) {
			FieldError error = new FieldError("clientdetails",
					"userDetails.phone1", onlyDigits);
			result.addError(error);
			System.out.println("phone not selected "
					+ error.getDefaultMessage());
			flag = true;
			logger.info(error.getDefaultMessage());
		}
		/*if (!userDetails.getPhone2().matches(regex)
				&& userDetails.getPhone2() != "") {
			FieldError error = new FieldError("clientdetails",
					"userDetails.phone2", onlyDigits);
			result.addError(error);
			System.out.println(" not selected " + error.getDefaultMessage());
			flag = true;
			logger.info(error.getDefaultMessage());
		}*/

		System.out.println(" Addres Enity " + addressEntity);

		try{
		if (addressEntity.getCity().getCityId() == 0) {
			FieldError cityError = new FieldError("clientdetails",
					"address.city.cityId", mandatory);
			result.addError(cityError);
			flag = true;
			logger.info(cityError.getDefaultMessage());

		}

		}catch(NullPointerException e){
			FieldError cityError = new FieldError("clientdetails",
					"address.city.cityId", mandatory);
			result.addError(cityError);
		}
		if (addressEntity.getTown() == null
				|| addressEntity.getTown().getTownId() == 0) {
			FieldError townError = new FieldError("clientdetails",
					"address.town.townId", mandatory);
			result.addError(townError);
			flag = true;
			logger.info(townError.getDefaultMessage());

		}

		boolean isUserExists = userService.isUserExists(clientdetails.getUser()
				.getUserName());

		if (isUserExists) {
			FieldError error = new FieldError("clientdetails", "user.userName",
					alreadyExist);
			result.addError(error);
			System.out.println("error" + error);
			flag = true;
			logger.info(error.getDefaultMessage());
		}
		if (result.hasErrors()) {
			flag = true;
			System.out.println("error count" + result.getErrorCount());

		}
		if (file.isEmpty()
				&& clientdetails.getUserDetails().getPhotograph() == null) {
			FieldError error = new FieldError("clientdetails",
					"userDetails.photograph", mandatory);
			result.addError(error);
			System.out.println("error" + error);
			flag = true;
			logger.info(error.getDefaultMessage());
		}

		System.out.println("flag " + flag);
		if (flag) {

			model.addAttribute("cities", cityService.getAllCities(1));
			model.addAttribute(
					"towns",
					townService.getAllTowns(clientdetails.getAddress()
							.getCity().getCityId()));
		}
		if (!flag) {
			FieldError error;
			try {

				if (addressEntity != null) {

					System.out.println(" selected town Id "
							+ addressEntity.getTown().getTownId());
					if (addressEntity.getTownOther() != null
							&& addressEntity.getTown().getTownId() == 25) {
						System.out.println(" town Other"
								+ addressEntity.getTownOther());
						TownEntity town = new TownEntity();
						town.setCity(addressEntity.getCity());
						System.out.println("Address City:"
								+ addressEntity.getCity());
						town.setTownName(addressEntity.getTownOther().trim()
								.toUpperCase());
						System.out.println("  Entry Other town  In table"
								+ town);
						townService.updateTown(town);
						Integer lastTown = townService.getLastTown();
						System.out.println("last town Id" + lastTown);
						town.setTownId(lastTown);
						addressEntity.setTown(town);
						System.out
								.println("Address Entity Before Save in other option :"
										+ addressEntity);

						addressService.saveAddress(addressEntity);
					} else {
						System.out.println("Address Entity Before Save :"
								+ addressEntity);
						addressService.saveAddress(addressEntity);
					}

				}

				if (user != null) {
					String encryptedPassword = encoder.encode(user
							.getPassword());
					user.setPassword(encryptedPassword);

					System.out.println(user.toString());
					userService.saveUser(user);
					if (userDetails != null) {
						userDetails.setUserId(user.getUserId());
						userDetails.setEmail(user.getUserName());
						String name = userDetails.getName().toUpperCase()
								.trim();
						userDetails.setName(name);
						Long lastAddress = addressService.getLastAddress();
						System.out.println("last address" + lastAddress);
						addressEntity.setAddressId(lastAddress);
						System.out
								.println("address entity before store to userde"
										+ addressEntity);
						userDetails.setAddress(addressEntity);
						if (!file.isEmpty()){
							/*userDetails.setPhotograph(file.getBytes());*/
							userDetails.setPhotograph(null);
						}
					java.util.Date utildate=new java.util.Date();
					userDetails.setRegDate(new Date(utildate.getTime()));	
					Integer userDetailsId=userDetailsService.saveUserDetails(userDetails);
					System.out.println(" userDetailsId :"+userDetailsId);
					int startIndex=file.getOriginalFilename().lastIndexOf(".");
					String extension=file.getOriginalFilename().substring(startIndex);
					String fileName=userDetailsId+"-logo"+extension;
					try {

						String filePath = uploadToDropBox(fileName,
								file.getInputStream());
						filePath = filePath.replace("www.dropbox.com",
								"dl.dropboxusercontent.com");
						System.out.println("filePath: " + filePath);
						
						userDetails.setUserDetailsId(userDetailsId);
						userDetails.setUserdetailsFileName(fileName);
						userDetails.setUserdetailsFilePath(filePath);
					} catch (DbxException e) {
						e.printStackTrace();
					}
					
					userDetailsService.updateUserDetails(userDetails);
					
					}
				}
			} catch (ConstraintViolationException e) {
				error = new FieldError("clientdetails", "user." + e.getField(),
						e.getMsg());
				result.addError(error);
				logger.info(error.getDefaultMessage());
				return "client/createClient";
			} catch (Exception e) {
				error = new FieldError("clientdetails", "user.userName",
						"*Invalid Data");
				e.printStackTrace();
				logger.info(error.getDefaultMessage());
				return "client/createClient";
			}

			return "redirect:/admin/clients";
		}

		return "client/createClient";
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
				"/client/client_logo/" + fileName).run(in);
		System.out.println("Hi:" + metadata.toStringMultiline());
		DbxClientV1 dbxClient = new DbxClientV1(config, ACCESS_TOKEN);
		String sharedLink = dbxClient.createShareableUrl(metadata.pathLower);
		System.out.println("sharedLink: " + sharedLink);
		return sharedLink;
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String redirectToUpdate() {
		return "redirect:/admin/clients";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUserDetails(
			ModelMap model,
			@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute("userDetails") UserDetailsEntity userDetails,
			BindingResult result) {
		System.out.println(" File Size After Update :"
				+ userDetails.getPhotograph().length);
		String regex = "[0-9]+";
		boolean flag = false;
		AddressEntity addressEntity = userDetails.getAddress();
		if (!userDetails.getPhone1().matches(regex)) {
			FieldError error = new FieldError("clientdetails", "phone1",
					onlyDigits);
			result.addError(error);
			flag = true;
		}
		if (!userDetails.getPhone2().matches(regex)) {
			FieldError error = new FieldError("clientdetails", "phone2",
					onlyDigits);
			result.addError(error);
			flag = true;
		}

		if (result.hasErrors()) {
			flag = true;
		}

		if (flag) {

			model.addAttribute("cities", cityService.getAllCities(1));
			model.addAttribute(
					"towns",
					townService.getAllTowns(userDetails.getAddress().getCity()
							.getCityId()));
		}
		/*
		 * if(file.isEmpty() && userDetails.getPhotograph()==null) { FieldError
		 * error = new FieldError("userDetails", "photograph", mandatory);
		 * result.addError(error); flag = true; }
		 */
		if (!flag) {
			try {
				if (addressEntity != null) {

					System.out.println(" selected town Id "
							+ addressEntity.getTown().getTownId());
					if (addressEntity.getTownOther() != null
							&& addressEntity.getTown().getTownId() == 25) {
						System.out.println(" town Other"
								+ addressEntity.getTownOther());
						TownEntity town = new TownEntity();
						town.setCity(addressEntity.getCity());
						System.out.println("Address City:"
								+ addressEntity.getCity());
						town.setTownName(addressEntity.getTownOther().trim()
								.toUpperCase());
						System.out.println("  Entry Other town  In table"
								+ town);
						townService.updateTown(town);
						Integer lastTown = townService.getLastTown();
						System.out.println("last town Id" + lastTown);
						town.setTownId(lastTown);
						addressEntity.setTown(town);
						System.out
								.println("Address Entity Before Save in other option :"
										+ addressEntity);

						addressService.saveAddress(addressEntity);
					} else {
						System.out.println("Address Entity Before Save :"
								+ addressEntity);
						addressService.saveAddress(addressEntity);
					}
					System.out.println(" address Entity after other Town Added"
							+ addressEntity.toString());
					addressService.updateAddress(addressEntity);
					Long lastAddress = addressService.getLastAddress();
					System.out.println("last address" + lastAddress);
					addressEntity.setAddressId(lastAddress);
				}

				if (!file.isEmpty())
					userDetails.setPhotograph(file.getBytes());
				System.out.println("Reg date" + userDetails.getRegDate());
				userDetailsService.updateUserDetails(userDetails);
				return "redirect:/admin/clients";
			} catch (ConstraintViolationException e) {
				FieldError error = new FieldError("userDetails", e.getField(),
						e.getMsg());
				result.addError(error);
				return "client/createClient";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "client/clientUpdate";
	}

	@RequestMapping("/load/logo/{userDetailsId}")
	public String downloadPicture(
			@PathVariable("userDetailsId") Integer userDetailsId,
			HttpServletResponse response) {
		UserDetailsEntity userDetails = userDetailsService
				.getUserDetails(userDetailsId);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\""
					+ userDetails.getName() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType("image/gif");
			ByteArrayInputStream bis = new ByteArrayInputStream(
					userDetails.getPhotograph());
			IOUtils.copy(bis, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			logger.info("File Not Found for subCategoryId: " + userDetailsId);
		}
		return null;
	}

	@RequestMapping(value = "/delete/{userDetailsId}", method = RequestMethod.GET)
	public String deleteClientDetails(ModelMap model,
			@PathVariable("userDetailsId") Integer userDetailsId) {
		userService.deleteUser(userDetailsService.getUserDetails(userDetailsId)
				.getUserId());
		return "redirect:/admin/clients";
	}

	@RequestMapping(value = "/edit/{userDetailsId}", method = RequestMethod.GET)
	public String editClientDetails(ModelMap model,
			@PathVariable("userDetailsId") Integer userDetailsId) {
		try{
		System.out.println("UserDetails "
				+ userDetailsService.getUserDetails(userDetailsId));
		UserDetailsEntity userDetailsEntity = userDetailsService
				.getUserDetails(userDetailsId);
		Integer cityId = userDetailsEntity.getAddress().getCity().getCityId();
		List<TownEntity> towns = townService.getAllTowns(cityId);
		model.addAttribute("userDetails",
				userDetailsService.getUserDetails(userDetailsId));
		model.addAttribute("cities", cityService.getAllCities());
		model.addAttribute("towns", towns);
		/*System.out.println(" File Size before Update :"
				+ userDetailsService.getUserDetails(userDetailsId)
						.getPhotograph().length);*/
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		return "client/clientUpdate";
	}

	@RequestMapping(value = "/view/")
	public String showClientDetails(ModelMap model) {
		List<UserDetailsEntity> l = new ArrayList<UserDetailsEntity>();
		l.add(userDetailsService.getUserDetails(21));
		model.addAttribute("userDetails", l);
		return "business/addbusiness";
	}

	@RequestMapping(value = "/exception")
	public String HandleFileSizeExceedException(ModelMap model,
			@ModelAttribute("clientdetails") ClientDetails clientDetails,
			BindingResult result) {
		FieldError FileSizeExceedException;
		FileSizeExceedException = new FieldError("clientDetails",
				"userDetails.photograph", "Less than 300 KB");
		model.addAttribute("userDetails",
				userDetailsService.getAllUserDetails());
		model.addAttribute("cities", cityService.getAllCities());

		result.addError(FileSizeExceedException);
		return "client/createClient";

	}

}
