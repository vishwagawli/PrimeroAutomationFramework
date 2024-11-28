package com.primero.testcases_MarkOfflineCases;

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
import com.primero.pages.MarkOffline_IncidentPage;
import com.primero.util.TestUtil;

public class CP_Add_Incident_Markoffline extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	//IncidentPage incidentpage;
	MarkOffline_IncidentPage mo_incidentpage;
	
	String sheetName = "incident";
	
	public CP_Add_Incident_Markoffline() {
		super();
	}

	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("cpusername"), prop.getProperty("password"));
		mo_incidentpage = homePage.mo_clickOnIncidentLink();
	}

	@DataProvider
	public Object[][] getTestDataFromExcel_SearchCases() throws EncryptedDocumentException, IOException
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}

	
	@Test(priority=1, dataProvider = "getTestDataFromExcel_SearchCases")
	public void createIncident(String violence, String area, String location, String timeofday, String violencetype) throws Exception{
	
		
	//	TestUtil.getNameFromTable(text);
		mo_incidentpage.makeOffline();
	//	mo_incidentpage.createNewIncident(violence,area,location,timeofday,violencetype);
		mo_incidentpage.mo_edit(violence, area, location, timeofday, violencetype, location, violencetype, location);
		
		
	}
	
	
	
	
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
