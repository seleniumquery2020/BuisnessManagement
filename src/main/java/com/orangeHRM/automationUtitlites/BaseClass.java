package com.orangeHRM.automationUtitlites;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass extends POJOClass{
	
	HashMap<String, String> map = PropertiesUtilities.getProperties();
	
	
	public void setup() {
		String browserName ="Chrome";	
		System.out.println("Setup method execution started");
		if(browserName.trim().toUpperCase().equals("CHROME")) {
			
			System.setProperty(map.get("chromeKey"),map.get("chromePath"));
			setDriver(new ChromeDriver());
			
		}else if(browserName.trim().toUpperCase().equals("EDGE")) {
			
			System.setProperty(map.get("edgeKey"),map.get("edgePath"));
			setDriver(new EdgeDriver());
			
		}

		getDriver().manage().window().maximize();
		getDriver().get(map.get("url"));
		
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void tearDown() {

		getDriver().quit();
		System.out.println("teardown method execution completed");
	}

}
