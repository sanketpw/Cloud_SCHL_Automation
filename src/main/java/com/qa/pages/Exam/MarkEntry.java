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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseClass;

public class MarkEntry extends BaseClass {
	
	public MarkEntry  (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "ddlSession") private WebElement ExamSession;
	@FindBy (id = "ddlBasicCourse") private WebElement BasicCourse;
	@FindBy (id = "ddlCourse") private WebElement Course;
	@FindBy (id = "ddlSubject") private WebElement Subject;
	@FindBy (id = "ddlExam") private WebElement ExamName;
	@FindBy (id = "btnSubmit") private WebElement SubmitBtn;
	@FindBy (id = "btnLock") private WebElement LockBtn;	
	
	
	public MarkEntry ExamSession() {
		System.out.println("Select Exam Session");
		Select ddl = new Select(ExamSession);
		ddl.selectByVisibleText("ES_2021-2020(NEW1)");
		return this;
	}
	
	public MarkEntry BasicCourse() {
		System.out.println("Select BasicCourse");
		Select ddl = new Select(BasicCourse);
		ddl.selectByVisibleText("B.COM");
		return this;
		}
		
		public MarkEntry Course() {
			System.out.println("Select Exam Course");
			Select ddl = new Select(Course);
			ddl.selectByVisibleText("B.COM - 1");
			return this;
			}
		public MarkEntry Subject(String sub) {
			System.out.println("Select Exam Subject");
			Select ddl = new Select(Subject);
			ddl.selectByVisibleText(sub);
			
//			 List<WebElement> dd = ddl.getOptions();
//
//			    //Get the length
//			    System.out.println(dd.size());
//
//			    // Loop to print one by one
//			    for (int j = 0; j < dd.size();) {
//			    	int A = 1;
//			    	 if (j > A)
//			            {
//			                j = A;
//			            }
//			    	 
//			        System.out.println(dd.get(A).getText());
//			        ddl.selectByVisibleText(dd.get(A).getText());
//			        break;
//			        }
			
			return this;
			
			}
		
		public MarkEntry ExamName(String E) {
			try {
				System.out.println("Select Exam ExamName");
				Select ddl = new Select(ExamName);
				ddl.selectByVisibleText(E);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
			}
		
		public MarkEntry Submit() {
			System.out.println("Click on Submit");
			click(SubmitBtn);			
			return this;
			}
		
		public MarkEntry LockBtn() {
			System.out.println("Click on Lock");
			click(LockBtn);			
			return this;
			}
		
		public MarkEntry EnterMarkEntry(String a,String b) throws Exception {
			System.out.println("EnterMarkEntry");
			 //driver.findElement(By.name("txtMarks3001226")).click();
			Thread.sleep(1000);
			WebElement StudMarktText = driver.findElement(By.name("txtMarks"+a));
			StudMarktText.clear();
			StudMarktText.click();
			Thread.sleep(1000);
			StudMarktText.sendKeys(b);			
			 //driver.findElement(By.name("txtMarks3001226")).sendKeys(b);
			 //driver.findElement(By.name("txtMarks3001227")).click();
			 //driver.findElement(By.name("txtMarks3001227")).sendKeys(a);
			return this;		
			}	
		
				
		
		public MarkEntry MarkEntry1() throws IOException, Exception {
			System.out.println("Whole Mark entry");
			
			ExamSession();
			BasicCourse();
			Course();		
			Thread.sleep(1000);	
			Subject("OC->OC -> Cr -");
			Thread.sleep(1000);	
			
			Workbook workbook = null;
			String fileName = "StudentsMarks3.xlsx";
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			File file = new File(".//src//test//resources//excel//StudentsMarks3.xlsx");
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
			
			//ExamName();			
			//EnterMarkEntry();
			Row row = sheet.getRow(i);
			ExamName(row.getCell(0).getStringCellValue());
			Row row1 = sheet.getRow(i);
			EnterMarkEntry(row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue());			
			Thread.sleep(1000);
			Submit();
			
			
			try {
				WebDriverWait wait = new WebDriverWait(driver, 30 /*timeout in seconds*/);
				if(wait.until(ExpectedConditions.alertIsPresent())==null) {  
				    System.out.println("alert was not present");
				   
				} else {
				    Alert alert = driver.switchTo().alert();
				    alert.accept();
				    System.out.println("alert was present and accepted");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			
			}			
			
			return this;			
			
			}			
		

		public MarkEntry MarkEntry2() throws IOException, Exception {
			System.out.println("Whole Mark entry");
			
			ExamSession();
			BasicCourse();
			Course();		
			Thread.sleep(1000);	
			Subject("HINDI->HINDI -> Cr - 1.00");
			Thread.sleep(1000);	
			Workbook workbook = null;
			String fileName = "StudentsMarks3.xlsx";
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			File file = new File(".//src//test//resources//excel//StudentsMarks3.xlsx");
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
			
			//ExamName();			
			//EnterMarkEntry();
			Row row = sheet.getRow(i);
			ExamName(row.getCell(0).getStringCellValue());
			EnterMarkEntry(row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue());			
			Thread.sleep(1000);			
			Submit();
			
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10 /*timeout in seconds*/);
				if(wait.until(ExpectedConditions.alertIsPresent())==null) {  
				    System.out.println("alert was not present");
				   
				} else {
				    Alert alert = driver.switchTo().alert();
				    alert.accept();
				    System.out.println("alert was present and accepted");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			
			
			}	
			
						
			return this;
			}	
		
		public MarkEntry MarkEntry3() throws IOException, Exception {
			System.out.println("Whole Mark entry");
			
			ExamSession();
			BasicCourse();
			Course();		
			Thread.sleep(1000);	
			Subject("GC->GC -> Cr - 0.00");
			Thread.sleep(1000);	
			Workbook workbook = null;
			String fileName = "StudentsMarks3.xlsx";
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			File file = new File(".//src//test//resources//excel//StudentsMarks3.xlsx");
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
			
			//ExamName();			
			//EnterMarkEntry();
			Row row = sheet.getRow(i);
			ExamName(row.getCell(0).getStringCellValue());
			EnterMarkEntry(row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue());			
			Thread.sleep(1000);			
			Submit();
			Thread.sleep(1000);
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10 /*timeout in seconds*/);
				if(wait.until(ExpectedConditions.alertIsPresent())==null) {  
				    System.out.println("alert was not present");
				   
				} else {
				    Alert alert = driver.switchTo().alert();
				    alert.accept();
				    System.out.println("alert was present and accepted");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			//LockBtn();
			
			}				
						
			return this;
			}			
		
		public MarkEntry MarkEntry4() throws IOException, Exception {
			System.out.println("Whole Mark entry");
			
			ExamSession();
			BasicCourse();
			Course();		
			Thread.sleep(1000);	
			Subject("MARATHI->MARATHI -> Cr - 1.00");
			Thread.sleep(1000);	
			Workbook workbook = null;
			String fileName = "StudentsMarks3.xlsx";
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			File file = new File(".//src//test//resources//excel//StudentsMarks3.xlsx");
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
			
			//ExamName();			
			//EnterMarkEntry();
			Row row = sheet.getRow(i);
			ExamName(row.getCell(0).getStringCellValue());
			EnterMarkEntry(row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue());			
			Thread.sleep(1000);			
			Submit();
			Thread.sleep(1000);
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10 /*timeout in seconds*/);
				if(wait.until(ExpectedConditions.alertIsPresent())==null) {  
				    System.out.println("alert was not present");
				   
				} else {
				    Alert alert = driver.switchTo().alert();
				    alert.accept();
				    System.out.println("alert was present and accepted");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			//LockBtn();
			
			}				
						
			return this;
			}			
		
		}
