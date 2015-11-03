package com.onlineshodh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.BusinessPlanDao;
import com.onlineshodh.entity.BusinessPlanEntity;
import com.onlineshodh.service.BusinessPlanService;

@Service
public class BusinessPlanServiceImpl implements BusinessPlanService{

	@Autowired
	BusinessPlanDao businessPlanDao; 
	@Override
	@Transactional
	public boolean assignBusinessPlan(BusinessPlanEntity businessPlan) {
		return businessPlanDao.assignBusinessPlan(businessPlan);
	}

	
}
