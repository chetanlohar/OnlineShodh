package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.CountryDao;
import com.onlineshodh.entity.CountryEntity;
import com.onlineshodh.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	public CountryDao countryDao;
	
	@Override
	public List<CountryEntity> getAllCountries() {
		return countryDao.getAllCountries();
	}


	@Override
	@Transactional
	public void saveCountry(CountryEntity country) {
		countryDao.saveCountry(country);
	}

}
