package com.qa.tests.establishment;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePageAdmin;
import com.qa.pages.LoginPageAdmin;
import com.qa.pages.establishment.Establishment;
import com.qa.pages.establishment.LeaveDetails;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;

public class LeaveDetailsTests extends BaseClass {
	
	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Establishment establishment;
	LeaveDetails leaveDetails;
	BaseClass baseClass;

	InputStream dataIs;
	JSONObject loginUsers;

	ExcelReader excelreader;
	
	public static WebDriver driver;
	
	
	@BeforeClass
	public void beforeClass() throws Exception {
		try {
			String dataFileName = "data/loginUsers.json";
			dataIs = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(dataIs);
			loginUsers = new JSONObject(tokener);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (dataIs != null) {
				dataIs.close();
			}
		}
	}
	
	@AfterClass
	public void afterClass() {
}
	
	@BeforeMethod
	public void beforeMethod(Method m) throws Exception{
		
		driver = initializeDriverBFT("UrlCloudSchoolAdmin");
		
		System.out.println("\n" + "******Starting Test: " + m.getName() + "*****" + "\n");
	}
	
	@AfterMethod
	public void afterMethod() {
	}
	
	@Test()
	
	public void LeaveDetails() throws IOException, Exception {
	
		loginPage = new LoginPageAdmin(driver);
		establishment = new Establishment(driver);
		leaveDetails = new LeaveDetails(driver);
		//baseClass = new BaseClass(driver);
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"), 
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
		
		//homePage.openEstablishment();
		driver.findElement(By.linkText("ESTABLISHMENT")).click();
		System.out.println("Click on ESTABLISHMENT");
		
		//establishment.openTransaction();
		driver.findElement(By.linkText("Transaction")).click();
		System.out.println("Click on Transaction");
		
		//establishment.openLeaveTransaction();
		driver.findElement(By.linkText("Leave Transaction")).click();
		System.out.println("Click on Leave Transaction");
		
		//establishment.openLeaveDetails();
		driver.findElement(By.linkText("Leave Details")).click();
		System.out.println("Click on Leave Details");
		Thread.sleep(2000);
		
		//establishment.EditButton();
		driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/center/i")).click();
		System.out.println("Click on Edit Button");
		Thread.sleep(2000);
		
		
//		//leaveDetails.btnAddNew();
//		driver.findElement(By.id("btnAddNew")).click();
//		System.out.println("Click on btnAddNew");
//		
//		//leaveDetails.ddlLeaveName();
//		Select ddlLeaveName = new Select(driver.findElement(By.id("ddlLeaveName")));
//		ddlLeaveName.selectByVisibleText("CASUAL LEAVE");
//		System.out.println("Click on ddlLeaveName");
//		
//		//leaveDetails.LeaveDays();
//		
//		
//		//leaveDetails.ddlStaffType();
//		Select ddlStaff = new Select(driver.findElement(By.id("ddlStaffType")));
//		ddlStaff.selectByVisibleText("TEACHING");
//		System.out.println("Click on ddlStaff");
//		
//		//leaveDetails.ddlPeriod();
//		Select ddlPeriod = new Select(driver.findElement(By.id("ddlPeriod")));
//		ddlPeriod.selectByVisibleText("JULY-JUNE");
//		System.out.println("Click on ddlPeriod");
//		
//		//leaveDetails.MaxDays();
//		driver.findElement(By.id("txtMaxDays")).clear();
//		driver.findElement(By.id("txtMaxDays")).sendKeys("12");
//		System.out.println("Enter on txtMaxDays");
		
		//leaveDetails.btnSubmit();
		driver.findElement(By.id("btnSubmit")).click();
		System.out.println("Click on btnSubmit");
		Thread.sleep(2000);

		
		
		String confirmationMsg = getText(driver.findElement(By.id("StrmMsg")));
		System.out.println("Confirmation Message - " + confirmationMsg);
		
		//Assertion applied on last message "Record Updated Succesfully!"
		String expectedConfirmationTxt = "Record Updated Succesfully!";
		System.out.println("Actual Confirmation Text - " + confirmationMsg + "\n"
				+ "Expected Confirmation Text - " + expectedConfirmationTxt);
		
		Assert.assertEquals(confirmationMsg, expectedConfirmationTxt);
		
		// this is for screen shot
		Utilities.getAScreenShot();
		
	}
}

		
		
		
		
		
		
	