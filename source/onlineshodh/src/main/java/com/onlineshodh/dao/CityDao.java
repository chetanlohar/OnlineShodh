package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.CityEntity;




public interface CityDao {
 
	public void updateCity(CityEntity cityEntity);
	public List<CityEntity> getAllCities();
	public List<CityEntity> getAllCities(Integer stateId);
	public CityEntity getCityById(Integer cityId);
	public void deleteCity(Integer cityId);
	
	
}
