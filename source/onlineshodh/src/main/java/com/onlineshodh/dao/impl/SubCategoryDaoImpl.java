package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.SubCategoryDao;
import com.onlineshodh.entity.SubCategoryEntity;

@Repository
public class SubCategoryDaoImpl extends AbstractJpaDao<SubCategoryEntity> implements SubCategoryDao {

	EntityManager em;
	
	@Override
	public List<SubCategoryEntity> getAllSubCategories() {
		setClazz(SubCategoryEntity.class);
		return findAll();
	}

	@Override
	public void saveSubCategory(SubCategoryEntity subCategory) {
		update(subCategory);
	}

	@Override
	public SubCategoryEntity getSubCategoryById(Integer subCategoryId) {
		setClazz(SubCategoryEntity.class);
		return findOne(subCategoryId);
	}

	@Override
	public void deleteSubCategory(Integer subCategoryId) {
		deleteById(subCategoryId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubCategoryEntity> listSubCategoriesByCategoryId(
			Integer categoryId) {
		em = getEntityManager();
		String query = "from SubCategoryEntity subcategory where subcategory.category.categoryId = :categoryId";
		List<SubCategoryEntity> result = em.createQuery(query).setParameter("categoryId",categoryId).getResultList();
		return result;
	}

	@Override
	public SubCategoryEntity getSubCategory(String subCatName) {
		em = getEntityManager();
		String query = "from SubCategoryEntity subcategory where subcategory.subCategoryName = :subCatName";
		SubCategoryEntity result = em.createQuery(query,SubCategoryEntity.class).setParameter("subCatName",subCatName).getSingleResult();
		return result;
	}
}
