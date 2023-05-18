package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;



public class OpenMarkEntry extends BaseClass {

	public OpenMarkEntry(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Exam Mark Entry']/parent::*") private WebElement OpenMarkEntryPage;
	
	public OpenMarkEntry OpenMarkEntryPage() {
		System.out.println("OpenMarkEntryPage");
		click(OpenMarkEntryPage);
		return this;
	}
	
}
