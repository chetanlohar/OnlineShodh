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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/*@Scope(value = "prototype")*/
@Entity
@Table(name = "state")
public class StateEntity implements  Serializable {

	private static final long serialVersionUID = 1L;

	/* State Id Of State */

	@Id
	@SequenceGenerator(name = "pk_sequence_stateid", sequenceName = "seq_state_stateid", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_stateid")
	@Column(name = "stateid",unique=true,nullable=false)
	private Integer stateId;

	/* State Name Of State */

	@Column(name = "statename")
	@NotEmpty(message = "State Name is Mandatory!")
	private String stateName;
	@ManyToOne(targetEntity=CountryEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="countryId")
	private CountryEntity country;
	
	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "StateEntity [stateId=" + stateId + ", stateName=" + stateName
				+ ", country=" + country + "]";
	}

	

}
