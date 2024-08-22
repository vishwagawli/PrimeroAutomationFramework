package com.primero.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.primero.base.TestBase;
import com.primero.util.TestUtil;

public class SettingPage extends TestBase{
		
	TestUtil tuobj = new TestUtil();
	
	By Setting_Label = By.xpath("//*[contains(text(),'Setting')]");
	
	@FindBy(id="buttons.new")
	WebElement newBtn;
	
	@FindBy(id="full_name")
	WebElement fullname;
	
	@FindBy(id="user_name")
	WebElement username;
	
	@FindBy(id="password_setting")
	WebElement pwdDD;
	
	@FindBy(id="password")
	WebElement pwd;
	
	@FindBy(id="password_confirmation")
	WebElement confirmpwd;
	
	@FindBy(id="role_unique_id")
	WebElement roleDD;
	
	@FindBy(id="user_group_unique_ids")
	WebElement userGrpDD;
	
	@FindBy(id="email")
	WebElement emailID;
	
	@FindBy(id="agency_id")
	WebElement agencyDD;
	
	@FindBy(id="location")
	WebElement locationDD;
	
		
	public By toastermsg_case = By.className("MuiSnackbarContent-message"); 
	
	@FindBy(className="MuiSnackbarContent-message")
	WebElement toastermsg;
	
	@FindBy(id="submit-form")
	WebElement saveBtn;
	
	@FindBy(id="dialog-submit")
	WebElement addBtn;
	
	@FindBy(id="buttons.edit")
	WebElement EditBtn;
	
	@FindBy(id="dialog-submit")
	WebElement addServiceBtn;
	
	public String typeValue="";
	
	 TestUtil tu = new TestUtil();
	
	public SettingPage()
		{
			PageFactory.initElements(driver, this);
		}
		 
	public void verifySettingLabelPresent()
		{
		tuobj.waitForElementToAppear(Setting_Label);
		}
	
	public void createNewUser(String fullname_txt,String username_txt, String pwd_txt, String confirmpwd_txt, String userrole, String usrgrp, String email_txt,String agency_txt, String locatn) throws InterruptedException
	{
		Thread.sleep(1000);
		newBtn.click();
		Thread.sleep(1000);
		saveBtn.click();
		fullname.sendKeys(fullname_txt);
		username.sendKeys(username_txt);
		
		pwdDD.clear();
		pwdDD.sendKeys("I will Set");
		driver.findElement(By.cssSelector("#password_setting-popup > li:nth-child(1)")).click();
		Thread.sleep(1000);
		
		pwd.sendKeys(pwd_txt);
		confirmpwd.sendKeys(confirmpwd_txt);
		
		roleDD.clear();
		roleDD.sendKeys(userrole);
		driver.findElement(By.cssSelector("#role_unique_id-popup > li:nth-child(1)")).click();
		
		userGrpDD.clear();
		userGrpDD.sendKeys(usrgrp);
		driver.findElement(By.cssSelector("#user_group_unique_ids-popup > li:nth-child(1)")).click();
	
		emailID.sendKeys(email_txt);
		
		agencyDD.clear();
		agencyDD.sendKeys(agency_txt);
		driver.findElement(By.cssSelector("#agency_id-popup > li:nth-child(1)")).click();
		
		locationDD.clear();
		locationDD.sendKeys(locatn);
		driver.findElement(By.cssSelector("#location-popup > li:nth-child(1)")).click();
		Thread.sleep(2000);
	//saveBtn.sendKeys(Keys.ENTER);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", saveBtn);
	Thread.sleep(2000);
	}
			
	}
