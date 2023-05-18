package com.qa.pages.attendance;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class TimetableCreation extends BaseClass
{

	public TimetableCreation(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Student Attendance Registration'])[1]/following::span[1]") private WebElement opentimetable;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Time Table Creation'])[1]/following::span[1]") private WebElement openclasstimetable;
	@FindBy (id = "4718~226399~3000890~2859") private WebElement drag;
	@FindBy (id = "4718~223517~3000890~0") private WebElement drag1;
	@FindBy (id = "4718~223516~3000890~0") private WebElement drag2;
	@FindBy (id = "4718~218938~3000890~0") private WebElement drag3;
	@FindBy (id = "droppable1") private WebElement drop;
	@FindBy (id = "droppable5") private WebElement drop1;
	@FindBy (id = "droppable3") private WebElement drop2;
	@FindBy (id = "droppable15") private WebElement drop3;
	@FindBy (id = "droppable8") private WebElement drop4;
	@FindBy (id = "droppable12") private WebElement drop5;
	@FindBy (id = "droppable22") private WebElement drop6;
	@FindBy (id = "droppable23") private WebElement drop7;
	@FindBy (id = "droppable16") private WebElement drop8;
	@FindBy (id = "droppable20") private WebElement drop9;
	@FindBy (id = "droppable14") private WebElement drop10;
	@FindBy (id = "droppable9") private WebElement drop11;



	// (.//*[normalize-space(text()) and normalize-space(.)='Student Attendance Registration'])[1]/following::span[1]
	public TimetableCreation OpenTimetable()
	{
		System.out.println("Open Timetable");
		click(opentimetable);
		return this;
	}// OpenTimetable end

	public TimetableCreation OpenClassTimetable()
	{
		System.out.println("Open class Timetable");
		click(openclasstimetable);
		return this;
	}// OpenClassTimetable end

	public TimetableCreation DragAndDrop() throws InterruptedException 
	{

		//Creating object of Actions class to build composite actions  
		Actions act = new Actions(driver);  
		//Performing the drag and drop action  
		act.dragAndDrop(drag,drop).build().perform();
		act.dragAndDrop(drag,drop1).build().perform();  
		act.dragAndDrop(drag1,drop3).build().perform();  
		act.dragAndDrop(drag1,drop2).build().perform();  
		act.dragAndDrop(drag2,drop4).build().perform();  
		act.dragAndDrop(drag2,drop6).build().perform();  
		act.dragAndDrop(drag3,drop5).build().perform();  
		act.dragAndDrop(drag3,drop7).build().perform();  
		act.dragAndDrop(drag1,drop10).build().perform();  
		act.dragAndDrop(drag2,drop8).build().perform();  
		act.dragAndDrop(drag3,drop9).build().perform();  
		act.dragAndDrop(drag3,drop7).build().perform();



		return this;
	}// DragAndDrop end

   
}// AttendanceTimetableCreationPages class end