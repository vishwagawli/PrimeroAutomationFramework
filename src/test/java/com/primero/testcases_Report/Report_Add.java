package com.primero.testcases_Report;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primero.base.TestBase;
import com.primero.pages.CasesPage;
import com.primero.pages.HomePage;
import com.primero.pages.LoginPage;
import com.primero.pages.ReportPage;
import com.primero.util.TestUtil;

public class Report_Add extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ReportPage reportPage;

	String sheetName = "Approval";

	public Report_Add() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("adminuser"), prop.getProperty("password"));
		Thread.sleep(15000);
		reportPage = new ReportPage();

	}

	@DataProvider
	public Object[][] getTestDataFromExcel_SearchCases() throws EncryptedDocumentException, IOException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getTestDataFromExcel_SearchCases")
	public void CreateReport(String text, String comment) throws Exception {
		System.out.println("Add method");
	

		Thread.sleep(2000);

		reportPage.createReport();

		//reportPage.clickOnRightArrow();
		//Thread.sleep(25000);

	}

	// @AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
