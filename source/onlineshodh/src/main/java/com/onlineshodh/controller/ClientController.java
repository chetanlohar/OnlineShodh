package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.onlineshodh.entity.AddressEntity;
import com.onlineshodh.entity.TownEntity;
import com.onlineshodh.entity.UserDetailsEntity;
import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.exception.ConstraintViolationException;
import com.onlineshodh.service.AddressService;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.TownService;
import com.onlineshodh.service.UserDetailsService;
import com.onlineshodh.service.UserService;
import com.onlineshodh.supportclass.ClientDetails;

@Controller
@RequestMapping(value="/admin/clients")
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
	AddressService addressService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Value("${mandatory}")
	String mandatory;
	
	@Value("${alreadyExist}")
	String alreadyExist;
	
	@Value("${onlyDigits}")
	String onlyDigits;
	

	@RequestMapping(value = { "/", "" })
	public String manageClients(ModelMap model) {
		model.addAttribute("clientdetails",
				context.getBean("clientDetails", ClientDetails.class));
		model.addAttribute("userDetails",
				userDetailsService.getAllUserDetails());
		model.addAttribute("cities", cityService.getAllCities());
		return "client/createClient";
	}

	@RequestMapping(value = "/showTowns", method = RequestMethod.POST)
	public @ResponseBody List<TownEntity> showTowns(ModelMap model,
			@RequestParam("cityId") Integer cityId) {

		return townService.getAllTowns(cityId);
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String redirectToClients() {

		return "redirect:/admin/clients";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveClient(
			ModelMap model,
			@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute("clientdetails") ClientDetails clientdetails,
			BindingResult result) {
		System.out.println(clientdetails);

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
			System.out.println("error"+error);
			flag = true;
		}
		if (!userDetails.getPhone2().matches(regex)
				&& userDetails.getPhone2() != "") {
			FieldError error = new FieldError("clientdetails",
					"userDetails.phone2", onlyDigits);
			result.addError(error);
			System.out.println("error"+error);
			flag = true;
		}

		if (addressEntity.getAddress().equalsIgnoreCase(" ")
				|| addressEntity.getAddress() == null) {
			FieldError error = new FieldError("clientdetails", "address.address",
					mandatory);
			result.addError(error);
			flag = true;
			
		}
		if (addressEntity.getStreet().equalsIgnoreCase(" ")
				|| addressEntity.getStreet() == null) {
			FieldError error = new FieldError("clientdetails", "address.street",
					mandatory);
			result.addError(error);
			flag = true;
			
		}
		if (addressEntity.getCity().getCityId() == null) {
			FieldError error = new FieldError("clientdetails", "address.city.cityId",
					mandatory);
			result.addError(error);
			flag = true;
			
		}
		if (addressEntity.getPincode().equalsIgnoreCase(" ")
				|| addressEntity.getPincode() == null) {
			FieldError error = new FieldError("clientdetails", "address.pincode",
					mandatory);
			result.addError(error);
			flag = true;
			
		}
		if (addressEntity.getTown().getTownId() == null) {
			FieldError error = new FieldError("clientdetails", "address.town.townId",
					mandatory);
			result.addError(error);
			flag = true;
			
		}
		if (addressEntity.getTownOther().equalsIgnoreCase(" ")
				|| addressEntity.getTownOther() == null) {
			FieldError error = new FieldError("clientdetails", "address.pincode",
					mandatory);
			result.addError(error);
			flag = true;
			
		}
		
		
		
		
		boolean isUserExists = userService.isUserExists(clientdetails.getUser()
				.getUserName());

		if (isUserExists) {
			FieldError error = new FieldError("clientdetails", "user.userName",
					alreadyExist);
			result.addError(error);
			System.out.println("error"+error);
			flag = true;
		}
		if (result.hasErrors()) {
			flag = true;
			System.out.println("error count"+result.getErrorCount());
		}
		if (file.isEmpty()
				&& clientdetails.getUserDetails().getPhotograph() == null) {
			FieldError error = new FieldError("clientdetails",
					"userDetails.photograph", mandatory);
			result.addError(error);
			System.out.println("error"+error);
			flag = true;
		}
		
		System.out.println("flag "+flag);
		if (!flag) {
			FieldError error;
			try {
				
				if(addressEntity!=null){
					
					System.out.println("here in add");
					if(addressEntity.getTownOther()!=null){
						System.out.println(" town Other"+addressEntity.getTownOther());
						TownEntity town=new TownEntity();
						town.setCity(addressEntity.getCity());
						town.setTownName(addressEntity.getTownOther().trim().toUpperCase());
						System.out.println("  Entry Other town  In table"+town);
						townService.updateTown(town);
						Integer lastTown=townService.getLastTown(); 
						town.setTownId(lastTown);
						addressEntity.setTown(town);
					}
					addressService.saveAddress(addressEntity);
					Long lastAddress=addressService.getLastAddress();
					System.out.println("last address"+lastAddress);
					addressEntity.setAddressId(lastAddress);
					
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
						System.out.println("address entity"+addressEntity);
						userDetails.setAddress(addressEntity);
						try {
							if (!file.isEmpty())
								userDetails.setPhotograph(file.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
						userDetailsService.saveUserDetails(userDetails);
					}
				}
			} catch (ConstraintViolationException e) {
				error = new FieldError("clientdetails", "user." + e.getField(),
						e.getMsg());
				result.addError(error);
				return "client/createClient";
			} catch (Exception e) {
				error = new FieldError("clientdetails", "user.userName",
						"*Invalid Data");
				e.printStackTrace();
				return "client/createClient";
			}
			
			return "redirect:/admin/clients";
		}
		
		return "client/createClient";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUserDetails(ModelMap model,@RequestParam("file") MultipartFile file,@Valid @ModelAttribute("userDetails") UserDetailsEntity userDetails, BindingResult result)
	{
		String regex = "[0-9]+";
		boolean flag = false;
		if(!userDetails.getPhone1().matches(regex))
		{
			FieldError error = new FieldError("clientdetails", "phone1", onlyDigits);
			result.addError(error);
			flag = true;
		}
		if(!userDetails.getPhone2().matches(regex))
		{
			FieldError error = new FieldError("clientdetails", "phone2", onlyDigits);
			result.addError(error);
			flag = true;
		}
		if(result.hasErrors())
		{
			flag = true;
		}
		if(file.isEmpty() && userDetails.getPhotograph()==null)
		{
			FieldError error = new FieldError("userDetails", "photograph", mandatory);
			result.addError(error);
			flag = true;
		}
		if(!flag)
		{
			try
			{
				if(!file.isEmpty())
					userDetails.setPhotograph(file.getBytes());
				userDetailsService.updateUserDetails(userDetails);
				return "redirect:/admin/clients";
			}
			catch(ConstraintViolationException e)
			{
				FieldError error = new FieldError("userDetails", e.getField(), e.getMsg());
				result.addError(error);
				return "client/createClient";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "client/clientUpdate";
	}
	
	@RequestMapping("/load/logo/{userDetailsId}")
	public String downloadPicture(@PathVariable("userDetailsId") Integer userDetailsId,HttpServletResponse response) {
		UserDetailsEntity userDetails = userDetailsService.getUserDetails(userDetailsId);
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
		}catch (NullPointerException e) {
			logger.info("File Not Found for subCategoryId: "+userDetailsId);
		}
		return null;
	}
	
	@RequestMapping(value = "/delete/{userDetailsId}", method = RequestMethod.GET)
	public String deleteClientDetails(ModelMap model,
			@PathVariable("userDetailsId") Integer userDetailsId) {
		userService.deleteUser(userDetailsService.getUserDetails(userDetailsId).getUserId());
		return "redirect:/admin/clients";
	}
	
	@RequestMapping(value = "/edit/{userDetailsId}", method = RequestMethod.GET)
	public String editClientDetails(ModelMap model,@PathVariable("userDetailsId") Integer userDetailsId) {
		model.addAttribute("userDetails", userDetailsService.getUserDetails(userDetailsId));
		return "client/clientUpdate";
	}
	
	@RequestMapping(value = "/view/")
	public String showClientDetails(ModelMap model)
	{
		List<UserDetailsEntity> l = new ArrayList<UserDetailsEntity>();
		l.add(userDetailsService.getUserDetails(21));
		model.addAttribute("userDetails", l);
		return "business/addbusiness";
	}

}
