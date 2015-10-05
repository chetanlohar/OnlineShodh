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

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Table(name="town")
@Entity
@Scope(value="prototype")
@Component
public class TownEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	@Id
	@SequenceGenerator(name="pk_sequence_townid",sequenceName="seq_town_townid",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_townid")
	@Column(name="townid",unique=true,nullable=false)
	private Integer townId;
	@Column(name="townname")
	@NotEmpty(message="Town Name Should Not Empty!")
	private String townName;
    @JoinColumn(name="cityId")
	@ManyToOne(targetEntity=CityEntity.class,fetch=FetchType.EAGER)
	private CityEntity city;
	
	public Integer getTownId() {
		return townId;
	}
	public void setTownId(Integer townId) {
		this.townId = townId;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	public CityEntity getCity() {
		return city;
	}
	public void setCity(CityEntity city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "TownEntity [townId=" + townId + ", townName=" + townName
				+ ", city=" + city + "]";
	}
	
	
}
