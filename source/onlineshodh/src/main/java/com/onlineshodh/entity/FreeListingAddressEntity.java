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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
/*@Scope(value="prototype")*/
@Entity
@Table(name="fl_address")
public class FreeListingAddressEntity implements Serializable {
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="pk_fl_address",sequenceName="seq_fl_address_addressid",allocationSize=1)
	@GeneratedValue(generator="pk_fl_address",strategy=GenerationType.SEQUENCE)
	@Column(name="freelistingbusinessaddressid",nullable=false,unique=true)
	private Integer fl_AddressId;
	@Column(name="fl_address")
	@NotNull(message="mandatory")
	private String fl_Address;
    @Column(name="fl_street")
    @NotNull(message="mandatory")
    private String fl_Street;
	@Column(name="fl_landmark")
	private String fl_LandMark;
	@ManyToOne(targetEntity=CityEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="cityId")
	private CityEntity city;
	@ManyToOne(targetEntity=TownEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="townId")
	private TownEntity town;
	@Column(name="fl_pincode")
	/*@NotNull(message="mandatory")*/
	private Integer pincode;
	@ManyToOne(targetEntity=FreeListingBusinessEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="freelistingbusinessdetailsId")
	private FreeListingBusinessEntity businessEntity; 
	
	public Integer getFl_AddressId() {
		return fl_AddressId;
	}
	public void setFl_AddressId(Integer fl_AddressId) {
		this.fl_AddressId = fl_AddressId;
	}
	public String getFl_Address() {
		return fl_Address;
	}
	public void setFl_Address(String fl_Address) {
		this.fl_Address = fl_Address;
	}
	public String getFl_Street() {
		return fl_Street;
	}
	public void setFl_Street(String fl_Street) {
		this.fl_Street = fl_Street;
	}
	public String getFl_LandMark() {
		return fl_LandMark;
	}
	public void setFl_LandMark(String fl_LandMark) {
		this.fl_LandMark = fl_LandMark;
	}
	public CityEntity getCity() {
		return city;
	}
	public void setCity(CityEntity city) {
		this.city = city;
	}
	public TownEntity getTown() {
		return town;
	}
	public void setTown(TownEntity town) {
		this.town = town;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public FreeListingBusinessEntity getBusinessEntity() {
		return businessEntity;
	}
	public void setBusinessEntity(FreeListingBusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}
	@Override
	public String toString() {
		return "FreeListingAddressEntity [fl_AddressId=" + fl_AddressId
				+ ", fl_Address=" + fl_Address + ", fl_Street=" + fl_Street
				+ ", fl_LandMark=" + fl_LandMark + ", city=" + city + ", town="
				+ town + ", pincode=" + pincode + ", businessEntity="
				+ businessEntity + "]";
	}
	
	
	
	
}
