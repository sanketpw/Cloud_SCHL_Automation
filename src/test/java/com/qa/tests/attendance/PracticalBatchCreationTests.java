package com.qa.tests.attendance;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePageAdmin;
import com.qa.pages.LoginPageAdmin;
import com.qa.pages.attendance.Attendance;
import com.qa.pages.attendance.PracticalBatchCreation;

public class PracticalBatchCreationTests extends BaseClass
{

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
    Attendance attendance;
    PracticalBatchCreation practical;
	InputStream dataIs;
	JSONObject loginUsers;

	public static WebDriver driver;
	
	

	@BeforeClass
	public void beforeClass() throws Exception 
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

	
	
	@AfterClass
	public void afterClass()
	{

	}
	
	

	@BeforeMethod
	public void beforeMethod(Method m) throws Exception
	{
		driver = initializeDriverBFT("UrlCloudSchoolAdmin");

		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
	}

	
	
	@AfterMethod
	public void afterMethod()
	{
	}

	
	
	

	@Test(priority = 1)
	public void User_Able_To_Create_Practical_Batch () throws IOException, InterruptedException 
	{
		loginPage = new LoginPageAdmin(driver);
		attendance = new Attendance(driver);
		practical = new PracticalBatchCreation(driver);
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"),
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
		
		
//		homePage.openAttendance();
//		attendance.OpenMaster();
//		attendance.OpenBatch();
//		practical.OpenPracticalBatch();
//		attendance.SelectAttendanceSession();
//		Thread.sleep(2000);
//		attendance.SelectTheoryBatch();
//		practical.EnterPracticalBatchShortName();
//		practical.EnterPracticalBatchName();
//		//attendance.ClickSubmitbutton();
		
		
		System.out.println("click on Academic -> Time Table -> Time Slots & Batch -> Practical Batch");
		Thread.sleep(2000);
		
		System.out.println("Click on Academic");
		driver.findElement(By.linkText("ACADEMIC")).click();
		
		System.out.println("Click on Time Table");
		driver.findElement(By.linkText("Time Table")).click();
		
		System.out.println("Click on Time Slots & Batch");
		driver.findElement(By.linkText("Time Slots & Batch")).click();
		
		System.out.println("Click on Practical Batch creation");
		driver.findElement(By.linkText("Practical Batch creation")).click();
		
		//driver.get("https://school.mastersofterp.in/Attendance/PracticalBatch/Index"); //Live URL
		//driver.get("http://schooluat.mastersofterp.in/Attendance/PracticalBatch/Index"); //UAT URL
		
		System.out.println("Select value Standard (Class)");
		Thread.sleep(2000);
		Select ddlCourse = new Select(driver.findElement(By.id("ddlCourse")));
		ddlCourse.selectByIndex(2); // Value - STD-II
		
		System.out.println("click on Edit Button");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("i.fa.fa-pencil-square-o")).click();
		
		System.out.println("Click on Update Button");
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddSpan")).click();
		Thread.sleep(1000);
		
	}//student_PracticalBatchRegistration end


}// AttendancePracticalBatchCreationTests class end






















































//generalised method call for dropdown function
//attendance.dropdown("id", "ddlAttendanceSession","ATTENDANCE SESSION");
//attendance.dropdown("id", "ddlBasicCourse","BSC SEM 1");
//attendance.dropdown("id", "ddlCourse","BSC SEM 1 - 1");
//attendance.dropdown("id", "ddlSubject","HINDI--HINDI(1.00)");
//attendance.dropdown("id", "ddlTheoryBatch","BSC TH BATCH");
//attendance.dropdown("id", "ddlTeacher","QUALITY ASSURANCE");
