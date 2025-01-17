package com.primero.testcases_Report;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primero.base.TestBase;
import com.primero.pages.HomePage;
import com.primero.pages.LoginPage;
import com.primero.pages.ReportPage;
import com.primero.util.TestUtil;

public class Report_EditDelete extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ReportPage reportPage;

	String sheetName = "Approval";

	public Report_EditDelete() {
		super();
	}

	
	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("adminuser"), prop.getProperty("password"));
		Thread.sleep(15000);
		reportPage = new ReportPage();
		
		Thread.sleep(3000);

	}

	@DataProvider
	public Object[][] getTestDataFromExcel_SearchCases() throws EncryptedDocumentException, IOException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getTestDataFromExcel_SearchCases")
	public void addReportTest(String text, String comment) throws Exception {
		System.out.println("Add method");
		Thread.sleep(5000);
		reportPage.createReport();

	
	}

	@Test(priority = 2, dataProvider = "getTestDataFromExcel_SearchCases")
	public void editReportTest(String text, String comment) throws Exception {
		System.out.println("Edit method");
		Thread.sleep(5000);
		reportPage.editReport();
		
		
	}

	@Test(priority = 3, dataProvider = "getTestDataFromExcel_SearchCases")
	public void deleteReportTest(String text, String comment) throws Exception {
		System.out.println("Delete method1");
		Thread.sleep(5000);
		reportPage.deleteReport();
		Thread.sleep(5000);

	}

//	@AfterClass
	public void tearDown() {
		driver.quit();

	}
}
