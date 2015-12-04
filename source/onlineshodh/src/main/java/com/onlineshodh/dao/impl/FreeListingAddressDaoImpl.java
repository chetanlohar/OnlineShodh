package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.FreeListingAddressDao;
import com.onlineshodh.entity.BusinessPhoneEntity;
import com.onlineshodh.entity.FreeListingAddressEntity;

@Repository
public class FreeListingAddressDaoImpl extends AbstractJpaDao<FreeListingAddressEntity> implements FreeListingAddressDao{
 
	EntityManager em=getEntityManager();
      	
	@Override
	public void saveFreeListingAddress(FreeListingAddressEntity address) {
		setClazz(FreeListingAddressEntity.class);
		create(address);
	}

	@Override
	public List<FreeListingAddressEntity> getBusinessFeatureDetailByBusinessId(
			Long businessId) {
		em = getEntityManager();
		String qry = "from FreeListingAddressEntity businessaddress where businessaddress.businessEntity.freelistingbusinessdetailsId=:businessId order by 1";
		return em.createQuery(qry,FreeListingAddressEntity.class).setParameter("businessId", businessId).getResultList();
	}	
	
}
