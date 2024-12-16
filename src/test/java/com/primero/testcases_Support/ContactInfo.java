package com.primero.testcases_Support;

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
import com.primero.pages.SettingPage;
import com.primero.pages.SupportPage;
import com.primero.util.TestUtil;

public class ContactInfo extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	//CasesPage casespage;
	SettingPage settingpage;
	SupportPage supportpage;
	String sheetName = "Setting_user";
	
	public ContactInfo() {
		super();
	}

	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("adminuser"), prop.getProperty("password"));
		supportpage = homePage.clickOnSupportLink();
	}

	@DataProvider
	public Object[][] getTestDataFromExcel_SearchCases() throws EncryptedDocumentException, IOException
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=1)
	public void verifySupport() throws IOException{
		
		supportpage.verifySupportLabelPresent();
		TestUtil.takeScreenshotAtEndOfTest();
	}
	@Test(priority=2)
	public void verifyorgName_Support() throws InterruptedException
	{
		settingpage=homePage.clickOnSettingLink();
		settingpage.goTocontactinfoTab();
		settingpage.editContactInfo();
		supportpage=homePage.clickOnSupportLink();
		supportpage.validateOrgName();
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
