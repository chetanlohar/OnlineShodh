package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.TownEntity;

public interface TownDao{

	public void updateTown(TownEntity town); 
	public List<TownEntity> getAllTowns();
	public TownEntity getTownById(Integer townId);
	public void deleteTown(Integer townId);
	
}
