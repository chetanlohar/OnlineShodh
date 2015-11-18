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
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="business_phone_details")
public class BusinessPhoneEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_businessphoneid",sequenceName="seq_businessdetails_businessid",allocationSize=1)
	@GeneratedValue(generator="pk_businessphoneid",strategy=GenerationType.SEQUENCE)
	@Column(name="businessphonedetailsid",nullable=false,unique=true)
	private Long buinessPhoneId;
	
	@Column(name="phone")
	@NotNull(message="Phone Number is Mandatory!")
	private String phone;
	
	@Column(name="phonetype")
	@NotNull(message="Phone Type is Mandatory!")
	private String phonetype;
	
	@ManyToOne(targetEntity=BusinessDetailsEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="businessId")
	private BusinessDetailsEntity business;

	/**
	 * @return the buinessPhoneId
	 */
	public Long getBuinessPhoneId() {
		return buinessPhoneId;
	}

	/**
	 * @param buinessPhoneId the buinessPhoneId to set
	 */
	public void setBuinessPhoneId(Long buinessPhoneId) {
		this.buinessPhoneId = buinessPhoneId;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return the phonetype
	 */
	public String getPhonetype() {
		return phonetype;
	}

	/**
	 * @param phonetype the phonetype to set
	 */
	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusinessPhoneEntity [buinessPhoneId=" + buinessPhoneId
				+ ", phone=" + phone + ", business=" + business + "]";
	}

}
