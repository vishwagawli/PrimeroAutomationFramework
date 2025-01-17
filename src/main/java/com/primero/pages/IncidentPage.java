package com.primero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.primero.base.TestBase;
import com.primero.util.TestUtil;

public class IncidentPage extends TestBase{
		
	TestUtil tuobj = new TestUtil();
	
	By Incident_Label = By.xpath("//*[contains(text(),'Incident')]");
	
	
	@FindBy(id="buttons.new")
	WebElement newBtn;
	
	@FindBy(id="cp_incident_identification_violence")
	WebElement cp_identification_violence;
	
	@FindBy(id="incident_date")
	WebElement incident_date;	
	
	@FindBy(id="cp_incident_location_type")
	WebElement cp_incident_area;
	
	@FindBy(id="incident_location")
	WebElement incident_location;
		
	@FindBy(id="cp_incident_timeofday")
	WebElement cp_incident_time;
	
	@FindBy(id="cp_incident_timeofday_actual")
	WebElement cp_incident_actualtime ;
	
	@FindBy(id="cp_incident_violence_type")
	WebElement cp_incident_violence_type;
	
	@FindBy(name="cp_incident_previous_incidents")
	WebElement cp_incident_previous_abuse;
	
	@FindBy(id="cp_incident_previous_incidents_description")
	WebElement cp_incident_previous_abuse_description;
	
	@FindBy(xpath="/html/body/div[4]/div[3]/div/div[2]/button[3]/span")
	WebElement assDueDateOk_Btn;
	
	String monthyearvaluestring = "/html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/p";
	String NextIconCalendor = "/html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]";
	
	By flaglist = By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/ul/div[1]/div[1]/li[1]");
	
	@FindBy(id="short_id")
	WebElement getcaseid;
	
	public By toastermsg_case = By.id("notistack-snackbar"); 
	
	//@FindBy(className="MuiSnackbarContent-message")
	//WebElement toastermsg;
	@FindBy(id="notistack-snackbar")
	WebElement toastermsg;
	
	@FindBy(id="buttons.save_and_return")
	WebElement saveBtn;
	
	@FindBy(id="cp_offender_details-perpetrator_details")
	WebElement Perpetrator_link;
	
	@FindBy(id="cp_incident_perpetrator_nationality")
	WebElement cp_incident_perpetrator_nationality;
	
	@FindBy(id="cp_incident_perpetrator_age")
	WebElement age_incident;
	
	@FindBy(id="cp_incident_perpetrator_national_id_no")
	WebElement cp_incident_perpetrator_national_id_no;
	
	@FindBy(id="dialog-submit")
	WebElement addBtn;
	
	@FindBy(id="buttons.edit")
	WebElement EditBtn;
	
	@FindBy(id="record-flags")
	WebElement Btn_assignFlag;
	
	@FindBy(id="flag-tab-1")
	WebElement tab_addFlag;
	
	@FindBy(id="message")
	WebElement txt_flagreason;
	
	@FindBy(xpath="//*[@id=\"more-actions\"]")
	WebElement menubar;
	
	@FindBy(xpath="//*[contains(text(),'Disable')]")
	WebElement disableBtn;
	
	@FindBy(xpath="//span[contains(text(),'Disabled')]")
	WebElement disableBtnTab;
	
	
	@FindBy(xpath="//*[contains(text(),'Apply')]")
	WebElement applyBtn;
	
	@FindBy(xpath="//li[contains(text(),'Enable')]")
	WebElement enableBtn;
	
	
	@FindBy(id="submit-form")
	WebElement Btn_resolve;
	
	@FindBy(id="dialog-submit")
	WebElement addServiceBtn;
	
	public String typeValue="";
	
	 TestUtil tu = new TestUtil();
	
	public IncidentPage()
		{
			PageFactory.initElements(driver, this);
		}
		 
	public void verifyTracingReqLabelPresent()
		{
		tuobj.waitForElementToAppear(Incident_Label);
		}
			
	public void createNewIncident(String violence, String area, String location, String timeofday, String violencetype) throws InterruptedException
		{
		Thread.sleep(8000);
		newBtn.click();
		Thread.sleep(1000);
		
		
		cp_identification_violence.clear();
		cp_identification_violence.sendKeys(violence);
		driver.findElement(By.cssSelector("#cp_incident_identification_violence-listbox > li:nth-child(1)")).click();
		
		//incident_date.click();
		//tu.selectDate("17", "Nov", "2025", monthyearvaluestring, NextIconCalendor);
		//assDueDateOk_Btn.click();
		
		cp_incident_area.clear();
		cp_incident_area.sendKeys(area);
		driver.findElement(By.cssSelector("#cp_incident_location_type-listbox > li:nth-child(1)")).click();
		
		incident_location.clear();
		incident_location.sendKeys(location);
		driver.findElement(By.cssSelector("#incident_location-listbox > li:nth-child(1)")).click();
		
		cp_incident_time.clear();
		cp_incident_time.sendKeys(timeofday);
		driver.findElement(By.cssSelector("#cp_incident_timeofday-listbox > li:nth-child(1)")).click();
		
		cp_incident_violence_type.clear();
		cp_incident_violence_type.sendKeys(violencetype);
		driver.findElement(By.cssSelector("#cp_incident_violence_type-listbox > li:nth-child(1)")).click();
		
		saveBtn.click();
		//Incident record successfully created.
		String inci_toastermsg= toastermsg.getText();
		tu.waitForElementToAppear(toastermsg_case);
		Assert.assertEquals(inci_toastermsg, "Incident record successfully created.","Toaster message doesnt matched.");
		
		}
		public void edit_Incident(String nationality, String age, String nationalId ) throws InterruptedException
		{
			String typeValue=getcaseid.getAttribute("value");
			System.out.println("Value of type attribute: "+typeValue);
			Thread.sleep(4000);		Perpetrator_link.click();
			EditBtn.click();
			
			cp_incident_perpetrator_nationality.clear();
			Thread.sleep(2000);
			cp_incident_perpetrator_nationality.sendKeys(nationality);
			driver.findElement(By.cssSelector("#cp_incident_perpetrator_nationality-listbox > li:nth-child(1)")).click();
			age_incident.clear();
			age_incident.sendKeys(Keys.CONTROL + "a");
			age_incident.sendKeys(Keys.DELETE);
			age_incident.sendKeys(age);
			cp_incident_perpetrator_national_id_no.clear();
			cp_incident_perpetrator_national_id_no.sendKeys(nationalId);
			
			saveBtn.click();
			
		//	String inci_toastermsg= toastermsg.getText();
		//	tu.waitForElementToAppear(toastermsg_case);
		//	Assert.assertEquals(inci_toastermsg, "Incident ff7613b was successfully updated.","Toaster message doesnt matched.");
			
		//	tuobj.waitForElementToAppear(toastermsg_case);
			//Case ebc57f1 transfer rejected.
			
			tuobj.waitForElementToAppear(toastermsg_case);
			String txt_toastermsg_assessment= toastermsg.getText();
			System.out.println(txt_toastermsg_assessment);
			
			Assert.assertEquals(txt_toastermsg_assessment, "Incident " + typeValue + " was successfully updated.","Toaster message doesnt matched.");
			
			
			
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
		
		public void disableincident() throws InterruptedException
		{
			Thread.sleep(1000);
			menubar.click();
			Thread.sleep(1000);
			disableBtn.click();
			Thread.sleep(1000);
			addServiceBtn.click();
			String flag_toastermsg= toastermsg.getText();
			System.out.println(flag_toastermsg);
			tu.waitForElementToAppear(toastermsg_case);
			Assert.assertEquals(flag_toastermsg, "Successfully disabled incident","Toaster message doesnt matched.");
			
			
		}
		
		public void PreRequisiteenableIncident() throws InterruptedException
		{
			Thread.sleep(1000);
			//menubar.click();
			//Thread.sleep(1000);
			disableBtnTab.click();
			applyBtn.click();
			Thread.sleep(1000);
		
			
		}
		
		public void enableIncident() throws InterruptedException
		{
			Thread.sleep(1000);
			menubar.click();
			Thread.sleep(1000);
			enableBtn.click();
			//applyBtn.click();
			Thread.sleep(1000);
			addServiceBtn.click();
			String flag_toastermsg= toastermsg.getText();
			System.out.println(flag_toastermsg);
			tu.waitForElementToAppear(toastermsg_case);
			Assert.assertEquals(flag_toastermsg, "Successfully enabled incidents.","Toaster message doesnt matched.");
			
			
		}
}

