package com.qa.pages.SchemeExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class SchemeCourseAllotment extends BaseClass{
	
		
		public SchemeCourseAllotment  (WebDriver rdriver)
		{
			driver= rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy (id = "ddlScheme") private WebElement Scheme;
		@FindBy (xpath ="//div[2]/div/button") private WebElement BasicCourse;	
		@FindBy (xpath ="//input[@value='12886']") private WebElement Course;
		@FindBy (id = "btnSubmit") private WebElement Submit;
		
		public SchemeCourseAllotment Scheme() {		
		    System.out.println("Select Scheme");
			Select ddl = new Select(Scheme);
			ddl.selectByVisibleText("(SESSION 2022-2023)");
			return this;
		}		
			
		
		public SchemeCourseAllotment Submit() {
			System.out.println("Click on Submit");
			click(Submit);			
			return this;
			}
		
	
		public SchemeCourseAllotment BasicCourse() {
			System.out.println("Click on BasicCourse");
			click(BasicCourse);			
			return this;
			}
		
		public SchemeCourseAllotment Course() {
			System.out.println("Click on Course");
			click(Course);			
			return this;
			}
		
		public SchemeCourseAllotment SchemeAllotmentActivity() throws Exception {
			Scheme();
			BasicCourse();
			 Course();
			
			
				Actions actions = new Actions(driver);
				actions.click().build().perform();
				Thread.sleep(1000); 
				driver.findElement(By.id("chkExamId106")).click();
				Thread.sleep(1000); 
				driver.findElement(By.id("chkExamId107")).click();
				Thread.sleep(1000); 
				driver.findElement(By.id("chkExamId108")).click();
				Thread.sleep(1000); 
				driver.findElement(By.id("chkExamId109")).click();
			
			
		    Thread.sleep(2000); 			
			 Submit();
			
		
			return this;
			}

		}
