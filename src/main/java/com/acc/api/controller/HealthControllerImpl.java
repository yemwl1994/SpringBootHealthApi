package com.acc.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acc.api.bo.HealthBo;
import com.acc.model.BookingInfo;
import com.acc.model.Login;
import com.acc.model.SignUp;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;

	
	
@RestController
@CrossOrigin(origins = "*")
public class HealthControllerImpl implements HealthController {
	
	@Autowired
	@Qualifier("HealthBoImpl")
	private HealthBo healthBo;
	
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleMessageNotReadableException(HttpServletRequest request,
    		HttpMessageNotReadableException exception){
    	
    	exception.printStackTrace();

    	String msg = "Invalid request message format.";
    	
    	if(exception.getCause() instanceof JsonMappingException){
    		JsonMappingException jme = (JsonMappingException) exception.getCause();
    		
    		List<Reference> list = jme.getPath();
//    		errorList = new ArrayList<ErrorMessage>();
    		
//    		for(Reference r : list){
//    			String msgStr = r.getFieldName()  + " is invalid.";
//				ErrorMessage em = new ErrorMessage();
//				em.setErrorCode("INVALID_FORMAT");
//				em.setErrorMessage(msgStr);
//				errorList.add(em);
//    		}
    	}
//    	responseBody.setErrors(errorList);
//		responseBody.setStatusMessage(msg);
		
//		ResponseEntity<K8StatusResponse> response = new ResponseEntity<K8StatusResponse>(responseBody,
//				HttpStatus.BAD_REQUEST);
		
		return null;
    }
    
    // Hibernate Validator .
	
	@Override
	@RequestMapping(value = "/user", consumes = { "application/json" }, 
					method = RequestMethod.POST, headers = "Accept=application/json",
					produces = "application/json")
	public ResponseEntity<?> postLogin(@RequestBody Login log/* @Valid BindingResult result*/) {
		return healthBo.postLogin(log);
	}


	@Override
	@RequestMapping(value = "/reg", consumes = { "application/json" }, 
		method = RequestMethod.POST, headers = "Accept=application/json",
		produces = "application/json")
	public ResponseEntity<?> postSignUp(@RequestBody SignUp info) {
		
		return healthBo.postSignUp(info);
	}


	@Override
	@RequestMapping(value = "/doc", consumes = { "application/json" },
			params = "state",method = RequestMethod.GET, headers = "Accept=application/json",
			produces = "application/json")
	public ResponseEntity<?> getGenDoc(@RequestParam("state") String state) {
	
		return healthBo.getGenDocList(state);
	}
	
	@RequestMapping(value = "/states", consumes = { "application/json" },
			method = RequestMethod.GET, headers = "Accept=application/json",
			produces = "application/json")
	public ResponseEntity<?> getStateList() {
	
		return healthBo.getStateList();
	}


	@Override
	@RequestMapping(value = "/book", consumes = { "application/json" }, 
		method = RequestMethod.POST, headers = "Accept=application/json",
		produces = "application/json")
	public ResponseEntity<?> postBooking(@RequestBody BookingInfo info) { //@Valid
		
		return healthBo.postBooking(info);
	}
	
	
	
	

}
