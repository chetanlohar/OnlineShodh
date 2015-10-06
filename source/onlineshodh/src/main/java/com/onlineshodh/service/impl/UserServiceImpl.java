/**
 * 
 */
package com.onlineshodh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshodh.dao.UserDao;
import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.service.UserService;

/**
 * @author Softinfology - Chetan Lohar - (TL-Java)
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public void saveUser(UserEntity user) {
		userDao.saveUser(user);
	}

	
	@Override
	public UserEntity getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	
	@Override
	public void deleteUser(Integer userId) {
		userDao.deleteUser(userId);
	}

}
