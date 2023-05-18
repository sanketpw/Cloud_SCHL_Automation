package com.qa.pages.establishment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class LeaveDetails extends BaseClass{
	
	public LeaveDetails(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "btnAddNew") private WebElement btnAddNew;
	@FindBy (id = "ddlLeaveName") private WebElement ddlLeaveName;
	@FindBy (id = "txtLeaveDays") private WebElement LeaveDays;
	@FindBy (id = "ddlStaffType") private WebElement ddlStaffType;
	@FindBy (id = "ddlPeriod") private WebElement ddlPeriod;
	@FindBy (id = "txtMaxDays") private WebElement MaxDays;
	@FindBy (id = "btnSubmit") private WebElement btnSubmit;
	

	public LeaveDetails btnAddNew() {
		System.out.println("Click btnAddNew");
		click(btnAddNew);
		return this;
	}
	
	public LeaveDetails ddlLeaveName() {
		System.out.println("Select ddlLeaveName");
		Select ddl = new Select(ddlLeaveName);
		ddl.selectByVisibleText("CASUAL LEAVE");
		return this;
	}
	
	public LeaveDetails LeaveDays() {
		System.out.println("Click LeaveDays");
		sendKeys(LeaveDays,"12");
		return this;
	}
	
	public LeaveDetails ddlStaffType() {
		System.out.println("Select ddlStaffType");
		Select ddl = new Select(ddlStaffType);
		ddl.selectByVisibleText("TEACHING");
		return this;
	}
	
	public LeaveDetails ddlPeriod() {
		System.out.println("Select ddlPeriod");
		Select ddl = new Select(ddlPeriod);
		ddl.selectByVisibleText("YEARLY");
		return this;
	}
	
	public LeaveDetails MaxDays() {
		System.out.println("Click MaxDays");
		sendKeys(MaxDays,"12");
		return this;
	}
	
	public LeaveDetails btnSubmit() {
		System.out.println("Click btnSubmit");
		click(btnSubmit);
		return this;
	}
}