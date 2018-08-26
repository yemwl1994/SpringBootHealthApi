package com.acc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignUp {
	
	@JsonProperty("username")
	private String userName;
	
	private String password;
	
	private String email;
	
	private String gender;
	
	private String address;
	
	@JsonProperty("postcode")
	private String postCode;
	
	private String state;
	
	private String country;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "SignUp [userName=" + userName + ", password=" + password + ", email=" + email + ", gender=" + gender
				+ ", address=" + address + ", postCode=" + postCode + ", state=" + state + ", country=" + country + "]";
	}
	
	
	
	
}
