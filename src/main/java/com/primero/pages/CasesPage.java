package com.primero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primero.base.TestBase;
import com.primero.util.TestUtil;

public class CasesPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"search-input\"]")
	WebElement searchbox;
	
	By Elmnt = By.xpath("//*[@id=\"root\"]/div/main/div/div/header/div/div[1]/h1");

	TestUtil tu = new TestUtil();
	
	public CasesPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyCasesLabelPresent()
	{
		tu.waitForElementToAppear(Elmnt);
		
	}
	
	public void sendDataToSearchbox(String text)
	{
		searchbox.sendKeys(text);
	}
}
