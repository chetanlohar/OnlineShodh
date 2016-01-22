package com.onlineshodh.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
/*@Scope(value="prototype")*/
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
	
	@Column(name="fl_regdate")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date regdate;
	
	@Column(name="fl_logo")
	private byte[] logo;
	
	@Column(name="fl_logoname")
	private String imagename;
	
	@Column(name="fl_logopath")
	private String imagepath;
	
	@Column(name="fl_businessdesc")
	private String businessDesc;
	
	@Column(name="fl_status")
	private String status;
	
	
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getBusinessDesc() {
		return businessDesc;
	}

	public void setBusinessDesc(String businessDesc) {
		this.businessDesc = businessDesc;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FreeListingBusinessEntity [freelistingbusinessdetailsId="
				+ freelistingbusinessdetailsId + ", businessName="
				+ businessName + ", personName=" + personName + ", email="
				+ email + ", website=" + website + ", keywords=" + keywords
				+ ", regdate=" + regdate + ", logo=" + Arrays.toString(logo)
				+ ", imagename=" + imagename + ", imagepath=" + imagepath
				+ ", businessDesc=" + businessDesc + ", status=" + status
				+ ", subCategory=" + subCategory + "]";
	}

		
}
