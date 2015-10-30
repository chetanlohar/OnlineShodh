/**
 * 
 */
package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.SubCategoryDao;
import com.onlineshodh.entity.SubCategoryEntity;
import com.onlineshodh.service.SubCategoryService;

/**
 * @author Softinfology - Chetan Lohar (Team Lead - Java)
 *
 */
@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	SubCategoryDao subcategorydao;
	
	/* (non-Javadoc)
	 * @see com.onlineshodh.service.SubCategoryService#getAllSubCategories()
	 */
	@Override
	public List<SubCategoryEntity> getAllSubCategories() {
		return subcategorydao.getAllSubCategories();
	}

	/* (non-Javadoc)
	 * @see com.onlineshodh.service.SubCategoryService#saveSubCategory(com.onlineshodh.entity.SubCategoryEntity)
	 */
	@Override
	@Transactional
	public void saveSubCategory(SubCategoryEntity subCategory) {
		subcategorydao.saveSubCategory(subCategory);
	}

	@Override
	public SubCategoryEntity getSubCategoryById(Integer subCategoryId) {
		return subcategorydao.getSubCategoryById(subCategoryId);
	}

	@Override
	@Transactional
	public void deleteSubCategory(Integer subCategoryId) {
		subcategorydao.deleteSubCategory(subCategoryId);
	}

	@Override
	public List<SubCategoryEntity> listSubCategoriesByCategoryId(
			Integer categoryId) {
		return subcategorydao.listSubCategoriesByCategoryId(categoryId);
	}
}
