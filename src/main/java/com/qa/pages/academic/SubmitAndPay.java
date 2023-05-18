package com.qa.pages.academic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class SubmitAndPay extends BaseClass{
	
	public SubmitAndPay(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy (id = "txtRemark") private WebElement remarkPayment;
	@FindBy (id = "ddlAdmThrough") private WebElement admthrough;
	@FindBy (id = "ddlpayoption") private WebElement paymentoption;
	@FindBy (id = "payid") private WebElement paymentid;
	
	@FindBy (xpath = "//button[@id='btnSubmit']/span") private WebElement submit;
	@FindBy (xpath = "//button[@id='btnAdjustFees']/span") private WebElement adjustfees;
	@FindBy (id = "txtFirstName") private WebElement concession;
	@FindBy (id = "ddlPaymentMode") private WebElement paymentmode;
	@FindBy (id = "amount") private WebElement amount;
	@FindBy (xpath = "//button[@id='btnAddAmt']/span") private WebElement add;
	
	@FindBy (id = "txtMother") private WebElement chequeno;
	@FindBy (id = "txtFather") private WebElement chequedate;
	@FindBy (id = "txtEnrollmentNo") private WebElement bankname;
	@FindBy (id = "txtMobile") private WebElement banklocation;
	@FindBy (id = "txtEmail") private WebElement ddno;
	@FindBy (id = "txtRemark") private WebElement dddate;
	@FindBy (id = "chkAdmZeroFee") private WebElement tranid;
	@FindBy (id = "btnSubmit") private WebElement trandate;
		

	@FindBy (id = "success") private WebElement confirmationmessage;


	
	
	
	public SubmitAndPay enterRemarkPayment() {
		System.out.println("Enter remarkPayment");
		sendKeys(remarkPayment,"Payment Completed");
		return this;
	}
	
	
	
	public SubmitAndPay selectADMThrough() {
		System.out.println("Select ADM Through");
		Select ddl = new Select(admthrough);
		ddl.selectByVisibleText("REGULAR");
		return this;
	}
	
	
	
	public SubmitAndPay selectPaymentOption() {
		System.out.println("Select Payment Option");
		Select ddl = new Select(paymentoption);
		ddl.selectByVisibleText("RTGS");
		return this;
	}
	
	
	
	public SubmitAndPay enterPaymentId() {
		System.out.println("Enter Payment Id");
		sendKeys(paymentid, "CR12345678");
		return this;
	}
	
	
	
	public SubmitAndPay clickOnFeesConcession() {
		System.out.println("Click On Fees Concession");
		click(concession);
		return this;
	}
	
	
	
	public SubmitAndPay clickOnSubmitButton() {
		System.out.println("Click On Submit Button");
		click(submit);
		return this;
	}
	
	
	
	public SubmitAndPay clickOnAdjustFees() {
		System.out.println("Click On Adjust Fees");
		click(adjustfees);
		return this;
	}
	
	
	
	public SubmitAndPay selectPaymentMode(String mode) throws Exception {
		System.out.println("Select Payment Mode");
		scrollIntoView(paymentmode, 0, 500);
		Thread.sleep(2000);
		click(paymentmode);
		Select ddl = new Select(paymentmode);
		ddl.selectByVisibleText(mode);
		return this;
	}
	
	
	
	public SubmitAndPay enterAmount() {
		System.out.println("Enter Amount");
		scrollIntoView(amount, 0, 500);
//		switchToFrame(0);
		clearText(amount);
		sendKeys(amount, "100");
		return this;
	}
	
	
	
	public SubmitAndPay clickOnAddButton() {
		System.out.println("Click On Add Button");
		click(add);
		return this;
	}
	

	
	
	public String verifyConfirmationMessage() {
		String confirmationMsg = getText(confirmationmessage);
		System.out.println("Confirmation Message - " + confirmationMsg );
		return confirmationMsg;
	}
	
		
	
	
}