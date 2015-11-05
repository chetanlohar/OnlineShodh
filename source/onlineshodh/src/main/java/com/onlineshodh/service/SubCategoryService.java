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
	
	/**
	 * @param subCategory the subCategory to be save in Persistance Storage
	 */
	public void saveSubCategory(SubCategoryEntity subCategory);
	
	/**
	 * @param subCategoryId
	 * @return SubCategoryEntity of subCategoryId
	 */
	public SubCategoryEntity getSubCategoryById(Integer subCategoryId);
	
	/**
	 * @param subCategoryId SubCategory to delete
	 */
	public void deleteSubCategory(Integer subCategoryId);
	
	public List<SubCategoryEntity> listSubCategoriesByCategoryId(Integer categoryId);
	
	public SubCategoryEntity getSubCategory(String subCatName);
	
}
