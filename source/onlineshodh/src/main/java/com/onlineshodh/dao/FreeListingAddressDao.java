package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.FreeListingAddressEntity;

public interface FreeListingAddressDao {

	public void saveFreeListingAddress(FreeListingAddressEntity address);

	List<FreeListingAddressEntity> getBusinessFeatureDetailByBusinessId(
			Long businessId);
}
