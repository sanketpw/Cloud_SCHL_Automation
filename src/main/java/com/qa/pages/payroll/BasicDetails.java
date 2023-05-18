package com.qa.pages.payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class BasicDetails extends BaseClass{
	
	public BasicDetails(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Employee Information']/parent::*") private WebElement empInfo;

	
	
	
	
	public BasicDetails openEmployeeInformation() {
		System.out.println("Open Employee Information");
		click(empInfo);
		return this;
	}
	
	

	
	

	
	
	
	
	



}