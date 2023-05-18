package com.qa.tests.itle_elearning;

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
import com.qa.pages.HomePageStudent;
import com.qa.pages.LoginPageStudent;
import com.qa.pages.itle.AppearObjective;
import com.qa.pages.itle.AppearObjectiveCIMS;
import com.qa.pages.itle.MyTest;
import com.qa.pages.itle.SelectCourse;
import com.qa.utilities.Utilities;

public class AppearObjectiveTestsCIMS extends BaseClass {

	LoginPageStudent loginPage;
	HomePageStudent homePage;
	AppearObjectiveCIMS itleStudent;
	InputStream dataIs;
	JSONObject loginUsers;
	SelectCourse selectCourse;
	MyTest mytest;
	Utilities utilities;
	
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
	public void beforeMethod(Method m) throws Exception {
		driver = initializeDriverBFT("UrlCloudSchoolStudent");

		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
	}

	@AfterMethod
	public void afterMethod() {
	}
	
	@Test(priority = 1)
	public void appear_Objective_Test () throws IOException, InterruptedException {

		loginPage = new LoginPageStudent(driver);
		itleStudent = new AppearObjectiveCIMS(driver);
		selectCourse = new SelectCourse(driver);
		mytest = new MyTest(driver);

		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolStudent").getString("userName"),
		loginUsers.getJSONObject("CloudSchoolStudent").getString("password"));
		
		//itleStudent.openITLE();
		System.out.println("click on ITLE");
		driver.findElement(By.linkText("ITLE")).click();
		
		//itleStudent.selectMyTest();
		System.out.println("click on My Test");
		driver.findElement(By.linkText("My Test")).click();
		
		//itleStudent.selectSubject();
		System.out.println("click on ddlSubject");
		Select ddlSubject = new Select (driver.findElement(By.id("ddlSubject")));
		ddlSubject.selectByValue("99896"); //English
		Thread.sleep(2000);
		
//		itleStudent.openMyTest();
//		Thread.sleep(2000);
		
		//itleStudent.openStartTest();
		System.out.println("click on I am ready to begin");
		driver.findElement(By.id("btnStart")).click();
		Thread.sleep(2000);
		
		//itleStudent.openReadyToBegin();
		System.out.println("click on btnStart");
		driver.findElement(By.id("btnStartTest")).click();
		Thread.sleep(2000);
		
		acceptAlert();
		Thread.sleep(2000);
		
		switchToNextWindow();
		
		//itleStudent.clickOnAnswerOne();
		System.out.println("Click on 'Answer one'");
		driver.findElement(By.id("rbMoption1")).click();
		Thread.sleep(2000);
		
		//itleStudent.clickOnSaveAndNext();
		System.out.println("Click on SaveAndNext");
		driver.findElement(By.id("btnSaveNext")).click();
		Thread.sleep(2000);
		
		//itleStudent.clickOnReviewAndSubmit();
		System.out.println("Click on 'Review And Submit'");
		driver.findElement(By.xpath("//button[@id='btnMarkForReview']/span")).click();
		Thread.sleep(2000);
		
		//itleStudent.clickOnFinal();
		System.out.println("Click on Finish");
		driver.findElement(By.xpath("//button[@id='btnFinalSubmit']/span")).click();
		Thread.sleep(2000);
		
		//itleStudent.clickOnFinalAlertOk();
		System.out.println("Click on FinalAlertOk");
		driver.findElement(By.id("btnOK")).click();
		Thread.sleep(2000);
		
//		itleStudent.clickCloseWindow();
//		Thread.sleep(2000);

	}
	
}

