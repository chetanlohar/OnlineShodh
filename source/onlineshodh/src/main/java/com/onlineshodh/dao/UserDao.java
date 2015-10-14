package com.onlineshodh.dao;

import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.exception.ConstraintViolationException;

/**
 * @author Softinfology - Chetan Lohar (TL-Java)
 * Describes the User Services of the User
 */
public interface UserDao {
	
	/**
	 * @param user describes the User Information which 
	 * will be stored in Database
	 * @throws ConstraintViolationException 
	 */
	public void saveUser(UserEntity user) throws ConstraintViolationException;
	
	/**
	 * @param userId is the userId of the User
	 * @return UserEntity Object for given userId
	 */
	public UserEntity getUserById(Integer userId);
	
	/**
	 * @param userId is the userId of the User
	 * Delete the User for the given userId
	 */
	public void deleteUser(Integer userId);
	
	/**
	 * @param username Username to Check that already exists or not.
	 * @return True if Exists and False if not exists
	 */
	public boolean isUserExists(String username);

}
