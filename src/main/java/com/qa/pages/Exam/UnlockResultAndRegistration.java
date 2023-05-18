package com.qa.pages.Exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnlockResultAndRegistration extends BaseClass{
	 
	
	 
	public UnlockResultAndRegistration UnlockResultAndRegistration1() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		Thread.sleep(1000); 
		WebDriver driver=new ChromeDriver();  
		Thread.sleep(1000); 
		driver.get("https://school.mastersofterp.in");
		Thread.sleep(1000); 
		driver.manage().window().maximize();
		driver.findElement(By.id("txtuserid")).sendKeys("cbseuser@pes.com");
		Thread.sleep(1000); 
		driver.findElement(By.id("txtpassword")).sendKeys("iitms@123");
		Thread.sleep(1000); 
		driver.findElement(By.id("btnlogin")).click();	
		Thread.sleep(1000); 
		driver.findElement(By.linkText("ASSESSMENT & EXAMS")).click();
		Thread.sleep(1000); 
		//driver.findElement(By.xpath("/html/body/div[3]/aside[1]/section/ul/li[4]/a/span[1]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/aside[1]/section/div/ul/li[4]/a/span[1]")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//*[@id=\"list-to-filter\"]/ul/li[4]/a/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Lock Unlock Result']/parent::*")).click();
		Thread.sleep(1000); 
		 driver.findElement(By.id("ddlExamSession")).click();
		    new Select(driver.findElement(By.id("ddlExamSession"))).selectByVisibleText("ES_2021-2020(NEW1)");
		    Thread.sleep(1000); 
		    driver.findElement(By.id("ddlBasicCourse")).click();
		    new Select(driver.findElement(By.id("ddlBasicCourse"))).selectByVisibleText("B.COM");
		    Thread.sleep(1000); 
		    driver.findElement(By.id("ddlCourse")).click();
		    new Select(driver.findElement(By.id("ddlCourse"))).selectByVisibleText("B.COM - 1");
		    Thread.sleep(1000); 
//		    driver.findElement(By.id("ddlSection")).click();
//		    new Select(driver.findElement(By.id("ddlSection"))).selectByVisibleText("A");		    
		    Thread.sleep(1000); 		
		    driver.findElement(By.id("ChkAll")).click();
			Thread.sleep(1000);  		
		    driver.findElement(By.id("btnUnlockSpan")).click();
			Thread.sleep(1000);
	

		return this;
		
		
	}
	
	
}


