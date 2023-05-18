package com.qa.pages.payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class AbstractSalaryNewReport extends BaseClass{
	
	public AbstractSalaryNewReport(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "ddlMonthYear") private WebElement ddlMonthYear;
	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	@FindBy (id = "lstEmployee") private WebElement ddlEmployee;
	@FindBy (id = "btnAddSpan") private WebElement btnAddSpan;
	
	public AbstractSalaryNewReport ddlMonthYear() {
		System.out.println("Select ddlMonthYear");
		Select ddl = new Select(ddlMonthYear);
		ddl.selectByValue("Oct2022");
		return this;
	}
	
	public AbstractSalaryNewReport ddlStaff() {
		System.out.println("Select ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByValue("1780");
		return this;
	}
	
	public AbstractSalaryNewReport ddlEmployee() {
		System.out.println("Select ddlEmployee");
		Select ddl = new Select(ddlEmployee);
		ddl.selectByVisibleText("REGULAR");
		return this;
	}
	
	public AbstractSalaryNewReport btnAddSpan() {
		System.out.println("Click btnAddSpan");
		click(btnAddSpan);
		return this;
	}
}