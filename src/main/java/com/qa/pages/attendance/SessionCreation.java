package com.qa.pages.attendance;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class SessionCreation extends BaseClass
{

	public SessionCreation(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Attendance Status'])[1]/preceding::span[2]") private WebElement attendancesession;
	@FindBy (id = "ddlAcademicSession") private WebElement selectacademicsession;
	@FindBy (id = "txtAttendanceSessionName") private WebElement attendancesessionfullname ;
	@FindBy (id = "txtShortName") private WebElement attendancesessionshortname ;
	@FindBy (id = "txtStartDate") private WebElement sessionstartdate ;
	@FindBy (id = "imgStartDate") private WebElement imgStartDate ;
	@FindBy (id = "txtEndDate") private WebElement sessionenddate ;
	@FindBy (id = "imgEndDate") private WebElement imgEndDate ;
	@FindBy (css = "td.day.today.active") private WebElement activedate;
	@FindBy (xpath = "(//th[@class='switch'])[8]") private WebElement calmonth ;
	@FindBy (xpath = "(//th[@class='next'])[8]") private WebElement nextmonth ;
	@FindBy (className = "day") private List<WebElement> day;







	public SessionCreation OpenAttendanceSession()
	{
		System.out.println("Open Attendance session");
		click(attendancesession);
		return this;
	}// OpenAttendanceSession end

	public SessionCreation SelectAcademicSession() 
	{
		System.out.println("Select Academic Session 'SESSION 2022-2023'");
		Select ddl = new Select(selectacademicsession);
		ddl.selectByVisibleText("SESSION 2022-2023");
		return this;
	}//selectAttendanceSession end

	public SessionCreation EnterAttendanceSessioFullName()
	{
		System.out.println("Enter attendance session full name");
		sendKeys(attendancesessionfullname,"ATTENDANCE SESSION");
		return this;
	}// EnterAttendanceSessioFullName end

	public SessionCreation EnterAttendanceSessioShortName()
	{
		System.out.println("Enter attendance session short name");
		sendKeys(attendancesessionshortname,"ATTENDANCE");
		return this;
	}// EnterAttendanceSessioShortName end

	public SessionCreation SelectSessionStartDate()// to select current date
	{
		System.out.println("Select Session Start Date");
		click(sessionstartdate);
		click(activedate);
		click(imgStartDate);
		return this;
	}// EnterSessionStartDate end

	public SessionCreation selectSessionEndDate(String month, String date)// to select passed date
	{
		System.out.println("Select Session End Date");
		click(sessionenddate);
		click(imgEndDate);

		while (!getText(calmonth).contains(month)) 
		{
			click(nextmonth);
		}
		int count = day.size();

		for (int i = 0; i < count; i++) 
		{
			String text = day.get(i).getText();
			if (text.equalsIgnoreCase(date)) 
			{
				day.get(i).click();
				break;
			}
		}
		return this;

	}// EnterAttendanceSessioShortName end




}// AttendanceSessionCreationPages class end