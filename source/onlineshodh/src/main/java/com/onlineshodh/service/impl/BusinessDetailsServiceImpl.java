package com.onlineshodh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshodh.dao.BusinessDetailsDao;
import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.service.BusinessDetailsService;

@Service
public class BusinessDetailsServiceImpl implements BusinessDetailsService {

	@Autowired
	BusinessDetailsDao businessDetailsDao;
	
	@Override
	public void saveBusinessDetails(BusinessDetailsEntity business) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBusinessDetails(BusinessDetailsEntity business) {
		// TODO Auto-generated method stub

	}

	@Override
	public BusinessDetailsEntity getBusinessDetails(Long businessId) {
		return businessDetailsDao.getBusinessDetails(businessId);
	}

}
