package com.Restaurant.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Baseclass.Baseclass;

public class SettingPage extends Baseclass {
	public SettingPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// setting button
	@FindBy(xpath = "//span[contains(text(),'Setting')]")
	WebElement Setting;

	// Users tab
	@FindBy(xpath = "//a[contains(text(),'Users')]")
	WebElement Users;

	// Add User
	@FindBy(xpath = "//button[@data-target='#AddUser']")
	WebElement AddUser;

	// Username
	@FindBy(xpath = "//input[@id='username']")
	WebElement Username;

	// First name
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement Firstname;

	// Last name
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement Lastname;

	// Email
	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement Email;

	// password
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	// Repeat Password
	@FindBy(xpath = "//input[@id='confirm_password']")
	WebElement Repeatpassword;

	// Submit
	@FindBy(xpath = "(//button[@type='submit'][normalize-space()='Submit'])[2]")
	WebElement Submit;

	// Added user

	@FindBy(xpath = "//table[@class='table']/tbody/tr[3]/td[2]")
	WebElement SearchUser;

	// Warehouse tab
	@FindBy(xpath = "//a[contains(text(),'Warehouses')]")
	WebElement Warehouses;

	// Add Warehouse
	@FindBy(xpath = "//button[@data-target='#AddWarehouse']")
	WebElement AddWarehouse;

	// name
	@FindBy(xpath = "//input[@id='WarehouseName']")
	WebElement WarehouseName;

	// Phone
	@FindBy(xpath = "(//input[@id='WarehousePhone'])[1]")
	WebElement WarehousePhone;

	// Email
	@FindBy(xpath = "(//input[@id='email'])[2]")
	WebElement WarehouseEmail;

	// Address
	@FindBy(xpath = "//input[@id='Adresse']")
	WebElement Address;

	// Submit
	@FindBy(xpath = "(//button[@type='submit'][normalize-space()='Submit'])[3]")
	WebElement SubmitWarehouse;

	// Added Warehouse

	@FindBy(xpath = "(//td[normalize-space()='Workshop'])[1]")
	WebElement SearchWarehouse;

	public void AddUser() {
		action.click1(Setting, "Setting tab");
		action.click1(Users, "Users tab");
		action.moveToElement(getDriver(), AddUser);
		action.click1(AddUser, "Add Users Button");
		action.type(Username, "samuel");
		action.type(Firstname, "MJ");
		action.type(Lastname, "Joseph");
		action.type(Email, "mj@gmail.com");
		action.type(password, "password");
		action.type(Repeatpassword, "password");
		action.moveToElement(getDriver(), Submit);
		action.click1(Submit, "Submit button");

	}

	public boolean ConfirmAddUser() {

		String Result = SearchUser.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("MJ")) {
			status = true;
		}
		return status;
	}

	public void AddWarehouse() {
		action.click1(Setting, "Setting tab");
		action.click1(Warehouses, "Users tab");
		action.moveToElement(getDriver(), AddWarehouse);
		action.click1(AddWarehouse, "Add Warehouse Button");
		action.type(WarehouseName, "Workshop");
		action.type(WarehousePhone, "8122663355");
		action.type(WarehouseEmail, "workshop@gmail.com");
		action.type(Address, "Test");
		action.moveToElement(getDriver(), SubmitWarehouse);
		action.click1(SubmitWarehouse, "Submit button");

	}

	public boolean ConfirmAddWarehouse() {

		String Result = SearchWarehouse.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("Workshop")) {
			status = true;
		}
		return status;
	}
}
