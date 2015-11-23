package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.FreeListingPhoneDao;
import com.onlineshodh.entity.FreeListingPhoneEntity;

@Repository
public class FreeListingPhoneDaoImpl extends
		AbstractJpaDao<FreeListingPhoneEntity> implements FreeListingPhoneDao {

	EntityManager em;

	@Override
	public void saveFreeListingPhoneDetails(FreeListingPhoneEntity phoneEntity) {
		create(phoneEntity);
	}

	@Override
	public List<FreeListingPhoneEntity> getAllFLBusinessPhonesByBusinessId(
			Long businessId) {
		em=getEntityManager();
		return em
				.createQuery(
						"from FreeListingPhoneEntity phones where freeListingBusinessEntity.freelistingbusinessdetailsId=:businessId",
						FreeListingPhoneEntity.class).setParameter(
						"businessId", businessId).getResultList();
	}
}