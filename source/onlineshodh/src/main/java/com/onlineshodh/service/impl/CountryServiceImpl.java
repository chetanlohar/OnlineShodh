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
	public boolean saveCountry(CountryEntity country) {
		return countryDao.saveCountry(country);
	}


	@Override
	@Transactional
	public CountryEntity getCountryById(Integer countryId) {
		return countryDao.getCountryById(countryId);
	}

	@Override
	@Transactional
	public void updateCountry(CountryEntity country) {
		countryDao.updateCountry(country);
	}


	@Override
	public CountryEntity getCountryByName(String countryName) {
		return countryDao.getCountryByName(countryName);
	}
}
