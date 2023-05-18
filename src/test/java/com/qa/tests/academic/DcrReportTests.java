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
		
				//homePage.openFeesCollectionHome();
				System.out.println("click on open Fees CollectionHome");
				driver.findElement(By.linkText("FEES COLLECTION")).click();//homePage.openFeesCollectionHome();
				
				//academic.openFeesReports();
				driver.findElement(By.linkText("Fees Reports")).click(); //academic.openFeesReports();
				System.out.println("click on openFeesReports");
				
				//academic.openFeesReport();
				driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fees Reports'])[1]/following::span[2]")).click();  //academic.openFeesReport();
				System.out.println("click on openFeesReport");
				
				//academic.openDcrReport();
				driver.findElement(By.linkText("DCR")).click(); //academic.openDcrReport();
				System.out.println("click on openDcrReport");
				
				//dcrReport.DETAILED();
				driver.findElement(By.xpath("//*/text()[normalize-space(.)='Detailed']/parent::*")).click(); //dcrReport DETAILED Report Format
				System.out.println("click on Report Format");
				
				//dcrReport.ddlSession();
				Select Session = new Select(driver.findElement(By.id("ddlSession")));//select session
				Session.selectByVisibleText("2022-2023");
				System.out.println("click on ddlSession");
				
				//dcrReport.ddlReceiptType();
				Select ddlReceiptType = new Select(driver.findElement(By.id("ddlReceiptType")));//select ddlReceiptType
				ddlReceiptType.selectByVisibleText("ADMISSION,NEXT INSTALLMENT,OTHER FEES");
				System.out.println("click on ddlReceiptType, ADMISSION,NEXT INSTALLMENT,OTHER FEES");
				
//				dcrReport.ddlCashBookType();
				Select ddlCashBookType = new Select(driver.findElement(By.id("ddlCashBookType")));//select ddlReceiptType
				ddlCashBookType.selectByVisibleText("ADMISSION FEE");
				System.out.println("click on ddlCashBookType, ADMISSION FEE");
				
				//dcrReport.DateFrom();
				System.out.println("Select Date To start");
				driver.findElement(By.id("txtDateFrom")).click();//click on To date
				//List<WebElement> day=driver.findElements(By.className("day"));
				System.out.println("Select Date From list");
				while (!getText(driver.findElement(By.xpath("/html/body/div[6]/div[3]/table/thead/tr[1]/th[2]"))).contains("May 2022")) // may 2022
				{
					(driver.findElement(By.xpath("(//th[@class='prev'])[3]"))).click();//previous arrow
					System.out.println("Select Date From May 2022");
				}
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/div[6]/div[3]/table/tbody/tr[3]/td[2]")).click();// date 10 select
//				int count = day.size();
//				System.out.println("date = "+count);
//				for (int i = 1; i < count+1; i++) 
//				{
//					String text = day.get(i).getText();
//					if (text.equalsIgnoreCase("10")) 
//					{
//						day.get(i).click();
//						System.out.println("Select Date From dateclicked");
//						break;
//					}
//				}
				
//				dcrReport.DateTo();
				System.out.println("Select Date From start");
				driver.findElement(By.id("txtDateTo")).click();//click on from date
				//List<WebElement> day1=driver.findElements(By.className("day"));
				System.out.println("Select Date From list");
				//driver.findElement(By.xpath("/html/body/div[9]/div[3]/table/tfoot/tr[1]/th")).click();// date 10 select
				driver.findElement(By.xpath("/html/body/div[7]/div[3]/table/tbody/tr[2]/td[5]")).click();// date 10 select

//				dcrReport.selectFormatType();
				Select reporttype = new Select(driver.findElement(By.id("ddlReportType")));
				reporttype.selectByVisibleText("50 Heads");
				System.out.println("click on reporttype, 50 Heads");
				
//				dcrReport.btnReport();
				driver.findElement(By.id("btnReport")).click();
				Thread.sleep(2000);
				System.out.println("click on btnReport");

				Thread.sleep(2000);
				switchToNextWindow();
				Thread.sleep(5000);
				Utilities.getAShot();
		
	}
}

		
		
		
		
		
		
	