package com.qa.pages.SchemeExam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class ExaminationSetup extends BaseClass {

	public ExaminationSetup(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "/html/body/div[3]/aside[1]/section/ul/li[3]/a/span[1]") private WebElement ExaminationSetup;
	
	
	public ExaminationSetup ExaminationSetupPage() {
		System.out.println("Open OpenSchemeCreation page");
		click(ExaminationSetup);
		return this;
	}
	
}
