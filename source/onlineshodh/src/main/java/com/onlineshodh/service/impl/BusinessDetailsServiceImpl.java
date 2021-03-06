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
	public Long saveBusinessDetails(BusinessDetailsEntity business){
		if (business.getBusinessId() != null)
		{
			 businessDetailsDao.updateBusinessDetails(business);
			 return business.getBusinessId();
		}
		else
		{
			business.setAddress(null);
			return businessDetailsDao.saveBusinessDetails(business);
		}
		
	}

	@Override
	@Transactional
	public void updateBusinessDetails(BusinessDetailsEntity business) {
		businessDetailsDao.updateBusinessDetails(business);

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

	@Override
	public List<BusinessDetailsEntity> getBusinessBySubCategoryId(Long subCatId) {
		return businessDetailsDao.getBusinessBySubCategoryId(subCatId);
	}

	@Override
	public List<BusinessDetailsEntity> getBusinessByCategoryId(Long catId) {
		return businessDetailsDao.getBusinessByCategoryId(catId);
	}
}
