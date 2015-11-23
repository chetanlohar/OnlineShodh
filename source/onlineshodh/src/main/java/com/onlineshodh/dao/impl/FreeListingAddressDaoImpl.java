package com.onlineshodh.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.FreeListingAddressDao;
import com.onlineshodh.entity.FreeListingAddressEntity;

@Repository
public class FreeListingAddressDaoImpl extends AbstractJpaDao<FreeListingAddressEntity> implements FreeListingAddressDao{

	@Override
	public void saveFreeListingAddress(FreeListingAddressEntity address) {
		setClazz(FreeListingAddressEntity.class);
		create(address);
	}

	
}
