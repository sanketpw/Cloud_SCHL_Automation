package com.qa.pages.attendance;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class Attendance extends BaseClass
{

	public Attendance(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy (xpath = "//*/text()[normalize-space(.)='Transaction']/parent::*") private WebElement transaction;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Registration']/parent::*") private WebElement registration;
	@FindBy (id = "ddlAttendanceSession") private WebElement selectattendancesession;
	@FindBy (id = "ddlBasicCourse") private WebElement selectbasiccourse;
	@FindBy (id = "ddlCourse") private WebElement selectcourse;
	@FindBy (id = "ddlTheoryBatch") private WebElement selecttheorybatch;
	@FindBy (id = "success") private WebElement confirmationmessage;
	@FindBy (id = "btnSubmitSpan") private WebElement submitbutton;
	@FindBy (id = "ddlPracticalBatch") private WebElement selectpracticalbatch;
	@FindBy (id = "ChkAll") private WebElement cheackallcheckbox;
	@FindBy (linkText = "Master") private WebElement master;
	@FindBy (linkText = "Common Master") private WebElement commonmaster;
	@FindBy (className = "day") private List<WebElement> day;
	@FindBy (xpath = "//li[@id='list-to-filter']/ul/li[2]/a/span") private WebElement batch ;
	@FindBy (id = "btnSubmit") private WebElement clicksubmitbutton ;
	@FindBy (id = "btnSave") private WebElement savebutton ;
	@FindBy (id = "txtAttendanceDate") private WebElement attendancedate ;
	@FindBy (xpath = "	//div[@class='datetimepicker-days']//th[@class='switch']") private WebElement month ;
	@FindBy (xpath = "//div[@class='datetimepicker-days']//th[@class='prev']") private WebElement prevmonth ;
	@FindBy (linkText = "Attendance") private WebElement attendance ;
	@FindBy (xpath = "//*/text()[normalize-space(.)='Student Attendance']/parent::*") private WebElement studentattendance ;
	@FindBy (id = "ddlAttendanceSession") private WebElement session ;
	@FindBy (xpath = "//li[3]/a/i") private WebElement clickhomeicon ;


	public Attendance OpenTransaction()
	{
		System.out.println("Open Transaction");
		click(transaction);
		return this;
	}// openTransaction end

	public Attendance OpenMaster()
	{
		System.out.println("Open Master");
		click(master);
		return this;
	}// OpenMaster end

	public Attendance OpenCommonMaster()
	{
		System.out.println("Open Common Master");
		click(commonmaster);
		return this;
	}// OpenCommonMaster end

	public Attendance OpenBatch()
	{
		System.out.println("Open Batch");
		click(batch);
		return this;
	}// OpenBatch end

	public Attendance ClickSubmitbutton()
	{
		System.out.println("click submit button");
		click(clicksubmitbutton);
		return this;
	}// openTransaction end

	public Attendance ClickSave()
	{
		System.out.println("Click save button");
		savebutton.click();
		return this;
	}// ClickSave end

	public Attendance OpenRegistration()
	{
		System.out.println("Open registration");
		click(registration);
		return this;
	}// openRegistration end

	public Attendance SelectAttendanceSession() 
	{
		System.out.println("Select Attendance Session 'ATTENDANCE SESSION'");
		Select ddl = new Select(selectattendancesession);
		ddl.selectByVisibleText("ATTENDANCE SESSION");
		return this;
	}//selectAttendanceSession end

	public Attendance SelectBasiccourse() 
	{
		System.out.println("Select 'Basic Course'");
		Select ddl = new Select(selectbasiccourse);
		ddl.selectByVisibleText("BSC SEM 1");
		return this;
	}//selectBasiccourse end

	public Attendance SelectCourse() 
	{
		System.out.println("Select Course ");
		Select ddl = new Select(selectcourse);
		ddl.selectByVisibleText("BSC SEM 1 - 1");
		return this;
	}//SelectCourse end

	public Attendance SelectTheoryBatch() 
	{
		System.out.println("Select Theory batch");
		Select ddl = new Select(selecttheorybatch);
		ddl.selectByVisibleText("BSC TH BATCH");
		return this;
	}//SelectTheoryBatch end

	public Attendance clicksubmitbutton()
	{
		System.out.println("click submit button");
		click(submitbutton);
		return this;
	}// clicksubmitbutton end

	public String verifyConfirmationMessage() 
	{
		String confirmationMsg = getText(confirmationmessage);
		System.out.println("Confirmation Message - " + confirmationMsg );
		return confirmationMsg;
	}// verifyConfirmationMessage end

	public Attendance SelectPracticalBatch() 
	{
		System.out.println("Select practical batch");
		Select ddl = new Select(selectpracticalbatch);
		ddl.selectByVisibleText("BSC PR BATCH");
		return this;
	}//SelectPracticalBatch end

	public Attendance CheackAllCheckbox()
	{
		System.out.println("Click checkall checkbox");
		click(cheackallcheckbox);
		return this;
	}// CheackAllCheckbox end

	public Attendance selectAttendanceDate()
	{
		System.out.println("Select Session End Date");
		click(attendancedate);

		while (!getText(month).contains("June")) 
		{
			click(prevmonth);
		}
		int count = day.size();

		for (int i = 0; i < count; i++) 
		{
			String text = day.get(i).getText();
			if (text.equalsIgnoreCase("21"))
			{
				day.get(i).click();
				break;
			}
		}
		return this;
	}// selectAttendanceDate end

	public Attendance clickOnAttendance() 
	{
		click(attendance);
		return this;
	}//clickOnAttendance end


	public Attendance openStudentAttendance() 
	{
		click(studentattendance);
		return this;
	}//openStudentAttendanceend

	public Attendance selectSession()
	{
		sendKeys(session, "ATTENDANCE SESSION");
		return this;
	}//selectSession end
	
	public Attendance ClickHomeIcon()
	{
		System.out.println("click home icon");
		click(clickhomeicon);
		return this;
	}// openRegistration end

	

	public void dropdown(String findby ,String locator, String visibletext )
	{
		switch(findby) 
		{
		case "id":
			Select commandrpdown = new Select(driver.findElement(By.id(locator)));
			commandrpdown.selectByVisibleText(visibletext);
			break;

		case "xpath":
			Select commandrpdown1 = new Select(driver.findElement(By.xpath(locator)));
			commandrpdown1.selectByVisibleText(visibletext);
			break;
		}//switch case end


	}//dropdown end

}// Attendance class end