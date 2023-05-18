package com.qa.pages.establishment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class LeaveAllotment extends BaseClass{
	
	public LeaveAllotment(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "ddlOrder") private WebElement ddlOrderBy;
	@FindBy (id = "ddlStaffType") private WebElement ddlStaffType;
	@FindBy (id = "ddlDepartment") private WebElement ddlDepartment;
	@FindBy (id = "ddlDesignature") private WebElement ddlDesignature;
	@FindBy (id = "ddlPeriod") private WebElement ddlPeriod;
	@FindBy (id = "ddlYear") private WebElement ddlYear;
	@FindBy (id = "ddlLeave") private WebElement ddlLeave;
	@FindBy (id = "btnSubmit") private WebElement btnSubmit;
	@FindBy (id = "ChkEmp36224") private WebElement CheckBox;
	
	public LeaveAllotment ddlOrderBy() {
		System.out.println("Select ddlOrderBy");
		Select ddl = new Select(ddlOrderBy);
		ddl.selectByVisibleText("IDNO");
		return this;
	}
	
	public LeaveAllotment ddlStaff() {
		System.out.println("Select ddlStaff");
		Select ddl = new Select(ddlStaffType);
		ddl.selectByVisibleText("TEACHING");
		return this;
	}
	
	public LeaveAllotment ddlDepartment() {
		System.out.println("Select ddlDepartment");
		Select ddl = new Select(ddlDepartment);
		ddl.selectByVisibleText("EDUCATION");
		return this;
	}
	
	public LeaveAllotment ddlDesignature() {
		System.out.println("Select ddlDesignature");
		Select ddl = new Select(ddlDesignature);
		ddl.selectByVisibleText("PERMANENT");
		return this;
	}
	
	public LeaveAllotment ddlPeriod() {
		System.out.println("Select ddlPeriod");
		Select ddl = new Select(ddlPeriod);
		ddl.selectByVisibleText("YEARLY");
		return this;
	}
	
	public LeaveAllotment ddlYear() {
		System.out.println("Select ddlYear");
		Select ddl = new Select(ddlYear);
		ddl.selectByVisibleText("2022");
		return this;
	}
	
	public LeaveAllotment ddlLeave() {
		System.out.println("Select ddlLeave");
		Select ddl = new Select(ddlLeave);
		ddl.selectByVisibleText("CASUAL LEAVE-PERMANENT");
		return this;
	}
	
	public LeaveAllotment CheckBox() {
		System.out.println("Click on Checkbox");
		click(CheckBox);
		return this;
	}
	
	public LeaveAllotment btnSubmit() {
		System.out.println("Select btnSubmit");
		click(btnSubmit);
		return this;
	}
}