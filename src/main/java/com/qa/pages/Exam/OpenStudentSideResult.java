package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class OpenStudentSideResult extends BaseClass{
	
	public OpenStudentSideResult(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Result Publish']/parent::*") private WebElement OpenResultPublish;
	
	public OpenStudentSideResult ClickResultPublishPage() {
		System.out.println("Open ResultPublish page");
		click(OpenResultPublish);
		return this;
	}
	

}
