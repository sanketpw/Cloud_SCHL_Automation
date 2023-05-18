package com.qa.pages.attendance;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class StudentDayorderAttendance extends BaseClass
{
	
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Student Attendance Registration'])[1]/following::span[1]") private WebElement opentimetable;


	public StudentDayorderAttendance(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy (linkText  = "Day Order Student Attendance") private WebElement dayorderattendance;

	@FindBy (xpath = "//*/text()[normalize-space(.)='Attendance']/parent::*") private WebElement attendance;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Start Online Class'])[1]/following::span[1]") private WebElement studentattendance;

	@FindBy (className = "day") private List<WebElement> day;
    @FindBy (id = "txtAttendanceDate") private WebElement attendancedate ;
    @FindBy (xpath = "    //div[@class='datetimepicker-days']//th[@class='switch']") private WebElement month ;
    @FindBy (xpath = "//div[@class='datetimepicker-days']//th[@class='prev']") private WebElement prevmonth ;
    
    @FindBy (id = "ddlClassType") private WebElement classtype ;
    
    @FindBy (xpath = "//div[@id='divSubject']/div/div[2]/div/button/span") private WebElement selectsubjectname ;
    @FindBy (xpath = "/html/body/div[3]/aside[2]/section/div[1]/div/div/div[2]/div[3]/div[3]/div[1]/div[1]/div/div[2]/div/ul/li[2]/a/label/input") private WebElement selectsubjectoption ;
    //@FindBy (xpath = "//input[@value='48795~223516~0~4718~0~33014~0']") private WebElement selectsubjectoption ;
    @FindBy (id = "txtRemark") private WebElement topiccovered ;
    @FindBy (id = "ddlAttStatus") private WebElement defaultstatus ;
    @FindBy (id = "btnConfirm") private WebElement confirm ;
    @FindBy (xpath = "//button[@id='btnNo']/span") private WebElement cancelpopup ;
    @FindBy (xpath = "//button[@id='btnSubmit']/span") private WebElement submitpopup ;
    
    
    public StudentDayorderAttendance SelectdayorderAttendance()
	{
		System.out.println("Open dayorderattendance");
		click(dayorderattendance);
		return this;
	}// OpenAttendance  end
	
    

	public StudentDayorderAttendance OpenAttendance()
	{
		System.out.println("Open Attendance");
		click(attendance);
		return this;
	}// OpenAttendance  end
	
	
	public StudentDayorderAttendance OpenStudentAttendance()
	{
		System.out.println("Open Student Attendance");
		click(studentattendance);
		return this;
	}// OpenStudentAttendance  end
	
	
	
	
	public StudentDayorderAttendance SelectAttendanceDate()
	{
        System.out.println("Select Session End Date");
        click(attendancedate);

        while (!getText(month).contains("June")) {
        click(prevmonth);
        }
        int count = day.size();

        for (int i = 0; i < count; i++) {
        String text = day.get(i).getText();
        if (text.equalsIgnoreCase("21")) {
            day.get(i).click();
            break;
            }
        }
        return this;
        }// SelectAttendanceDate end
	
	
	public StudentDayorderAttendance OpenClassType()
	{
		System.out.println("Select Class type");
		Select ddl = new Select(classtype);
		ddl.selectByVisibleText("REGULAR LECTURE");
		return this;
	}// EnterSessionStartDate end
	
	public StudentDayorderAttendance SelectSubjectName()
	{
		System.out.println("Select  subject name");
		selectsubjectname.click();
		selectsubjectoption.click();
		return this;
	}// SelectSubjectName end
	
	public StudentDayorderAttendance SelectDefaultStatus(String attendanceoption)
	{
		System.out.println("Select default status name");
		Select ddl = new Select(defaultstatus);
		ddl.selectByVisibleText(attendanceoption);
		return this;
	}// SelectDefaultStatus end
	
	public StudentDayorderAttendance ClickConfirmbutton()
	{
		System.out.println("Click confirm");
		confirm.click();
		return this;
	}// ClickConfirmbutton end
	
	public StudentDayorderAttendance EnterTopicCovered(String topics)
	{
		System.out.println("Enter topic covered");
		sendKeys(topiccovered,topics);
		return this;
	}// SelectSubjectName end
	
	public StudentDayorderAttendance ClickCancelPopup()
	{
		System.out.println("Click cancel button on popup");
		click(cancelpopup);
		return this;
	}// ClickCancelPopup  end
	
	public StudentDayorderAttendance ClickSubmitPopup()
	{
		System.out.println("Click submit button on popup");
		click(submitpopup);
		return this;
	}// OpenStudentAttendance  end

	


	

   
}// AttendanceStudentAttendancePages class end