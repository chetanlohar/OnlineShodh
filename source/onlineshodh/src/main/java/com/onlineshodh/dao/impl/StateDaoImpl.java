package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.StateDao;
import com.onlineshodh.entity.CountryEntity;
import com.onlineshodh.entity.StateEntity;

@Repository
public class StateDaoImpl extends AbstractJpaDao<StateEntity> implements StateDao {

	@Override
	public boolean saveState(StateEntity state) {
		create(state);
		return true;
	}

	@Override
	public void updateState(StateEntity state) {
		setClazz(StateEntity.class);
		update(state);
		
	}

	@Override
	public List<StateEntity> getAllStates() {
		setClazz(StateEntity.class);
		return findAll();
	}

	@Override
	public StateEntity getStateById(Integer stateId) {
		setClazz(StateEntity.class);
		return findOne(stateId);
	}

	@Override
	public void deleteState(Integer stateId) {
		StateEntity state = getStateById(stateId);
		delete(state);
	}

}
