package com.acc.api.dao.mysql;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.acc.model.Login;
import com.acc.model.LoginStatus;
import com.acc.model.SignUp;
import com.acc.util.PropertiesUtil;

@Service
public class UserDAOImpl {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	// get Login Status
	public LoginStatus getStates(Login log) throws IOException {
		
		Properties prop = PropertiesUtil.getProperties();
		System.out.println(prop.getProperty("acchealth.secretkey"));
		String sql = "SELECT id, user_name, email, address, postcode, country, state from user WHERE user_name = ? and password = AES_ENCRYPT(?,'" + 
				prop.getProperty("acchealth.secretkey","accenturehealthcha") +"')";
		
		List<LoginStatus> list = jdbcTemplate.query(sql,new Object[]{log.getUserName(),log.getPassword()} ,new BeanPropertyRowMapper<LoginStatus>(LoginStatus.class));
		
		return listChecker(list);
	}
	
	public int insertSignUpInfo(SignUp info) throws IOException {
		Properties prop = PropertiesUtil.getProperties();
		String sql = "INSERT INTO acc_health.user (user_name,password,email,gender,address,postcode,country,state) " +
				"VALUES (?, AES_ENCRYPT(?,'"+ prop.getProperty("acchealth.secretkey","accenturehealthcha") + "'), ?, ?, ?, ?, ?, ?)";
		int row = jdbcTemplate.update(sql,new Object[] {info.getUserName(), info.getPassword(),info.getEmail(), info.getGender(),info.getAddress(), info.getPostCode(), info.getCountry(), info.getState()});
		
		return row;
	}
	
	
	public Integer checkUserName(String username) {
	
		String sql = "SELECT  count(user_name) from acc_health.user WHERE user_name = ?";
		Integer value = jdbcTemplate.queryForObject(sql,new Object[]{username} ,Integer.class);	
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
