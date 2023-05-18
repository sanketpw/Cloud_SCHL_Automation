package com.qa.pages.payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class EmployeeIDCard extends BaseClass{
	
	public EmployeeIDCard(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	@FindBy (id = "btnEmpList") private WebElement btnEmpList;
	
	public EmployeeIDCard ddlStaff() {
		System.out.println("Select ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByVisibleText("TEACHING");
		return this;
	}
	
	
	public EmployeeIDCard btnEmpList() {
		System.out.println("Click btnEmpList");
		click(btnEmpList);
		return this;
	}
}