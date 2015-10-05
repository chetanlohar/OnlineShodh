package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.CityDao;
import com.onlineshodh.entity.CityEntity;



@Repository
public class CityDaoImpl extends AbstractJpaDao<CityEntity> implements CityDao {

	EntityManager em;
	
	@Override
	public void updateCity(CityEntity city) {
	 
		setClazz(CityEntity.class);
		update(city);
	}

	@Override
	public List<CityEntity> getAllCities() {
		setClazz(CityEntity.class);
		return findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityEntity> getAllCities(Integer stateId) {
		em = getEntityManager();
		String query = "from CityEntity city where city.state.stateId = :stateId";
		List<CityEntity> result = em.createQuery(query)
				.setParameter("stateId",stateId)
				.getResultList();
		return result;
	}
	@Override
	public CityEntity getCityById(Integer cityId) {
		setClazz(CityEntity.class);
		return findOne(cityId);
	}

	@Override
	public void deleteCity(Integer cityId) {
		
		CityEntity city=getCityById(cityId);
		delete(city);
	}

	

	

}
