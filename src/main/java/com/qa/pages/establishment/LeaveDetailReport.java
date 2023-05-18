package com.qa.pages.establishment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class LeaveDetailReport extends BaseClass{
	
	public LeaveDetailReport(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "ddlStaff") private WebElement ddlStaff;
	@FindBy (id = "ddlDesignature") private WebElement ddlDesignature;
	@FindBy (id = "btnReport") private WebElement btnReport;
	
	public LeaveDetailReport ddlStaff() {
		System.out.println("Select ddlStaff");
		Select ddl = new Select(ddlStaff);
		ddl.selectByVisibleText("TEACHING");
		return this;
	}
	
	
	public LeaveDetailReport ddlDesignature() {
		System.out.println("Click btnEmpList");
		Select ddl = new Select(ddlDesignature);
		ddl.selectByVisibleText("PERMANENT");
		return this;
	}
	
	public LeaveDetailReport  btnReport() {
		System.out.println("click btnReport");
		click(btnReport);
		return this;
	}
}