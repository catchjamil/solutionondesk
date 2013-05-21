package com.sd.web.security;

import com.sd.web.dto.BaseDTO;

public class Ticket extends BaseDTO {

	private String userName;
	private String role;
	private String email;

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public String getUserName() {
		return userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
