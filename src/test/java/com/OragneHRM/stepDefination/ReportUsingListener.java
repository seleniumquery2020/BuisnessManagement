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
import org.testng.annotations.Test;

import com.orangeHRM.automationUtitlites.PropertiesUtilities;

public class ReportUsingListener {
	
	WebDriver driver;
	
	@Test(groups = {"Smoke"})
	public void launchApplication() {
		HashMap<String, String> map = PropertiesUtilities.getProperties();
		System.setProperty(map.get("chromeKey"), map.get("chromePath"));


		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(map.get("url"));

	}
	@Test(priority =  1)
	public void verifyTheLoginDetails() throws InterruptedException {

		Thread.sleep(5000);

		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

		driver.findElement(By.tagName("button")).click();

		Thread.sleep(5000);
		
		try {
			WebElement title = driver.findElement(By.xpath("//h6[text()='PIM']"));
			if (title.isDisplayed()) {
			    Assert.assertTrue(true, "User logged in sucessfully");				
			}
			driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
			driver.findElement(By.linkText("Logout")).click();
			
		} catch (RuntimeException e) {		

			System.out.println("User loging is unsucessfully");
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
}
