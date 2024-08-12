package com.primero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.primero.base.TestBase;
import com.primero.util.TestUtil;

public class TracingRequestPage extends TestBase{
		
	TestUtil tuobj = new TestUtil();
	
	By TracingReq_Label = By.xpath("//h1[contains(text(),'Tracing Req')]");
	
	By caseid_matchedb = By.xpath("//*[@id=\"case.case_id_display-button\"]/span");
	
	@FindBy(id="buttons.new")
	WebElement newBtn;
	
	@FindBy(id="relation_name")
	WebElement nameofInquirer;
	
	@FindBy(id="relation_nickname")
	WebElement nicknameofInquirer;	
	
	@FindBy(id="relation_age")
	WebElement ageofInquirer;
	
	@FindBy(id="relation_language")
	WebElement lang_tr;
	
	@FindBy(id="relation_religion")
	WebElement religion_tr;
	
	@FindBy(id="relation_ethnicity")
	WebElement ethinicity_tr;
	
	@FindBy(id="relation_sub_ethnicity1")
	WebElement subethinicity_tr;
	
	@FindBy(id="relation_address_current")
	WebElement currntaddr;
	
	@FindBy(id="relation_location_current")
	WebElement currentlcation;
	
	@FindBy(name="separation_evacuation")
	WebElement chk_sepration;
	
	@FindBy(id="buttons.save_and_return")
	WebElement save_btn;
	
	public By toastermsg_case = By.className("MuiSnackbarContent-message"); 
	
	@FindBy(className="MuiSnackbarContent-message")
	WebElement toastermsg;
	
	@FindBy(id="short_id")
	WebElement gettrid;
	
	@FindBy(xpath="//*[@id=\"tracing_request_tracing_request-tracing_request\"]/div/span")
	WebElement subTR;
	
	@FindBy(id="buttons.edit")
	WebElement Edit_btn;
	
	@FindBy(id="fields.add")
	WebElement AddTR_btn;
	
	@FindBy(id="tracing_request_status")
	WebElement TRstatus;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="age")
	WebElement age;
	
	@FindBy(id="dialog-submit")
	WebElement addBtn;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/div/div/div[2]/form/div[2]/div/ul/li/a")
	WebElement trlink;
	
	@FindBy(id="tracing_request.find_match")
	WebElement findmatch_btn;
	
	@FindBy(xpath="//*[@id=\"case.case_id_display-button\"]/span")
	WebElement caseid_matched;
	
	@FindBy(id="tracing_request.match")
	WebElement match_Btn;
	
	@FindBy(id="tracing_request.back_to_traces")
	WebElement backtotrace_Btn;
	
	@FindBy(xpath = "//*[contains(text(),'Has Match')]")
	WebElement hasmatched_lbll;
	By hasmatched_lbl = By.xpath("//*[contains(text(),'Has Match')]");
	
	@FindBy(xpath="//h2[contains(text(),'Trace')]/span")
	WebElement traceid;
	
	public String typeValue="";
	
	public TracingRequestPage()
		{
			PageFactory.initElements(driver, this);
		}
		 
	public void verifyTracingReqLabelPresent()
		{
		tuobj.waitForElementToAppear(TracingReq_Label);
		}
			
	public void createNewTR() throws InterruptedException
		{
		Thread.sleep(1000);
		newBtn.click();
		Thread.sleep(1000);
		nameofInquirer.sendKeys("Hiren");
		nicknameofInquirer.sendKeys("Baboo");
		ageofInquirer.sendKeys("44");
		
		lang_tr.clear();
		lang_tr.sendKeys("Language1");
		driver.findElement(By.cssSelector("#relation_language-popup > li:nth-child(1)")).click();
		
		religion_tr.clear();
		religion_tr.sendKeys("Religion2");
		driver.findElement(By.cssSelector("#relation_religion-popup > li:nth-child(1)")).click();
		
		ethinicity_tr.clear();
		ethinicity_tr.sendKeys("Ethnicity2");
		driver.findElement(By.cssSelector("#relation_ethnicity-popup > li:nth-child(1)")).click();
		
		subethinicity_tr.clear();
		subethinicity_tr.sendKeys("Ethnicity4");
		driver.findElement(By.cssSelector("#relation_sub_ethnicity1-popup > li:nth-child(1)")).click();
		
		currntaddr.sendKeys("Address");
		
		currentlcation.clear();
		currentlcation.sendKeys("Country");
		driver.findElement(By.cssSelector("#relation_location_current-popup > li:nth-child(1)")).click();
		
		chk_sepration.click();
		
		save_btn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg= toastermsg.getText();
		System.out.println(txt_toastermsg);
		Assert.assertEquals(txt_toastermsg, "Tracing Request record successfully created.","Toaster message doesnt matched.");
		Thread.sleep(3000);
		
		 typeValue=gettrid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);
		}
	public void addTR() throws InterruptedException
	{
		Edit_btn.click();
		subTR.click();
		AddTR_btn.click();
		
		TRstatus.clear();
		TRstatus.sendKeys("Open");
		driver.findElement(By.cssSelector("#tracing_request_status-popup > li:nth-child(1)")).click();
		
		name.sendKeys("Pratik");
		age.sendKeys("44");
		addBtn.click();
		
		save_btn.click();
		Thread.sleep(2000);
		trlink.click();
		findmatch_btn.click();
		
		tuobj.waitForElementToAppear(caseid_matchedb);
		String caseID_TR = caseid_matched.getText();
		System.out.println("Case ID is" +caseID_TR );
		caseid_matched.click();
		
		String trace_id = traceid.getText();
		Thread.sleep(4000);
		match_Btn.click();
		
		String txt_toastermsg= toastermsg.getText();
		System.out.println(txt_toastermsg);
		Assert.assertEquals(txt_toastermsg, "Successfully matched Trace " + trace_id + " with Case " + caseID_TR + ".","Toaster message doesnt matched.");
		
		
		backtotrace_Btn.click();
		
		tuobj.waitForElementToAppear(hasmatched_lbl);
		
		//Assert.assertEquals(txt_toastermsg, "Tracing Request record successfully created.","Toaster message doesnt matched.");
		//Successfully matched Trace 2d6ffd5 with Case 026f686
	}
	
	public void assignFlag_TR() throws InterruptedException
	{
		
	}
}
