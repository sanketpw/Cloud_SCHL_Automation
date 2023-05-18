package com.qa.tests.academic;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePageAdmin;
import com.qa.pages.LoginPageAdmin;
import com.qa.pages.academic.Academic;
import com.qa.pages.academic.FeesCollection;
import com.qa.pages.academic.OutstandingFees;
import com.qa.pages.academic.StudentAdmission;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;




public class FeesCollectionTests extends BaseClass {

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Academic academic;
	//FeesCollectionHome feescollectionHome;
	StudentAdmission studentAdmission;
	FeesCollection feesCollection;
	OutstandingFees outstandingFees;
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
	public void User_Able_To_Perform_Fees_collection() throws IOException, Exception {

		loginPage = new LoginPageAdmin(driver);
		academic = new Academic(driver);
		studentAdmission = new StudentAdmission(driver);
		feesCollection = new FeesCollection(driver);
		outstandingFees = new OutstandingFees(driver);
		
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"),
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));

		//homePage.openFeesCollectionHome();
		driver.findElement(By.linkText("FEES COLLECTION")).click();//homePage.openFeesCollectionHome();
		
		//academic.openTransaction();
		driver.findElement(By.linkText("Transaction")).click();
		
		//academic.openCollectFees();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Collect Fees']/parent::*")).click();
		
		//academic.openFeesCollection();
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Fees Collection']/parent::*")).click();
		


		/*Fees Collection*/
		//feesCollection.SearchCriteria();
		System.out.println("Click on Search Criteria");
		Thread.sleep(2000);
		driver.findElement(By.id("sName")).click();
		
		//feesCollection.Enterstudentname();
		System.out.println("Enter student name");
		driver.findElement(By.id("txtStudent")).sendKeys("___");
		driver.findElement(By.className("eac-item")).click();
		
//		feesCollection.btnShow();
//		feesCollection.acceptAlert();
		
		//feesCollection.EnterMobileNo();
		System.out.println("EnterMobileNo");
		driver.findElement(By.id("txtMobileNo")).sendKeys("8149914475");
		
		//feesCollection.Remark();
		System.out.println("Enter Remark");
		driver.findElement(By.id("txtRemark")).sendKeys("Always paid Fees on Time in Future");
		
		//feesCollection.scrollIntoView();
		
		//feesCollection.ddlAdmThrough();
		System.out.println("Select ddlAdmThrough");
		Select ddlAdmThrough = new Select(driver.findElement(By.id("ddlAdmThrough")));//select ddlReceiptType
		ddlAdmThrough.selectByVisibleText("REGULAR");
		
		
		//feesCollection.ddlpayoption();
		System.out.println("Select Payment Option");
		Select ddlpayoption = new Select(driver.findElement(By.id("ddlpayoption")));
		ddlpayoption.selectByVisibleText("RTGS");
		
		
		//feesCollection.payid();
		System.out.println("Enter Payment Id");
		driver.findElement(By.id("payid")).sendKeys("CR12345678");
		
		
		//feesCollection.ddlPayMode();
		System.out.println("ddlPayMode Cash");
		Select ddlPayMode = new Select(driver.findElement(By.id("ddlPayMode")));
		ddlPayMode.selectByVisibleText("Cash");
		
		
		//feesCollection.AmtDesc();
		System.out.println("Enter Amount 100");
		driver.findElement(By.id("txtAmtDesc")).clear();
		driver.findElement(By.id("txtAmtDesc")).sendKeys("100");
		
		
		//feesCollection.btnAdd();
		System.out.println("Click On Add Button");
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(2000);
		
		
		//feesCollection.btnAdjust();
		System.out.println("Click on btnAdjust");
		driver.findElement(By.id("btnAdjust")).click();
		
		//feesCollection.btnSubmitSpan();
		System.out.println("Click on btnSubmitSpan");
		driver.findElement(By.id("btnSubmitSpan")).click();
		
		/*Fees Collection*/
		Thread.sleep(1500);
		switchToNextWindow();
		Thread.sleep(2000);
		
		Utilities.getAShot();


//		String actualConfiramationTxt = studentAdmission.verifyConfirmationMessage();
//		String expectedConfiramationTxt = "Record Saved Successfully!";
//		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
//				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);
//
//		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);

	}

	


}
