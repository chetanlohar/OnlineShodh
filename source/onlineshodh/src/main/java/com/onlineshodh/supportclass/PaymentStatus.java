package com.onlineshodh.supportclass;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.onlineshodh.entity.CheckEntity;
import com.onlineshodh.entity.PaymentEntity;

@Component
@Scope(value="prototype")
public class PaymentStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Valid
	PaymentEntity payment;
	@Valid
	CheckEntity check;
	public PaymentEntity getPayment() {
		return payment;
	}
	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}
	public CheckEntity getCheck() {
		return check;
	}
	public void setCheck(CheckEntity check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return "PaymentStatus [payment=" + payment + ", check=" + check + "]";
	}
	
}
