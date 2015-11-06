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
@Table(name="business_enquiry_details")
public class BusinessEnquiryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_businessenquiryid",sequenceName="seq_business_enquiry_id",allocationSize=1)
	@GeneratedValue(generator="pk_businessenquiryid",strategy=GenerationType.SEQUENCE)
	@Column(name="enquiryid")
	private Long businessEnquiryDetailsId;
	
	@Column(name="enquiryname")
	private String enquiryname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="message")
	private String message;
	
	@ManyToOne(targetEntity=BusinessDetailsEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="businessId")
	private BusinessDetailsEntity business;

	public Long getBusinessEnquiryDetails() {
		return businessEnquiryDetailsId;
	}

	public void setBusinessEnquiryDetails(Long businessEnquiryDetails) {
		this.businessEnquiryDetailsId = businessEnquiryDetails;
	}

	public String getEnquiryname() {
		return enquiryname;
	}

	public void setEnquiryname(String enquiryname) {
		this.enquiryname = enquiryname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BusinessDetailsEntity getBusiness() {
		return business;
	}

	public void setBusiness(BusinessDetailsEntity business) {
		this.business = business;
	}

	@Override
	public String toString() {
		return "BusinessEnquiryEntity [businessEnquiryDetails="
				+ businessEnquiryDetailsId + ", enquiryname=" + enquiryname
				+ ", email=" + email + ", phone=" + phone + ", message="
				+ message + ", business=" + business + "]";
	}
}
