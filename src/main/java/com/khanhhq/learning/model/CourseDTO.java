package com.khanhhq.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[Course]")
public class CourseDTO {
	@Id
	@Column
	private String courseID;
	@Column
	private String title;
	@Column
	private String category;
	@Column
	private String description;
	@Column
	private boolean status;
	
	
	
	public CourseDTO() {
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseId(String courseId) {
		this.courseID = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
