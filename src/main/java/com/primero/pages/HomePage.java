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
	
	@FindBy(xpath="//*[contains(text(),'Tracing Req')]")
	WebElement tracingreqhp;
	
	@FindBy(xpath="//*[contains(text(),'Incident')]")
	WebElement incidenthp;
	
	@FindBy(xpath="//*[contains(text(),'Setting')]")
	WebElement settinghp;
	
	@FindBy(xpath="//*[contains(text(),'Support')]")
	WebElement supporthp;
	
	@FindBy(xpath="//*[contains(text(),'Log out')]")
	WebElement logoutlink; 
	
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
	
	public MarkOffline_CasesPage mo_clickOnCasesLink(){
		caseshp.click();
		return new MarkOffline_CasesPage();
	}
	public MarkOffline_IncidentPage mo_clickOnIncidentLink(){
		incidenthp.click();
		return new MarkOffline_IncidentPage();
	}
	public TracingRequestPage clickOnTracingReqLink(){
		tracingreqhp.click();
		return new TracingRequestPage();
	}
	
	public IncidentPage clickOnIncidentLink(){
		incidenthp.click();
		return new IncidentPage();
	}
	
	public SettingPage clickOnSettingLink(){
		settinghp.click();
		return new SettingPage();
	}
	
	public SupportPage clickOnSupportLink(){
		supporthp.click();
		return new SupportPage();
	}
	
	public void logoutApplication()
	{
		logoutlink.click();
	}
	
	

}
