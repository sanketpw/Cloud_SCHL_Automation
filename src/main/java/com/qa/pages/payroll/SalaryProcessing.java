package com.qa.pages.payroll;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class SalaryProcessing extends BaseClass{
	
	public SalaryProcessing(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "txtMonthYear") private WebElement MonthYear;
	@FindBy (xpath = "//div[@class='datetimepicker-days']//th[@class='switch']") private WebElement monthMY;
	@FindBy (xpath = "//div[@class='datetimepicker-days']//th[@class='prev']") private WebElement prevmonthMY;
	@FindBy (xpath = "//td[@class='day']") private List<WebElement> day;

	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	@FindBy (id = "btnSalaryProcess") private WebElement btnSalaryProcess;

//	public SalaryProcessing MonthYear() {
//		System.out.println("Enter MonthYear");
//		click(MonthYear);
//		return this;
//	}
	
	public SalaryProcessing selectMonthYear() {
		System.out.println("Select MonthYear");
		click(MonthYear);
		while (!getText(monthMY).contains("July 2022"))
		{
			click(prevmonthMY);
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
	
	public SalaryProcessing ddlStaff() {
		System.out.println("Enter ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByVisibleText("TEACHING");
		return this;
	}
	
	
	public SalaryProcessing btnSalaryProcess() {
		System.out.println("Enter btnSalaryProcess");
		click(btnSalaryProcess);
		return this;
	}
}