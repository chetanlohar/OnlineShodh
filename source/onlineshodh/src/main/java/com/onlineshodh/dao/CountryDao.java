package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.CountryEntity;

public interface CountryDao {
	
	public List<CountryEntity> getAllCountries();
	public void saveCountry(CountryEntity country);
}
