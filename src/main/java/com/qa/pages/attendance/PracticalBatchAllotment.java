package com.qa.pages.attendance;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class PracticalBatchAllotment extends BaseClass
{

	public PracticalBatchAllotment(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Bulk Parent Subject Creation'])[1]/following::span[1]") private WebElement clickpracticalbatchalottment  ;

	public PracticalBatchAllotment OpenPracticalBatchAllottment()
	{
		System.out.println("open Practical batch allottment ");
		click(clickpracticalbatchalottment);
		return this;
	}// OpenPracticalBatchAllottment end
	


}// AttendancePracticalBatchAllotmentPages class end