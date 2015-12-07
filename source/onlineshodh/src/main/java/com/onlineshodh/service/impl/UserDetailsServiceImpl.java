package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.UserDetailsDao;
import com.onlineshodh.entity.UserDetailsEntity;
import com.onlineshodh.entity.UserEntity;
import com.onlineshodh.exception.ConstraintViolationException;
import com.onlineshodh.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Value("${alreadyExist}")
	String alreadyExist;
	
	@Value("${onlyDigits}")
	String onlyDigits;
	
	@Value("${onlyAlphabets}")
	String onlyAlphabets;
	
	@Override
	@Transactional
	public Integer saveUserDetails(UserDetailsEntity userDetails) throws ConstraintViolationException {
		Integer userdetailsId=0;
		try
		{
			userdetailsId=userDetailsDao.saveUserDetails(userDetails);
		}
		catch(DataIntegrityViolationException e)
		{
			if(e.getMostSpecificCause().getMessage().contains("chk_userdetails_name"))
				throw new ConstraintViolationException("userName",alreadyExist);
			else if(e.getMostSpecificCause().getMessage().contains("chk_userdetails_phone1"))
				throw new ConstraintViolationException("phone1",onlyDigits);
			else if(e.getMostSpecificCause().getMessage().contains("chk_userdetails_phone2"))
				throw new ConstraintViolationException("phone2",onlyDigits);
		}
		catch(Exception e)
		{
			throw new ConstraintViolationException("userName","**Invalid Data in Some Fields");
		}
		return userdetailsId;
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

	@Override
	@Transactional
	public void updateUserDetails(UserDetailsEntity userDetails)
			throws ConstraintViolationException {
		try
		{
			userDetailsDao.updateUserDetails(userDetails);
		}
		catch(DataIntegrityViolationException e)
		{
			if(e.getMostSpecificCause().getMessage().contains("chk_userdetails_name"))
				throw new ConstraintViolationException("userName",alreadyExist);
			else if(e.getMostSpecificCause().getMessage().contains("chk_userdetails_phone1"))
				throw new ConstraintViolationException("phone1",onlyDigits);
			else if(e.getMostSpecificCause().getMessage().contains("chk_userdetails_phone2"))
				throw new ConstraintViolationException("phone2",onlyDigits);
			else if(e.getMostSpecificCause().getMessage().contains("chk_userdetails_name"))
				throw new ConstraintViolationException("name",onlyAlphabets);
		}
	}

	@Override
	public List<UserDetailsEntity> getUserDeatilsByName(String Name) {
		return userDetailsDao.getUserDeatilsByName(Name);
	}

	@Override
	public UserDetailsEntity getUserDetailsByUserId(Integer userId) {
		return userDetailsDao.getUserDetailsByUserId(userId);
	}

	@Override
	public List<UserDetailsEntity> findUserDeatilsByName(String Name) {
		
		return userDetailsDao.findUserDeatilsByName(Name);
	}

	/*public List<UserDetailsEntity> getBusinessDetailsByBusinessName(String bussinessName){
		return userDetailsDao.getBusinessDetailsByBusinessName(bussinessName);
	}*/

	
}
