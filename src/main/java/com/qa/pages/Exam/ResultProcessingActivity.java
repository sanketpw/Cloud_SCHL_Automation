package com.qa.pages.Exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;


public class ResultProcessingActivity  extends BaseClass {
	
	@FindBy (id = "ddlSession") private WebElement ExamSession;
	@FindBy (id = "ddlBasicCourse") private WebElement BasicCourse;
	@FindBy (id = "ddlCourse") private WebElement Course;
	@FindBy (id = "Export") private WebElement ClickMarkProcessing;
	@FindBy (id = "btnSubmit") private WebElement Submit;
	@FindBy (id = "alerts") private WebElement ConfirmationMessage;
	@FindBy (id = "Gracing") private WebElement ClickGracing;
	@FindBy (id = "ddlGracingtype") private WebElement GracingType;
	@FindBy (id = "ddlCategory") private WebElement GracingCategory;
	@FindBy (id = "Grading") private WebElement ClickGrading;
	@FindBy (id = "ddlGradePattern") private WebElement GradePattern;
	@FindBy (id = "ddlGradingtype") private WebElement GradingType;
	@FindBy (id = "Result") private WebElement ClickResultProcessing;
	@FindBy (id = "ddlFacultyType") private WebElement FacultyType;
	@FindBy (id = "txtResultDate") private WebElement ResultDate;
	@FindBy (id = "btnSubmitSpan") private WebElement FinalSubmit;
	@FindBy (id = "ddlCategoryResult") private WebElement ResultCategory;
	
	
	public ResultProcessingActivity(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public ResultProcessingActivity ExamSession() {
		System.out.println("Select ExamSession");
		Select ddl = new Select(ExamSession);
		ddl.selectByVisibleText("ES_2021-2020(NEW1)");
		return this;
	}
	
	public ResultProcessingActivity BasicCourse() {
		System.out.println("Select BasicCourse");
		Select ddl = new Select(BasicCourse);
		ddl.selectByVisibleText("B.COM");
		return this;
	}
	
	public ResultProcessingActivity Course() {
		System.out.println("Select Course");
		Select ddl = new Select(Course);
		ddl.selectByVisibleText("B.COM - 1");
		return this;
	}

	public ResultProcessingActivity ClickMarkProcessing() {
		System.out.println("Click MarkProcessing");
		click(ClickMarkProcessing);
		return this;
	}
	
	public ResultProcessingActivity Submit() {
		System.out.println("Click Submit for MarkProcesing");
		click(Submit);
		return this;
	}
	
	public String verifyConfirmationMessage() {
		String confirmationMsg = getText(ConfirmationMessage);
		System.out.println("Confirmation Message - " + confirmationMsg );
		return confirmationMsg;
	}
	
	public ResultProcessingActivity ClickGracing() {
		System.out.println("Click ClickGracing");
		click(ClickGracing);
		return this;}
	
	public ResultProcessingActivity GracingType(String a) {
		System.out.println("Select GracingType");
		Select ddl = new Select(GracingType);
		ddl.selectByVisibleText(a);
		return this;
	}

	public ResultProcessingActivity GracingCategory(String a) {
		System.out.println("Select GracingCategory");
		Select ddl = new Select(GracingCategory);
		ddl.selectByVisibleText(a);
		return this;
	}
	
	public ResultProcessingActivity ClickGrading() {
		System.out.println("Click ClickGrading");
		click(ClickGrading);
		return this;
	}
	
	public ResultProcessingActivity GradePattern(String a) {
		System.out.println("Select GradePattern");
		Select ddl = new Select(GradePattern);
		ddl.selectByVisibleText(a);
		return this;
	}
	
	public ResultProcessingActivity GradingType(String a) {
		System.out.println("Select GradingType");
		Select ddl = new Select(GradingType);
		ddl.selectByVisibleText(a);
		return this;
	}
	
	public ResultProcessingActivity ClickResultProcessing() {
		System.out.println("Click ResultProcessing");
		click(ClickResultProcessing);
		return this;
	}
	
	public ResultProcessingActivity ResultCategory(String a) {
		System.out.println("Select ResultCategory");
		Select ddl = new Select(ResultCategory);
		ddl.selectByVisibleText(a);
		return this;
	}
	
	public ResultProcessingActivity FacultyType(String a) {
		System.out.println("Select FacultyType");
		Select ddl = new Select(FacultyType);
		ddl.selectByVisibleText(a);
		return this;
	}
	
	public ResultProcessingActivity ResultDate(String d) {
		System.out.println("Select ResultDate");
		sendKeys(ResultDate, d);
		return this;
	}
	
	public ResultProcessingActivity FinalSubmit() {
		System.out.println("Click FinalSubmit");
		click(FinalSubmit);
		return this;
	}
	
	
	public ResultProcessingActivity StartMarkProcessing() throws IOException, Exception {
		Workbook workbook = null;
		String fileName = "StudentAdm.xlsx";
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		File file = new File(".//src//test//resources//excel//ResultProcessing.xlsx");
		FileInputStream inputStream = new FileInputStream(file);	
		ClassLoader classloader =
				   org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
				URL resPath = classloader.getResource(
				         "org/apache/poi/poifs/filesystem/POIFSFileSystem.class");
				String path = resPath.getPath();
				System.out.println("The actual POI Path is " + path);
		if (fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		}

		else if (fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		}
		
		Sheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();		// Find number of rows in excel file
		System.out.println(rowCount); 
		for (int i = 0; i <=rowCount ; i++) {
		 ExamSession();
		 BasicCourse();
		 Course();
		 ClickMarkProcessing();
		 Submit();
		 verifyConfirmationMessage();
		 Thread.sleep(2000);		
		 ClickGracing();
		 Row row = sheet.getRow(i);
		 GracingType(row.getCell(0).getStringCellValue());
		 GracingCategory(row.getCell(1).getStringCellValue());
		 Submit();
		 verifyConfirmationMessage();
		 Thread.sleep(2000);		
		 ClickGrading();
		 GradePattern(row.getCell(2).getStringCellValue());
		 GradingType(row.getCell(3).getStringCellValue());
		 Submit();
		 Thread.sleep(2000);		
		 ClickResultProcessing();
		 GradePattern(row.getCell(2).getStringCellValue());
		 ResultCategory(row.getCell(1).getStringCellValue());
		 FacultyType(row.getCell(4).getStringCellValue());
		 ResultDate(row.getCell(5).getStringCellValue());
		 ResultDate.sendKeys(Keys.ENTER);
		 Thread.sleep(2000);		
		 Submit();
		 verifyConfirmationMessage();
		 }
		return this;
	}
	
	
}
