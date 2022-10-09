package com.OragneHRM.stepDefination;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangeHRM.automationUtitlites.PropertiesUtilities;

public class ParamterFromXMLFile {
	
	WebDriver driver;
	
	@Parameters({"browserName","url"})
	@Test
	public void details(@Optional("Edge")String browserName,@Optional("https://www.google.com/")String url) {
		
		System.out.println("Browser Name = "+browserName);
		HashMap<String, String> map = PropertiesUtilities.getProperties();
		
		if(browserName.trim().toUpperCase().equals("CHROME")) {
			
		System.setProperty(map.get("chromeKey"), map.get("chromePath"));
		driver = new ChromeDriver();
		
		} else if(browserName.trim().toUpperCase().equals("EDGE")) {
			
			System.setProperty(map.get("edgeKey"), map.get("edgePath"));
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		System.out.println("Application URl = "+url);
		driver.get(url);
		
	}

}
