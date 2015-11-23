package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.FreeListingPhoneEntity;

public interface FreeListingPhoneDao {
	
	public void saveFreeListingPhoneDetails(FreeListingPhoneEntity phoneEntity);

	List<FreeListingPhoneEntity> getAllFLBusinessPhonesByBusinessId(
			Long businessId);

}
