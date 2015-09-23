package com.onlineshodh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
@Entity
@Table(name="country")
public class CountryEntity implements Comparable<CountryEntity>,Serializable{

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Country id of the Country
	 */
	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="seq_country_countryid", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="countryid",unique=true,nullable=false)
	private Integer countryId;
	
	/**
	 * Country Name of the Country
	 */
	@Column(name="countryname")
	@NotEmpty
	private String countryName;
	
	
	/**
	 * @return the countryId
	 */
	public Integer getCountryId() {
		return countryId;
	}
	
	
	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	
	
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
	
	
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CountryEntity [countryId=" + countryId + ", countryName="
				+ countryName + "]";
	}


	@Override
	public int compareTo(CountryEntity country) {
		if(this.getCountryId() < country.getCountryId())
			return -1;
		else
			return 1;
	}
	
}
