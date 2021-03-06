package com.onlineshodh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.dao.AddressDao;
import com.onlineshodh.entity.AddressEntity;
import com.onlineshodh.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao addressDao;
	
	@Override
	@Transactional
	public void saveAddress(AddressEntity address) {
		addressDao.saveAddress(address);
	}

	@Override
	public AddressEntity getAddress(Long addressId) {
		return addressDao.getAddress(addressId);
	}

	@Override
	public List<AddressEntity> getAllAddress() {
		return addressDao.getAllAddress();
	}

	@Override
	@Transactional
	public void updateAddress(AddressEntity address) {
		addressDao.updateAddress(address);
	}
	
	@Override
	public Long getLastAddress(){
		
		return addressDao.getLastAddress();
	}
}
