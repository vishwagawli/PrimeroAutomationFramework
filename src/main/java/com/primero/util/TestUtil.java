package com.primero.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.primero.base.TestBase;

import dev.failsafe.internal.util.Assert;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+ "//src//main//java//com//"
									+"//primero//testdata//Primero.xlsx";

	static Workbook book;
	static Sheet sheet;
	
	//WebDriver driver;
	public void waitForElementToAppear(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}


	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException {
		//File f = new File(TESTDATA_SHEET_PATH);
		//FileInputStream fis = new FileInputStream(f);
		//Workbook wb = WorkbookFactory.create(fis);
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		Files.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static boolean getNameFromTable(String text) throws InterruptedException
	{
		
		//table[contains(@class,'MuiTable-root')]/tbody/tr[4]/td[3]"
		String beforxpath="//table[contains(@class,'MuiTable-root')]/tbody/tr[";
		String afterxpath= "]/td[3]";
		for(int i=1;i<=5;i++)
		{
			String name = driver.findElement(By.xpath(beforxpath+i+afterxpath)).getText();
			System.out.println(name);
			
		/*	if(name.contains(text))
			{
			   test = driver.findElement(By.xpath(beforxpath+i+afterxpath)).getText();
				
				Thread.sleep(5000);
			}*/
			if(name.equalsIgnoreCase(text))
			{
				System.out.println("True");
				return true;
			}
					
		}
		System.out.println("False");
		return false;
	
		
	}
	
	
}


