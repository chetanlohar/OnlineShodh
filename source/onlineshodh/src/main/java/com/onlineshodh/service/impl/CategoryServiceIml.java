package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.CategoryDao;
import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.service.CategoryService;

@Service
public class CategoryServiceIml implements CategoryService {

	@Autowired
	public CategoryDao categoryDao;
	
	@Override
	public List<CategoryEntity> getAllCategories() {
		return categoryDao.getAllCategories();
	}

	@Override
	@Transactional
	public void saveCategory(CategoryEntity category) {
		categoryDao.saveCategory(category);
	}
}
