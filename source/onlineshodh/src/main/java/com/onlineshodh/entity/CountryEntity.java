package com.onlineshodh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
@Entity
@Table(name="country")
public class CountryEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	/*Country id of the Country*/
	@Id
	@Column(name="countryid")
	@GeneratedValue
	private Integer countryId;
	
	/*Country Name of the Country*/
	@Column(name="countryname")
	@NotEmpty
	private String countryName;
	
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public String toString() {
		return "CountryEntity [countryId=" + countryId + ", countryName="
				+ countryName + "]";
	}
	
}
