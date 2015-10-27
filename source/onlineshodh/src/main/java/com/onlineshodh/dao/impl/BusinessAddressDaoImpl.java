package com.onlineshodh.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.BusinessAddressDao;
import com.onlineshodh.entity.BusinessAddressEntity;

@Repository
public class BusinessAddressDaoImpl extends AbstractJpaDao<BusinessAddressEntity> implements BusinessAddressDao {

	EntityManager em;
	
	@Override
	public BusinessAddressEntity getBusinessAddressByBusinessId(Long businessId) {
		em = getEntityManager();
		return em.createQuery("from BusinessAddressEntity businessaddr where businessaddr.business.businessId = :businessId", BusinessAddressEntity.class).setParameter("businessId", businessId).getSingleResult();
	}

}
