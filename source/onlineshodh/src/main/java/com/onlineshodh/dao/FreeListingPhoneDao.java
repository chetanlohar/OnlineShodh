package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.FreeListingPhoneEntity;

public interface FreeListingPhoneDao {
	
	public void saveFreeListingPhoneDetails(FreeListingPhoneEntity phoneEntity);

	public List<FreeListingPhoneEntity> getAllFLBusinessPhonesByBusinessId(
			Long businessId);

	public void updateFreeListingPhoneDetails(FreeListingPhoneEntity phoneEntity);
	
	public FreeListingPhoneEntity getPhoneById(Long phoneId);
	
	public void deletePhone(Long PhoneId);

}
