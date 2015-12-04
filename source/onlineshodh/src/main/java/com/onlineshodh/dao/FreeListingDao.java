package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.FreeListingBusinessEntity;

public interface FreeListingDao {
	
	public Long saveFreeListingBusinessDetails(FreeListingBusinessEntity entity);
	public FreeListingBusinessEntity getFeelistingEntityById(Long freeListingId);
	public List<FreeListingBusinessEntity> getALlFreeListingBusiness(); 
	public void updateFreeListingBusinessDetails(FreeListingBusinessEntity entity); 
	public List<FreeListingBusinessEntity> getAllFLBusinessById(Long freeListingId);


}
