package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.BannerDao;
import com.onlineshodh.entity.BannerEntity;

@Repository
public class BannerDaoImpl extends AbstractJpaDao<BannerEntity> implements BannerDao{

	@Override
	public void saveBanner(BannerEntity banner) {
		update(banner);
	}

	@Override
	public List<BannerEntity> getAllBanners() {
		setClazz(BannerEntity.class);
		return findAll();
	}

	@Override
	public BannerEntity getBannerById(Integer bannerId) {
		
		return findOne(bannerId);
	}

	@Override
	public void deleteBanner(Integer bannerId) {
		BannerEntity bannerEntity=getBannerById(bannerId);
		delete(bannerEntity); 
	}
}
