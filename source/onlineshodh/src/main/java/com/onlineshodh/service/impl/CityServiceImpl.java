package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.CityDao;
import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	CityDao cityDao;
	
	
	@Override
	@Transactional
	public void updateCity(CityEntity city) {
		String cityName=city.getCityName().toUpperCase();
		city.setCityName(cityName);
		cityDao.updateCity(city);
	}


	@Override
	public List<CityEntity> getAllCities() {
		return cityDao.getAllCities();
	}


	@Override
	public CityEntity getCityById(Integer cityId) {
		return cityDao.getCityById(cityId);
	}


	@Override
	@Transactional
	public void deleteCity(Integer cityId) {
		cityDao.deleteCity(cityId);
	}


	@Override
	public List<CityEntity> getAllCities(Integer stateId) {
		return cityDao.getAllCities(stateId);
	}

	
}
