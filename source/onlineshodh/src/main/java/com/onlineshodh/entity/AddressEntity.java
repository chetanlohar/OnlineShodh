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

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/*@Scope("prototype")*/
@Entity
@Table(name="address")
public class AddressEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="addressid",nullable=false,unique=true)
	@SequenceGenerator(name="pk_addressid",sequenceName="seq_address_addressid",allocationSize=1)
	@GeneratedValue(generator="pk_addressid",strategy=GenerationType.SEQUENCE)
	private Long addressId;
	
	@Column(name="address")
	@NotNull(message="Address is Mandatory!")
	@NotEmpty(message="Address is Mandatory!")
	private String address;
	
	@Column(name="street")
	@NotNull(message="Street is Mandatory!")
	@NotEmpty(message="Street is Mandatory!")
	private String street;
	
	@Column(name="landmark")
	private String landMark;
	
	@ManyToOne(targetEntity=CityEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="cityId")
	private CityEntity city;
	
	@ManyToOne(targetEntity=TownEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="townId")
	private TownEntity town;
	
	@Column(name="townother")
	private String townOther;
	
	@Column(name="pincode")
	@NotNull(message="Pincode is Mandatory")
	@NotEmpty(message="Pincode is Mandatory")
	private String pincode;
	
	@Column(name="map")
	private String map;

	/**
	 * @return the addressId
	 */
	public Long getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the landMark
	 */
	public String getLandMark() {
		return landMark;
	}

	/**
	 * @param landMark the landMark to set
	 */
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	/**
	 * @return the city
	 */
	public CityEntity getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(CityEntity city) {
		this.city = city;
	}

	/**
	 * @return the town
	 */
	public TownEntity getTown() {
		return town;
	}

	/**
	 * @param town the town to set
	 */
	public void setTown(TownEntity town) {
		this.town = town;
	}

	/**
	 * @return the townOther
	 */
	public String getTownOther() {
		return townOther;
	}

	/**
	 * @param townOther the townOther to set
	 */
	public void setTownOther(String townOther) {
		this.townOther = townOther;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the map
	 */
	public String getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(String map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "AddressEntity [addressId=" + addressId + ", address=" + address
				+ ", street=" + street + ", landMark=" + landMark + ", city="
				+ city + ", town=" + town + ", townOther=" + townOther
				+ ", pincode=" + pincode + ", map=" + map + "]";
	}
	
	
	
}
