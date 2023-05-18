package com.qa.pages.Exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class StudentSideResult extends BaseClass {
	
	public StudentSideResult  (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "ddlResultExamSession") private WebElement Session;
	@FindBy (id = "ddlResultCourses") private WebElement BasicCourse;
	@FindBy (id = "btnResultGenerate") private WebElement GetResult;
	
	public StudentSideResult Session() {		
	    System.out.println("Select Exam Session");
		Select ddl = new Select(Session);
		ddl.selectByVisibleText("ES_2021-2020(NEW1)");
		return this;
	}		
	
	public StudentSideResult BasicCourse() {
		System.out.println("Select BasicCourse");
		Select ddl = new Select(BasicCourse);
		ddl.selectByVisibleText("B.COM - 1");
		return this;
		}

	public StudentSideResult ClickGetResult() {
		System.out.println("Click on GetResult");
		click(GetResult);			
		return this;
		}
	
	public StudentSideResult GetStudentResult() throws Exception {	
		
		Session();
		BasicCourse();
		Thread.sleep(1000); 
		ClickGetResult();
				
		return this;
		}
	
public StudentSideResult StudentGRScreenShot(String Name1) throws Exception {	
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		 File src=(File) scrShot.getScreenshotAs(OutputType.FILE);
			//File src = new File("D:\\Images\\Download.png");
			Thread.sleep(1000);			
			FileUtils.copyFile(src, new File(".\\src\\test\\resources\\data\\StudentSideResult-"+Name1+".png"));
			Thread.sleep(1000);		
		return this;
		}

public StudentSideResult WriteDataForStudentGC(String Name1, int i) throws IOException, Exception {
	
	 try {
			File file =    new File(".//src//test//resources//excel//StudentSideGCR.xls");
			
			//Create an object of FileInputStream class to read excel file
			FileInputStream inputStream = new FileInputStream(file);
			
			//creating workbook instance that refers to .xls file
			HSSFWorkbook wb=new HSSFWorkbook(inputStream);
			
			//creating a Sheet object using the sheet Name
			HSSFSheet sheet=wb.getSheetAt(0);							
//			
			//HSSFRow row2=sheet.createRow(i);
			HSSFRow row2=sheet.createRow(i);
			
			CreationHelper helper
           = wb.getCreationHelper();
			HSSFHyperlink link
           = (HSSFHyperlink)helper.createHyperlink(
               HyperlinkType.FILE);
			
 String link2 = "E:\\SVN_Work\\CIMS_College\\src\\test\\resources\\data\\StudentSideResult-"+Name1+".png";
       link.setAddress(link2);   

		        
       row2.createCell(0).setCellValue(Name1);
       row2.createCell(1).setHyperlink((HSSFHyperlink)link);
       row2.createCell(1).setCellValue("Click here to view StudentSideGCR");
			
			
			//write the data in excel using output stream
			FileOutputStream outputStream = new FileOutputStream(".//src//test//resources//excel//StudentSideGCR.xls");
			wb.write(outputStream);
			wb.close();
			System.out.println("Write Done");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	return this;
	}



}
