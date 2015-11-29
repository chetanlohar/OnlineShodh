package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.BannerEntity;


public interface BannerDao  {
	public void saveBanner(BannerEntity banner);
	public List<BannerEntity> getAllBanners();
	public BannerEntity getBannerById(Integer bannerId); 
	public void deleteBanner(Integer bannerId);
	public List<BannerEntity> getBannerByBannerName(
			String bannerName);
	public List<BannerEntity> getBanners(Integer CategoryId);
}
