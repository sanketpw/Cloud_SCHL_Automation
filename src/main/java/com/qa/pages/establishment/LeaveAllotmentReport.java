package com.qa.pages.establishment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class LeaveAllotmentReport extends BaseClass{
	
	public LeaveAllotmentReport(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	@FindBy (id = "ddlDepartment") private WebElement ddlDepartment;
	@FindBy (id = "ddlDesignature") private WebElement ddlDesignature;
	@FindBy (id = "ddlYear") private WebElement ddlYear;
	@FindBy (id = "ddlPeriod") private WebElement ddlPeriod;
	@FindBy (id = "ddlLeave") private WebElement ddlLeave;
	@FindBy (id = "btnReport") private WebElement btnReport;

	
	public LeaveAllotmentReport ddlStaff() {
		System.out.println("Select ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByVisibleText("TEACHING");
		return this;
	}
	public LeaveAllotmentReport ddlDepartment() {
		System.out.println("Select ddlDepartment");
		Select ddl = new Select(ddlDepartment);
		ddl.selectByVisibleText("EDUCATION");
		return this;
	}
	
	public LeaveAllotmentReport ddlDesignature() {
		System.out.println("Select ddlDesignature");
		Select ddl = new Select(ddlDesignature);
		ddl.selectByVisibleText("PERMANENT");
		return this;
	}
	
	public LeaveAllotmentReport ddlPeriod() {
		System.out.println("Select ddlPeriod");
		Select ddl = new Select(ddlPeriod);
		ddl.selectByVisibleText("YEARLY");
		return this;
	}
	
	public LeaveAllotmentReport ddlYear() {
		System.out.println("Select Year");
		Select ddl = new Select(ddlYear);
		ddl.selectByVisibleText("2022");
		return this;
	}
	
	public LeaveAllotmentReport ddlLeave() {
		System.out.println("Select ddlLeave");
		Select ddl = new Select(ddlLeave);
		ddl.selectByVisibleText("CASUAL LEAVE-");
		return this;
	}
	
	
	public LeaveAllotmentReport btnReport() {
		System.out.println("Select btnReport");
		click(btnReport);
		return this;
	}
}