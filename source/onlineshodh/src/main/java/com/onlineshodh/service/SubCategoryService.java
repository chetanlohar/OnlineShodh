/**
 * 
 */
package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.SubCategoryEntity;

/**
 * @author Softinfology - Chetan Lohar (Team Lead - Java)
 *
 */
public interface SubCategoryService {

	/**
	 * @return List of all SubCategories
	 */
	public List<SubCategoryEntity> getAllSubCategories();
	
}
