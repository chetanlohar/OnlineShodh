package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.BannerDao;
import com.onlineshodh.entity.BannerEntity;


@Repository
public class BannerDaoImpl extends AbstractJpaDao<BannerEntity> implements BannerDao{

	 EntityManager entityManager;
	
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

	@Override
	public List<BannerEntity> getBannerByBannerName(String bannerName) {
			entityManager = getEntityManager();
			return entityManager
					.createQuery(
							"from BannerEntity banner where lower(banner.bannerName) Like :bannerName",
							BannerEntity.class)
					.setParameter("businessName", bannerName + '%')
					.getResultList();
	}
	
}
