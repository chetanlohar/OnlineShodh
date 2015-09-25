package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.CategoryDao;
import com.onlineshodh.entity.CategoryEntity;

@Repository
public class CategoryDaoImpl extends AbstractJpaDao<CategoryEntity>implements CategoryDao {

	@Override
	public List<CategoryEntity> getAllCategories() {
		setClazz(CategoryEntity.class);
		return findAll();
	}

	@Override
	public void saveCategory(CategoryEntity category) {
		update(category);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoryEntity getCategoryById(Integer categoryId) {
		return findOne(categoryId);
	}
}
