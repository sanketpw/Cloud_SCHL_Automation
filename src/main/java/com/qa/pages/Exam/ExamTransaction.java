package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class ExamTransaction extends BaseClass {
	
	

		public ExamTransaction(WebDriver rdriver)
		{
			driver= rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy (xpath = "//*/text()[normalize-space(.)='Transaction']/parent::*") private WebElement Transaction;
		
		public ExamTransaction open_Transaction() {
			 
			System.out.println("Open Transaction");
			click(Transaction);
			return this;
		}

}
