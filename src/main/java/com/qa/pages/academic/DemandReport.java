package com.qa.pages.academic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class DemandReport extends BaseClass{
	
	public DemandReport(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "ddlSession") private WebElement ddlSession;
	@FindBy (id = "ddlCourse") private WebElement ddlCourse;
	@FindBy (id = "ddlReportFormat") private WebElement ddlReportFormat;
	@FindBy (id = "btnReport") private WebElement btnReport;
	@FindBy (xpath = "//*[@id=\"btnId\"]/span") private WebElement DemandReport;
	
	public DemandReport ddlSession() {
		System.out.println("Select ddlSession");
		Select ddl = new Select(ddlSession);
		ddl.selectByVisibleText("2022-2023");
		return this;
	}
	
	public DemandReport ddlCourse() {
		System.out.println("Select ddlCourse");
		Select ddl = new Select(ddlCourse);
		ddl.selectByVisibleText("STANDARD-5");
		return this;
	}
	
	public DemandReport ddlReportFormat() {
		System.out.println("Select ddlReportFormat");
		Select ddl = new Select(ddlReportFormat);
		ddl.selectByVisibleText("Demand With Fees Details");
		return this;
	}
	
	public DemandReport btnReport() {
		System.out.println("Click on btnReport");
		click(btnReport);
		return this;
	}
	
}