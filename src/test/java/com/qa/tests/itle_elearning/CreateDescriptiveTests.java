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
import com.qa.pages.HomePageAdmin;
import com.qa.pages.LoginPageAdmin;
import com.qa.pages.itle.CreateDescriptive;
import com.qa.pages.itle.ITLE_Admin;
import com.qa.pages.itle.SelectCourse;

public class CreateDescriptiveTests extends BaseClass {

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
    ITLE_Admin itleAdmin;
    SelectCourse selectCourse;
	InputStream dataIs;
	JSONObject loginUsers;
	CreateDescriptive Descriptive;

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
		driver = initializeDriverBFT("ItleAdmin");

		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
	}

	
	
	@AfterMethod
	public void afterMethod() {
	}

	@Test(priority = 1)
	public void create_Descriptive_Test () throws IOException, InterruptedException {
   
		loginPage = new LoginPageAdmin(driver);
		Descriptive = new CreateDescriptive(driver);

		homePage = loginPage.login(loginUsers.getJSONObject("ITLEAdminLogin").getString("userName"),
				loginUsers.getJSONObject("ITLEAdminLogin").getString("password"));

		homePage.openItle();
		Descriptive.openCourceSubject();   //ITLE_CreateDescriptiveTestAdmin.java
		Descriptive.openSelectCourseSubject();
		Descriptive.openSelectCourseSubject1();
		Descriptive.selectCourseSubject();
		Descriptive.openEnglishSubject();
		Descriptive.Test();
		Descriptive.createTest();
		Descriptive.enterTestTitle();
		Descriptive.testScheduleType();
		Descriptive.selectTestStartDate();
		Descriptive.enterTestDuration();
		Descriptive.selectStartTime();
		Descriptive.selectQuestionType();
		Descriptive.SetQuestionPaper();
		Descriptive.EnterNoOfPaperSets();
		Descriptive.EnterEasyQuestion();
		Descriptive.EnterObjectiveMarkPerStudent();
		Descriptive.clickOnSubmitButton();
		Descriptive.OpenAssignExam();
		Descriptive.AssignExamCheckBox();
		Descriptive.clickOnOkButton();
		Descriptive. clickOnSaveButton();
		
		Thread.sleep(2000);
	}
}
