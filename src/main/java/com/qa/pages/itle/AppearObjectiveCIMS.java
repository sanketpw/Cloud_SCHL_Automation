package com.qa.pages.itle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class AppearObjectiveCIMS extends BaseClass{
	
	
	public AppearObjectiveCIMS(WebDriver rdriver)
	{
		
		driver= rdriver;
		PageFactory.initElements(driver, this);

	}
   
	@FindBy (id = "Itle_Student_Layout") private WebElement openitle;
	@FindBy (xpath = "//*[@id=\"toggleDemo3\"]/ul/li[8]/a/span") private WebElement selectmytest;
	@FindBy (xpath = "/html/body/div[3]/aside[2]/section/div/div/div/div[2]/div[1]/div[2]/div/div/div[6]/a/span") private WebElement openmytest;

	 
	
	
	
//	@FindBy (id = "ddlSession") private WebElement session;
	@FindBy (linkText = "BSC SEM 1 - 1 - ENGLISH - ENGLISH (BS) - 0.00") private WebElement Englishsubject;
    @FindBy (xpath = "//*[@id=\"divTest\"]/div/a/span") private WebElement mytest;
    @FindBy (id = "btnStart") private WebElement starttest;
    @FindBy (id = "btnStartTest") private WebElement readytobegin;
    @FindBy (xpath = "/html/body") private WebElement clickok;
    @FindBy (id = "rbMoption1") private WebElement answerone;
    @FindBy (id = "btnSaveNext") private WebElement saveandnextbuttonclick;
    @FindBy (xpath = "//*[@id=\"btnMarkForReview\"]/span") private WebElement reviewandsubmitclick;
    @FindBy (xpath = "//*[@id=\"btnFinalSubmit\"]/span") private WebElement finalclick;
    @FindBy (id = "btnOK") private WebElement finalalertok;
    //@FindBy (id = "btnCloseWindow") private WebElement closewindow;
    
    public AppearObjectiveCIMS openITLE() {
		System.out.println("Select ITLE");
		click(openitle);
		return this;
	}
    public AppearObjectiveCIMS selectMyTest() {
		System.out.println("Select ITLE");
		click(selectmytest);
		return this;
	}
	public AppearObjectiveCIMS selectSubject() {
		System.out.println("BSC SEM 1 - 1 - ENGLISH - ENGLISH (BS) - 0.00");
		click(Englishsubject);
		return this;
	}
	public AppearObjectiveCIMS openMyTest() {
		System.out.println("Open My Test");
		click(openmytest);
		return this;
	}
	public AppearObjectiveCIMS openStartTest() {
		System.out.println("Start Test");
		click(starttest);
		return this;
	}
	public AppearObjectiveCIMS openReadyToBegin() {
		System.out.println("Ready to Begin");
		click(readytobegin);
		return this;
	} 
	public AppearObjectiveCIMS clickOnAnswerOne()
	{
		System.out.println("Click on 'Answer one'");
		click(answerone);
		System.out.println("Clicked......................'");
		return this;
	}
	public AppearObjectiveCIMS clickOnSaveAndNext() {
		System.out.println("Click on 'Start Test'");
		click(saveandnextbuttonclick);
		return this;
	}
	public AppearObjectiveCIMS clickOnReviewAndSubmit() {
		System.out.println("Click on 'Review And Submit'");
		click(reviewandsubmitclick);
		return this;
	}
	public AppearObjectiveCIMS clickOnFinal()
	{
		System.out.println("Click on 'Close'");
		click(finalclick);
		return this;
	}
	public AppearObjectiveCIMS clickOnFinalAlertOk()
	{
		System.out.println("Click on 'Final'");
		click(finalalertok);
		return this;
	}
//	public ITLE_Student clickCloseWindow()
//	{
//		System.out.println("Click on 'Final'");
//		click(closewindow);
//		return this;
//	}
}