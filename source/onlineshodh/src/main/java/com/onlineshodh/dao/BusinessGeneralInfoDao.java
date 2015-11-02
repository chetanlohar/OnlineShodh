package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.BusinessGeneralInfoEntity;

public interface BusinessGeneralInfoDao {
	
public void saveBusinessGeneralInfo(BusinessGeneralInfoEntity entity);
	
	public void updateBusinessGeneralInfo(BusinessGeneralInfoEntity entity);
	
	public void deleteBusinessGeneralInfo(Long businessGeneralInfo);
	
	public List<BusinessGeneralInfoEntity> getBusinessGeneralInfoByBusinessId(Long businessId);
	
	public List<BusinessGeneralInfoEntity> getAllBusinessGeneralInfo();
	
	public BusinessGeneralInfoEntity getBusinessGeneralInfo(Long businessGeneralInfo);

}
