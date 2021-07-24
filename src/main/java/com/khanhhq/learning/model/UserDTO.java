package com.khanhhq.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[User]")
public class UserDTO {
	@Id
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private boolean status;

	public UserDTO() {
	}

	public UserDTO(String email, String password, String role, boolean status) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	public UserDTO(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", password=" + password + ", role=" + role + ", status=" + status + "]";
	}

}
