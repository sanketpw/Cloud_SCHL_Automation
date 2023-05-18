package com.qa.pages.syty_registeration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class OnlineRegisteration extends BaseClass{
	
	public OnlineRegisteration(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (linkText = "Personal") private WebElement personal;
	
	
	
	
	public OnlineRegisteration openPersonal() {
		System.out.println("Open Personal");
		click(personal);
		return this;
	}
	
	

	
	
	
	
	



}