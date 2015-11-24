package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.FreeListingBusinessFeatureEntity;

public interface FreeListingBusinessFeatureDao {
public void saveFreeListingBusinessFeature(FreeListingBusinessFeatureEntity businessFeatureEntity);

public void updateFLBFeature(FreeListingBusinessFeatureEntity featureEntity);

public List<FreeListingBusinessFeatureEntity> getAllFeturesByBusinessID(Long businessId);

public FreeListingBusinessFeatureEntity getFeature(Long featureId);

public void deleteFLBFeature(Long featureId);

}
