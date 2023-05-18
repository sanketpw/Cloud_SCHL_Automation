package com.qa.pages.syty_registeration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class Personal extends BaseClass{
	
	public Personal(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "txtUnicodeName") private WebElement studentnametamil;
	@FindBy (id = "ddlGender") private WebElement gender;
	@FindBy (id = "txtmobileNo") private WebElement mobileno;

	
	
	
	public Personal enterStudentNameTamil() {
		System.out.println("Enter Student Name in Tamil");
		sendKeys(studentnametamil, "Sanjay");
		return this;
	}
	
	
	public Personal selectGender() {
		System.out.println("Select Gender");
		Select ddl = new Select(gender);
		ddl.selectByVisibleText("MALE");
		return this;
	}
	
	
	public Personal enterMobileNo() {
		System.out.println("Enter Mobile Number");
		sendKeys(mobileno, "9763639705");
		return this;
	}
	
	

	
	
	
	
	



}