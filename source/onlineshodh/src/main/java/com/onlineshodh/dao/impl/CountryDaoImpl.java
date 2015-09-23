package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.CountryDao;
import com.onlineshodh.entity.CountryEntity;

@Repository
public class CountryDaoImpl extends AbstractJpaDao<CountryEntity> implements CountryDao{

	EntityManager em;
	
	@Override
	public List<CountryEntity> getAllCountries() {
		setClazz(CountryEntity.class);
		return findAll();
	}

	@Override
	public boolean saveCountry(CountryEntity country) {
		/*if(getCountryByName(country.getCountryName())==null)
		{
			create(country);
			return true;
		}
		return false;*/
		create(country);
		return true;
	}

	@Override
	public CountryEntity getCountryById(Integer countryId) {
		setClazz(CountryEntity.class);
		return findOne(countryId);
	}

	@Override
	public void updateCountry(CountryEntity country) {
		setClazz(CountryEntity.class);
		update(country);
	}
	
	public CountryEntity getCountryByName(String countryName)
	{
		em = getEntityManager();
		String query = "select country.countryId from CountryEntity country where country.countryName= ?";
		Query query1 = em.createQuery(query);
		query1.setParameter(1, countryName);
		try
		{
			Integer countryid = (Integer) query1.getSingleResult();
			System.out.println(countryid);
			setClazz(CountryEntity.class);
			return findOne(countryid);
		}
		catch(NoResultException e)
		{
			System.out.println("Country Not available");
			return null;
		}
	}

	@Override
	public void deleteCountry(Integer countryId) {
		CountryEntity country = getCountryById(countryId);
		delete(country);
	}
}
