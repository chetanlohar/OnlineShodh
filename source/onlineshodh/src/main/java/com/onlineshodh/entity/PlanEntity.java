package com.onlineshodh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="plan_details")
/*@Scope(value="prototype")*/
public class PlanEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="planid",unique=true)
	@Id
	@SequenceGenerator(name="pk_sequence_planid",sequenceName="seq_plan_planid",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_planid")
	private Integer planId;
	@NotEmpty(message="PlanName should Not Empty!")
	@Column(name="planname",nullable=false)
	private String planName;
	@Column(name="plandesc",nullable=false)
	@NotEmpty(message="Plan Description should Not Empty!")
	private String planDescription;
	@Column(name="view_businessname")
	private boolean businessName;
	@Column(name="view_businessaddr")
	private boolean businessAddress;
	@Column(name="view_personname")
	private boolean personName;
	@Column(name="view_images",nullable=false)
	@NotNull(message="No Of Images should Not Empty!")
	@Digits(integer=2,fraction=0,message="PlzEnter Valid No Of Imagess")
	@Min(value=0,message="Plz Enter valid No Of images(No of img>=0) )")
	private Integer noOfImages;
	@Column(name="view_businessdesc")
	private boolean businessDescription;
	@Column(name="view_email")
	private boolean email;
	@Column(name="view_contacts",nullable=false)
	@NotNull(message="No Of Contact should Not Empty!")
	@Digits(integer=2,fraction=0,message="PlzEnter Valid No Of Contacts")
	@Min(value=0,message="Plz Enter valid No Of Contacts(contacts>=0) )")
	private Integer noOfContacts;
	@Column(name="view_enquiryform")
	private boolean enquiryForm;
	@Column(name="view_generalinfo")
	private boolean generalInfo;
	@Column(name="view_website")
	private boolean website;
	@Column(name="priority",nullable=false)
	@NotEmpty(message="Priority should Not Empty!")
	private String priority;
	@Column(name="validityinmonths")
	@NotNull(message="Months should Not Empty!")
	@Digits(integer=2,fraction=0,message="PlzEnter Valid No Of Months")
	@Min(value=0,message="Plz Enter valid No Of Months(months>=0) )")
	private Integer validityInMonths;
	@Column(name="amount")
	@NotNull(message="Amount should Not Empty!")
	@Digits(integer=6,fraction=2,message="Plz Enter Valid ammount")
	@Min(value=0,message="Plz Enter valid Ammount(amount>=0)")
	private Integer amount;
	@Column(name="view_map")
	private boolean map;
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanDescription() {
		return planDescription;
	}
	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}
	public boolean isBusinessName() {
		return businessName;
	}
	public void setBusinessName(boolean businessName) {
		this.businessName = businessName;
	}
	public boolean isBusinessAddress() {
		return businessAddress;
	}
	public void setBusinessAddress(boolean businessAddress) {
		this.businessAddress = businessAddress;
	}
	public boolean isPersonName() {
		return personName;
	}
	public void setPersonName(boolean personName) {
		this.personName = personName;
	}
	public Integer getNoOfImages() {
		return noOfImages;
	}
	public void setNoOfImages(Integer noOfImages) {
		this.noOfImages = noOfImages;
	}
	public boolean isBusinessDescription() {
		return businessDescription;
	}
	public void setBusinessDescription(boolean businessDescription) {
		this.businessDescription = businessDescription;
	}
	public boolean isEmail() {
		return email;
	}
	public void setEmail(boolean email) {
		this.email = email;
	}
	public Integer getNoOfContacts() {
		return noOfContacts;
	}
	public void setNoOfContacts(Integer noOfContacts) {
		this.noOfContacts = noOfContacts;
	}
	public boolean isEnquiryForm() {
		return enquiryForm;
	}
	public void setEnquiryForm(boolean enquiryForm) {
		this.enquiryForm = enquiryForm;
	}
	public boolean isGeneralInfo() {
		return generalInfo;
	}
	public void setGeneralInfo(boolean generalInfo) {
		this.generalInfo = generalInfo;
	}
	public boolean isWebsite() {
		return website;
	}
	public void setWebsite(boolean website) {
		this.website = website;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Integer getValidityInMonths() {
		return validityInMonths;
	}
	public void setValidityInMonths(Integer validityInMonths) {
		this.validityInMonths = validityInMonths;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public boolean isMap() {
		return map;
	}
	public void setMap(boolean map) {
		this.map = map;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "PlanEntity [planId=" + planId + ", planName=" + planName
				+ ", planDescription=" + planDescription + ", businessName="
				+ businessName + ", businessAddress=" + businessAddress
				+ ", personName=" + personName + ", noOfImages=" + noOfImages
				+ ", businessDescription=" + businessDescription + ", email="
				+ email + ", noOfContacts=" + noOfContacts + ", enquiryForm="
				+ enquiryForm + ", generalInfo=" + generalInfo + ", website="
				+ website + ", priority=" + priority + ", validityInMonths="
				+ validityInMonths + ", amount=" + amount + ", map=" + map
				+ "]";
	}
	
	
	
	
	
	
	
	

}
