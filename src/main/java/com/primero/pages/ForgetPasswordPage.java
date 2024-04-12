package com.primero.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Link;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import com.primero.base.TestBase;
import com.primero.util.TestUtil;

public class ForgetPasswordPage extends TestBase{
	
	@FindBy(id="login.forgot_password")
	WebElement forgetpwdlink; 
	
	@FindBy(id="email")
	WebElement txt_emailforgetpwd; 
	
	@FindBy(id="dialog-submit")
	WebElement btnok_frgtpwd; 
	
	By toaster_pwdresetlink = By.className("MuiSnackbarContent-action");
	
	@FindBy(id="user.password")
	WebElement txt_setpwd; 
	
	@FindBy(id="user.password_confirmation")
	WebElement txt_setpwdconfirm; 
	
	@FindBy(id="submit-form")
	WebElement Btn_SetPwd; 

	public ForgetPasswordPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickforgetpwd()
	{
		forgetpwdlink.click();
		txt_emailforgetpwd.sendKeys("anything@ijhu7hld.mailosaur.net");
		btnok_frgtpwd.click();
	}
	
	public void validatetoaster()
	{
		TestUtil tuobj = new TestUtil();
		tuobj.waitForElementToAppear(toaster_pwdresetlink);
	}
	
	public void validateEmail() throws IOException, MailosaurException
	{
		 String apiKey = "cNpP2SoPbIuA1ECSteWHyptrJdM0vQIq";
		    String serverId = "ijhu7hld";
		    String serverDomain = "ijhu7hld.mailosaur.net";

		    MailosaurClient mailosaur = new MailosaurClient(apiKey);

		    MessageSearchParams params = new MessageSearchParams();
		    params.withServer(serverId);

		    SearchCriteria criteria = new SearchCriteria();
		    criteria.withSentTo("anything@" +serverDomain);

		    Message message = mailosaur.messages().get(params, criteria);
		    
		    System.out.println(message.to().get(0).email());
		    System.out.println(message.from().get(0).email());
		  //  System.out.println(message.subject());
		    System.out.println(message.text().body());
		    
		    System.out.println("--------------Links---------------");
		    System.out.println(message.html().links().size()); // 2

		    System.out.println("--------------LinksLoops---------------");
		    List<Link> links = message.html().links();
		    String linktoclick = links.get(1).href();
		    System.out.println(linktoclick);
		  //  driver.switchTo().newWindow(WindowType.WINDOW);
		 
		 driver.navigate().to(linktoclick);

	}
	public void setPassword()
	{
		txt_setpwd.sendKeys("Primer0!");
		txt_setpwdconfirm.sendKeys("Primer0!");
		Btn_SetPwd.click();
	}
}

