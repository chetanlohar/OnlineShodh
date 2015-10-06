/**
 * 
 */
package com.onlineshodh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.onlineshodh.dao.UserDao;
import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.exception.ConstraintViolationException;
import com.onlineshodh.service.UserService;

/**
 * @author Softinfology - Chetan Lohar - (TL-Java)
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Value("${alreadyExist}")
	String alreadyExist;
	
	@Value("${passwordLength}")
	String passwordLength;
	
	
	
	@Override
	public void saveUser(UserEntity user) throws ConstraintViolationException {
		try
		{
			userDao.saveUser(user);
		}
		catch(DataIntegrityViolationException e)
		{
			if(e.getMostSpecificCause().getMessage().contains("unq_users_username"))
				throw new ConstraintViolationException("userName",alreadyExist);
			else if(e.getMostSpecificCause().getMessage().contains("chk_users_password"))
				throw new ConstraintViolationException("password",passwordLength);
		}
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
