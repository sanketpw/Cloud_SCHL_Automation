package com.qa.tests.attendance;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePageAdmin;
import com.qa.pages.LoginPageAdmin;
import com.qa.pages.attendance.Attendance;
import com.qa.pages.attendance.SessionCreation;
import com.qa.pages.attendance.TheoryBatchCreation;
import com.qa.utilities.Utilities;

public class AttendanceTests extends BaseClass
{

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
    Attendance attendance;
    SessionCreation session;
    TheoryBatchCreation theorybatch;
	InputStream dataIs;
	JSONObject loginUsers;

	public static WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() throws Exception 
	{
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

	@BeforeClass
	public void beforeClass() throws Exception 
	{
//		try {
//			String dataFileName = "data/loginUsers.json";
//			dataIs = getClass().getClassLoader().getResourceAsStream(dataFileName);
//			JSONTokener tokener = new JSONTokener(dataIs);
//			loginUsers = new JSONObject(tokener);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			if (dataIs != null) {
//				dataIs.close();
//			}
//		}
	}

	//testing add new feature
	
	@AfterClass
	public void afterClass()
	{

	}
	
	

	@BeforeMethod
	public void beforeMethod(Method m) throws Exception
	{
		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
		
		
	}
	@AfterMethod
	public void afterMethod()
	{

	}

	@BeforeTest
	private void beforeTest() throws Exception
	{
		driver = initializeDriverBFT("UrlCloudSchoolAdmin");
		loginPage = new LoginPageAdmin(driver);
		attendance = new Attendance(driver);
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"),
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
	}
	
	

	@Test(priority = 1)
	public void User_Able_To_Allow_DayWise_Attendance_Entry () throws Exception 
	{
		
		session = new SessionCreation(driver);
		
		//homePage.openAttendance();
		driver.findElement(By.linkText("ACADEMIC")).click();
		System.out.println("click on open ACADEMIC");

		//attendance.OpenTransaction();
		driver.findElement(By.linkText("Attendance")).click();
		System.out.println("Click on Attendance");
		
		//attendance.OpenAttendanceEntry();
		driver.findElement(By.linkText("Attendance Entry")).click();
		System.out.println("click on Attendance Entry");
		
		//session.OpenAttendance ();
		//driver.findElement(By.xpath("/html/body/div[4]/aside[1]/section/ul/ul/li[4]/ul/li[1]/ul/li[3]/a/span")).click();
		driver.findElement(By.linkText("Daily Attendance")).click();
		System.out.println("click on Attendance Page");
		
		//session.ddlCourse();
		Select ddlCourse = new Select(driver.findElement(By.id("ddlCourse")));
		ddlCourse.selectByVisibleText("STANDARD-5");
		System.out.println("ddlCourse STANDARD-5");
		
		
		//session.ddlSection();
		Select ddlSection = new Select(driver.findElement(By.id("ddlSection")));
		ddlSection.selectByVisibleText("A");
		System.out.println("Select on ddlSection A");
		
		//session.attendanceDate();
		driver.findElement(By.id("attendanceDate")).click();
		driver.findElement(By.className("day")).click();
		//driver.findElement(By.id("attendanceDate")).sendKeys("09/12/2022");
		System.out.println("select attendanceDate");

		//Alert available only when used 2nd time same data
		//acceptAlert();
		 try {
				WebDriverWait wait = new WebDriverWait(driver, 30 /*timeout in seconds*/);
				if(wait.until(ExpectedConditions.alertIsPresent())==null) {
					Thread.sleep(1000);	
				    System.out.println("alert was not present");
				   
				} else {
				    Alert alert = driver.switchTo().alert();
				    alert.accept();
				    System.out.println("alert was present and accepted");
				}
			}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("click on acceptAlert");
		
		//attendance.ClickSubmitbutton();
		driver.findElement(By.id("btnSubmit")).click();
		

		String confirmationMsg = getText(driver.findElement(By.id("success")));
		System.out.println("Confirmation Message - " + confirmationMsg);
		
		//Assertion applied on last message "Record Updated Succesfully!"
		String expectedConfirmationTxt = "Record Saved Successfully!";
		System.out.println("Actual Confirmation Text - " + confirmationMsg + "\n"
				+ "Expected Confirmation Text - " + expectedConfirmationTxt);
		
		Assert.assertEquals(confirmationMsg, expectedConfirmationTxt);
		
		Thread.sleep(1000);
		Utilities.getAShot();

	}//Attendance_SessionCreation method end

}
