package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.BusinessPhoneDao;
import com.onlineshodh.entity.BusinessPhoneEntity;

@Repository
public class BusinessPhoneDaoImpl extends AbstractJpaDao<BusinessPhoneEntity> implements BusinessPhoneDao {

	EntityManager em;
	
	@Override
	public void saveBusinessPhoneDetails(BusinessPhoneEntity entity) {
		create(entity);
	}

	@Override
	public void updateBusinessPhoneDetails(BusinessPhoneEntity entity) {
		update(entity);
	}
	
	@Override
	public List<BusinessPhoneEntity> getBusinessPhoneDetailByBusinessId(
			Long businessId) {
		em = getEntityManager();
		String qry = "from BusinessPhoneEntity businessphone where businessphone.business.businessId=:businessId order by 1";
		return em.createQuery(qry,BusinessPhoneEntity.class).setParameter("businessId", businessId).getResultList();
	}

	@Override
	public List<BusinessPhoneEntity> getAllBusinessPhoneDetails() {
		return findAll();
	}

	@Override
	public BusinessPhoneEntity getBusinessPhoneDetails(Long businessPhoneId) {
		return findOne(businessPhoneId);
	}

	@Override
	public BusinessPhoneEntity getBusinessPhoneByPhoneId(Long phoneId) {
	setClazz(BusinessPhoneEntity.class);
	return findOne(phoneId);
	}

	@Override
	public void deleteBusinessPhone(Long phoneId) {
		setClazz(BusinessPhoneEntity.class);
		BusinessPhoneEntity entity=findOne(phoneId);
		delete(entity);
	}

	

}
