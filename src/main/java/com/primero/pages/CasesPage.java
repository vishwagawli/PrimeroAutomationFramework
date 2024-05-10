package com.primero.pages;


import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

import com.primero.base.TestBase;
import com.primero.util.TestUtil;

public class CasesPage extends TestBase{
	
	 TestUtil tuobj = new TestUtil();
	
	@FindBy(xpath="//*[@id=\"search-input\"]")
	WebElement searchbox;
	
	By Elmnt = By.xpath("//*[@id=\"root\"]/div/main/div/div/header/div/div[1]/h1");
	
	By flaglist = By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/ul/div[1]/div[1]/li[1]");
	
	@FindBy(id="buttons.new")
	WebElement newBtn;
	
	@FindBy(id="case.create_new_case")
	WebElement createnewcaseBtn;
	
	@FindBy(id="cpims_id")
	WebElement txt_cpimsid;
	
	@FindBy(id="name_first")
	WebElement txt_fname;
	
	@FindBy(id="name_middle")
	WebElement txt_mname;
	
	@FindBy(id="name_last")
	WebElement txt_lname;
	
	@FindBy(id="assessment_due_date")
	WebElement assDueDate;
	
	@FindBy(xpath="/html/body/div[4]/div[3]/div/div[2]/button[3]/span")
	WebElement assDueDateOk_Btn;
	
	@FindBy(xpath="/html/body/div[5]/div[3]/div/div[2]/button[3]")
	WebElement DateOk_Btn;
	
	
	@FindBy(id="age")
	WebElement txt_age;
	
	@FindBy(id="sex")
	WebElement sex;
	
	@FindBy(id="buttons.save_and_return")
	WebElement save_btn;
	
	@FindBy(className="MuiSnackbarContent-message")
	WebElement toastermsg;
	
	public By toastermsg_case = By.className("MuiSnackbarContent-message"); 
	
	@FindBy(xpath="//*[@id=\"assessment-assessment\"]/div/span")
	WebElement Assesment_Tab;
	
	@FindBy(id="assessment_requested_on")
	WebElement Assesment_reqOnDate;
	
	@FindBy(id="buttons.edit")
	WebElement Edit_btn;
	
	@FindBy(xpath="//*[@id=\"cp_case_plan-case_plan\"]/div/span")
	WebElement CasePlan_Tab;
	
	@FindBy(id="date_case_plan")
	WebElement CasPlanIntiatedDate;
	
	@FindBy(xpath="//*[@id=\"care_arrangements-services_follow_up\"]/div/span")
	WebElement ServicesandFollowup_Tab;
	
	@FindBy(xpath="//*[@id=\"services-services_follow_up\"]")
	WebElement Services_subTab;
	
	@FindBy(xpath="//*[@id=\"fields.add\"]")
	WebElement serviceAdd_btn;
	
	@FindBy(id="service_response_type")
	WebElement serviceresponse_DD;
	
	@FindBy(id="service_type")
	WebElement typeofservice_dd;
	
	@FindBy(id="dialog-submit")
	WebElement addServiceBtn;
	
	@FindBy(id="service_implemented_day_time")
	WebElement implementedonDate_DD;
	
	@FindBy(xpath="//*[@id=\"more-actions\"]/span")
	WebElement menubar;
	
	@FindBy(xpath="//*[@id=\"long-menu\"]/div[3]/ul/div/li[5]")
	WebElement closebtn;
	
	//By monthyearval  = By.xpath("/html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/p");
	String monthyearvaluestring = "/html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/p";
	String NextIconCalendor = "/html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]";
	
	String serviceImplmented_MonthYrLabel = "/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/div/p";
	String serviceImplmented_nextIcon = "/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/button[2]";
	
	TestUtil tu = new TestUtil();

	public String txt_toastermsg;
	
	@FindBy(id="case_id_display")
	WebElement getcaseid;
	
	@FindBy(id="record-flags")
	WebElement Btn_assignFlag;
	
	@FindBy(id="flag-tab-1")
	WebElement tab_addFlag;
	
	@FindBy(id="message")
	WebElement txt_flagreason;
	
	@FindBy(id="submit-form")
	WebElement Btn_resolve;
	
	@FindBy(id="unflag_message")
	WebElement reasonunflag;
	
	@FindBy(xpath="//*[@id=\"long-menu\"]/div[3]/ul/div/li[5]")
	WebElement reopenBtn;
	
	@FindBy(xpath="//*[@id=\"long-menu\"]/div[3]/ul/div/li[6]")
	WebElement disable_Btn;
	
	//@FindBy(xpath = "//*[@id=\"long-menu\"]/div[3]/ul/div/li[6]")
	
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
	public void closeCase() throws InterruptedException
	{
		Thread.sleep(1000);
		menubar.click();
		Thread.sleep(1000);
		closebtn.click();
		Thread.sleep(1000);
		addServiceBtn.click();
		String flag_toastermsg= toastermsg.getText();
		System.out.println(flag_toastermsg);
		tu.waitForElementToAppear(toastermsg_case);
		
	}
	public void reopenCase() throws InterruptedException
	{
		Thread.sleep(1000);
		menubar.click();
		Thread.sleep(1000);
		reopenBtn.click();
		Thread.sleep(1000);
		addServiceBtn.click();
		String flag_toastermsg= toastermsg.getText();
		System.out.println(flag_toastermsg);
		tu.waitForElementToAppear(toastermsg_case);
		Assert.assertEquals(flag_toastermsg, "Successfully reopened case","Toaster message doesnt matched.");
		
		
	}
	
	public void disableCase() throws InterruptedException
	{
		Thread.sleep(1000);
		menubar.click();
		Thread.sleep(1000);
		disable_Btn.click();
		Thread.sleep(1000);
		addServiceBtn.click();
		String flag_toastermsg= toastermsg.getText();
		System.out.println(flag_toastermsg);
		tu.waitForElementToAppear(toastermsg_case);
		Assert.assertEquals(flag_toastermsg, "Successfully disabled case","Toaster message doesnt matched.");
		
		
	}
	
	public void enableCase() throws InterruptedException
	{
		Thread.sleep(1000);
		menubar.click();
		Thread.sleep(1000);
		disable_Btn.click();
		Thread.sleep(1000);
		addServiceBtn.click();
		String flag_toastermsg= toastermsg.getText();
		System.out.println(flag_toastermsg);
		tu.waitForElementToAppear(toastermsg_case);
		Assert.assertEquals(flag_toastermsg, "Successfully enabled case","Toaster message doesnt matched.");
		
		
	}
	public void createNewCase(String cpmisId, String fname, String lname, String assDuedate, String age) throws InterruptedException
	
	{
		Thread.sleep(1000);
		newBtn.click();
		Thread.sleep(1000);
		createnewcaseBtn.click();
		txt_cpimsid.sendKeys(cpmisId);
		txt_fname.sendKeys(fname);
		txt_lname.sendKeys(lname);
		assDueDate.click();
		TestUtil tu = new TestUtil();
		tu.selectDate("17", "Jul", "2024", monthyearvaluestring, NextIconCalendor);
		assDueDateOk_Btn.click();
		txt_age.sendKeys(age);
		
		
		sex.clear();
		sex.sendKeys("Male");
		driver.findElement(By.cssSelector("#sex-popup > li:nth-child(1)")).click();
		
		
		
		save_btn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg= toastermsg.getText();
		System.out.println(txt_toastermsg);
		Assert.assertEquals(txt_toastermsg, "Case record successfully created.","Toaster message doesnt matched.");
		Thread.sleep(3000);
		//WebElement one_tab = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/header/div/div[4]/div/div[1]/span/span[1]"));
		//String color_one = one_tab.getCssValue("color");
		//System.out.println("color is ------>" +color_one);
		
		String typeValue=getcaseid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);
		
		//Assessment tab
		Edit_btn.click();
		Assesment_Tab.click();
		Assesment_reqOnDate.click();
		tu.selectDate("17", "Jul", "2024", monthyearvaluestring, NextIconCalendor);
		assDueDateOk_Btn.click();	
		save_btn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg_assessment= toastermsg.getText();
		System.out.println(txt_toastermsg_assessment);
		
		Assert.assertEquals(txt_toastermsg_assessment, "Case " + typeValue + " was successfully updated.","Toaster message doesnt matched.");
		
		//Case Plan Tab
		Edit_btn.click();
		CasePlan_Tab.click();
		CasPlanIntiatedDate.click();
		tu.selectDate("17", "Jul", "2024", monthyearvaluestring, NextIconCalendor);
		assDueDateOk_Btn.click();	
		save_btn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg_CasePlan= toastermsg.getText();
		System.out.println(txt_toastermsg_CasePlan);
		
		Assert.assertEquals(txt_toastermsg_CasePlan, "Case " + typeValue + " was successfully updated.","Toaster message doesnt matched.");
		
		//Services Tab
		Edit_btn.click();
		ServicesandFollowup_Tab.click();
		Services_subTab.click();
		serviceAdd_btn.click();
		//CarePlan
		serviceresponse_DD.clear();
		serviceresponse_DD.sendKeys("Care");
		driver.findElement(By.cssSelector("#service_response_type-popup > li:nth-child(1)")).click();
		
		typeofservice_dd.clear();
		typeofservice_dd.sendKeys("Safehouse");
		driver.findElement(By.cssSelector("#service_type-popup > li:nth-child(1)")).click();
		
		addServiceBtn.click();
		
		//Action Plan
		serviceAdd_btn.click();
		serviceresponse_DD.clear();
		serviceresponse_DD.sendKeys("Action");
		driver.findElement(By.cssSelector("#service_response_type-popup > li:nth-child(1)")).click();
		
		typeofservice_dd.clear();
		typeofservice_dd.sendKeys("Family Mediation Service");
		driver.findElement(By.cssSelector("#service_type-popup > li:nth-child(1)")).click();
		
		addServiceBtn.click();
		
		//Service Provision
		serviceAdd_btn.click();
		typeofservice_dd.clear();
		typeofservice_dd.sendKeys("Legal Assistance Service");
		driver.findElement(By.cssSelector("#service_type-popup > li:nth-child(1)")).click();
		
		addServiceBtn.click();
		
		save_btn.click();
		
		
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg_servicesPlan= toastermsg.getText();
		System.out.println(txt_toastermsg_servicesPlan);
		
		Assert.assertEquals(txt_toastermsg_servicesPlan, "Case " + typeValue + " was successfully updated.","Toaster message doesnt matched.");
		
		//Services Tab to Implement date
				Edit_btn.click();
				//ServicesandFollowup_Tab.click();
				//Services_subTab.click();
				
			List<WebElement> li = driver.findElements(By.id("subform-header-button"));
			
			for (int i =1;i<=li.size();i++)
			{
				Thread.sleep(5000);
				driver.findElement(By.xpath(" //*[@id=\"root\"]/div/main/div/div/div[2]/form/div[2]/div/ul/li["+i+"]/a")).click();
				
				implementedonDate_DD.click();
				tu.selectDate("10", "Aug", "2024", serviceImplmented_MonthYrLabel, serviceImplmented_nextIcon);
				DateOk_Btn.click();	
				Thread.sleep(2000);
				addServiceBtn.click();
			}
			
			save_btn.click();	
				
		
		
	}

	public void assignFlag(String reason) throws InterruptedException
	{
		Btn_assignFlag.click();
		//for(int i=1;i<=5;i++)
		//{
		Thread.sleep(2000);
		tab_addFlag.click();
		Thread.sleep(2000);
		txt_flagreason.sendKeys(reason);
		Thread.sleep(2000);
		addServiceBtn.click();
		String flag_toastermsg= toastermsg.getText();
		System.out.println(flag_toastermsg);
		tu.waitForElementToAppear(toastermsg_case);
		Assert.assertEquals(flag_toastermsg, "Flag added successfully","Toaster message doesnt matched.");
		Thread.sleep(2000);
		tu.waitForElementToAppear(flaglist);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/ul/div[1]/div[1]/li[1]/div/span/div/div[1]/div[1]/span")).getText());
		
		//List<WebElement> resolve_btns = driver.findElements(By.id("submit-form"));
		
	//	for(int i = 1; i< resolve_btns.size();i++)
		//{
			
			//System.out.println(driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/ul/div[1]/div[" +i+ "]/li[1]/div/span/div/div[1]/div[1]/span")).getText());
		//}
		
	//	}
	}
	
	public void resolveFlag(String reasontounflag) throws InterruptedException
	{
		List<WebElement> resolve_btns = driver.findElements(By.id("submit-form"));
		
		for(int i = 0; i< resolve_btns.size();i++)
		{
			
			//System.out.println(driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/ul/div[1]/div[" +i+ "]/li[1]/div/span/div/div[1]/div[1]/span")).getText());
			driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/ul/div[1]/div[1]/li[1]/div/span/div/div[1]/div[1]/span")).getText();
			driver.findElement(By.id("submit-form")).click();
			reasonunflag.sendKeys(reasontounflag);
			addServiceBtn.click();
			String flag_toastermsg= toastermsg.getText();
			System.out.println(flag_toastermsg);
			tu.waitForElementToAppear(toastermsg_case);
			Assert.assertEquals(flag_toastermsg, "Flag resolved","Toaster message doesnt matched.");
			
			
		}
		
		
		
	}
}
