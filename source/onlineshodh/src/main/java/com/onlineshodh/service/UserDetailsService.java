package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.UserDetailsEntity;

/**
 * @author Softinfology - Chetan Lohar - (TL-Java)
 *
 */
public interface UserDetailsService {

	/**
	 * @param userDetails User Details to be stored in Persistance Storage
	 */
	public void saveUserDetails(UserDetailsEntity userDetails);
	
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
}
