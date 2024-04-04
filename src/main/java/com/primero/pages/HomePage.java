package com.primero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primero.base.TestBase;
import com.primero.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//h1[contains(text(), 'Home')]")
	WebElement hometext;
	
	By Elmt = By.xpath("//h1[contains(text(), 'Home')]");
	
	@FindBy(xpath="//*[@id=\"navigation.cases\"]/a")
	WebElement caseshp;
	
	TestUtil tu = new TestUtil();
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public String verifyHomeText()
	{
	//	hometext.isDisplayed();
		
		tu.waitForElementToAppear(Elmt);
		return hometext.getText();
	}
	
	public CasesPage clickOnCasesLink(){
		caseshp.click();
		return new CasesPage();
	}

}
