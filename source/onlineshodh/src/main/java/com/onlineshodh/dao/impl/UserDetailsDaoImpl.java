package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.UserDetailsDao;
import com.onlineshodh.entity.UserDetailsEntity;

@Repository
public class UserDetailsDaoImpl extends AbstractJpaDao<UserDetailsEntity> implements UserDetailsDao {

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

}
