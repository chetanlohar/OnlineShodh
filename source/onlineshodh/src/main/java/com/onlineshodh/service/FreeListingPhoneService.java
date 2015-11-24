package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.FreeListingPhoneEntity;

public interface FreeListingPhoneService {

	public void saveFreeListingPhoneDetails(FreeListingPhoneEntity phoneEntity);
	public List<FreeListingPhoneEntity> getAllFLBusinessPhonesByBusinessId(
			Long businessId);
	
	public void updateFreeListingPhoneDetails(FreeListingPhoneEntity phoneEntity);
	public void deletePhone(Long phoneId); 
	public FreeListingPhoneEntity getPhoneById(Long phoneId);
}
