package com.qa.tests.payroll;

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
import com.qa.pages.payroll.AbstractSalaryNewReport;
import com.qa.pages.payroll.Payroll;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;

public class AbstractSalaryNewReportTests extends BaseClass {
	
	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Payroll payroll;
	AbstractSalaryNewReport abstractSalaryNewReport;

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
	
	public void AbstractSalaryNewReport() throws IOException, Exception {
	
		loginPage = new LoginPageAdmin(driver);
		payroll = new Payroll(driver);
		abstractSalaryNewReport = new AbstractSalaryNewReport(driver);
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"), 
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
		
		//homePage.openPayroll();
		driver.findElement(By.linkText("PAYROLL")).click();
		System.out.println("click on PAYROLL");
		
		//payroll.openReport();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Report']/parent::*")).click();
		System.out.println("open Report");
		
		//payroll.openReports();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Reports']/parent::*")).click();
		System.out.println("open Reports");
		
		//payroll.openAbstractSalaryNewReport();
		driver.findElement(By.linkText("Abstract Salary Report")).click();
		System.out.println("click on AbstractSalaryNewReport");
		
		//abstractSalaryNewReport.ddlMonthYear();
		Select EmployeeType = new Select(driver.findElement(By.id("ddlEmployee")));
		EmployeeType.selectByVisibleText("JUNIOR");
				
		//abstractSalaryNewReport.ddlMonthYear();
		Select ddlMonthYear = new Select(driver.findElement(By.id("ddlMonthYear")));
		ddlMonthYear.selectByVisibleText("Aug2021");
		
		//abstractSalaryNewReport.ddlStaff();
		Select ddlStaff = new Select(driver.findElement(By.id("ddlStaff")));
		ddlStaff.selectByVisibleText("TEACHING");
		
		//abstractSalaryNewReport.btnAddSpan();
		driver.findElement(By.id("btnAbstarctReport")).click();
		System.out.println("click on btnAbstarctReport");
		
		
	
		Thread.sleep(2000);
		switchToNextWindow();
		Thread.sleep(2000);
		Utilities.getAShot();
		
	}
}

		
		
		
		
		
		
	