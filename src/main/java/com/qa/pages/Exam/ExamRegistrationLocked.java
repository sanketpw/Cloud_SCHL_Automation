package com.qa.pages.Exam;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseClass;

public class ExamRegistrationLocked extends BaseClass{
	
	public ExamRegistrationLocked (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Student Exam Registration']/parent::*") private WebElement StuExamRegistration;
	@FindBy (id = "ddlAcdSession") private WebElement AcademicSession;
	@FindBy (id = "ddlSession") private WebElement Session;
	@FindBy (id = "ddlBasicCourse") private WebElement BasicCourse;
	@FindBy (id = "ddlCourse") private WebElement Course; 
	@FindBy (id = "ddlMedium") private WebElement Medium;
	@FindBy (id="ChkAll") private WebElement SelectAll;
	@FindBy (id="btnSubmit") private WebElement Submit;
	@FindBy (id = "btnLock") private WebElement LockBtn;
	@FindBy (id = "btnCancel") private WebElement Cancel;
	@FindBy (xpath="/html/body/div[3]/aside[2]/section/div/div/div/div[2]/div[1]") private WebElement confirmationmessage;
	
	public ExamRegistrationLocked OpenStuExamRegistration() {			
		click(StuExamRegistration);
		System.out.println("Open StuExamRegistration");
		return this;
	}		
	
	public ExamRegistrationLocked AcdSession() {
		System.out.println("Select AcademicSession");
		Select ddl = new Select(AcademicSession);
		ddl.selectByVisibleText("2021-2020(NEW 1)");
		return this;
	}
	
	public ExamRegistrationLocked Session() {
		System.out.println("selecte Exam Session");
		Select ddl = new Select(Session);
		ddl.selectByVisibleText("ES_2021-2020(NEW1)");
		return this;
	}
	
	public ExamRegistrationLocked BasicCourse() {
		System.out.println("selecte BasicCourse");
		Select ddl = new Select(BasicCourse);
		ddl.selectByVisibleText("B.COM");
		return this;
	}
	
	public ExamRegistrationLocked Course() {
		System.out.println("selecte Course");
		Select ddl = new Select(Course);
		ddl.selectByVisibleText("B.COM - 1");
		return this;
	}
	
	public ExamRegistrationLocked Medium() {
		System.out.println("selecte Medium");
		Select ddl = new Select(Medium);
		ddl.selectByVisibleText("ENGLISH");
		return this;
	}
	
	public ExamRegistrationLocked SelectAll() {
		System.out.println("Click on SelectAll");
		click(SelectAll);
		return this;
	}
	
	public ExamRegistrationLocked Submit() {
		System.out.println("Click on Submit");
		click(Submit);
		return this;
	}
	
	public ExamRegistrationLocked LockBtn() {
		System.out.println("Click on Lock");
		click(LockBtn);			
		return this;
		}
	
	public ExamRegistrationLocked Cancel() {
		System.out.println("Click on Cancel");
		click(Cancel);			
		return this;
		}
	
	public String verifyConfirmationMessage() {
		String confirmationMsg = getText(confirmationmessage);
		System.out.println("Confirmation Message - " + confirmationMsg );
		return confirmationMsg;
	}
	
	
	
	
	public ExamRegistrationLocked StartExamRegistrationLOCK() throws Exception {
		OpenStuExamRegistration();
		AcdSession();
		Session();
		BasicCourse();
		Course();
		Medium();
		Thread.sleep(2000);
		SelectAll();
		Thread.sleep(2000);
		LockBtn();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10 /*timeout in seconds*/);
			if(wait.until(ExpectedConditions.alertIsPresent())==null) {  
			    System.out.println("alert was not present");
			   
			} else {
			    Alert alert = driver.switchTo().alert();
			    alert.accept();
			    System.out.println("alert was present and accepted");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		Thread.sleep(2000);
		
		return this;
	
}
	




	
}
