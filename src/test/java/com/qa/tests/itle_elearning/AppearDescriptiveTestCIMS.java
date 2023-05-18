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
import com.qa.pages.itle.AppearDescriptiveCIMS;
import com.qa.pages.itle.AppearObjective;
import com.qa.pages.itle.ITLE_Student;
import com.qa.pages.itle.MyTest;
import com.qa.pages.itle.SelectCourse;
import com.qa.utilities.Utilities;

public class AppearDescriptiveTestCIMS extends BaseClass {

	
	

		LoginPageStudent loginPage;
		HomePageStudent homePage;
		AppearDescriptiveCIMS itleStudent;
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
		driver = initializeDriverBFT("UrlCloudSchoolStudent");

		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
	}

	
	@AfterMethod
	public void afterMethod() {
	}

	@Test(priority = 1)
	public void Appear_Descriptive () throws IOException, InterruptedException {

		loginPage = new LoginPageStudent(driver);
		itleStudent = new AppearDescriptiveCIMS(driver);
		selectCourse = new SelectCourse(driver);
		mytest = new MyTest(driver);

		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolStudent").getString("userName"),
		loginUsers.getJSONObject("CloudSchoolStudent").getString("password"));  //
		itleStudent.openITLE();
		itleStudent.selectMyTest();
		itleStudent.selectSubject();
//		Thread.sleep(2000);
		itleStudent.openMyTest();
//		Thread.sleep(2000);
		itleStudent.openStartTest();
//		Thread.sleep(2000);
		itleStudent.openReadyToBegin();
//		Thread.sleep(2000);
		acceptAlert();
		Thread.sleep(2000);
		switchToNextWindow();
		Thread.sleep(2000);
		switchToFrame(0);//go to Frame
		Thread.sleep(2000);
		itleStudent.clickOnTxtAnsOne();
		Thread.sleep(1000);
		switchToDefaultContent();//frame out
		Thread.sleep(1000);
		itleStudent.clickOnSaveAndNext();
		itleStudent.clickOnReviewAndSubmitButton();
		itleStudent.clickOnFinishButton();
		itleStudent.clickOnOkButton();
	}
	
}
