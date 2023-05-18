package com.qa.pages.academic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class Academic extends BaseClass{
	
	public Academic(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (xpath = "//*[@id=\"menu-li\"]/a/span[1]") private WebElement Admissions;
	@FindBy (xpath = "//*[@id=\"menu-li\"]/ul/li[1]/a/span") private WebElement AdmitStudents;
	@FindBy (xpath = "//*[@id=\"btnId\"]/span") private WebElement Admission;
	@FindBy (xpath = "/html/body/div[4]/aside[1]/section/ul/ul/li[3]/a/span[1]") private WebElement transaction;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Collect Fees']/parent::*") private WebElement collectfees;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Fees Collection']/parent::*") private WebElement feescollection;
	@FindBy (linkText = "Fees Reports") private WebElement feesreports;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Outstanding Fees']/parent::*") private WebElement outstanding;
	@FindBy (xpath = "/html/body/div[4]/aside[1]/section/ul/ul/li[4]/ul/li/ul/li[19]/a/span") private WebElement DemandReport;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Fees Reports'])[1]/following::span[2]") private WebElement FeesReport;
	@FindBy (linkText = "DCR") private WebElement DcrReport;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Dcr Report'])[1]/following::span[1]") private WebElement DailyDcr;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Summary Fees Collection Report'])[1]/following::span[1]") private WebElement AllCashBookReport;
	
	public Academic openAdmissions() {
		System.out.println("Open Admissions");
		click(Admissions);
		return this;
	}
	
	public Academic openAdmitStudents() {
		System.out.println("open AdmitStudents");
		click(AdmitStudents);
		return this;
	}
	
	public Academic openAdmission() {
		System.out.println("Open Admission");
		click(Admission);
		return this;
	}
	
	public Academic openTransaction() {
		System.out.println("Open Transaction");
		click(transaction);
		return this;
	}
	
	public Academic openCollectFees() {
		System.out.println("Open Collect Fees");
		click(collectfees);
		return this;
	}
	
	public Academic openFeesCollection() {
		System.out.println("Open Fees Collection");
		click(feescollection);
		return this;
	}
	
	public Academic openOutstandingFees() {
		System.out.println("Open Outstanding Fees");
		click(outstanding);
		return this;
	}

	
	public Academic openFeesReports() {
		System.out.println("Open Fees Reports");
		click(feesreports);
		return this;
	}
	
	public Academic openDemandReport() {
		System.out.println("Open Demand Report");
		click(DemandReport);
		return this;
	}
	
	
	public Academic openFeesReport() {
		System.out.println("Open Fees Report");
		click(FeesReport);
		return this;
	}
	
	public Academic openDcrReport() {
		System.out.println("Open DcrReport");
		click(DcrReport);
		return this;
	}
	
	public Academic openDailyDcr() {
		System.out.println("open DailyDcr");
		click(DailyDcr);
		return this;
	}
	
	public Academic openAllCashBookReport() {
		System.out.println("open AllCashBookReport");
		click(AllCashBookReport);
		return this;
	}


}