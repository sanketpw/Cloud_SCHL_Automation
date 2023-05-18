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
import com.qa.pages.SchemeExam.ExaminationSetup;
import com.qa.pages.SchemeExam.HomePageSchemeExam;
import com.qa.pages.SchemeExam.LoginSchemeExam;
import com.qa.pages.SchemeExam.OpenSchemeCourseAllotment;
import com.qa.pages.SchemeExam.OpenSchemeCreation;
import com.qa.pages.SchemeExam.OpenSchemeSubjectAllotment;
import com.qa.pages.SchemeExam.SchemeCourseAllotment;
import com.qa.pages.SchemeExam.SchemeCreation;
import com.qa.pages.SchemeExam.SchemeSetup;
import com.qa.pages.SchemeExam.SchemeSubjectAllotment;
import com.qa.pages.SchemeExam.Subject;

public class SchemeExamTest extends BaseClass{
	

	LoginSchemeExam loginschemeexam;
	HomePageSchemeExam homepageschemeexam;
	ExaminationSetup examinationsetup;
	SchemeSetup schemesetup;
	OpenSchemeCreation openschemecreation;
	SchemeCreation schemecreation;
	OpenSchemeCourseAllotment openschemecourseallotment;
	SchemeCourseAllotment schemecourseallotment;
	Subject subject;
	OpenSchemeSubjectAllotment openschemesubjectallotment;
	SchemeSubjectAllotment schemesubjectallotment;
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
	  
/*	  @Test(priority = 1) 
	  public void To_Test_SchemeCreation_Page() throws Exception{
		  
		  loginschemeexam = new LoginSchemeExam(driver);  
		 
		  homepageschemeexam= new HomePageSchemeExam(driver);	
		  
		  examinationsetup = new ExaminationSetup(driver);
		  
		  schemesetup = new SchemeSetup(driver);
		  
		  openschemecreation = new OpenSchemeCreation(driver);
		  
		  schemecreation = new SchemeCreation(driver);
	  
		  homepageschemeexam = loginschemeexam.login(loginUsers.getJSONObject("AdmissionLogin").getString("userName"),
	      loginUsers.getJSONObject("AdmissionLogin").getString("password"));
		  
		  homepageschemeexam.open_SchemeExamination();
		  examinationsetup.ExaminationSetupPage();		 
		  schemesetup.SchemeSetupPage();
		  openschemecreation.OpenSchemeCreationPage();
		  schemecreation.ScemeCreationActivity();		 
		  
	      Thread.sleep(3000); 
	  } 
	  
	  @Test(priority = 2) 
	  public void To_Test_Scheme_Page() throws Exception{
		  
		  loginschemeexam = new LoginSchemeExam(driver);  
		 
		  homepageschemeexam= new HomePageSchemeExam(driver);	
		  
		  examinationsetup = new ExaminationSetup(driver);
		  
		  schemesetup = new SchemeSetup(driver);
		  
		  openschemecourseallotment = new OpenSchemeCourseAllotment(driver);
		  
		  schemecourseallotment = new SchemeCourseAllotment(driver);
	  
		  homepageschemeexam = loginschemeexam.login(loginUsers.getJSONObject("AdmissionLogin").getString("userName"),
	      loginUsers.getJSONObject("AdmissionLogin").getString("password"));
		  
		  homepageschemeexam.open_SchemeExamination();
		  examinationsetup.ExaminationSetupPage();		 
		  schemesetup.SchemeSetupPage();
		  openschemecourseallotment.OpenSchemeCourseAllotmentPage();
		  schemecourseallotment.SchemeAllotmentActivity();		 
		  
	      Thread.sleep(3000); 
	  }  */
	  
	  @Test(priority = 3) 
	  public void To_Test_SchemeSubjectAllotment_Page() throws Exception{
		  
		  loginschemeexam = new LoginSchemeExam(driver);		 
		  homepageschemeexam= new HomePageSchemeExam(driver);		  
		  examinationsetup = new ExaminationSetup(driver);  
		  subject = new Subject(driver);
		  openschemesubjectallotment = new OpenSchemeSubjectAllotment(driver);
		  schemesubjectallotment = new SchemeSubjectAllotment(driver);
			  
		  homepageschemeexam = loginschemeexam.login(loginUsers.getJSONObject("AdmissionLogin").getString("userName"),
	      loginUsers.getJSONObject("AdmissionLogin").getString("password"));
		  
		  homepageschemeexam.open_SchemeExamination();
		  examinationsetup.ExaminationSetupPage();		 
		  subject.SubjectSubmodule();
		  openschemesubjectallotment.OpenSchemeSubjectAllotmentPage();
		  schemesubjectallotment.SchemeSubjectAllotmentPage();
		  Thread.sleep(3000); 
	  }
	
}
