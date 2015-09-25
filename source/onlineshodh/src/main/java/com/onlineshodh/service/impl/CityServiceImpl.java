package com.onlineshodh.service.impl;

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

	
}
