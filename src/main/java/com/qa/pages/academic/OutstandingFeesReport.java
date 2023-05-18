package com.qa.pages.academic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class OutstandingFeesReport extends BaseClass{
	
	public OutstandingFeesReport(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "ddlSession") private WebElement session;
	@FindBy (id = "ddlCashBook") private WebElement receiptbook;
	@FindBy (id = "ddlBasicCourse") private WebElement basiccourse;
	@FindBy (id = "ddlCourse") private WebElement course;
	@FindBy (id = "ddlFeeType") private WebElement feetype;
	@FindBy (id = "ddlStudentType") private WebElement studenttype;
	@FindBy (id = "ddlMedium") private WebElement medium;
	@FindBy (id = "ddlOrderBy") private WebElement orderby;
	@FindBy (id = "ddlSession") private WebElement outstandingtype;
	@FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='All Student'])[2]/following::label[1]") private WebElement allstudent;
	@FindBy (id = "ddlReportType") private WebElement reporttype;	
	@FindBy (id = "ddlReportFormat") private WebElement reportformat;
	@FindBy (id = "rbAllOutstanding") private WebElement alloutstanding;
	@FindBy (id = "rbOnlyOutstanding") private WebElement onlyoutstanding;
	@FindBy (id = "txtTillDate") private WebElement tilldate;
	@FindBy (css = "td.day.today.active") private WebElement activedate;

	@FindBy (id = "btnReport") private WebElement reportbutton;

	
	
	
	public OutstandingFeesReport selectSession() {
		System.out.println("Select Session");
		Select ddl = new Select(session);
		ddl.selectByVisibleText("2022-2023");
		return this;
	}
	
	public OutstandingFeesReport selectReceiptBook() {
		System.out.println("Select Receipt Book");
		Select ddl = new Select(receiptbook);
		ddl.selectByVisibleText("ADMISSION FEE");
		return this;
	}
	
	public OutstandingFeesReport selectBasicCourse() {
		System.out.println("Select Basic Course");
		Select ddl = new Select(basiccourse);
		ddl.selectByVisibleText("B.COM");
		return this;
	}
	
	public OutstandingFeesReport selectCourse() {
		System.out.println("Select Course");
		Select ddl = new Select(course);
		ddl.selectByVisibleText("STANDARD-5");
		return this;
	}
	
	public OutstandingFeesReport selectFeeType() {
		System.out.println("Select Fee Type");
		Select ddl = new Select(feetype);
		ddl.selectByVisibleText("REGULAR");
		return this;
	}
	
	
	public OutstandingFeesReport selectStudentType() {
		System.out.println("Select Student Type");
		Select ddl = new Select(studenttype);
		ddl.selectByVisibleText("REGULAR");
		return this;
	}
	

	
	public OutstandingFeesReport selectMedium() {
		System.out.println("Select Medium");
		Select ddl = new Select(medium);
		ddl.selectByVisibleText("ENGLISH");
		return this;
	}
	

	public OutstandingFeesReport selectSection() {
		System.out.println("Select Section");
		Select ddl = new Select(course);
		ddl.selectByVisibleText("A");
		return this;
	}
	
	
	public OutstandingFeesReport selectOrderBy() {
		System.out.println("Select Order By");
		Select ddl = new Select(orderby);
		ddl.selectByVisibleText("Student Id");
		return this;
	}
	
	
	public OutstandingFeesReport selectOutstandingType() {
		System.out.println("Select Outstanding Type");
		click(outstandingtype);
		click(allstudent);;
		return this;
	}
	
	
	public OutstandingFeesReport selectReportType() {
		System.out.println("Select Report Type");
		Select ddl = new Select(reporttype);
		ddl.selectByVisibleText("Detailed");
		return this;
	}
	
	
	public OutstandingFeesReport selectReportFormat() {
		System.out.println("Select Report Format");
		Select ddl = new Select(reportformat);
		ddl.selectByVisibleText("Format1 (50 Heads)");
		return this;
	}
	
	
	public OutstandingFeesReport selectOutstandingOption() {
		System.out.println("Select Outstanding Option");
		click(alloutstanding);
		return this;
	}
	
	
	public OutstandingFeesReport enterPayAmtTillDate() {
		System.out.println("Select Pay Amt Till Date");
		click(tilldate);
		click(activedate);
		return this;
	}
	
	
	public OutstandingFeesReport clickOnReport() {
		System.out.println("Click On Report");
		click(reportbutton);
		return this;
	}
	
}