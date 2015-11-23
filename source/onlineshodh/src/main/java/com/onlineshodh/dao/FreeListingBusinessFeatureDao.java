package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.FreeListingBusinessFeatureEntity;

public interface FreeListingBusinessFeatureDao {
public void saveFreeListingBusinessFeature(FreeListingBusinessFeatureEntity businessFeatureEntity);

public List<FreeListingBusinessFeatureEntity> getAllFeturesByBusinessID(Long businessId);

}
