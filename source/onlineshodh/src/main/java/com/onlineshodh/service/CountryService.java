package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.CountryEntity;

public interface CountryService {
	
	public List<CountryEntity> getAllCountries();
	public boolean saveCountry(CountryEntity country);
	public CountryEntity getCountryById(Integer countryId);
	public void updateCountry(CountryEntity country);
	public void deleteCountry(Integer countryId);
	public CountryEntity getCountryByName(String countryName);

}
