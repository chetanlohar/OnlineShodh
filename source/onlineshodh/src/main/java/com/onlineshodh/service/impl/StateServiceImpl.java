package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.StateDao;
import com.onlineshodh.entity.StateEntity;
import com.onlineshodh.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	public StateDao stateDao;

	@Override
	@Transactional
	public boolean saveState(StateEntity stateEntity) {

		String stateName = stateEntity.getStateName().toUpperCase();
		stateEntity.setStateName(stateName);
		return stateDao.saveState(stateEntity);
	}

	@Override
	@Transactional
	public void updateState(StateEntity state) {
		String stateName=state.getStateName().toUpperCase();
		state.setStateName(stateName);
		stateDao.updateState(state);
	}

	@Override
	public List<StateEntity> getAllStates() {
		
		return stateDao.getAllStates();
	}

	@Override
	public StateEntity getStateById(Integer stateId) {
		
		return stateDao.getStateById(stateId);
	}

	@Override
	@Transactional
	public void deleteState(Integer stateId) {
		stateDao.deleteState(stateId);
	}

}
