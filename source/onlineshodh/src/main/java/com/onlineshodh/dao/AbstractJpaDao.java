package com.onlineshodh.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*Generic Abstract DAO class for Persistence/Database Operations*/
public abstract class AbstractJpaDao<T extends Serializable>{
	
	private Class<T> clazz;
	EntityManager entityManager;
	
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/*Selects the Entity (Record) from Persistence Storage for given id*/
	public T findOne(Integer id)
	{
		return entityManager.find(clazz, id);
	}
	
	/*Selects all the Entities (Records) from the Persistence Storage*/
	@SuppressWarnings("unchecked")
	public List<T> findAll()
	{
		return entityManager.createQuery("from "+clazz.getName()).getResultList();
	}
	
	/*creates the new Entity (Record) in Persistence Storage*/
	public void create(T entity)
	{
		entityManager.persist(entity);
	}
	
	/*Updates the Existing Entity (Record) in Persistence Storage*/
	public void update(T entity)
	{
		entityManager.merge(entity);
	}
	
	/*Deletes the Existing Entity (Record) from Persistence Storage*/
	public void delete(T entity)
	{
		entityManager.remove(entity);
	}
	
	/*Deletes the Existing Entity (Record) from Persistence Storage for given id*/
	public void deleteById(Integer id)
	{
		T entity = findOne(id);
		entityManager.remove(entity);
	}
	
}
