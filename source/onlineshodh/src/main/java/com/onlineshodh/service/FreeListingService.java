package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.FreeListingBusinessEntity;

public interface FreeListingService {
	
	public Long saveFreeListingBusinessDetails(FreeListingBusinessEntity entity);
	public FreeListingBusinessEntity getFeelistingEntityById(Long freeListingId);
	public List<FreeListingBusinessEntity> getALlFreeListingBusiness();
	public void updateFreeListingBusinessDetails(FreeListingBusinessEntity entity); 
	
}
