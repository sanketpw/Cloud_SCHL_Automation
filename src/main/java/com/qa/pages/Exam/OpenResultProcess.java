package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;



public class OpenResultProcess extends BaseClass {
	
	public OpenResultProcess(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Result Process']/parent::*") private WebElement ResulProcess;
	
	public OpenResultProcess Open_ResultProcess() {
		System.out.println("Open ResulProcess");
		click(ResulProcess);
		return this;
	}


}
