package com.qa.pages.academic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class StudentAdmission extends BaseClass{
	
	public StudentAdmission(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	


	@FindBy (id = "ddlCourse") private WebElement course;
	@FindBy (id = "ddlFeeType") private WebElement feetype;
	@FindBy (id = "ddlStudentType") private WebElement studenttype;
	
	@FindBy (id = "ddlTitle") private WebElement title;
	@FindBy (id = "txtLastName") private WebElement lastName;
	@FindBy (id = "txtFirstName") private WebElement firstName;
	@FindBy (id = "txtMiddleName") private WebElement middleName;
	@FindBy (id = "ddlGender") private WebElement gender;
	@FindBy (id = "ddlSection") private WebElement ddlSection;
	
	@FindBy (id = "txtMother") private WebElement mothersname;
	@FindBy (id = "txtFather") private WebElement fathersname;
	//@FindBy (id = "txtEnrollmentNo") private WebElement enrollnumber;
	@FindBy (id = "txtMobile") private WebElement mobile;
	@FindBy (id = "txtEmail") private WebElement email;
	@FindBy (id = "txtRemark") private WebElement remark;
	@FindBy (id = "chkAdmZeroFee") private WebElement zeroamt;
	@FindBy (id = "btnSubmit") private WebElement submitbutton;
	
	@FindBy (id = "btnSubject") private WebElement subjectbutton;	
	@FindBy (id = "ddlMedium") private WebElement medium;	
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='*'])[10]/following::label[1]") private WebElement subjecttype;	
	@FindBy (id = "btnAddSubject") private WebElement addbutton;	

	@FindBy (id = "btnSaveAndPaySpan") private WebElement SubmitAndPay;	

	@FindBy (id = "success") private WebElement confirmationmessage;


	
	
	
	public StudentAdmission selectCourse() {
		System.out.println("Select Course");
		Select ddl = new Select(course);
		ddl.selectByVisibleText("STANDARD-5");
		return this;
	}
	
	
	public StudentAdmission selectFeeType() {
		System.out.println("Select Fee Type");
		Select ddl = new Select(feetype);
		ddl.selectByVisibleText("FULL PAYING");
		return this;
	}
	
	
	public StudentAdmission selectStudentType() {
		System.out.println("Select Student Type");
		Select ddl = new Select(studenttype);
		ddl.selectByVisibleText("REGULAR");
		return this;
	}
	
	
	public StudentAdmission selectTitle() {
		System.out.println("Select Title");
		Select ddl = new Select(title);
		ddl.selectByVisibleText("MASTER");
		return this;
	}
	

//	public StudentAdmission LastName(String name) throws IOException {
//		System.out.println("Enter Last Name");
//		sendKeys(lastName, name);
//		return this;
//	}
//	
//	
//	
//	public StudentAdmission FirstName(String name) throws IOException {
//		System.out.println("Enter Last Name");
//		sendKeys(firstName, name);
//		return this;
//	}
//	
//	
//	public StudentAdmission MiddleName(String name) throws IOException {
//		System.out.println("Enter Last Name");
//		sendKeys(middleName, name);
//		return this;
//	}

	public StudentAdmission enterLastName() throws IOException {
		System.out.println("Enter Last Name");
        File file = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);  
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
            System.out.println(rowCount);
            for (int i = 1; i <=1 ; i++) {
            Row row = sheet.getRow(i);
		sendKeys(lastName, row.getCell(2).getStringCellValue());
            }
        }
		return this;
	}
	


	public StudentAdmission enterFirstName() throws IOException {
		System.out.println("Enter First Name");
	    File file = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);  
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
            System.out.println(rowCount);
            for (int i = 1; i <=1 ; i++) {
            Row row = sheet.getRow(i);
		sendKeys(firstName, row.getCell(0).getStringCellValue());
            }
        }
		return this;
	}


	public StudentAdmission enterMiddleName() throws IOException {
		System.out.println("Enter Middle Name");
		   File file = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
	        FileInputStream inputStream = new FileInputStream(file);  
	        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
	            Sheet sheet = workbook.getSheetAt(0);
	            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
	            System.out.println(rowCount);
	            for (int i = 1; i <=1 ; i++) {
	            Row row = sheet.getRow(i);
			sendKeys(middleName, row.getCell(1).getStringCellValue());
	            }
	        }
			return this;
		}

	

	public StudentAdmission selectGender() {
		System.out.println("Select Gender");
		Select ddl = new Select(gender);
		ddl.selectByVisibleText("FEMALE");
		return this;
	}
	
	
	public StudentAdmission selectddlSection() {
		System.out.println("Select ddlSection");
		Select ddl = new Select(ddlSection);
		ddl.selectByVisibleText("A");
		return this;
	}
	
	
	public StudentAdmission enterMothersName() {
		System.out.println("Enter Mothers Name");
		sendKeys(mothersname, "Michelle");
		return this;
	}
	
	
	public StudentAdmission enterFathersName() {
		System.out.println("Enter Fathers Name");
		sendKeys(fathersname, "Danny");
		return this;
	}
	
	
//	public StudentAdmission enterEnrollmentNumber() {
//		System.out.println("Enter Enrollment Number ");
//		sendKeys(enrollnumber, "Test123");
//		return this;
//	}
	
	
	public StudentAdmission enterMobileNumber() {
		System.out.println("Enter Mobile Number");
		sendKeys(mobile, "9763639705");
		return this;
	}
	
	
	
	public StudentAdmission enterEmail() {
		System.out.println("Enter Email ");
		sendKeys(email, "raiscajitan@yahoo.in");;
		return this;
	}
	
	
	
	public StudentAdmission enterRemark() {
		System.out.println("Enter Remark");
		sendKeys(remark,"This is Test");
		return this;
	}
	
	
	public StudentAdmission checkAdmissionZeroAmt() {
		System.out.println("Check if want to do admission with zero amount");
		click(zeroamt);
		return this;
	}
	
	public StudentAdmission clickSubmitButton() {
		System.out.println("Click on Submit Button");
		click(submitbutton);
		return this;
	}
	
	public StudentAdmission clickOnAddSubjectButton() {
		System.out.println("Click on Add Subject Button");
		click(subjectbutton);
		return this;
	}
	
	public StudentAdmission selectMedium() {
		System.out.println("Select Medium");
		click(medium);
		Select ddl = new Select(medium);
		ddl.selectByVisibleText("ENGLISH");
		return this;
	}
	
	
	public StudentAdmission selectSubjectType() {
		System.out.println("Select Subject Type");
		click(subjecttype);
		return this;
	}
	
	
	public StudentAdmission clickOnAdd() {
		System.out.println("Click On Add Button");
		click(addbutton);
		return this;
	}

	
	public StudentAdmission clickOnSubmitAndPayBtn() {
		System.out.println("Click On Submit And Pay Button");
		click(SubmitAndPay);
		return this;
	}
	
	public String verifyConfirmationMessage() {
		String confirmationMsg = getText(confirmationmessage);
		System.out.println("Confirmation Message - " + confirmationMsg );
		return confirmationMsg;
	}
	
	

	
//	public StudentAdmission startAdmission(String fileName) throws IOException {
//		Workbook workbook = null;
//		String fileExtensionName = fileName.substring(fileName.indexOf("."));
//		File file = new File("D://CCMS_files//student name list.xls");
//		FileInputStream inputStream = new FileInputStream(file);	
//		
//		if (fileExtensionName.equals(".xlsx")) {
//			workbook = new XSSFWorkbook(inputStream);
//		}
//
//		else if (fileExtensionName.equals(".xls")) {
//			workbook = new HSSFWorkbook(inputStream);
//		}
//		
//		Sheet sheet = workbook.getSheetAt(0);
//		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();		// Find number of rows in excel file
//		System.out.println(rowCount); 
//		for (int i = 105; i <=110 ; i++) {
//		selectBasicCourse();
//		selectCourse();
//		selectFeeType();
//		selectStudentType();
//		selectTitle();
//		Row row = sheet.getRow(i);
//		enterLastName(row.getCell(2).getStringCellValue());
//		enterFirstName(row.getCell(0).getStringCellValue());
//		enterMiddleName(row.getCell(1).getStringCellValue());
//		selectGender();
//		selectCasteCategory();
//		enterMothersName();
//		enterFathersName();
//		enterEnrollmentNumber();
//		enterMobileNumber();
//		enterEmail();
//		enterRemark();
//		checkAdmissionZeroAmt();
//		clickSubmitButton();
//		verifyConfirmationMessage();
//		 
//
//		}
//		return this;
//	
//	}
	
	
	
}