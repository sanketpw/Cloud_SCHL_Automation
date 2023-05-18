package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;



public class HomePageExam extends BaseClass{

	public HomePageExam(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (linkText = "EXAMINATION") private WebElement Examination;
	
	public HomePageExam open_Examination() {		
		click(Examination);
		System.out.println("Open Examination");
		return this;
	}	
	
}
