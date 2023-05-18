package com.qa.pages.payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class Payroll extends BaseClass{
	
	public Payroll(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy (xpath = "//*/text()[normalize-space(.)='Transactions']/parent::*") private WebElement transaction;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Monthly Work']/parent::*") private WebElement monthlywork;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Basic Details']/parent::*") private WebElement basicdetails;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Monthly Work'])[1]/following::span[1]") private WebElement attendanceEntry;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Attendance Entry'])[1]/following::span[1]") private WebElement monthlyChangesInMasterFile;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Salary Process']/parent::*") private WebElement SalaryProcess;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Lock/Unlock Salary']/parent::*") private WebElement LockUnlockSalary;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Report']/parent::*") private WebElement Report;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Reports']/parent::*") private WebElement Reports;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Employee Pay Slip']/parent::*") private WebElement EmployeePaySlip;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Employee Pay Slip'])[1]/following::span[1]") private WebElement AnnualPaySlip;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Employee ID Card']/parent::*") private WebElement EmployeeIDCard;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Abstract Salary New Report']/parent::*") private WebElement AbstractSalaryNewReport;
	
	public Payroll openTransaction() {
		System.out.println("Open Transaction");
		click(transaction);
		return this;
	}
	
	
	public Payroll openBasicDetails() {
		System.out.println("Open Basic Details");
		click(basicdetails);
		return this;
	}
	

	public Payroll openMonthlyWork() {
		System.out.println("Open Monthly Work");
		click(monthlywork);
		return this;
		}
	

	public Payroll openattendanceEntry() {
		System.out.println("Open attendanceEntry");
		click(attendanceEntry);
		return this;
	}
	
	public Payroll openmonthlyChangesInMasterFile() {
		System.out.println("open monthlyChangesInMasterFile");
		click(monthlyChangesInMasterFile);
		return this;
	}
	
	public Payroll openSalaryProcess() {
		System.out.println("open SalaryProcess");
		click(SalaryProcess);
		return this;
	}
	
	public Payroll openLockUnlockSalary() {
		System.out.println("open LockUnlockSalary");
		click(LockUnlockSalary);
		return this;
	}
	
	public Payroll openReport() {
		System.out.println("open Report");
		click(Report);
		return this;
	}
	
	public Payroll openReports() {
		System.out.println("open Reports");
		click(Reports);
		return this;
	}
	
	public Payroll openEmployeePaySlip() {
		System.out.println("Open EmployeePaySlip");
		click(EmployeePaySlip);
		return this;
	}
	
	public Payroll openAnnualPaySlip() {
		System.out.println("open AnnualPaySlip");
		click(AnnualPaySlip);
		return this;
	}
	
	public Payroll openEmployeeIDCard() {
		System.out.println("open EmployeeIDCard");
		click(EmployeeIDCard);
		return this;
	}
	
	public Payroll openAbstractSalaryNewReport() {
		System.out.println("open AbstractSalaryNewReport");
		click(AbstractSalaryNewReport);
		return this;
	}
}