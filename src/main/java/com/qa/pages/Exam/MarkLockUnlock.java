package com.qa.pages.Exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class MarkLockUnlock extends BaseClass {
	
	public MarkLockUnlock (WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "ddlSession") private WebElement ExamSession;
	@FindBy (id = "ddlBasicCourse") private WebElement BasicCourse;
	@FindBy (id = "ddlCourse") private WebElement Course;
	@FindBy (id = "ddlSubject") private WebElement Subject;
	@FindBy (id = "ddlExam") private WebElement ExamName;
    @FindBy (id = "ddlSubjectType") private WebElement SubjectType;
    @FindBy (id="ChkAll") private WebElement SelectAll;
    @FindBy (id="btnSubmit") private WebElement Submit;
    @FindBy (id = "btnCancel") private WebElement Cancel;

public MarkLockUnlock ExamSession() {
		System.out.println("Select Exam Session");
		Select ddl = new Select(ExamSession);
		ddl.selectByVisibleText("ES_2021-2020(NEW1)");
		return this;
	}
	
	public MarkLockUnlock BasicCourse() {
		System.out.println("Select BasicCourse");
		Select ddl = new Select(BasicCourse);
		ddl.selectByVisibleText("B.COM");
		return this;
		}
		
		public MarkLockUnlock Course() {
			System.out.println("Select Exam Course");
			Select ddl = new Select(Course);
			ddl.selectByVisibleText("B.COM - 1");
			return this;
			}

public MarkLockUnlock SubjectType() {
			System.out.println("Select SubjectType");
			Select ddl = new Select(SubjectType);
			ddl.selectByVisibleText("THEORY");
			return this;
			}

public MarkLockUnlock ExamName(String Exam) {
			System.out.println("Select Exam ExamName");
			Select ddl = new Select(ExamName);
			ddl.selectByVisibleText(Exam);
			return this;
			}

public MarkLockUnlock SelectAll() {
			System.out.println("Click on SelectAll");
			//click(SelectAll);
			
			WebElement checkBoxElement = SelectAll;
			boolean isSelected = checkBoxElement.isSelected();
					
			//performing click operation if element is not checked
			if(isSelected == false) {
				checkBoxElement.click();
			}
			
			return this;
		}

public MarkLockUnlock Submit() {
	System.out.println("Click on Submit");
	click(Submit);
	return this;
}

public MarkLockUnlock Cancel() {
	System.out.println("Click on Cancel");
	click(Cancel);			
	return this;
	}


public MarkLockUnlock LUMark1() throws Exception{
System.out.println("Whole Lock Unlock");			
			ExamSession();
			BasicCourse();
			Course();
            SubjectType();
            ExamName("INTERNAL-1");
            Thread.sleep(1000);	
            SelectAll();
            Thread.sleep(1000);	
            Submit();

			return this;
		}

public MarkLockUnlock LUMark2() throws Exception{
System.out.println("Whole Lock Unlock");
            Cancel();
			ExamSession();
			BasicCourse();
			Course();
            SubjectType();
            ExamName("EXTERNAL-1");
            Thread.sleep(1000);	
            SelectAll();
            Thread.sleep(1000);	
            Submit();
			
			return this;
		}

}
