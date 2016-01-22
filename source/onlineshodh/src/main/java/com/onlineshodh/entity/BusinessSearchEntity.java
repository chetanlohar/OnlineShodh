package com.onlineshodh.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
/*@Scope(value="prototype")*/
public class BusinessSearchEntity implements Serializable {

	private static final long serialVersionUID = 1L;
     
	@Valid
	private String searchBy;
	@Valid
	private String searchText;
	
	public String getSearchBy() {
		return searchBy;
	}
	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	
}
