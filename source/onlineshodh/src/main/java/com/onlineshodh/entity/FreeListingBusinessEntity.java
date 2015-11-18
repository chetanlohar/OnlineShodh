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
@Scope(value="prototype")
@Entity
@Table(name="fl_business_details")
public class FreeListingBusinessEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_freeListingId",sequenceName="seq_fl_business_id",allocationSize=1)
	@GeneratedValue(generator="pk_freeListingId",strategy=GenerationType.SEQUENCE)
	@Column(name="fl_business_id")
	private Long freeListingId;
	
	@Column(name="fl_business_name")
	private String businessName;
	
	@Column(name="fl_business_personname")
	private String personName;
	
	@Column(name="fl_business_email")
	private String email;
	
	@Column(name="fl_business_website")
	private String website;
	
	@Column(name="fl_business_keywords")
	private String keywords;
	
	@ManyToOne(targetEntity=SubCategoryEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="subCategoryId")
	private SubCategoryEntity subCategory;

	/**
	 * @return the freeListingId
	 */
	public Long getFreeListingId() {
		return freeListingId;
	}

	/**
	 * @param freeListingId the freeListingId to set
	 */
	public void setFreeListingId(Long freeListingId) {
		this.freeListingId = freeListingId;
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
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FreeListingBusinessEntity [freeListingId=" + freeListingId
				+ ", businessName=" + businessName + ", personName="
				+ personName + ", email=" + email + ", website=" + website
				+ ", keywords=" + keywords + ", subCategory=" + subCategory
				+ "]";
	}
	
}
