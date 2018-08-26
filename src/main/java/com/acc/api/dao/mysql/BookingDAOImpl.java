package com.acc.api.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.acc.model.BookingInfo;

@Service
public class BookingDAOImpl {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	public int insertBookingInfo(BookingInfo info, String bookRefId) {
		
		String sql = "INSERT INTO acc_health.general_booking_log (`user_id`, `doc_id`, `booking_ref_id`, `transport_service`) VALUES (?, ?, ?, ?)";
		
		int row = jdbcTemplate.update(sql,new Object[] {info.getUserId(), info.getDocId(),bookRefId, info.getTransportService()});
		
		return row;
	}

}
