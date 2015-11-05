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
@Table(name="payment_details")
public class PaymentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_sequence_paymentid",sequenceName="seq_payment_paymentid",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_paymentid")
	@Column(name="paymentid",nullable=false,unique=true)
	private Integer paymentId;
	@Column(name="paymentmode")
	private String paymentMode;
	@Column(name="status")
	private String status;
	@Column(name="ammount")
	private Integer ammount;
	@ManyToOne(targetEntity=BannerEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="bannerid")
	private BannerEntity banner;
	@ManyToOne(targetEntity=BusinessDetailsEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="businessid")
	private BusinessDetailsEntity business;
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getAmmount() {
		return ammount;
	}
	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}
	public BannerEntity getBanner() {
		return banner;
	}
	public void setBanner(BannerEntity banner) {
		this.banner = banner;
	}
	public BusinessDetailsEntity getBusiness() {
		return business;
	}
	public void setBusiness(BusinessDetailsEntity business) {
		this.business = business;
	}
	@Override
	public String toString() {
		return "PaymentEntity [paymentId=" + paymentId + ", paymentMode="
				+ paymentMode + ", status=" + status + ", ammount=" + ammount
				+ ", banner=" + banner + ", business=" + business + "]";
	}
	

	

}
