package com.qa.pages.establishment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class LeaveApproval extends BaseClass{
	
	public LeaveApproval(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (className = "fa fa-pencil-square-o") private WebElement ApproveORReject;
	@FindBy (id = "ddlSelectType") private WebElement ddlSelectType;
	@FindBy (id = "txtRemark") private WebElement Remark;
	@FindBy (id = "btnSubmit") private WebElement btnSubmit;
	//test
	
	public LeaveApproval ApproveORReject() {
		System.out.println("Click ApproveORReject");
		click(ApproveORReject);
		return this;
	}
	
	public LeaveApproval ddlSelectType() {
		System.out.println("Select ddlSelectType");
		Select ddl = new Select(ddlSelectType);
		ddl.selectByVisibleText("Approve");
		return this;
	}
	
	public LeaveApproval Remark() {
		System.out.println("Select Remark");
		sendKeys(Remark,"Valid reason is available");
		return this;
	}
	
	public LeaveApproval btnSubmit() {
		System.out.println("Select btnSubmit");
		click(btnSubmit);
		return this;
	}
}