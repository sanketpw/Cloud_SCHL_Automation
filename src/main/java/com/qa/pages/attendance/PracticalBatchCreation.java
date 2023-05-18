package com.qa.pages.attendance;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class PracticalBatchCreation extends BaseClass
{

	public PracticalBatchCreation(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Batch'])[1]/following::span[1]") private WebElement theorybatch ;
	@FindBy (id = "txtShortName") private WebElement practicalbatchshortname ;
	@FindBy (id = "txtBatchName") private WebElement createpracticalbatchname ;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Theory Batch Creation'])[1]/following::span[1]") private WebElement practicalbatch ;

	
	
	public PracticalBatchCreation OpenTheoryBatch()
	{
		System.out.println("Open Theory Batch");
		click(theorybatch);
		return this;
	}// OpenTheoryBatch  end
	
	public PracticalBatchCreation EnterPracticalBatchShortName()
	{
		System.out.println("Enter Theory batch  short name is=");
		sendKeys(practicalbatchshortname,"BSC PR BATCH");
		return this;
	}// EnterTheoryBatchShortName end

	public PracticalBatchCreation EnterPracticalBatchName()
	{
		System.out.println("Enter Theory batch name=");
		sendKeys(createpracticalbatchname,"BSC PR BATCH");
		return this;
	}// EnterTheoryBatchName end

	public PracticalBatchCreation OpenPracticalBatch()
	{
		System.out.println("Open Practical Batch");
		click(practicalbatch);
		return this;
	}// OpenPracticalBatch  end




}// AttendanceTheoryBatchCreationPages class end