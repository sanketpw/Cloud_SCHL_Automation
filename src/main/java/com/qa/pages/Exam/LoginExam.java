package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;



public class LoginExam extends BaseClass{
	
	public WebDriver driver;
	LoginExam loginexam;

	public LoginExam(WebDriver rdriver) 
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy (xpath = "//input[@id='txtuserid']") private WebElement usernameTextField;
	@FindBy (id = "txtpassword") private WebElement passwordTextField;
	@FindBy (xpath = "//input[@id='btnlogin']") private WebElement loginButton;
	
//	By userName=By.xpath("//input[@id='txtUserName']");
//	By password=By.id("txtpassword");
//	By logIn=By.xpath("//input[@id='btnlogin']");	

	
	public LoginExam enterUserName(String userName) {
		System.out.println("Enter Username "+userName);
		sendKeys(usernameTextField, userName);
		return this;
	}

	
	public LoginExam enterPassword(String password) {
		System.out.println("Enter Password " + password);
		sendKeys(passwordTextField, password);
		return this;
	}
	
	
	public HomePageExam pressLoginButton() throws Exception {		
		System.out.println("Press Login Button ");		
		click(loginButton);				 
	    return new HomePageExam(driver);
		
	}	
	
	public HomePageExam login(String userName, String password) throws Exception{
		enterUserName(userName);
		enterPassword(password);
		return pressLoginButton();
	}
	
	
}
