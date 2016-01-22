package com.onlineshodh.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping(value = "admin/account")
public class AccountController {

	private static final Logger logger = Logger
			.getLogger(ClientController.class);

	@Autowired
	WebApplicationContext context;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	CityService cityService;
	
	@Autowired
	UserService userService;

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

	@RequestMapping(value = { "/", "" ,"/create"})
	public String createAccount(ModelMap model) {
		model.addAttribute("clientdetails",
				context.getBean("clientDetails", ClientDetails.class));
		model.addAttribute("cities", cityService.getAllCities());
		return "account/manageAccounts";
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

		try {
			if (addressEntity.getCity().getCityId() == 0) {
				FieldError cityError = new FieldError("clientdetails",
						"address.city.cityId", mandatory);
				result.addError(cityError);
				flag = true;
				logger.info(cityError.getDefaultMessage());

			}

		} catch (NullPointerException e) {
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
			flag = true;
			logger.info(error.getDefaultMessage());
		}
		if (result.hasErrors()) {
			flag = true;

		}
		if (file.isEmpty()
				&& clientdetails.getUserDetails().getPhotograph() == null) {
			FieldError error = new FieldError("clientdetails",
					"userDetails.photograph", mandatory);
			result.addError(error);
			flag = true;
			logger.info(error.getDefaultMessage());
		}

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
					if (addressEntity.getTownOther() != null
							&& addressEntity.getTown().getTownId() == 25) {
						TownEntity town = new TownEntity();
						town.setCity(addressEntity.getCity());
						town.setTownName(addressEntity.getTownOther().trim()
								.toUpperCase());
						townService.updateTown(town);
						Integer lastTown = townService.getLastTown();
						town.setTownId(lastTown);
						addressEntity.setTown(town);
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
					userService.saveUser(user);
					if (userDetails != null) {
						userDetails.setUserId(user.getUserId());
						userDetails.setEmail(user.getUserName());
						String name = userDetails.getName().toUpperCase()
								.trim();
						userDetails.setName(name);
						Long lastAddress = addressService.getLastAddress();
						addressEntity.setAddressId(lastAddress);
						userDetails.setAddress(addressEntity);
						if (!file.isEmpty()) {
							userDetails.setPhotograph(null);
						}
						java.util.Date utildate = new java.util.Date();
						userDetails.setRegDate(new Date(utildate.getTime()));
						Integer userDetailsId = userDetailsService
								.saveUserDetails(userDetails);
						int startIndex = file.getOriginalFilename()
								.lastIndexOf(".");
						String extension = file.getOriginalFilename()
								.substring(startIndex);
						String fileName = userDetailsId + "-logo" + extension;
						try {

							String filePath = uploadToDropBox(fileName,
									file.getInputStream());
							filePath = filePath.replace("www.dropbox.com",
									"dl.dropboxusercontent.com");
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
				return "account/manageAccounts";
			} catch (Exception e) {
				error = new FieldError("clientdetails", "user.userName",
						"*Invalid Data");
				e.printStackTrace();
				logger.info(error.getDefaultMessage());
				return "account/manageAccounts";
			}
			return "redirect:/admin/account";
		}
		return "account/manageAccounts";
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

}
