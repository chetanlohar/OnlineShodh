package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.UserDetailsDao;
import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.entity.UserDetailsEntity;

@Repository
public class UserDetailsDaoImpl extends AbstractJpaDao<UserDetailsEntity>
		implements UserDetailsDao {

	EntityManager entityManager;

	@Override
	public void saveUserDetails(UserDetailsEntity userDetails) {
		create(userDetails);
	}

	@Override
	public UserDetailsEntity getUserDetails(Integer userDetailsId) {
		setClazz(UserDetailsEntity.class);
		return findOne(userDetailsId);
	}

	@Override
	public void deteteUserDetails(Integer userDetailsId) {
		setClazz(UserDetailsEntity.class);
		delete(findOne(userDetailsId));
	}

	@Override
	public List<UserDetailsEntity> getAllUserDetails() {
		setClazz(UserDetailsEntity.class);
		return findAll();
	}

	@Override
	public void updateUserDetails(UserDetailsEntity userDetails) {
		update(userDetails);
	}

	@SuppressWarnings("unchecked")
	public List<UserDetailsEntity> getUserDeatilsByName(String Name) {
		entityManager = getEntityManager();
		setClazz(UserDetailsEntity.class);
		return entityManager
				.createQuery(
						"from UserDetailsEntity userDetails where userDetails.name = :userName order by 1")
				.setParameter("userName", Name).getResultList();
	}

	@Override
	public UserDetailsEntity getUserDetailsByUserId(Integer userId) {
		entityManager = getEntityManager();
		return entityManager
				.createQuery(
						"from UserDetailsEntity userDetails where userDetails.userId=:userId",
						UserDetailsEntity.class).setParameter("userId", userId)
				.getSingleResult();
	}
	
	/*public List<UserDetailsEntity> getBusinessDetailsByBusinessName(String bussinessName){
		entityManager=getEntityManager();
		return  entityManager.createQuery("from BusinessDetailsEntity b  where b.businessName=:bussinessName ", UserDetailsEntity.class).setParameter("bussinessName", bussinessName).getResultList();	
		return entityManager.createQuery(" Select u from UserDetailsEntity u LEFT JOIN u.userDetailsId business where business.businessName=:businessName", UserDetailsEntity.class).setParameter("businessName",bussinessName).getResultList();
	
	 return entityManager.createQuery("from BusinessDetailsEntity b RIGHT OUTER JOIN b.userDetails  where b.businessName=:bussinessName ", UserDetailsEntity.class).setParameter("bussinessName", bussinessName).getResultList();	
	
	}*/

}
