package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.SubCategoryDao;
import com.onlineshodh.entity.SubCategoryEntity;

@Repository
@Cacheable(value = { "categoryCache" })
public class SubCategoryDaoImpl extends AbstractJpaDao<SubCategoryEntity> implements SubCategoryDao {

	EntityManager em;
	
	@Override
	public List<SubCategoryEntity> getAllSubCategories() {
		setClazz(SubCategoryEntity.class);
		return findAll();
	}

	@Override
	public Integer saveSubCategory(SubCategoryEntity subCategory) {
		create(subCategory);
		return subCategory.getSubCategoryId();
	}

	@Override
	public void updateSubCategory(SubCategoryEntity subCategory) {
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
	@Cacheable(value="categoryCache")
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
		String query = "from SubCategoryEntity subcategory where lower(subcategory.subCategoryName) = :subCatName";
		SubCategoryEntity result = em.createQuery(query,SubCategoryEntity.class).setParameter("subCatName",subCatName.trim().toLowerCase()).getSingleResult();
		return result;
	}

	
}
