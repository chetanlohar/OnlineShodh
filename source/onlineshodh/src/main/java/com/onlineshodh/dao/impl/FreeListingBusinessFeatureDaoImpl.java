package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.FreeListingBusinessFeatureDao;
import com.onlineshodh.entity.FreeListingBusinessFeatureEntity;

@Repository
public class FreeListingBusinessFeatureDaoImpl extends
		AbstractJpaDao<FreeListingBusinessFeatureEntity> implements
		FreeListingBusinessFeatureDao {

	EntityManager em;

	@Override
	public void saveFreeListingBusinessFeature(
			FreeListingBusinessFeatureEntity businessFeatureEntity) {
		create(businessFeatureEntity);
	}

	@Override
	public List<FreeListingBusinessFeatureEntity> getAllFeturesByBusinessID(Long businessId) {
		em = getEntityManager();
		return em.createQuery("from FreeListingBusinessFeatureEntity where business.freelistingbusinessdetailsId=:businessId", FreeListingBusinessFeatureEntity.class)
				.setParameter("businessId", businessId).getResultList();
	}

	@Override
	public FreeListingBusinessFeatureEntity getFeature(Long featureId) {
		setClazz(FreeListingBusinessFeatureEntity.class);
		return findOne(featureId);
	}

	@Override
	public void updateFLBFeature(FreeListingBusinessFeatureEntity featureEntity) {
		update(featureEntity);
	}

	@Override
	@Transactional
	public void deleteFLBFeature(Long featureId) {
		FreeListingBusinessFeatureEntity featureEntity=getFeature(featureId);
		delete(featureEntity);
		
	}

}
