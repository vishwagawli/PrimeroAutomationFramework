package com.primero.testcases_incident;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primero.base.TestBase;
import com.primero.pages.CasesPage;
import com.primero.pages.HomePage;
import com.primero.pages.IncidentPage;
import com.primero.pages.LoginPage;
import com.primero.util.TestUtil;

public class CP_Disable_Incident extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	//CasesPage casespage;
	IncidentPage incidentpage;
	
	String sheetName = "SearchCases";
	
	public CP_Disable_Incident() {
		super();
	}

	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("cpusername"), prop.getProperty("password"));
		incidentpage = homePage.clickOnIncidentLink();
	}

	@DataProvider
	public Object[][] getTestDataFromExcel_SearchCases() throws EncryptedDocumentException, IOException
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}

	
	@Test(priority=1, dataProvider = "getTestDataFromExcel_SearchCases")
	public void disableIncident(String text) throws InterruptedException, IOException{
		TestUtil.getNameFromTable(text);
	incidentpage.disableincident();
	
	
	}
	
	
	
	
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
