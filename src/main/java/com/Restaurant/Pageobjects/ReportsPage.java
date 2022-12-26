package com.Restaurant.Pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Baseclass.Baseclass;

public class ReportsPage extends Baseclass {

	public ReportsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// reports button
	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	WebElement Reports;

	// top 5 products
	@FindBy(xpath = "//h3[contains(text(),'Top 5 Products this year')]")
	WebElement Top5Prod;
	// Client Stat
	@FindBy(xpath = "//h3[text()='Clients Stats']")
	WebElement ClientsStat;
	// select client Drop down
	@FindBy(xpath = "(//b[@role='presentation'])[1]")
	WebElement SelectClientDrop;
	// Calendar of client
	@FindBy(xpath = "//input[@id='CustomerRange']")
	WebElement ClientCalender;
	// report of client
	@FindBy(xpath = "(//button[contains(text(),'Get Report')])[1]")
	WebElement ClientReport;
	// ClientStat Text
	@FindBy(xpath = "//h4[@id='stats']")
	WebElement ClientStatusText;
	// close button for client stats
	@FindBy(xpath = "//button[text()='Close']")
	WebElement Close;

	// prod Status
	@FindBy(xpath = "(//span[@role='presentation'])[2]")
	WebElement ProductStatus;
	// Prod Stat Text
	@FindBy(xpath = "(//h4[normalize-space()='Stats'])[1]")
	WebElement ProductStatusText;
	// Product dropdown
	@FindBy(xpath = "(//span[@id ='select2-productSelect-container'][1]")
	WebElement SelectProductDrop;
	// productRange
	@FindBy(xpath = "//input[@id='ProductRange']")
	WebElement ProdRange;
	// product report
	@FindBy(xpath = "(//button[contains(text(),'Get Report')])[2]")
	WebElement ProdReport;
	// Product status text
	@FindBy(xpath = "//h4[@id='stats']")
	WebElement ProdStatusText;

	@FindBy(xpath = "//h3[text()='Stock stats']")
	WebElement StoreStat;
	// SelectOmstore
	@FindBy(xpath = "//span[contains(text(),'OMStores')]")
	WebElement SelectStore;
	// regisstore calender
	@FindBy(xpath = "//input[@id='RegisterRange']")
	WebElement RegisCal;
	@FindBy(xpath = "(//button[contains(text(),'Get Report')])[3]")
	WebElement RegReport;

	public void SelectClient() {
		action.click1(Reports, "Clicking on Reports");
		action.moveToElement(getDriver(), ClientsStat);
		action.click1(SelectClientDrop, "Clicking on Select Product");
		action.type(ClientCalender, "01/01/2022 - 12/31/2022");
		action.click1(ClientReport, "Clicking on Report");
		action.explicitWait(getDriver(), ClientStatusText, Duration.ofSeconds(30));
		action.click1(Close, "ClickingonClose");

	}

	public Boolean IsStatPresent() {
		return action.isDisplayed(getDriver(), ClientStatusText);
	}

	public void SelectProduct() {
		action.click1(Reports, "Clicking on Reports");
		action.moveToElement(getDriver(), ProductStatus);
		action.click1(SelectProductDrop, "Clicking on Select Product");
		action.type(ProdRange, "01/01/2022 - 12/31/2022");
		action.click1(ProdReport, "Clicking on Report");
		action.explicitWait(getDriver(), ProductStatusText, Duration.ofSeconds(30));
		action.click1(Close, "ClickingonClose");

	}

	public Boolean IsProductStatPresent() {
		return action.isDisplayed(getDriver(), ProductStatusText);
	}

	public void SelectStore() {
		action.click1(Reports, "Clicking on Reports");
		action.moveToElement(getDriver(), StoreStat);
		action.click1(SelectStore, "Clicking on Select store");
		action.type(RegisCal, "01/01/2022 - 12/31/2022");
		action.click1(RegReport, "Clicking on Report");
		action.explicitWait(getDriver(), ClientStatusText, Duration.ofSeconds(30));
		action.click1(Close, "ClickingonClose");

	}

	public boolean IsReportStatusPresent() {
		return action.isDisplayed(getDriver(), ClientStatusText);
	}

}
