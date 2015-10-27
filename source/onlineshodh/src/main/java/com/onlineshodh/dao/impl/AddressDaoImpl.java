package com.onlineshodh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.AddressDao;
import com.onlineshodh.entity.AddressEntity;
import com.onlineshodh.entity.BusinessDetailsEntity;

@Repository
public class AddressDaoImpl extends AbstractJpaDao<AddressEntity> implements AddressDao {

	@Override
	public void saveAddress(AddressEntity address) {
		update(address);
	}

	@Override
	public void updateAddress(AddressEntity address) {
		update(address);
	}

	@Override
	public AddressEntity getAddress(Long addressId) {
		setClazz(AddressEntity.class);
		return findOne(addressId);
	}

	@Override
	public List<AddressEntity> getAllAddress() {
		setClazz(AddressEntity.class);
		return findAll();
	}
}
