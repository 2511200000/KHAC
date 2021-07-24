package com.khanhhq.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[Admin]")
public class AdminDTO {
	@Id
	@Column
	private String adminEmail;
	@Column
	private String fullName;
	@Column
	private String img;

	 

	public AdminDTO() {
	}

	public AdminDTO(String adminEmail) {
		this.adminEmail = adminEmail;
	 
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "emailDTO [adminEmail=" + adminEmail + ", fullName=" + fullName + ", img=" + img + "]";
	}
}
