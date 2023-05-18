package com.qa.pages.itle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class MyTest extends BaseClass{
	
	
	public MyTest(WebDriver rdriver) {
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "btnStart") private WebElement startObjectiveTest;
	@FindBy (xpath = "//button[@id='btnStartTest']") private WebElement iAmReadyToBegin;
	@FindBy (xpath = "//input[@id='rbMoption1']") private WebElement answerone;
	//@FindBy (id = "rbMoption1") private WebElement answertwo;
	@FindBy (xpath = "//*[@id=\"rbMoption1\"]") private WebElement answertwo;
    @FindBy (id = "btnSaveNext") private WebElement saveandnextbuttonclick;
	@FindBy (xpath = "//*[@id=\"btnMarkForReview\"]/span") private WebElement reviewandsubmitclick;
	@FindBy (xpath = "//*[@id=\"btnFinalSubmit\"]/span") private WebElement finalclick;
	//@FindBy (xpath = "//*[@id=\"btnCloseModalPopup\"]/span") private WebElement closeclick;
	@FindBy (id = "btnOK") private WebElement finalalertok;
	//@FindBy (xpath = "//*[@id=\"myConfirmAlertModal\"]/div/div/div[3]/button[2]") private WebElement finalclose;
	//tr[@class='even']//input[@id='btnStart']
	//tbody[@id='tbody']/tr[2]/td[3]/input
	//tbody[@id='tbody']/tr[2]/td[3]/input
	// id=btnSubmitByAdminTerminate        id=btnMarkForReviewSave
	public MyTest clickOnStartTest() {
		System.out.println("Click on 'Start Test'");
		click(startObjectiveTest);
		return this;
	}
	public MyTest clickOnReadyToBegin() {
		System.out.println("Click on 'I am Ready To Begin Test'");
		click(iAmReadyToBegin);
		return this;
	} 
	public MyTest clickOnAnswerOne()
	{
		System.out.println("Click on 'Answer one'");
		click(answerone);
		System.out.println("Clicked......................'");
		return this;
	}
	public MyTest clickOnAnswertwo()
	{
		System.out.println("Click on 'Answer two'");
		click(answertwo);
		System.out.println("Clicked......................'");
		return this;
	}
	public MyTest clickOnSaveAndNext() {
		System.out.println("Click on 'Start Test'");
		click(saveandnextbuttonclick);
		return this;
	}
	public MyTest clickOnReviewAndSubmit() {
		System.out.println("Click on 'Review And Submit'");
		click(reviewandsubmitclick);
		return this;
	}
//	public MyTest clickOnClose() {
//		System.out.println("Click on 'Close'");
//		click(closeclick);
//		return this;
//	}
	public MyTest clickOnFinal() {
		System.out.println("Click on 'Close'");
		click(finalclick);
		return this;
	}
	public MyTest clickOnFinalAlertOk() {
		System.out.println("Click on 'Final'");
		click(finalalertok);
		return this;
	}
//	public MyTest clickOnAlertClose() {
//		System.out.println("Click on 'Close'");
//		click(finalclose);
//		return this;
//	}
	
}