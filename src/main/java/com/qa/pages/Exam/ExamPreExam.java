package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class ExamPreExam extends BaseClass{
	
	public ExamPreExam(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Pre Exam']/parent::*") private WebElement PreExamSubmodule;
	
	public ExamPreExam open_PreExamSubmodule() {
		System.out.println("Open PreExamSubmodule");
		click(PreExamSubmodule);
		return this;
	}

}
