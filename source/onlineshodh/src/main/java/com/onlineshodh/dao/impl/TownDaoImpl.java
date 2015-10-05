package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.TownDao;

import com.onlineshodh.entity.TownEntity;

@Repository
public class TownDaoImpl extends AbstractJpaDao<TownEntity> implements TownDao {

	
	@Override
	public void updateTown(TownEntity town) {
		setClazz(TownEntity.class);
		update(town);
	}

	@Override
	public List<TownEntity> getAllTowns() {
		setClazz(TownEntity.class);
		return findAll();
	}

	@Override
	public TownEntity getTownById(Integer townId) {
		setClazz(TownEntity.class);
		return findOne(townId);
	}

	@Override
	public void deleteTown(Integer townId) {
		TownEntity town=getTownById(townId);
		delete(town);
	}

}
