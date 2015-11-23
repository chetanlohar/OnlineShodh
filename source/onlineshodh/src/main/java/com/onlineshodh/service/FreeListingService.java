package com.onlineshodh.service;

import com.onlineshodh.entity.FreeListingBusinessEntity;

public interface FreeListingService {
	
	public Long saveFreeListingBusinessDetails(FreeListingBusinessEntity entity);
	public FreeListingBusinessEntity getFeelistingEntityById(Long freeListingId);

}
