package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.impl.BusinessGeneralInfoDaoImpl;
import com.onlineshodh.entity.BusinessGeneralInfoEntity;
import com.onlineshodh.service.BusinessGeneralInfoService;

@Service
public class BusinessGeneralInfoServiceImpl implements
		BusinessGeneralInfoService {

	@Autowired
	BusinessGeneralInfoDaoImpl busiGenInfoDao;
	
	@Override
	@Transactional
	public void saveBusinessGeneralInfo(BusinessGeneralInfoEntity entity) {
		busiGenInfoDao.saveBusinessGeneralInfo(entity);
	}

	@Override
	@Transactional
	public void updateBusinessGeneralInfo(BusinessGeneralInfoEntity entity) {
		busiGenInfoDao.update(entity);
	}

	@Override
	@Transactional
	public void deleteBusinessGeneralInfo(Long businessGeneralInfo) {
		busiGenInfoDao.deleteBusinessGeneralInfo(businessGeneralInfo);
	}

	@Override
	public List<BusinessGeneralInfoEntity> getBusinessGeneralInfoByBusinessId(
			Long businessId) {
		return busiGenInfoDao.getBusinessGeneralInfoByBusinessId(businessId);
	}

	@Override
	public List<BusinessGeneralInfoEntity> getAllBusinessGeneralInfo() {
		return busiGenInfoDao.getAllBusinessGeneralInfo();
	}

	@Override
	public BusinessGeneralInfoEntity getBusinessGeneralInfo(
			Long businessGeneralInfo) {
		return busiGenInfoDao.getBusinessGeneralInfo(businessGeneralInfo);
	}

}
