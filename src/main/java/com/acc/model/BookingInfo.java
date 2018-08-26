package com.acc.model;

public class BookingInfo {
	
	private Integer userId;
	
	private Integer docId;
	
	private Boolean transportService;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Boolean getTransportService() {
		return transportService;
	}

	public void setTransportService(Boolean transportService) {
		this.transportService = transportService;
	}
	
	
}
