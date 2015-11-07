package com.onlineshodh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.CheckDao;
import com.onlineshodh.entity.CheckEntity;
import com.onlineshodh.service.CheckService;

@Service
public class CheckServiceImpl implements CheckService{

	
	@Autowired
	CheckDao checkDao;
	
	@Override
	@Transactional
	public void saveCheck(CheckEntity checkEntity) {
		checkDao.saveCheck(checkEntity);
		
	}

	
}
