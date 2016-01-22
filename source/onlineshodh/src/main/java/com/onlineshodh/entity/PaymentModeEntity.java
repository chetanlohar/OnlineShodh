package com.onlineshodh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/*@Scope("prototype")*/
@Entity
@Table(name="payment_mode")
public class PaymentModeEntity implements Serializable{
      
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="pk_sequence_paymentmodeid",sequenceName="seq_payment_mode_payment_mode_id",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_paymentmodeid")
	@Column(name="paymentmodeid",nullable=false,unique=true)
	private Integer paymentModeid;
	@Column(name="paymentmode")
	private String paymentMode;
	public Integer getPaymentModeid() {
		return paymentModeid;
	}
	public void setPaymentModeid(Integer paymentModeid) {
		this.paymentModeid = paymentModeid;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	@Override
	public String toString() {
		return "PaymentModeEntity [paymentModeid=" + paymentModeid
				+ ", paymentMode=" + paymentMode + "]";
	}
	
	
	
}
