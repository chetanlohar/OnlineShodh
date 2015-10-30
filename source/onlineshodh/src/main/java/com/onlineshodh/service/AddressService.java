package com.onlineshodh.service;

import java.util.List;

import com.onlineshodh.entity.AddressEntity;

public interface AddressService {
	
	public void saveAddress(AddressEntity address);
	
	public void updateAddress(AddressEntity address);
	
	public AddressEntity getAddress(Long addressId);
	
	public List<AddressEntity> getAllAddress();
	
	public Long getLastAddress();


}
