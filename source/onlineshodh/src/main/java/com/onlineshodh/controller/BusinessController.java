package com.onlineshodh.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.entity.BusinessAddressEntity;
import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.BusinessSearchEntity;
import com.onlineshodh.service.BusinessAddressService;
import com.onlineshodh.service.BusinessDetailsService;
import com.onlineshodh.service.UserDetailsService;

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
	BusinessAddressService businessAddressService;

	@RequestMapping(value = { "/", "" })
	public String manageBusinessDetails(ModelMap model) {
		model.addAttribute("businessDetails", context.getBean(
				"businessDetailsEntity", BusinessDetailsEntity.class));
		model.addAttribute("SearchBusiness", context.getBean(
				"businessSearchEntity", BusinessSearchEntity.class));
		return "business/BusinessManagement";
	}

	public String saveBusinessDetails(
			@Valid @ModelAttribute BusinessDetailsEntity businessDetails,
			BindingResult result) {

		return "";
	}

	
	@RequestMapping("/load/logo/{businessId}")
	public String downloadPicture(
			@PathVariable("businessId") Long businessId,
			HttpServletResponse response) {
		
		BusinessDetailsEntity business = businessService.getBusinessDetails(businessId);
		
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
	public String businessDetails(@PathVariable("userDetailsId") Long userDetailsId, ModelMap model)
	{
		model.addAttribute("userdetails",userDetailsService.getUserDetails(userDetailsId.intValue()));
		model.addAttribute("businessDetails",businessService.getBusinessDetailsByUserDetailsId(userDetailsId));
		return "business/BusinessDetails";
	}
	
	@RequestMapping("/{userDetailsId}/update/{businessId}")
	public String updateBusinessDetails(@PathVariable("userDetailsId") Long userDetailsId,@PathVariable("businessId") Long businessId,ModelMap model)
	{
		System.out.println("userDetailsId: "+userDetailsId);
		System.out.println("businessId: "+businessId);
		BusinessAddressEntity businessAddress = businessAddressService.getBusinessAddressByBusinessId(businessId);
		System.out.println(businessAddress.getAddress().getLandMark());
		model.addAttribute("businessDetails",businessAddress);
		return "business/businessdetailupdate";
	}
	
	@RequestMapping("/view/client/{userDetailsId}")
	public String viewClientDetails(@PathVariable("userDetailsId") Long userDetailsId, ModelMap model)
	{
		model.addAttribute("userdetails", userDetailsService.getUserDetails(userDetailsId.intValue()));
		return "business/BusinessDetails";
	}
	
	@RequestMapping("/new/add/{userDetailsId}")
	public String addNewBusiness(@PathVariable("userDetailsId") Long userDetailsId)
	{
		System.out.println("userDetailsId: "+userDetailsId);
		return "business/newbusiness";
		
	}
	
	@RequestMapping("/update/info/{userDetailsId}")
	public String addBusinessInfo(@PathVariable("userDetailsId") Long userDetailsId, ModelMap model)
	{
		model.addAttribute("businessdetail", context.getBean("businessDetailsEntity",BusinessDetailsEntity.class));
		return "business/businessadd";
	}
	
}
