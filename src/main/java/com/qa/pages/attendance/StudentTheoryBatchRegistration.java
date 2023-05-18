package com.qa.pages.attendance;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class StudentTheoryBatchRegistration extends BaseClass
{
	
	public StudentTheoryBatchRegistration(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	//@FindBy (id = "ddlTeacher") private WebElement selectteacher;
	@FindBy (className = "checkbox") private WebElement selectteacher;
	@FindBy (className = "multiselect-selected-text") private WebElement clickteacher;
	@FindBy (id = "ddlSubject") private WebElement selectsubject;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Student Registration'])[1]/following::span[1]") private WebElement theorybatchstudentregistration;
	//@FindBy (xpath = "/html/body/div[3]/aside[1]/section/ul/li[5]/ul/li[1]/ul/li[9]/a/span") private WebElement theorybatchstudentregistration;
	
	public StudentTheoryBatchRegistration SelectTeacher()
	{
		System.out.println("select teacher");
		scrollIntoView(selectteacher, 0, 500);
		click(clickteacher);
		click(selectteacher);
		//Select ddl = new Select(selectteacher);
		//ddl.selectByVisibleText("QUALITY ASSURANCE");
		//ddl.selectByValue("3000890");		
		return this;
	}// AttendanceSubjectTeacherAllottmentPages end
	
	public StudentTheoryBatchRegistration SelectSubject() 
	{
		System.out.println("Select Theory Subject");
		Select ddl = new Select(selectsubject);
		ddl.selectByVisibleText("HINDI--HINDI(1.00)");
		return this;
	}//SelectSubject end

	public StudentTheoryBatchRegistration OpentheoryBatchStudentRegistration()
	{
		System.out.println("Open Theory batch student registration");
		click(theorybatchstudentregistration);
		return this;
	}// opentheoryBatchStudentRegistration end


   
}// AttendanceStudentAttendancePages class end