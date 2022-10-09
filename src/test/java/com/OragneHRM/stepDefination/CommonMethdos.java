package com.OragneHRM.stepDefination;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.orangeHRM.automationUtitlites.BaseClass;

public class CommonMethdos extends BaseClass {

	@BeforeTest
	public void login() {

		System.out.println("Login Process");
	}

	

	@AfterTest
	public void logout() {

		System.out.println("Logout Process");

	}
}
