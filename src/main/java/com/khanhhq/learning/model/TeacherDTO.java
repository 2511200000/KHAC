package com.khanhhq.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[Teacher]")
public class TeacherDTO {
	@Id
	@Column
	private String teacherEmail;
	@Column
	private String fullName;
	@Column
	private String phone;
	@Column
	private String description;

	public TeacherDTO() {
	}
 
	public TeacherDTO(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}



	public TeacherDTO(String teacherEmail, String fullName, String phone, String description) {
		this.teacherEmail = teacherEmail;
		this.fullName = fullName;
		this.phone = phone;
		this.description = description;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
