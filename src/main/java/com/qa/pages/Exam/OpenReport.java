package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;



public class OpenReport extends BaseClass {
	
	public OpenReport(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Report']/parent::*") private WebElement OpenReports;
	
	public OpenReport OpenReports() {
		System.out.println("Open Reports");
		click(OpenReports);
		return this;
	}

}
