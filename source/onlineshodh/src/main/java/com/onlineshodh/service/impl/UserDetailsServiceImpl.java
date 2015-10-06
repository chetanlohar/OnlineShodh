package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.UserDetailsDao;
import com.onlineshodh.entity.UserDetailsEntity;
import com.onlineshodh.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Override
	@Transactional
	public void saveUserDetails(UserDetailsEntity userDetails) {
		userDetailsDao.saveUserDetails(userDetails);
	}

	@Override
	public UserDetailsEntity getUserDetails(Integer userDetailsId) {
		return userDetailsDao.getUserDetails(userDetailsId);
	}

	@Override
	@Transactional
	public void deteteUserDetails(Integer userDetailsId) {
		userDetailsDao.deteteUserDetails(userDetailsId);
	}

	@Override
	public List<UserDetailsEntity> getAllUserDetails() {
		return userDetailsDao.getAllUserDetails();
	}

}
