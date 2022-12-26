package com.Restaurant.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Baseclass.Baseclass;

public class LoginPage extends Baseclass {

	public LoginPage() {

		PageFactory.initElements(getDriver(), this);
	}

	// For Username
	@FindBy(xpath = "//input[@name='username']")
	WebElement Uname;

	public WebElement UserName() {
		return Uname;
	}

	// For Password
	@FindBy(name ="password")
	WebElement PWord;

	public WebElement Password() {
		return PWord;
	}

	// For Login
	@FindBy(xpath = "//input[@name = 'submit']")
	WebElement Submit;

	public WebElement Submitbutton() {
		return Submit;
	}

	// For Logo
	@FindBy(xpath = "//img[@alt ='logo']")
	WebElement Logo;

	public WebElement Logobutton() {
		return Logo;
	}

	// For Login Text
	@FindBy(xpath = "//h1[normalize-space()='Login']")
	WebElement LoginText;

	public WebElement LoginTxt() {
		return LoginText;
	}

	// For Copyright Text
	@FindBy(xpath = "//div[@class='login-help']")
	WebElement Copy;

	public WebElement Copyright() {
		return Copy;
	}
	
	// For Logout Icon
	@FindBy(xpath = "//a[@title = 'Logout']")
	WebElement Logout;

	public WebElement LogoutButton() {
		return Logout;
	}

	public boolean IsLogoPresent() {
		return action.isDisplayed(getDriver(), Logo);

	}

	public void ValidLogin() {
		action.type(Uname, prop.getProperty("Username"));
		action.type(PWord, prop.getProperty("Password"));
		action.click1(Submit, "Clicking on login button");

	}

	public void InvalidLogin(String Username, String password) {
		action.type(UserName(), Username);
		action.type(PWord, password);
		action.click1(Submit, "Loginbutton");

	}

	public void ClickLogOut() {

		action.click1(Logout, "Clicking on logout");
	}

}
