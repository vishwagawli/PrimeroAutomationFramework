package com.primero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primero.base.TestBase;
import com.primero.util.TestUtil;

public class LoginPage extends TestBase{
	
	@FindBy(id="user_name")
	WebElement username; 
	
	@FindBy(id="password")
	WebElement pwd; 
	
	@FindBy(id="login-form-button")
	WebElement loginBtn;
	
	public By loginBtn_By = By.id("login-form-button");
	
By Elmt = By.xpath("//h1[contains(text(), 'Home')]");
By toastermsg_invalidcreds = By.className("MuiSnackbarContent-message"); 
	
	@FindBy(xpath="//h1[contains(text(), 'Home')]")
	WebElement hometext;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage loginApplication(String email, String password)
	{
		username.sendKeys(email);
		pwd.sendKeys(password);
		loginBtn.click();
		
		return new HomePage();
	}
public void validateElement()
	
	{
		TestUtil tuobj = new TestUtil();
		tuobj.waitForElementToAppear(Elmt);
	}
	
	public String validateText()
	{
		return hometext.getText();
	}
public void validateToaster_InvalodCreds()
	
	{
		TestUtil tuobj = new TestUtil();
		tuobj.waitForElementToAppear(toastermsg_invalidcreds);
	}
}
