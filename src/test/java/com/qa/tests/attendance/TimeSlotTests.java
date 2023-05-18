package com.qa.tests.attendance;

import java.awt.Checkbox;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePageAdmin;
import com.qa.pages.LoginPageAdmin;

public class TimeSlotTests extends BaseClass {

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
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
	public void BeforeMethod(Method m) throws Exception
	{
		driver = initializeDriverBFT("UrlCloudSchoolAdmin");
		
		System.out.println("\n" + "****** Starting Test: " + m.getName() + "*****" + "******" + "\n");
	}
	
	@AfterMethod
	public void afterMethod()
	{
	}
	
	@Test (priority = 1)
	
	public void Time_Slot () throws IOException, InterruptedException
	{
		loginPage = new LoginPageAdmin(driver);
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"), 
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
		
		System.out.println("Path -> Academic -> Time Table -> Time Slots & Batch -> Time Slot");
		Thread.sleep(2000);
		
		System.out.println("Click on Academic");
		driver.findElement(By.linkText("ACADEMIC")).click();
		
		System.out.println("Click on Time Table");
		driver.findElement(By.linkText("Time Table")).click();
		
		System.out.println("Click on Time Slots & Batch");
		driver.findElement(By.linkText("Time Slots & Batch")).click();
		
		System.out.println("Click on Time Slot");
		driver.findElement(By.linkText("Time Slot")).click();
		
		//driver.get("https://school.mastersofterp.in/Attendance/TimeSlot/Index"); //Live URL
		//driver.get("http://schooluat.mastersofterp.in/Attendance/TimeSlot/Index"); //UAT URL
		
		System.out.println("Select Standard (Class)");
		Thread.sleep(2000);
		Select ddlCourseCode = new Select(driver.findElement(By.id("ddlCourseCode")));
		ddlCourseCode.selectByIndex(2); // Value - STD-II
		
//		System.out.println("Select Slot No.");
//		Thread.sleep(2000);
//		Select ddlSlot = new Select(driver.findElement(By.id("ddlSlot")));
//		ddlSlot.selectByIndex(1); // Value - 1
//		
//		System.out.println("Enter Slot Name");
//		driver.findElement(By.id("txtSlotName")).sendKeys("MOR");
//		
//		System.out.println("Enter From Time");
//		driver.findElement(By.id("txtTimeFrom")).sendKeys("08:00AM");
//		
//		System.out.println("Enter To Time");
//		driver.findElement(By.id("txtTimeTo")).sendKeys("09:00AM");
//		
//		System.out.println("Click on Active CheckBox");
//		//driver.findElement(By.id("IsActive")).click();
//		if ( ! driver.findElement(By.id("IsActive")).isSelected() )
//		{
//			driver.findElement(By.id("IsActive")).click();
//		}
//		System.out.println("Active CheckBox is Selected");
		
		System.out.println("click on Edit Button");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]/i")).click();
		
		System.out.println("Click on Update Button");
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddSpan")).click();
		Thread.sleep(1000);
		
	}
}
