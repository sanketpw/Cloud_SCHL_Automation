package com.qa.pages.academic;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;
import com.qa.pages.attendance.SessionCreation;

public class DcrReport extends BaseClass{
	
	public DcrReport(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Detailed']/parent::*") private WebElement DETAILED;
	@FindBy (id = "ddlSession") private WebElement ddlSession;
	@FindBy (id = "ddlReceiptType") private WebElement ddlReceiptType;
	@FindBy (id = "ddlCashBookType") private WebElement ddlCashBookType;
	@FindBy (id = "txtDateFrom") private WebElement DateFrom;
	@FindBy (id = "txtDateTo") private WebElement DateTo;
	@FindBy (id = "ddlReportType") private WebElement reporttype;

	@FindBy (id = "btnReport") private WebElement btnReport;
	@FindBy (xpath = "//*/text()[normalize-space(.)='You Are At : Academic-> Fees Reports-> Fees Report-> Daily Collection Register']/parent::*") private WebElement Outclick;
	
	@FindBy (id = "txtDateFrom") private WebElement datefrom ;
	@FindBy (xpath = "(//th[@class='switch'])[3]") private WebElement calmonth ;
	@FindBy (xpath = "(//th[@class='prev'])[3]") private WebElement prevmonth ;
	@FindBy (className = "day") private List<WebElement> day;
	
	@FindBy (id = "txtDateTo") private WebElement dateto ;
	@FindBy (xpath = "(//th[@class='switch'])[8]") private WebElement calmonth1 ;
	@FindBy (xpath = "(//th[@class='prev'])[8]") private WebElement prevmonth1 ;
	//@FindBy (xpath = "//td[@class='day today']\r\n") private WebElement today;
	@FindBy (xpath = "/html/body/div[9]/div[3]/table/tfoot/tr[1]/th") private WebElement today;


	
	public DcrReport DETAILED() {
		System.out.println("Select Report Format");
		click(DETAILED);
		return this;
	}
	
	public DcrReport ddlSession() {
		System.out.println("Select SESSION");
		Select ddl = new Select(ddlSession);
		ddl.selectByVisibleText("2022-2023");
		return this;
	}
	
	public DcrReport ddlReceiptType() {
		System.out.println("Select ddlReceiptType");
		Select ddl = new Select(ddlReceiptType);
		ddl.selectByVisibleText("ADMISSION,NEXT INSTALLMENT,OTHER FEES");
		return this;
	}
	
	public DcrReport ddlCashBookType() {
		System.out.println("Select ddlCashBookType");
		Select ddl = new Select(ddlCashBookType);
		ddl.selectByVisibleText("ADMISSION FEE");
		return this;
	}
	
	
	public DcrReport DateFrom() {
		
			System.out.println("Select Date From");
			click(datefrom);
			while (!getText(calmonth).contains("May 2022")) 
			{
				click(prevmonth);
			}
			int count = day.size();

			for (int i = 0; i < count; i++) 
			{
				String text = day.get(i).getText();
				if (text.equalsIgnoreCase("10")) 
				{
					day.get(i).click();
					break;
				}
			}
			return this;
	}
	
	
	public DcrReport DateTo() {
		click(dateto);
		click(today);
//		while (!getText(calmonth1).contains("October 2022")) 
//		{
//			click(prevmonth1);
//		}
//		int count = day.size();
//
//		for (int i = 0; i < count; i++) 
//		{
//			String text = day.get(i).getText();
//			if (text.equalsIgnoreCase("24")) 
//			{
//				day.get(i).click();
//				break;
//			}
//		}
		System.out.println("Enter Date To");
		return this;
	}
	
	public DcrReport selectFormatType() {
		System.out.println("Select Format Type");
		Select ddl = new Select(reporttype);
		ddl.selectByVisibleText("50 Heads");
		return this;
	}
	
	public DcrReport btnReport() {
		System.out.println("Click on Report Button");
		click(btnReport);
		return this;
	}
}