package com.primero.testases_Setting;

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
import com.primero.util.TestUtil;

public class Add_Lookup extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	//CasesPage casespage;
	SettingPage settingpage;
	
	String sheetName = "forms_lookup";
	
	public Add_Lookup() {
		super();
	}

	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("adminuser"), prop.getProperty("password"));
		settingpage = homePage.clickOnSettingLink();
	}

	@DataProvider
	public Object[][] getTestDataFromExcel_SearchCases() throws EncryptedDocumentException, IOException
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}

	
	@Test(priority=1, dataProvider = "getTestDataFromExcel_SearchCases")
	//@Test(priority=1)
	public void addLookups(String lookupname, String lookuptext) throws InterruptedException {
		
		settingpage.goToFormTab();
		settingpage.addLookup(lookupname,lookuptext);
		Thread.sleep(9000);
		settingpage.editLookup();
	}
	
	
	
	
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
