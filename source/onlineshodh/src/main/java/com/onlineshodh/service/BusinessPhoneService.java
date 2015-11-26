package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.BusinessPhoneEntity;

public interface BusinessPhoneService {
	
	public void saveBusinessPhoneDetails(BusinessPhoneEntity entity);
	
	public void updateBusinessPhoneDetails(BusinessPhoneEntity entity);
	
	public List<BusinessPhoneEntity> getBusinessPhoneDetailByBusinessId(Long businessId);
	
	public List<BusinessPhoneEntity> getAllBusinessPhoneDetails();
	
	public BusinessPhoneEntity getBusinessPhoneDetails(Long businessPhoneId);

	public BusinessPhoneEntity getBusinessPhoneByPhoneId(Long phoneId);
}
