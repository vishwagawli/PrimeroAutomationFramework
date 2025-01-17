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

public class Cases_AddNewCasesPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CasesPage casespage;
	
	String sheetName = "AddNewCases";
	
	
	public Cases_AddNewCasesPageTest() {
		super();
	}

	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("cpusername"), prop.getProperty("password"));
		casespage = homePage.clickOnCasesLink();
	}
	/*@Test(priority=1)
	public void verifyCasesLabel() throws IOException{
		
		casespage.verifyCasesLabelPresent();
		TestUtil.takeScreenshotAtEndOfTest();
	}*/
	

	@DataProvider
	public Object[][] getTestDataFromExcel_SearchCases() throws EncryptedDocumentException, IOException
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	

	
	
	@Test(priority=1, dataProvider = "getTestDataFromExcel_SearchCases")
	public void addNewCase(String cpmisId, String fname, String lname, String assDuedate, String age) throws InterruptedException, IOException{
	//	casespage.makeOffline();
	casespage.createNewCase(cpmisId, fname, lname, assDuedate,age);
	//Assert.assertEquals(casespage.txt_toastermsg, "Case record successfully created.","Text not matched");   	
	TestUtil.takeScreenshotAtEndOfTest();
	//Thread.sleep(5000);
	
	homePage.logoutApplication();
	TestUtil tuobj = new TestUtil();
	tuobj.waitForElementToAppear(loginPage.loginBtn_By);
	
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.loginApplication(prop.getProperty("adminuser"), prop.getProperty("password"));
	casespage = homePage.clickOnCasesLink();
	
	String texttosearch = fname +" "+  lname;
	System.out.println(texttosearch); // Make td value 3
	TestUtil.getNameFromTable(texttosearch);  // Make td value 3
	Thread.sleep(10000);
	
	casespage.closeCase();
	Thread.sleep(5000);
	casespage.reopenCase();
	Thread.sleep(5000);
	casespage.disableCase();
	Thread.sleep(5000);
	casespage.enableCase();
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
