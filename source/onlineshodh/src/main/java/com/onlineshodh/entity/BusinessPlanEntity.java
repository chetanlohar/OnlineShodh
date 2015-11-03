package com.onlineshodh.entity;

import java.io.Serializable;
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
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="business_plan_details")
@Scope("prototype")
public class BusinessPlanEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="pk_sequence_businessplanid",sequenceName="seq_businessplan_businessplanid",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_businessplanid")
	@Column(name="businessplandetid",unique=true,nullable=false)
	private Integer businessplandetid;
	@ManyToOne(targetEntity=BusinessDetailsEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="businessid")
	private BusinessDetailsEntity business;
	@ManyToOne(targetEntity=PlanEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="planid")
	private PlanEntity plan;
	@Column(name="startdate")
	private Date startdate;
	@Column(name="enddate")
	private Date enddate;
	@Column(name="status")
	private String status;
	public Integer getBusinessplandetid() {
		return businessplandetid;
	}
	public void setBusinessplandetid(Integer businessplandetid) {
		this.businessplandetid = businessplandetid;
	}
	public BusinessDetailsEntity getBusiness() {
		return business;
	}
	public void setBusiness(BusinessDetailsEntity business) {
		this.business = business;
	}
	public PlanEntity getPlan() {
		return plan;
	}
	public void setPlan(PlanEntity plan) {
		this.plan = plan;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BusinessPlanEntity [businessplandetid=" + businessplandetid
				+ ", business=" + business + ", plan=" + plan + ", startdate="
				+ startdate + ", enddate=" + enddate + ", status=" + status
				+ "]";
	}
	
	
	
}
