package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.BannerDao;
import com.onlineshodh.entity.BannerEntity;
import com.onlineshodh.service.BannerService;

@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	BannerDao bannerDao;

	@Override
	@Transactional
	public Integer saveBanner(BannerEntity banner) {
		return bannerDao.saveBanner(banner);
		
	}
	@Override
	@Transactional
	public void updateBanner(BannerEntity banner) {
		bannerDao.updateBanner(banner);
	}
	

	@Override
	public List<BannerEntity> getAllBanners() {
		
		return bannerDao.getAllBanners();
	}

	@Override
	public BannerEntity getBannerById(Integer bannerId) {
		return bannerDao.getBannerById(bannerId);
	}

	@Override
	@Transactional
	public void deleteBanner(Integer bannerId) {
       bannerDao.deleteBanner(bannerId);		
	}

	@Override
	public List<BannerEntity> getBannerByBannerName(String bannerName) {
		
		return bannerDao.getBannerByBannerName(bannerName);
	}

	@Override
	public List<BannerEntity> getBanners(Integer CategoryId) {
		return bannerDao.getBanners(CategoryId);
	}

	
}
