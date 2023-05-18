package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class OpenLockUnlock extends BaseClass {

	public OpenLockUnlock(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//*/text()[normalize-space(.)='Lock Unlock Mark Entry']/parent::*") private WebElement OpenLUMarkPage;
	
	public OpenLockUnlock OpenLockUnlockPage() {
		System.out.println("Open LockUnlock Page");
		click(OpenLUMarkPage);
		return this;
	}
	

}
