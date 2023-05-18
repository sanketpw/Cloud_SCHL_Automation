package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;
import com.qa.pages.academic.Academic;

public class HomePageAdmin extends BaseClass {

	public HomePageAdmin(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "ACADEMIC")private WebElement academic;
	@FindBy(xpath = "/html/body/div[4]/aside[1]/section/ul/li[5]/a/span[1]")private WebElement ADMISSION;
	@FindBy (xpath = "/html/body/div[4]/aside[1]/section/ul/li[6]/a/span[1]") private WebElement FeesCollectionHome;
	@FindBy(linkText = "ATTENDANCE")private WebElement attendance;
	@FindBy(linkText = "ITLE")private WebElement itle;
	@FindBy (linkText = "BSC SEM 2 - ENG - ENGLISH -I (TH) - 0.00") private WebElement Englishsubject;
	@FindBy(linkText = "PAYROLL")private WebElement payroll;
	@FindBy(linkText = "ESTABLISHMENT")private WebElement Establishment;

	
	public HomePageAdmin openAcademic() {
		System.out.println("Open Academic");
		click(academic);
		return this;
	}

	public HomePageAdmin openADMISSION() {
		System.out.println("Open ADMISSION");
		click(ADMISSION);
		return this;
	}
	
	public HomePageAdmin openFeesCollectionHome() {
		System.out.println("Open Fees Collection");
		click(FeesCollectionHome);
		return this;
	}
	
	public HomePageAdmin openAttendance() {
		System.out.println("Open attendance");
		click(attendance);
		return this;
	}

	public HomePageAdmin openItle() {
		System.out.println("Open ITLE");
		click(itle);
		return this;
	}
	public HomePageAdmin openEnglishSubject() //it will click on English/Subject  first
	{
		System.out.println("Open English/Subject");
		click(Englishsubject);
		return this;
	}

	public HomePageAdmin openPayroll() {
		System.out.println("Open Payroll");
		click(payroll);
		return this;
	}
	
	public HomePageAdmin openEstablishment() {
		System.out.println("open Establishment");
		click(Establishment);
		return this;
	}
		

	}

