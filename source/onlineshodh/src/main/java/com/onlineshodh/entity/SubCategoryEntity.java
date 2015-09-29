package com.onlineshodh.entity;

import java.io.Serializable;
import java.util.Arrays;

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
 * @author Softinfology - Chetan Lohar(Team Lead-Java)
 *
 */
@Component
@Scope(value="prototype")
@Entity()
@Table(name="subcategory")
public class SubCategoryEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Describes Subcategory Id of the Subcategory
	 */
	@Id
	@SequenceGenerator(name="pk_subcategoryid",sequenceName="seq_subcategory_subcategoryid",allocationSize=1)
	@GeneratedValue(generator="pk_subcategoryid",strategy=GenerationType.SEQUENCE)
	@Column(name="subcategoryid", nullable=false,unique=true)
	private Integer subCategoryId;
	
	/**
	 * Describes Subcategory Name
	 */
	@Column(name="subcategoryname",nullable=false,unique=true)
	@NotEmpty(message="SubCategory Name is Mandatory!")
	private String subCategoryName;
	
	/**
	 * Describes Subcategory Logo (Picture)
	 */
	@Column(name="subcategorylogo", nullable=false)
	private byte [] subCategoryLogo;
	
	/**
	 * Describes Popularity (hits) of Subcategory
	 */
	@Column(name="popularity",nullable=false)
	private Integer popularity;
	
	/**
	 * Describes Subcategory Description
	 */
	@Column(name="subcategorydesc",nullable=false)
	@NotEmpty(message="SubCategory Description is Mandatory!")
	private String subCategoryDesc;

	/**
	 * Describes the Main Category of the Subcategory 
	 */
	@ManyToOne(targetEntity=CategoryEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="categoryId")
	private CategoryEntity category;

	/**
	 * @return the subCategoryId
	 */
	public Integer getSubCategoryId() {
		return subCategoryId;
	}


	/**
	 * @param subCategoryId the subCategoryId to set
	 */
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}


	/**
	 * @return the subCategoryName
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}


	/**
	 * @param subCategoryName the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}


	/**
	 * @return the subCategoryLogo
	 */
	public byte[] getSubCategoryLogo() {
		return subCategoryLogo;
	}


	/**
	 * @param subCategoryLogo the subCategoryLogo to set
	 */
	public void setSubCategoryLogo(byte[] subCategoryLogo) {
		this.subCategoryLogo = subCategoryLogo;
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
	 * @return the subCategoryDesc
	 */
	public String getSubCategoryDesc() {
		return subCategoryDesc;
	}


	/**
	 * @param subCategoryDesc the subCategoryDesc to set
	 */
	public void setSubCategoryDesc(String subCategoryDesc) {
		this.subCategoryDesc = subCategoryDesc;
	}


	/**
	 * @return the category
	 */
	public CategoryEntity getCategory() {
		return category;
	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubCategoryEntity [subCategoryId=" + subCategoryId
				+ ", subCategoryName=" + subCategoryName + ", subCategoryLogo="
				+ Arrays.toString(subCategoryLogo) + ", popularity="
				+ popularity + ", subCategoryDesc=" + subCategoryDesc
				+ ", category=" + category + "]";
	}
}
