package com.OragneHRM.stepDefination;

import org.testng.annotations.Test;

public class GroupsMethods {
	
	@Test(groups = {"Smoke"})
	public void m1() {
		System.out.println("m1 method");
	}

	@Test(groups = {"Smoke"})
	public void m2() {
		System.out.println("m2 method");
	}

	@Test(groups = {"Smoke"})
	public void m3() {
		System.out.println("m3 method");
	}

	@Test
	public void m4() {
		System.out.println("m4 method");
	}

	@Test
	public void m5() {
		System.out.println("m5 method");
	}

}
