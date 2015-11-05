package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.BannerEntity;

public interface BannerService {

	public void saveBanner(BannerEntity banner);
	public List<BannerEntity> getAllBanners();
	public BannerEntity getBannerById(Integer bannerId);
	public void deleteBanner(Integer bannerId);
/*	public List<BannerEntity> */ 
}
