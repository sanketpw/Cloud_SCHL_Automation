package com.qa.pages.payroll;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

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

public class EmployeeInformation extends BaseClass{
	
	public EmployeeInformation(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "ddlTitle") private WebElement ddlTitle;
	@FindBy (id = "txtSequence") private WebElement Sequence;
	@FindBy (id = "txtLastName") private WebElement LastName;
	@FindBy (id = "txtFirstName") private WebElement FirstName;
	@FindBy (id = "txtMiddleName") private WebElement MiddleName;
	@FindBy (id = "ddlGender") private WebElement ddlGender;
	@FindBy (id = "txtDOB") private WebElement DOB;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Today'])[2]/following::th[3]") private WebElement monthDOB;
	@FindBy (xpath = "//div[3]/table/thead/tr/th") private WebElement prevmonthDOB;
	@FindBy (className = "day") private List<WebElement> dayDOB;
	
	@FindBy (id = "txtAadhar") private WebElement Aadhar;
	@FindBy (id = "txtPersonalEmail") private WebElement PersonalEmail;
	@FindBy (id = "txtMobile") private WebElement Mobile;
	@FindBy (id = "txtEmail") private WebElement Email;
	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	@FindBy (id = "ddlDepartment") private WebElement ddlDepartment;
	@FindBy (id = "ddlDesignation") private WebElement ddlDesignation;
	@FindBy (id = "ddlStaffType") private WebElement ddlStaffType;
	@FindBy (id = "ddlAppointment") private WebElement ddlAppointment;
	@FindBy (id = "ddlDesignationNature") private WebElement ddlDesignationNature;
	@FindBy (id = "ddlUserType") private WebElement ddlUserType;
	@FindBy (id = "ddlEmployeeType") private WebElement ddlEmployeeType;
	
	@FindBy (id = "txtDateofJoin") private WebElement DateofJoin;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Today'])[17]/following::th[3]") private WebElement monthDOJ;
	@FindBy (xpath = "/html/body/div[12]/div[3]/table/thead/tr[1]/th[1]") private WebElement prevmonthDOJ;
	@FindBy (className = "day") private List<WebElement> dayDOJ;
	
	@FindBy (id = "txtDateofIncrement") private WebElement DateofIncrement;
	@FindBy (xpath = "https://cims.mastersofterp.in/Payroll/PayEmployeeInformation/Index") private WebElement monthDOI;
	@FindBy (xpath = "/html/body/div[13]/div[3]/table/thead/tr[1]/th[1]") private WebElement prevMonthDOI; 
	@FindBy (className = "day") private WebElement dayDOI;
	
	@FindBy (id = "txtDateofRetire") private WebElement DateofRetire;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Tu'])[6]/preceding::th[3]") private WebElement monthDOR;
	@FindBy (xpath = "/html/body/div[12]/div[3]/table/thead/tr[1]/th[1]") private WebElement prevmonthDOR;
	@FindBy (className = "day") private List<WebElement> dayDOR;
	
	@FindBy (id = "txtDateofMarriage") private WebElement DateofMarriage;
	@FindBy (id = "radioYes") private WebElement radioYes;
	@FindBy (id = "radioHRAYes") private WebElement radioHRAYes;
	@FindBy (id = "ddlBank") private WebElement ddlBank;
	@FindBy (id = "txtAccNo") private WebElement AccNo;
	@FindBy (id = "txtbankbranch") private WebElement bankbranch;
	@FindBy (id = "txtPANNo") private WebElement PANNo;
	@FindBy (id = "txtUANNo") private WebElement UANNo;
	@FindBy (id = "txtIFSCCode") private WebElement IFSCCode;
	@FindBy (id = "ddlPayRule") private WebElement ddlPayRule;
	@FindBy (id = "txtBasic") private WebElement Basic;
	//@FindBy (id = "ddlPayScale") private WebElement ddlPayScale;
	@FindBy (id = "ddlpayLevel") private WebElement ddlpayLevel;
	@FindBy (id = "ddlCellNo") private WebElement ddlCellNo;
	@FindBy (id = "btnReport") private WebElement btnReport;
	@FindBy (id = "btnSubmit") private WebElement btnSubmit;
	
	
	public EmployeeInformation ddlTitle() {
		System.out.println("Select ddlTitle");
		Select ddl = new Select(ddlTitle);
		ddl.selectByVisibleText("MR.");
		return this;
	}
	
	public EmployeeInformation Sequence() {
		System.out.println("Enter Sequence");
		sendKeys(Sequence,"8435465");
		return this;
	}
	
	public EmployeeInformation LastName() throws Exception {
		System.out.println("Enter Last Name/Surname");
        File file = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);  
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();       
            System.out.println(rowCount);
            for (int i = 1; i <=1 ; i++) {
            Row row = sheet.getRow(i);
		sendKeys(LastName, row.getCell(2).getStringCellValue());
            }
        }
		return this;
	}
	
	public EmployeeInformation FirstName() throws Exception {
		System.out.println("Enter First Name");
        File file = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);  
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();       
            System.out.println(rowCount);
            for (int i = 1; i <=1 ; i++) {
            Row row = sheet.getRow(i);
		sendKeys(FirstName, row.getCell(0).getStringCellValue());
            }
        }
		return this;
	}
	
	public EmployeeInformation MiddleName() throws Exception {System.out.println("Enter Middle Name");
    File file = new File(".\\src\\test\\resources\\excel\\testdata.xlsx");
    FileInputStream inputStream = new FileInputStream(file);  
    try (Workbook workbook = new XSSFWorkbook(inputStream)) {
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();       
        System.out.println(rowCount);
        for (int i = 1; i <=1 ; i++) {
        Row row = sheet.getRow(i);
	sendKeys(FirstName, row.getCell(1).getStringCellValue());
        }
    }
	return this;
}
	
	public EmployeeInformation ddlGender() {
		System.out.println("Enter ddlGender");
		sendKeys(ddlGender,"FEMALE");
		return this;
	}
	
	
	public EmployeeInformation selectDOB()
	{
		System.out.println("Select Date of Birth");
		click(DOB);
		while (!getText(monthDOB).contains("June 2018")) 
		{
			click(prevmonthDOB);
		}
		int count = dayDOB.size();

		for (int i = 0; i < count; i++) {
			String text = dayDOB.get(i).getText();
			if (text.equalsIgnoreCase("21"))
			{
				dayDOB.get(i).click();
				break;
			}
		}
		return this;
	}
	
	public EmployeeInformation Aadhar() {
		System.out.println("Enter Aadhar");
		sendKeys(Aadhar,"123456789012");
		return this;
	}
	
	public EmployeeInformation PersonalEmail() {
		System.out.println("Enter PersonalEmail");
		sendKeys(PersonalEmail,"vishal@gmail.com");
		return this;
	}
	
	public EmployeeInformation Mobile() {
		System.out.println("Select Mobile");
		sendKeys(Mobile,"8149914475");
		return this;
	}
	
	public EmployeeInformation Email() {
		System.out.println("Enter Email");
		sendKeys(Email,"vishal.dhande.mastersofterp.com");
		return this;
	}
	
	public EmployeeInformation ddlStaff() {
		System.out.println("Select ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByVisibleText("NON TEACHING");
		return this;
	}
	
	public EmployeeInformation ddlDepartment() {
		System.out.println("Select ddlDepartment");
		Select ddl = new Select(ddlDepartment);
		ddl.selectByVisibleText("INFORMATION TECHNOLOGY");
		return this;
	}
	
	public EmployeeInformation ddlDesignation() {
		System.out.println("Select ddlDesignation");
		Select ddl = new Select(ddlDesignation);
		ddl.selectByVisibleText("PRINCIPAL");
		return this;
	}
	
	public EmployeeInformation ddlStaffType() {
		System.out.println("Select ddlStaffType");
		Select ddl = new Select(ddlStaffType);
		ddl.selectByVisibleText("VACATIONAL");
		return this;
	}
	
	public EmployeeInformation ddlAppointment() {
		System.out.println("Select ddlAppointment");
		Select ddl = new Select(ddlAppointment);
		ddl.selectByVisibleText("CIVIL");
		return this;
	}
	
	public EmployeeInformation ddlDesignationNature() {
		System.out.println("Select ddlDesignationNature");
		Select ddl = new Select(ddlDesignationNature);
		ddl.selectByVisibleText("PERMANENT");
		return this;
	}
	
	public EmployeeInformation ddlUserType() {
		System.out.println("Select ddlUserType");
		Select ddl = new Select(ddlUserType);
		ddl.selectByVisibleText("ADMIN");
		return this;
	}
	
	public EmployeeInformation ddlEmployeeType() {
		System.out.println("Select ddlEmployeeType");
		Select ddl = new Select(ddlEmployeeType);
		ddl.selectByVisibleText("REGULAR");
		return this;
		 
	}
	
	public EmployeeInformation selectDateofJoin() {
		System.out.println("Select DateofJoin");
		click(DateofJoin);
		while(!getText(monthDOJ).contains("August 2019"))
		{
			click (prevmonthDOJ);
		}
		int count = dayDOJ.size();
		
		for (int i = 0; i<count; i++) {
			String text = dayDOJ.get(i).getText();
			if (text.equalsIgnoreCase("21"))
			{
				dayDOJ.get(i).click();
				break;
			}
		}
		return this;
	}
	
//	public EmployeeInformation selectDateofIncrement() {
//		System.out.println("Select DateofIncrement");
//		click(DateofIncrement);
//		while(!getText(monthDOI).contains("August 2020"))
//		{
//			click(prevMonthDOI);
//		}
//		int count = dayDOI.size();
//		
//		for (int i = 0; i<count; i++) {
//			String text = dayDOI.get(i).getText();
//			if (text.equalsIgnoreCase("22"))
//			{
//				dayDOI.get(i).click();
//				break;
//			}
//		}
//		return this;
//	}
	
	public EmployeeInformation DateofRetire() {
		System.out.println("Select DateofRetire");
		click(DateofRetire);
		while(!getText(monthDOR).contains("September 2020"))
		{
			click(prevmonthDOR);
		}
		int count = dayDOR.size();
		
		for (int i = 0; i<count; i++) {
			String text = dayDOR.get(i).getText();
			if (text.equalsIgnoreCase("22"))
			{
				dayDOR.get(i).click();
				break;
			}
		}
		return this;
	}
	
	public EmployeeInformation DateofMarriage() {
		System.out.println("Enter DateofMarriage");
		sendKeys(DateofMarriage,"12/08/2020");
		return this;
	}
	
	public EmployeeInformation radioYes() {
		System.out.println("Enter radioYes");
		click(radioYes);
		return this;
	}
	
	public EmployeeInformation radioHRAYes() {
		System.out.println("Enter radioHRAYes");
		click(radioHRAYes);
		return this;
	}
	
	public EmployeeInformation ddlBank() {
		System.out.println("Enter ddlBank");
		Select ddl = new Select(ddlBank);
		ddl.selectByVisibleText("STATE BANK OF INDIA");
		return this;
	}
	
	public EmployeeInformation AccNo() {
		System.out.println("Select txtAccNo");
		sendKeys(AccNo,"9846548965647545");
		return this;
	}
	
	public EmployeeInformation bankbranch() {
		System.out.println("Enter bankbranch");
		sendKeys(bankbranch,"Kuhi");
		return this;
	}
	
	public EmployeeInformation PANNo() {
		System.out.println("Enter PANNo");
		sendKeys(PANNo,"AF8555SFR5");
		return this;
	}
	
	public EmployeeInformation UANNo() {
		System.out.println("Select UANNo");
		sendKeys(PANNo,"UAN984656565");
		return this;
	}
	
	public EmployeeInformation IFSCCode() {
		System.out.println("Enter IFSCCode");
		sendKeys(IFSCCode,"KUHI698465");
		return this;
	}
	
	public EmployeeInformation ddlPayRule() {
		System.out.println("Enter ddlPayRule");
		Select ddl = new Select(ddlPayRule);
		ddl.selectByVisibleText("R6");
		return this;
	}
	
	public EmployeeInformation ddlpayLevel() {
		System.out.println("Enter ddlpayLevel");
		Select ddl = new Select(ddlpayLevel);
		ddl.selectByVisibleText("PB-1(5200-20200)1800");
		return this;
	}
	
	public EmployeeInformation ddlCellNo() {
		System.out.println("Select ddlCellNo");
		Select ddl = new Select(ddlCellNo);
		ddl.selectByVisibleText("1");
		return this;
	}
		
	public EmployeeInformation btnReport() {
		System.out.println("Select btnReport");
		click(btnReport);
		return this;
	}
	
	public EmployeeInformation btnSubmit() {
		System.out.println("Enter btnSubmit");
		click(btnSubmit);
		return this;
	}
	

}