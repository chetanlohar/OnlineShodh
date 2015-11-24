package com.onlineshodh.entity;

import java.io.Serializable;
import java.util.Arrays;

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

/**
 * @author Softinfology - Chetan Lohar, Java Developer
 *
 */
@Component
@Entity
@Table(name="category")
@Scope(value="prototype")
public class CategoryEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Describes Category Id
	 */
	@Id
	@SequenceGenerator(name="pk_sequence_categoryid",sequenceName="seq_category_categoryid", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_categoryid")
	@Column(name="categoryid", nullable=false, unique=true)
	private Integer categoryId;
	
	/**
	 * Describes Category Name
	 */
	@Column(name="categoryName")
	@NotEmpty(message="Category Name Mandatory!")
	private String categoryName;
	

	/**
	 * Describes Category Description
	 */
	@Column(name="categorydesc")
	@NotEmpty(message="Category Description Mandatory!")
	private String categoryDesc;
	
	
	/**
	 * Describes Category Logo
	 */
	@Column(name="categorylogo",nullable=false)
	private byte [] categoryLogo;
	
	
	/**
	 * Describes Category Popularity
	 */
	@Column(name="popularity")
	private Integer popularity;
	
	@Column(name="path")
	private String path;
	
	@Column(name="imagefilename")
	private String imageFileName;
	


	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}


	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}


	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	/**
	 * @return the categoryDesc
	 */
	public String getCategoryDesc() {
		return categoryDesc;
	}


	/**
	 * @param categoryDesc the categoryDesc to set
	 */
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}


	/**
	 * @return the categoryLogo
	 */
	public byte [] getCategoryLogo() {
		return categoryLogo;
	}


	/**
	 * @param categoryLogo the categoryLogo to set
	 */
	public void setCategoryLogo(byte [] categoryLogo) {
		this.categoryLogo = categoryLogo;
	}

	/**
	 * @return the popularity
	 */
	public Integer getPopularity() {
		return popularity;
	}


	/**
	 * @param popularity the popularity to set
	 */
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}


	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}


	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategoryEntity [categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", categoryDesc=" + categoryDesc
				+ ", categoryLogo=" + Arrays.toString(categoryLogo)
				+ ", popularity=" + popularity + "]";
	}
}
