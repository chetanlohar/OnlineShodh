package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.BusinessPhoneDao;
import com.onlineshodh.entity.BusinessPhoneEntity;
import com.onlineshodh.service.BusinessPhoneService;

@Service
public class BusinessPhoneServiceImpl implements BusinessPhoneService {

	@Autowired
	BusinessPhoneDao businessphoneDao;
	
	@Override
	@Transactional
	public void saveBusinessPhoneDetails(BusinessPhoneEntity entity) {
		businessphoneDao.saveBusinessPhoneDetails(entity);
	}
	
	@Override
	@Transactional
	public void updateBusinessPhoneDetails(BusinessPhoneEntity entity) {
		businessphoneDao.updateBusinessPhoneDetails(entity);
	}

	@Override
	public List<BusinessPhoneEntity> getBusinessPhoneDetailByBusinessId(
			Long businessId) {
		return businessphoneDao.getBusinessPhoneDetailByBusinessId(businessId);
	}

	@Override
	public List<BusinessPhoneEntity> getAllBusinessPhoneDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessPhoneEntity getBusinessPhoneDetails(Long businessPhoneId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessPhoneEntity getBusinessPhoneByPhoneId(Long phoneId) {
		return businessphoneDao.getBusinessPhoneByPhoneId(phoneId);
	}

	@Override
	@Transactional
	public void deleteBusinessPhone(Long phoneId) {
		businessphoneDao.deleteBusinessPhone(phoneId);
	}

	

}
