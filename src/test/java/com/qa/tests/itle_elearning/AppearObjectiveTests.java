package com.qa.tests.itle_elearning;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePageStudent;
import com.qa.pages.LoginPageStudent;
import com.qa.pages.itle.AppearObjective;
import com.qa.pages.itle.MyTest;
import com.qa.pages.itle.SelectCourse;
import com.qa.utilities.Utilities;

public class AppearObjectiveTests extends BaseClass {

	LoginPageStudent loginPage;
	HomePageStudent homePage;
    AppearObjective itleStudent;
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
		driver = initializeDriverBFT("ItleStudent");

		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
	}

	@AfterMethod
	public void afterMethod() {
	}
	
	@Test(priority = 1)
	public void appear_Objective_Test () throws IOException, InterruptedException {

		loginPage = new LoginPageStudent(driver);
		itleStudent = new AppearObjective(driver);
		selectCourse = new SelectCourse(driver);
		mytest = new MyTest(driver);

		homePage = loginPage.login(loginUsers.getJSONObject("ITLEStudentLogin").getString("userName"),
		loginUsers.getJSONObject("ITLEStudentLogin").getString("password"));
		
		homePage.openITLE();
		itleStudent.selectSession();
		Thread.sleep(2000);
		itleStudent.selectSubject();
		Thread.sleep(2000);
		itleStudent.openMyTest();
		Thread.sleep(2000);
		itleStudent.openStartTest();
		Thread.sleep(2000);
		itleStudent.openReadyToBegin();
		Thread.sleep(2000);
		acceptAlert();
		Thread.sleep(2000);
		switchToNextWindow();
		itleStudent.clickOnAnswerOne();
		Thread.sleep(2000);
		itleStudent.clickOnSaveAndNext();
		Thread.sleep(2000);
		itleStudent.clickOnReviewAndSubmit();
		Thread.sleep(2000);
		itleStudent.clickOnFinal();
		Thread.sleep(2000);
		itleStudent.clickOnFinalAlertOk();
		Thread.sleep(2000);
//		itleStudent.clickCloseWindow();
		Thread.sleep(2000);

		
		
		
		
//		//selectcourse.select_ITLE_Session();
//		selectcourse.open_Active_Course();
//		Thread.sleep(4000);
//		selectcourse.open_My_Test_In_WorkArea();
//		Thread.sleep(4000);
//		mytest.clickOnStartTest();  //MyTest.java
//		Thread.sleep(4000);
//		mytest.clickOnReadyToBegin();  //MyTest.java
//		//Thread.sleep(1000);
//		acceptAlert();
//
//		//Thread.sleep(1000);
////		String strUrl = driver.getCurrentUrl ();
////		System.out.println("Current url is=" +strUrl);
//		Thread.sleep(4000);
//
//
//		Thread.sleep(4000);
//
//		switchToNextWindow();
//
////		String strUrl1 = driver.getCurrentUrl ();
////		System.out.println("Current url is=" +strUrl1);
//		Thread.sleep(2000);
//
	//	mytest.clickOnAnswerOne();  //MyTest.java
//		Thread.sleep(2000);
//		mytest.clickOnSaveAndNext();  //MyTest.java
//		Thread.sleep(2000);
//		mytest.clickOnAnswertwo();  //MyTest.java
//		Thread.sleep(2000);
//		mytest.clickOnSaveAndNext();  //MyTest.java
//		Thread.sleep(2000);
//		mytest.clickOnReviewAndSubmit();  //MyTest.java
//		mytest.clickOnFinal();  //MyTest.java
//		mytest.clickOnFinalAlertOk();  //MyTest.java
//		Thread.sleep(2000);
//		Utilities.getAScreenShot();
		//mytest.clickOnAlertClose();
		//mytest.clickOnClose();
		//dismissAlert();
	}
	
}

