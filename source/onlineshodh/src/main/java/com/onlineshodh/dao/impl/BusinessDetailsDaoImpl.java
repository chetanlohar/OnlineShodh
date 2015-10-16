package com.onlineshodh.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.BusinessDetailsDao;
import com.onlineshodh.entity.BusinessDetailsEntity;

@Repository
public class BusinessDetailsDaoImpl extends AbstractJpaDao<BusinessDetailsEntity> implements BusinessDetailsDao {

	@Override
	@Transactional
	public void saveBusinessDetails(BusinessDetailsEntity business) {
		create(business);
	}

	@Override
	@Transactional
	public void updateBusinessDetails(BusinessDetailsEntity business) {
		update(business);
	}

	@Override
	public BusinessDetailsEntity getBusinessDetails(Long businessId) {
		setClazz(BusinessDetailsEntity.class);
		return findOne(businessId);
	}

}
