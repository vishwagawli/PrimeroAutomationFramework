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

public class CasesPageTest2 extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CasesPage casespage;
	
	String sheetName = "SearchCases";
	
	public CasesPageTest2() {
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
	public void sendSearchBoxData() throws InterruptedException, IOException{
		Thread.sleep(1000);
		driver.findElement(By.id("buttons.new")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("case.create_new_case")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("assessment_due_date")).click();
		TestUtil tu = new TestUtil();
		//tu.selectDate("17", "Jul", "2024");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/button[3]/span")).click();
		Thread.sleep(10000);
	}
	
	
	
	
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
