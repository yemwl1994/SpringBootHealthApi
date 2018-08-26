package com.acc.model;

import com.fasterxml.jackson.annotation.JsonGetter;

public class LoginStatus {
	
	private Integer id;
	private String userName;
	private String email;
	private String address;
	private String postcode;
	private String country;
	private String state;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonGetter("username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@JsonGetter("email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonGetter("address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonGetter("postcode")
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	@JsonGetter("country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@JsonGetter("state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "LoginStatus [id=" + id + ", userName=" + userName + ", email=" + email + ", address=" + address
				+ ", postcode=" + postcode + ", country=" + country + ", state=" + state + "]";
	}

	
	
}
