package com.primero.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.primero.base.TestBase;
import com.primero.pages.HomePage;
import com.primero.pages.LoginPage;

public class InvalidLoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	public InvalidLoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test
	public void invalidloginTest()
	{
		loginpage.loginApplication(prop.getProperty("invalidusername"), prop.getProperty("password"));
		loginpage.validateToaster_InvalodCreds();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
