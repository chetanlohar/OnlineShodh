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
/*@Scope("prototype")*/
@Entity
@Table(name="business_generalinfo_details")
public class BusinessGeneralInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_generalInfoId",sequenceName="seq_business_generalinfo_id",allocationSize=1)
	@GeneratedValue(generator="pk_generalInfoId",strategy=GenerationType.SEQUENCE)
	@Column(name="generalinfoid",nullable=false,unique=true)
	private Long businessGenInfoId;
	
	@Column(name="generalinfoname",nullable=false)
	@NotNull(message="Information Needed!")
	private String generalInfoName;
	
	@ManyToOne(targetEntity=BusinessDetailsEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="businessId")
	private BusinessDetailsEntity business;

	/**
	 * @return the businessGenInfoId
	 */
	public Long getBusinessGenInfoId() {
		return businessGenInfoId;
	}

	/**
	 * @param businessGenInfoId the businessGenInfoId to set
	 */
	public void setBusinessGenInfoId(Long businessGenInfoId) {
		this.businessGenInfoId = businessGenInfoId;
	}

	/**
	 * @return the generalInfoName
	 */
	public String getGeneralInfoName() {
		return generalInfoName;
	}

	/**
	 * @param generalInfoName the generalInfoName to set
	 */
	public void setGeneralInfoName(String generalInfoName) {
		this.generalInfoName = generalInfoName;
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
		return "BusinessGeneralInfoEntity [businessGenInfoId="
				+ businessGenInfoId + ", generalInfoName=" + generalInfoName
				+ ", business=" + business + "]";
	}
}
