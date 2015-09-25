package com.onlineshodh.dao.impl;

import org.springframework.stereotype.Repository;
import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.CityDao;
import com.onlineshodh.entity.CityEntity;

@Repository
public class CityDaoImpl extends AbstractJpaDao<CityEntity> implements CityDao {

	
	@Override
	public void updateCity(CityEntity city) {
	 
		setClazz(CityEntity.class);
		update(city);
	}

}
