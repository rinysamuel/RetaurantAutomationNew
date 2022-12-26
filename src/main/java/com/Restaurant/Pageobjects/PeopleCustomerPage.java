package com.Restaurant.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Restaurant.Baseclass.Baseclass;
	
public class PeopleCustomerPage extends Baseclass {

	public PeopleCustomerPage() {

		PageFactory.initElements(getDriver(), this);
	}

	// people
	@FindBy(xpath = "//i[@class='fa fa-users']")
	WebElement people;

	// customer
	@FindBy(xpath = "//span[contains(text(),'Customers')]")
	WebElement Customers;
	// add customer
	@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
	WebElement AddCust;
	// form header for customer
	@FindBy(xpath = "//h4[contains(text(),'Add Customer')]")
	WebElement FormHeaderCust;

	// add customer name
	@FindBy(xpath = "//input[@id='CustomerName']")
	WebElement CustName;

	// add waiter for phone number
	@FindBy(xpath = "//input[@id='CustomerPhone']")
	WebElement CustPhone;

	// add waiter for email
	@FindBy(xpath = "//input[@id='CustomerEmail']")
	WebElement CustEmail;
	// customer discount
	@FindBy(xpath = "//input[@id='CustomerDiscount']")
	WebElement CustDisc;
	// submit button
	@FindBy(xpath = "//button[@class='btn btn-add']")
	WebElement Submit;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchcustomer;

	// Result of search
	@FindBy(xpath = "//table[@id='Table']/tbody/tr/td[1]")
	WebElement SearchName;
	// edit button
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement Editbtncust;
	// back button of edit
	@FindBy(xpath = "//a[@class='btn btn-default float-right']")
	WebElement Back;

	@FindBy(xpath = "//div[@class='dataTables_info']")
	WebElement ShowEntry;

	@FindBy(xpath = "//select[@name='Table_length']")
	WebElement Numdrop;

	@FindBy(id = "Table_info")
	WebElement showentry;

	// delete button
	@FindBy(xpath = "//a[@data-toggle='popover']")
	WebElement Delete;
	// confirm delete
	@FindBy(xpath = "//a[contains(text(),'Yes, delete it!')]")
	WebElement CfmDel;

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement Nomatch;

	public void ClickOnPeople() {
		action.click1(people, "Clicking on people button");
	}

	public void ClickOnCustomers() {
		action.click1(Customers, "Clicking on waiters");
	}

	public boolean IsAddCustomerPresent() {
		return action.isDisplayed(getDriver(), AddCust);

	}

	public void ClickOnAddCustomer() {
		action.moveToElement(getDriver(), AddCust);
		action.click1(AddCust, "Clicking on Addwaiters");
	}

	public boolean IsFormHeaderPresent() {
		return action.isDisplayed(getDriver(), FormHeaderCust);

	}

	public boolean IsEditCustBackButonPresent() {
		return action.isDisplayed(getDriver(), Back);

	}

	public void AddCustomerForm() {
		action.click1(people, "Clicking on people button");
		action.click1(Customers, "Clicking on waiters");
		action.moveToElement(getDriver(), AddCust);
		action.click1(AddCust, "Clicking on Addwaiters");
		action.type(CustName, "Gifty");
		action.type(CustPhone, "8122334466");
		action.type(CustEmail, "gifty@gmail.com");
		action.type(CustDisc, "29");
		action.click1(Submit, "clicking on submit button");

	}

	public boolean SearchCustomersforAdd() {
		action.click1(people, "Clicking on people button");
		action.click1(Customers, "Clicking on waiters");
		action.click1(searchcustomer, "Clicking on search");
		action.type(searchcustomer, "Gifty");
		String Result = SearchName.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("Gifty")) {
			status = true;
		}
		return status;
	}

	public void EditCustomers() {
		action.click1(people, "Clicking on people button");
		action.click1(Customers, "Clicking on waiters");
		action.click1(searchcustomer, "clicking on search");
		action.type(searchcustomer, "Ravi");
		action.click1(Editbtncust, "click to edi");
		action.type(CustEmail, "ravi111@gmail.com");
		action.click1(Submit, "clicking on submit button");
	}

	public boolean ConfirmEditCustomer() {
		action.click1(people, "Clicking on people button");
		action.click1(Customers, "Clicking on waiters");
		action.click1(searchcustomer, "clicking on search");
		action.type(searchcustomer, "Ravi");
		//String Res = CustEmail.getText();
		boolean status = false;
		if (CustEmail.getText().equalsIgnoreCase("ravi111@gmail.com"))

		{
			status = true;
		}
		return status;
	}

	public void CustomerDelete() {
		action.click1(people, "Clicking on people button");
		action.click1(Customers, "Clicking on waiters");
		action.click1(searchcustomer, "clicking on search");
		action.type(searchcustomer, "sfd");
		action.click1(Delete, "clicking on delete");
		action.click1(CfmDel, "Confirming the delete has happ");

	}

	public boolean ConfirmDelete() {
		action.click1(people, "Clicking on people button");
		action.click1(Customers, "Clicking on waiters");
		action.click1(searchcustomer, "clicking on search");
		action.type(searchcustomer, "sfd");
		String Ress = Nomatch.getText();
		boolean status = false;
		if (Ress.equalsIgnoreCase("No matching records found")) {
			status = true;
		}
		return status;

	}
}
