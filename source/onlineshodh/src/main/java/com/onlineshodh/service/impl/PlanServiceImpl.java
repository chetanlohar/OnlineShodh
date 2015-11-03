package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.PlanDao;
import com.onlineshodh.entity.BusinessPlanEntity;
import com.onlineshodh.entity.PlanEntity;
import com.onlineshodh.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService  {

	@Autowired
	PlanDao planDao;
	
	@Override
	@Transactional
	public boolean savePlan(PlanEntity plan) {
	
	 String planName=plan.getPlanName().toUpperCase();
     plan.setPlanName(planName);          
    return planDao.savePlan(plan);
		
	}

	@Override
	public List<PlanEntity> getAllPlans() {
		return planDao.getAllPlans();
	}

	@Override
	public PlanEntity getPlan(Integer planId) {
		return planDao.getPlan(planId);
	}

	@Override
	@Transactional
	public void deletePlan(Integer planId) {
		planDao.deletePlan(planId);
	}
}
