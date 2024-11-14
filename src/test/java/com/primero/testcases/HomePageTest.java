package com.primero.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.primero.base.TestBase;
import com.primero.pages.CasesPage;
import com.primero.pages.HomePage;
import com.primero.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CasesPage casespage;
	
	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("cpusername1"), prop.getProperty("password"));
	}
	@Test(priority=1)
	
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Primero","Home page title not matched");
	}
	
	@Test(priority=2)
		public void verifyHomeTextTest()
	{
		//String HomeText = homePage.verifyHomeText();
		Assert.assertEquals(homePage.verifyHomeText(), "Home","Home page Text not matched");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws InterruptedException{
		
		casespage = homePage.clickOnCasesLink();
		Thread.sleep(4000);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
