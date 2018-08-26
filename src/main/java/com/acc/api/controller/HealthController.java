package com.acc.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.acc.model.BookingInfo;
import com.acc.model.Login;
import com.acc.model.SignUp;

public interface HealthController {
	
	public ResponseEntity<?> postLogin(@RequestBody Login log);
	
	public ResponseEntity<?> postSignUp(@RequestBody SignUp info);
	
	public ResponseEntity<?> getGenDoc(@RequestParam("state") String state);
	
	public ResponseEntity<?> getStateList();
	
	public ResponseEntity<?> postBooking(@RequestBody BookingInfo info);
}
