package com.qa.pages.attendance;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class SlotAllotment extends BaseClass
{

	public SlotAllotment(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Attendance Slot Master'])[1]/following::span[1]") private WebElement clickslotallotment ;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='*'])[2]/following::button[1]") private WebElement slotbasiccourse ;
	@FindBy (xpath = "//div/ul/li/div/input") private WebElement searchboxforbasiccourse ;
	@FindBy (xpath = "/html/body/div[3]/aside[2]/section/div/div/div/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/ul/li[2]/a/label/input") private WebElement cheackboxtoselectsearchedoption ;
	@FindBy (xpath = "/html/body/div[3]/aside[2]/section/div/div/div/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[2]/div/button") private WebElement slotcourse ;
	@FindBy (xpath = "/html/body/div[3]/aside[2]/section/div/div/div/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[2]/div/ul/li[1]/div/input") private WebElement searchboxforcourse ;
	@FindBy (xpath = "/html/body/div[3]/aside[2]/section/div/div/div/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[2]/div/ul/li[2]/a/label/input") private WebElement cheackboxtoselectsearchedoptionforcourse ;
	@FindBy (xpath = "/html/body/div[3]/aside[2]/section/div/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div[2]/div/button") private WebElement slotname ;
	@FindBy (xpath = "/html/body/div[3]/aside[2]/section/div/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div[2]/div/ul/li[1]/div/input") private WebElement searchboxforslotname ;
	@FindBy (xpath = "/html/body/div[3]/aside[2]/section/div/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div[2]/div/ul/li[3]/a/label/input") private WebElement cheackboxtoselectsearchedoptionforslotname ;

	
	
	public SlotAllotment OpenSlotAllottment()
	{
		System.out.println("Open Slot Allottment");
		click(clickslotallotment);
		return this;
	}// OpenSlotAllottment  end
	
	public SlotAllotment SelectSlotBasiccourse() throws InterruptedException 
	{
		System.out.println("Select 'Basic Course'");
		slotbasiccourse.click();
		Thread.sleep(1000);
		searchboxforbasiccourse.sendKeys("BSC SEM 1");
		Thread.sleep(1000);
		cheackboxtoselectsearchedoption.click();
		Thread.sleep(1000);
		slotbasiccourse.click();
	    System.out.println("dropdown value selected");
		return this;
	}//SelectSlotBasiccourse end
	
	public SlotAllotment SelectSlotCourse() throws InterruptedException 
	{
		System.out.println("Select ' Course'");
		slotcourse.click();
		Thread.sleep(1000);
		searchboxforcourse.sendKeys("BSC SEM 1 - 1");
		Thread.sleep(1000);
		cheackboxtoselectsearchedoptionforcourse.click();
		Thread.sleep(1000);
		slotcourse.click();
	    System.out.println("dropdown value selected");
		return this;
	}//SelectSlotcourse end
	
	public SlotAllotment SelectSlotName() throws InterruptedException 
	{
		System.out.println("Select 'Slot Name'");
		slotname.click();
		Thread.sleep(1000);
		searchboxforslotname.sendKeys("SLOT 2->2->10:00AM->11:00AM");
		Thread.sleep(1000);
		cheackboxtoselectsearchedoptionforslotname.click();
		Thread.sleep(1000);
		slotname.click();
	    System.out.println("dropdown value selected");
		return this;
	}//SelectSlotBasiccourse end
	
	



}// AttendanceSlotAllotmentPages class end