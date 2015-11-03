package com.onlineshodh.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.BusinessPlanDao;
import com.onlineshodh.entity.BusinessPlanEntity;

@Repository
public class BusinessPlanDaoImpl extends AbstractJpaDao<BusinessPlanEntity> implements BusinessPlanDao{

	@Override
	public boolean assignBusinessPlan(BusinessPlanEntity businessPlan) {
		setClazz(BusinessPlanEntity.class);
		create(businessPlan);
		return true;
	}

}
