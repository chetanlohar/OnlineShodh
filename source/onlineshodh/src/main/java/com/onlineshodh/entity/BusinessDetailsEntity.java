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

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="business_details")
public class BusinessDetailsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Describes Business ID
	 */
	@Id
	@Column(name="businessid",unique=true,nullable=false)
	@SequenceGenerator(name="pk_businessid",sequenceName="seq_businessdetails_businessid")
	@GeneratedValue(generator="pk_businessid",strategy=GenerationType.SEQUENCE)
	private Long businessId;
	
	/**
	 * Describes Business Name
	 */
	@Column(name="businessname",nullable=false)
	@NotEmpty(message="Business Name is Mandatory!")
	private String businessName;
	
	/**
	 * Describes Name of The Person associated with Business
	 */
	@Column(name="personname",nullable=false)
	@NotEmpty(message="Person Name is Mandatory")
	private String personName;
	
	/**
	 * Describes Business Email
	 */
	@Column(name="email",nullable=false)
	@NotEmpty(message="Email is Mandatory")
	private String email;
	
	/**
	 * Describes Business Website
	 */
	@Column(name="website")
	private String website;
	
	@Column(name="businessdesc",nullable=false)
	@NotEmpty(message="Business Description is Mandatory!")
	private String businessDesc;
	
	/**
	 * Describes Sub-Category of the Business
	 */
	@ManyToOne(targetEntity=SubCategoryEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="subCategoryId")
	private SubCategoryEntity subCategory;
	
	/**
	 * Describes the User Information of the Business
	 */
	@ManyToOne(targetEntity=UserDetailsEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="userDetailsId")
	private UserDetailsEntity userDetails;

	/**
	 * @return the businessId
	 */
	public Long getBusinessId() {
		return businessId;
	}

	/**
	 * @param businessId the businessId to set
	 */
	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	/**
	 * @return the businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the businessDesc
	 */
	public String getBusinessDesc() {
		return businessDesc;
	}

	/**
	 * @param businessDesc the businessDesc to set
	 */
	public void setBusinessDesc(String businessDesc) {
		this.businessDesc = businessDesc;
	}

	/**
	 * @return the subCategory
	 */
	public SubCategoryEntity getSubCategory() {
		return subCategory;
	}

	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(SubCategoryEntity subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * @return the userDetails
	 */
	public UserDetailsEntity getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDetailsEntity userDetails) {
		this.userDetails = userDetails;
	}

}
