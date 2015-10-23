package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.BusinessDetailsDao;
import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.UserDetailsEntity;

@Repository
public class BusinessDetailsDaoImpl extends
		AbstractJpaDao<BusinessDetailsEntity> implements BusinessDetailsDao {

	EntityManager entityManager;

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
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessDetailsEntity> getBusinessDetais(String name) {
		entityManager = getEntityManager();
		setClazz(BusinessDetailsEntity.class);
		return entityManager
				.createQuery(
						"from BusinessDetailsEntity business where business.personName = :personName order by 1")
				.setParameter("personName", name).getResultList();
		 //return findAll(name) ;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessDetailsEntity> getBusinessDetaisByUserName(
			String userName) {
		entityManager = getEntityManager();
		setClazz(BusinessDetailsEntity.class);
		return entityManager
				.createQuery(
						"from BusinessDetailsEntity business where business.userDetails.user.userName = :userName order by 1")
				.setParameter("userName", userName).getResultList();
		// return findAll(name) ;
	}

	public List<BusinessDetailsEntity> getBusinessDetailsByBusinessName(String bussinessName){
		entityManager=getEntityManager();
		return entityManager.createQuery("from BusinessDetailsEntity business where business.businessName=:businessName", BusinessDetailsEntity.class).setParameter("businessName",bussinessName).getResultList();
	       
	}
	
	

}
