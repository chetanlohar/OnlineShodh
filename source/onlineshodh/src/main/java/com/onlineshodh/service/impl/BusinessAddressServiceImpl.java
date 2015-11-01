package com.onlineshodh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.BusinessAddressDao;
import com.onlineshodh.entity.BusinessAddressEntity;
import com.onlineshodh.service.BusinessAddressService;

@Service
public class BusinessAddressServiceImpl implements BusinessAddressService {

	@Autowired
	BusinessAddressDao businessAddressDao;
	
	@Override
	public BusinessAddressEntity getBusinessAddressByBusinessId(Long businessId) {
		return businessAddressDao.getBusinessAddressByBusinessId(businessId);
	}

	@Override
	@Transactional
	public void saveBusinessAddress(BusinessAddressEntity businessAddressEntity) {
		businessAddressDao.saveBusinessAddress(businessAddressEntity);
	}

}
