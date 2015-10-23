package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.UserDetailsEntity;

/**
 * @author Softinfology - Chetan Lohar - (TL-Java)
 *
 */
public interface UserDetailsDao {

	/**
	 * @param userDetails User Details to be stored in Persistance Storage
	 */
	public void saveUserDetails(UserDetailsEntity userDetails);
	
	/**
	 * @param userDetails Updates the User Details in Persistance Storage
	 */
	public void updateUserDetails(UserDetailsEntity userDetails);
	
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
	 * @return List of all User's Information
	 */
	public List<UserDetailsEntity> getAllUserDetails();
	
	public List<UserDetailsEntity> getUserDeatilsByName(String Name);
	
	public UserDetailsEntity getUserDetailsByUserId(Integer userId);
	
/*	public List<UserDetailsEntity> getBusinessDetailsByBusinessName(String bussinessName);
*/
	
	
	
}