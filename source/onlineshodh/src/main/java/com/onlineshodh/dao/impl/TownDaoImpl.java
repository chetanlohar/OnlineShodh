package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.TownDao;
import com.onlineshodh.entity.TownEntity;

@Repository
public class TownDaoImpl extends AbstractJpaDao<TownEntity> implements TownDao {

	EntityManager em;
	
	@Override
	public void updateTown(TownEntity town) {
		setClazz(TownEntity.class);
		update(town);
	}
	
	@Override
	public void saveTown(TownEntity town) {
		create(town);
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
	
	// get Towns By CityId
		@Override
		@SuppressWarnings("unchecked")
		public List<TownEntity> getAllTowns(Integer cityId) {
			em = getEntityManager();
			return em
					.createQuery(
							"from TownEntity town where town.city.cityId =:cityId")
					.setParameter("cityId", cityId).getResultList();

		}

		@Override
		public Integer getLastTown(){
			em=getEntityManager();
			return em.createQuery("select max(town.townId)from TownEntity town",Integer.class).getSingleResult();
		}

		@Override
		public List<TownEntity> getTownsByCityName(String cityName) {
			em=getEntityManager();
			return em.createQuery("from TownEntity town where town.city.cityName like ?",TownEntity.class).setParameter(1, cityName).getResultList();
		}

	

}
