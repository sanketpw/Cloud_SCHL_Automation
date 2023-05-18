package com.qa.pages.Exam;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class HandelAlert extends BaseClass{
	
	
	public HandelAlert(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	

	public void HandelAlert1()	{		
		Alert alert = driver.switchTo().alert();	
		String alertMessage= driver.switchTo().alert().getText();
		 System.out.println(alertMessage);
		 alert.accept();	 

	}
	
}
