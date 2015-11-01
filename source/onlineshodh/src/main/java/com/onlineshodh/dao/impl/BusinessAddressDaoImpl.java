package com.onlineshodh.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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
		try
		{
			return em.createQuery("from BusinessAddressEntity businessaddr where businessaddr.business.businessId = :businessId", BusinessAddressEntity.class).setParameter("businessId", businessId).getSingleResult();
		}
		catch(NoResultException e)
		{
			System.out.println("No result Found..."+e.getMessage());
			return null;
		}
		
	}

	@Override
	public void saveBusinessAddress(BusinessAddressEntity businessAddressEntity) {
		create(businessAddressEntity);
	}

}
