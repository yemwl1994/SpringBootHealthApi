package com.acc.api.bo;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acc.api.dao.mysql.BookingDAOImpl;
import com.acc.api.dao.mysql.GenDocDAOImpl;
import com.acc.api.dao.mysql.RefDAOImpl;
import com.acc.api.dao.mysql.UserDAOImpl;
import com.acc.model.BookingInfo;
import com.acc.model.BookingStatus;
import com.acc.model.DoctorInfo;
import com.acc.model.Error;
import com.acc.model.Login;
import com.acc.model.LoginStatus;
import com.acc.model.SignUp;
import com.acc.model.SignUpStatus;
import com.acc.model.State;

@Service("HealthBoImpl")
public class HealthBoImpl implements HealthBo {
	
	@Autowired
	UserDAOImpl userHealth;
	
	@Autowired
	RefDAOImpl refDao;
	
	@Autowired
	GenDocDAOImpl genDocDao;
	
	@Autowired
	BookingDAOImpl bookDao;
	
	@Override
	public ResponseEntity<?> postLogin(Login log) {
		
		try {
			LoginStatus ls = userHealth.getStates(log);
			if(ls == null) {
				return returnWithException("Login Issue");
			}
			return new ResponseEntity<LoginStatus>(ls,HttpStatus.OK);
		} catch (IOException e) {
			return returnWithException("Login Issue");
		}
		
		
	}

	@Override
	public ResponseEntity<?> postSignUp(SignUp info) {
		
		// check the username exist
		
		Integer value = userHealth.checkUserName(info.getUserName());

		if(value > 0) {
			return returnWithException("Username Exist");
		} else {
			//insert into db 
			try {
				
				int rows = userHealth.insertSignUpInfo(info);
				if(rows > 0) {
					SignUpStatus sus = new SignUpStatus();
					sus.setSuccess(true);
					return new ResponseEntity<SignUpStatus>(sus,HttpStatus.OK);
				}else {
					
					return returnWithException("Sql Exception");
					
				}

			}catch(Exception e) {
				e.printStackTrace();
				return returnWithException("File IO Exception");
			
			}
		}
	}
	
	public ResponseEntity<?> getGenDocList(String state){
		
		List<DoctorInfo> list = genDocDao.getDoctorList(state);
		
		if(list.size() > 0) {
			
			return new ResponseEntity<List<DoctorInfo>>(list,HttpStatus.OK);
		}else {
			
			return returnWithException("No Doc Found");
		}

	}
	
	@Override
	public ResponseEntity<?> postBooking(BookingInfo info) {
		
		// gen the RefId
		String bookingRefId = getNextRefNo("W");
		
		Integer value = bookDao.insertBookingInfo(info, bookingRefId);
		
		if(value > 0) {
			BookingStatus bk = new BookingStatus();
			bk.setSuccess(true);
			bk.setBookingRefId(bookingRefId);
			
			return new ResponseEntity<BookingStatus>(bk,HttpStatus.OK);
			
			
		} else {
			
			return returnWithException("Booking Confirmation Fail");
		}

	}

	
	private String getNextRefNo(String prefix){
		
		DecimalFormat numberFormat = new DecimalFormat("00000000");
		Number nextSeq = getNextRefSequence(prefix);
		String nextSeqStr = numberFormat.format(nextSeq);
		StringBuffer sb = new StringBuffer(prefix).append(nextSeqStr);
		
		return sb.toString();
		
	}
	
	private Number getNextRefSequence(String prefix) {
		// update the refId
		int row = refDao.updateRefId(prefix);
		
		// then retrieve the latest 
		if(row > 0) {
			Number value = refDao.selectRefId(prefix);
			return value;
		} else {
			return 0;
		}
	}
	

	@Override
	public ResponseEntity<?> getStateList() {
		// TODO Auto-generated method stub
		List<State> list = genDocDao.getStateList();
		
		if(list.size() > 0) {
			
			return new ResponseEntity<List<State>>(list,HttpStatus.OK);
		}else {
			
			return returnWithException("No State Found");
		}
	}
	
	
	private ResponseEntity<Error> returnWithException(String errorMessage) {
		Error err = new Error();
		err.setError(errorMessage);
		return new ResponseEntity<Error>(err,HttpStatus.OK);
		
	}

	


}
