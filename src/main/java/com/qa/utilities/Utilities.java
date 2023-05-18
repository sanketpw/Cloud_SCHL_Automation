package com.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.qa.base.BaseClass;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utilities extends BaseClass{

	public static String screenshotPath;
	public static String screenshotName;

	
	
	public static final long Wait= 30;
	
	

	public static void getAScreenShot() throws IOException {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		FileUtils.copyFile(scrFile,
				//new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\screenshots" + screenshotName));

	}

	
	
	public static void getAShot() throws IOException {
			
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		//ImageIO.write(screenshot.getImage(), "jpg", new File(System.getProperty("user.dir") + "\\target\\screenshots\\" + screenshotName));
		ImageIO.write(screenshot.getImage(), "jpg", new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\screenshots" + screenshotName));

	}
	

	
	@DataProvider(name = "getData")
	public  Object[][] getData() {
		ExcelReader excel = null;
		if (excel == null) {
			excel = new ExcelReader(".\\src\\test\\resources\\excel\\testDetails.xlsx");
		}

		String sheetName = "NameList";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		HashMap<String, String> table = null;

		for (int rowNum = 2; rowNum <= 2; rowNum++) { // 2

			table = new HashMap<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]

				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));

				//data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				data[rowNum - 2][0] =table;
				
			}

		}

		return data;

	}

	public static boolean isTestRunnable(String testName, ExcelReader excel) {
		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String testCase = excel.getCellData(sheetName, "TCID", rNum);

			if (testCase.equalsIgnoreCase(testName)) {

				String runmode = excel.getCellData(sheetName, "Runmode", rNum);

				if (runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}

		}
		return false;
	}

}
