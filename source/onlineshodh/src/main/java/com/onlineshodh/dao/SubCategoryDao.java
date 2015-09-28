/**
 * 
 */
package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.SubCategoryEntity;

/**
 * @author Softinfology - Chetan Lohar - (Team Lead - Java)
 *
 */
public interface SubCategoryDao {
	
	/**
	 * @return List of all SubCategories from the Persistence Storage
	 */
	public List<SubCategoryEntity> getAllSubCategories();

}
