package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.StateDao;
import com.onlineshodh.entity.StateEntity;

@Repository
public class StateDaoImpl extends AbstractJpaDao<StateEntity> implements StateDao {

	EntityManager em;
	
	@Override
	public boolean saveState(StateEntity state) {
		create(state);
		return true;
	}

	@Override
	public void updateState(StateEntity state) {
		setClazz(StateEntity.class);
		update(state);
		
	}

	@Override
	@Cacheable(value="state")
	public List<StateEntity> getAllStates() {
		setClazz(StateEntity.class);
		return findAll();
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	@Cacheable(value="state")
	public List<StateEntity> getAllStates(Integer countryId) {
		em = getEntityManager();
		String query = "from StateEntity state where state.country.countryId = :countryId";
		List<StateEntity> result = em.createQuery(query)
		.setParameter("countryId",countryId)
		.getResultList();
		return result;
	}
	
	@Override
	public StateEntity getStateById(Integer stateId) {
		setClazz(StateEntity.class);
		return findOne(stateId);
	}

	@Override
	public void deleteState(Integer stateId) {
		StateEntity state = getStateById(stateId);
		delete(state);
	}

}
