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
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Table(name="banner_details")
@Component
@Scope(value="prototype")
@Entity
public class BannerEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_sequence_bannerid",sequenceName="seq_banner_bannerid",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_bannerid")
	@Column(name="bannerid")
	private Integer bannerId;
	@ManyToOne(targetEntity=CategoryEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="categoryid")
	private CategoryEntity category;
	@ManyToOne(targetEntity=CityEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="cityid")
	private CityEntity city;
	@Column(name="banner",nullable=false)
	private byte[] bannerLogo;
	@Column(name="urllink")
	@NotEmpty(message="Url Should not Empty")
	private String urlLink;
	@Column(name="totalhits")
	private Integer totalHit;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="regdate") 
	private Date regDate;
	 
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="startdate")
	private Date startDate;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="expdate")
	private Date expiryDate;
	
	@Column(name="status")
	private String status;
	
	
	public Integer getBannerId() {
		return bannerId;
	}
	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public CityEntity getCity() {
		return city;
	}
	public void setCity(CityEntity city) {
		this.city = city;
	}
	
	
	public byte[] getBannerLogo() {
		return bannerLogo;
	}
	public void setBannerLogo(byte[] bannerLogo) {
		this.bannerLogo = bannerLogo;
	}
	public String getUrlLink() {
		return urlLink;
	}
	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}
	public Integer getTotalHit() {
		return totalHit;
	}
	public void setTotalHit(Integer totalHit) {
		this.totalHit = totalHit;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "BannerEntity [bannerId=" + bannerId + ", category=" + category
				+ ", city=" + city + ", banner=" + Arrays.toString(bannerLogo)
				+ ", urlLink=" + urlLink + ", totalHit=" + totalHit
				+ ", regDate=" + regDate + ", startDate=" + startDate
				+ ", expiryDate=" + expiryDate + "]";
	}
	
	
	
}
