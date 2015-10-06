package com.onlineshodh.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Softinfology - Chetan Lohar (Team Lead-Java)
 * Describes the User Information of the User.
 * UserEntity is main actor for the system. 
 */
@Component
@Scope(value="prototype")
@Entity
@Table(name="users")
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * UserId of the User
	 */
	@Id
	@SequenceGenerator(name="pk_userid",sequenceName="seq_users_userid",allocationSize=1)
	@GeneratedValue(generator="pk_userid",strategy=GenerationType.SEQUENCE)
	@Column(name="userid",nullable=false,unique=true)
	private Integer userId;
	
	
	/**
	 * UserName of the User which will be in Email format
	 */
	@Column(name="username",nullable=false,unique=true)
	@NotEmpty(message="Email is Mandatory")
	@Email(message="Not a valid Email")
	private String userName;
	
	
	/**
	 * Password of the User
	 */
	@Column(name="password",nullable=false)
	@NotEmpty(message="Password is Mandatory")
	private String password;
	
	
	/**
	 * User Account is Enable=true/Not-Enable=false
	 */
	@Column(name="enabled",nullable=false)
	private boolean enabled;
	
	
	/**
	 * Role of the User
	 */
	@Column(name="role",nullable=false)
	private String role;
	
	
	/**
	 * Describes when user is Created
	 */
	@Column(name="createdon",nullable=false)
	private Timestamp createdOn;
	
	
	/**
	 * User Id of the User who Created Current User 
	 */
	@Column(name="createdby")
	private Integer createdBy;
	
	/**
	 * Status of Account is Expiration
	 * true for NonExpired
	 * false for Expired account
	 */
	@Column(name="accountnonexpired",nullable=false)
	private boolean accountNonExpired;

	
	/**
	 * Status of Account is Locked
	 * true for Non-Locked account
	 * false for Locked account
	 */
	@Column(name="accountnonlocked",nullable=false)
	private boolean accountNonLocked;
	
	
	/**
	 * Status of Email Verification
	 */
	@Column(name="emailverified",nullable=false)
	private boolean emailVerified;
	
	
	/**
	 * status of credentials Non Expired
	 * true for Credentials Non-Expired
	 * false for Credentials Expired
	 */
	@Column(name="credentialsnonexpired",nullable=false)
	private boolean credentialsNonExpired;
	
	
	/**
	 * UUID for Email Verification Link
	 */
	@Column(name="uuidforemail",nullable=false)
	private String uuidForEmail;


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
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param username the username to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}


	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}


	/**
	 * @return the cratedOn
	 */
	public Timestamp getCreatedOn() {
		return createdOn;
	}


	/**
	 * @param cratedOn the cratedOn to set
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}


	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}


	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	/**
	 * @return the accountNonExpired
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}


	/**
	 * @param accountNonExpired the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}


	/**
	 * @return the accountNonLocked
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}


	/**
	 * @param accountNonLocked the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	/**
	 * @return the emailVerified
	 */
	public boolean isEmailVerified() {
		return emailVerified;
	}


	/**
	 * @param emailVerified the emailVerified to set
	 */
	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}


	/**
	 * @return the credentialsNonExpired
	 */
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}


	/**
	 * @param credentialsNonExpired the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}


	/**
	 * @return the uuidforemail
	 */
	public String getUuidforemail() {
		return uuidForEmail;
	}


	/**
	 * @param uuidforemail the uuidforemail to set
	 */
	public void setUuidforemail(String uuidforemail) {
		this.uuidForEmail = uuidforemail;
	}
	
	public UserEntity()
	{
		this.enabled = true;
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
		this.emailVerified = false;
		this.uuidForEmail = null;
		this.role = "client";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", username=" + userName
				+ ", password=" + password + ", enabled=" + enabled + ", role="
				+ role + ", cratedOn=" + createdOn + ", createdBy=" + createdBy
				+ ", accountNonExpired=" + accountNonExpired
				+ ", accountNonLocked=" + accountNonLocked + ", emailVerified="
				+ emailVerified + ", credentialsNonExpired="
				+ credentialsNonExpired + ", uuidforemail=" + uuidForEmail
				+ "]";
	}
}
