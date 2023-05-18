package com.qa.tests.itle_elearning;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePageAdmin;
import com.qa.pages.LoginPageAdmin;
import com.qa.pages.itle.CreateObjective;
import com.qa.pages.itle.Create_Objective_test_CIMS_Link;
import com.qa.pages.itle.ITLE_Admin;
import com.qa.pages.itle.SelectCourse;

public class CreateObjectiveTestsCIMS extends BaseClass {

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Create_Objective_test_CIMS_Link itleAdmin;
    SelectCourse selectCourse;
	InputStream dataIs;
	JSONObject loginUsers;
	CreateObjective createObjective;

	public static WebDriver driver;
	
	@FindBy (id = "txtTimeStar") private WebElement teststarttime;//start time
	
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
		driver = initializeDriverBFT("UrlCloudSchoolAdmin");

		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
	}

	
	@AfterMethod
	public void afterMethod() {
	}

	@Test(priority = 1)

	public void Faculty_Should_Be_Able_To_Create_Objective_Test_Paper () throws Exception {

   
		loginPage = new LoginPageAdmin(driver);
		itleAdmin = new Create_Objective_test_CIMS_Link(driver);
		selectCourse = new SelectCourse(driver);
		createObjective = new CreateObjective(driver);
		

		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"),
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
		
		//homePage.openItle();
		System.out.println("click on ITLE");
		driver.findElement(By.linkText("ITLE")).click();
		
		//itleAdmin.openOnlineAssessmentt();
		System.out.println("click on Online Assessment");
		driver.findElement(By.linkText("Online Assessment")).click();
		
		//itleAdmin.openCreate Exam();
		System.out.println("click on Create Exam");
		driver.findElement(By.linkText("Create Exam")).click();
		
		//itleAdmin.openSelectCourseSubject1();
		System.out.println("click on Create Objective Test");
		driver.findElement(By.linkText("Create Objective Test")).click();
		
		//itleAdmin.select_ITLE_Session();
//		System.out.println("click on ddlSeession");
//		Select ddlSeession = new Select(driver.findElement(By.id("ddlSeession")));
//		ddlSeession.selectByVisibleText("SES 2022-23");
		
		//itleAdmin.select_Course();
		System.out.println("click on ddlSubject");
		Select ddlSubject = new Select(driver.findElement(By.id("ddlSubject")));
		ddlSubject.selectByVisibleText("STD-I - A - ENGLISH");
		
		//itleAdmin.openEnglishSubject()//create objective test;
		System.out.println("click on btnAddTest");
		driver.findElement(By.id("btnAddTest")).click();
		
		//itleAdmin.Test();
		
		//itleAdmin.createTest();
		
		//itleAdmin.enterTestTitle();
		System.out.println("click on Test Title");
		driver.findElement(By.id("txtSyllabus")).sendKeys("Test44");
		
		//itleAdmin.testScheduleType();
		System.out.println("click on Test Schedule Type");
		Select ddlTestType = new Select(driver.findElement(By.id("ddlTestType")));
		ddlTestType.selectByVisibleText("Non-Flexible");
		
		//itleAdmin.selectTestStartDate();
		System.out.println("click on txtStartDate");
		driver.findElement(By.id("txtStartDate")).click();
		driver.findElement(By.cssSelector("td.day.today.active")).click();
		
		//itleAdmin.enterTestDuration();
		System.out.println("click on txtTestDuration");
		driver.findElement(By.id("txtTestDuration")).sendKeys("01:00");
		
		//itleAdmin.selectStartTime();
		System.out.println("click on Test Start Time");
		driver.findElement(By.id("txtTimeStar")).sendKeys(GetCurrentTime()); //(Keys.SPACE, Keys.ENTER)
		driver.findElement(By.id("txtTimeStar")).sendKeys(Keys.SPACE, Keys.ENTER);
		
		//itleAdmin.selectQuestionType();
		
		//itleAdmin.SetQuestionPaper();
		System.out.println("click on Set Question Paper");
		driver.findElement(By.id("lblAddQuestions")).click();
		Thread.sleep(2000);
		
		//itleAdmin.EnterNoOfPaperSets();
		System.out.println("click on No. of Paper Set");
		driver.findElement(By.id("txtNoSet")).clear();
		driver.findElement(By.id("txtNoSet")).sendKeys("1");
		
		//itleAdmin.EnterEasyQuestion();
		System.out.println("Enter on Easy");
		driver.findElement(By.id("txtEasyUser")).sendKeys("1");
		
		//itleAdmin.EnterObjectiveMarkPerStudent();
		System.out.println("Enter on SELECT QUESTIONS");
		driver.findElement(By.id("txtDifficultyLevel")).sendKeys("1");
		
		//itleAdmin.clickOnSubmitButton();
		System.out.println("Click on Submit");
		driver.findElement(By.id("btnOKModal")).click();
		
		//itleAdmin.OpenAssignExam();
		System.out.println("Click on Assign Exam To Student");
		driver.findElement(By.id("lblAddStudent")).click();
		
		Thread.sleep(3000);
		//itleAdmin.AssignExamCheckBox();
		System.out.println("Click on Assign Exam CheckBox All");
		driver.findElement(By.id("IsAllStd")).click();
		
		//itleAdmin.clickOnOkButton();
		System.out.println("Click on clickOnOkButton");
		driver.findElement(By.id("btnCount")).click();
		
//		itleAdmin.clickOnAfterResultOn();
//		
		Thread.sleep(2000);
		//itleAdmin.clickOnSaveButton();
		System.out.println("Click on btnSave");
		driver.findElement(By.id("btnSave")).click();
		
		Thread.sleep(4000);


	}
	
}
