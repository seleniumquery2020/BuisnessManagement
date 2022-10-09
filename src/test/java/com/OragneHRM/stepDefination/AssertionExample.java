package com.OragneHRM.stepDefination;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionExample {
		
	public static void main(String[] args) {
		
		 String s = "Selenium";
		 String s1 = "aws";
		 
		 //To perform verify process		 
		 SoftAssert softAssert = new SoftAssert();
		 softAssert.assertEquals(s, s1,"Strings are same");
		
		 System.out.println("Soft assert execution completed");
		 
		 //To perform Validation process - Hard Assert
		 Assert.assertEquals(s, s1,"String are not same");
		 System.out.println("Hard assert execution completed");
	}

}
