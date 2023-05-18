package com.qa.pages.academic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class FeesCollection extends BaseClass{
	
	public FeesCollection(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Name']/parent::*") private WebElement searchcriteria;
	@FindBy (id = "txtStudent") private WebElement enterstudentname;
	@FindBy (className = "eac-item") private WebElement studentname;
	@FindBy (id = "btnShow") private WebElement btnShow;
	@FindBy (id = "txtMobileNo") private WebElement mobileno;
	@FindBy (id = "txtRemark") private WebElement remark;
	@FindBy (id = "ddlAdmThrough") private WebElement ddlAdmThrough;
	@FindBy (id = "ddlpayoption") private WebElement ddlpayoption;
	@FindBy (id = "payid") private WebElement payid;
	@FindBy (id = "ddlPayMode") private WebElement ddlPayMode;
	@FindBy (id = "txtAmtDesc") private WebElement AmtDesc;
	@FindBy (id = "btnAdd") private WebElement btnAdd;
	@FindBy (id = "btnAdjust") private WebElement btnAdjust;
	@FindBy (id = "btnSubmitSpan") private WebElement btnSubmitSpan;
	
	
	public FeesCollection SearchCriteria() {
		System.out.println("Click on Search Criteria");
		click(searchcriteria);
		return this;
	}
	
	
	
	public FeesCollection Enterstudentname() throws Exception {
		System.out.println("Enter student name");
		sendKeys(enterstudentname,"Kawale");
		click(studentname);
		return this;
	}
	
	public FeesCollection btnShow() {
		System.out.println("Click on btnShow");
		click(btnShow);
		return this;
	}
	
	public FeesCollection EnterMobileNo() {
		System.out.println("EnterMobileNo");
		sendKeys(mobileno,"8149914475");
		return this;
	}
	
	public FeesCollection Remark() {
		System.out.println("Remark");
		sendKeys(remark,"Always paid Fees on Time in Future");
		return this;
	}
	
	public FeesCollection ddlAdmThrough() {
		System.out.println("AdmThrough");
		Select ddl = new Select(ddlAdmThrough);
		ddl.selectByVisibleText("REGULAR");
		return this;
	}
	
	public FeesCollection ddlpayoption() {
		System.out.println("Click on Payment Options");
		Select ddl = new Select(ddlpayoption);
		ddl.selectByVisibleText("RTGS");
		return this;
	}
	
	public FeesCollection payid() {
		System.out.println("Enter payid");
		sendKeys(payid,"984653");
		return this;
	}
	
	public FeesCollection ddlPayMode() {
		System.out.println("Click on Payment Mode");
		Select ddl = new Select(ddlPayMode);
		ddl.selectByVisibleText("Cash");
		return this;
	}
	
	public FeesCollection AmtDesc() {
		System.out.println("Enter AmtDesc");
		sendKeys(AmtDesc,"200");
		return this;
	}
	
	public FeesCollection btnAdd() {
		System.out.println("Click on btnAdd");
		click(btnAdd);
		return this;
	}
	
	public FeesCollection btnAdjust() {
		System.out.println("Click on btnAdjust");
		click(btnAdjust);
		return this;
	}
	
	public FeesCollection btnSubmitSpan() {
		System.out.println("Click on btnSubmitSpan");
		click(btnSubmitSpan);
		return this;
	}
	
}