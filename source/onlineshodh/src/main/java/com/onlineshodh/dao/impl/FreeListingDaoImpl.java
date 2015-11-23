package com.onlineshodh.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.FreeListingDao;
import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.entity.FreeListingBusinessEntity;

@Repository
public class FreeListingDaoImpl extends AbstractJpaDao<FreeListingBusinessEntity> implements FreeListingDao {

	@Override
	@Transactional
	public Long saveFreeListingBusinessDetails(FreeListingBusinessEntity entity) {
		create(entity);
      Long freeListingBusinessEntityId=entity.getFreelistingbusinessdetailsId();
      return freeListingBusinessEntityId;
	}

	@Override
	public FreeListingBusinessEntity getFeelistingEntityById(Long freeListingId) {
		setClazz(FreeListingBusinessEntity.class);
		return findOne(freeListingId);
	}
}
