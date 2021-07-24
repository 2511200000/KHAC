package com.khanhhq.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[Student]")
public class StudentDTO {
	@Id
	@Column
	private String studentEmail;
	@Column
	private String fullName;
	@Column
	private String phone;
	@Column
	private String description;
	@Column
	private String interests;
	@Column
	private String img;

	public StudentDTO() {
	}

	public StudentDTO(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
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

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "StudentDTO [studentEmail=" + studentEmail + ", fullName=" + fullName + ", phone=" + phone
				+ ", description=" + description + ", interests=" + interests + ", img=" + img + "]";
	}

}
