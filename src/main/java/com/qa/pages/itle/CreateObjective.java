package com.qa.pages.itle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class CreateObjective extends BaseClass{
	
	
	public CreateObjective(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy (xpath = "/html/body/div[4]/aside[1]/section/ul/li[15]/a/span[1]") private WebElement selectitle;
//	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Course/Subject'])[1]/following::span[2]") private WebElement selectcoursesubject ;
//	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Select Course/Subject'])[1]/following::span[1]") private WebElement selectcoursesubject1;			
//	@FindBy (id = "ddlCourse") private WebElement selectcourse ;
//	@FindBy (linkText = "BSC SEM 1 - 1 - ENGLISH - ENGLISH (BS) - 0.00") private WebElement Englishsubject;
//    @FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Import Obj. Que.'])[1]/following::span[1]") private WebElement test ;
//    @FindBy (xpath = "//button[@id='btnAddTest']/span") private WebElement createtest ;
//    @FindBy (id = "txtSyllabus") private WebElement testtitle;
//    @FindBy (id = "ddlTestType") private WebElement testscheduletype ;
//    @FindBy (id = "txtStartDate") private WebElement teststartdate;
//    @FindBy (css = "td.day.today.active") private WebElement selecttodayactivedate;
//    @FindBy (id = "txtTestDuration") private WebElement testduration;   
//    @FindBy (id = "txtTimeStar") private WebElement teststarttime;//start time
//    @FindBy (xpath = "//div[@id='DivDashboard']/div/div") private WebElement selectstarttime;
//    @FindBy (id = "ddlQuestionType") private WebElement typeofquestion  ;
//    @FindBy (id = "lblAddQuestions") private WebElement setquestionpaper  ;
//    @FindBy (id = "txtNoSet") private WebElement noofpapersets;
//    @FindBy (id = "txtEasyUser") private WebElement easy;
//    @FindBy (id = "txtDifficultyLevel") private WebElement objectivemarkperstudent;
//    @FindBy (id = "btnOKModal") private WebElement submitbutton;
//    @FindBy (id = "lblAddStudent") private WebElement assignexamtostudent  ;
//    @FindBy (id = "IsAllStd") private WebElement assignexamcheckbox; 
//    @FindBy (xpath = "//input[@id='IsAfterResult']") private WebElement ShowResultAfterTest;//new line
    //@FindBy (xpath = "//*[@id=\"IsAfterResult\"]") private WebElement ShowResultAfterTest;//new xpath

    @FindBy (id = "btnCount") private WebElement okbutton;
    @FindBy (id = "btnSave") private WebElement savebutton;

	//@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Course/Subject'])[1]/following::span[2]") private WebElement selectcoursesubject ;

    
    
	public CreateObjective openItle() //it will click on Course/Subject  first
	{
		System.out.println("select ITLE Module");
		click(selectitle);
		return this;
	}
	
//	public CreateObjectiveTest openSelectCourseSubject () // it will click on Select Course subject first
//	{
//		System.out.println("Click on Select Course");
//		click(selectcoursesubject);
//		return this;
//	}
//	
//	public CreateObjectiveTest openSelectCourseSubject1 () // it will click on Select Course subject first
//	{
//		System.out.println("Click on Select Course");
//		click(selectcoursesubject1);
//		return this;
//	}
//	
//	public CreateObjectiveTest selectCourseSubject() {
//		System.out.println("Select Course '");
//        Select ddl = new Select(selectcourse);
//        ddl.selectByVisibleText("BSC SEM 1 - 1");
//        return this;
//	}
//	
//	public CreateObjectiveTest openEnglishSubject() //it will click on English/Subject  first
//	{
//		System.out.println("Open English/Subject");
//		click(Englishsubject);
//		return this;
//	}
//	
//	public CreateObjectiveTest Test() //it will click on Test  first
//	{
//		System.out.println("Open Test");
//		click(test);
//		return this;
//	}
//
//	public CreateObjectiveTest createTest() //it will click on Test  first
//	{
//		System.out.println("Create Test");
//		click(createtest);
//		return this;
//	}
//	
//	public CreateObjectiveTest enterTestTitle() throws Exception  
//	{
//		System.out.println("Enter Test Title ");
//		File file = new File(".\\src\\test\\resources\\excel\\TestsTitle.xlsx");
//        FileInputStream inputStream = new FileInputStream(file);
//        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
//            Sheet sheet = workbook.getSheetAt(0);
//            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();        // Find number of rows in excel file
//            System.out.println(rowCount);
//            for (int i = 29; i <=29; i++) {
//            Row row = sheet.getRow(i);
//            System.out.println(row.getCell(0).getStringCellValue());
//        sendKeys(testtitle, row.getCell(0).getStringCellValue());
//            }
//        }
//        return this;
//	}
//	
//	
//	public CreateObjectiveTest testScheduleType() {
//		System.out.println("Select Schedule Type '");
//        Select ddl = new Select(testscheduletype);
//        ddl.selectByVisibleText("Non-Flexible");
//        return this;
//	}
//	
//	public CreateObjectiveTest selectTestStartDate()
//	{
//		System.out.println("Select Test Start Date");
//		click(teststartdate);
//		click(selecttodayactivedate);
//		return this;
//	}
//	
//	public CreateObjectiveTest enterTestDuration()
//	{
//		System.out.println("Enter Test Duration ");
//		sendKeys(testduration, "03:00");
//		return this;
//	}
//
//	
//	public CreateObjectiveTest selectStartTime()
//    {
//        System.out.println("Enter Current Time -" + GetCurrentTime());
//        sendKeys(teststarttime, GetCurrentTime());
//        teststarttime.sendKeys(Keys.SPACE, Keys.ENTER);//selection for AM/PM
//        return this;
//    }
	
//	public ITLE_ELearning TestDate() throws InterruptedException
//	{
//		//Displaying current time in 12 hour format with AM/PM
//        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
//        String dateString = dateFormat.format(new Date()).toString();
//        System.out.println("Current time in AM/PM: "+dateString);
//        sendKeys(teststarttime,dateString );
//        return this;
//	}
	

//	public CreateObjectiveTest selectQuestionType() {
//		System.out.println("Select Question Type");
//        Select ddl = new Select(typeofquestion);
//        ddl.selectByVisibleText("Objective");
//        return this;
//	}
//	
//	public CreateObjectiveTest SetQuestionPaper() //it will click on Set Question paper
//	{
//		System.out.println("Creat eTest");
//		click(setquestionpaper);
//		return this;
//	}
//	
//	public CreateObjectiveTest EnterNoOfPaperSets()
//	{
//		System.out.println("Enter Paper Set ");
//		sendKeys(noofpapersets, "1");
//		return this;
//	}
//	
//	public CreateObjectiveTest EnterEasyQuestion()
//	{
//		System.out.println("Enter Easy Question Set ");
//		sendKeys(easy, "2");
//		return this;
//	}
//	
//	public CreateObjectiveTest EnterObjectiveMarkPerStudent()
//	{
//		System.out.println("Enter Marks Per Student");
//		sendKeys(objectivemarkperstudent, "2");
//		return this;
//	}
//	
//	public CreateObjectiveTest clickOnSubmitButton()
//	{
//		System.out.println("Click On Submit Button");
//		click(submitbutton);;
//		return this;
//	}
//	
//	public CreateObjectiveTest OpenAssignExam() //it will click on Course/Subject  first
//	{
//		System.out.println("Open Course/Subject");
//		click(assignexamtostudent);
//		return this;
//	}
//	
//	public CreateObjectiveTest AssignExamCheckBox() //it will check box
//	{
//		System.out.println("click sellect all check box");
//		
//		if (assignexamcheckbox.isSelected())
//		{
//
//			System.out.println("Checkbox is checked");
//		}	
//		else
//		{
//			System.out.println("Checkbox is not checked");
//			click(assignexamcheckbox);
//
//		}
//
//		
//		return this;
//	}
//	
//
//	public CreateObjectiveTest IsAfterResult() {
//		System.out.println("Enter IsAfterResult");
//		click(ShowResultAfterTest);
//		return this;
//	}
	
	
//	public CreateObjectiveTest clickOnOkButton()
//	{
//		System.out.println("Click On Submit Button");
//		scrollToElement(okbutton);;
//		click(okbutton);;
//		return this;
//	}
//	
//	public CreateObjectiveTest clickOnSaveButton()
//	{
//		System.out.println("Click On Submit Button");
//		click(savebutton);;
//		return this;
//	}
//	
//	public CreateObjectiveTest getAllertText()
//	{
//		
//		return this;
//	}
}
	//*[@id="list-to-filter"]/a/span[1]
//*[@id="btnId"]/span
