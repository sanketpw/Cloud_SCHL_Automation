package com.qa.pages.SchemeExam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class HomePageSchemeExam extends BaseClass{
	
	public HomePageSchemeExam(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (linkText = "SCHEME EXAM") private WebElement SchemeExam;
	
	public HomePageSchemeExam open_SchemeExamination() {		
		click(SchemeExam);
		System.out.println("Open SchemeExamModule");
		return this;
	}	

}
