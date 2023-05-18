package com.qa.pages.Exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;


public class GradeCard extends BaseClass {

	public GradeCard  (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "ddlSession") private WebElement Session;
	@FindBy (id = "ddlBasicCourse") private WebElement BasicCourse;
	@FindBy (id = "ddlCourse") private WebElement Course;
	@FindBy (id = "Name") private WebElement ClickName;
	@FindBy (css = "#select2-ddlStudent-container") private WebElement StudentName;
	@FindBy (id = "btnGradeCard") private WebElement BtnGradeCard;
	

			@FindBy (className = "select2-results__option") private List<WebElement> studentDropDown;

			
	
	public GradeCard Session() {		
	    System.out.println("Select Session");
		Select ddl = new Select(Session);
		ddl.selectByVisibleText("ES_2021-2020(NEW1)");
		return this;
	}		
	
	public GradeCard BasicCourse() {
		System.out.println("Select BasicCourse");
		Select ddl = new Select(BasicCourse);
		ddl.selectByVisibleText("B.COM");
		return this;
		}
	
	public GradeCard Course() {
		System.out.println("Select Exam Course");
		Select ddl = new Select(Course);
		ddl.selectByVisibleText("B.COM - 1");
		return this;
		}
	
	public GradeCard Name() {
		System.out.println("Click on Name");
		click(ClickName);			
		return this;
		}
	
	public GradeCard StudentName(String Name) {
		System.out.println("Select StudentName");
		
		click(StudentName);
		
		
	//List<WebElement> dropdown= driver.findElements(By.className("select2-results__option"));	
		
	 //dropdown.get(1).click(); 
		
		List<WebElement> options = driver.findElements(By.className("select2-results__option"));

		for (WebElement opt : options) {

		    if (opt.getText().equals(Name)) {
		    	
					opt.click();
					
					break;
		    }
		}		 		
	
		System.out.println("Student Selected");
			
		return this;
		}
	
	public GradeCard ScreenShot(String Name) throws Exception {	
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		 File src=(File) scrShot.getScreenshotAs(OutputType.FILE);
			//File src = new File("D:\\Images\\Download.png");
			Thread.sleep(1000);			
			FileUtils.copyFile(src, new File(".\\src\\test\\resources\\data\\StudentResultReport-"+Name+".png"));
			Thread.sleep(1000);		
		return this;
		}
	
public GradeCard WriteData(String Name) throws Exception {	
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		 File src=(File) scrShot.getScreenshotAs(OutputType.FILE);
			//File src = new File("D:\\Images\\Download.png");
			Thread.sleep(1000);			
			FileUtils.copyFile(src, new File(".\\src\\test\\resources\\data\\StudentResultReport-"+Name+".png"));
			Thread.sleep(1000);		
		return this;
		}

	public GradeCard BtnGradeCard() {
		System.out.println("Click on GradeCardBtn");
		click(BtnGradeCard);			
		return this;
		}
	
	public GradeCard WriteData1(String Name, int i) throws IOException, Exception {
		
		 try {
				File file =    new File(".//src//test//resources//excel//GradeCardResult.xls");
				
				//Create an object of FileInputStream class to read excel file
				FileInputStream inputStream = new FileInputStream(file);
				
				//creating workbook instance that refers to .xls file
				HSSFWorkbook wb=new HSSFWorkbook(inputStream);
				
				//creating a Sheet object using the sheet Name
				HSSFSheet sheet=wb.getSheetAt(0);
								
//				int rowCount1 = sheet.getLastRowNum() - sheet.getFirstRowNum();		// Find number of rows in excel file
//				System.out.println(rowCount1); 
//				for (int i = 0; i<=rowCount1;i++) {						
//				
				//Create a row object to retrieve row at index 3
				//HSSFRow row2=sheet.createRow(i);
				HSSFRow row2=sheet.createRow(i);
				
				CreationHelper helper
	            = wb.getCreationHelper();
				HSSFHyperlink link
	            = (HSSFHyperlink)helper.createHyperlink(
	                HyperlinkType.FILE);
				
	  String link1 = "E:\\SVN_Work\\CIMS_College\\src\\test\\resources\\data\\StudentResultReport-"+Name+".png";
	        link.setAddress(link1);
	        
//	        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();		// Find number of rows in excel file
//			System.out.println(rowCount); 
//			for (int i = 0; i <= rowCount; i++) {	
//				HSSFRow row2=sheet.createRow(i);
				
				
				/*for(int j = 0; j < row2.getLastCellNum(); j++){

			        //Fill data in row

			        Cell cell = row2.createCell(j);*/			       
	        
	        //Row row2 = sheet.getRow(i);
	        
	        
//	        Map<String, Object[]> studentData
//            = new TreeMap<String, Object[]>();  
//        studentData.put("1", new Object[] { Name,link1 });    
//          Set<String> keyid = studentData.keySet();
//  
//        int rowid = 0;
//  
//        // writing the data into the sheets...
//  
//        for (String key : keyid) {
//  
//            row2 = sheet.createRow(rowid++);
//            Object[] objectArr = studentData.get(key);
//            int cellid = 0;
//  
//            for (Object obj : objectArr) {
//                Cell cell = row2.createCell(cellid++);
//                cell.setCellValue((String)obj);
//            }
			        
	        row2.createCell(0).setCellValue(Name);
	        row2.createCell(1).setHyperlink((HSSFHyperlink)link);
	        row2.createCell(1).setCellValue("Click here to view report");
	        
	        
				
				//create a cell object to enter value in it using cell Index
				//row2.createCell(0).setCellValue("GradeCardLink");
				
				
				//write the data in excel using output stream
				FileOutputStream outputStream = new FileOutputStream(".//src//test//resources//excel//GradeCardResult.xls");
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
	
	
	
	public GradeCard GradeCardPage() throws IOException, Exception {
		
		Workbook workbook = null;
		String fileName = "GradeCard.xls";
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		File file = new File(".//src//test//resources//excel//GradeCard.xls");
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
		
		Session();
		BasicCourse();
		Course();
		Name();
		Thread.sleep(1000);
		Row row = sheet.getRow(i);
		StudentName(row.getCell(0).getStringCellValue());		
		BtnGradeCard();
		Thread.sleep(1000);
		
		String originalHandle = driver.getWindowHandle();		  
	    for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);    
	            break;
	        }
	    }
	    //driver.switchTo().window(originalHandle);	    
		Thread.sleep(1000);
		ScreenShot(row.getCell(0).getStringCellValue());
		Thread.sleep(1000);
		 driver.switchTo().window(originalHandle);
		 Thread.sleep(1000);
		 WriteData1(row.getCell(0).getStringCellValue(),i);
		 Thread.sleep(1000);
		}	
		
		return this;
	
}}
	
