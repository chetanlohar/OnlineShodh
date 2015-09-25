package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.CategoryEntity;

public interface CategoryService {
	
	public List<CategoryEntity> getAllCategories();
	public void saveCategory(CategoryEntity category);
	public void deleteCategory(Integer categoryId);
	public CategoryEntity getCategoryById(Integer categoryId);
}
