package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.PlanEntity;

public interface PlanService {

	public boolean savePlan(PlanEntity plan);
	public List<PlanEntity> getAllPlans();
    public PlanEntity getPlan(Integer planId);  
	public void deletePlan(Integer planId);
}
