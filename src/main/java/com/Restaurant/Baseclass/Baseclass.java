package com.Restaurant.Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.Restaurant.Action.ActionClass;
import com.Restaurant.Pageobjects.ExpensesPage;
import com.Restaurant.Pageobjects.LanguagePage;
import com.Restaurant.Pageobjects.LoginPage;
import com.Restaurant.Pageobjects.PeopleCustomerPage;
import com.Restaurant.Pageobjects.PeopleSupplierPage;
import com.Restaurant.Pageobjects.PeopleWaiterPage;
import com.Restaurant.Pageobjects.ProductPage;
import com.Restaurant.Pageobjects.ReportsPage;
import com.Restaurant.Pageobjects.SalesPage;
import com.Restaurant.Pageobjects.SettingPage;
import com.Restaurant.Pageobjects.StoresPage;
import com.Restaurant.Utilities.ExcelRead;
import com.Restaurant.Utilities.ExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static Properties prop;
	// public static WebDriver driver;
	public static ActionClass action;
	// for All objects
	public static ExpensesPage Ep;
	public static LanguagePage Lp1;
	public static PeopleCustomerPage Pc;
	public static PeopleSupplierPage Ps;
	public static LoginPage Lp;
	public static PeopleWaiterPage Pw;
	public static ProductPage Pp;
	public static ReportsPage Rp;
	public static SalesPage Sp;
	public static StoresPage Sr;
	public static ExcelRead Er;
	public static SettingPage Stp;

	// Thread local driver

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	@BeforeSuite
	public void beforeSuite() {
		ExtentReport.setExtent();
		// used to execute log4j config file(log4j.xml)
		DOMConfigurator.configure("log4j.xml");
	}

	// loadConfig method is to load the configuration
	@BeforeTest
	public void loadConfig() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configurations\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// using TestNg xml file to get the browser instead of taking browser from
	// config file
	@Parameters("Browser")
	@BeforeMethod
	public void firstcall(String browserName) {
		launchApp(browserName);
		Ep = new ExpensesPage();
		Lp1 = new LanguagePage();
		Lp = new LoginPage();
		Pw = new PeopleWaiterPage();
		Pp = new ProductPage();
		Rp = new ReportsPage();
		Sp = new SalesPage();
		Ps = new PeopleSupplierPage();
		Pc = new PeopleCustomerPage();
		Er = new ExcelRead();
		Sr = new StoresPage();
		Stp = new SettingPage();

	}

	public static WebDriver getDriver() {
		return driver.get();

	}

	public void launchApp(String browserName) {

		// String browserName = prop.getProperty("Browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver.set(new FirefoxDriver());
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());
			WebDriverManager.edgedriver().setup();
			// driver = new EdgeDriver();
		}
		// Maximize the screen
		getDriver().manage().window().maximize();
		action = new ActionClass();
		// Implicit TimeOuts
		action.implicitWait(getDriver(), 10);
		// PageLoad TimeOuts
		action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("Url"));
	}

	@DataProvider
	public Object[][] InvalidLoginDatas() {
		Object[][] data = new Object[3][2];
		data[0][0] = "uname";
		data[0][1] = "password";
		data[1][0] = "admin";
		data[1][1] = "pwrod";
		data[2][0] = "login";
		data[2][1] = "pasword";
		return data;

	}

	@AfterMethod
	public void AfterMethods() {
		getDriver().close();

	}

	@AfterSuite
	public void AfterSuite() {
		ExtentReport.endReport();
	}

}