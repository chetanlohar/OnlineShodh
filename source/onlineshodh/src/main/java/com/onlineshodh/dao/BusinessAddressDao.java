package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.BusinessAddressEntity;

public interface BusinessAddressDao {
	
	public BusinessAddressEntity getBusinessAddressByBusinessId(Long businessId);
	
	public void saveBusinessAddress(BusinessAddressEntity businessAddressEntity);
	
	public List<BusinessAddressEntity> getAllBusinessAddressDetails();

}
