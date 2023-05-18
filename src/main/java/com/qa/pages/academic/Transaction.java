package com.qa.pages.academic;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class Transaction extends BaseClass{
	
	public Transaction(WebDriver rdriver)
	{
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(className = "treeview")private List<WebElement> translist;
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Prospectus'])[2]/following::span[1]")private WebElement registration;
	
	
	
	public Transaction openTabList(String tabname) {
		String TabName= tabname;
		for (int i=0; i < translist.size(); i++) {
			if (translist.get(i).getText().equalsIgnoreCase(TabName)){
				translist.get(i).click();
			break;
			}
		}
		System.out.println("Clicked on " + TabName);
		return this;
		}

	public Transaction openRegistration() {
		click(registration);
		System.out.println("Clicked on Registration");
		return this;
		
	}
	
	
}