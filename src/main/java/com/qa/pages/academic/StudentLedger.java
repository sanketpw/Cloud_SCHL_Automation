package com.qa.pages.academic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class StudentLedger extends BaseClass{
	
	public StudentLedger(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "ddlSession") private WebElement session;
	@FindBy (id = "ddlSearchBy") private WebElement searchby;
	
	@FindBy (id = "userInput") private WebElement enterinput;
	@FindBy (id = "ui-id-2") private WebElement inputoption;
	

	@FindBy (xpath = "//button[@id='btnReport']/span") private WebElement reportbutton;

	
	
	
	public StudentLedger selectSession() {
		System.out.println("Select Session");
		Select ddl = new Select(session);
		ddl.selectByVisibleText("2021-2022");
		return this;
	}
	
	public StudentLedger selectSearchBy() {
		System.out.println("Select Search By");
		Select ddl = new Select(searchby);
		ddl.selectByVisibleText("Student Name");
		return this;
	}

	public StudentLedger enterInput() {
		System.out.println("Enter Input");
		sendKeys(enterinput, "ARBAT  ASHISH");
		//sendKeys(enterinput, "___");
		click(inputoption);;
		return this;
	}
	
	public StudentLedger clickOnReportButton() {
		System.out.println("Click On Report Button");
		scrollIntoView(reportbutton, 0, 3000);
		click(reportbutton);
		return this;
	}
	
}

