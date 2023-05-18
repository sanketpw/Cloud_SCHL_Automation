package com.qa.pages.itle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class SelectCourse extends BaseClass{
	
	
	public SelectCourse(WebDriver rdriver) {
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy (id = "ddlSession") private WebElement itleSession;
	//@FindBy (linkText = "BSC SEM 1 - 1 - ENGLISH - ENGLISH (BS) - 0.00") private WebElement activeCourse;
	@FindBy (xpath = "//a[@title='My Test']") private WebElement workAreaMyTest;
	
	
	
	
	
	public SelectCourse select_ITLE_Session() {
		System.out.println("Select ITLE Session 'WINTER 2016'");
		Select ddl = new Select(itleSession);
		ddl.selectByVisibleText("WINTER 2016");
		return this;
	}
	
	
//	public SelectCourse open_Course() {
//		System.out.println("Select Course");
//		click(activeCourse);
//		return this;
//	}
	

	public SelectCourse open_My_Test_In_WorkArea() {
		System.out.println("Open 'My Test' From Work Area");
		click(workAreaMyTest);
		return this;
	}
	




}