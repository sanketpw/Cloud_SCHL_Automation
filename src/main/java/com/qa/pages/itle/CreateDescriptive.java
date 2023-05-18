package com.qa.pages.itle;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class CreateDescriptive extends BaseClass{
	
	
	public CreateDescriptive(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy (linkText = "Course/Subject") private WebElement courcesubject;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Course/Subject'])[1]/following::span[2]") private WebElement selectcoursesubject ;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Select Course/Subject'])[1]/following::span[1]") private WebElement selectcoursesubject1;			
	@FindBy (id = "ddlCourse") private WebElement selectcourse ;
	@FindBy (linkText = "BSC SEM 2 - ENG - ENGLISH -I (TH) - 0.00") private WebElement Englishsubject;
	  
    @FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Import Obj. Que.'])[1]/following::span[1]") private WebElement test ;
    @FindBy (xpath = "//button[@id='btnAddTest']/span") private WebElement createtest ;
    @FindBy (id = "txtSyllabus") private WebElement testtitle;
    @FindBy (id = "ddlTestType") private WebElement testscheduletype ;
    @FindBy (id = "txtStartDate") private WebElement teststartdate;
    @FindBy (css = "td.day.today.active") private WebElement selecttodayactivedate;
    @FindBy (id = "txtTestDuration") private WebElement testduration;   
    @FindBy (id = "txtTimeStar") private WebElement teststarttime;//start time
 //   @FindBy (xpath = "//div[@id='DivDashboard']/div/div") private WebElement selectstarttime;
    @FindBy (id = "ddlQuestionType") private WebElement typeofquestion  ;  
    @FindBy (id = "lblAddQuestions") private WebElement setquestionpaper  ;
    @FindBy (id = "txtNoSet") private WebElement noofpapersets;
    @FindBy (id = "txtEasyUserDes") private WebElement easy;
    @FindBy (id = "txtDifficultyLevel") private WebElement objectivemarkperstudent;
    @FindBy (id = "btnOKModal") private WebElement submitbutton;
   @FindBy (id = "lblAddStudent") private WebElement assignexamtostudent  ;
    @FindBy (id = "IsAllStd") private WebElement assignexamcheckbox;
    @FindBy (id = "btnCount") private WebElement okbutton;

    @FindBy (id = "btnSave") private WebElement savebutton;

	//@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Course/Subject'])[1]/following::span[2]") private WebElement selectcoursesubject ;

    
    
	public CreateDescriptive openCourceSubject() //it will click on Course/Subject  first
	{
		System.out.println("Open Course/Subject");
		click(courcesubject);
		return this;
	}
	
	public CreateDescriptive openSelectCourseSubject () // it will click on Select Course subject first
	{
		System.out.println("Click on Select Course");
		click(selectcoursesubject);
		return this;
	}

	public CreateDescriptive openSelectCourseSubject1 () // it will click on Select Course subject first
	{
		System.out.println("Click on Select Course");
		click(selectcoursesubject1);
		return this;
	}
	
	
	public CreateDescriptive selectCourseSubject() {
		System.out.println("Select Course");
        Select ddl = new Select(selectcourse);
        ddl.selectByVisibleText("BSC SEM 2");
        return this;
	}
	
	public CreateDescriptive openEnglishSubject() //it will click on English/Subject  first
	{
		System.out.println("Open English/Subject");
		click(Englishsubject);
		return this;
	}
	public CreateDescriptive Test() //it will click on Test  first
	{
		System.out.println("Open Test");
		click(test);
		return this;
	}

	public CreateDescriptive createTest() //it will click on Test  first
	{
		System.out.println("Create Test");
		click(createtest);
		return this;
	}
	
	public CreateDescriptive enterTestTitle()
	{
		System.out.println("Enter Test Title ");
		sendKeys(testtitle, "Augut_30_6:45");
		return this;
	}
	
	public CreateDescriptive testScheduleType() {
		System.out.println("Select Schedule Type '");
        Select ddl = new Select(testscheduletype);
       ddl.selectByVisibleText("Non-Flexible");
        return this;
	}
	
	public CreateDescriptive selectTestStartDate()
	{
		System.out.println("Select Test Start Date");
		click(teststartdate);
		click(selecttodayactivedate);
		return this;
	}
	
	public CreateDescriptive enterTestDuration()
	{
		System.out.println("Enter Test Duration ");
		sendKeys(testduration, "01:00");
		return this;
	}

	
	public CreateDescriptive selectStartTime()
    {
        System.out.println("Enter Current Time -" + GetCurrentTime());
        sendKeys(teststarttime, GetCurrentTime());
        teststarttime.sendKeys(Keys.SPACE, Keys.ENTER);//selection for AM/PM
        return this;
    }
	
//	public CreateDescriptiveTest TestDate() throws InterruptedException
//	{
//		//Displaying current time in 12 hour format with AM/PM
//        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
//        String dateString = dateFormat.format(new Date()).toString();
//        System.out.println("Current time in AM/PM: "+dateString);
//        sendKeys(teststarttime,dateString );
//        return this;
//	}
	

	public CreateDescriptive selectQuestionType() {
		System.out.println("Select Question Type");
        Select ddl = new Select(typeofquestion);
        ddl.selectByVisibleText("Descriptive");
        return this;
	}
	
	public CreateDescriptive SetQuestionPaper() //it will click on Set Question paper
	{
		System.out.println("Creat eTest");
		click(setquestionpaper);
		return this;
	}
	
	public CreateDescriptive EnterNoOfPaperSets()
	{
		System.out.println("Enter Paper Set ");
		sendKeys(noofpapersets, "1");
		return this;
	}
	
	public CreateDescriptive EnterEasyQuestion()
	{
		System.out.println("Enter Easy Question Set ");
		sendKeys(easy, "2");
		return this;
	}
	
	public CreateDescriptive EnterObjectiveMarkPerStudent()
	{
		System.out.println("Enter Marks Per Student");
		sendKeys(objectivemarkperstudent, "2");
		return this;
	}
	
	public CreateDescriptive clickOnSubmitButton()
	{
		System.out.println("Click On Submit Button");
		click(submitbutton);;
		return this;
	}
	
	public CreateDescriptive OpenAssignExam() //it will click on Course/Subject  first
	{
		System.out.println("Open Course/Subject");
		click(assignexamtostudent);
		return this;
	}
	
	public CreateDescriptive AssignExamCheckBox() //it will check box
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
	
	public CreateDescriptive clickOnOkButton()
	{
		System.out.println("Click On Submit Button");
		scrollToElement(okbutton);
		click(okbutton);;
		return this;
	}
	
	public CreateDescriptive clickOnSaveButton()
	{
		System.out.println("Click On Save Button");
		click(savebutton);;
		return this;
	}
	
//	public CreateDescriptiveTest getAllertText()
//	{
//		
//		return this;
//	}
}
	//*[@id="list-to-filter"]/a/span[1]

//*[@id="btnId"]/span
