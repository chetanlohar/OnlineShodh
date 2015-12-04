package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.FreeListingAddressDao;
import com.onlineshodh.entity.FreeListingAddressEntity;
import com.onlineshodh.service.FreeListingAddressService;

@Service
public class FreeListingAddresServiceImpl implements FreeListingAddressService {

	@Autowired
	FreeListingAddressDao freeListingAddressDao;
	
	@Override
	@Transactional
	public void saveFreeListingAddress(FreeListingAddressEntity address) {
		freeListingAddressDao.saveFreeListingAddress(address);
	}

	@Override
	public List<FreeListingAddressEntity> getBusinessFeatureDetailByBusinessId(
			Long businessId) {
		
		return freeListingAddressDao.getBusinessFeatureDetailByBusinessId(businessId);
	}

}
