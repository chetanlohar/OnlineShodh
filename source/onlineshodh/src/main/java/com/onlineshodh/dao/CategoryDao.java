package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.CategoryEntity;

public interface CategoryDao {
	
	public List<CategoryEntity> getAllCategories();
	public void saveCategory(CategoryEntity category);
}
