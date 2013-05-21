package com.sd.web.dto;

public class UserRegistrationDTO extends BaseDTO {

	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String phoneNumber;
	private String role;
	private String address;
	private String country;
	private String state;
	private String city;

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public String getState() {
		return state;
	}

	public String getUserName() {
		return userName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
