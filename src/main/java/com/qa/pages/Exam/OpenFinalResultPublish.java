package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class OpenFinalResultPublish extends BaseClass {
	
	public OpenFinalResultPublish(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Result Publish']/parent::*") private WebElement ResultPublish;
	
	
	public OpenFinalResultPublish ResultPublish() {
		System.out.println("Open ResultPublish page");
		click(ResultPublish);
		return this;
	}
	
	
}
