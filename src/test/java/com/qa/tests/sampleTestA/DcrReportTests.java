package com.qa.tests.sampleTestA;

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
import com.qa.pages.academic.Academic;
import com.qa.pages.academic.DcrReport;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;

public class DcrReportTests extends BaseClass {
	
	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Academic academic;
	DcrReport dcrReport;

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
	public void beforeMethod(Method m) throws Exception{
		
		driver = initializeDriverBFT("UrlCloudSchoolAdmin");
		
		System.out.println("\n" + "******Starting Test: " + m.getName() + "*****" + "\n");
	}
	
	@AfterMethod
	public void afterMethod() {
	}
	
	@Test()
	
	public void User_Able_To_Generate_DCR_Report() throws IOException, Exception {
	
		loginPage = new LoginPageAdmin(driver);
		academic = new Academic(driver);
		dcrReport = new DcrReport(driver);
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"), 
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
		
		homePage.openFeesCollectionHome();
		academic.openFeesReports();
		academic.openFeesReport();
		academic.openDcrReport();
		
		dcrReport.DETAILED();
		dcrReport.ddlSession();
		dcrReport.ddlReceiptType();
		dcrReport.ddlCashBookType();
		dcrReport.DateFrom();
		dcrReport.DateTo();
		dcrReport.selectFormatType();
		dcrReport.btnReport();
		Thread.sleep(1500);
		switchToNextWindow();
		Thread.sleep(2000);
		
		Utilities.getAShot();
		
	}
}

		
		
		
		
		
		
	