package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.CategoryDao;
import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.entity.CityEntity;

@Repository
public class CategoryDaoImpl extends AbstractJpaDao<CategoryEntity>implements CategoryDao {

	@Override
	public List<CategoryEntity> getAllCategories() {
		setClazz(CategoryEntity.class);
		return findAll();
	}

	@Override
	public void saveCategory(CategoryEntity category) {
		setClazz(CategoryEntity.class);
		update(category);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		deleteById(categoryId);
	}

	@Override
	public CategoryEntity getCategoryById(Integer categoryId) {
		return findOne(categoryId);
	}
}
