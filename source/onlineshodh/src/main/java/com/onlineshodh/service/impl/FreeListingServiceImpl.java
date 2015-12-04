package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.FreeListingDao;
import com.onlineshodh.entity.FreeListingBusinessEntity;
import com.onlineshodh.service.FreeListingService;

@Service
public class FreeListingServiceImpl implements FreeListingService {

	@Autowired
	FreeListingDao freeListingDao;
	
	@Override
	public Long saveFreeListingBusinessDetails(FreeListingBusinessEntity entity) {
		String businessName=entity.getBusinessName().toUpperCase();
		entity.setBusinessName(businessName);
		return freeListingDao.saveFreeListingBusinessDetails(entity);
	}
    @Override
    @Transactional
	public void updateFreeListingBusinessDetails(FreeListingBusinessEntity entity) 
	{
    	freeListingDao.updateFreeListingBusinessDetails(entity);
	}
	
	@Override
	public FreeListingBusinessEntity getFeelistingEntityById(Long freeListingId) {
		
		return freeListingDao.getFeelistingEntityById(freeListingId);
	}

	@Override
	public List<FreeListingBusinessEntity> getALlFreeListingBusiness() {
		
		return freeListingDao.getALlFreeListingBusiness();
	}
	@Override
	public List<FreeListingBusinessEntity> getAllFLBusinessById(
			Long freeListingId) {
		return freeListingDao.getAllFLBusinessById(freeListingId);
	}

}
