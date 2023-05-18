package com.qa.pages.establishment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;
	
	public class LeaveStatusReport extends BaseClass{
		
		public LeaveStatusReport(WebDriver rdriver)
		{
			driver= rdriver;
			PageFactory.initElements(rdriver, this);
		}

		@FindBy (id = "ddlStaffType") private WebElement ddlStaffType;
		@FindBy (id = "ddlDepartment") private WebElement ddlDepartment;
		@FindBy (id = "ddlEmployee") private WebElement ddlEmployee;
		@FindBy (id = "btnReport") private WebElement btnReport;

		public LeaveStatusReport ddlStaffType() {
			System.out.println("Enter ddlStaffType");
			Select ddl = new Select(ddlStaffType);
			ddl.selectByVisibleText("TEACHING");
			return this;
		}
		
		public LeaveStatusReport ddlDepartment() {
			System.out.println("Enter ddlDepartment");
			Select ddl = new Select(ddlDepartment);
			ddl.selectByVisibleText("EDUCATION");
			return this;
		}
		
		public LeaveStatusReport ddlEmployee() {
			System.out.println("Enter ddlEmployee");
			Select ddl = new Select(ddlEmployee);
			ddl.selectByVisibleText("MAYUR K");
			return this;
		}
		
		public LeaveStatusReport btnReport() {
			System.out.println("Enter btnReport");
			click(btnReport);
			return this;
		}
	}