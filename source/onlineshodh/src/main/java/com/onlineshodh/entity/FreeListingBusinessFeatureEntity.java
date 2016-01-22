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
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/*@Scope("prototype")*/
@Entity
@Table(name="freelisting_business_feature")

public class FreeListingBusinessFeatureEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="pk_freelistingbusinessfeature",sequenceName="seq_freelisting_business_feature_id",allocationSize=1)
	@GeneratedValue(generator="pk_freelistingbusinessfeature",strategy=GenerationType.SEQUENCE)
	@Column(name="freelistingbusinessfeatureid",nullable=false,unique=true)
	private Long freelistingBusinessFeatureId;
	
	@Column(name="freelistingbusinessfeature",nullable=false)
	@NotNull(message="Information Needed!")
	private String freelistingBusinessFeature;
	
	@ManyToOne(targetEntity=FreeListingBusinessEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="freelistingbusinessdetailsId")
	private FreeListingBusinessEntity business;

	public Long getFreelistingBusinessFeatureId() {
		return freelistingBusinessFeatureId;
	}

	public void setFreelistingBusinessFeatureId(Long freelistingBusinessFeatureId) {
		this.freelistingBusinessFeatureId = freelistingBusinessFeatureId;
	}

	public String getFreelistingBusinessFeature() {
		return freelistingBusinessFeature;
	}

	public void setFreelistingBusinessFeature(String freelistingBusinessFeature) {
		this.freelistingBusinessFeature = freelistingBusinessFeature;
	}

	public FreeListingBusinessEntity getBusiness() {
		return business;
	}

	public void setBusiness(FreeListingBusinessEntity business) {
		this.business = business;
	}

	@Override
	public String toString() {
		return "FreeListingBusinessFeature [freelistingBusinessFeatureId="
				+ freelistingBusinessFeatureId
				+ ", freelistingBusinessFeature=" + freelistingBusinessFeature
				+ ", business=" + business + "]";
	}

	
	
}
