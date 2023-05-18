package com.qa.pages.Exam;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnlockRegistrationOnly extends BaseClass{

	
	public UnlockRegistrationOnly Unregistration() throws InterruptedException {
		
		
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
		driver.findElement(By.linkText("Transaction")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Pre Exam']/parent::*")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/text()[normalize-space(.)='Exam Registration Unlock']/parent::*")).click();
		 driver.findElement(By.id("ddlSession")).click();
		 Thread.sleep(1000); 
		    new Select(driver.findElement(By.id("ddlSession"))).selectByVisibleText("ES_2021-2020(NEW1)");
		    Thread.sleep(1000); 
		    driver.findElement(By.id("ddlBasicCourse")).click();
		    new Select(driver.findElement(By.id("ddlBasicCourse"))).selectByVisibleText("B.COM");
		    Thread.sleep(1000); 
		    driver.findElement(By.id("ddlCourse")).click();
		    new Select(driver.findElement(By.id("ddlCourse"))).selectByVisibleText("B.COM - 1");
		    Thread.sleep(1000); 
		    driver.findElement(By.id("ddlMedium")).click();
		    new Select(driver.findElement(By.id("ddlMedium"))).selectByVisibleText("ENGLISH");
//		    driver.findElement(By.id("ddlSection")).click();
//		    new Select(driver.findElement(By.id("ddlSection"))).selectByVisibleText("A");		    
		    Thread.sleep(1000); 		
		    driver.findElement(By.id("ChkAll")).click();
		    Thread.sleep(1000); 		
		    driver.findElement(By.id("ChkAll")).click();
		    Thread.sleep(1000); 		
		    driver.findElement(By.id("ChkAll")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnUnLockSpan")).click();
			Thread.sleep(2000);
			
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10 /*timeout in seconds*/);
				if(wait.until(ExpectedConditions.alertIsPresent())==null) {  
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
			
			driver.findElement(By.id("btnUnRegSpan")).click();
			Thread.sleep(2000); 
			//acceptAlert();
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10 /*timeout in seconds*/);
				if(wait.until(ExpectedConditions.alertIsPresent())==null) {  
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
