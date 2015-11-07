package com.onlineshodh.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.PaymentDao;
import com.onlineshodh.entity.PaymentEntity;

@Repository
public class PaymentDaoImpl extends AbstractJpaDao<PaymentEntity> implements PaymentDao {

	 public Integer savePayment(PaymentEntity payment){
		create(payment);
	  return payment.getPaymentId();
	 }
}
