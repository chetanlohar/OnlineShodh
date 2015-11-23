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
	@SequenceGenerator(name="pk_sequence_freelistingid",sequenceName="seq_fl_business_id",allocationSize=1)
	@GeneratedValue(generator="pk_sequence_freelistingid",strategy=GenerationType.SEQUENCE)
	@Column(name="freelistingbusinessdetailsid",unique=true,nullable=false)
	private Long freelistingbusinessdetailsId;
	
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

	

	public Long getFreelistingbusinessdetailsId() {
		return freelistingbusinessdetailsId;
	}

	public void setFreelistingbusinessdetailsId(Long freelistingbusinessdetailsId) {
		this.freelistingbusinessdetailsId = freelistingbusinessdetailsId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public SubCategoryEntity getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategoryEntity subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "FreeListingBusinessEntity [freelistingbusinessdetailsId="
				+ freelistingbusinessdetailsId + ", businessName="
				+ businessName + ", personName=" + personName + ", email="
				+ email + ", website=" + website + ", keywords=" + keywords
				+ ", subCategory=" + subCategory + "]";
	}

	
	
	
}
