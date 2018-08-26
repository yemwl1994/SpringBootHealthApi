package com.acc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class State {
	
	@JsonProperty("state")
	private String state;

	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
