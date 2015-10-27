package com.onlineshodh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="business_address_details")
public class BusinessAddressEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_businessAddressId",sequenceName="seq_business_address_id",allocationSize=1)
	@GeneratedValue(generator="pk_businessAddressId",strategy=GenerationType.SEQUENCE)
	@Column(name="businessaddressid",nullable=false,unique=false)
	private Long businessAddressId;
	
	@ManyToOne(targetEntity=BusinessDetailsEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="businessId")
	private BusinessDetailsEntity business;
	
	@Column(name="addresstype")
	private String addressType;
	
	
	@ManyToOne(targetEntity=AddressEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="addressId")
	private AddressEntity address;


	/**
	 * @return the businessAddressId
	 */
	public Long getBusinessAddressId() {
		return businessAddressId;
	}


	/**
	 * @param businessAddressId the businessAddressId to set
	 */
	public void setBusinessAddressId(Long businessAddressId) {
		this.businessAddressId = businessAddressId;
	}


	/**
	 * @return the business
	 */
	public BusinessDetailsEntity getBusiness() {
		return business;
	}


	/**
	 * @param business the business to set
	 */
	public void setBusiness(BusinessDetailsEntity business) {
		this.business = business;
	}


	/**
	 * @return the addressType
	 */
	public String getAddressType() {
		return addressType;
	}


	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}


	/**
	 * @return the address
	 */
	public AddressEntity getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
}
