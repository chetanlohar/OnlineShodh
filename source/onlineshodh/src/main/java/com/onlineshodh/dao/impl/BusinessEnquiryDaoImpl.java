package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.BusinessEnquiryDao;
import com.onlineshodh.entity.BusinessEnquiryEntity;

@Repository
public class BusinessEnquiryDaoImpl extends AbstractJpaDao<BusinessEnquiryEntity> implements BusinessEnquiryDao {

	
	
	@Override
	public void saveEnquiry(BusinessEnquiryEntity entity) {
		create(entity);
	}

	@Override
	public BusinessEnquiryEntity getEnquiry(Long enquiryId) {
		setClazz(BusinessEnquiryEntity.class);
		return findOne(enquiryId);
	}

	@Override
	public List<BusinessEnquiryEntity> getAllEnquiries() {
		setClazz(BusinessEnquiryEntity.class);
		return findAll();
	}

}
