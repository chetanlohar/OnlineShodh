package com.onlineshodh.service;

import java.util.List;


import com.onlineshodh.entity.StateEntity;

public interface StateService {
	public boolean saveState(StateEntity stateEntity);
	public void updateState(StateEntity state);
    public List<StateEntity> getAllStates(); 	
    public List<StateEntity> getAllStates(Integer countryId);
    public StateEntity getStateById(Integer stateId);
    public void deleteState(Integer stateId);
}
