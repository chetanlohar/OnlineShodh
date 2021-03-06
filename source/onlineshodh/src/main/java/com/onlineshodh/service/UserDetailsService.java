package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.UserDetailsEntity;
import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.exception.ConstraintViolationException;

/**
 * @author Softinfology - Chetan Lohar - (TL-Java)
 *
 */
public interface UserDetailsService {

	/**
	 * @param userDetails User Details to be stored in Persistance Storage
	 * @return 
	 * @throws ConstraintViolationException 
	 */
	public Integer saveUserDetails(UserDetailsEntity userDetails) throws ConstraintViolationException;
	
	
	/**
	 * @param userDetails Updates the User Details in Persistance Storage
	 * @throws ConstraintViolationException
	 */
	public void updateUserDetails(UserDetailsEntity userDetails) throws ConstraintViolationException;
	
	/**
	 * @param userDetailsId User Details Id to get the details of User's Details
	 * @return User Details
	 */
	public UserDetailsEntity getUserDetails(Integer userDetailsId);
	
	/**
	 * @param userDetailsId to delete the Userdetails for user
	 */
	public void deteteUserDetails(Integer userDetailsId);
	
	/**
	 * @return List of All the User's Information
	 */
	public List<UserDetailsEntity> getAllUserDetails();
	
	public List<UserDetailsEntity> getUserDeatilsByName(String Name);
	
	public List<UserDetailsEntity> findUserDeatilsByName(String Name);
	
	public UserDetailsEntity getUserDetailsByUserId(Integer userId);
	
/*	public List<UserDetailsEntity> getBusinessDetailsByBusinessName(String bussinessName);
*/
}
