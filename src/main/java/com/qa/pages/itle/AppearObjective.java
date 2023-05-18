package com.qa.pages.itle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class AppearObjective extends BaseClass{
	
	
	public AppearObjective(WebDriver rdriver)
	{
		
		driver= rdriver;
		PageFactory.initElements(driver, this);

	}
   
	@FindBy (id = "ddlSession") private WebElement session;
    @FindBy (id = "ddlSubject") private WebElement subject;
    @FindBy (xpath = "//*[@id=\"divTest\"]/div/a/span") private WebElement mytest;
    @FindBy (id = "btnStart") private WebElement starttest;
    @FindBy (id = "btnStartTest") private WebElement readytobegin;
    @FindBy (xpath = "/html/body") private WebElement clickok;
    @FindBy (id = "rbMoption3") private WebElement answerone;
    @FindBy (id = "btnSaveNext") private WebElement saveandnextbuttonclick;
    @FindBy (xpath = "//*[@id=\"btnMarkForReview\"]/span") private WebElement reviewandsubmitclick;
    @FindBy (xpath = "//*[@id=\"btnFinalSubmit\"]/span") private WebElement finalclick;
    @FindBy (id = "btnOK") private WebElement finalalertok;
    //@FindBy (id = "btnCloseWindow") private WebElement closewindow;
    
	
    public AppearObjective selectSession() {
		System.out.println("Select Session");
		Select ddl = new Select(session);
		ddl.selectByVisibleText("WINTER 2016");
		return this;
	}
    
	public AppearObjective selectSubject() {
		System.out.println("Select Subject");
		Select ddl = new Select(subject);
		ddl.selectByVisibleText("ENG - ENGLISH -I (TH) - 0.00");
		return this;
	}
	public AppearObjective openMyTest() {
		System.out.println("Open My Test");
		click(mytest);
		return this;
	}
	public AppearObjective openStartTest() {
		System.out.println("Start Test");
		click(starttest);
		return this;
	}
	public AppearObjective openReadyToBegin() {
		System.out.println("Ready to Begin");
		click(readytobegin);
		return this;
	} 
	public AppearObjective clickOnAnswerOne()
	{
		System.out.println("Click on 'Answer one'");
		click(answerone);
		System.out.println("Clicked......................'");
		return this;
	}
	public AppearObjective clickOnSaveAndNext() {
		System.out.println("Click on 'Start Test'");
		click(saveandnextbuttonclick);
		return this;
	}
	public AppearObjective clickOnReviewAndSubmit() {
		System.out.println("Click on 'Review And Submit'");
		click(reviewandsubmitclick);
		return this;
	}
	public AppearObjective clickOnFinal()
	{
		System.out.println("Click on 'Close'");
		click(finalclick);
		return this;
	}
	public AppearObjective clickOnFinalAlertOk()
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