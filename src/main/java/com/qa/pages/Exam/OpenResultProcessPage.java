package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;



public class OpenResultProcessPage extends BaseClass {
	
	public OpenResultProcessPage(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Result Processing'])[1]/following::span[1]") private WebElement ResulProcessPage;
	
	
	public OpenResultProcessPage OpenResultProcessActualPage() throws Exception {
		System.out.println("ResulProcessPage");	
		click(ResulProcessPage);
		
		return this;
	}
	
		
}
