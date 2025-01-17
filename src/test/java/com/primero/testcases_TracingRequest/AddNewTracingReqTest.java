package com.primero.testcases_TracingRequest;

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
import com.primero.pages.TracingRequestPage;
import com.primero.util.TestUtil;

public class AddNewTracingReqTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CasesPage casespage;
	TracingRequestPage tracingrequest;
	
	String sheetName = "SearchCases";
	
	public AddNewTracingReqTest() {
		super();
	}

	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("adminuser"), prop.getProperty("password"));
		tracingrequest = homePage.clickOnTracingReqLink();
	}
	@Test(priority=1)
	public void verifyCasesLabel() throws IOException{
		
		tracingrequest.verifyTracingReqLabelPresent();
		TestUtil.takeScreenshotAtEndOfTest();
	}
	

	@DataProvider
	public Object[][] getTestDataFromExcel_SearchCases() throws EncryptedDocumentException, IOException
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}

/*	
	@Test(priority=2, dataProvider = "getTestDataFromExcel_SearchCases")


	*/
	@Test(priority=2)
	public void createTR() throws InterruptedException
	{
		tracingrequest.createNewTR();
		tracingrequest.addTR();
	}
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
