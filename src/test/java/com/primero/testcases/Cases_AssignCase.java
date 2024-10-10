package com.primero.testcases;

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
import com.primero.pages.LoginPage;
import com.primero.util.TestUtil;

public class Cases_AssignCase extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CasesPage casespage;
	
	String sheetName = "AssignCase";
	
	public Cases_AssignCase() {
		super();
	}

	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("cpusername"), prop.getProperty("password"));
		casespage = homePage.clickOnCasesLink();
	}

	@DataProvider
	public Object[][] getTestDataFromExcel_SearchCases() throws EncryptedDocumentException, IOException
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}

	
	@Test(priority=1, dataProvider = "getTestDataFromExcel_SearchCases")
	public void assignCase(String text,String assignee) throws Exception{
	
		
		TestUtil.getNameFromTable(text);
		casespage.assignCase(assignee);
		
		homePage.logoutApplication();
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("cpusername1"), prop.getProperty("password"));
		casespage = homePage.clickOnCasesLink();
		
		TestUtil.getNameFromTable(text);
		
		casespage.validateassignCase();
		
		
	}
	
	
	
	
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
