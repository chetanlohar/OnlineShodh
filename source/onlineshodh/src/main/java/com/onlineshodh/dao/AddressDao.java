package com.onlineshodh.dao;

import java.util.List;

import com.onlineshodh.entity.AddressEntity;

public interface AddressDao {

	public void saveAddress(AddressEntity address);

	public void updateAddress(AddressEntity address);

	public AddressEntity getAddress(Long addressId);
	
	public List<AddressEntity> getAllAddress();

}
