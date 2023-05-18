package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;



public class OpenGradeCard extends BaseClass{
	
	public OpenGradeCard(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Grade Card']/parent::*") private WebElement OpenGradeCard;
	
	
	public OpenGradeCard ClickGradeCard() {
		System.out.println("Open GradeCard");
		click(OpenGradeCard);
		return this;
	}

}
