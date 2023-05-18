package com.qa.tests.academic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.qa.pages.academic.StudentAdmission;
import com.qa.pages.academic.SubmitAndPay;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.Utilities;




public class StudentAdmissionTests extends BaseClass {

	LoginPageAdmin loginPage;
	HomePageAdmin homePage;
//	Academic academic;
	StudentAdmission studentAdmission;
//	SubmitAndPay submitAndPay;

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

	
	


	@Test(priority=1)
	public void Student_Admission_With_ZeroAmt_Fees_Amount() throws IOException, Exception {

		loginPage = new LoginPageAdmin(driver);
//		academic = new Academic(driver);
		studentAdmission = new StudentAdmission(driver);
		
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"),
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));

		//homePage.openADMISSION();
		Thread.sleep(2000);
		System.out.println("Open ADMISSION");
		driver.findElement(By.linkText("ADMISSION")).click();
		Thread.sleep(2000);
		
		
		//academic.openAdmissions();
		System.out.println("Open Admissions");
		driver.findElement(By.id("menu-li")).click();
		
		
		//academic.openAdmitStudents();
		System.out.println("open AdmitStudents");
		driver.findElement(By.xpath("//*[@id=\"menu-li\"]/ul/li[1]/a/span")).click();
		
		
		//academic.openAdmission();
		System.out.println("Open Admission");
		driver.findElement(By.xpath("//*[@id=\"btnId\"]/span")).click();
		
		
		//Course Details
		
		//studentAdmission.selectCourse();
		Select course = new Select(driver.findElement(By.id("ddlCourse")));//select ddlReceiptType
		course.selectByVisibleText("STANDARD-5");
		System.out.println("Select ddlCourse");
		
		//studentAdmission.selectFeeType();
		System.out.println("Select ddlFeeType");
		Select feetype = new Select(driver.findElement(By.id("ddlFeeType")));//select ddlReceiptType
		feetype.selectByVisibleText("FULL PAYING");
		
		
		//studentAdmission.selectStudentType();
		System.out.println("Select ddlStudentType");
		Select studenttype = new Select(driver.findElement(By.id("ddlStudentType")));//select ddlReceiptType
		studenttype.selectByVisibleText("REGULAR");
		
		
		//studentAdmission.selectTitle();
		System.out.println("Select ddlTitle");
		Select title = new Select(driver.findElement(By.id("ddlTitle")));//select ddlReceiptType
		title.selectByVisibleText("MASTER");
		
		
		//Student Details
		
		//studentAdmission.enterLastName();
		System.out.println("Enter Last Name");
        File file = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);  
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
            System.out.println(rowCount);
            for (int i = 1; i <=1 ; i++) {
            Row row = sheet.getRow(i);
		sendKeys(driver.findElement(By.id("txtLastName")), row.getCell(2).getStringCellValue());
            }
        }
		
		//studentAdmission.enterFirstName();
		System.out.println("Enter First Name");
	    File fileA = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
        FileInputStream inputStreamA = new FileInputStream(fileA);  
        try (Workbook workbook = new XSSFWorkbook(inputStreamA)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
            System.out.println(rowCount);
            for (int i = 1; i <=1 ; i++) {
            Row row = sheet.getRow(i);
		sendKeys(driver.findElement(By.id("txtFirstName")), row.getCell(0).getStringCellValue());
            }
        }
		
		//studentAdmission.enterMiddleName();
		System.out.println("Enter Middle Name");
		   File fileB = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
	        FileInputStream inputStreamB = new FileInputStream(fileB);  
	        try (Workbook workbook = new XSSFWorkbook(inputStreamB)) {
	            Sheet sheet = workbook.getSheetAt(0);
	            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
	            System.out.println(rowCount);
	            for (int i = 1; i <=1 ; i++) {
	            Row row = sheet.getRow(i);
			sendKeys(driver.findElement(By.id("txtMiddleName")), row.getCell(1).getStringCellValue());
	            }
	        }
		
		//studentAdmission.selectGender();
		Select gender = new Select(driver.findElement(By.id("ddlGender")));//select ddlReceiptType
		gender.selectByVisibleText("FEMALE");
		System.out.println("Select Gender");
		
		//studentAdmission.selectddlSection();
		Select selectddlSection = new Select(driver.findElement(By.id("ddlSection")));//select ddlReceiptType
		selectddlSection.selectByVisibleText("A");
		System.out.println("Select ddlSection");
		
		//studentAdmission.enterMothersName();
		driver.findElement(By.id("txtMother")).sendKeys("Michelle");
		System.out.println("Enter name of MothersName");
		
		//studentAdmission.enterFathersName();
		driver.findElement(By.id("txtFather")).sendKeys("Danny");
		System.out.println("Enter name of Father");
		
		//studentAdmission.enterEnrollmentNumber();
		
		//studentAdmission.enterMobileNumber();
		driver.findElement(By.id("txtMobile")).sendKeys("9763639705");
		System.out.println("Enter Mobile No.");
		
		//studentAdmission.enterEmail();
		driver.findElement(By.id("txtEmail")).sendKeys("vishal@gmail.com");
		System.out.println("Enter Email");
		
		//studentAdmission.enterRemark();
		driver.findElement(By.id("txtRemark")).sendKeys("This is Test Admission");
		System.out.println("enter Remark");
		
		//studentAdmission.checkAdmissionZeroAmt();
		driver.findElement(By.id("chkAdmZeroFee")).click();
		System.out.println("click on check on zero amt check box");
		//Subject Details
		
		//studentAdmission.clickOnAddSubjectButton();
		Thread.sleep(2000);
		driver.findElement(By.id("btnSubject")).click();
		Thread.sleep(2000);
		System.out.println("click on btnSubject");
		
		//studentAdmission.selectMedium();
		Select medium = new Select(driver.findElement(By.id("ddlMedium")));
		medium.selectByVisibleText("ENGLISH");
		System.out.println("click on ddlMedium");
		
		//studentAdmission.selectSubjectType();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[10]/following::label[1]")).click();
		System.out.println("click on select subject type");
		
		//studentAdmission.clickOnAdd();
		driver.findElement(By.id("btnAddSubject")).click();
		Thread.sleep(2000);
		System.out.println("click on AddSubject button");
		
		//studentAdmission.clickSubmitButton();
		driver.findElement(By.id("btnSubmit")).click();
		System.out.println("click on Submit button");
		
		Utilities.getAShot();
		
		
		String actualConfiramationTxt = studentAdmission.verifyConfirmationMessage();
		String expectedConfiramationTxt = "Record Saved Succesfully!";
		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);

		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);

	}
	
	
	@Test(priority=2)
	public void Student_Admission_With_Direct_Submit() throws IOException, Exception {

		loginPage = new LoginPageAdmin(driver);
//		academic = new Academic(driver);
		studentAdmission = new StudentAdmission(driver);
		
		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"),
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));

		//homePage.openADMISSION();
		Thread.sleep(2000);
		driver.findElement(By.linkText("ADMISSION")).click();
		Thread.sleep(2000);
		System.out.println("Open ADMISSION");
		
		//academic.openAdmissions();
		driver.findElement(By.id("menu-li")).click();
		System.out.println("Open Admissions");
		
		//academic.openAdmitStudents();
		driver.findElement(By.xpath("//*[@id=\"menu-li\"]/ul/li[1]/a/span")).click();
		System.out.println("open AdmitStudents");
		
		//academic.openAdmission();
		driver.findElement(By.xpath("//*[@id=\"btnId\"]/span")).click();
		System.out.println("Open Admission");
		
		//Course Details
		//studentAdmission.selectCourse();
		Select course = new Select(driver.findElement(By.id("ddlCourse")));//select ddlReceiptType
		course.selectByVisibleText("STANDARD-5");
		System.out.println("Select ddlCourse");
		
		//studentAdmission.selectFeeType();
		Select feetype = new Select(driver.findElement(By.id("ddlFeeType")));//select ddlReceiptType
		feetype.selectByVisibleText("FULL PAYING");
		System.out.println("Select ddlFeeType");
		
		//studentAdmission.selectStudentType();
		Select studenttype = new Select(driver.findElement(By.id("ddlStudentType")));//select ddlReceiptType
		studenttype.selectByVisibleText("REGULAR");
		System.out.println("Select ddlStudentType");
		
		//studentAdmission.selectTitle();
		Select title = new Select(driver.findElement(By.id("ddlTitle")));//select ddlReceiptType
		title.selectByVisibleText("MASTER");
		System.out.println("Select ddlTitle");
		
		//Student Details
		//studentAdmission.enterLastName();
		System.out.println("Enter Last Name");
        File file = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);  
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
            System.out.println(rowCount);
            for (int i = 1; i <=1 ; i++) {
            Row row = sheet.getRow(i);
		sendKeys(driver.findElement(By.id("txtLastName")), row.getCell(2).getStringCellValue());
            }
        }
		
		//studentAdmission.enterFirstName();
		System.out.println("Enter First Name");
	    File fileA = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
        FileInputStream inputStreamA = new FileInputStream(fileA);  
        try (Workbook workbook = new XSSFWorkbook(inputStreamA)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
            System.out.println(rowCount);
            for (int i = 1; i <=1 ; i++) {
            Row row = sheet.getRow(i);
		sendKeys(driver.findElement(By.id("txtFirstName")), row.getCell(0).getStringCellValue());
            }
        }
        
		//studentAdmission.enterMiddleName();
		System.out.println("Enter Middle Name");
		   File fileB = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
	        FileInputStream inputStreamB = new FileInputStream(fileB);  
	        try (Workbook workbook = new XSSFWorkbook(inputStreamB)) {
	            Sheet sheet = workbook.getSheetAt(0);
	            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
	            System.out.println(rowCount);
	            for (int i = 1; i <=1 ; i++) {
	            Row row = sheet.getRow(i);
			sendKeys(driver.findElement(By.id("txtMiddleName")), row.getCell(1).getStringCellValue());
	            }
	        }
		
		//studentAdmission.selectGender();
		Select gender = new Select(driver.findElement(By.id("ddlGender")));//select ddlReceiptType
		gender.selectByVisibleText("FEMALE");
		System.out.println("Select Gender");
		
		//studentAdmission.selectddlSection();
		Select selectddlSection = new Select(driver.findElement(By.id("ddlSection")));//select ddlReceiptType
		selectddlSection.selectByVisibleText("A");
		System.out.println("Select ddlSection");
		
		//studentAdmission.enterMothersName();
		driver.findElement(By.id("txtMother")).sendKeys("Michelle");
		System.out.println("Enter name of MothersName");
		
		//studentAdmission.enterFathersName();
		driver.findElement(By.id("txtFather")).sendKeys("Danny");
		System.out.println("Enter name of Father");
		
		//studentAdmission.enterEnrollmentNumber();
		//studentAdmission.enterMobileNumber();
		driver.findElement(By.id("txtMobile")).sendKeys("9763639705");
		System.out.println("Enter Mobile No.");
		
		//studentAdmission.enterEmail();
		driver.findElement(By.id("txtEmail")).sendKeys("vishal@gmail.com");
		System.out.println("Enter Email");
		
		//studentAdmission.enterRemark();
		driver.findElement(By.id("txtRemark")).sendKeys("This is Test Admission");
		System.out.println("enter Remark");
		
		//Subject Details
		//studentAdmission.clickOnAddSubjectButton();
		Thread.sleep(2000);
		driver.findElement(By.id("btnSubject")).click();
		Thread.sleep(2000);
		System.out.println("click on btnSubject");
		
		//studentAdmission.selectMedium();
		Select medium = new Select(driver.findElement(By.id("ddlMedium")));
		medium.selectByVisibleText("ENGLISH");
		System.out.println("click on ddlMedium");
		
		//studentAdmission.selectSubjectType();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[10]/following::label[1]")).click();
		System.out.println("click on select subject type");
		
		//studentAdmission.clickOnAdd();
		driver.findElement(By.id("btnAddSubject")).click();
		Thread.sleep(2000);
		System.out.println("click on AddSubject button");
		
		//studentAdmission.clickSubmitButton();
		driver.findElement(By.id("btnSubmit")).click();
		System.out.println("click on Submit button");
		

		Utilities.getAShot();
		

		String actualConfiramationTxt = studentAdmission.verifyConfirmationMessage();
		String expectedConfiramationTxt = "Record Saved Succesfully!";
		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);

		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);

	}

	
	@Test(priority=3)
	public void Student_Admission_With_Submit_And_Pay() throws Exception {

		loginPage = new LoginPageAdmin(driver);
//		academic = new Academic(driver);
		studentAdmission = new StudentAdmission(driver);
//		submitAndPay = new SubmitAndPay(driver);

		
		homePage = loginPage.login(loginUsers.getJSONObject("CloudSchoolAdmin").getString("userName"),
				loginUsers.getJSONObject("CloudSchoolAdmin").getString("password"));

		//homePage.openADMISSION();
		Thread.sleep(2000);
		driver.findElement(By.linkText("ADMISSION")).click();
		Thread.sleep(2000);
		System.out.println("Open ADMISSION");
		
		//academic.openAdmissions();
		driver.findElement(By.id("menu-li")).click();
		System.out.println("Open Admissions");
		
		//academic.openAdmitStudents();
		driver.findElement(By.xpath("//*[@id=\"menu-li\"]/ul/li[1]/a/span")).click();
		System.out.println("open AdmitStudents");
		
		//academic.openAdmission();
		driver.findElement(By.xpath("//*[@id=\"btnId\"]/span")).click();
		System.out.println("Open Admission");
		
		//Course Details
		//studentAdmission.selectCourse();
		Select course = new Select(driver.findElement(By.id("ddlCourse")));//select ddlReceiptType
		course.selectByVisibleText("STANDARD-5");
		System.out.println("Select ddlCourse");
		
		//studentAdmission.selectFeeType();
		Select feetype = new Select(driver.findElement(By.id("ddlFeeType")));//select ddlReceiptType
		feetype.selectByVisibleText("FULL PAYING");
		System.out.println("Select ddlFeeType");
		
		//studentAdmission.selectStudentType();
		Select studenttype = new Select(driver.findElement(By.id("ddlStudentType")));//select ddlReceiptType
		studenttype.selectByVisibleText("REGULAR");
		System.out.println("Select ddlStudentType");
		
		//studentAdmission.selectTitle();
		Select title = new Select(driver.findElement(By.id("ddlTitle")));//select ddlReceiptType
		title.selectByVisibleText("MASTER");
		System.out.println("Select ddlTitle");
		
		//Student Details
		//studentAdmission.enterLastName();
		System.out.println("Enter Last Name");
        File file = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);  
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
            System.out.println(rowCount);
            for (int i = 1; i <=1 ; i++) {
            Row row = sheet.getRow(i);
		sendKeys(driver.findElement(By.id("txtLastName")), row.getCell(2).getStringCellValue());
            }
        }
        
		//studentAdmission.enterFirstName();
		System.out.println("Enter First Name");
	    File fileA = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
        FileInputStream inputStreamA = new FileInputStream(fileA);  
        try (Workbook workbook = new XSSFWorkbook(inputStreamA)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
            System.out.println(rowCount);
            for (int i = 1; i <=1 ; i++) {
            Row row = sheet.getRow(i);
		sendKeys(driver.findElement(By.id("txtFirstName")), row.getCell(0).getStringCellValue());
            }
        }
		
		//studentAdmission.enterMiddleName();
		System.out.println("Enter Middle Name");
		   File fileB = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
	        FileInputStream inputStreamB = new FileInputStream(fileB);  
	        try (Workbook workbook = new XSSFWorkbook(inputStreamB)) {
	            Sheet sheet = workbook.getSheetAt(0);
	            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
	            System.out.println(rowCount);
	            for (int i = 1; i <=1 ; i++) {
	            Row row = sheet.getRow(i);
			sendKeys(driver.findElement(By.id("txtMiddleName")), row.getCell(1).getStringCellValue());
	            }
	        }
		
		//studentAdmission.selectGender();
		Select gender = new Select(driver.findElement(By.id("ddlGender")));//select ddlReceiptType
		gender.selectByVisibleText("FEMALE");
		System.out.println("Select Gender");
		
		//studentAdmission.selectddlSection();
		Select selectddlSection = new Select(driver.findElement(By.id("ddlSection")));//select ddlReceiptType
		selectddlSection.selectByVisibleText("A");
		System.out.println("Select ddlSection");
		
		//studentAdmission.enterMothersName();
		driver.findElement(By.id("txtMother")).sendKeys("Michelle");
		System.out.println("Enter name of MothersName");
		
		//studentAdmission.enterFathersName();
		driver.findElement(By.id("txtFather")).sendKeys("Danny");
		System.out.println("Enter name of Father");
		
		//studentAdmission.enterEnrollmentNumber();
		//studentAdmission.enterMobileNumber();
		driver.findElement(By.id("txtMobile")).sendKeys("9763639705");
		System.out.println("Enter Mobile No.");
		
		//studentAdmission.enterEmail();
		driver.findElement(By.id("txtEmail")).sendKeys("vishal@gmail.com");
		System.out.println("Enter Email");
		
		//studentAdmission.enterRemark();
		driver.findElement(By.id("txtRemark")).sendKeys("This is Test Admission");
		System.out.println("enter Remark");
		
		//Subject Details
		
		//studentAdmission.clickOnAddSubjectButton();
		Thread.sleep(2000);
		driver.findElement(By.id("btnSubject")).click();
		Thread.sleep(2000);
		System.out.println("click on btnSubject");
		
		//studentAdmission.selectMedium();
		Select medium = new Select(driver.findElement(By.id("ddlMedium")));
		medium.selectByVisibleText("ENGLISH");
		System.out.println("click on ddlMedium");
		
		//studentAdmission.selectSubjectType();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[10]/following::label[1]")).click();
		System.out.println("click on select subject type");
		
		//studentAdmission.clickOnAdd();
		driver.findElement(By.id("btnAddSubject")).click();
		Thread.sleep(2000);
		System.out.println("click on AddSubject button");
		
		//studentAdmission.clickOnSubmitAndPayBtn();
		driver.findElement(By.id("btnSaveAndPaySpan")).click();
		Thread.sleep(1000);
		System.out.println("Click On Submit And Pay Button");
		//SubmitAndPay
		
		Thread.sleep(1000);
		switchToFrame(0);
		Thread.sleep(3000);
		//submitAndPay.enterRemarkPayment();
		System.out.println("Enter remarkPayment");
		driver.findElement(By.id("txtRemark")).sendKeys("Payment Completed");
		
		
		//submitAndPay.selectADMThrough();
		Thread.sleep(1000);
		Select admthrough = new Select(driver.findElement(By.id("ddlAdmThrough")));
		admthrough.selectByVisibleText("REGULAR");
		System.out.println("Select ADM Through");
		
		//submitAndPay.selectPaymentOption();
		Select paymentoption = new Select(driver.findElement(By.id("ddlpayoption")));
		paymentoption.selectByVisibleText("RTGS");
		System.out.println("Select Payment Option");
		
		//submitAndPay.enterPaymentId();
		driver.findElement(By.id("payid")).sendKeys("CR12345678");
		System.out.println("Enter Payment Id");
		
//		submitAndPay.selectPaymentMode("Cheque");
		
		//submitAndPay.enterAmount();
		driver.findElement(By.id("amount")).clear();
		driver.findElement(By.id("amount")).sendKeys("100");
		System.out.println("Enter Amount");
		
		//submitAndPay.clickOnAddButton();
		driver.findElement(By.xpath("//button[@id='btnAddAmt']/span")).click();
		Thread.sleep(2000);
		System.out.println("Click On Add Button");
		
		Thread.sleep(2000);
		//submitAndPay.clickOnAdjustFees();
		driver.findElement(By.xpath("//button[@id='btnAdjustFees']/span")).click();
		System.out.println("Click On Adjust Fees");
		
		Thread.sleep(1000);
		//submitAndPay.clickOnSubmitButton();
		driver.findElement(By.xpath("//button[@id='btnSubmit']/span")).click();
		System.out.println("Click On Submit Button");
		
		Thread.sleep(1500);
		switchToNextWindow();
		Thread.sleep(2000);
		
		Utilities.getAShot();

//		String actualConfiramationTxt = studentAdmission.verifyConfirmationMessage();
//		String expectedConfiramationTxt = "Record Saved Succesfully!";
//		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
//				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);
//
//		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);

	}
	
}



