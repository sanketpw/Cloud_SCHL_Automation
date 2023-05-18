package com.qa.pages.SchemeExam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class OpenSchemeSubjectAllotment extends BaseClass{
	
	public OpenSchemeSubjectAllotment(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "/html/body/div[3]/aside[1]/section/ul/li[3]/ul/li[3]/ul/li[3]/a/span") private WebElement SchemeSubjectAllotment;
	
	
	public OpenSchemeSubjectAllotment OpenSchemeSubjectAllotmentPage() {
		System.out.println("Open SchemeCourseAllotment page");
		click(SchemeSubjectAllotment);
		return this;
	}

}
