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
}
