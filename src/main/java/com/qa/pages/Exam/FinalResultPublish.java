package com.qa.pages.Exam;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseClass;

public class FinalResultPublish extends BaseClass {

	public FinalResultPublish  (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "ddlExamSession") private WebElement Session;
	@FindBy (id = "ddlBasicCourse") private WebElement BasicCourse;
	@FindBy (id = "ddlCourse") private WebElement Course;
	@FindBy (id = "txtPublishDate") private WebElement PublishDate;
	@FindBy (id = "txtPublishTime") private WebElement PublishTime;
	@FindBy (id="ChkAll") private WebElement SelectAll;
	@FindBy (id = "btnPublish") private WebElement btnPublish;
	
	public FinalResultPublish Session() {		
	    System.out.println("Select Session");
		Select ddl = new Select(Session);
		ddl.selectByVisibleText("ES_2021-2020(NEW1)");
		return this;
	}		
	
	public FinalResultPublish BasicCourse() {
		System.out.println("Select BasicCourse");
		Select ddl = new Select(BasicCourse);
		ddl.selectByVisibleText("B.COM");
		return this;
		}
	
	public FinalResultPublish Course() {
		System.out.println("Select Exam Course");
		Select ddl = new Select(Course);
		ddl.selectByVisibleText("B.COM - 1");
		return this;
		}
	
	public FinalResultPublish PublishDate() {
	
		System.out.println("Enter PublishDate");
		PublishDate.clear();
		sendKeys(PublishDate,"09/08/2022");
		
		return this;
		}
	
	public FinalResultPublish PublishTime() {
		
		System.out.println("Enter PublishDate");
		PublishTime.clear();
		sendKeys(PublishTime,"15:59");
		
		return this;
		}
	
	public FinalResultPublish SelectAll() {
		System.out.println("Click on SelectAll");
		//click(SelectAll);
		
		WebElement checkBoxElement = SelectAll;
		boolean isSelected = checkBoxElement.isSelected();
				
		//performing click operation if element is not checked
		if(isSelected == false) {
			checkBoxElement.click();
		}
		
		return this;
	}
	
	public FinalResultPublish SubmitPublish() {
		System.out.println("Click on btnPublish");
		click(btnPublish);			
		return this;
		}
	
	public FinalResultPublish Publish() throws Exception {
		
		Session();
		BasicCourse();
		Course();
		PublishDate();
		PublishTime();
		Thread.sleep(1000);	
		SelectAll();
		Thread.sleep(1000);	
		SubmitPublish();
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30 /*timeout in seconds*/);
			if(wait.until(ExpectedConditions.alertIsPresent())==null) {
				Thread.sleep(1000);	
			    System.out.println("alert was not present");
			   
			} else {
			    Alert alert = driver.switchTo().alert();
			    alert.accept();
			    System.out.println("alert was present and accepted");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
				
		return this;
		}
	
}
