package com.acc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	private static Properties prop = null;
	private static File f = null;
	private static long lastModified = 0;
	private static Object lock = null;
	
	public static Properties getProperties() throws IOException{
		
		if(f == null && lock == null){
			f = new File("config.properties");
		}
		
		if(prop == null && lock ==null){
			lock = new Object();
			synchronized(lock){
				prop = new Properties();
				FileInputStream fis = new FileInputStream(f);
				prop.load(fis);
				PropertiesUtil.lastModified = f.lastModified();
				fis.close();
			}
		}else{
			File f = new File("config.properties");
			
			if(PropertiesUtil.lastModified != f.lastModified()){
				synchronized(lock){
					FileInputStream fis = new FileInputStream(f);
					prop = new Properties();
					PropertiesUtil.lastModified = f.lastModified();
					fis.close();
				}
			}
		}
		
		return prop;
	}
}
