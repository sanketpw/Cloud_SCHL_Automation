package com.qa.tests.sampleTestA;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {
	public static WebDriver driver;
	public static Properties prop;
	InputStream inputStream;
	public static String UrlCloudSchoolAdmin="https://school.mastersofterp.in;";

	public static void main(String[] args) throws Exception
	{

		
		initializeDriver(UrlCloudSchoolAdmin);
	}//main end
	
	
	
	
	
	public static WebDriver initializeDriver(String url) throws Exception
	{

		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\resources\\properties\\congfig.properties");


			//prop.load(fis);
			String browserName = prop.getProperty("browser");
			System.out.println(browserName);

			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				// Execute in chrome driver
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
	}//initializeDriver end

}//practice end
