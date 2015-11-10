package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.BusinessDetailsDao;
import com.onlineshodh.entity.BusinessDetailsEntity;

@Repository
public class BusinessDetailsDaoImpl extends
		AbstractJpaDao<BusinessDetailsEntity> implements BusinessDetailsDao {

	EntityManager entityManager;

	@Override
	public void saveBusinessDetails(BusinessDetailsEntity business) {
		create(business);
	}

	@Override
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
		// return findAll(name) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessDetailsEntity> getBusinessDetaisByUserName(
			String userName) {
		entityManager = getEntityManager();
		setClazz(BusinessDetailsEntity.class);
		return entityManager
				.createQuery(
						"from BusinessDetailsEntity business where business.userDetails.user.userName=:userName")
				.setParameter("userName", userName).getResultList();
		// return findAll(name) ;
	}

	public List<BusinessDetailsEntity> getBusinessDetailsByBusinessName(
			String bussinessName) {
		entityManager = getEntityManager();
		return entityManager
				.createQuery(
						"from BusinessDetailsEntity business where lower(business.businessName) Like :businessName",
						BusinessDetailsEntity.class)
				.setParameter("businessName", '%' + bussinessName + '%')
				.getResultList();

	}

	@Override
	public List<BusinessDetailsEntity> getBusinessDetailsByUserDetailsId(
			Long userDetailsId) {

		entityManager = getEntityManager();
		setClazz(BusinessDetailsEntity.class);
		return entityManager
				.createQuery(
						"from BusinessDetailsEntity business where business.userDetails.userDetailsId = :userDetailsId",
						BusinessDetailsEntity.class)
				.setParameter("userDetailsId", userDetailsId.intValue())
				.getResultList();
	}

	@Override
	public List<BusinessDetailsEntity> findBusinessDetailsByBusinessName(
			String bussinessName) {
		entityManager = getEntityManager();
		return entityManager
				.createQuery(
						"from BusinessDetailsEntity business where lower(business.businessName)=:businessName",
						BusinessDetailsEntity.class)
				.setParameter("businessName", bussinessName.toLowerCase()).getResultList();
	}

	@Override
	public List<BusinessDetailsEntity> getAllBusinessDetais() {
		setClazz(BusinessDetailsEntity.class);
		return findAll();
	}

	@Override
	public List<BusinessDetailsEntity> getBusinessBySubCategoryId(Long subCatId) {
		entityManager = getEntityManager();
		String query = "from BusinessDetailsEntity business where business.subCategory.subCategoryId = :subCatId";
		return entityManager.createQuery(query, BusinessDetailsEntity.class).setParameter("subCatId", subCatId.intValue()).getResultList();
	}

	@Override
	public List<BusinessDetailsEntity> getBusinessByCategoryId(Long catId) {
		entityManager = getEntityManager();
		String query = "from BusinessDetailsEntity business where business.subCategory.category.categoryId = :catId";
		return entityManager.createQuery(query, BusinessDetailsEntity.class).setParameter("catId", catId.intValue()).getResultList();
	}

}
