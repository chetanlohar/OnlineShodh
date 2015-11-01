package com.onlineshodh.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="business_generalinfo_details")
public class BusinessGeneralInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long businessGenInfoId;
	
	private String generalInfo;
	
	private String generalInfoDesc;
	
	private BusinessDetailsEntity business;

}
