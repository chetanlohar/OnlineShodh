package com.onlineshodh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value="prototype")
@Entity
@Table(name="city")
public class CityEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="pk_sequence_cityid",sequenceName="seq_city_cityid",allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_cityid")
	@Column(name="cityid",unique=true,nullable=false)
    private Integer cityId;
	@Column(name="cityname")
	@NotEmpty(message="City Name is Mandatory!")
	private String cityName;
	@ManyToOne(targetEntity=StateEntity.class,fetch=FetchType.EAGER)
	private StateEntity stateEntity; 
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public StateEntity getStateEntity() {
		return stateEntity;
	}
	public void setStateEntity(StateEntity stateEntity) {
		this.stateEntity = stateEntity;
	}
	@Override
	public String toString() {
		return "CityEntity [cityId=" + cityId + ", cityName=" + cityName
				+ ", stateEntity=" + stateEntity + "]";
	}
	

}
