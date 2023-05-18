package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;



public class LoginPageStudent extends BaseClass{

	
	public WebDriver driver;
	LoginPageStudent loginPageCIMS;
	
	public LoginPageStudent(WebDriver rdriver) 
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	
	
	
	@FindBy (xpath = "//input[@id='txtUserName']") private WebElement usernameTextField;
	@FindBy (id = "txtPassword") private WebElement passwordTextField;
	@FindBy (xpath = "//input[@id='btnlogin']") private WebElement loginButton;
	
//	By userName=By.xpath("//input[@id='txtUserName']");
//	By password=By.id("txtpassword");
//	By logIn=By.xpath("//input[@id='btnlogin']");

	@FindBy (xpath = "//input[@id='txtUserName']") private WebElement itlestudentusername;
	@FindBy (id = "txtPassword") private WebElement itlestudentpassword;
	@FindBy (xpath = "//input[@id='btnlogin']") private WebElement itlelogin;
	
	
	

	
	public LoginPageStudent enterUserName(String userName) {
		System.out.println("Enter Username "+userName);
		sendKeys(usernameTextField, userName);
		return this;
	}

	
	public LoginPageStudent enterPassword(String password) {
		System.out.println("Enter Password " + password);
		sendKeys(passwordTextField, password);
		return this;
	}
	
	
	public HomePageStudent pressLoginButton() {
		System.out.println("Press Login Button ");
		click(loginButton);
		return new HomePageStudent(driver);
	}


	public HomePageStudent login(String userName, String password){
		enterUserName(userName);
		enterPassword(password);
		return pressLoginButton();
	}
	
	public LoginPageStudent enterItleUserName(String userName) {
		System.out.println("Enter Username "+userName);
		sendKeys(itlestudentusername, userName);
		return this;
	}

	
	public LoginPageStudent enterItlePassword(String password) {
		System.out.println("Enter Password " + password);
		sendKeys(itlestudentpassword, password);
		return this;
	}
	
	
	public HomePageStudent pressItleLoginButton() {
		System.out.println("Press Login Button ");
		click(itlelogin);
		return new HomePageStudent(driver);
	}

	
	
	
	
}
