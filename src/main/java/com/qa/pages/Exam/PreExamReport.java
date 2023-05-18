package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;



public class PreExamReport extends BaseClass{
	
	public PreExamReport(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Post Exam Report']/parent::*") private WebElement PreExamReport;
	
	public PreExamReport ClickPreExamReport() {
		System.out.println("Open PreExamReport");
		click(PreExamReport);
		return this;
	}

}
