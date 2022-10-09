package com.OragneHRM.stepDefination;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		
		
		String[][] details= { {"Admin","admin123"}};
		return details;
	}
	
	 @BeforeSuite
		public void startReport() {
			
			extentHtmlReporter = new ExtentHtmlReporter(new File("C:\\CountersignTechnology\\BuisnessManagement\\Reports\\Report_"+timeStamp()+".html"));
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentHtmlReporter);
			
			
			
	}
	 
	
	@Test(groups = {"Smoke"})
	public void launchApplication() {
		extentTest =  extentReports.createTest("launchApplication() execution");
		HashMap<String, String> map = PropertiesUtilities.getProperties();
		System.setProperty(map.get("chromeKey"), map.get("chromePath"));
		extentTest.info("launching Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		extentTest.info("User hit the application url as "+map.get("url"));
		driver.get(map.get("url"));

	}
	
	@Test(dataProvider = "details" , priority =  1,dependsOnMethods = {"launchApplication"}, groups = {"Smoke"})
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
				extentTest.info("User logged in sucessfully");
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
			try {
				extentTest.addScreenCaptureFromPath(getScreenshot());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Assert.fail();
		}
		
		
	}
	
	      
     public String getScreenshot() {
    	 
    	 TakesScreenshot shot  = (TakesScreenshot) driver;
    	 
    	 File srcFile = shot.getScreenshotAs(OutputType.FILE);
    	 String path = "C:\\CountersignTechnology\\BuisnessManagement\\Screenshot\\Screenshot_"+timeStamp()+".png";
    	 File destFile = new File(path);
    	 try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			
		}
    	 
    	 return path;
     }
     
     public String timeStamp() {
    	 
    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy_hhmmss");
    	String date = simpleDateFormat.format(new Date());
    	 return date;
     }
    
    @AfterSuite
    public void stopReport() {
    	extentReports.flush();
    }
    
}
