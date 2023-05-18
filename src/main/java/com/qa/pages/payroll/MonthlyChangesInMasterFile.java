package com.qa.pages.payroll;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class MonthlyChangesInMasterFile extends BaseClass{
	
	public MonthlyChangesInMasterFile(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "ddlPayHead") private WebElement ddlPayHead;
	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	@FindBy (id = "ddlDepartment") private WebElement ddlDepartment;
	@FindBy (id = "ddlEmployeeType") private WebElement ddlEmployee;
	@FindBy (id = "ddlOrderBy") private WebElement ddlOrderBy;
	@FindBy (id = "btnShowSpan") private WebElement btnShow;
	@FindBy (xpath = "//tbody[@id='tbodyMonthlyChange']/tr/td[6]/input") private WebElement Amount;
	@FindBy (xpath = "//input[@id='txtAmount']") private List<WebElement> emplist;
	@FindBy (id = "btnAddSpan") private WebElement btnSave;

	public MonthlyChangesInMasterFile ddlPayHead() {
		System.out.println("Enter ddlPayHead");
		Select ddl = new Select(ddlPayHead);
		ddl.selectByVisibleText("BONUS");
		return this;
	}
	
	public MonthlyChangesInMasterFile ddlStaff() {
		System.out.println("Enter ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByVisibleText("TEACHING");
		return this;
	}
	
	public MonthlyChangesInMasterFile selectDepartment() {
		System.out.println("Enter ddlDepartment");
		Select ddl = new Select(ddlDepartment);
		ddl.selectByVisibleText("ELECTRICAL");
		return this;
	}
	
	public MonthlyChangesInMasterFile ddlEmployee() {
		System.out.println("Enter ddlEmployee");
		Select ddl = new Select(ddlEmployee);
		ddl.selectByVisibleText("FACULTY");
		return this;
	}
	
	public MonthlyChangesInMasterFile ddlOrderBy() {
		System.out.println("Enter ddlOrderBy");
		Select ddl = new Select(ddlOrderBy);
		ddl.selectByVisibleText("IDNO");
		return this;
	}
	
	public MonthlyChangesInMasterFile btnShow() {
		System.out.println("Click on btnShow");
		click(btnShow);
		return this;
	}
	public MonthlyChangesInMasterFile Amount() {
		System.out.println("Enter Amount");
		scrollToElement(Amount);
		Amount.clear();
		sendKeys(Amount,"3");
		return this;
	}
	
	
//	public MonthlyChangesInMasterFile enterAmount(String empname) {
//		String EmpName= empname;
//		for (int i=0; i < emplist.size(); i++) {
//			if (emplist.get(i).getText().equalsIgnoreCase(EmpName)){
//			scrollToElement(emplist.get(i));
//			emplist.get(i).clear();
//			emplist.get(i).sendKeys("25");
//			break;
//			}
//		}
//		System.out.println("Enter Amt for" + EmpName);
//		return this;
//		}
	
	
	public MonthlyChangesInMasterFile btnSave() {
		System.out.println("Enter btnSave");
		click(btnSave);
		return this;
	}
}