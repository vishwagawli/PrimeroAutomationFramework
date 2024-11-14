package com.primero.pages;


import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import com.primero.base.TestBase;
import com.primero.util.TestUtil;

//import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class MarkOffline_CasesPage extends TestBase{
	
	 TestUtil tuobj = new TestUtil();
	
	@FindBy(xpath="//*[@id=\"search-input\"]")
	WebElement searchbox;
	
	By Elmnt = By.xpath("//*[@id=\"root\"]/div/main/div/div/header/div/div[1]/h1");
	
	By flaglist = By.xpath("//*[@id=\"simple-tabpanel-0\"]/div/ul/div[1]/div[1]/li[1]");
	
	@FindBy(id="buttons.new")
	WebElement newBtn;
	
	@FindBy(id="case.create_new_case")
	WebElement createnewcaseBtn;
	
	@FindBy(id="case.skip_and_create")
	WebElement createnewcaseBtn1;
	
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
	
	@FindBy(xpath="//*[text()='OK']")
	WebElement assDueDateOk_Btn;
	
	@FindBy(xpath="//*[text()='OK']")
	WebElement DateOk_Btn;
	
	
	@FindBy(id="age")
	WebElement txt_age;
	
	@FindBy(id="sex")
	WebElement sex;
	
	@FindBy(id="buttons.save_and_return")
	WebElement save_btn;
	
	//@FindBy(className="MuiSnackbarContent-message")notistack-snackbar
	//WebElement toastermsg;
	@FindBy(id="notistack-snackbar")
	WebElement toastermsg;
	
	//public By toastermsg_case = By.className("MuiSnackbarContent-message");  
	public By toastermsg_case = By.id("notistack-snackbar");
	public By toastermsg_pdf = By.xpath("(//span[@id=\"client-snackbar\"])[2]");
	
	public By assigncasedd = By.xpath("//*[@id=\"cd1497ed-ca8b-435d-a3d5-c91febad49fa\"]/div[1]/div/div/div/div[2]");
	
	@FindBy(xpath="(//span[@id=\"client-snackbar\"])[2]")
	WebElement toastermsg_pdf_Webel;
	
	@FindBy(id="assessment-assessment")
	WebElement Assesment_Tab;
	
	//@FindBy(name="assessment_requested_on")
	//WebElement Assesment_reqOnDate;
	@FindBy(xpath="//*[@id=\"root\"]/div/main/div/div/div[2]/form/div[7]/div/div/div/div/button")
	WebElement Assesment_reqOnDate;
	
	@FindBy(id="buttons.edit")
	WebElement Edit_btn;
	
	@FindBy(xpath="//*[@id=\"cp_case_plan-case_plan\"]/div/span")
	WebElement CasePlan_Tab;
	
	@FindBy(name="date_case_plan")
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
	
	@FindBy(name="service_implemented_day_time")
	WebElement implementedonDate_DD;
	
	@FindBy(xpath="//*[@id=\"more-actions\"]")
	WebElement menubar;
	
	@FindBy(xpath="//li[contains(text(),'Close')]")
	WebElement closebtn;
	
	//By monthyearval  = By.xpath("/html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/p");
	String monthyearvaluestring = "/html/body/div[4]/div[2]/div/div[1]/div/div[1]/div[1]/div/div";
	// /html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/p
	
	String NextIconCalendor = "/html/body/div[4]/div[2]/div/div[1]/div/div[1]/div[2]/button[2]";
	// 	/html/body/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]
	String serviceImplmented_MonthYrLabel = "/html/body/div[5]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div/div";
	String serviceImplmented_nextIcon = "/html/body/div[5]/div[2]/div/div[1]/div[1]/div[1]/div[2]/button[2]";
	
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
	
	@FindBy(xpath="//li[contains(text(),'Reopen')]")
	WebElement reopenBtn;
	
	@FindBy(xpath="//li[contains(text(),'Disable')]")
	WebElement disable_Btn;
	
	@FindBy(xpath="//li[contains(text(),'Enable')]")
	WebElement enable_Btn;
	
	@FindBy(id = "consent-data_confidentiality")
	WebElement tab_dataConfidentiality;
	
	@FindBy(name="consent_for_services")
	WebElement chk_serviceconsent;
	
	@FindBy(name="consent_reporting")
	WebElement radio_Consent;
	
	@FindBy(name="disclosure_other_orgs")
	WebElement chk_disclosuresharing;
	
	@FindBy(xpath="//*[@id=\"long-menu\"]/div[3]/ul/div/li[1]")
	WebElement menu_refercase;
	
	@FindBy(xpath="//li[contains(text(), 'Transfer Case')]")
	WebElement menu_transfercase;
	
	@FindBy(xpath="//*[@id=\"remote\"]/div/label/span[1]/input")
	WebElement chk_refertoremotsystem;
	
	@FindBy(xpath="//*[@id=\"remoteSystem\"]/div/label/span[1]/input")
	WebElement chk_transferremotesystem;
	
	@FindBy(xpath="//*[@id=\"consent_individual_transfer\"]/div/label/span[1]/input")
	WebElement chk_transferconsent;
		
	@FindBy(id="role")
	WebElement dd_role_refercase;
	
	@FindBy(id="transitioned_to")
	WebElement reciepDD;
	
	@FindBy(id="service")
	WebElement refer_ServiceDD;
	
	@FindBy(id="agency")
	WebElement transfer_agency;
	
	@FindBy(id="transitioned_to_agency")
	WebElement refer_agency_txt;
	
	@FindBy(id="location")
	WebElement refer_loc_txt;
	
	@FindBy(id="transitioned_to_remote")
	WebElement refer_reciepent_txt;
	
	@FindBy(id="notes")
	WebElement txt_Notes_refer;
	
	@FindBy(id="dialog-submit")
	WebElement refer_Btn;
	
	@FindBy(xpath="//*[@id=\"record_owner-record_information\"]/div")
	WebElement recInfotab;
	
	@FindBy(xpath="//*[@id=\"referral-record_information\"]/div")
	WebElement refraltab;
	
	@FindBy(xpath="(//*[@id='more-actions'])[2]")
	WebElement menubar_ref;
	
	@FindBy(xpath="//*[@id=\"more-actions\"]")
	WebElement moreaction_transfercase;
	
	@FindBy(xpath="//*[@id=\"long-menu\"]/div[3]/ul/li")
	WebElement revokeBtn;
	
	@FindBy(xpath="//*[@id=\"long-menu\"]/div[3]/ul/li[1]")
	WebElement acceptBtn;
	
	@FindBy(xpath="//*[contains(text(),'Revoked')]")
	WebElement revokedLabel;
	
	@FindBy(xpath="//*[contains(text(),'Accepted')]")
	WebElement acceptLbl;
	
	@FindBy(xpath="//*[@id=\"long-menu\"]/div[3]/ul/li[2]")
	WebElement rejectBtn;
	
	@FindBy(id="rejected_reason")
	WebElement rejectReason;
	
	@FindBy(xpath="//*[contains(text(),'Rejected')]")
	WebElement rejectLbl;
	
	@FindBy(xpath="//*[@id=\"long-menu\"]/div[3]/ul/div/li[2]")
	WebElement assigncasemenu;
	
	@FindBy(name="notes")
	WebElement txt_NoteAssignMenu;
	
	@FindBy(xpath="//*[@id=\"transfers_assignments-record_information\"]/div/span")
	WebElement assigntransfermenutab;
	
	@FindBy(xpath="//*[@id=\"transfers_assignments-record_information\"]/div/span")
	WebElement menutransfer;
	
	@FindBy(xpath="//*[@id=\"921e895b-080b-423d-901c-6620c5746187\"]/div[1]/div/div[2]/div/div/span")
		WebElement revokedLabel_Transfer;
	
	@FindBy(xpath="//li[contains(text(),'Request Approval')]")
	WebElement menu_reqApproval;
	
	@FindBy(xpath="//li[contains(text(),'Approvals')]")
	WebElement menu_Approval;
	
	@FindBy(xpath="//*[@id=\"outlined-select-approval-native\"]")
	WebElement ReqApp_DD;
	
	@FindBy(xpath="//*[@id=\"menu-\"]/div[3]/ul/li[2]")
	WebElement casplan_dd_reqApproval;
	
	@FindBy(xpath="//*[@id=\"menu-\"]/div[3]/ul/li[3]")
	WebElement closure_dd_reqApproval;
	
	@FindBy(xpath="//*[@id=\"menu-\"]/div[3]/ul/li[4]")
	WebElement actionplan_dd_reqApproval;
	
	@FindBy(xpath="//*[@id=\"menu-\"]/div[3]/ul/li[4]")
	WebElement caseclosure_dd_reqApproval;
	
	@FindBy(id="outlined-multiline-static")
	WebElement commentsAppeoval;
	
	@FindBy(id="cp_case_plan-case_plan")
	WebElement menu_caseplan;
	
	@FindBy(xpath="//*[@id=\"approval_status_case_plan\"]")
	WebElement approvalstatus;
	
	public MarkOffline_CasesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void approvals(String comment) throws InterruptedException
	{
		menubar.click();
		menu_Approval.click();
		commentsAppeoval.sendKeys(comment);
		addServiceBtn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg= toastermsg.getText();
		System.out.println(txt_toastermsg);
		Assert.assertEquals(txt_toastermsg, "Case Plan - Approved","Toaster message doesnt matched.");
		/*menu_caseplan.click();
		Thread.sleep(4000);
		String txt_approvalstatus=approvalstatus.getAttribute("value");
		System.out.println(txt_approvalstatus);
		Assert.assertEquals(txt_approvalstatus, "Approved","Toaster message doesnt matched.");
		
		*/
	}
	public void requestApproval_caseplan() throws InterruptedException
	{
		String typeValue=getcaseid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);
		
		menubar.click();
		menu_reqApproval.click();
		Thread.sleep(2000);
		ReqApp_DD.click();
		casplan_dd_reqApproval.click();
		addServiceBtn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg= toastermsg.getText();
		System.out.println(txt_toastermsg);
		Assert.assertEquals(txt_toastermsg, "Approval requested for Case Plan form.","Toaster message doesnt matched.");
		//Approval requested for Case Plan form.
		
		
	}
	public void requestApproval_caseclosure() throws InterruptedException
	{
		String typeValue=getcaseid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);
		
		menubar.click();
		menu_reqApproval.click();
		Thread.sleep(2000);
		ReqApp_DD.click();
		caseclosure_dd_reqApproval.click();
		addServiceBtn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg= toastermsg.getText();
		System.out.println(txt_toastermsg);
		Assert.assertEquals(txt_toastermsg, "Approval requested for Case closure form.","Toaster message doesnt matched.");
		//Approval requested for Case Plan form.
		
		
	}
	public void revokeTransferCase() throws InterruptedException
	{
		
		recInfotab.click();
		assigntransfermenutab.click();
		Thread.sleep(2000);
		menubar_ref.click();
		Thread.sleep(2000);
		revokeBtn.click();
		addServiceBtn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String revoklbl = revokedLabel_Transfer.getText();
		Assert.assertEquals(revoklbl, "REVOKED","Toaster message doesnt matched.");
				
	}
	public void revokeReferCase() throws InterruptedException
	{	
		
		recInfotab.click();
		refraltab.click();
		Thread.sleep(2000);
		menubar_ref.click();
		Thread.sleep(2000);
		revokeBtn.click();
		addServiceBtn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String revoklbl = revokedLabel.getText();
		Assert.assertEquals(revoklbl, "REVOKED","Toaster message doesnt matched.");
				
	}
	
	public void acceptReferCase() throws InterruptedException
	{
		recInfotab.click();
		refraltab.click();
		Thread.sleep(2000);
		menubar_ref.click();
		Thread.sleep(2000);
		revokeBtn.click();
		addServiceBtn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		
		String txt_toastermsg_acceptref= toastermsg.getText();
		System.out.println(txt_toastermsg_acceptref);
		Assert.assertEquals(txt_toastermsg_acceptref, "Referral accepted.","Toaster message doesnt matched.");
		
		String AceptLbl = acceptLbl.getText();
		System.out.println(AceptLbl);
		Assert.assertEquals(AceptLbl, "ACCEPTED","Toaster message doesnt matched.");
	}
	
	public void rejectReferCase(String reason) throws InterruptedException
	{
		recInfotab.click();
		refraltab.click();
		Thread.sleep(2000);
		menubar_ref.click();
		Thread.sleep(2000);
		rejectBtn.click();
		rejectReason.sendKeys(reason);
		addServiceBtn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		
		String txt_toastermsg_acceptref= toastermsg.getText();
		System.out.println(txt_toastermsg_acceptref);
		Assert.assertEquals(txt_toastermsg_acceptref, "Referral rejected.","Toaster message doesnt matched.");
		
		String rejectLbl1 = rejectLbl.getText();
		System.out.println(rejectLbl1);
		Assert.assertEquals(rejectLbl1, "REJECTED","Toaster message doesnt matched.");
	}
	
	public void acceptTransferCase() throws InterruptedException
	{
		String typeValue=getcaseid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);
		
		recInfotab.click();
		menutransfer.click();
		Thread.sleep(2000);
		menubar_ref.click();
		//moreaction_transfercase.click();
		Thread.sleep(2000);
		acceptBtn.click();
		
		addServiceBtn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		
		String txt_toastermsg_acceptref= toastermsg.getText();
		System.out.println(txt_toastermsg_acceptref);
		Assert.assertEquals(txt_toastermsg_acceptref, "Case transfer successfully accepted.","Toaster message doesnt matched.");
		
	//	String AceptLbl = acceptLbl.getText();
		//System.out.println(AceptLbl);
		//Assert.assertEquals(AceptLbl, "ACCEPTED","Toaster message doesnt matched.");
	}
	
	public void rejectTransferCase(String comment) throws InterruptedException
	{
		String typeValue=getcaseid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);
		
		recInfotab.click();
		menutransfer.click();
		Thread.sleep(2000);
		menubar_ref.click();
		//moreaction_transfercase.click();
		Thread.sleep(2000);
		rejectBtn.click();
		
		rejectReason.sendKeys(comment);
		addServiceBtn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		//Case ebc57f1 transfer rejected.
		
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg_assessment= toastermsg.getText();
		System.out.println(txt_toastermsg_assessment);
		
		Assert.assertEquals(txt_toastermsg_assessment, "Case " + typeValue + " transfer rejected.","Toaster message doesnt matched.");
		
	/*	String rejectLbl1 = rejectLbl.getText();
		System.out.println(rejectLbl1);
		Assert.assertEquals(rejectLbl1, "REJECTED","Toaster message doesnt matched.");
		*/
	}
	
	public void internalReferalcase() throws InterruptedException

	{
		String typeValue=getcaseid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);
		
		menubar.click();
		menu_refercase.click();
		//chk_refertoremotsystem.click();
		
		refer_ServiceDD.clear();
		refer_ServiceDD.sendKeys("Secur");
		driver.findElement(By.cssSelector("#service-listbox > li:nth-child(1)")).click();
		
		reciepDD.clear();
		reciepDD.sendKeys("sandesh");
		driver.findElement(By.cssSelector("#transitioned_to-listbox > li:nth-child(1)")).click();
		
		txt_Notes_refer.sendKeys("Notes");
		refer_Btn.click();
		
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg_assessment= toastermsg.getText();
		System.out.println(txt_toastermsg_assessment);
		
		Assert.assertEquals(txt_toastermsg_assessment, "Case " + typeValue + " successfully referred","Toaster message doesnt matched.");
		
	}
	
	
	public void validateassignCase() throws InterruptedException
	{
		recInfotab.click();
		Thread.sleep(1000);
		assigntransfermenutab.click();
		Thread.sleep(1000);
		tu.waitForElementToAppear(assigncasedd);
	}
	
	public void assignCase(String assignee) throws InterruptedException
	{
		String typeValue=getcaseid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);

		menubar.click();
		assigncasemenu.click();
		
		reciepDD.clear();
		reciepDD.sendKeys(assignee);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#transitioned_to-listbox > li:nth-child(1)")).click();
		
		txt_NoteAssignMenu.sendKeys("Note");
		
		addServiceBtn.click();
		
		
		
		String flag_toastermsg= toastermsg.getText();
		System.out.println(flag_toastermsg);
		tu.waitForElementToAppear(toastermsg_case);
		Assert.assertEquals(flag_toastermsg, "Successfully reassigned","Toaster message doesnt matched.");
		
	}
	
	public void remoteReferCase(String ref,String service, String referagency, String location, String recipent, String notes) throws InterruptedException
	{
		String typeValue=getcaseid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);
		
		/*Edit_btn.click();
		tab_dataConfidentiality.click();
		chk_serviceconsent.click();
		radio_Consent.click();
		chk_disclosuresharing.click();
		save_btn.click();
		Thread.sleep(5000);*/
		menubar.click();
		menu_refercase.click();
		chk_refertoremotsystem.click();
		dd_role_refercase.clear();
		dd_role_refercase.sendKeys(ref);
		driver.findElement(By.cssSelector("#role-listbox > li:nth-child(1)")).click();
		
		refer_ServiceDD.clear();
		refer_ServiceDD.sendKeys(service);
		driver.findElement(By.cssSelector("#service-listbox > li:nth-child(1)")).click();
		
		refer_agency_txt.sendKeys(referagency);
		refer_loc_txt.sendKeys(location);
		refer_reciepent_txt.sendKeys(recipent);
		txt_Notes_refer.sendKeys(notes);
		refer_Btn.click();
		
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg_assessment= toastermsg.getText();
		System.out.println(txt_toastermsg_assessment);
		
		Assert.assertEquals(txt_toastermsg_assessment, "Case " + typeValue + " successfully referred","Toaster message doesnt matched.");
		
		Thread.sleep(5000);
		
	//	tuobj.waitForElementToAppear(toastermsg_pdf);
	//	String toastermsg_pdf_= toastermsg_pdf_Webel.getText();
	//	System.out.println(toastermsg_pdf_);
		
	//	Assert.assertEquals(toastermsg_pdf_, "Successfully generated the export file","Toaster message doesnt matched.");
		
		
	}
	
	public void transferCase(String agency, String recipt, String Notes) throws InterruptedException
	{
		String typeValue=getcaseid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);
		
		/*Edit_btn.click();
		tab_dataConfidentiality.click();
		Thread.sleep(1000);
		chk_serviceconsent.click();
		radio_Consent.click();
		chk_disclosuresharing.click();
		save_btn.click();
		Thread.sleep(5000);*/
		menubar.click();
		menu_transfercase.click();
		chk_transferremotesystem.click();
		chk_transferconsent.click();
		
		transfer_agency.clear();
		transfer_agency.sendKeys(agency);
		driver.findElement(By.cssSelector("#agency-listbox > li:nth-child(1)")).click();
		Thread.sleep(5000);
		reciepDD.clear();
		reciepDD.sendKeys(recipt);
		driver.findElement(By.cssSelector("#transitioned_to-listbox > li:nth-child(1)")).click();
		
		txt_Notes_refer.sendKeys(Notes);
		Thread.sleep(4000);
		refer_Btn.click();
		
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg_assessment= toastermsg.getText();
		System.out.println(txt_toastermsg_assessment);
		
		Assert.assertEquals(txt_toastermsg_assessment, "Successfully transferred","Toaster message doesnt matched.");
		
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
		Assert.assertEquals(flag_toastermsg, "You are currently offline. Your changes will be submitted when you are back online.","Toaster message doesnt matched.");
		
		
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
		Assert.assertEquals(flag_toastermsg, "You are currently offline. Your changes will be submitted when you are back online.","Toaster message doesnt matched.");
		
		
	}
	
	public void enableCase() throws InterruptedException
	{
		Thread.sleep(1000);
		menubar.click();
		Thread.sleep(1000);
		enable_Btn.click();
		Thread.sleep(1000);
		addServiceBtn.click();
		String flag_toastermsg= toastermsg.getText();
		System.out.println(flag_toastermsg);
		tu.waitForElementToAppear(toastermsg_case);
		Assert.assertEquals(flag_toastermsg, "You are currently offline. Your changes will be submitted when you are back online.","Toaster message doesnt matched.");
		
		
	}
	public void mo_createNewCase(String cpmisId, String fname, String lname, String assDuedate, String age) throws InterruptedException
	
	{
		Thread.sleep(8000);
		newBtn.click();
		Thread.sleep(1000);
	//	createnewcaseBtn.click();
		Thread.sleep(3000);
		txt_cpimsid.sendKeys(cpmisId);
		txt_fname.sendKeys(fname);
		txt_lname.sendKeys(lname);
		//assDueDate.click();
		TestUtil tu = new TestUtil();
	//	tu.selectDate("17", "Jul", "2024", monthyearvaluestring, NextIconCalendor);
		//assDueDateOk_Btn.click();
		txt_age.sendKeys(age);
		
		
		sex.clear();
		sex.sendKeys("Male");
		driver.findElement(By.cssSelector("#sex-listbox > li:nth-child(1)")).click();
		
		
		
		save_btn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg= toastermsg.getText();
		System.out.println(txt_toastermsg);
		Assert.assertEquals(txt_toastermsg, "You are currently offline. Your changes will be submitted when you are back online.","Toaster message doesnt matched.");
		Thread.sleep(3000);
		//WebElement one_tab = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/header/div/div[4]/div/div[1]/span/span[1]"));
		//String color_one = one_tab.getCssValue("color");
		//System.out.println("color is ------>" +color_one);
		
		String typeValue=getcaseid.getAttribute("value");
		System.out.println("Value of type attribute: "+typeValue);
		
		//Assessment tab
		Thread.sleep(3000);
		Edit_btn.click();
		Thread.sleep(8000);

		Assesment_Tab.click();
		Thread.sleep(1000);
		Assesment_reqOnDate.click();
		Thread.sleep(1000);
		tu.selectDate("11", "Jul", "2025", monthyearvaluestring, NextIconCalendor);
		assDueDateOk_Btn.click();	
		save_btn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg_assessment= toastermsg.getText();
		System.out.println(txt_toastermsg_assessment);
		
		Assert.assertEquals(txt_toastermsg_assessment, "You are currently offline. Your changes will be submitted when you are back online.","Toaster message doesnt matched.");
		
		//Case Plan Tab
		Thread.sleep(3000);
		Edit_btn.click();
		Thread.sleep(3000);
		CasePlan_Tab.click();
		Thread.sleep(3000);
		CasPlanIntiatedDate.click();
		tu.selectDate("11", "Jul", "2025", monthyearvaluestring, NextIconCalendor);
		assDueDateOk_Btn.click();
		Thread.sleep(3000);
		save_btn.click();
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg_CasePlan= toastermsg.getText();
		System.out.println(txt_toastermsg_CasePlan);
		
		Assert.assertEquals(txt_toastermsg_CasePlan, "You are currently offline. Your changes will be submitted when you are back online.","Toaster message doesnt matched.");
		
		//Services Tab
		Thread.sleep(3000);
		Edit_btn.click();
		Thread.sleep(3000);
		ServicesandFollowup_Tab.click();
		Thread.sleep(3000);
		Services_subTab.click();
		Thread.sleep(3000);
		serviceAdd_btn.click();
		//CarePlan
		serviceresponse_DD.clear();
		serviceresponse_DD.sendKeys("Care");
		driver.findElement(By.cssSelector("#service_response_type-listbox > li:nth-child(1)")).click();
		
		typeofservice_dd.clear();
		typeofservice_dd.sendKeys("Safehouse");
		driver.findElement(By.cssSelector("#service_type-listbox > li:nth-child(1)")).click();
		
		addServiceBtn.click();
		
		//Action Plan
		serviceAdd_btn.click();
		serviceresponse_DD.clear();
		serviceresponse_DD.sendKeys("Action");
		driver.findElement(By.cssSelector("#service_response_type-listbox > li:nth-child(1)")).click();
		
		typeofservice_dd.clear();
		typeofservice_dd.sendKeys("Family Mediation Service");
		driver.findElement(By.cssSelector("#service_type-listbox > li:nth-child(1)")).click();
		
		addServiceBtn.click();
		
		//Service Provision
		Thread.sleep(3000);
		serviceAdd_btn.click();
		Thread.sleep(3000);
		typeofservice_dd.clear();
		typeofservice_dd.sendKeys("Legal Assistance Service");
		driver.findElement(By.cssSelector("#service_type-listbox > li:nth-child(1)")).click();
		
		addServiceBtn.click();
		
		save_btn.click();
		
		
		tuobj.waitForElementToAppear(toastermsg_case);
		String txt_toastermsg_servicesPlan= toastermsg.getText();
		System.out.println(txt_toastermsg_servicesPlan);
		
		Assert.assertEquals(txt_toastermsg_servicesPlan, "You are currently offline. Your changes will be submitted when you are back online.","Toaster message doesnt matched.");
		Thread.sleep(3000);
		//Services Tab to Implement date
				Edit_btn.click();
				Thread.sleep(3000);
				//ServicesandFollowup_Tab.click();
				//Services_subTab.click();
				
			List<WebElement> li = driver.findElements(By.id("subform-header-button"));
			
			for (int i =1;i<=li.size();i++)
			{
				Thread.sleep(5000);
				driver.findElement(By.xpath(" //*[@id=\"root\"]/div/main/div/div/div[2]/form/div[2]/div/ul/li["+i+"]/a")).click();
				
				implementedonDate_DD.click();
				tu.selectDate("11", "Aug", "2026", serviceImplmented_MonthYrLabel, serviceImplmented_nextIcon);
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
		Thread.sleep(8000);
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
	@Test
	public void makeOffline()
	{
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
	      devTools.createSession();

	       devTools.send(Network.enable(Optional.of(1000000),Optional.empty(), Optional.empty()));
	        devTools.send(Network.emulateNetworkConditions(true, 0, 0, 0, Optional.empty()));
	       // devTools.send(Network.emulateNetworkConditions(true, 0, 0, 0, Optional.of(ConnectionType.WIFI)));
			
		
	}
}
