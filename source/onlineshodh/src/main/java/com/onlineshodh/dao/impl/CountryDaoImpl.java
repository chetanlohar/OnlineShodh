package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.CountryDao;
import com.onlineshodh.entity.CountryEntity;

@Repository
public class CountryDaoImpl extends AbstractJpaDao<CountryEntity> implements CountryDao{

	@Override
	public List<CountryEntity> getAllCountries() {
		setClazz(CountryEntity.class);
		return findAll();
	}

	@Override
	public void saveCountry(CountryEntity country) {
		create(country);
	}

}
