package com.acc.api.dao.mysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RefDAOImpl {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	public int updateRefId(String prefix) {
		String sql = "UPDATE refs SET ref = ref + 1 WHERE prefix = ?";		
		int row = jdbcTemplate.update(sql, new Object[]{prefix});	
		return row;
	}
	
	public Number selectRefId(String prefix) {
		String sql = "SELECT ref FROM refs where prefix = ?";
		Number value = (Number) jdbcTemplate.queryForObject(sql,new Object[]{prefix} ,Number.class);
		return value;
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
