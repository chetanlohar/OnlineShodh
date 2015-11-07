package com.onlineshodh.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.CheckDao;
import com.onlineshodh.entity.CheckEntity;

@Repository
public class CheckDaoImpl extends AbstractJpaDao<CheckEntity> implements CheckDao{

	@Override
	public void saveCheck(CheckEntity checkEntity) {
		create(checkEntity);
	}

	
}
