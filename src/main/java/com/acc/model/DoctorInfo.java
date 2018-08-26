package com.acc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class DoctorInfo {
	
	private int id;
	private String name;
	private String gender;
	private String clinicAddress;	
	private String state;	
	private String longi;	
	private String lat;	
	private String openHr;	
	private String closeHr;	
	private String contactNo;	
	private Integer waitingPatient;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@JsonGetter("clinicAddress")
	public String getClinicAddress() {
		return clinicAddress;
	}
	
	@JsonSetter("clinic_address")
	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}
	
	@JsonGetter("openHr")
	public String getOpenHr() {
		return openHr;
	}
	
	@JsonSetter("openhr")
	public void setOpenHr(String openHr) {
		this.openHr = openHr;
	}
	
	@JsonGetter("closeHr")
	public String getCloseHr() {
		return closeHr;
	}
	
	@JsonSetter("closehr")
	public void setCloseHr(String closeHr) {
		this.closeHr = closeHr;
	}
	
	@JsonGetter("contactNo")
	public String getContactNo() {
		return contactNo;
	}
	
	@JsonSetter("contact_no")
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	@JsonGetter("waitingPatient")
	public Integer getWaitingPatient() {
		return waitingPatient;
	}
	
	@JsonSetter("waiting_patient")
	public void setWaitingPatient(Integer waitingPatient) {
		this.waitingPatient = waitingPatient;
	}
	
	
	
}
