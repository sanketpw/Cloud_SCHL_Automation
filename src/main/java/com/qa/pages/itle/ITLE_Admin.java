package com.qa.pages.itle;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class ITLE_Admin extends BaseClass{
	
	
	public ITLE_Admin(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy (linkText = "Course/Subject") private WebElement courcesubject;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Course/Subject'])[1]/following::span[2]") private WebElement selectcoursesubject ;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Select Course/Subject'])[1]/following::span[1]") private WebElement selectcoursesubject1;			
	@FindBy (id = "ddlCourse") private WebElement selectcourse ;
	@FindBy (linkText = "BSC SEM 1 - 1 - ENGLISH - ENGLISH (BS) - 0.00") private WebElement Englishsubject;
    @FindBy (xpath = "/html/body/div[3]/aside[2]/section/div/div/div[1]/div[4]/div/div/div[9]/a/span") private WebElement test ;
    @FindBy (xpath = "//*[@id=\"btnAddTest\"]/span") private WebElement createtest ;//.....
    @FindBy (id = "txtSyllabus") private WebElement testtitle;
    @FindBy (id = "ddlTestType") private WebElement testscheduletype ;
    @FindBy (id = "txtStartDate") private WebElement teststartdate;
    @FindBy (css = "td.day.today.active") private WebElement selecttodayactivedate;
    @FindBy (id = "txtTestDuration") private WebElement testduration;   
    @FindBy (id = "txtTimeStar") private WebElement teststarttime;//start time
    @FindBy (xpath = "//div[@id='DivDashboard']/div/div") private WebElement selectstarttime;
    @FindBy (id = "ddlQuestionType") private WebElement typeofquestion  ;
   
    
    @FindBy (id = "lblAddQuestions") private WebElement setquestionpaper ;
    @FindBy (id = "txtNoSet") private WebElement noofpapersets ;
    @FindBy (id = "txtEasyUser") private WebElement easy;
    @FindBy (id = "txtDifficultyLevel") private WebElement objectivemarkperstudent;
    @FindBy (id = "btnOKModal") private WebElement submitbutton;
    @FindBy (id = "lblAddStudent") private WebElement assignexamtostudent  ;
    @FindBy (id = "IsAllStd") private WebElement assignexamcheckbox;
    @FindBy (id = "btnCount") private WebElement okbutton;
    @FindBy (id = "IsAfterResult") private WebElement  afterresulton;//new test
   
    @FindBy (id = "btnSave") private WebElement savebutton;

	//@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Course/Subject'])[1]/following::span[2]") private WebElement selectcoursesubject ;

    
    
	public ITLE_Admin openCourceSubject() //it will click on Course/Subject  first
	{
		System.out.println("Open Course/Subject");
		click(courcesubject);
		return this;
	}
	
	public ITLE_Admin openSelectCourseSubject () // it will click on Select Course subject first
	{
		System.out.println("Click on Select Course");
		click(selectcoursesubject);
		return this;
	}
	
	public ITLE_Admin openSelectCourseSubject1 () // it will click on Select Course subject first
	{
		System.out.println("Click on Select Course");
		click(selectcoursesubject1);
		return this;
	}
	
	
	public ITLE_Admin selectCourseSubject() {
		System.out.println("Select Course");
        Select ddl = new Select(selectcourse);
        ddl.selectByVisibleText("BSC SEM 2");
        return this;
	}
	
	public ITLE_Admin openEnglishSubject() //it will click on English/Subject  first
	{
		System.out.println("Open English/Subject");
		click(Englishsubject);
		return this;
	}
	
	public ITLE_Admin Test() //it will click on Test  first
	{
		System.out.println("Open Test");
		click(test);
		return this;
	}

	public ITLE_Admin createTest() //it will click on Test  first
	{
		System.out.println("Create Test");
		click(createtest);
		return this;
	}
	
	public ITLE_Admin enterTestTitle()
	{
		System.out.println("Enter Test Title ");
		sendKeys(testtitle, "Augut_30_05:00");
		return this;
	}
	
	public ITLE_Admin testScheduleType() {
		System.out.println("Select Schedule Type '");
        Select ddl = new Select(testscheduletype);
        ddl.selectByVisibleText("Non-Flexible");
        return this;
	}
	
	public ITLE_Admin selectTestStartDate()
	{
		System.out.println("Select Test Start Date");
		click(teststartdate);
		click(selecttodayactivedate);
		return this;
	}
	
	public ITLE_Admin enterTestDuration()
	{
		System.out.println("Enter Test Duration ");
		sendKeys(testduration, "01:00");
		return this;
	}

	
	public ITLE_Admin selectStartTime()
	{
		System.out.println("Enter Current Time -" + GetCurrentTime());
		sendKeys(teststarttime, GetCurrentTime());
		teststarttime.sendKeys(Keys.SPACE, Keys.ENTER);
		return this;
	}
	

	


	public ITLE_Admin selectQuestionType() {
		System.out.println("Select Question Type");
        Select ddl = new Select(typeofquestion);
        ddl.selectByVisibleText("Objective");
        return this;
	}
	
	public ITLE_Admin SetQuestionPaper() //it will click on Set Question paper
	{
		System.out.println("Creat eTest");
		click(setquestionpaper);
		return this;
	}
	
	public ITLE_Admin EnterNoOfPaperSets()
	{
		System.out.println("Enter Paper Set ");
		sendKeys(noofpapersets, "1");
		return this;
	}
	
	public ITLE_Admin EnterEasyQuestion()
	{
		System.out.println("Enter Easy Question Set ");
		sendKeys(easy, "1");
		return this;
	}
	
	public ITLE_Admin EnterObjectiveMarkPerStudent()
	{
		System.out.println("Enter Marks Per Student");
		sendKeys(objectivemarkperstudent, "1");
		return this;
	}
	
	public ITLE_Admin clickOnSubmitButton()
	{
		System.out.println("Click On Submit Button");
		click(submitbutton);;
		return this;
	}
	
	public ITLE_Admin OpenAssignExam() //it will click on Course/Subject  first
	{
		System.out.println("Open Course/Subject");
		click(assignexamtostudent);
		return this;
	}
	
	public ITLE_Admin AssignExamCheckBox() //it will check box
	{
		System.out.println("click sellect all check box");
		
		if (assignexamcheckbox.isSelected())
		{

			System.out.println("Checkbox is checked");
		}	
		else
		{
			System.out.println("Checkbox is not checked");
			click(assignexamcheckbox);

		}

		
		return this;
	}
	
	public ITLE_Admin clickOnOkButton()
	{
		System.out.println("Click On Submit Button");
		scrollIntoView(okbutton, 0, 500);
		click(okbutton);
		return this;
	}
	public ITLE_Admin clickOnAfterResultOn()// new function
	{
		System.out.println("Click On Submit Button");
		click(afterresulton);;
		return this;
	}
	
	
	public ITLE_Admin clickOnSaveButton()
	{
		System.out.println("Click On Submit Button");
		click(savebutton);;
		return this;
	}
	
	public ITLE_Admin getAllertText()
	{
		getAllertText();
		return this;
	}
}
	//*[@id="list-to-filter"]/a/span[1]

//*[@id="btnId"]/span
