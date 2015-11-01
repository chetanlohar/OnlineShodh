package com.onlineshodh.dao;

import com.onlineshodh.entity.BusinessAddressEntity;

public interface BusinessAddressDao {
	
	public BusinessAddressEntity getBusinessAddressByBusinessId(Long businessId);
	
	public void saveBusinessAddress(BusinessAddressEntity businessAddressEntity);

}
