package com.qa.tests.examination;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.Exam.ExamPreExam;
import com.qa.pages.Exam.ExamRegistrationLocked;
import com.qa.pages.Exam.ExamTransaction;
import com.qa.pages.Exam.FinalResultPublish;
import com.qa.pages.Exam.GradeCard;
import com.qa.pages.Exam.HandelAlert;
import com.qa.pages.Exam.HomePageExam;
import com.qa.pages.Exam.LoginExam;
import com.qa.pages.Exam.LoginStudent;
import com.qa.pages.Exam.MarkEntry;
import com.qa.pages.Exam.MarkLockUnlock;
import com.qa.pages.Exam.OpenFinalResultPublish;
import com.qa.pages.Exam.OpenGradeCard;
import com.qa.pages.Exam.OpenLockUnlock;
import com.qa.pages.Exam.OpenMarkEntry;
import com.qa.pages.Exam.OpenReport;
import com.qa.pages.Exam.OpenResultProcess;
import com.qa.pages.Exam.OpenResultProcessPage;
import com.qa.pages.Exam.PreExamReport;
import com.qa.pages.Exam.ResultProcessingActivity;
import com.qa.pages.Exam.StudentExamRegistration;

public class RegularExamTest extends BaseClass {
	
	LoginExam loginexam;
	HomePageExam homePageExam;
	HandelAlert handelalert;
	ExamTransaction examTransaction;
	ExamPreExam examPreExam;
	StudentExamRegistration studentexamrgistration;
	OpenMarkEntry openmarkentry;
	MarkEntry markentry;
	OpenResultProcess openresultprocess;
	OpenResultProcessPage openresultprocesspage;
	ResultProcessingActivity resultprocessingactivity;
	OpenReport openreport;	
	PreExamReport preexamreport;
	OpenGradeCard opengradecard;
	GradeCard gradecard;	
	OpenLockUnlock openlockunlock;
	MarkLockUnlock marklockunlock;
	ExamRegistrationLocked examregistrationlocked;
	OpenFinalResultPublish openfinalresultpage;
	FinalResultPublish finalresultpublish;
	LoginStudent loginstudent;
	
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
			  public void Students_Available_In_Grid_Registered_For_All_Available_Courses() throws Exception{
			  
			  loginexam = new LoginExam(driver); homePageExam= new HomePageExam(driver);
			  examTransaction=new ExamTransaction(driver); examPreExam=new
			  ExamPreExam(driver); 
			  studentexamrgistration=new
			  StudentExamRegistration(driver);
			  examregistrationlocked = new ExamRegistrationLocked(driver);
			  
			  
			  homePageExam =
			 loginexam.login(loginUsers.getJSONObject("SHLogin").getString("userName"),
			  loginUsers.getJSONObject("SHLogin").getString("password"));
			  
			  homePageExam.open_Examination(); examTransaction.open_Transaction();
			  examPreExam.open_PreExamSubmodule();
			  studentexamrgistration.StartExamRegistration1(); 
			  //examregistrationlocked.StartExamRegistrationLOCK();
			  Thread.sleep(3000); 
			  }
			  
			  
			  @Test(priority = 2) 
			  public void Registered_Student_Should_Be_Locked() throws Exception{
				  
				  loginexam = new LoginExam(driver); homePageExam= new HomePageExam(driver);
				  examTransaction=new ExamTransaction(driver); examPreExam=new
				  ExamPreExam(driver); 
				  studentexamrgistration=new
				  StudentExamRegistration(driver);
				  examregistrationlocked = new ExamRegistrationLocked(driver);
				  
				  
				  homePageExam =
				 loginexam.login(loginUsers.getJSONObject("SHLogin").getString("userName"),
				  loginUsers.getJSONObject("SHLogin").getString("password"));
				  
				  homePageExam.open_Examination(); examTransaction.open_Transaction();
				  examPreExam.open_PreExamSubmodule();
				  //studentexamrgistration.StartExamRegistration1(); 
				  examregistrationlocked.StartExamRegistrationLOCK();
				  Thread.sleep(3000); 
				  }
			  
			  
			 @Test(priority = 3) public void MarkEntry_To_Be_Done_On_All_Available_Courses() throws Exception{
			
			  loginexam = new LoginExam(driver); homePageExam= new HomePageExam(driver);
			  examTransaction=new ExamTransaction(driver); openresultprocess = new
			  OpenResultProcess(driver); openmarkentry=new OpenMarkEntry(driver);
			  markentry= new MarkEntry(driver);
			  
			  homePageExam =
			  loginexam.login(loginUsers.getJSONObject("SHLogin").getString("userName"),
			  loginUsers.getJSONObject("SHLogin").getString("password"));
			  
			  homePageExam.open_Examination(); examTransaction.open_Transaction();
			  openresultprocess.Open_ResultProcess(); openmarkentry.OpenMarkEntryPage();
			  markentry. MarkEntry1();			 
			  markentry. MarkEntry2();
			  markentry. MarkEntry3();
			  markentry. MarkEntry4();
			  Thread.sleep(3000);
			  
			  }
	  
	  
 	@Test(priority = 4)
	  public void Internal_Marks_To_Be_Locked() throws Exception{
	 
	 loginexam = new LoginExam(driver);		 
	 homePageExam= new HomePageExam(driver);				 
	 examTransaction=new ExamTransaction(driver);		 
	 openresultprocess = new OpenResultProcess(driver);		 
	 openlockunlock = new OpenLockUnlock(driver);		 
	 marklockunlock = new MarkLockUnlock(driver);			
				  
	 homePageExam = loginexam.login(loginUsers.getJSONObject("SHLogin").getString("userName"),
	 loginUsers.getJSONObject("SHLogin").getString("password"));	 
	 
	 homePageExam.open_Examination();		
	 examTransaction.open_Transaction();
	 openresultprocess.Open_ResultProcess();
	 openlockunlock.OpenLockUnlockPage();
	 Thread.sleep(2000);  
     marklockunlock.LUMark1();
    
}
	  
	  @Test(priority = 5)
	  public void External_Marks_To_Be_Locked() throws Exception{
	 
	 loginexam = new LoginExam(driver);		 
	 homePageExam= new HomePageExam(driver);				 
	 examTransaction=new ExamTransaction(driver);		 
	 openresultprocess = new OpenResultProcess(driver);		 
	 openlockunlock = new OpenLockUnlock(driver);		 
	 marklockunlock = new MarkLockUnlock(driver);			
				  
	 homePageExam = loginexam.login(loginUsers.getJSONObject("SHLogin").getString("userName"),
	 loginUsers.getJSONObject("SHLogin").getString("password"));	 
	 
	 homePageExam.open_Examination();		
	 examTransaction.open_Transaction();
	 openresultprocess.Open_ResultProcess();
	 openlockunlock.OpenLockUnlockPage();
	 Thread.sleep(2000);  
     marklockunlock.LUMark2();
    
}
			 

			 
			 
			 @Test(priority = 6) 
			 public void ResultProcessing_With_MarkProcessing_Gracing_Grading_With_Date() throws Exception {
			  loginexam = new LoginExam(driver); 
			  homePageExam= new HomePageExam(driver);
			  examTransaction=new ExamTransaction(driver); 
			  openresultprocess = new OpenResultProcess(driver); 
			  openresultprocesspage = new OpenResultProcessPage(driver); 
			  resultprocessingactivity = new  ResultProcessingActivity(driver);
			  
			  homePageExam =loginexam.login(loginUsers.getJSONObject("SHLogin").getString("userName"),
			  loginUsers.getJSONObject("SHLogin").getString("password"));
			  
			  homePageExam.open_Examination(); 
			  examTransaction.open_Transaction();
			  openresultprocess.Open_ResultProcess(); 
			  openresultprocesspage.OpenResultProcessActualPage();
			  resultprocessingactivity.StartMarkProcessing(); 
			  Thread.sleep(3000); 
			  
}
	  
	 
	 @Test(priority = 7) public void Generating_Final_Result_With_GradeCard() throws Exception{
	 
	 loginexam = new LoginExam(driver);		 
	 homePageExam= new HomePageExam(driver);
	 openreport = new OpenReport(driver);
	 preexamreport = new PreExamReport(driver);
	 opengradecard = new OpenGradeCard(driver);
	 gradecard = new GradeCard(driver);
	 
	 homePageExam = loginexam.login(loginUsers.getJSONObject("SHLogin").getString("userName"),
	 loginUsers.getJSONObject("SHLogin").getString("password"));	 
	 
		
	 homePageExam.open_Examination(); 
	 openreport.OpenReports();
	 preexamreport.ClickPreExamReport(); 
	 opengradecard.ClickGradeCard();
	 gradecard.GradeCardPage(); 
	 
	 } 
	  
	  
	  @Test(priority = 8)
	  public void Result_To_be_Published_at_student_side() throws Exception{
	 
	 loginexam = new LoginExam(driver);		 
	 homePageExam= new HomePageExam(driver);				 
	 examTransaction=new ExamTransaction(driver);		 
	 openresultprocess = new OpenResultProcess(driver);
	 openfinalresultpage = new OpenFinalResultPublish(driver);
	 finalresultpublish = new FinalResultPublish(driver);
					  
	 homePageExam = loginexam.login(loginUsers.getJSONObject("SHLogin").getString("userName"),
	 loginUsers.getJSONObject("SHLogin").getString("password"));	 
	 
	 homePageExam.open_Examination();		
	 examTransaction.open_Transaction();
	 openresultprocess.Open_ResultProcess();
	 openfinalresultpage. ResultPublish();
	 finalresultpublish.Publish();
    
}  
	  
	
		  
	  }
	  
	
	

