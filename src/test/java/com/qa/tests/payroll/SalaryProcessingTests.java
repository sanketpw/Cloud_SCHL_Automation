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
import com.qa.pages.payroll.MonthlyWork;
import com.qa.pages.payroll.Payroll;
import com.qa.pages.payroll.SalaryProcessing;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;

public class SalaryProcessingTests extends BaseClass {
	
	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Payroll payroll;
	MonthlyWork monthlyWork;
	SalaryProcessing salaryProcessing;
	

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
	
	public void SalaryProcessing() throws IOException, Exception {
	
		loginPage = new LoginPageAdmin(driver);
		payroll = new Payroll(driver);
		salaryProcessing = new SalaryProcessing(driver);
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"), 
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));
		
		//homePage.openPayroll();
		driver.findElement(By.linkText("PAYROLL")).click();
		System.out.println("Open Payroll");
		
		//payroll.openTransaction();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Transactions']/parent::*")).click();
		System.out.println(" open Transaction");
		
		//payroll.openMonthlyWork();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Monthly Work']/parent::*")).click();
		System.out.println("open MonthlyWork");
		
		//payroll.openSalaryProcess();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Salary Process']/parent::*")).click();
		System.out.println("open SalaryProcess");
		
		//salaryProcessing.selectMonthYear();
		//driver.findElement(By.id("ddlEmployee")).click();
		click(driver.findElement(By.id("txtMonthYear")));
		while (!getText(driver.findElement(By.xpath("//div[@class='datetimepicker-days']//th[@class='switch']"))).contains("August 2021"))
		{
			click(driver.findElement(By.xpath("//div[@class='datetimepicker-days']//th[@class='prev']")));
		}
		int count = driver.findElements(By.xpath("//td[@class='day']")).size();
		
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.xpath("//td[@class='day']")).get(i).getText();
			if (text.equalsIgnoreCase("28"))
			{
				driver.findElements(By.xpath("//td[@class='day']")).get(i).click();
				break;
			}
		System.out.println("Select MonthYear");
		}
		//salaryProcessing.ddlStaff();
		Select TEACHING = new Select(driver.findElement(By.id("ddlStaff")));
		TEACHING.selectByVisibleText("TEACHING");
		System.out.println("Select TEACHING");
		
		//salaryProcessing.btnSalaryProcess();
		driver.findElement(By.id("btnSalaryProcess")).click();
		System.out.println("click btnSalaryProcess");
		
		salaryProcessing.acceptAlert();
		System.out.println("click on acceptAlert");
		

		Thread.sleep(2000);
		Utilities.getAShot();
		
	}
}

		
		
		
		
		
		
	