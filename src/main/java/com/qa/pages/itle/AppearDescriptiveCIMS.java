package com.qa.pages.itle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class AppearDescriptiveCIMS extends BaseClass{
	
	public AppearDescriptiveCIMS(WebDriver rdriver) {
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
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
    @FindBy (xpath = "/html/body/p") private WebElement txtBoxAns1; 
    
    
  //  @FindBy (xpath = "/html/body/p") private WebElement answerone;
   // @FindBy (xpath = "/html/body/p") private WebElement answertwo;
    @FindBy (id = "btnSave") private WebElement saveandnextbuttonclick;
    @FindBy (xpath = "//*[@id=\"btnMarkForReview\"]/span") private WebElement reviewandsubmitclick;
    @FindBy (xpath = "//*[@id=\"btnSubmit\"]/span") private WebElement finishclick;
    @FindBy (id = "btnOK") private WebElement okclick;

    
   //   /html   /html/body/div[1]/aside/section/div[3]/div[1]/div/div/div[3]/div[2]
    
	//tr[@class='even']//input[@id='btnStart']
	//tbody[@id='tbody']/tr[2]/td[3]/input
	//tbody[@id='tbody']/tr[2]/td[3]/input
	// id=btnSubmitByAdminTerminate        id=btnMarkForReviewSave
	
	
    public AppearDescriptiveCIMS openITLE() {
		System.out.println("Select ITLE");
		click(openitle);
		return this;
	}
    public AppearDescriptiveCIMS selectMyTest() {
		System.out.println("Select ITLE");
		click(selectmytest);
		return this;
	}
	public AppearDescriptiveCIMS selectSubject() {
		System.out.println("BSC SEM 1 - 1 - ENGLISH - ENGLISH (BS) - 0.00");
		click(Englishsubject);
		return this;
	}
	public AppearDescriptiveCIMS openMyTest() {
		System.out.println("Open My Test");
		click(openmytest);
		return this;
	}
	public AppearDescriptiveCIMS openStartTest() {
		System.out.println("Start Test");
		click(starttest);
		return this;
	}
	public AppearDescriptiveCIMS openReadyToBegin() {
		System.out.println("Ready to Begin");
		click(readytobegin);
		return this;
	}
	public AppearDescriptiveCIMS clickOnTxtAnsOne() {
		System.out.println("answear one");
		scrollToElement(txtBoxAns1);
		sendKeys(txtBoxAns1,"Model–view–controller is a software architectural pattern");
		return this;
	}
		public AppearDescriptiveCIMS clickOnSaveAndNext() {
			System.out.println("Click on Save and Next");
			scrollIntoView(saveandnextbuttonclick, 0, 500);
			click(saveandnextbuttonclick);
			return this;
		}
		
		
		
		
		
		
		
//		public AppearDescriptiveCIMS clickOnAnswerTwo() {
//			System.out.println("write answear two: ");
//			click(answertwo);
//			sendKeys(answertwo, "second answear  ");
//			return this;
//		} 
		public AppearDescriptiveCIMS clickOnReviewAndSubmitButton() {
			System.out.println("Click on Final Submit");
			click(reviewandsubmitclick);
			return this;
		}
		public AppearDescriptiveCIMS clickOnFinishButton() {
			System.out.println("Click on Finish Button");
			click(finishclick);
			return this;
		}
		public AppearDescriptiveCIMS clickOnOkButton() {
			System.out.println("Click on Finish Button");
			click(okclick);
			return this;
		}

		
		
	

	
	/*public AppearDescriptive clickOnStartTest() {
		System.out.println("Click on 'Start Test'");
		click(startDescriptiveTest);
		return this;
	}   
	public AppearDescriptive clickOnReadyToBegin() {
		System.out.println("Click on 'I am Ready To Begin Test'");
		click(iAmReadyToBegin);
		return this;
	}
	public AppearDescriptive clickOnTxtAnsOne() {
		System.out.println("answear one");
		scrollToElement(txtBoxAns1);
		sendKeys(txtBoxAns1,"Model–view–controller is a software architectural pattern");
		return this;
	}
	public AppearDescriptive clickOnSaveAndNext() {
		System.out.println("Click on Save and Next");
		scrollIntoView(saveandnextbuttonclick, 0, 500);
		click(saveandnextbuttonclick);
		return this;
	}
	public AppearDescriptive clickOnTxtAnsTwo() {
		System.out.println("answear Two");
		scrollToElement(txtBoxAns2);
		sendKeys(txtBoxAns2,"set of certain stages which occur at a certain time");
		return this;
	}
	public AppearDescriptive clickOnSaveAndNextButton() {
		System.out.println("Click on Save and Next");
		scrollIntoView(saveandnextbuttonclick, 0, 500);
		click(saveandnextclick);
		return this;
	}
	public AppearDescriptive clickOnReviewAndSubmitButton() {
		System.out.println("Click on Final Submit");
		click(reviewandsubmitclick);
		return this;
	}
	public AppearDescriptive clickOnFinishButton() {
		System.out.println("Click on Finish Button");
		click(finishclick);
		return this;
	}
	public AppearDescriptive clickOnOkButton() {
		System.out.println("Click on Finish Button");
		click(okclick);
		return this;
	}
	public AppearDescriptive clickOnCloseWindow() {
		System.out.println("Click on Finish Button");
		click(windowcloseclick);
		return this;
	}*/
	/*public MyDescriptivepage clickOnAnswerOne()
	{
		System.out.println("Click on 'Answer one'");
		click(answerone);
		System.out.println("Clicked......................'");
		return this;
	}
 public MyDescriptivepage clickOnAnswertwo()
	{
		System.out.println("Click on 'Answer two'");
		click(answertwo);
		System.out.println("Clicked......................'");
		return this;
	}*/
	
	


	
	
	
	
//	public MyTest clickOnAlertClose() {
//		System.out.println("Click on 'Close'");
//		click(finalclose);
//		return this;
//	}
	
}