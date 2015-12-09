package com.onlineshodh.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.CategoryDao;
import com.onlineshodh.entity.CategoryEntity;
import com.onlineshodh.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

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

	@Override
	@Transactional
	public void deleteCategory(Integer categoryId) {
		
		CategoryEntity categoryToDelete = categoryDao.getCategoryById(categoryId);
		try {
			File file = new File(categoryToDelete.getPath());
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		categoryDao.deleteCategory(categoryToDelete);
	}

	@Override
	public CategoryEntity getCategoryById(Integer categoryId) {
		return categoryDao.getCategoryById(categoryId);
	}
}
