package com.qa.pages.syty_registeration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class SYTY extends BaseClass{
	
	public SYTY(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (linkText = "Transaction") private WebElement transaction;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Registration Call Letter'])[1]/following::span[1]") private WebElement collectFees;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Collect Fees'])[1]/following::span[1]") private WebElement studentAdmission;

	
	
	
	
	public SYTY openTransaction() {
		System.out.println("Open Transaction");
		click(transaction);
		return this;
	}
	
	
	public SYTY collect_fees() {
		System.out.println("Open Collect Fees");
		click(collectFees);
		return this;
	}
	
	
	public SYTY student_admission() {
		System.out.println("Open Student Admission");
		click(studentAdmission);
		return this;
	}
	
	

	
	
	
	
	



}