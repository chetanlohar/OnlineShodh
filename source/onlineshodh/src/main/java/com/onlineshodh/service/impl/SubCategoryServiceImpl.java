/**
 * 
 */
package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
