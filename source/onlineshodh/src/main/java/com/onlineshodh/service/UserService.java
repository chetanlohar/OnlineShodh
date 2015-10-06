package com.onlineshodh.service;

import com.onlineshodh.entity.UserEntity;

/**
 * @author Softinfology - Chetan Lohar (TL-Java)
 * Describes the User Services of the User
 */
public interface UserService {
	
	/**
	 * @param user describes the User Information which 
	 * will be stored in Database
	 */
	public void saveUser(UserEntity user);
	
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

}
