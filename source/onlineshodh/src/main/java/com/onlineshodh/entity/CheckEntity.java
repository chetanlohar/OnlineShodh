package com.onlineshodh.entity;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
@Table(name="check_details")
@Entity
public class CheckEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="pk_sequence_checkid",sequenceName="seq_check_details_checkid", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_checkid")
	@Column(name="checkid", nullable=false, unique=true)
	private Integer checkId;
	@Column(name="checkno")
	private Integer checkNo;
	@Column(name="bankname")
	private String bankName;
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="checkdate")
	private Date checkDate;
	@Column(name="paymentid")
	private Integer paymentId;
	
	@Column(name="amount")
	private Integer amount;
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getCheckId() {
		return checkId;
	}
	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}
	public Integer getCheckNo() {
		return checkNo;
	}
	public void setCheckNo(Integer checkNo) {
		this.checkNo = checkNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	@Override
	public String toString() {
		return "CheckEntity [checkId=" + checkId + ", checkNo=" + checkNo
				+ ", bankName=" + bankName + ", checkDate=" + checkDate
				+ ", paymentId=" + paymentId + "]";
	} 
	
	
}
