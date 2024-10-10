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
	
	@FindBy(id="submit-form")
	WebElement editBtn;
	
	@FindBy(id="code")
	WebElement usercode_txt;
	
	@FindBy(id="buttons.edit")
	WebElement editBtn_role;
	
	@FindBy(xpath="//*[starts-with(text(),'Apply')]")
	WebElement apply_Btn;
	
	@FindBy(xpath="//*[starts-with(text(),'Disabled')]")
	WebElement disabled_Btn;
	
	@FindBy(xpath="//table[contains(@class,'MuiTable-root')]/tbody/tr")
	WebElement userlist;
	
	@FindBy(xpath="//*[text()='Enabled']")
	WebElement enabled_Btn;
	
	@FindBy(xpath="//*[contains(text(),'Disabled')]/parent::span/preceding-sibling::span/input")
	WebElement chkboxdisabled;
	
	@FindBy(xpath="//*[text()='Enabled / Disabled']/parent::div/parent::div/parent::div/parent::div/following-sibling::div/div/div/div/*[text()='Agency']")
	WebElement AgencyLbl;

	@FindBy(xpath="//*[text()='Enabled / Disabled']/parent::div/parent::div/parent::div/parent::div/following-sibling::div/div/div/div/*[text()='User Group']")
	WebElement usergrpLbl;
	
	@FindBy(xpath="//*[text()='Enabled / Disabled']/parent::div/parent::div/parent::div/parent::div/following-sibling::div/div/following-sibling::div/div/div/div/div/div/div/div/input")
	WebElement agencyDD_sort;
	
	@FindBy(xpath="(//*[text()='Enabled / Disabled']/parent::div/parent::div/parent::div/parent::div/following-sibling::div/div/following-sibling::div)[2]/div/div/div/div/div/div/div/input")
	WebElement usergrpDD_sort;
	
	@FindBy(xpath="//span[contains(text(),'User Group')]")
	WebElement usergroup_tab;
	
	@FindBy(xpath="//span[contains(text(),'Agencies')]")
	WebElement agency_tab;
	
	//*************Role*************
	@FindBy(xpath="//span[contains(text(),'Roles')]")
	WebElement Roles_tab;
	
	
	@FindBy(name="name")
	WebElement name_roles;
	
	@FindBy(id="description")
	WebElement desc_roles;
	
	@FindBy(xpath="//span[contains(text(),'View')]/parent::span/preceding-sibling::span/input")
	WebElement view_caserole;
	
	@FindBy(xpath="//span[contains(text(),'Create')]/parent::span/preceding-sibling::span/input[1]")
	WebElement create_caserole;
	
	@FindBy(xpath="//span[contains(text(),'Edit')]/parent::span/preceding-sibling::span/input[1]")
	WebElement edit_caserole;
	
	@FindBy(xpath="//span[contains(text(),'Flag')]/parent::span/preceding-sibling::span/input[1]")
	WebElement flag_caserole;
	
	@FindBy(xpath="//span[contains(text(),'Resolve any Flag')]/parent::span/preceding-sibling::span/input")
	WebElement resolveflag_caserole;
	
	@FindBy(xpath="//div[@id=\"permissions[incident]\"]/label/span/span[contains(text(),'View')]")
	WebElement view_incidentrole;
	
	@FindBy(xpath="//div[@id=\"permissions[incident]\"]/label/span/span[contains(text(),'Create')]")
	WebElement create_incidentrole;
	
	@FindBy(xpath="//div[@id=\"permissions[tracing_request]\"]/label/span/span[contains(text(),'Create')]")
	WebElement create_TRrole;
	
	
		
	public By toastermsg_case = By.className("MuiSnackbarContent-message"); 
	
	@FindBy(id="notistack-snackbar")
	WebElement toastermsg;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	@FindBy(id="dialog-submit")
	WebElement addBtn;
	
	@FindBy(id="buttons.edit")
	WebElement EditBtn;
	
	@FindBy(id="dialog-submit")
	WebElement addServiceBtn;
	
	public String typeValue="";
	
	@FindBy(id="description")
	WebElement desc_role;
	
	@FindBy(id="agency_unique_ids")
	WebElement agencydd_usergrp;
	
	 TestUtil tu = new TestUtil();
	 
//**********Agency ***********
	 @FindBy(id="agency_code")
	 WebElement agencycode_agency;
	 
	 @FindBy(id="name.en")
	 WebElement name_agency;
	 
	 @FindBy(id="description.en")
	 WebElement desc_agency;
	 
	 @FindBy(id="services")
	 WebElement agency_services;
	 
	 
	 
	
	public SettingPage()
		{
			PageFactory.initElements(driver, this);
		}
		 
	public void verifySettingLabelPresent()
		{
		tuobj.waitForElementToAppear(Setting_Label);
		}
	

	public void goToRoleTab() throws InterruptedException
	{
		Thread.sleep(1000);
		Roles_tab.click();
		Thread.sleep(1000);
		
	}
	public void goToUserGroupTab() throws InterruptedException
	{
		Thread.sleep(1000);
		usergroup_tab.click();
		Thread.sleep(1000);
	}
	public void goToAgencyTab() throws InterruptedException
	{
		Thread.sleep(1000);
		agency_tab.click();
		Thread.sleep(1000);
	}
	public void addUserGroup(String name, String desc, String agency) throws InterruptedException
	{
		Thread.sleep(1000);
		newBtn.click();
		Thread.sleep(1000);
		name_roles.sendKeys(name);
		desc_role.sendKeys(desc);
		
		agencydd_usergrp.clear();
		agencydd_usergrp.sendKeys(agency);
		driver.findElement(By.cssSelector("#agency_unique_ids-listbox > li:nth-child(1)")).click();
		Thread.sleep(1000);
		//User Group was successfully created.
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", saveBtn);
			//addBtn.click();
		//	User was successfully created.
			String txt_toastermsg_acceptref= toastermsg.getText();
			System.out.println(txt_toastermsg_acceptref);
			Assert.assertEquals(txt_toastermsg_acceptref, "User Group was successfully created.","Toaster message doesnt matched.");
		Thread.sleep(2000);
		
	}
	public void editRole(String desc) throws InterruptedException
	{
		Thread.sleep(1000);
	//	Roles_tab.click();
		//TestUtil.getNameFromTable("CP Case Worker");
		editBtn_role.click();
		Thread.sleep(1000);
		desc_role.clear();
		desc_role.sendKeys(desc);
		saveBtn.click();
		
		String txt_toastermsg_acceptref= toastermsg.getText();
		System.out.println(txt_toastermsg_acceptref);
		Assert.assertEquals(txt_toastermsg_acceptref, "Role was successfully updated.","Toaster message doesnt matched.");
	Thread.sleep(2000);
		
	}
	
	public void editAgency(String desc) throws InterruptedException
	{
		Thread.sleep(1000);
		editBtn.click();
		Thread.sleep(1000);
		desc_agency.clear();
		desc_agency.sendKeys(desc);
		saveBtn.click();
		
		String txt_toastermsg_acceptref= toastermsg.getText();
		System.out.println(txt_toastermsg_acceptref);
		Assert.assertEquals(txt_toastermsg_acceptref, "Agency was successfully updated.","Toaster message doesnt matched.");
	Thread.sleep(2000);
		
	}
	
	public void editUserGroup(String desc) throws InterruptedException
	{
		Thread.sleep(1000);
	//	Roles_tab.click();
		//TestUtil.getNameFromTable("CP Case Worker");
		editBtn.click();
		Thread.sleep(1000);
		desc_role.clear();
		desc_role.sendKeys(desc);
		saveBtn.click();
		
		String txt_toastermsg_acceptref= toastermsg.getText();
		System.out.println(txt_toastermsg_acceptref);
		Assert.assertEquals(txt_toastermsg_acceptref, "User Group was successfully updated.","Toaster message doesnt matched.");
	Thread.sleep(2000);
		
	}
		
	
	public void editUser(String usercode_t) throws InterruptedException
	{
		Thread.sleep(1000);
		editBtn.click();
		Thread.sleep(1000);
		usercode_txt.clear();
		usercode_txt.sendKeys(usercode_t);
		saveBtn.click();
		
		String txt_toastermsg_acceptref= toastermsg.getText();
		System.out.println(txt_toastermsg_acceptref);
		Assert.assertEquals(txt_toastermsg_acceptref, "User was successfully updated.","Toaster message doesnt matched.");
	Thread.sleep(2000);
		
	}
	public void createNewUser(String fullname_txt,String username_txt, String pwd_txt, String confirmpwd_txt, String userrole, String usrgrp, String email_txt,String agency_txt, String locatn) throws InterruptedException
	{
		Thread.sleep(1000);
		newBtn.click();
		Thread.sleep(1000);
		//saveBtn.click();
		fullname.sendKeys(fullname_txt);
		username.sendKeys(username_txt);
		
		pwdDD.clear();
		pwdDD.sendKeys("I will Set");
		driver.findElement(By.cssSelector("#password_setting-listbox > li:nth-child(1)")).click();
		Thread.sleep(1000);
		
		pwd.sendKeys(pwd_txt);
		confirmpwd.sendKeys(confirmpwd_txt);
		
		roleDD.clear();
		roleDD.sendKeys(userrole);
		driver.findElement(By.cssSelector("#role_unique_id-listbox > li:nth-child(1)")).click();
		
		userGrpDD.clear();
		userGrpDD.sendKeys(usrgrp);
		driver.findElement(By.cssSelector("#user_group_unique_ids-listbox > li:nth-child(1)")).click();
	
		emailID.sendKeys(email_txt);
		
		agencyDD.clear();
		agencyDD.sendKeys(agency_txt);
		driver.findElement(By.cssSelector("#agency_id-listbox > li:nth-child(1)")).click();
		
		locationDD.clear();
		locationDD.sendKeys(locatn);
		driver.findElement(By.cssSelector("#location-listbox > li:nth-child(1)")).click();
		Thread.sleep(1000);
	//saveBtn.sendKeys(Keys.ENTER);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", saveBtn);
		addBtn.click();
	//	User was successfully created.
		String txt_toastermsg_acceptref= toastermsg.getText();
		System.out.println(txt_toastermsg_acceptref);
		Assert.assertEquals(txt_toastermsg_acceptref, "User was successfully created.","Toaster message doesnt matched.");
	Thread.sleep(2000);
	}
		public void getAgency() throws InterruptedException
		{
			Thread.sleep(1000);
			AgencyLbl.click();
			Thread.sleep(1000);
			agencyDD_sort.clear();
			agencyDD_sort.sendKeys("UNICEF");
			agencyDD_sort.sendKeys(Keys.ARROW_DOWN);
			agencyDD_sort.sendKeys(Keys.ENTER);
			//driver.findElement(By.cssSelector("#:rf3:-listbox > li:nth-child(1)")).click();
			Thread.sleep(1000);
			userlist.isDisplayed();
		}
		
		public void getUserGroup() throws InterruptedException
		{
			Thread.sleep(1000);
			usergrpLbl.click();
			Thread.sleep(1000);
			usergrpDD_sort.clear();
			usergrpDD_sort.sendKeys("Primero");
			usergrpDD_sort.sendKeys(Keys.ARROW_DOWN);
			usergrpDD_sort.sendKeys(Keys.ENTER);
			//driver.findElement(By.cssSelector("#:rf3:-listbox > li:nth-child(1)")).click();
			Thread.sleep(1000);
			apply_Btn.click();
			Thread.sleep(1000);
			userlist.isDisplayed();
		}
	
		public void getDisabledRole() throws InterruptedException
		{
			Thread.sleep(1000);
			disabled_Btn.click();
			Thread.sleep(1000);
			enabled_Btn.click();
			Thread.sleep(1000);
			apply_Btn.click();
			Thread.sleep(1000);
			
			if(userlist.isDisplayed())
			{
				userlist.click();
				System.out.println("The checkbox is selection state is - " + chkboxdisabled.isSelected());
			}
			
		}
		
		public void getDisabledUser() throws InterruptedException
	{
		Thread.sleep(1000);
		disabled_Btn.click();
		Thread.sleep(1000);
		enabled_Btn.click();
		Thread.sleep(1000);
		apply_Btn.click();
		Thread.sleep(1000);
		
		if(userlist.isDisplayed())
		{
			userlist.click();
			System.out.println("The checkbox is selection state is - " + chkboxdisabled.isSelected());
		}
		
	}
	
	
		public void addAgency(String name, String acode, String desc, String service) throws InterruptedException
		{
			Thread.sleep(1000);
			newBtn.click();
			Thread.sleep(1000);
			name_agency.sendKeys(name + Math.random());
			agencycode_agency.sendKeys(acode + Math.random());
			desc_agency.sendKeys(desc);
			agency_services.clear();
			agency_services.sendKeys(service);
			driver.findElement(By.cssSelector("#services-listbox > li:nth-child(1)")).click();
			Thread.sleep(1000);
			Thread.sleep(3000);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", saveBtn);
			//	addBtn.click();
			//	User was successfully created.
				String txt_toastermsg_acceptref= toastermsg.getText();
				System.out.println(txt_toastermsg_acceptref);
				Assert.assertEquals(txt_toastermsg_acceptref, "Agency was successfully created.","Toaster message doesnt matched.");
			Thread.sleep(2000);
		}
	public void addRole() throws InterruptedException
	{
		Thread.sleep(1000);
		Roles_tab.click();
		Thread.sleep(1000);
		newBtn.click();
		Thread.sleep(1000);
		name_roles.sendKeys("CPCaseWorker_test");
		view_caserole.click();
		create_caserole.click();
		edit_caserole.click();
		flag_caserole.click();
		resolveflag_caserole.click();
		view_incidentrole.click();
		create_incidentrole.click();
		create_TRrole.click();
		Thread.sleep(5000);
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", saveBtn);
		//	addBtn.click();
		//	User was successfully created.
			String txt_toastermsg_acceptref= toastermsg.getText();
			System.out.println(txt_toastermsg_acceptref);
			Assert.assertEquals(txt_toastermsg_acceptref, "Role was successfully created.","Toaster message doesnt matched.");
		Thread.sleep(2000);
	}
	}
	
