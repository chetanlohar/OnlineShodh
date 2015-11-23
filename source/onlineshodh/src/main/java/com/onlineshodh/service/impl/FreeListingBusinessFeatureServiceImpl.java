package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.FreeListingBusinessFeatureDao;
import com.onlineshodh.entity.FreeListingBusinessFeatureEntity;
import com.onlineshodh.service.FreeListingBusinessFeatureService;


@Service
public class FreeListingBusinessFeatureServiceImpl implements FreeListingBusinessFeatureService {

	@Autowired
	FreeListingBusinessFeatureDao freeListingBusinessFeatureDao;
	
	@Override
	@Transactional
	public void saveFreeListingBusinessFeature(
			FreeListingBusinessFeatureEntity businessFeatureEntity) {
		freeListingBusinessFeatureDao.saveFreeListingBusinessFeature(businessFeatureEntity);
	}

	@Override
	public List<FreeListingBusinessFeatureEntity> getAllFeturesByBusinessID(Long businessId) {
		return freeListingBusinessFeatureDao.getAllFeturesByBusinessID(businessId);
	}

	
}
