package com.qa.tests.payroll;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePageAdmin;
import com.qa.pages.LoginPageAdmin;
import com.qa.pages.payroll.LockUnlockSalary;
import com.qa.pages.payroll.MonthlyWork;
import com.qa.pages.payroll.Payroll;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;

public class LockUnlockSalaryTests extends BaseClass {
	
	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Payroll payroll;
	MonthlyWork monthlyWork;
	LockUnlockSalary lockUnlockSalary;
	

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
	
	public void LockUnlockSalary() throws IOException, Exception {
	
		loginPage = new LoginPageAdmin(driver);
		payroll = new Payroll(driver);
		lockUnlockSalary = new LockUnlockSalary(driver);
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"), 
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
		
		//homePage.openPayroll();
		driver.findElement(By.linkText("PAYROLL")).click();
		System.out.println("Open Payroll");
		
		//payroll.openTransaction();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Transactions']/parent::*")).click();
		System.out.println("open Transaction");
		
		//payroll.openMonthlyWork();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Monthly Work']/parent::*")).click();
		System.out.println("open MonthlyWork");
		
		//payroll.openLockUnlockSalary();
		System.out.println("open LockUnlockSalary");
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Lock/Unlock Salary']/parent::*")).click();
		
		//lockUnlockSalary.checkbox button();
		System.out.println("click LOCK/UNLOCK checkbox");
		driver.findElement(By.xpath("//tbody[@id='tbodySalaryLock']/tr/td[4]/input")).click();
		
		//lockUnlockSalary.btntemplock();
		driver.findElement(By.id("btntemplock")).click();
		System.out.println("click btntemplock");
		
		//Assertion applied on last message "Record Updated Succesfully!"
		String confirmationMsg = getText(driver.findElement(By.id("message")));
		System.out.println("Confirmation Message - " + confirmationMsg);
		
		String expectedConfirmationTxt = "Record Updated Succesfully!";
		System.out.println("Actual Confirmation Text - " + confirmationMsg + "\n"
				+ "Expected Confirmation Text - " + expectedConfirmationTxt);
		
		Assert.assertEquals(confirmationMsg, expectedConfirmationTxt);
		
		
		Thread.sleep(2000);
		Utilities.getAShot();
		
	}
}

		
		
		
		
		
		
	