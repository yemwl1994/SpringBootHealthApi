package com.acc.api.bo;

import org.springframework.http.ResponseEntity;

import com.acc.model.BookingInfo;
import com.acc.model.Login;
import com.acc.model.SignUp;

public interface HealthBo {
	
	public ResponseEntity<?> postLogin(Login log);
	
	public ResponseEntity<?> postSignUp(SignUp info);
	
	public ResponseEntity<?> getGenDocList(String state);
	 
	public ResponseEntity<?> getStateList();
	
	public ResponseEntity<?> postBooking(BookingInfo info);
	
	// public ResponseEntity<?> 
}
