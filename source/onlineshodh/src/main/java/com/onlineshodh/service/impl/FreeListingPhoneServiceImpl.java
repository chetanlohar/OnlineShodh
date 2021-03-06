package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.FreeListingPhoneDao;
import com.onlineshodh.entity.FreeListingPhoneEntity;
import com.onlineshodh.service.FreeListingPhoneService;

@Service
public class FreeListingPhoneServiceImpl implements FreeListingPhoneService {

	@Autowired
	FreeListingPhoneDao freeListingPhoneDao;
	
	@Override
	@Transactional
	public void saveFreeListingPhoneDetails(FreeListingPhoneEntity phoneEntity) {
		freeListingPhoneDao.saveFreeListingPhoneDetails(phoneEntity);
	}

	@Override
	public List<FreeListingPhoneEntity> getAllFLBusinessPhonesByBusinessId(
			Long businessId) {
		
		return freeListingPhoneDao.getAllFLBusinessPhonesByBusinessId(businessId);
	}

	@Override
	@Transactional
	public void updateFreeListingPhoneDetails(FreeListingPhoneEntity phoneEntity) {
	
		freeListingPhoneDao.updateFreeListingPhoneDetails(phoneEntity);
		
	}

	@Override
	@Transactional
	public void deletePhone(Long phoneId) {
		
		freeListingPhoneDao.deletePhone(phoneId);
	}

	@Override
	public FreeListingPhoneEntity getPhoneById(Long phoneId)  {
		return freeListingPhoneDao.getPhoneById(phoneId);
	}

}
