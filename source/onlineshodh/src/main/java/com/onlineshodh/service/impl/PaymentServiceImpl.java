package com.onlineshodh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.PaymentDao;
import com.onlineshodh.entity.PaymentEntity;
import com.onlineshodh.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao paymentDao;

	@Override
	@Transactional
	public void savePayment(PaymentEntity payment) {
		paymentDao.savePayment(payment);
	}
	
}
