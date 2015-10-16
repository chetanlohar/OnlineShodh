package com.onlineshodh.dao;

import com.onlineshodh.entity.BusinessDetailsEntity;

public interface BusinessDetailsDao {
	
	/**
	 * @param business Describes the Business Data to be Store
	 */
	public void saveBusinessDetails(BusinessDetailsEntity business);
	
	/**
	 * @param business Updates the Business Details for the Business
	 */
	public void updateBusinessDetails(BusinessDetailsEntity business);
	
	/**
	 * @param businessId Describes the Business Id of the Business
	 * @return BusinessDetails of specified BusinessId
	 */
	public BusinessDetailsEntity getBusinessDetails(Long businessId);

}
