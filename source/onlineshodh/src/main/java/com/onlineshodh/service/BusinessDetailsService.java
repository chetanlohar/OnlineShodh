package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.BusinessDetailsEntity;

public interface BusinessDetailsService {

	/**
	 * @param business
	 *            Describes the Business Data to be Store
	 */
	public void saveBusinessDetails(BusinessDetailsEntity business);

	/**
	 * @param business
	 *            Updates the Business Details for the Business
	 */
	public void updateBusinessDetails(BusinessDetailsEntity business);

	/**
	 * @param businessId
	 *            Describes the Business Id of the Business
	 * @return BusinessDetails of specified BusinessId
	 */
	public BusinessDetailsEntity getBusinessDetails(Long businessId);
	
	public List<BusinessDetailsEntity> getAllBusinessDetais();

	public List<BusinessDetailsEntity> getBusinessDetais(String name);

	public List<BusinessDetailsEntity> getBusinessDetaisByUserName(
			String userName);

	public List<BusinessDetailsEntity> getBusinessDetailsByBusinessName(
			String bussinessName);

	public List<BusinessDetailsEntity> findBusinessDetailsByBusinessName(
			String bussinessName);
	
	public List<BusinessDetailsEntity> getBusinessDetailsByUserDetailsId(Long userDetailsId);
	
	public List<BusinessDetailsEntity> getBusinessBySubCategoryId(Long subCatId);
	
	public List<BusinessDetailsEntity> getBusinessByCategoryId(Long catId);
	
}
