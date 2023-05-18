package com.qa.pages.SchemeExam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;
import com.qa.pages.Exam.LoginExam;

public class LoginSchemeExam extends BaseClass{
	
	public WebDriver driver;
	LoginExam loginexam;

	public LoginSchemeExam(WebDriver rdriver) 
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

	
	public LoginSchemeExam enterUserName(String userName) {
		System.out.println("Enter Username "+userName);
		sendKeys(usernameTextField, userName);
		return this;
	}

	
	public LoginSchemeExam enterPassword(String password) {
		System.out.println("Enter Password " + password);
		sendKeys(passwordTextField, password);
		return this;
	}
	
	
	public HomePageSchemeExam pressLoginButton() throws Exception {		
		System.out.println("Press Login Button ");		
		click(loginButton);				 
	    return new HomePageSchemeExam(driver);
		
	}	
	
	public HomePageSchemeExam login(String userName, String password) throws Exception{
		enterUserName(userName);
		enterPassword(password);
		return pressLoginButton();
	}
	

}
