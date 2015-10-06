package com.onlineshodh.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.UserDao;
import com.onlineshodh.entity.UserEntity;

@Repository
public class UserDaoImpl extends AbstractJpaDao<UserEntity> implements UserDao {

	@Override
	@Transactional
	public void saveUser(UserEntity user) {
		update(user);
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

}
