package com.qa.pages.SchemeExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class SchemeCreation extends BaseClass {
	
	public SchemeCreation  (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "ddlAcademicYear") private WebElement AcademicYear;
	@FindBy (id = "txtSchemeName") private WebElement SchemeName;
	@FindBy (id = "ddlGradepattern") private WebElement ResultPattern;
	@FindBy (id = "btnSubmit") private WebElement Submit;
	
	public SchemeCreation AcademicYear() {		
	    System.out.println("Select AcademicYear");
		Select ddl = new Select(AcademicYear);
		ddl.selectByVisibleText("SESSION 2022-2023");
		return this;
	}		
	
	public SchemeCreation SchemeName() {
		System.out.println("Enter SchemeName");
		SchemeName.clear();
		sendKeys(SchemeName,"NewSchemeSh");		
		return this;
		}
	
	public SchemeCreation ResultPattern() {
		System.out.println("Select ResultPattern");
		Select ddl = new Select(ResultPattern);
		ddl.selectByVisibleText("10 Point Grading");
		return this;
		}
	
	public SchemeCreation Submit() {
		System.out.println("Click on Submit");
		click(Submit);			
		return this;
		}
		
	public SchemeCreation ScemeCreationActivity() throws Exception {
		  AcademicYear();
		  SchemeName();
		  ResultPattern();
		 
		  Thread.sleep(1000); 
		  driver.findElement(By.id("chkExamId106")).click();
		  Thread.sleep(1000); 
		
		 //Submit();		  	
		return this;
		}
		
}	
	

