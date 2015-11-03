package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.BusinessDetailsDao;
import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.service.BusinessDetailsService;

@Service
public class BusinessDetailsServiceImpl implements BusinessDetailsService {

	@Autowired
	BusinessDetailsDao businessDetailsDao;

	@Override
	@Transactional
	public void saveBusinessDetails(BusinessDetailsEntity business) {
		businessDetailsDao.saveBusinessDetails(business);
	}

	@Override
	@Transactional
	public void updateBusinessDetails(BusinessDetailsEntity business) {
		// TODO Auto-generated method stub

	}

	@Override
	public BusinessDetailsEntity getBusinessDetails(Long businessId) {
		return businessDetailsDao.getBusinessDetails(businessId);
	}

	@Override
	public List<BusinessDetailsEntity> getBusinessDetais(String name) {
		return businessDetailsDao.getBusinessDetais(name);
	}

	

	@Override
	public List<BusinessDetailsEntity> getBusinessDetaisByUserName(
			String userName) {
		return businessDetailsDao.getBusinessDetaisByUserName(userName);
	}

	public List<BusinessDetailsEntity> getBusinessDetailsByBusinessName(String bussinessName){
		return businessDetailsDao.getBusinessDetailsByBusinessName(bussinessName);
	}

	@Override
	public List<BusinessDetailsEntity> getBusinessDetailsByUserDetailsId(
			Long userDetailsId) {
		return businessDetailsDao.getBusinessDetailsByUserDetailsId(userDetailsId);
	}

	@Override
	public List<BusinessDetailsEntity> findBusinessDetailsByBusinessName(
			String bussinessName) {
		return businessDetailsDao.findBusinessDetailsByBusinessName(bussinessName);
	}

	@Override
	public List<BusinessDetailsEntity> getAllBusinessDetais() {
		return businessDetailsDao.getAllBusinessDetais();
	}
}
