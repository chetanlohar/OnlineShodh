package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.CountryEntity;

public interface CountryService {
	
	public List<CountryEntity> getAllCountries();
	public void saveCountry(CountryEntity country);

}
