package com.qa.pages.attendance;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class StudentAttendance extends BaseClass
{
	
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Student Attendance Registration'])[1]/following::span[1]") private WebElement opentimetable;


	public StudentAttendance(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Time Table Import By Excel'])[1]/following::span[1]") private WebElement attendance;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Start Online Class'])[1]/following::span[1]") private WebElement studentattendance;

	@FindBy (className = "day") private List<WebElement> day;
    @FindBy (id = "txtAttendanceDate") private WebElement attendancedate ;
    @FindBy (xpath = "    //div[@class='datetimepicker-days']//th[@class='switch']") private WebElement month ;
    @FindBy (xpath = "//div[@class='datetimepicker-days']//th[@class='prev']") private WebElement prevmonth ;
    
    @FindBy (id = "ddlClassType") private WebElement classtype ;
    
    @FindBy (xpath = "//div[@id='divSubject']/div/div[2]/div/button/span") private WebElement selectsubjectname ;
    @FindBy (xpath = "//input[@value='48795~223516~0~4718~0~33014~0']") private WebElement selectsubjectoption ;
    @FindBy (id = "txtRemark") private WebElement topiccovered ;
    @FindBy (id = "ddlAttStatus") private WebElement defaultstatus ;
    @FindBy (id = "btnConfirm") private WebElement confirm ;
    @FindBy (xpath = "//button[@id='btnNo']/span") private WebElement cancelpopup ;
    @FindBy (xpath = "//button[@id='btnSubmit']/span") private WebElement submitpopup ;

	public StudentAttendance OpenAttendance()
	{
		System.out.println("Open Attendance");
		click(attendance);
		return this;
	}// OpenAttendance  end
	
	
	public StudentAttendance OpenStudentAttendance()
	{
		System.out.println("Open Student Attendance");
		click(studentattendance);
		return this;
	}// OpenStudentAttendance  end
	
	
	
	
	public StudentAttendance SelectAttendanceDate()
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
	
	
	public StudentAttendance OpenClassType()
	{
		System.out.println("Select Class type");
		Select ddl = new Select(classtype);
		ddl.selectByVisibleText("REGULAR LECTURE");
		return this;
	}// EnterSessionStartDate end
	
	public StudentAttendance SelectSubjectName()
	{
		System.out.println("Select  subject name");
		selectsubjectname.click();
		selectsubjectoption.click();
		return this;
	}// SelectSubjectName end
	
	public StudentAttendance SelectDefaultStatus(String attendanceoption)
	{
		System.out.println("Select default status name");
		Select ddl = new Select(defaultstatus);
		ddl.selectByVisibleText(attendanceoption);
		return this;
	}// SelectDefaultStatus end
	
	public StudentAttendance ClickConfirmbutton()
	{
		System.out.println("Click confirm");
		confirm.click();
		return this;
	}// ClickConfirmbutton end
	
	public StudentAttendance EnterTopicCovered(String topics)
	{
		System.out.println("Enter topic covered");
		sendKeys(topiccovered,topics);
		return this;
	}// SelectSubjectName end
	
	public StudentAttendance ClickCancelPopup()
	{
		System.out.println("Click cancel button on popup");
		click(cancelpopup);
		return this;
	}// ClickCancelPopup  end
	
	public StudentAttendance ClickSubmitPopup()
	{
		System.out.println("Click submit button on popup");
		click(submitpopup);
		return this;
	}// OpenStudentAttendance  end

	


	

   
}// AttendanceStudentAttendancePages class end