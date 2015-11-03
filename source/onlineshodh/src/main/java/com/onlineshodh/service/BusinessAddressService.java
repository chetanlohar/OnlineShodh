package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.BusinessAddressEntity;

public interface BusinessAddressService {
	
	public BusinessAddressEntity getBusinessAddressByBusinessId(Long businessId);
	
	public void saveBusinessAddress(BusinessAddressEntity businessAddressEntity);
	
	public List<BusinessAddressEntity> getAllBusinessAddressDetails();
}
