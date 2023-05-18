package com.qa.pages.establishment;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class LeaveSummaryReport extends BaseClass{
	
	public LeaveSummaryReport(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "ddlStaffType") private WebElement ddlStaffType;
	@FindBy (id = "ddlDepartment") private WebElement ddlDepartment;
	@FindBy (id = "ddlEmployee") private WebElement ddlEmployee;
	
	@FindBy (id = "txtFromDate") private WebElement FromDate;
	@FindBy (xpath = "//div[@class='datetimepicker-days']//th[@class='switch']") private WebElement monthMY;
	@FindBy (xpath = "//div[@class='datetimepicker-days']//th[@class='prev']") private WebElement prevmonthMY;
	@FindBy (xpath = "//td[@class='day']") private List<WebElement> day;

	@FindBy (id = "/html/body/div[9]/div[3]/table/tbody/tr[1]/td[6]") private WebElement Fromdate1;
	@FindBy (xpath = "//td[@class='day today active']") private WebElement activeday;

	
	@FindBy (id = "txtToDate") private WebElement ToDate;
	
	@FindBy (id = "btnReport") private WebElement btnReport;

	
	public LeaveSummaryReport ddlStaffType() {
		System.out.println("Enter ddlStaffType");
		Select ddl = new Select(ddlStaffType);
		ddl.selectByVisibleText("PERMANENT");
		return this;
	}
	
	
	public LeaveSummaryReport ddlDepartment() {
		System.out.println("Click ddlDepartment");
		Select ddl = new Select(ddlDepartment);
		ddl.selectByVisibleText("ELECTRICAL");
		return this;
	}
		
	public LeaveSummaryReport ddlEmployee() {
		System.out.println("Select ddlEmployee");
		Select ddl = new Select(ddlEmployee);
		ddl.selectByValue("36224");
		return this;
	}
	
	public LeaveSummaryReport FromDate() {
		System.out.println("Click on FromDate");
		click(FromDate);
		while (!getText(monthMY).contains("January 2022"))
		{
			click(prevmonthMY);
		}
		int count = day.size();
		
		for (int i = 0; i < count; i++) {
			String text = day.get(i).getText();
			if (text.equalsIgnoreCase("1"))
			{
				day.get(i).click();
				break;
			}
		}
		return this;
		
	}
	
	public LeaveSummaryReport ToDate() {
		System.out.println("Click ToDate");
		click(ToDate);
		click(activeday);
		return this;
		
	}
	
	
	public LeaveSummaryReport btnReport() {
		System.out.println("Click btnReport");
		click(btnReport);
		return this;
	}
}