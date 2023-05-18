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
import com.qa.pages.academic.OutstandingFeesReport;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;




public class OutsatndingFeesReportTests extends BaseClass {

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Academic academic;
	OutstandingFeesReport outstandingFeesReport;
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
	public void User_Able_To_Generate_Outstanding_Fees_Report() throws IOException, Exception {

		loginPage = new LoginPageAdmin(driver);
		academic = new Academic(driver);
		feesReports = new FeesReports(driver);
		outstandingFeesReport = new OutstandingFeesReport(driver);
		
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"),
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));

		//homePage.openFeesCollectionHome();
		Thread.sleep(2000);
		System.out.println("Open Fees Collection");
		driver.findElement(By.linkText("FEES COLLECTION")).click();//homePage.openFeesCollectionHome();
		Thread.sleep(2000);
		
		
		//academic.openFeesReports();
		System.out.println("Open Fees Reports");
		driver.findElement(By.linkText("Fees Reports")).click();
		
		
		//feesReports.expandFeesReport();
		System.out.println("Click On Fees Report");
		driver.findElement(By.linkText("School Reports")).click();
		
		
		//feesReports.openOutstandingFeesReport();
		System.out.println("Click on Outstanding Fees Report");
		driver.findElement(By.linkText("Outstanding Fees")).click();
		
		
		//outstandingFeesReport.selectSession();
		System.out.println("Select ddlSession");
		Select ddlSession = new Select(driver.findElement(By.id("ddlSession")));//select ddlReceiptType
		ddlSession.selectByVisibleText("2022-2023");
		
		
		//outstandingFeesReport.selectReceiptBook();
		System.out.println("Select Receipt Book");
		Select course = new Select(driver.findElement(By.id("ddlCashBook")));//select ddlReceiptType
		course.selectByVisibleText("ADMISSION FEE");
		
		
//		//outstandingFeesReport.selectBasicCourse();
//		outstandingFeesReport.selectCourse();
//		outstandingFeesReport.selectFeeType();
//		outstandingFeesReport.selectStudentType();
//		outstandingFeesReport.selectMedium();
		
		
		//outstandingFeesReport.selectReportType();
		System.out.println("Select Report Type Detailed");
		Select ddlReportType = new Select(driver.findElement(By.id("ddlReportType")));
		ddlReportType.selectByVisibleText("Detailed");
		
//		outstandingFeesReport.enterPayAmtTillDate();
		
		//outstandingFeesReport.clickOnReport();
		System.out.println("Click On Report");
		driver.findElement(By.id("btnReport")).click();
		
		Thread.sleep(2000);
		switchToNextWindow();
		Thread.sleep(2000);
		Utilities.getAShot();
		

	}

	


}
