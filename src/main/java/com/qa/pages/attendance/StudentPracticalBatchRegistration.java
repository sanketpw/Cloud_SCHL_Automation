package com.qa.pages.attendance;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class StudentPracticalBatchRegistration extends BaseClass
{
	
	public StudentPracticalBatchRegistration(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	//@FindBy (id = "ddlTeacher") private WebElement selectteacher;
	@FindBy (className = "multiselect-selected-text") private WebElement clickteacher;
	@FindBy (className = "checkbox") private WebElement selectteacher;
	
	@FindBy (id = "ddlSubject") private WebElement selectsubject;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Student Registration'])[1]/following::span[1]") private WebElement theorybatchstudentregistration;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Theory Batch Student Registration'])[1]/following::span[1]") private WebElement practicalbatchstudentregistration;

	
	public StudentPracticalBatchRegistration SelectTeacher()
	{
		System.out.println("select teacher");
		click(clickteacher);
		click(selectteacher);
		//Select ddl = new Select(selectteacher);
		//ddl.selectByVisibleText("QUALITY ASSURANCE");
		//ddl.selectByValue("3000890");
		return this;
	}// AttendanceSubjectTeacherAllottmentPages end
	
	public StudentPracticalBatchRegistration SelectSubject() 
	{
		System.out.println("Select Theory Subject");
		Select ddl = new Select(selectsubject);
		ddl.selectByVisibleText("19--JAVA(30.00)");
		return this;
	}//SelectSubject end

	public StudentPracticalBatchRegistration OpentheoryBatchStudentRegistration()
	{
		System.out.println("Open Theory batch student registration");
		click(theorybatchstudentregistration);
		return this;
	}// opentheoryBatchStudentRegistration end
	
	public StudentPracticalBatchRegistration OpenpracticalBatchStudentRegistration()
	{
		System.out.println("Open practical batch student registration");
		click(practicalbatchstudentregistration);
		return this;
	}// OpenpracticalBatchStudentRegistration end


   
}// AttendanceStudentPracticalBatchRegistrationPages class end