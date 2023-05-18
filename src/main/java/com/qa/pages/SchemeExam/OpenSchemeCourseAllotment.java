package com.qa.pages.SchemeExam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class OpenSchemeCourseAllotment extends BaseClass{
	
	public OpenSchemeCourseAllotment(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "/html/body/div[3]/aside[1]/section/ul/li[3]/ul/li[1]/ul/li[5]/a/span") private WebElement SchemeCourseAllotment;
	
	
	public OpenSchemeCourseAllotment OpenSchemeCourseAllotmentPage() {
		System.out.println("Open SchemeCourseAllotment page");
		click(SchemeCourseAllotment);
		return this;
	}

}
