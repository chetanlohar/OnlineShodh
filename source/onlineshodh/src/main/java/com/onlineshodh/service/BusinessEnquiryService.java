package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.BusinessEnquiryEntity;

public interface BusinessEnquiryService {
	
	public void saveEnquiry(BusinessEnquiryEntity entity);
	
	public BusinessEnquiryEntity getEnquiry(Long enquiryId);
	
	public List<BusinessEnquiryEntity> getAllEnquiries();
	

}
