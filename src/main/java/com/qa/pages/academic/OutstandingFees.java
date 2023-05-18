package com.qa.pages.academic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class OutstandingFees extends BaseClass{
	
	public OutstandingFees(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//@FindBy (id = "ddlbasic") private WebElement ddlBasicCourseBranchStandard;
	@FindBy (id = "ddlCourse") private WebElement CourseYearStandard;
	@FindBy (id = "SNAME") private WebElement SearchBy;
	@FindBy (id = "serchtext") private WebElement entername;
	@FindBy (css = "div.eac-item") private WebElement ddoption;
	
	@FindBy (id = "btnShowSpan") private WebElement btnShowSpan;
	@FindBy (id = "txtRemark") private WebElement Remark;
	@FindBy (id = "ddlpayoption") private WebElement PaymentOption;
	@FindBy (id = "payid") private WebElement PaymentID;
	@FindBy (id = "ddlrcptmode") private WebElement ReceiptMode;
	@FindBy (id = "ddlPaymentMode") private WebElement PaymentMode;
	@FindBy (id = "amount") private WebElement amount;
	@FindBy (id = "btnAddAmt") private WebElement btnAddAmt;
	@FindBy (id = "btnAdjust") private WebElement btnAdjust;
	@FindBy (id = "btnSubmitSpan") private WebElement btnSubmitSpan;
	@FindBy (id = "icon") private WebElement Download;
	
//	public OutstandingFees ddlBasicCourseBranchStandard() {
//		System.out.println("Select BasicCourseBranchStandard");
//		Select ddl = new Select(ddlBasicCourseBranchStandard);
//		ddl.selectByVisibleText("STANDARD-5");
//		return this;
//	}
	
	public OutstandingFees CourseYearStandard() {
		System.out.println("Select CourseYearStandard");
		Select ddl = new Select(CourseYearStandard);
		ddl.selectByVisibleText("STANDARD-5");
		return this;
	}
	
	public OutstandingFees SearchBy() {
		System.out.println("Select SearchBy");
		click(SearchBy);
		return this;
	}
	
	public OutstandingFees serchtext() {
		System.out.println("Enter serchtext");
		sendKeys(entername,"Kawale");
		click(ddoption);
		return this;
	}
	
	public OutstandingFees btnShowSpan() {
		System.out.println("Click on btnShow");
		click(btnShowSpan);
		return this;
	}
	
	public OutstandingFees Remark() {
		System.out.println("Enter Remark");
		scrollToElement(Remark);
		sendKeys(Remark,"Good Marks");
		click(Remark);
		return this;
	}
	
	public OutstandingFees PaymentOption() {
		System.out.println("Select PaymentOption");
		Select ddl = new Select(PaymentOption);
		ddl.selectByVisibleText("RTGS");
		return this;
	}
	
	public OutstandingFees PaymentID() {
		System.out.println("Enter PaymentID");
		sendKeys(PaymentID,"9846566546");
		return this;
	}
	
	public OutstandingFees ReceiptMode() {
		System.out.println("Select ReceiptMode");
		Select ddl = new Select(ReceiptMode);
		ddl.selectByVisibleText("Cash Receipt");
		return this;
	}
	
	public OutstandingFees PaymentMode() {
		System.out.println("Select PaymentMode");
		Select ddl = new Select(PaymentMode);
		ddl.selectByVisibleText("Cash");
		return this;
	}
	
	public OutstandingFees amount() {
		System.out.println("Enter amount");
		clearText(amount);
		sendKeys(amount,"100");
		return this;
	}
	
	public OutstandingFees btnAddAmt() {
		System.out.println("Click on btnAddAmt");
		click(btnAddAmt);
		return this;
	}
	
	public OutstandingFees btnAdjust() {
		System.out.println("Click on btnAdjust");
		click(btnAdjust);
		return this;
	}
	
	public OutstandingFees btnSubmitSpan() {
		System.out.println("Click on btnSubmit");
		click(btnSubmitSpan);
		return this;
	}
	
	public OutstandingFees Download() {
		System.out.println("Click on Download");
		click(Download);
		return this;
	}
	
	
	
}