package com.qa.tests.establishment;

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
import com.qa.pages.establishment.Establishment;
import com.qa.pages.establishment.LeaveAllotmentReport;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;

public class LeaveAllotmentReportTests extends BaseClass {
	
	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Establishment establishment;
	LeaveAllotmentReport leaveAllotmentReport;


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
	
	public void Leave_Allotment_Report() throws IOException, Exception {
	
		loginPage = new LoginPageAdmin(driver);
		
		establishment = new Establishment(driver);
		leaveAllotmentReport = new LeaveAllotmentReport(driver);
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"), 
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
		
		//homePage.openEstablishment();
		driver.findElement(By.linkText("ESTABLISHMENT")).click();
		System.out.println("Click on ESTABLISHMENT");
		
		//establishment.openReport();
		driver.findElement(By.linkText("Report")).click();
		System.out.println("open Report");
		
		//establishment.openLeaveReports();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Leave Reports']/parent::*")).click();
		System.out.println("open Leave Reports");
		
		//establishment.openLeaveAllotmentReport();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Leave Allotment Report']/parent::*")).click();
		System.out.println("open LeaveAllotmentReport");
		
		//leaveAllotmentReport.ddlStaff();
		Select ddlStaff = new Select(driver.findElement(By.id("ddlStaff")));
		ddlStaff.selectByVisibleText("TEACHING");
		System.out.println("Click on ddlStaff");
		
		//leaveAllotmentReport.ddlDepartment();
		Select ddlDepartment = new Select(driver.findElement(By.id("ddlDepartment")));
		ddlDepartment.selectByVisibleText("EDUCATION");
		System.out.println("Click on ddlDepartment");
		
		//leaveAllotmentReport.ddlDesignature();
		Select ddlDesignature = new Select(driver.findElement(By.id("ddlDesignature")));
		ddlDesignature.selectByVisibleText("PERMANENT");
		System.out.println("Click on ddlDesignature");
		
		//leaveAllotmentReport.ddlPeriod();
		Select ddlPeriod = new Select(driver.findElement(By.id("ddlPeriod")));
		ddlPeriod.selectByVisibleText("JULY-JUNE");
		System.out.println("Click on ddlPeriod");
		
		//leaveAllotmentReport.ddlYear();
		Select ddlYear = new Select(driver.findElement(By.id("ddlYear")));
		ddlYear.selectByVisibleText("2022");
		System.out.println("Click on ddlYear");
		
		//leaveAllotmentReport.ddlLeave();
		Select ddlLeave = new Select(driver.findElement(By.id("ddlLeave")));
		ddlLeave.selectByVisibleText("CASUAL LEAVE-PERMANENT");
		System.out.println("Click on ESTABLISHMENT");
		
		//leaveAllotmentReport.btnReport();
		driver.findElement(By.id("btnReport")).click();
		System.out.println("Click on btnReport");
		
		
		Thread.sleep(1000);
		switchToNextWindow();
		Thread.sleep(1000);
		Utilities.getAShot();
		
	}
}

		
		
		
		
		
		
	