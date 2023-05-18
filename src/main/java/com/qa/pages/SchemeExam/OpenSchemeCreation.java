package com.qa.pages.SchemeExam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class OpenSchemeCreation extends BaseClass {
	
	
	public OpenSchemeCreation(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "/html/body/div[3]/aside[1]/section/ul/li[3]/ul/li[1]/ul/li[1]/a/span") private WebElement OpenSchemeCreation;
	
	
	public OpenSchemeCreation OpenSchemeCreationPage() {
		System.out.println("Open OpenSchemeCreation page");
		click(OpenSchemeCreation);
		return this;
	}

}
