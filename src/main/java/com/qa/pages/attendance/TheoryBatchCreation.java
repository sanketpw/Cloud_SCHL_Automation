package com.qa.pages.attendance;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class TheoryBatchCreation extends BaseClass
{

	public TheoryBatchCreation(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Batch'])[1]/following::span[1]") private WebElement theorybatch ;
	@FindBy (id = "txtShortName") private WebElement theorybatchshortname ;
	@FindBy (id = "txtBatchName") private WebElement createtheorybatchname ;

	
	
	public TheoryBatchCreation OpenTheoryBatch()
	{
		System.out.println("Open Theory Batch");
		click(theorybatch);
		return this;
	}// OpenTheoryBatch  end
	
	public TheoryBatchCreation EnterTheoryBatchShortName()
	{
		System.out.println("Enter Theory batch  short name is=BSC TH BATCH");
		sendKeys(theorybatchshortname,"BSC TH BATCH");
		return this;
	}// EnterTheoryBatchShortName end

	public TheoryBatchCreation EnterTheoryBatchName()
	{
		System.out.println("Enter Theory batch name=BSC TH BATCH");
		sendKeys(createtheorybatchname,"BSC TH BATCH");
		return this;
	}// EnterTheoryBatchName end





}// AttendanceTheoryBatchCreationPages class end