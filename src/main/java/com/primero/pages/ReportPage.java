package com.primero.pages;

import java.time.LocalTime;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.primero.base.TestBase;
import com.primero.util.TestUtil;

public class ReportPage extends TestBase {
	LocalTime myObj = LocalTime.now();// Create a date object
	String dynamicdiscription = "TEST" + myObj;
	String reportName = "";

	String description = "Description" + myObj;

	@FindBy(xpath = "//h1[contains(text(), 'Home')]")
	WebElement hometext;

	By Elmt = By.xpath("//h1[contains(text(), 'Home')]");

	@FindBy(xpath = "//*[@id=\"navigation.cases\"]/a")
	WebElement caseshp;

	@FindBy(xpath = "//*[contains(text(),'Tracing Req')]")
	WebElement tracingreqhp;

	@FindBy(xpath = "//*[contains(text(),'Incident')]")
	WebElement incidenthp;

	@FindBy(xpath = "//*[contains(text(),'Setting')]")
	WebElement settinghp;

	@FindBy(xpath = "//*[contains(text(),'Support')]")
	WebElement supporthp;

	@FindBy(xpath = "//*[contains(text(),'Log out')]")
	WebElement logoutlink;

	@FindBy(xpath = "(//*[contains(text(),'Reports')])[1]")
	WebElement reportlink;

	@FindBy(xpath = "//*[@id='buttons.new']")
	WebElement newlink;

	@FindBy(xpath = "//*[@id='name.en']")
	WebElement name1;
	By name = By.xpath("//*[@id='name.en']");

	@FindBy(xpath = "//*[@id='description.en']")
	WebElement discription;
	By discription1 = By.xpath("//*[@id='description.en']");

	@FindBy(xpath = "(//*[contains(@class, 'css-aik7p')])[1]")
	WebElement clickmodue;
	By clickmodue1 = By.xpath("(//*[contains(@class, 'css-aik7p')])[1]");

	@FindBy(xpath = "//*[contains(text(),'CP')]")
	WebElement clickmodue2;
	By clickmoduex = By.xpath("//*[contains(text(),'CP')]");

	@FindBy(xpath = "(//*[contains(@class, 'css-aik7p')])[2]")
	WebElement Recorddropdown;
	By Recorddropdownx = By.xpath("(//*[contains(@class, 'css-aik7p')])[2]");

	@FindBy(xpath = "//*[contains(text(),'Protection Concern')]")
	WebElement Recorddropdownvalue;
	By Reprotdropdownvaluex = By.xpath("//*[contains(text(),'Protection Concern')]");

	@FindBy(xpath = "(//*[contains(@class, 'css-aik7p')])[3]")
	WebElement Rowddropdown;
	By Rowdropdown = By.xpath("(//*[contains(@class, 'css-aik7p')])[3]");

	@FindBy(xpath = "//*[contains(text(),'Has action been taken?')]")
	WebElement Rowddropdownvalue;
	By Rowdropdownvalue = By.xpath("(//*[contains(@class, 'css-aik7p')])[3]");

	@FindBy(xpath = "(//*[contains(@class, 'css-aik7p')])[4]")
	WebElement columndropdown;
	By columndropdownx = By.xpath("(//*[contains(@class, 'css-aik7p')])[4]");

	@FindBy(xpath = "//*[contains(text(),'Period when identified?')]")
	WebElement columndropdownvalue;
	By columndropdownvaluex = By.xpath("(//*[contains(@class, 'css-aik7p')])[4]");

	@FindBy(xpath = "(//*[@type='checkbox'])[2]")
	WebElement agecheckbox;
	By checkboxx = By.xpath("(//*[@type='checkbox'])[2]");

	@FindBy(xpath = "(//*[contains(@class, 'css-aik7p')])[5]")
	WebElement agedropdown;
	By agedropdownx = By.xpath("(//*[contains(@class, 'css-aik7p')])[5]");

	@FindBy(xpath = "//*[contains(text(),'Month')]")
	WebElement agedropdownvalue;
	By agedropdownvaluex = By.xpath("//*[contains(text(),'Month')]");

	@FindBy(xpath = "(//*[@type='checkbox'])[3]")
	WebElement generatecheckbox;
	By generatecheckboxx = By.xpath("(//*[@type='checkbox'])[3]");

	@FindBy(xpath = "(//*[@id='submit-form'])[3]")
	WebElement submitBTN;

	@FindBy(xpath = "//*[contains(text(),'Edit')]")
	WebElement editBtn;

	@FindBy(xpath = "//*[@id='name.en']")
	WebElement name2;
	By name3 = By.xpath("//*[@id='name.en']");

	@FindBy(xpath = "(//*[@id='submit-form'])[3]")
	WebElement saveBTN2;

	@FindBy(xpath = "//*[@id='description.en']")
	WebElement discription2;
	By discription11 = By.xpath("//*[@id='description.en']");

	@FindBy(xpath = "//*[contains(text(),'Delete')]")
	WebElement deleteBtn;

	@FindBy(xpath = "(//*[contains(text(),'OK')])[2]")
	WebElement reportOKBtn;

	@FindBy(css = ".tCGOKasHfsL72Ju4lW6J")
	WebElement reportLabel;

	@FindBy(xpath = "//*[contains(text(),'Case2_Report-Sandesh')]")
	WebElement reportcase2;

	@FindBy(css = "#report-data-button")
	WebElement reportDownload;

	@FindBy(xpath = "//*[@data-testid='KeyboardArrowRightIcon']")
	WebElement rightArrow;

	TestUtil tu = new TestUtil();

	public ReportPage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public String verifyHomeText() {
		// hometext.isDisplayed();

		tu.waitForElementToAppear(Elmt);
		return hometext.getText();
	}

	public CasesPage clickOnCasesLink() {
		caseshp.click();
		return new CasesPage();
	}

	public MarkOffline_CasesPage mo_clickOnCasesLink() {
		caseshp.click();
		return new MarkOffline_CasesPage();
	}

	public MarkOffline_IncidentPage mo_clickOnIncidentLink() {
		incidenthp.click();
		return new MarkOffline_IncidentPage();
	}

	public TracingRequestPage clickOnTracingReqLink() {
		tracingreqhp.click();
		return new TracingRequestPage();
	}

	public IncidentPage clickOnIncidentLink() {
		incidenthp.click();
		return new IncidentPage();
	}

	public SettingPage clickOnSettingLink() {
		settinghp.click();
		return new SettingPage();
	}

	public SupportPage clickOnSupportLink() {
		supporthp.click();
		return new SupportPage();
	}

	public void logoutApplication() {
		logoutlink.click();
	}

	public void deleteReport() {
		deleteBtn.click();
	}

	public ReportPage createReport() throws InterruptedException {
		reportlink.click(); // report click
		Thread.sleep(2000);

		System.out.println("Click on Report");

		newlink.click(); // newBTN click
		Thread.sleep(2000);

		reportName = "Test" + myObj;

		name1.sendKeys(reportName); // Name click
		Thread.sleep(2000);

		discription.sendKeys(dynamicdiscription);// discription click
		Thread.sleep(2000);

		clickmodue.click(); // click module dropdown
		Thread.sleep(1000);
		clickmodue2.click(); // module dropdown value click
		//Thread.sleep(5000);

		Recorddropdown.click(); // Record dropdown click
		//Thread.sleep(5000);
		Recorddropdownvalue.click(); // record dropdownvalue click
		Thread.sleep(2000);

		Rowddropdown.click();
		Thread.sleep(2000);// Rowddropdown click

		Rowddropdownvalue.click(); // row dropdownvalue click
		Thread.sleep(2000);

		columndropdown.click(); // columndropdown click
		Thread.sleep(2000);
		columndropdownvalue.click(); // columndropdownvalue click
		Thread.sleep(2000);

		agecheckbox.click(); // agecheckbox click
		Thread.sleep(2000);

		agedropdown.click(); // agedropdown click
		Thread.sleep(2000);
		agedropdownvalue.click(); // agedropdownvalue click
		Thread.sleep(2000);

		generatecheckbox.click(); // generatecheckbox click
		Thread.sleep(2000);

		submitBTN.click(); // submitBTN.click();
		Thread.sleep(3000);

		String actualReport = reportLabel.getText();
		System.out.println("Report created success..." + actualReport);
		Assert.assertEquals(actualReport, reportName);

		return new ReportPage();

	}

	public void deleteReport1() throws InterruptedException {
		deleteBtn.click();
		System.out.println("Click on Delete button");
		Thread.sleep(5000);

		reportOKBtn.click();
		System.out.println("Click on OK button");
		Thread.sleep(5000);
	}

	public void editReport() throws InterruptedException {
		String editReportName = "Edit" + myObj;
		editBtn.click();
		System.out.println("Click on Edit button");
		Thread.sleep(5000);

		name2.sendKeys(Keys.CONTROL + "a");
		name2.sendKeys(Keys.DELETE);
		name2.sendKeys(editReportName);
		System.out.println("Clear the data from Name Text field");
		Thread.sleep(5000);

		discription2.sendKeys(Keys.CONTROL + "a");
		discription2.sendKeys(Keys.DELETE);
		discription2.sendKeys(dynamicdiscription);

		System.out.println("Clear the data from Description Text field");
		Thread.sleep(5000);

		saveBTN2.click();
		System.out.println("Click on Save button");
		Thread.sleep(5000);

		String actualReport = reportLabel.getText();
		System.out.println("Report Edited successfully..." + actualReport);
		Assert.assertEquals(actualReport, editReportName);

	}

	public void downloadReport() throws InterruptedException {
		reportlink.click();
		System.out.println(" Clicked on Report link");
		Thread.sleep(5000);

		reportcase2.click();
		System.out.println("Clicked on Report");
		Thread.sleep(5000);

		reportDownload.click();
		System.out.println("Clicked on Download Report");
		Thread.sleep(5000);

	}

	public void searchReport() throws InterruptedException {

		reportlink.click();
		Thread.sleep(5000);

		rightArrow.click();
		Thread.sleep(5000);
	}

	public void clickOnRightArrow() throws InterruptedException {
		reportlink.click();
		Thread.sleep(15000);
		int page = 0;

		try {
			while (rightArrow.isEnabled()) {
				rightArrow.click();
				page++;
				System.out.println("Page..." + page);
			}
		} catch (Exception e) {
			try {
				verifyReportLastPage();
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
		}
		System.out.println(" End of page");

	}

	public void verifyReportLastPage() throws InterruptedException {
		String xpath = "//*[contains(text(),'" + reportName + "')]";

		WebElement reportElement = driver.findElement(By.xpath(xpath));

		System.out.println("Dynamic xpath.." + xpath);

		String actLastReport = reportElement.getText();
		Thread.sleep(15000);
		System.out.println("Report is verified successfully.....");
		Assert.assertEquals(actLastReport, reportName);

	}

}