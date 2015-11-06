package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.BusinessEnquiryEntity;

public interface BusinessEnquiryDao {

	public void saveEnquiry(BusinessEnquiryEntity entity);

	public BusinessEnquiryEntity getEnquiry(Long enquiryId);

	public List<BusinessEnquiryEntity> getAllEnquiries();

}
