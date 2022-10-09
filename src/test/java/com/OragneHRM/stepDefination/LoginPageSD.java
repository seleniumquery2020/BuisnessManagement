package com.OragneHRM.stepDefination;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageSD{

	@Test
	public void getTitle() {

		System.out.println("Title of Page ");
	}

	@Test(enabled = false)
	public void getCurrentUrl() {

		System.out.println("Url of Page ");
	}

	@Test
	public void verifyPage() {

		System.out.println("verifyPage");
	}
	
	@BeforeClass
	public void currentPageTitle() {
		System.out.println("Current Page : " );
	}

	@AfterClass
	public void currentPageUrl() {
		System.out.println("Current Url : ");
		System.out.println("Current Page : " );
	}
	
	@BeforeMethod @AfterMethod
	public void screenShot() {
		System.out.println("Take a Screenshot");
	}
}
