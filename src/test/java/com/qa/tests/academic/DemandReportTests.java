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
import com.qa.pages.academic.DemandReport;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;

public class DemandReportTests extends BaseClass {
	
	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Academic academic;
	DemandReport demandReport;
	

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
	
	public void User_Able_To_Generate_Demand_Report() throws IOException, InterruptedException {
	
		loginPage = new LoginPageAdmin(driver);
		academic = new Academic(driver);
		demandReport = new DemandReport(driver);
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"), 
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
		
		//homePage.openFeesCollectionHome();
		System.out.println("Open Fees Collection");
		Thread.sleep(2000);
		driver.findElement(By.linkText("FEES COLLECTION")).click();//homePage.openFeesCollectionHome();
		Thread.sleep(2000);
		
		
		//academic.openFeesReports();
		System.out.println("Open Fees Reports");
		driver.findElement(By.linkText("Fees Reports")).click();

		
		//academic.openFeesReport();
		System.out.println("Open School Report");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fees Reports'])[1]/following::span[2]")).click();

		
		//academic.openDemandReport();
		System.out.println("Open Demand Report");
		driver.findElement(By.linkText("Demand")).click();
		
		
		//demandReport.ddlSession();
		System.out.println("Select ddlSession - 2022-2023");
		Select ddlSession = new Select(driver.findElement(By.id("ddlSession")));//select ddlReceiptType
		ddlSession.selectByVisibleText("2022-2023");
		
		
		//demandReport.ddlCourse();
		System.out.println("Select ddlCourse - STANDARD-5");
		Select ddlCourse = new Select(driver.findElement(By.id("ddlCourse")));//select ddlReceiptType
		ddlCourse.selectByVisibleText("STANDARD-5");
		
		
//		demandReport.ddlReportFormat();
		
		Thread.sleep(2000);
		//demandReport.btnReport();
		System.out.println("Click on btnReport");
		driver.findElement(By.id("btnReport")).click();
		
		
		Thread.sleep(2000);
		switchToNextWindow();
		Thread.sleep(5000);
		Utilities.getAShot();
		
	}
}

		
		
		
		
		
		
	