package com.orangeHRM.automationUtitlites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtilities {

	public static HashMap<String, String> getProperties(){

		Properties properties = new Properties();

		File file = new File(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\orangeHRM\\objectRepo\\GlobalRepo.properties");

		try {
			properties.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		HashMap<String, String> map = new HashMap<String, String>();
		map.putAll((Map)properties);
		
		//Set<Map.Entry<String, String>> mapEntry = map.entrySet();
		
		//System.out.println(map.get("username"));
		
		return map;
	}

}
