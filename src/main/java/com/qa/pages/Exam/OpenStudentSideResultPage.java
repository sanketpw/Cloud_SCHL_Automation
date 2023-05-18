package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class OpenStudentSideResultPage extends BaseClass {
	
	public OpenStudentSideResultPage  (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "Examination") private WebElement Examination;
	@FindBy (xpath = "/html/body/div[3]/aside[1]/section/ul/li[6]/div/ul/li[2]/a/span") private WebElement StudentActualResult;
	
	public OpenStudentSideResultPage Examination() {
		System.out.println("Click on Examination");
		click(Examination);			
		return this;}
		
		public OpenStudentSideResultPage StudentActualResult() {
			System.out.println("Click on StudentActualResult_Studentside");
			click(StudentActualResult);			
			return this;
			}
		
		public OpenStudentSideResultPage StudentSide_ResultPage() {
			
			Examination();
			StudentActualResult();
					
			return this;
			}
		

}
