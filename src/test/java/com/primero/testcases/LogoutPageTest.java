package com.primero.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.primero.base.TestBase;
import com.primero.pages.HomePage;
import com.primero.pages.LoginPage;
import com.primero.util.TestUtil;

public class LogoutPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	
	public LogoutPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homePage=loginpage.loginApplication(prop.getProperty("cpusernameqa"), prop.getProperty("password"));

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
	public void verifyLogoutTest()
	{
	homePage.logoutApplication();
	TestUtil tuobj = new TestUtil();
	tuobj.waitForElementToAppear(loginpage.loginBtn_By);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
