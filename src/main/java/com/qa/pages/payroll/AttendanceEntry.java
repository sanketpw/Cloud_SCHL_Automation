package com.qa.pages.payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class AttendanceEntry extends BaseClass{
	
	public AttendanceEntry(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	@FindBy (id = "ddlDepartment") private WebElement ddlDepartment;
	@FindBy (id = "ddlEmployeeType") private WebElement ddlEmployeeType;
	@FindBy (id = "ddlOrderBy") private WebElement ddlOrderBy;
	@FindBy (id = "txtAbsDay") private WebElement AbsDay;
	@FindBy (id = "btnSubmitSpan") private WebElement btnSubmit;

	public AttendanceEntry ddlStaff() {
		System.out.println("Enter ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByVisibleText("TEACHING");
		return this;
	}
	
	public AttendanceEntry ddlDepartment() {
		System.out.println("Enter ddlDepartment");
		Select ddl = new Select(ddlDepartment);
		ddl.selectByVisibleText("ELECTRICAL");
		return this;
	}
	
	public AttendanceEntry ddlEmployeeType() {
		System.out.println("Enter ddlEmployeeType");
		Select ddl = new Select(ddlEmployeeType);
		ddl.selectByVisibleText("FACULTY");
		return this;
	}
	
	public AttendanceEntry ddlOrderBy() {
		System.out.println("Enter ddlOrderBy");
		Select ddl = new Select(ddlOrderBy);
		ddl.selectByVisibleText("EMPLOYEE ID");
		return this;
	}
	
	public AttendanceEntry AbsDay() {
		System.out.println("Enter AbsDay");
		sendKeys(AbsDay,"1");
		return this;
	}
	
	public AttendanceEntry btnSubmit() {
		System.out.println("Enter btnSubmit");
		click(btnSubmit);
		return this;
	}
}