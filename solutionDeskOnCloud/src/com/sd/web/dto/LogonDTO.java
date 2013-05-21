package com.sd.web.dto;

public class LogonDTO extends BaseDTO {

	private String userName;
	private String password;
	private String role;
	private String email;

	public String getEmail() {
		return email;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	/**
	 * @return Returns the userName.
	 */
	public String getUserName() {
		return userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password
	 *            The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @param userName
	 *            The userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
