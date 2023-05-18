package com.qa.pages.establishment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class Establishment extends BaseClass{
	
	public Establishment(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Leave Transaction'])[1]/preceding::a[1]") private WebElement transaction;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Leave Transaction']/parent::*") private WebElement LeaveTransaction;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Leave Details']/parent::*") private WebElement LeaveDetails;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Leave Allotment']/parent::*") private WebElement LeaveAllotment;
	@FindBy (linkText = "Report") private WebElement Report;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Reports']/parent::*") private WebElement Reports;

	@FindBy (xpath = "//*/text()[normalize-space(.)='Leave Reports']/parent::*") private WebElement LeaveReports;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Leave Allotment Report']/parent::*") private WebElement LeaveAllotmentReport;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Other Reports']/parent::*") private WebElement OtherReports;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Leave Summary Report']/parent::*") private WebElement LeaveSummaryReport;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Leave Status Report']/parent::*") private WebElement LeaveStatusReport;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Leave Detail Report']/parent::*") private WebElement LeaveDetailReport;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Application']/parent::*") private WebElement Application;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Leave Application']/parent::*") private WebElement LeaveApplication;
	
	public Establishment openTransaction() {
		System.out.println("Open Transaction");
		click(transaction);
		return this;
	}
	
	
	public Establishment openLeaveTransaction() {
		System.out.println("Open LeaveTransaction");
		click(LeaveTransaction);
		return this;
	}
	

	public Establishment openLeaveDetails() {
		System.out.println("Open LeaveDetails");
		click(LeaveDetails);
		return this;
		}
	

	public Establishment openLeaveAllotment() {
		System.out.println("Open LeaveAllotment");
		click(LeaveAllotment);
		return this;
	}
	
	
	public Establishment openLeaveAllotmentReport() {
		System.out.println("open LeaveAllotmentReport");
		click(LeaveAllotmentReport);
		return this;
	}
	
	public Establishment openReport() {
		System.out.println("open Report");
		click(Report);
		return this;
	}
	
	public Establishment openReports() {
		System.out.println("open Reports");
		click(Reports);
		return this;
	}
	
	public Establishment openLeaveReports() {
		click(LeaveReports);
		System.out.println("open Leave Reports");
		return this;
	}
	
	public Establishment openLeaveStatusReport() {
		System.out.println("Open LeaveStatusReport");
		click(LeaveStatusReport);
		return this;
	}
	
	public Establishment openLeaveDetailReport() {
		System.out.println("open LeaveDetailReport");
		click(LeaveDetailReport);
		return this;
	}
	
	public Establishment openOtherReports() {
		System.out.println("open OtherReports");
		click(OtherReports);
		return this;
	}
	
	public Establishment openLeaveSummaryReport() {
		System.out.println("open LeaveSummaryReport");
		click(LeaveSummaryReport);
		return this;
	}
	
	public Establishment openApplication() {
		System.out.println("Open Application");
		click(Application);
		return this;
	}
	
	public Establishment openLeaveApplication() {
		System.out.println("Open openLeaveApplication");
		click(LeaveApplication);
		return this;
	}
}