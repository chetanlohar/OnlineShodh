package com.onlineshodh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/prashant")
public class TestController {

	@RequestMapping(value="/createClient")
	public String doThis()
	{
		return "client/createClient";
	}
	

	@RequestMapping(value="/countymanage")
	public String docounty()
	{
		return "country/countryManagement";
	}
	
	@RequestMapping(value="/countyupdate")
	public String docountyupdate()
	{
		return "country/CountryUpdate";
	}
	
	
	@RequestMapping(value="/statemanage")
	public String dostate()
	{
		return "state/stateManagement";
	}
	@RequestMapping(value="/stateupdate")
	public String dostateupdate()
	{
		return "state/StateUpdate";
	}
	
	@RequestMapping(value="/citymanage")
	public String docity()
	{
		return "city/cityManage";
	}
	
	@RequestMapping(value="/cityupdate")
	public String docityupdate()
	{
		return "city/CityUpate";
	}
	
	
	@RequestMapping(value="/Townmanage")
	public String dotown()
	{
		return "town/townManagement";
	}
	@RequestMapping(value="/Townupdate")
	public String dotownupdate()
	{
		return "town/TownUpdate";
	}
	
	
	@RequestMapping(value="/clientcreate")
	public String doccreate()
	{
		return "client/createClient";
	}
	

	@RequestMapping(value="/clientupdate")
	public String doupdate()
	{
		return "client/updateClient";
	}
	
	
	@RequestMapping(value="/categorymanage")
	public String docategorym()
	{
		return "category/categorymanage";
	}
	

	@RequestMapping(value="/categoryupdate")
	public String docategoryu()
	{
		return "category/categoryupdate";
	}
	
	

	@RequestMapping(value="/subcategorymanage")
	public String dosubcategorym()
	{
		return "category/subcatmanage";
	}
	
	@RequestMapping(value="/subcategoryupdate")
	public String dosubcategoryu()
	{
		return "category/Subcategoryupdate";
	}
	

	@RequestMapping(value="/businessmanage")
	public String dobmanage()
	{
		return "business/addbusiness";
	}
	
	@RequestMapping(value="/newbusinessmanage")
	public String donewbmanage()
	{
		return "business/newbusiness";
	}
	
	@RequestMapping(value="/businessdetail")
	public String dobusinessdetail()
	{
		return "business/BusinessDetails";
	}
	@RequestMapping(value="/businessnew")
	public String dobusinessnew()
	{
		return "business/businessadd";
	}
	
	@RequestMapping(value="/businessnewadd")
	public String dobusinessnewadd()
	{
		return "business/newbusnessaddress";
	}
	
	@RequestMapping(value="/businessdetailedit")
	public String dobusinessdetailedit()
	{
		return "business/Bclientupdate";
	}
	
	@RequestMapping(value="/businessdetailupdate")
	public String dobusinessdetailupdate()
	{
		return "business/businessdetailupdate";
	}
	
	@RequestMapping(value="/businessaddressupdate")
	public String dobusinessaddressupdate()
	{
		return "business/busiaddressupdate";
	}
	@RequestMapping(value="/clientaddupdate")
	public String doclientaddupdate()
	{
		return "business/clientaddupdate";
	}
	@RequestMapping(value="/editbusiness")
	public String doeditbusiness()
	{
		return "business/editbusiness";
	}
	
	//banner controller
	
	@RequestMapping(value="/bannermanage")
	public String dobanner()
	{
		return "banner/bannermanage";
	}
	
	//plan controller
	@RequestMapping(value="/addplan")
	public String doaddplan()
	{
		return "plan/Create_plan";
	}
	@RequestMapping(value="/plan_edit")
	public String doplan_edit()
	{
		return "plan/edit_plan";
	}
	
	@RequestMapping(value="/plan_price")
	public String doplan_price()
	{
		return "plan/plantable";
	}
	
	//search_result controller
	
	
	@RequestMapping(value="/business_list")
	public String dobusiness_list()
	{
		return "Search_result/Business_listing";
	}
	
}
