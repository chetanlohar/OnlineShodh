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
@Scope(value = "prototype")
@Entity
@Table(name = "state")
public class StateEntity implements Comparable<StateEntity>, Serializable {

	private static final long serialVersionUID = 1L;

	/* State Id Of State */

	@Id
	@SequenceGenerator(name = "pk_sequence", sequenceName = "seq_state_stateid", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name = "stateid",unique=true,nullable=false)
	private Integer stateId;

	/* State Name Of State */

	@Column(name = "statename")
	@NotEmpty(message = "State Name is Mandatory!")
	private String stateName;
	@Column(name="countryid",nullable=false)
	private Integer countryId;
	
	/*private CountryEntity country;*/

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
	
	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		
		return "StateEntity [stateId=" + stateId + ", StateName="
				+ stateName + "]";
	}

	@Override
	public int compareTo(StateEntity stateEntity) {
		if (this.getStateId() < stateEntity.getStateId())
			return -1;
		else
			return 1;
	}

}
