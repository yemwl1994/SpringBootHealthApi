package com.acc.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserialAdapter extends JsonDeserializer<Date>{

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		
		
		DateFormat format = null;
		
		String date = jsonParser.getText();
		String pattern = "[\\s/-]+";
		String postPattern = "\\d{4}(0|1){1}\\d{1}[0-3]{1}\\d{1}";
		
		date = date.replaceAll(pattern, "");

		if(date.matches(postPattern)){
			format = new SimpleDateFormat("yyyyMMdd");
			
		}else{
			format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		}
		
		try {
			return format.parse(date);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
