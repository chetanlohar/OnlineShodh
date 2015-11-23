package com.onlineshodh.dao;

import com.onlineshodh.entity.FreeListingBusinessEntity;

public interface FreeListingDao {
	
	public Long saveFreeListingBusinessDetails(FreeListingBusinessEntity entity);
	public FreeListingBusinessEntity getFeelistingEntityById(Long freeListingId);


}
