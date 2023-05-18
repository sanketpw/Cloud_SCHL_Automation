package com.qa.pages.attendance;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class TheoryBatchAllotment extends BaseClass
{

	public TheoryBatchAllotment(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Parent Subject Creation'])[1]/following::span[1]") private WebElement clicktheorybatchalottment  ;

	public TheoryBatchAllotment OpenTheoryBatchAllottment()
	{
		System.out.println("open theory batch allottment ");
		click(clicktheorybatchalottment);
		return this;
	}// OpenTheoryBatchAllottment end



}// AttendanceTheoryBatchAllotmentPages class end