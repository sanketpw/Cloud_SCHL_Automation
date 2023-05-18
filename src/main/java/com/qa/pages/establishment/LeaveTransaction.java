package com.qa.pages.establishment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class LeaveTransaction extends BaseClass{
	
	public LeaveTransaction(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy (xpath = "//*[@id=\"list-to-filter\"]/ul/li[1]/a/span") private WebElement leaveTransaction;

	
	
	
	
	public LeaveTransaction openLeaveTransaction() {
		System.out.println("Open leaveTransaction");
		click(leaveTransaction);
		return this;
	}
	
	

	
	

	
	
	
	
	



}