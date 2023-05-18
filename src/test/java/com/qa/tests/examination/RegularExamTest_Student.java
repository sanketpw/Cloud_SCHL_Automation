package com.qa.tests.examination;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.Exam.LoginStudent;
import com.qa.pages.Exam.OpenStudentSideResultPage;
import com.qa.pages.Exam.StudentSideResult;

public class RegularExamTest_Student extends BaseClass {
	
LoginStudent loginstudent;
OpenStudentSideResultPage openstudentsideresultpage;
StudentSideResult studentsideresult;


	InputStream dataIs;
	JSONObject loginUsers;
	//PdfReader pdfReader;
	
	public static WebDriver driver;
	
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		  try {
			  String dataFileName = "data/loginUsers.json";
			  System.out.println();
			  
			  dataIs = getClass().getClassLoader().getResourceAsStream(dataFileName);
			  JSONTokener tokener = new JSONTokener(dataIs);
			  loginUsers = new JSONObject(tokener); 	
		  } catch (Exception e) {
			  e.printStackTrace();  
			  throw e;
		  }finally {
			if (dataIs != null) {
				dataIs.close();
			}	
		  }
	  }
	 @AfterClass
	  public void afterClass() throws Exception {
		
		
	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) throws Exception,NullPointerException {
		 driver=initializeDriverBFT("urlCIMSAdmin");
		 
		 System.out.println("\n" + "***** Starting Test: " + m.getName()  + "*****" + "\n");
	  }

	  @AfterMethod
	  public void afterMethod() throws Exception {
		  Thread.sleep(1000); 
		  driver.close();
		  
		    }  
	  
	  @Test(priority = 1)
	  public void Result_at_student_side_after_result_publish() throws Exception{
		  
		  loginstudent = new LoginStudent(driver);	
		  openstudentsideresultpage = new OpenStudentSideResultPage(driver);
			 studentsideresult= new StudentSideResult(driver);
		     
			 Thread.sleep(1000);
			 driver.findElement(By.id("btnstud")).click();
			 Thread.sleep(1000);
		 	
		  Workbook workbook = null;
			String fileName = "StudentLogin.xlsx";
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			File file = new File(".//src//test//resources//excel//StudentLogin.xlsx");
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
			 Thread.sleep(1000);
			 Row row = sheet.getRow(i);			
			
			loginstudent.login1((row.getCell(0).getStringCellValue()),(row.getCell(1).getStringCellValue()));	
			 Thread.sleep(2000);	 
			 openstudentsideresultpage.StudentSide_ResultPage();
			 studentsideresult.GetStudentResult();
			 Thread.sleep(2000);
			 //ScreenShot
			 studentsideresult.StudentGRScreenShot(row.getCell(0).getStringCellValue());		 
			 Thread.sleep(2000);
			 studentsideresult.WriteDataForStudentGC(row.getCell(0).getStringCellValue(),i);
			 Thread.sleep(2000);
			 //Logout
			 driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li[2]/a/i")).click();
			 Thread.sleep(1000);
			 
			 try {
					WebDriverWait wait = new WebDriverWait(driver, 30 /*timeout in seconds*/);
					if(wait.until(ExpectedConditions.alertIsPresent())==null) {
						Thread.sleep(1000);	
					    System.out.println("alert was not present");
					   
					} else {
					    Alert alert = driver.switchTo().alert();
					    alert.accept();
					    System.out.println("alert was present and accepted");
					}
				}
			 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			 	 
	     }
	  
	  

}}
