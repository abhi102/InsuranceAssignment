package com.lemonade.tests;


import java.io.IOException;

import org.testng.annotations.*;


public class LemonadeTests extends LemonadePageMethods{
	LemonadePageMethods StudioFinderPage;

    //Test that browser opens successfully
	@Test(priority=1)
	public void TestBrowserOpensSuccessfully() throws IOException {
		initialize();
	}
	
	//Test Home Page and Title Assertion
	@Test(priority=2)
	public void TestHomePage() {
		AssertTitle();
	}
	
	//Test Page Links are working correctly
	@Test(priority=3)
	public void TestPageLinks()  {
		TestPages();	
	}
	
	//Test to sign up for Car Insurance in New York
	@Test(priority=4)
	public void TestCarInsurance() throws InterruptedException, IOException {
		CarInsuranceCheck();	
	}
	
	//Test to get quote for Renters Insurance In New York
	@Test(priority=5)
	public void TestRentInsurance() throws InterruptedException, IOException {
		RentInsuranceCheck();	
	}
	
	//Close Browser after Execution
		@AfterClass
		public void teardown() {
			driver.quit();
		}

	
}
