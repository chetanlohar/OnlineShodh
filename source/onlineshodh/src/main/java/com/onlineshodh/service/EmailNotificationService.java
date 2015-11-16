package com.onlineshodh.service;

import com.onlineshodh.entity.BusinessEnquiryEntity;


public interface EmailNotificationService {
	
	public void sendEnquiryNotification(BusinessEnquiryEntity enquiry);

	
}
