package com.lemonade.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.lemonade.base.BaseClass;

import pageobjects.PageObjects;
import org.openqa.selenium.JavascriptExecutor;

public class LemonadePageMethods extends BaseClass {
	
	PageObjects PO;
	//Defining Test Methods
	
	public void AssertTitle() {
		//Get Window Title and check text is displayed for HomePage
		PO = new PageObjects(driver);
		String title = driver.getTitle();
		System.out.println("Page Title is "+title+"\n");
		//Verify that the Title matches the provided Text
		Assert.assertEquals(title, PO.HomePageTitle);
		Assert.assertEquals(PO.PageTextLocator.getText(), PO.HomePageText);
	}	
	
	public void TestPages() {
		//Navigate to Renters Page
		PO = new PageObjects(driver);
		PO.RentersLink.click();
		//wait for page to load and verify Renters Page text is displayed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(PO.PageTextLocator.getText(), PO.RentersPageText);
		//Navigate to HomeOwners Page
		PO.HomeOwnersPageLink.click();
		//wait for page to load and verify Home Owners Page text is displayed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(PO.PageTextLocator.getText(), PO.HomeOwnersPageText);
		//Navigate to Car Page
		PO.CarPageLink.click();
		//wait for page to load and verify Car Page text is displayed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(PO.PageTextLocator.getText(), PO.CarPageText);
		//Navigate to Pet Page
		PO.PetPageLink.click();
		//wait for page to load and verify Pet Page text is displayed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(PO.PageTextLocator.getText(), PO.PetPageText);
		//Navigate to Life Page
		PO.LifePageLink.click();
		//wait for page to load and verify Life Page text is displayed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(PO.PageTextLocator.getText(), PO.LifePageText);
		//Navigate to GiveBack Page
		PO.GiveBackPageLink.click();
		//wait for page to load and verify GiveBack Page text is displayed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(PO.GiveBackPageTextLocator.getText(), PO.GiveBackPageText);
		PO.MyAccountPageLink.click();
		//wait for page to load and verify Email field is displayed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(true, PO.MyAccountEmail.isDisplayed());
		}	
	
	public void CarInsuranceCheck() throws InterruptedException, IOException {
		
		PO = new PageObjects(driver);
		driver.get(PO.HomePageLink);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait until Check Prices button is visible
		wait.until(ExpectedConditions.visibilityOf(PO.CheckPrices));
		//click on Check Prices
		PO.CheckPrices.click();
		//wait until No Lemonade Account button is visible
		wait.until(ExpectedConditions.visibilityOf(PO.NoLemonadeAccount));	
		PO.NoLemonadeAccount.click();
		wait.until(ExpectedConditions.visibilityOf(PO.NextButton));
		PO.NextButton.click();
		//wait until Car CheckBox is visible
		wait.until(ExpectedConditions.visibilityOf(PO.CarCheckBox));
		Thread.sleep(1000);
		PO.CarCheckBox.click();
		wait.until(ExpectedConditions.visibilityOf(PO.NextButton));
		PO.NextButton.click();
		//wait until First Name text box is visible
		wait.until(ExpectedConditions.visibilityOf(PO.FirstName));
		//Read data from Excel file located in TestData folder
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook =new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//Send FirstName to FirstName field
		PO.FirstName.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		//Send LastName to LastName field
		PO.LastName.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		// Click on Next Button
		wait.until(ExpectedConditions.visibilityOf(PO.NextButton));
		PO.NextButton.click();
		//wait until Location field is visible and send location from Excel value
		wait.until(ExpectedConditions.visibilityOf(PO.Location));
		PO.Location.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
		// Wait until drop down visibility and Press Enter key to select the first value from Drop down
		wait.until(ExpectedConditions.visibilityOf(PO.LocationListBox));
		Actions actions = new Actions(driver);
				actions.sendKeys(Keys.ENTER);
				actions.perform();
		// Wait for page to load and click next button
		wait.until(ExpectedConditions.visibilityOf(PO.NextButton));
		Thread.sleep(1000);
		PO.NextButton.click();
		//wait until Email field is visible and send email from Excel value
		wait.until(ExpectedConditions.visibilityOf(PO.Email));
		//Send Email from Excel to Email field
		PO.Email.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
		// Click on Let Me Know
		wait.until(ExpectedConditions.visibilityOf(PO.LetMeKnow));
		PO.LetMeKnow.click();
		// Add 2 second wait for visibility on Screen
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(PO.SignupConfirmation));
		//Print Signup Confirmation and verify it is displayed on Screen
		System.out.println(PO.SignupConfirmation.getText());
		Assert.assertEquals(true, PO.SignupConfirmation.isDisplayed());
		
	}
	
	public void RentInsuranceCheck() throws InterruptedException, IOException {
		PO = new PageObjects(driver);
		driver.get(PO.HomePageLink);	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PO.RentersLink.click();
		//wait until Check Prices button is visible
		wait.until(ExpectedConditions.visibilityOf(PO.CheckPricesRentLink));
		//click on Check Prices
		PO.CheckPricesRentLink.click();
		//wait until No Lemonade Account button is visible and click Next
		wait.until(ExpectedConditions.visibilityOf(PO.NoLemonadeAccount));	
		PO.NoLemonadeAccount.click();
		wait.until(ExpectedConditions.visibilityOf(PO.NextButton));
		PO.NextButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Read data from Excel file located in TestData folder
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook =new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//Send FirstName from Row 3 to FirstName field
		PO.RentersFirstName.sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		//Send LastName from Row 3 to LastName field
		PO.RentersLastName.sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
		// Click on Lets Do This Button
		wait.until(ExpectedConditions.visibilityOf(PO.LetsDoThisButton));
		PO.LetsDoThisButton.click();
		//wait until Location field is visible and send location from Excel value
		wait.until(ExpectedConditions.visibilityOf(PO.RentersLocation));
		Thread.sleep(2000);
		PO.RentersLocation.sendKeys(sheet.getRow(2).getCell(2).getStringCellValue());
		// Wait until drop down visibility and Press Enter key to select the first value from Drop down
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
				actions.sendKeys(Keys.ENTER);
				actions.perform();
		// Wait for page to load and click next button
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(PO.NextButton)).click();
		// add wait for visibility on screen and click on Next button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		js.executeScript("arguments[0].click();", PO.FireAlarmCheckBox);
		js.executeScript("arguments[0].click();", PO.NextButton);
		// Select roommates checkbox and click next, add wait for visibility
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		js.executeScript("arguments[0].click();", PO.RentersRoommates);
		js.executeScript("arguments[0].click();", PO.NextButton);
		// Select No checkbox for valuable jewellery etc. and click next,	
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		js.executeScript("arguments[0].click();", PO.NoCheckBox);
		js.executeScript("arguments[0].click();", PO.NextButton);
		Thread.sleep(2000);
		// Select No checkbox and click next, add wait for visibility
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		js.executeScript("arguments[0].click();", PO.NoCheckBox);
		js.executeScript("arguments[0].click();", PO.NextButton);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		js.executeScript("arguments[0].click();", PO.NoCheckBox);
		js.executeScript("arguments[0].click();", PO.CarNextButton);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Generate random email to complete process, print the email
		final String randomEmail = randomEmail();
		System.out.println(randomEmail);
		PO.RentersEmail.sendKeys(randomEmail);
		// get date of birth from Excel and send to Website
		String abc = sheet.getRow(2).getCell(4).getStringCellValue();
		String[] date1 = abc.split("/");
		String day = date1[0]; 
		String month = date1[1]; 
		String year = date1[2]; 
		PO.Month.sendKeys(month);
		PO.Day.sendKeys(day);
		PO.Year.sendKeys(year);
		// Accept T&C and click on Next
		js.executeScript("arguments[0].click();", PO.TermsCheckBox);
		wait.until(ExpectedConditions.elementToBeClickable(PO.NextButton)).click();
		//Wait until it calculates and next button is visible
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(PO.NextButton2));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", PO.NextButton2);
		// Click on No
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", PO.NoCheckBox);
		js.executeScript("arguments[0].click();", PO.NextButton);
		// Click on None
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", PO.None);
		js.executeScript("arguments[0].click();", PO.NextButton);
		Thread.sleep(2000);
		// CLick on Next and Lets Go
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		js.executeScript("arguments[0].click();", PO.NextButton);
		js.executeScript("arguments[0].click();", PO.LetsGo);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Verify Quote is generated and deductable options text is shown
		Assert.assertEquals(true, PO.LemonadeInsuranceQuoteText.isDisplayed());
		Assert.assertEquals(true, PO.ChooseDeductableText.isDisplayed());
		Thread.sleep(3000);
	}	
	
}
