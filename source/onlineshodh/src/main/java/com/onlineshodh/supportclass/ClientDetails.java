package com.onlineshodh.supportclass;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.onlineshodh.entity.AddressEntity;
import com.onlineshodh.entity.UserDetailsEntity;
import com.onlineshodh.entity.UserEntity;

@Component
/*@Scope(value="prototype")*/
public class ClientDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Loging Information of the User
	 */
	@Valid
	private UserEntity user;
	/**
	 * Personal Details of the user
	 */
	@Valid
	private UserDetailsEntity userDetails;
	
	@Valid
	private AddressEntity address;

	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	/**
	 * @return the userDetails
	 */
	public UserDetailsEntity getUserDetails() {
		return userDetails;
	}
	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDetailsEntity userDetails) {
		this.userDetails = userDetails;
	}
	
	
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "ClientDetails [user=" + user + ", userDetails=" + userDetails
				+ ", address=" + address + "]";
	}
}
