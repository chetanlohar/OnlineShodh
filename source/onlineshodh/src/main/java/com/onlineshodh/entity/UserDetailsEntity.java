package com.onlineshodh.entity;

import java.io.Serializable;
import java.sql.Date;

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

/**
 * @author Softinfology - Chetan Lohar (TL-Java)
 * UserDetailsEntity Describes the User's Personal Information
 *
 */
@Component
@Scope(value="prototype")
@Entity
@Table(name="user_details")
public class UserDetailsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * User Details Id is the Id of the User's Personal Information
	 */
	@Id
	@SequenceGenerator(name="pk_userdetailsid",sequenceName="seq_userdetails_userdetailsid",allocationSize=1)
	@GeneratedValue(generator="pk_userdetailsid",strategy=GenerationType.SEQUENCE)
	@Column(name="userdetailsid",nullable=false,unique=true)
	private Integer userDetailsId;
	
	/**
	 * Name of the User
	 */
	@Column(name="name",nullable=false)
	@NotEmpty(message="Name Mandatory!")
	private String name;
	
	/**
	 * Email of the User
	 */
	@Column(name="email",nullable=false)
	private String email;
	
	/**
	 * Primary Contact of the User
	 */
	@Column(name="phone1",nullable=false)
	@NotEmpty(message="Primary Contact Mandatory")
	private String phone1;
	
	/**
	 * Secondary Contact of the User
	 */
	@Column(name="phone2")
	private String phone2;
	
	/**
	 * Registration Date of the User
	 */
	@Column(name="regdate",nullable=false)
	private Date regDate;
	
	/**
	 * Photograph of the User
	 */
	private byte [] photograph;
	
	/**
	 * User Id of the User
	 */
	@Column(name="userid",nullable=false)
	private Integer userId;

	@ManyToOne(targetEntity=AddressEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="addressId")
	private AddressEntity address;
	
	/*@ManyToMany(targetEntity=UserEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="userid")*/
	
	/*@Column(name="userid",insertable=false,updatable=false)
	private UserEntity user;
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}*/

	/**
	 * @return the userDetailsId
	 */
	public Integer getUserDetailsId() {
		return userDetailsId;
	}

	/**
	 * @param userDetailsId the userDetailsId to set
	 */
	public void setUserDetailsId(Integer userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone1
	 */
	public String getPhone1() {
		return phone1;
	}

	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	/**
	 * @return the phone2
	 */
	public String getPhone2() {
		return phone2;
	}

	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	/**
	 * @return the regdate
	 */
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * @param regdate the regdate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	/**
	 * @return the photograph
	 */
	public byte[] getPhotograph() {
		return photograph;
	}

	/**
	 * @param photograph the photograph to set
	 */
	public void setPhotograph(byte[] photograph) {
		this.photograph = photograph;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the address
	 */
	public AddressEntity getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	/*public UserDetailsEntity(UserDetailsEntity userDetails) {
		
		this.userId = userDetails.getUserId();
		this.email = userDetails.getEmail();
		this.name = userDetails.getName();
		this.phone1 = userDetails.getPhone1();
		this.phone2 = userDetails.getPhone2();
		this.photograph = userDetails.getPhotograph();
		this.regDate = userDetails.getRegDate();
		this.userDetailsId = userDetails.getUserDetailsId();
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "UserDetailsEntity [userDetailsId=" + userDetailsId + ", name="
				+ name + ", email=" + email + ", phone1=" + phone1
				+ ", phone2=" + phone2 + ", regdate=" + regDate
				+ ", photograph=" + Arrays.toString(photograph) + ", userId="
				+ userId + "]";
	}*/
}
