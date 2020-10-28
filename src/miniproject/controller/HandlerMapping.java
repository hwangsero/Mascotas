package miniproject.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping(String propLocation) {
		mappings = new HashMap<>();
		Properties prop = new Properties();
		
		try {
			//파일이 있는지 확인(읽기)
			InputStream inStream 
					= new FileInputStream(propLocation);
			//파일 추출
			prop.load(inStream);
			
			//properties 내에서 key값만 뽑아오는 메소드
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				String className = prop.getProperty(key.toString());
				
				System.out.println(key+ " 키 : " + className);
				
				Class<?> clz = Class.forName(className);
				
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Controller getController(String uri) {
		
		
		return mappings.get(uri); 
	}

}











