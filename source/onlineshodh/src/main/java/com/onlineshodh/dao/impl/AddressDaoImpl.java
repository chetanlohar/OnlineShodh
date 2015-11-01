package com.onlineshodh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.AbstractJpaDao;
import com.onlineshodh.dao.AddressDao;
import com.onlineshodh.entity.AddressEntity;

@Repository
public class AddressDaoImpl extends AbstractJpaDao<AddressEntity> implements AddressDao {

	EntityManager em;
	
	@Override
	public void saveAddress(AddressEntity address) {
		create(address);
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

	//get Last Entity
		public Long getLastAddress(){
			em=getEntityManager();
			return em.createQuery("select max(add.addressId)from AddressEntity add",Long.class).getSingleResult();
		}

}
