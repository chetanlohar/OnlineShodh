package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.FreeListingAddressEntity;

public interface FreeListingAddressService {
	public void saveFreeListingAddress(FreeListingAddressEntity address);
	
	List<FreeListingAddressEntity> getBusinessFeatureDetailByBusinessId(
			Long businessId);
}
