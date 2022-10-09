package com.OragneHRM.stepDefination;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.orangeHRM.automationUtitlites.PropertiesUtilities;

public class Demo {
	
	WebDriver driver;
	ExtentTest extentTest;
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    
    
	@DataProvider(name = "details")
	public String[][] loginDetails(){
		
		
		String[][] details= { {"Sonali","Supriya123"} ,{"Admin","admin123"} , {"Pragati","Selenium123"} };
		return details;
	}
	
	 @BeforeSuite
		public void startReport() {
			
			extentHtmlReporter = new ExtentHtmlReporter(new File("C:\\CountersignTechnology\\BuisnessManagement\\Reports\\report.html"));
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentHtmlReporter);
			
			
			
	}
	 
	
	@Test(priority =  0)
	public void launchApplication() {
		extentTest =  extentReports.createTest("launchApplication() execution");
		HashMap<String, String> map = PropertiesUtilities.getProperties();
		System.setProperty(map.get("chromeKey"), map.get("chromePath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(map.get("url"));

	}
	
	@Test(dataProvider = "details" , priority =  1)
	public void verifyTheLoginDetails(String username,String Password) throws InterruptedException {

		extentTest =  extentReports.createTest("verifyTheLoginDetails() execution with Username : "+username+" Password : "+Password);
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(Password);

		driver.findElement(By.tagName("button")).click();

		Thread.sleep(5000);
		
		try {
			WebElement title = driver.findElement(By.xpath("//h6[text()='PIM']"));
			if (title.isDisplayed()) {
				System.out.println("User logged in sucessfully");
				extentTest.pass("User logged in sucessfully");
				Assert.assertTrue(true, "User logged in sucessfully");				
			}
			driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
			driver.findElement(By.linkText("Logout")).click();
			
		} catch (RuntimeException e) {		

			System.out.println("User loging is unsucessfully");
			extentTest.fail("User loging in unsucessfully");
			extentTest.error(e);
			Assert.fail();
		}
		
		
	}
	
	      
   
    
    @AfterSuite
    public void stopReport() {
    	extentReports.flush();
    }
}
