package com.onlineshodh.dao.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.PaymentModeDao;
import com.onlineshodh.entity.PaymentModeEntity;

@Repository
public class PaymentModeDaoImpl extends AbstractJpaDao<PaymentModeEntity> implements PaymentModeDao {

	public List<PaymentModeEntity> getAllPaymentMode(){
		setClazz(PaymentModeEntity.class);
		return findAll();
	}
}
