package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.SubCategoryDao;
import com.onlineshodh.entity.SubCategoryEntity;

@Repository
public class SubCategoryDaoImpl extends AbstractJpaDao<SubCategoryEntity> implements SubCategoryDao {

	@Override
	public List<SubCategoryEntity> getAllSubCategories() {
		setClazz(SubCategoryEntity.class);
		return findAll();
	}

	@Override
	public void saveSubCategory(SubCategoryEntity subCategory) {
		update(subCategory);
	}

	@Override
	public SubCategoryEntity getSubCategoryById(Integer subCategoryId) {
		setClazz(SubCategoryEntity.class);
		return findOne(subCategoryId);
	}

	@Override
	public void deleteSubCategory(Integer subCategoryId) {
		deleteById(subCategoryId);
	}
}
