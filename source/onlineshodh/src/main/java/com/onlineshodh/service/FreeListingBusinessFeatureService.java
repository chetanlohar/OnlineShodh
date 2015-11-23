package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.FreeListingBusinessFeatureEntity;

public interface FreeListingBusinessFeatureService {
	public void saveFreeListingBusinessFeature(FreeListingBusinessFeatureEntity businessFeatureEntity);
	public List<FreeListingBusinessFeatureEntity> getAllFeturesByBusinessID(Long businessId);

}
