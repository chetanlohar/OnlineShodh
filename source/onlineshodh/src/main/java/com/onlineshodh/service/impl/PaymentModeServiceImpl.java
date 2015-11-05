package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.PaymentModeDao;
import com.onlineshodh.entity.PaymentModeEntity;
import com.onlineshodh.service.PaymentModeService;

@Repository
public class PaymentModeServiceImpl implements PaymentModeService{

	@Autowired 
	PaymentModeDao paymentModeDao;
	
	@Override
	public List<PaymentModeEntity> getAllPaymentMode() {
		return paymentModeDao.getAllPaymentMode();
	}

	
	
}
