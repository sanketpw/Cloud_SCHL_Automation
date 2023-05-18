package com.qa.pages.payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class EmployeePaySlipReport extends BaseClass{
	
	public EmployeePaySlipReport(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "ddlMonthYear") private WebElement MonthORYear;
	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	@FindBy (id = "ddlEmployee") private WebElement ddlEmployee;
	@FindBy (id = "rdoAllEmployee") private WebElement rdoAllEmployee;
	@FindBy (id = "txtReason") private WebElement Reason;
	@FindBy (id = "btnShow") private WebElement btnShow;

	public EmployeePaySlipReport ddlMonthYear() {
		System.out.println("Select MonthORYear");
		Select ddl = new Select(MonthORYear);
		ddl.selectByValue("Oct2022");
		return this;
	}
	
	public EmployeePaySlipReport ddlStaff() {
		System.out.println("Select ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByValue("1780");
		return this;
	}
	
	public EmployeePaySlipReport ddlEmployee() {
		System.out.println("Select ddlEmployee");
		Select ddl = new Select(ddlEmployee);
		ddl.selectByValue("1167");
		return this;
	}
	
	public EmployeePaySlipReport rdoAllEmployee() {
		System.out.println("Select rdoAllEmployee");
		click(rdoAllEmployee);
		return this;
	}
	
	public EmployeePaySlipReport Reason() {
		System.out.println("Select Reason");
		sendKeys(Reason,"Full Attendance");
		return this;
	}
	
	public EmployeePaySlipReport btnShow() {
		System.out.println("Select txtReason");
		click(btnShow);
		return this;
	}
}