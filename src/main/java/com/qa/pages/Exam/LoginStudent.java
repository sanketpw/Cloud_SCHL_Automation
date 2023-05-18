package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class LoginStudent extends BaseClass {
	
	
	public WebDriver driver;

	public LoginStudent(WebDriver rdriver) 
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);

	}
	@FindBy (id = "txtUserName") private WebElement usernameTextField;
	@FindBy (id = "txtPassword") private WebElement passwordTextField;
	@FindBy (id = "btnlogin") private WebElement loginButton;
	

	
	public LoginStudent enterUserName(String userName) {
		System.out.println("Enter Username "+userName);
		sendKeys(usernameTextField, userName);
		return this;
	}

	
	public LoginStudent enterPassword(String password) {
		System.out.println("Enter Password " + password);
		sendKeys(passwordTextField, password);
		return this;
	}
	
	
	public LoginStudent pressLoginButton() throws Exception {		
		System.out.println("Press Login Button ");		
		click(loginButton);				 
	    return new LoginStudent(driver);
		
	}	
	
	public LoginStudent login1(String userName, String password) throws Exception{
		enterUserName(userName);
		enterPassword(password);
		return pressLoginButton();
	}

}
