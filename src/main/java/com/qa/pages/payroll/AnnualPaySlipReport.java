package com.qa.pages.payroll;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class AnnualPaySlipReport extends BaseClass{
	
	public AnnualPaySlipReport(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "txtFromDate") private WebElement FromDate;
	@FindBy (xpath = "(//th[@class='switch'])[3]") private WebElement calmonth ;
	@FindBy (xpath = "(//th[@class='prev'])[3]") private WebElement prevmonth ;
	@FindBy (className = "day") private List<WebElement> day;
	@FindBy (xpath = "/html/body/div[10]/div[3]/table/tbody/tr[1]/td[6]") private WebElement day1;
	
	@FindBy (id = "txtToDate") private WebElement ToDate;
	@FindBy (xpath = "(//th[@class='switch'][normalize-space()='November 2022'])[2]") private WebElement calmonth1 ;
	@FindBy (xpath = "(//th[@class='prev'])[8]]") private WebElement prevmonth1 ;
	@FindBy (xpath = "(//td[contains(text(),'14')])[2]") private WebElement activedate;
	
	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	@FindBy (id = "ddlEmployee") private WebElement ddlEmployee;
	@FindBy (id = "ddlEmployeeName") private WebElement ddlEmployeeName;
	@FindBy (id = "btnShow") private WebElement btnShow;

	public AnnualPaySlipReport FromDate() {
		System.out.println("Select From Date");
		click(FromDate);
		while (!getText(calmonth).contains("January 2022")) 
		{
			click(prevmonth);
		}
		int count = day.size();

		for (int i = 0; i < count; i++) 
		{
			String text = day.get(i).getText();
			if (text.equalsIgnoreCase("1")) 
			{
				day.get(i).click();
				break;
			}
		}
		return this;
}

	
	public AnnualPaySlipReport ToDate() {
		System.out.println("Select From Date");
		click(ToDate);
		click(activedate);
//		while (!getText(calmonth1).contains("August 2022")) 
//		{
//			click(prevmonth1);
//		}
//		int count = day.size();
//
//		for (int i = 0; i < count; i++) 
//		{
//			String text = day.get(i).getText();
//			if (text.equalsIgnoreCase("8")) 
//			{
//				day.get(i).click();
//				break;
//			}
//		}
		return this;
}
	
	public AnnualPaySlipReport ddlStaff() {
		System.out.println("Select ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByVisibleText("TEACHING");
		return this;
	}
	
	public AnnualPaySlipReport ddlEmployee() {
		System.out.println("Select ddlEmployee");
		Select ddl = new Select(ddlEmployee);
		ddl.selectByVisibleText("FACULTY");
		return this;
	}
	
	public AnnualPaySlipReport ddlEmployeeName() {
		System.out.println("Select ddlEmployeeName");
		Select ddl = new Select(ddlEmployeeName);
		ddl.selectByVisibleText("Pushpa Ramika Test6");
		return this;
	}
	
	public AnnualPaySlipReport btnShow() {
		System.out.println("Select btnShow");
		click(btnShow);
		return this;
	}
}