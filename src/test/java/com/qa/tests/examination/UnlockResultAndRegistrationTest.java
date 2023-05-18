package com.qa.tests.examination;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.Exam.UnlockRegistrationOnly;
import com.qa.pages.Exam.UnlockResultAndRegistration;



public class UnlockResultAndRegistrationTest extends BaseClass {
	
	UnlockResultAndRegistration unlockresultandregistration;
	UnlockRegistrationOnly unlockrgistrationonly;
	 @Test(priority = 1) 
	  public void UnlockResul() throws Exception{
		 
		 unlockresultandregistration= new UnlockResultAndRegistration();
		 unlockresultandregistration. UnlockResultAndRegistration1();
		
		  }
	 
	 @Test(priority = 2) 
	  public void UnlockRegistration() throws Exception{
		 
		 unlockrgistrationonly= new UnlockRegistrationOnly();
		 unlockrgistrationonly. Unregistration();
		  
		 
		  }

//	 @AfterMethod
//	  public void afterMethod() throws Exception {
//		  Thread.sleep(1000); 
//		  driver.close();
//		  
//		    }  
}
