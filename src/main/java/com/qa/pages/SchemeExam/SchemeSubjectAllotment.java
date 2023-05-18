package com.qa.pages.SchemeExam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class SchemeSubjectAllotment extends BaseClass{	
	
	public SchemeSubjectAllotment  (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "ddlBasicCourse") private WebElement BasicCourse;
	@FindBy (id = "ddlCourse") private WebElement Course;
	@FindBy (id = "ddlScheme") private WebElement AllottoScheme;
	@FindBy (id = "btnSubmit") private WebElement Submit;
	
	public SchemeSubjectAllotment BasicCourse() {		
	    System.out.println("Select BasicCourse");
		Select ddl = new Select(BasicCourse);
		ddl.selectByVisibleText("BSC SEM 1");
		return this;
	}		
	
	public SchemeSubjectAllotment Course() {
		System.out.println("Enter Course");
		 
			Select ddl = new Select(Course);
			ddl.selectByVisibleText("BSC SEM 1 - 1");		
		return this;
		}
	
	public SchemeSubjectAllotment AllottoScheme() {
		System.out.println("Select AllottoScheme");
		Select ddl = new Select(AllottoScheme);
		ddl.selectByVisibleText("(SESSION 2022-2023)");
		return this;
		}
	
	public SchemeSubjectAllotment Submit() {
		System.out.println("Click on Submit");
		click(Submit);			
		return this;
		}
		
	public SchemeSubjectAllotment SchemeSubjectAllotmentPage() {
		BasicCourse();
		Course();
		AllottoScheme();
		 //Submit();
		  	
		return this;
		}
	

}
