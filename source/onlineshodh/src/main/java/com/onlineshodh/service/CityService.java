package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.CityEntity;


public interface CityService {

	public void updateCity(CityEntity city);
	public List<CityEntity> getAllCities();
	public List<CityEntity> getAllCities(Integer stateId);
	public CityEntity getCityById(Integer cityId);
	public void deleteCity(Integer cityId);
}
