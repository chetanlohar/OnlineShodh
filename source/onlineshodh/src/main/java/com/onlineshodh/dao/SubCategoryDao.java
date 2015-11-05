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
	/**
	 * @param subCategory to be store in Persistance Storage
	 */
	public void saveSubCategory(SubCategoryEntity subCategory);
	
	/**
	 * @param subCategoryId
	 * @return SubCategoryEntity of given subCategoryId
	 */
	public SubCategoryEntity getSubCategoryById(Integer subCategoryId);
	
	/**
	 * @param subCategoryId SubCategory to delete
	 */
	public void deleteSubCategory(Integer subCategoryId);
	
	
	/**
	 * @param categoryId describes Category Id of the Selected Category
	 * @return List of All SubCategories for perticuler Category Id.
	 */
	public List<SubCategoryEntity> listSubCategoriesByCategoryId(Integer categoryId);
	
	public SubCategoryEntity getSubCategory(String subCatName);
}
