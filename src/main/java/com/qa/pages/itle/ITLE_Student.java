package com.qa.pages.itle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class ITLE_Student extends BaseClass{
	
	
	public ITLE_Student(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(driver, this);

	}

   
    @FindBy (xpath = "//*/text()[normalize-space(.)='Select Course']/parent::*") private WebElement selectcourse;
	
	
	
	
	
	
	
	public ITLE_Student openSelectCourse() {
		System.out.println("Open My Test");
		click(selectcourse);
		return this;
	}
	
	
	
   
}