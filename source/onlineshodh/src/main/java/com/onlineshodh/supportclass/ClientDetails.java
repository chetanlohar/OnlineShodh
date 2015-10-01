package com.onlineshodh.supportclass;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.onlineshodh.entity.CountryEntity;
import com.onlineshodh.entity.UserEntity;

@Component
@Scope(value="prototype")
public class ClientDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Valid
	private UserEntity user;
	@Valid
	private CountryEntity country;
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public CountryEntity getCountry() {
		return country;
	}
	public void setCountry(CountryEntity country) {
		this.country = country;
	}
}
