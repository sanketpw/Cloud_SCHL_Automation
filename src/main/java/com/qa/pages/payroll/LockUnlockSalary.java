package com.qa.pages.payroll;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class LockUnlockSalary extends BaseClass{
	
	public LockUnlockSalary(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "btnAddSpan") private WebElement btnPermanentLockSalary;
	@FindBy (xpath = "//input[@class='form-control datePicker']") private WebElement MonthYear;
	@FindBy (xpath = "(//th[@class='switch'])[8]") private WebElement month;
	@FindBy (xpath = "(//th[@class='prev'])[8]") private WebElement prevmonth;
	@FindBy (xpath = "//td[@class='day']") private List<WebElement> day;

	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	
	@FindBy (id = "txtDepositDate") private WebElement DepositDate;
//	@FindBy (xpath = "//div[@class='datetimepicker-days']//th[@class='switch']") private WebElement monthDD;
//	@FindBy (xpath = "//div[@class='datetimepicker-days']//th[@class='prev']") private WebElement prevmonthDD;
//	@FindBy (xpath = "//td[@class='day']") private List<WebElement> dayDD;
	@FindBy (xpath = "//td[@class='day']") private WebElement dayDD1;
	
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)=concat('What', \"'\", 's New?')])[1]/preceding::span[2]") private WebElement btnLockSalaryPermanent;
//	@FindBy (id = "btnBack") private WebElement btnBack;
	
	public LockUnlockSalary btnPermanentLockSalary() {
		System.out.println("Click   Permanent Lock Salary button");
		click(btnPermanentLockSalary);
		return this;
	}
	
	public LockUnlockSalary selectMonthYear() {
		System.out.println("Select MonthYear");
		click(MonthYear);
		while (!getText(month).contains("July 2022"))
		{
			click(prevmonth);
		}
		int count = day.size();
		
		for (int i = 0; i < count; i++) {
			String text = day.get(i).getText();
			if (text.equalsIgnoreCase("28"))
			{
				day.get(i).click();
				break;
			}
		}
		return this;
		
	}
	
	public LockUnlockSalary ddlStaff() {
		System.out.println("Enter ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByVisibleText("TEACHING");
		return this;
	}
	
	public LockUnlockSalary DepositDate() {
		System.out.println("Select DepositDate");
		sendKeys(DepositDate,"28/07/2022");
		return this;
	}
	
	public LockUnlockSalary dayDD1() {
		System.out.println("Click on dayDD");
		click(dayDD1);
		return this;
	}
	
	public LockUnlockSalary btnLockSalaryPermanent() {
		System.out.println("Click btnLockSalaryPermanent");
		click(btnLockSalaryPermanent);
		return this;
	}
	
	
//	public LockUnlockSalary btnBack() {
//		System.out.println("Click btnBack");
//		click(btnBack);
//		return this;
//	}
}