package com.onlineshodh.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*Generic Abstract DAO class for Persistence/Database Operations*/
public abstract class AbstractJpaDao<T extends Serializable> {

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

	/* Selects the Entity (Record) from Persistence Storage for given id */
	public T findOne(Integer id) {
		return entityManager.find(clazz, id);
	}

	/* Selects the Entity (Record) from Persistence Storage for given id */
	public T findOne(Long id) {
		return entityManager.find(clazz, id);
	}

	/* Selects All the Entities (Record) from Persistence Storage for given name 
	@SuppressWarnings("unchecked")
	public List<T> findAll(String name)
	{
		return entityManager.createQuery("from "+clazz.getName()+" business where business.personName = :personName order by 1")
.setParameter("personName", name).getResultList();

	}*/

	/* Selects all the Entities (Records) from the Persistence Storage */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery(
				"from " + clazz.getName() + " order by 1").getResultList();
	}

	/* creates the new Entity (Record) in Persistence Storage */
	public void create(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	/* Updates the Existing Entity (Record) in Persistence Storage */
	public void update(T entity) {
		entityManager.merge(entity);
	}

	/* Deletes the Existing Entity (Record) from Persistence Storage */
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	/*
	 * Deletes the Existing Entity (Record) from Persistence Storage for given
	 * id
	 */
	public void deleteById(Integer id) {
		T entity = findOne(id);
		entityManager.remove(entity);
	}
	
	public void deleteById(Long id) {
		T entity = findOne(id);
		entityManager.remove(entity);
	}

}
