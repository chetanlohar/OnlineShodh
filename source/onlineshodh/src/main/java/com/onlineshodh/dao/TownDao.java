package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.TownEntity;

public interface TownDao{

	public void updateTown(TownEntity town); 
	public List<TownEntity> getAllTowns();
	public TownEntity getTownById(Integer townId);
	public void deleteTown(Integer townId);
	public List<TownEntity> getAllTowns(Integer cityId);
	public Integer getLastTown();
	void saveTown(TownEntity town);
	public List<TownEntity> getTownsByCityName(String cityName);
}
