package com.khanhhq.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[Category]")
public class CategoryDTO {
	@Id
	@Column
	private String categoryID;
	@Column
	private String categoryName;
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public CategoryDTO() {
	}
	@Override
	public String toString() {
		return "CategoryDTO [categoryID=" + categoryID + ", categoryName=" + categoryName + "]";
	}
	
	
}
