package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;



public class LoginPageAdmin extends BaseClass{

	
	public WebDriver driver;
	LoginPageAdmin loginPageCIMS;
	
	public LoginPageAdmin(WebDriver rdriver) 
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	
	
	
	@FindBy (id = "txtuserid") private WebElement usernameTextField;
	@FindBy (id = "txtpassword") private WebElement passwordTextField;
	@FindBy (id = "btnlogin") private WebElement loginButton;
	
	

	
	public LoginPageAdmin enterUserName(String userName)
	{
		System.out.println("Enter Username "+userName);
		sendKeys(usernameTextField, userName);
		return this;
	}

	
	public LoginPageAdmin enterPassword(String password) 
	{
		System.out.println("Enter Password " + password);
		sendKeys(passwordTextField, password);
		return this;
	}
	
	
	
	public HomePageAdmin pressLoginButton() 
	{
		System.out.println("Press Login Button ");
		click(loginButton);
		return new HomePageAdmin(driver);
	}


	public HomePageAdmin login(String userName, String password)
	{
		enterUserName(userName);
		enterPassword(password);
		return pressLoginButton();
	}

}
