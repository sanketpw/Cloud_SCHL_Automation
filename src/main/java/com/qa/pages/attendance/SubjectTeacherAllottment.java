package com.qa.pages.attendance;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class SubjectTeacherAllottment extends BaseClass
{

	public SubjectTeacherAllottment(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Practical Batch Allotment'])[1]/following::span[1]") private WebElement opensubjectteacherallotment   ;
	@FindBy (id = "ddlTeacher") private WebElement selectteacher;
	@FindBy (id = "ddlSubject") private WebElement selectsubject;

	
	public SubjectTeacherAllottment OpenSubjectTeacherAllottment()
	{
		System.out.println("open subject teacher allottment ");
		click(opensubjectteacherallotment);
		return this;
	}// OpenSubjectTeacherAllottment end
	
	public SubjectTeacherAllottment SelectTeacher()
	{
		System.out.println("select teacher");
		Select ddl = new Select(selectteacher);
		ddl.selectByVisibleText("QUALITY ASSURANCE");		
		return this;
	}// AttendanceSubjectTeacherAllottmentPages end
	
	public SubjectTeacherAllottment SelectSubject() 
	{
		System.out.println("Select Theory Subject");
		Select ddl = new Select(selectsubject);
		ddl.selectByVisibleText("HINDI--HINDI(1.00)");
		return this;
	}//SelectSubject end


}// AttendanceSubjectTeacherAllottmentPages class end