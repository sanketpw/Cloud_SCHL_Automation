package com.qa.pages.payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class MonthlyWork extends BaseClass{
	
	public MonthlyWork(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (linkText = "Transactions") private WebElement transaction;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Monthly Work']/parent::*") private WebElement monthlywork;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Basic Details']/parent::*") private WebElement basicdetails;

	
	
	
	
	public MonthlyWork openTransaction() {
		System.out.println("Open Transaction");
		click(transaction);
		return this;
	}
	
	
	public MonthlyWork openBasicDetails() {
		System.out.println("Open Collect Fees");
		click(basicdetails);
		return this;
	}
	
	
	public MonthlyWork openMonthlyWork() {
		System.out.println("Open Student Admission");
		click(monthlywork);
		return this;
	}
	
	
	
	

	
	
	
	
	



}