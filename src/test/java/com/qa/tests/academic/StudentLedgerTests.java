package com.qa.tests.academic;

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
import com.qa.pages.academic.Academic;
import com.qa.pages.academic.FeesReports;
import com.qa.pages.academic.StudentLedger;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;




public class StudentLedgerTests extends BaseClass {

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Academic academic;
	StudentLedger studentLedger;
	FeesReports feesReports;
	InputStream dataIs;
	JSONObject loginUsers;

	ExcelReader excelreader;
	

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
		
		driver = initializeDriverBFT("UrlCloudSchoolAdmin");

		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
	}

	
	
	@AfterMethod
	public void afterMethod() {
	}

	
	


	@Test()
	public void User_Able_To_Generate_Student_Ledger() throws IOException, Exception {

		loginPage = new LoginPageAdmin(driver);
		academic = new Academic(driver);
		feesReports = new FeesReports(driver);
		studentLedger = new StudentLedger(driver);
		
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"),
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));

		//homePage.openFeesCollectionHome();
		Thread.sleep(2000);
		System.out.println("Open Fees Collection");
		driver.findElement(By.linkText("FEES COLLECTION")).click();//homePage.openFeesCollectionHome();
		Thread.sleep(2000);
		
		
		//academic.openFeesReports();
		driver.findElement(By.linkText("Fees Reports")).click(); //academic.openFeesReports();
		System.out.println("click on openFeesReports");
		
		//academic.openFeesReport();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fees Reports'])[1]/following::span[2]")).click();  //academic.openFeesReport();
		System.out.println("click on openFeesReport");
		
//		academic.openFeesReports();
//		feesReports.expandFeesReport();
		
		//feesReports.openStudentsLedger();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Student Ledger']/parent::*")).click();  //academic.openFeesReport();
		System.out.println("open on Student Ledger");
		
		//studentLedger.selectSession();
		Select Session = new Select(driver.findElement(By.id("ddlSession")));//select session
		Session.selectByVisibleText("2021-2022");
		System.out.println("click on ddlSession");
		
		//studentLedger.selectSearchBy();
		Select stud = new Select(driver.findElement(By.id("ddlSearchBy")));
		stud.selectByVisibleText("Student Name");
		System.out.println("select Student Name");
		
		//studentLedger.enterInput();
		driver.findElement(By.id("userInput")).sendKeys("ARBAT");
		driver.findElement(By.className("ui-menu-item")).click();
		System.out.println("Enter student Input");
		
		Thread.sleep(3000);
		//studentLedger.clickOnReportButton();
		driver.findElement(By.xpath("//button[@id='btnReport']/span")).click();
		System.out.println("Click On Report Button");
		
		Thread.sleep(2000);
		switchToNextWindow();
		Thread.sleep(2000);
		Utilities.getAShot();
		
		

	}

	


}
