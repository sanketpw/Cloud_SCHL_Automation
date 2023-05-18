package com.qa.tests.itle_elearning;

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
import com.qa.pages.itle.CreateObjective;
import com.qa.pages.itle.ITLE_Admin;
import com.qa.pages.itle.SelectCourse;

public class CreateObjectiveTests extends BaseClass {

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
    ITLE_Admin itleAdmin;
    SelectCourse selectCourse;
	InputStream dataIs;
	JSONObject loginUsers;
	CreateObjective createObjective;

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

	public void Faculty_Should_Be_Able_To_Create_Objective_Test_Paper () throws Exception {

   
		loginPage = new LoginPageAdmin(driver);
		itleAdmin = new ITLE_Admin(driver);
		selectCourse = new SelectCourse(driver);
		createObjective = new CreateObjective(driver);
		

		homePage = loginPage.login(loginUsers.getJSONObject("ITLEAdminLogin").getString("userName"),
				loginUsers.getJSONObject("ITLEAdminLogin").getString("password"));
		
		homePage.openItle();
		itleAdmin.openCourceSubject();
		itleAdmin.openSelectCourseSubject();
		itleAdmin.openSelectCourseSubject1();
		selectCourse.select_ITLE_Session();
		itleAdmin.selectCourseSubject();
		homePage.openEnglishSubject();
		itleAdmin.Test();
		itleAdmin.createTest();
		itleAdmin.enterTestTitle();
		itleAdmin.testScheduleType();
		itleAdmin.selectTestStartDate();
		itleAdmin.enterTestDuration();
		itleAdmin.selectStartTime();
		itleAdmin.selectQuestionType();
		itleAdmin.SetQuestionPaper();
		itleAdmin.EnterNoOfPaperSets();
		itleAdmin.EnterEasyQuestion();
		itleAdmin.EnterObjectiveMarkPerStudent();
		itleAdmin.clickOnSubmitButton();
		itleAdmin.OpenAssignExam();
		itleAdmin.AssignExamCheckBox();
		itleAdmin.clickOnOkButton();
		itleAdmin.clickOnAfterResultOn();
		itleAdmin.clickOnSaveButton();
		Thread.sleep(2000);
//		
//		itleelearning.openSelectCourseSubject();
//		
//		itleelearning.openSelectCourseSubject1();
//		
//		itleelearning.selectCourseSubject();
//		
//		itleelearning.openEnglishSubject();
//		
//		itleelearning.Test();
//		
//		itleelearning.createTest();
//		
//        itleelearning.enterTestTitle();
//        
//        itleelearning.testScheduleType();
//        
//	    itleelearning.selectTestStartDate();
//	   
//	    itleelearning.enterTestDuration();
//	   
//	    itleelearning.selectStartTime();
//		itleelearning.openSelectCourseSubject();
//		
//		itleelearning.openSelectCourseSubject1();
//		
//		itleelearning.selectCourseSubject();
//		
//		itleelearning.openEnglishSubject();
//		
//		itleelearning.Test();
//		
//		itleelearning.createTest();
//		
//        itleelearning.enterTestTitle();
//        
//        itleelearning.testScheduleType();
//        
//	    itleelearning.selectTestStartDate();
//	   
//	    itleelearning.enterTestDuration();
//	   
//	    itleelearning.selectStartTime();
//		itleelearning.openSelectCourseSubject();
//		
//		itleelearning.openSelectCourseSubject1();
//		
//		itleelearning.selectCourseSubject();
//		
//		itleelearning.openEnglishSubject();
//		Thread.sleep(2000);
//		itleelearning.Test();
//		Thread.sleep(2000);
//		itleelearning.createTest();
//		Thread.sleep(2000);
//        itleelearning.enterTestTitle();
//        Thread.sleep(2000);
//        itleelearning.testScheduleType();
// 	   	Thread.sleep(2000);
//	    itleelearning.selectTestStartDate();
//	    Thread.sleep(2000);
//	    itleelearning.enterTestDuration();
// 	   	Thread.sleep(2000);
//	    itleelearning.selectStartTime();
	    
	   //itleelearning.TestDate();
	    Thread.sleep(1000);
//	    itleelearning.selectQuestionType();
//	    
//	    itleelearning.SetQuestionPaper();
//	   
//	    itleelearning.EnterNoOfPaperSets();
//	    
//	    itleelearning.EnterEasyQuestion();
//	   
//        itleelearning.EnterObjectiveMarkPerStudent();
//       
//        itleelearning.clickOnSubmitButton();
//        
//        itleelearning.OpenAssignExam();
//       
//        itleelearning.AssignExamCheckBox();
//       
//        itleelearning.clickOnOkButton();
//        itleelearning.IsAfterResult();
//        
//       
//        itleelearning.clickOnSaveButton();   //ITLE_CreateTestAdmin.java
//        Thread.sleep(2000);
//	    itleelearning.selectQuestionType();
//	    
//	    itleelearning.SetQuestionPaper();
//	   
//	    itleelearning.EnterNoOfPaperSets();
//	    
//	    itleelearning.EnterEasyQuestion();
//	   
//        itleelearning.EnterObjectiveMarkPerStudent();
//       
//        itleelearning.clickOnSubmitButton();
//        
//        itleelearning.OpenAssignExam();
//       
//        itleelearning.AssignExamCheckBox();
//       
//        itleelearning.clickOnOkButton();
//        itleelearning.IsAfterResult();
//        
//       
//        itleelearning.clickOnSaveButton();   //ITLE_CreateTestAdmin.java
//        Thread.sleep(2000);
//	    itleelearning.selectQuestionType();
//	    Thread.sleep(1000);
//	    itleelearning.SetQuestionPaper();
//	    Thread.sleep(1000);
//	    itleelearning.EnterNoOfPaperSets();
//	    Thread.sleep(1000);
//	    itleelearning.EnterEasyQuestion();
//	    Thread.sleep(1000);
//        itleelearning.EnterObjectiveMarkPerStudent();
//        Thread.sleep(1000);
//        itleelearning.clickOnSubmitButton();
//        Thread.sleep(1000);
//        itleelearning.OpenAssignExam();
//        Thread.sleep(1000);
//        itleelearning.AssignExamCheckBox();
//        Thread.sleep(1000);
//        itleelearning.clickOnOkButton();
//        Thread.sleep(1000);
//        itleelearning.IsAfterResult();
//        Thread.sleep(1000);
//        itleelearning.clickOnSaveButton();   //ITLE_CreateTestAdmin.java
      

		//String actualConfiramationTxt = studentAdmission.verifyConfirmationMessage();
		//String expectedConfiramationTxt = "Record Saved Successfully!";
		//System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
			//	+ "Expected Confiramtion Text - " + expectedConfiramationTxt);

		//Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);

	}
	
}
