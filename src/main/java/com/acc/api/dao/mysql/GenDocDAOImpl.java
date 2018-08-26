package com.acc.api.dao.mysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.acc.model.DoctorInfo;
import com.acc.model.State;

@Service
public class GenDocDAOImpl {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	public List<DoctorInfo> getDoctorList(String state)  {
		
		
		String sql = "SELECT * from gen_doc_info WHERE state = ?";
		List<DoctorInfo> list = jdbcTemplate.query(sql,new Object[]{state} ,new BeanPropertyRowMapper<DoctorInfo>(DoctorInfo.class));
		
		return list;
		
	}
	
	public List<State> getStateList(){
		String sql = "SELECT distinct(state) FROM gen_doc_info";
		List<State> list = jdbcTemplate.query(sql,new Object[]{} ,new BeanPropertyRowMapper<State>(State.class));
		// queryForList
		return list;
	}
	
	
	private <T> T listChecker(List<T> list){
		
		if(list != null && !list.isEmpty()){
			System.out.println(list.get(0));
			return list.get(0);
		}else{
			return null;
		}
		
	}

}
