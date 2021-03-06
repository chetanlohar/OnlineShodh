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
/*@Scope(value="prototype")*/
@Entity
@Table(name = "payment_details")
public class PaymentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "pk_sequence_paymentid", sequenceName = "seq_payment_paymentid", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence_paymentid")
	@Column(name = "paymentid", nullable = false, unique = true)
	private Integer paymentId;
	@Column(name = "paymentfor")
	private String paymentfor;
	@Column(name = "amount")
	private Integer ammount;
	@Column(name = "status")
	private String status;
	@Column(name = "remark")
	private String remark;
	@Column(name = "payeename")
	private String payeeName;

	@Column(name = "bannerid")
	private Integer bannerId;

	@Column(name = "businessid")
	private Long businessId;

	@Column(name = "isbusiness")
	private boolean isBusiness;

	public boolean isBusiness() {
		return isBusiness;
	}

	public void setBusiness(boolean isBusiness) {
		this.isBusiness = isBusiness;
	}

	@ManyToOne(targetEntity = PaymentModeEntity.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "paymentmodeid")
	private PaymentModeEntity paymentMode;

	@Column(name = "transactionid")
	private Integer transactionid;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentfor() {
		return paymentfor;
	}

	public void setPaymentfor(String paymentfor) {
		this.paymentfor = paymentfor;
	}

	public Integer getAmmount() {
		return ammount;
	}

	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public PaymentModeEntity getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentModeEntity paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Integer getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(Integer transactionid) {
		this.transactionid = transactionid;
	}
	
	public Integer getBannerId() {
		return bannerId;
	}

	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	@Override
	public String toString() {
		return "PaymentEntity [paymentId=" + paymentId + ", paymentfor="
				+ paymentfor + ", ammount=" + ammount + ", status=" + status
				+ ", remark=" + remark + ", payeeName=" + payeeName
				+ ", bannerId=" + bannerId + ", businessId=" + businessId
				+ ", isBusiness=" + isBusiness + ", paymentMode=" + paymentMode
				+ ", transactionid=" + transactionid + "]";
	}
}
