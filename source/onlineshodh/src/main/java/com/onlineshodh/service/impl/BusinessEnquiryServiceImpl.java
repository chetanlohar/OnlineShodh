package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.BusinessEnquiryDao;
import com.onlineshodh.entity.BusinessEnquiryEntity;
import com.onlineshodh.service.BusinessEnquiryService;

@Service
public class BusinessEnquiryServiceImpl implements BusinessEnquiryService {

	@Autowired
	BusinessEnquiryDao businessEnquiryDao;
	
	@Override
	@Transactional
	public void saveEnquiry(BusinessEnquiryEntity entity) {
		businessEnquiryDao.saveEnquiry(entity);

	}

	@Override
	public BusinessEnquiryEntity getEnquiry(Long enquiryId) {
		return businessEnquiryDao.getEnquiry(enquiryId);
	}

	@Override
	public List<BusinessEnquiryEntity> getAllEnquiries() {
		return businessEnquiryDao.getAllEnquiries();
	}

}
