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
@Table(name="freelisting_business_phone_details")
public class FreeListingPhoneEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_freelistingphoneid",sequenceName="seq_freelistingphonedetails_phoneid",allocationSize=1)
	@GeneratedValue(generator="pk_freelistingphoneid",strategy=GenerationType.SEQUENCE)
	@Column(name="flbusinessphoneid",nullable=false,unique=true)
	private Long freeBuinessPhoneId;
	
	@Column(name="flbusinessphone")
	@NotNull(message="Phone Number is Mandatory!")
	private String phone;
	
	@Column(name="flbusinessphonetype")
	@NotNull(message="Phone Type is Mandatory!")
	private String phonetype;
	
	@ManyToOne(targetEntity=FreeListingBusinessEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="freelistingbusinessdetailsId")
	private FreeListingBusinessEntity freeListingBusinessEntity;

	public Long getFreeBuinessPhoneId() {
		return freeBuinessPhoneId;
	}

	public void setFreeBuinessPhoneId(Long freeBuinessPhoneId) {
		this.freeBuinessPhoneId = freeBuinessPhoneId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhonetype() {
		return phonetype;
	}

	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}

	public FreeListingBusinessEntity getFreeListingBusinessEntity() {
		return freeListingBusinessEntity;
	}

	public void setFreeListingBusinessEntity(
			FreeListingBusinessEntity freeListingBusinessEntity) {
		this.freeListingBusinessEntity = freeListingBusinessEntity;
	}

	@Override
	public String toString() {
		return "FreeListingPhoneEntity [freeBuinessPhoneId="
				+ freeBuinessPhoneId + ", phone=" + phone + ", phonetype="
				+ phonetype + ", freeListingBusinessEntity="
				+ freeListingBusinessEntity + "]";
	}

	
	
	
	
}
