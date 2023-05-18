package com.qa.pages.SchemeExam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class Subject  extends BaseClass{
	
	public Subject (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "/html/body/div[3]/aside[1]/section/ul/li[3]/ul/li[3]/a/span") private WebElement SubjectSubmodule;
	
	
	public Subject SubjectSubmodule() {
		System.out.println("Open Subject submodule");
		click(SubjectSubmodule);
		return this;
	}

}
