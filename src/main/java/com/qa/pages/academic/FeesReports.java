package com.qa.pages.academic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class FeesReports extends BaseClass{
	
	public FeesReports(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath = "/html/body/div[4]/aside[1]/section/ul/ul/li[4]/ul/li/a/span")private WebElement feesreport;
	@FindBy(xpath = "/html/body/div[4]/aside[1]/section/ul/ul/li[4]/ul/li/ul/li[10]/a/span")private WebElement outstandingfeesreport;
	@FindBy(xpath = "//*/text()[normalize-space(.)='All Cashbook Report']/parent::*")private WebElement allcashbookreport;
	@FindBy(xpath = "//*/text()[normalize-space(.)='Student Ledger']/parent::*")private WebElement studentledger;

	
	@FindBy (id = "txtStudent") private WebElement enterstudentname;
	@FindBy (css = "div.eac-item") private WebElement studentname;


	
	public FeesReports expandFeesReport() {
		System.out.println("Click On Fees Report");
		click(feesreport);
		return this;
	}
	
	public FeesReports openDemandReport() {
		System.out.println("Enter student name");
		sendKeys(enterstudentname,"KAWALE TUSHAR A");
		click(studentname);
		return this;
	}
	
	public FeesReports openDCRReport() {
		System.out.println("Click on Search Criteria");
		click(studentname);
		return this;
	}
	
	public FeesReports openDailyDCR() {
		System.out.println("Enter student name");
		sendKeys(enterstudentname,"KAWALE TUSHAR A");
		click(studentname);
		return this;
	}
	
	public FeesReports openOutstandingFeesReport() {
		System.out.println("Click on Outstanding Fees Report");
		click(outstandingfeesreport);
		return this;
	}
	
	public FeesReports openStudentsLedger() {
		System.out.println("open on Student Ledger");
		click(studentledger);
		return this;
	}
	
	public FeesReports openAllCashBook() {
		System.out.println("Click on All Cash Book Report");
		click(allcashbookreport);
		return this;
	}
	

	
}