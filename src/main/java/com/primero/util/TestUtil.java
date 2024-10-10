package com.primero.util;



import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import java.awt.image.RenderedImage;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.primero.base.TestBase;

import dev.failsafe.internal.util.Assert;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 50;
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+ "//src//main//java//com//"
									+"//primero//testdata//Primero.xlsx";
	
	//public static String url = downloadpath+ "/a812fc7d-d8fc-418f-a97b-d76371df41db.pdf";
	
	static String url = "file:///home/vishwambargawli/eclipse-workspace/Primero/PDF/a812fc7d-d8fc-418f-a97b-d76371df41db.pdf";

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
		String afterxpath= "]/td[1]";
		for(int i=1;i<=25;i++)
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
				driver.findElement(By.xpath(beforxpath+i+afterxpath)).click();
				
				return true;
			}
					
		}
		System.out.println("False");
		return false;
	
		
	}
	
	
	/*	
	public static String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
		
	}
	
	public void selectDate(String exDay, String exMonth, String exYear) throws InterruptedException
	{
		String monthYearVal = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/p")).getText();
		System.out.println("Value is" +monthYearVal);
		
		while(!(getMonthYear(monthYearVal)[0].equalsIgnoreCase(exMonth) && getMonthYear(monthYearVal)[1].equalsIgnoreCase(exYear)))
		{
			driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]")).click();
			monthYearVal = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/p")).getText();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'"+exDay+"')]")).click();
		//p[contains(text(),'17')]
		
	}
	*/
	
	public static String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
		
	}
	
	public void selectDate(String exDay, String exMonth, String exYear, String xpath_MonthYearLabel, String xpath_NextIconCalendor) throws InterruptedException
	{
		WebElement MY = driver.findElement(By.xpath(xpath_MonthYearLabel));
		String monthYearVal = MY.getText();
		System.out.println("Value is" +monthYearVal);
		
		while(!(getMonthYear(monthYearVal)[0].equalsIgnoreCase(exMonth) && getMonthYear(monthYearVal)[1].equalsIgnoreCase(exYear)))
		{
			driver.findElement(By.xpath(xpath_NextIconCalendor)).click();
			monthYearVal = driver.findElement(By.xpath(xpath_MonthYearLabel)).getText();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'"+exDay+"')]")).click();
		//p[contains(text(),'17')]
		
	}
	
	public static void pdfReaderTest() throws Exception {
		
		//URL pdfUrl = new URL(url);
		java.net.URL pdfUrl = new java.net.URL(url);
		InputStream ip = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(ip);
		PDDocument pdDocument = PDDocument.load(bf);
		int pageCount = pdDocument.getNumberOfPages();
		System.out.println("pdf page: " + pageCount);
		
		System.out.println("========================pdf content===============");
		PDFTextStripper pdfStiper = new PDFTextStripper();
	    String pdfText = pdfStiper.getText(pdDocument);
		System.out.println(pdfText);
		
		int imagecount = getImagesFromPDF(pdDocument).size();
		System.out.println("Total Images "+imagecount);
		
		PDFBoxExtractImages(pdDocument);
		
		
		 
		
	}
	
	public int getPDFImagesCount(PDDocument document) throws IOException {
		return getImagesFromPDF(document).size();
	}
	
	public static List<RenderedImage> getImagesFromPDF(PDDocument document) throws IOException {
		List<RenderedImage> images = new ArrayList<>();
		for (PDPage page : document.getPages()) {
			images.addAll(getImagesFromResources(page.getResources()));
		}

		return images;
	}
	
	private static List<RenderedImage> getImagesFromResources(PDResources resources) throws IOException {
		List<RenderedImage> images = new ArrayList<>();

		for (COSName xObjectName : resources.getXObjectNames()) {
			PDXObject xObject = resources.getXObject(xObjectName);

			if (xObject instanceof PDFormXObject) {
				images.addAll(getImagesFromResources(((PDFormXObject) xObject).getResources()));
			} else if (xObject instanceof PDImageXObject) {
				images.add(((PDImageXObject) xObject).getImage());
			}
		}
		
		return images;
	}
	
	public static void PDFBoxExtractImages(PDDocument document) throws Exception {
	    PDPageTree list = document.getPages();
	    for (PDPage page : list) {
	        PDResources pdResources = page.getResources();
	        for (COSName c : pdResources.getXObjectNames()) {
	            PDXObject o = pdResources.getXObject(c);
	            if (o instanceof org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) {
	                File file = new File("./pdfimages/" + System.nanoTime() + ".png");
	                ImageIO.write(((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject)o).getImage(), "png", file);
	            }
	        }
	    }
	}
	

}


