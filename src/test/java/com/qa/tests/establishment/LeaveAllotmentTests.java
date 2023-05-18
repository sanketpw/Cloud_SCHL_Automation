package com.qa.tests.establishment;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
//import com.qa.pages.payroll.AnnualPaySlipReport;
//import com.qa.pages.payroll.Payroll;
import com.qa.pages.establishment.LeaveAllotment;
//import com.qa.pages.establishment.LeaveTransaction;
import com.qa.utilities.ExcelReader;

public class LeaveAllotmentTests extends BaseClass {
	
	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	LeaveAllotment leaveAllotment;
	Establishment establishment;
	//LeaveTransaction leaveTransaction;
	

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
	
	public void Leave_Allotment() throws IOException, Exception {
	
		loginPage = new LoginPageAdmin(driver);
		leaveAllotment = new LeaveAllotment(driver);
		establishment = new Establishment(driver);
		//leaveTransaction = new LeaveTransaction(driver);
		
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
		
		//establishment.openLeaveAllotment();
		driver.findElement(By.linkText("Leave Allotment")).click();
		System.out.println("Click on Leave Allotment");
		
		//leaveAllotment.ddlOrderBy();
		Select ddlOrderBy = new Select(driver.findElement(By.id("ddlOrder")));
		ddlOrderBy.selectByVisibleText("IDNO");
		System.out.println("Click on ddlOrder IDNO");
		
		//leaveAllotment.ddlStaff();
		Select ddlStaff = new Select(driver.findElement(By.id("ddlStaffType")));
		ddlStaff.selectByVisibleText("TEACHING");
		System.out.println("Click on ddlStaff");
		
		//leaveAllotment.ddlDepartment();
		Select ddlDepartment = new Select(driver.findElement(By.id("ddlDepartment")));
		ddlDepartment.selectByVisibleText("EDUCATION");
		System.out.println("Click on ddlDepartment");
		
		//leaveAllotment.ddlDesignature();
		Select ddlDesignature = new Select(driver.findElement(By.id("ddlDesignature")));
		ddlDesignature.selectByVisibleText("PERMANENT");
		System.out.println("Click on ddlDesignature");
		
		//leaveAllotment.ddlPeriod();
		Select ddlPeriod = new Select(driver.findElement(By.id("ddlPeriod")));
		ddlPeriod.selectByVisibleText("JULY-JUNE");
		System.out.println("Click on ddlPeriod");
		
		//leaveAllotment.ddlYear();
		Select ddlYear = new Select(driver.findElement(By.id("ddlYear")));
		ddlYear.selectByVisibleText("2022");
		System.out.println("Click on ddlYear");
		
		//leaveAllotment.ddlLeave();
		Select ddlLeave = new Select(driver.findElement(By.id("ddlLeave")));
		ddlLeave.selectByVisibleText("CASUAL LEAVE-PERMANENT");
		System.out.println("Click on ESTABLISHMENT");
		
		Thread.sleep(2000);
//		leaveAllotment.CheckBox();
		
		//leaveAllotment.btnSubmit();
		driver.findElement(By.id("btnSubmit")).click();
		System.out.println("Click on btnSubmit");
		
		String confirmationMsg = getText(driver.findElement(By.id("message")));
		System.out.println("Confirmation Message - " + confirmationMsg);
		
		String expectedConfirmationTxt = "Record Saved Successfully!";
		System.out.println("Actual Confirmation Text - " + confirmationMsg + "\n"
				+ "Expected Confirmation Text - " + expectedConfirmationTxt);
		
		Assert.assertEquals(confirmationMsg, expectedConfirmationTxt);
		
		//Utilities.getAScreenShot();
		
	}
}

		
		
		
		
		
		
	