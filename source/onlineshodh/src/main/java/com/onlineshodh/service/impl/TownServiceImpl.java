package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.TownDao;
import com.onlineshodh.entity.TownEntity;
import com.onlineshodh.service.TownService;
@Service
public class TownServiceImpl implements TownService{

	@Autowired
    TownDao townDao; 
	
	@Override
	@Transactional
	public void updateTown(TownEntity town) {
		String townName=town.getTownName().toUpperCase();
		town.setTownName(townName);
		townDao.updateTown(town);
	}

	@Override
	public List<TownEntity> getAllTowns() {
		
		return townDao.getAllTowns();
	}

	@Override
	public TownEntity getTownById(Integer townId) {
		
		return townDao.getTownById(townId);
	}

	@Override
	@Transactional
	public void deleteTown(Integer townId) {
		townDao.deleteTown(townId);
		
	}
	
	@Override
	public List<TownEntity> getAllTowns(Integer cityId) {
		return townDao.getAllTowns(cityId);
	}

	@Override
	public Integer getLastTown() {
		
		return townDao.getLastTown() ;
	}

	

}
