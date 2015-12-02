package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.BusinessGeneralInfoDao;
import com.onlineshodh.entity.BusinessGeneralInfoEntity;

@Repository
public class BusinessGeneralInfoDaoImpl extends AbstractJpaDao<BusinessGeneralInfoEntity> implements BusinessGeneralInfoDao {

	EntityManager em;
	
	@Override
	public void saveBusinessGeneralInfo(BusinessGeneralInfoEntity entity) {
		create(entity);
	}

	@Override
	public void updateBusinessGeneralInfo(BusinessGeneralInfoEntity entity) {
		update(entity);
	}

	@Override
	public void deleteBusinessGeneralInfo(Long businessGeneralInfo) {
		setClazz(BusinessGeneralInfoEntity.class);
		deleteById(businessGeneralInfo);
	}

	@Override
	public List<BusinessGeneralInfoEntity> getBusinessGeneralInfoByBusinessId(
			Long businessId) {
		em = getEntityManager();
		String qry = "from BusinessGeneralInfoEntity info where info.business.businessId=:businessId";
		return em.createQuery(qry, BusinessGeneralInfoEntity.class).setParameter("businessId", businessId).getResultList();
	}

	@Override
	public List<BusinessGeneralInfoEntity> getAllBusinessGeneralInfo() {
		setClazz(BusinessGeneralInfoEntity.class);
		return findAll();
	}

	@Override
	public BusinessGeneralInfoEntity getBusinessGeneralInfo(
			Long businessGeneralInfo) {
		setClazz(BusinessGeneralInfoEntity.class);
		return findOne(businessGeneralInfo);
	}

}
