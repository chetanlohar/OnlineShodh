package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.FreeListingDao;
import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.entity.FreeListingBusinessEntity;

@Repository
public class FreeListingDaoImpl extends
		AbstractJpaDao<FreeListingBusinessEntity> implements FreeListingDao {

	EntityManager em;

	@Override
	@Transactional
	public Long saveFreeListingBusinessDetails(FreeListingBusinessEntity entity) {
		create(entity);
		Long freeListingBusinessEntityId = entity
				.getFreelistingbusinessdetailsId();
		return freeListingBusinessEntityId;
	}

	@Override
	public void updateFreeListingBusinessDetails(
			FreeListingBusinessEntity entity) {
		update(entity);
	}

	@Override
	public FreeListingBusinessEntity getFeelistingEntityById(Long freeListingId) {
		setClazz(FreeListingBusinessEntity.class);
		return findOne(freeListingId);
	}

	@Override
	public List<FreeListingBusinessEntity> getALlFreeListingBusiness() {
		setClazz(FreeListingBusinessEntity.class);
		return findAll();
	}

	@Override
	public List<FreeListingBusinessEntity> getAllFLBusinessById(
			Long freeListingId) {
		em = getEntityManager();
		return em
				.createQuery(
						"from FreeListingBusinessEntity FLB where FLB.freelistingbusinessdetailsId=:freeListingId",
						FreeListingBusinessEntity.class)
				.setParameter("freeListingId", freeListingId).getResultList();
	}
}
