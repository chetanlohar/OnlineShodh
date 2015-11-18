package com.onlineshodh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshodh.dao.FreeListingDao;
import com.onlineshodh.entity.FreeListingBusinessEntity;
import com.onlineshodh.service.FreeListingService;

@Service
public class FreeListingServiceImpl implements FreeListingService {

	@Autowired
	FreeListingDao freeListingDao;
	
	@Override
	public void saveFreeListingBusinessDetails(FreeListingBusinessEntity entity) {
		freeListingDao.saveFreeListingBusinessDetails(entity);
	}

}
