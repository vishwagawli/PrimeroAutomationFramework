package com.primero.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primero.base.TestBase;
import com.primero.pages.CasesPage;
import com.primero.pages.HomePage;
import com.primero.pages.LoginPage;
import com.primero.util.TestUtil;

public class CasesPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CasesPage casespage;
	
	String sheetName = "SearchCases";
	
	public CasesPageTest() {
		super();
	}

	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		casespage = homePage.clickOnCasesLink();
	}
	@Test(priority=1)
	public void verifyCasesLabel() throws IOException{
		
		casespage.verifyCasesLabelPresent();
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	/*@Test(priority=2)
	public void sendSearchBoxData() throws InterruptedException, IOException{
		
		casespage.sendDataToSearchbox("Text");
		TestUtil.takeScreenshotAtEndOfTest();
		Thread.sleep(3000);
	}*/
	@DataProvider
	public Object[][] getTestDataFromExcel_SearchCases() throws EncryptedDocumentException, IOException
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
/*	@Test(priority=2, dataProvider = "getTestDataFromExcel_SearchCases")
	public void sendSearchBoxData(String text) throws InterruptedException, IOException{
		
		//casespage.sendDataToSearchbox("Text");
		casespage.sendDataToSearchbox(text);
		Thread.sleep(6000);
		TestUtil.getNameFromTable();
	//	Assert.assertEquals(TestUtil.getNameFromTable().test, "Home","Home page Text not matched");
		TestUtil.takeScreenshotAtEndOfTest();
		Thread.sleep(3000);
	}*/
	
	
	@Test(priority=2, dataProvider = "getTestDataFromExcel_SearchCases")
	public void sendSearchBoxData(String text) throws InterruptedException, IOException{
		
		//casespage.sendDataToSearchbox("Text");
		casespage.sendDataToSearchbox(text);
		Thread.sleep(6000);
		TestUtil.getNameFromTable(text);
	//	Assert.assertEquals(TestUt, "Home","Home page Text not matched");
		TestUtil.takeScreenshotAtEndOfTest();
		Thread.sleep(3000);
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
