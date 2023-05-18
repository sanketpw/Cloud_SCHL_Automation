package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class HomePageStudent extends BaseClass{
	
	public HomePageStudent(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (xpath = "//a[@id='ITLE']/span") private WebElement itle_eLearning;
	@FindBy (xpath = "//ul[@id='studentMenus']/li[13]/a") private WebElement onlineregisteration;
	
	public HomePageStudent openITLE() {
		System.out.println("Open ITLE ");
		click(itle_eLearning);
		return this;
	}
		public HomePageStudent openOnlineRegisteration() {
		System.out.println("Open Online Registeration");
		click(onlineregisteration);
		return this;
	}
	
	
	
	

	
	
	
	



}