package com.onlineshodh.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;



@Component
public class BusinessSearchEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String searchBy;
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
