package com.onlineshodh.dao;
import java.util.List;

import com.onlineshodh.entity.StateEntity;

public interface StateDao {
	public boolean saveState(StateEntity stateEntity);
	public void updateState(StateEntity stateEntity);
	public List<StateEntity> getAllStates();
	public StateEntity getStateById(Integer stateId);
	public void deleteState(Integer stateId);
}
