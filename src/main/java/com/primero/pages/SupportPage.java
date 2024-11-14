package com.primero.pages;




import java.util.Random;
import java.util.random.RandomGenerator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.primero.base.TestBase;
import com.primero.util.TestUtil;

//import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class SupportPage extends TestBase{
		
	TestUtil tuobj = new TestUtil();
	
	By Support_Label = By.xpath("//*[contains(text(),'Setting')]");
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/div/div/div/div/div[2]/div[2]")
	WebElement orgname;
	
	public By toastermsg_case = By.className("MuiSnackbarContent-message"); 
	
	@FindBy(id="notistack-snackbar")
	WebElement toastermsg;
	
	
	public String typeValue="";
	TestUtil tu;
	By Elmnt = By.xpath("//*[@id=\"root\"]/div/main/div/div/header/div/div[1]/h1");

	
	public SupportPage()
		{
			PageFactory.initElements(driver, this);
		}
		 

	public void verifySupportLabelPresent()
		{
		tuobj.waitForElementToAppear(Support_Label);
		}
	public void validateOrgName() throws InterruptedException {
		String text_orgname = orgname.getText();
		System.out.println(text_orgname);
		Assert.assertEquals(text_orgname, "Organization name","Toaster message doesnt matched.");
		Thread.sleep(2000);
	}
	

	}
	
