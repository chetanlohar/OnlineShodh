package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.UserDao;
import com.onlineshodh.entity.UserEntity;

@Repository
public class UserDaoImpl extends AbstractJpaDao<UserEntity> implements UserDao {

	EntityManager entityManager;

	@Override
	@Transactional
	public void saveUser(UserEntity user) {
		create(user);
	}

	@Override
	public UserEntity getUserById(Integer userId) {
		setClazz(UserEntity.class);
		return findOne(userId);
	}

	@Override
	@Transactional
	public void deleteUser(Integer userId) {
		setClazz(UserEntity.class);
		delete(findOne(userId));
	}

	@Override
	public boolean isUserExists(String username) {

		String query = "from UserEntity user where user.userName=?";
		entityManager = getEntityManager();
		TypedQuery<UserEntity> query1 = entityManager.createQuery(query,
				UserEntity.class);
		query1.setParameter(1, username.trim());
		UserEntity userentity = null;
		try {
			userentity = query1.getSingleResult();
			if (userentity != null)
				return true;
		} catch (javax.persistence.NoResultException e) {
			System.out
					.println("Session Expired...No result found for userid(null)");
			return false;
		}
		return false;
	}

	@Override
	public List<UserEntity> getUserByName(String userName) {

		
		entityManager = getEntityManager();
		return entityManager
				.createQuery(
						"from UserEntity user where user.userName LIKE :userName",
						UserEntity.class).setParameter("userName", userName+'%')
				.getResultList();
	}

	@Override
	public UserEntity getUserByUserName(String userName) {
		entityManager = getEntityManager();
		return entityManager
				.createQuery(
						"from UserEntity user where user.userName=:userName",
						UserEntity.class).setParameter("userName", userName)
				.getSingleResult();
	}

}
