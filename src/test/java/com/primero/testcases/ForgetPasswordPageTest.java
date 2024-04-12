package com.primero.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;
import com.primero.base.TestBase;
import com.primero.pages.ForgetPasswordPage;
import com.primero.pages.HomePage;
import com.primero.pages.LoginPage;

public class ForgetPasswordPageTest extends TestBase{
	ForgetPasswordPage forgetpasswordpage;
	HomePage homePage;
	
	public ForgetPasswordPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		forgetpasswordpage = new ForgetPasswordPage();
		homePage = new HomePage();
		
	}
	@Test(priority=1)
	public void performForgetPassword()
	{
		forgetpasswordpage.clickforgetpwd();
		forgetpasswordpage.validatetoaster();
	}
	@Test(priority=2)
	public void EmailLink() throws IOException, MailosaurException, InterruptedException
	{
		forgetpasswordpage.validateEmail();
		Thread.sleep(3000);
		forgetpasswordpage.setPassword();
		homePage.verifyHomeText();
		Thread.sleep(3000);
	 
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

