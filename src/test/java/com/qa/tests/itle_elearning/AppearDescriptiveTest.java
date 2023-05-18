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
import com.qa.pages.itle.AppearDescriptive;
import com.qa.pages.itle.AppearObjective;
import com.qa.pages.itle.ITLE_Student;
import com.qa.pages.itle.MyTest;
import com.qa.pages.itle.SelectCourse;
import com.qa.utilities.Utilities;

public class AppearDescriptiveTest extends BaseClass {

	
	

		LoginPageStudent loginPage;
		HomePageStudent homePage;
		AppearDescriptive itleStudent;
		InputStream dataIs;
		JSONObject loginUsers;
		SelectCourse selectCourse;
		MyTest mytest;
		Utilities utilities;
	
	
	
//	LoginPageStudent loginPage;
//	HomePageStudent homePage;
//	AppearDescriptive descriptiveTestPage;
//
//    ITLE_Student elearning;
//	InputStream dataIs;
//	JSONObject loginUsers;
//	SelectCourse selectcourse;
//	MyTest mytest;
//	Utilities utilities;
//	
	
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
	
//	public void beforeClass() throws Exception {
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
//	}

	
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
	public void Appear_Descriptive () throws IOException, InterruptedException {

		loginPage = new LoginPageStudent(driver);
		itleStudent = new AppearDescriptive(driver);
		selectCourse = new SelectCourse(driver);
		mytest = new MyTest(driver);
		
//		loginPage = new LoginPageStudent(driver);
//		itleStudent = new ITLE_Student(driver);
//		selectcourse = new SelectCourse(driver);
//		mytest = new MyTest(driver);
//		descriptiveTestPage = new AppearDescriptive(driver); // MyDescriptivepage.java
		
		homePage = loginPage.login(loginUsers.getJSONObject("ITLEStudentLogin").getString("userName"),
		loginUsers.getJSONObject("ITLEStudentLogin").getString("password"));  //
		homePage.openITLE();  //HomePageStudent.java
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
		Thread.sleep(2000);
		switchToFrame(0);//go to Frame
		Thread.sleep(2000);
		itleStudent.clickOnAnswerOne();
		Thread.sleep(2000);
		switchToDefaultContent();//frame out
		Thread.sleep(2000);
		itleStudent.clickOnSaveAndNext();
		Thread.sleep(2000);
		switchToFrame(0);
		Thread.sleep(2000);
		itleStudent.clickOnAnswerTwo();
		Thread.sleep(2000);
		switchToDefaultContent();
		Thread.sleep(2000);
		itleStudent.clickOnSaveAndNext();
		Thread.sleep(2000);
		itleStudent.clickOnReviewAndSubmitButton();
		Thread.sleep(2000);
		itleStudent.clickOnFinishButton();
		Thread.sleep(2000);
		itleStudent.clickOnOkButton();
		Thread.sleep(2000);
//		itleStudent.selectSubject();
//		Thread.sleep(2000);
//		itleStudent.openMyTest();
//		Thread.sleep(2000);
//		itleStudent.openStartTest();
//		Thread.sleep(2000);
//		itleStudent.openReadyToBegin();
//		Thread.sleep(2000);
//		acceptAlert();
//		Thread.sleep(2000);
//		switchToNextWindow();
		
		
		
		
		
		
//		elearning.openSelectCourse();  //ITLE_ElearingStudent.java
//		//selectcourse.open_Active_Course();  //SelectCourse.java
//		selectcourse.open_My_Test_In_WorkArea(); //SelectCourse.java
//		descriptiveTestPage.clickOnStartTest();   // MyDescriptivepage.java
//		descriptiveTestPage.clickOnReadyToBegin();
//		acceptAlert();
//		Thread.sleep(2000);
//		switchToNextWindow(); // Switch to window
//		Thread.sleep(2000);
//		switchToFrame(0);//go to Frame
//		Thread.sleep(2000);
//
//		descriptiveTestPage.clickOnTxtAnsOne();
//		Thread.sleep(1000);
//		switchToDefaultContent();//frame out
//		Thread.sleep(1000);
//		descriptiveTestPage.clickOnSaveAndNext();
//		Thread.sleep(2000);
//		switchToDefaultContent();
//		Thread.sleep(2000);
//		switchToFrame(0);
//		Thread.sleep(2000);
//		descriptiveTestPage.clickOnTxtAnsTwo();
//		Thread.sleep(2000);
//		switchToDefaultContent();//frame out
//		Thread.sleep(2000);
//		descriptiveTestPage.clickOnSaveAndNextButton();
//		descriptiveTestPage.clickOnReviewAndSubmitButton();
//		descriptiveTestPage.clickOnFinishButton();
//		descriptiveTestPage.clickOnOkButton();// Final exam submit
//		descriptiveTestPage.clickOnCloseWindow(); // Close Exam window
		//mytest.clickOnAlertClose();
		//mytest.clickOnClose();
		//dismissAlert();
	}
	
}
