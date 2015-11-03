package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.PlanDao;
import com.onlineshodh.entity.BusinessPlanEntity;
import com.onlineshodh.entity.PlanEntity;

@Repository
public class PlanDoaImpl extends AbstractJpaDao<PlanEntity> implements PlanDao{

	@Override
	public boolean savePlan(PlanEntity plan) {
		 update(plan);
		 return true;
	}

	@Override
	public List<PlanEntity> getAllPlans() {
		setClazz(PlanEntity.class);
		return findAll();
	}

	@Override
	public PlanEntity getPlan(Integer planId) {
		setClazz(PlanEntity.class);
		return findOne(planId);
	}

	@Override
	public void deletePlan(Integer planId) {
	PlanEntity planEntity=getPlan(planId);
 	delete(planEntity);
	}

	
	
}
