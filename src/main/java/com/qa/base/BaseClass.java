package com.qa.base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import com.qa.utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;
	InputStream inputStream;
	//Utilities util;
	//@Parameters("browser")
	//@BeforeTest
	
	/**
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public WebDriver initializeDriverBFT(String url) throws Exception  {

		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
			
			prop.load(fis);
			String browserName = prop.getProperty("browser");
			System.out.println(browserName);

			if (browserName.contains("chrome")) {
//				ChromeOptions options = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				// Execute in chrome driver

				
//				if(browserName.contains("headless")) {
//				options.addArguments("headless");
//				}
//				driver = new ChromeDriver(options);
//				driver.manage().window().setSize(new Dimension(1400,900));

			} else if (browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				// Execute in firefox code

			} else if (browserName.equals("Edge")) {
				WebDriverManager.iedriver().setup();
				driver = new EdgeDriver();
				// Execute in edge driver
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get(prop.getProperty(url));

			driver.manage().window().maximize();
			
		} catch (Exception e) 
		{
			System.out.println(e.getCause());
			System.out.println(e.getMessage());

			throw e;
		}

		return driver;
	}
	
	public void waitForVisibility(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Utilities.Wait);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void waitUntilElementisClickable(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Utilities.Wait);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public void click(WebElement e) {
		waitForVisibility(e);
		waitUntilElementisClickable(e);
		e.click();
	}

	public void sendKeys(WebElement e, String text) {
		waitForVisibility(e);
		e.sendKeys(text);
	}

	public void clearText(WebElement e) {
		waitForVisibility(e);
		e.clear();
	}

	public String getAttribute(WebElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

	public String getText(WebElement e) {
		waitForVisibility(e);
		return e.getText();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	@AfterTest
	public void afterTest() {
	//driver.quit();
	}

	public String GetCurrentTime() {
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		 Date date = new Date();	 //get current date time with Date()
		 String date1= dateFormat.format(date); // Now format the date 	
		 return date1;
		 }
	
	public String GetCurrentDate() {
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");		 
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		 return date1;
		 }
	
	public void scrollIntoView(WebElement e, int up, int down) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy("+up+","+down+")");// Scroll Into View
    }
	
	
	public void scrollToElement(WebElement e) {
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoViewIfNeeded()", e);
	  
	}

	public void acceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Utilities.Wait);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert : " + driver.switchTo().alert().getText() + " - Yes");
		alert.accept();
    }
	
	public void dismissAlert() {
	WebDriverWait wait = new WebDriverWait(driver, Utilities.Wait);
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	System.out.println("Alert : " + driver.switchTo().alert().getText() + " - No");
	alert.dismiss();
	}	

	public void switchToNextWindow() {
		Set<String> windowpopup= driver.getWindowHandles(); 
		Iterator<String> iterate=windowpopup.iterator(); 
		List<String> Windex= new ArrayList<String>();
		while(iterate.hasNext()) {
			Windex.add( iterate.next());
		}
		driver.switchTo().window(Windex.get(1));
		driver.manage().window().maximize();
		System.out.println(windowpopup.size() + " - WindowPopup : Switched to Window");
		System.out.println("                  Current URL - "+ driver.getCurrentUrl());
		System.out.println("                  Window Title - " + driver.getTitle());
		System.out.println("                  Window Id - " + Windex.get(1));
		
	}
	
	public void switchToFrame(int framenum) { //function for Switch the window
	int totalframes=driver.findElements(By.tagName("iframe")).size();
	System.out.println(totalframes);	
	driver.switchTo().frame(framenum);
	System.out.println("switched to new frame");
	}



	public void switchToDefaultContent() {//function for go out side the frame
		int totalframes=driver.findElements(By.tagName("iframe")).size();
		System.out.println(totalframes);	
		driver.switchTo().defaultContent();
		}

	public String verifyConfirmationMessage() {
		String confirmationMsg = getText(driver.findElement(By.id("StrmMsg")));
		System.out.println("Confirmation Message - " + confirmationMsg);
		return confirmationMsg;
	}

}
