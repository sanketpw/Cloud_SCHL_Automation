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
import com.qa.pages.academic.FeesCollection;
import com.qa.pages.academic.OutstandingFees;
import com.qa.pages.academic.StudentAdmission;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;




public class OutstandingFeesTests extends BaseClass {

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
	Academic academic;
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
	
	public void User_Able_To_Collect_Outstanding_fees() throws IOException, Exception {

		loginPage = new LoginPageAdmin(driver);
		academic = new Academic(driver);
		studentAdmission = new StudentAdmission(driver);
		feesCollection = new FeesCollection(driver);
		outstandingFees = new OutstandingFees(driver);
		
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"),
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));

		//homePage.openFeesCollectionHome();
		Thread.sleep(2000);
		System.out.println("Open Fees Collection");
		driver.findElement(By.linkText("FEES COLLECTION")).click();//homePage.openFeesCollectionHome();
		Thread.sleep(2000);
		
		
		
		//academic.openTransaction();
		System.out.println("Open Transaction");
		driver.findElement(By.linkText("Transaction")).click();
		
		//academic.openCollectFees();
		System.out.println("Open Collect Fees");
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Collect Fees']/parent::*")).click();
		
		//academic.openOutstandingFees();
		System.out.println("Open Outstanding Fees");
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Outstanding Fees']/parent::*")).click();
		
		
		/*Outstanding Fees */
		Thread.sleep(1000);
		//outstandingFees.ddlBasicCourseBranchStandard();
		Thread.sleep(1000);
		
		//outstandingFees.CourseYearStandard();
		System.out.println("Select ddlSection");
		Select course = new Select(driver.findElement(By.id("ddlCourse")));//select ddlReceiptType
		course.selectByVisibleText("STANDARD-5");
		
		Thread.sleep(1000);
		//outstandingFees.SearchBy();
		driver.findElement(By.id("SNAME")).click();
		System.out.println("Select SearchBy");
		
		Thread.sleep(1000);
		//outstandingFees.serchtext();
		System.out.println("Enter serchtext");
		driver.findElement(By.id("serchtext")).sendKeys("KAWALE");
		//driver.findElement(By.id("serchtext")).sendKeys("___");
		driver.findElement(By.cssSelector("div.eac-item")).click();
		
		acceptAlert();
		
//		Thread.sleep(1000);
//		outstandingFees.btnShowSpan();
		Thread.sleep(1000);
		//outstandingFees.acceptAlert();
		

		Thread.sleep(1000);
		//outstandingFees.Remark();
		System.out.println("Enter Remark");
		driver.findElement(By.id("txtRemark")).sendKeys("Good Marks");
		driver.findElement(By.id("txtRemark")).click();
		
		Thread.sleep(1000);
		//outstandingFees.PaymentOption();
		System.out.println("Select Payment Option");
		Select ddlpayoption = new Select(driver.findElement(By.id("ddlpayoption")));
		ddlpayoption.selectByVisibleText("RTGS");
		
		Thread.sleep(1000);
		//outstandingFees.PaymentID();
		System.out.println("Enter Payment Id");
		driver.findElement(By.id("payid")).sendKeys("CR12345678");
		
		Thread.sleep(1000);
		//outstandingFees.ReceiptMode();
		System.out.println("ddlrcptmode Cash Receipt");
		Select ddlPayMode = new Select(driver.findElement(By.id("ddlrcptmode")));
		ddlPayMode.selectByVisibleText("Cash Receipt");
		
		Thread.sleep(1000);
		//outstandingFees.PaymentMode();
		System.out.println("ddlPaymentMode Cash");
		Select ddlPaymentMode = new Select(driver.findElement(By.id("ddlPaymentMode")));
		ddlPaymentMode.selectByVisibleText("Cash");
		
		Thread.sleep(1000);
		//outstandingFees.amount();
		System.out.println("Enter Amount");
		driver.findElement(By.id("amount")).clear();
		driver.findElement(By.id("amount")).sendKeys("100");
		
		Thread.sleep(1000);
		//outstandingFees.btnAddAmt();
		System.out.println("Click on btnAddAmt");
		driver.findElement(By.id("btnAddAmt")).click();
		Thread.sleep(2000);
		
		Thread.sleep(1000);
		//outstandingFees.btnAdjust();
		System.out.println("Click On Adjust Fees");
		driver.findElement(By.id("btnAdjust")).click();
		
		Thread.sleep(1000);
		//outstandingFees.btnSubmitSpan();
		System.out.println("Click on btnSubmitSpan");
		driver.findElement(By.id("btnSubmitSpan")).click();
		
		
		Thread.sleep(10000);
		switchToNextWindow();
		driver.manage().window().maximize();
		//Utilities.getAShot();
		//PdfReader.readPdfContent("");
		
		//outstandingFees.Download();
		
		/*Outstanding Fees */
		
		

		Utilities.getAShot();

		
//
//		String actualConfiramationTxt = studentAdmission.verifyConfirmationMessage();
//		String expectedConfiramationTxt = "Record Saved Successfully!";
//		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
//				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);
//
//		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);

	}

	


}
