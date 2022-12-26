package com.Restaurant.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Restaurant.Baseclass.Baseclass;

public class PeopleWaiterPage extends Baseclass {

	public PeopleWaiterPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// people header
	@FindBy(xpath = "//i[@class='fa fa-users']")
	WebElement People;

	// waiters text from header
	@FindBy(xpath = "//span[contains(text(),'Waiters')]")
	WebElement Waiters;

	// add waiter text
	@FindBy(xpath = "//button[contains(text(),'Add Waiter')]")
	WebElement AddWaiter;

	// add waiter form header text
	@FindBy(xpath = "//h4[@id='myModalLabel']")
	WebElement FormHeader;

	// add waiter for waiter name field
	@FindBy(xpath = "//input[@id='WaiterName']")
	WebElement WaiterName;

	// add waiter for phone number
	@FindBy(xpath = "//input[@id='WaiterPhone']")
	WebElement WaiterPhone;

	// add waiter for email
	@FindBy(xpath = "//input[@id='WaiterEmail']")
	WebElement WaiterEmail;

	// add waiter for Store
	@FindBy(xpath = "//select[@id='WaiterStore']")
	WebElement Storedrop;

	public void SelectStore() {
		Select SelectCategory = new Select(Storedrop);
		SelectCategory.selectByValue("168");
	}

	// Show number dropdown
	@FindBy(xpath = "//select[@name='Table_length']")
	WebElement Numdrop;

	public void SelectNum() {
		Select sel = new Select(Numdrop);
		sel.selectByIndex(1);

	}

	@FindBy(xpath = "//div[@class='dataTables_info']")
	WebElement ShowEntry;

	// add waiter submit
	@FindBy(xpath = "//button[@class='btn btn-add']")
	WebElement Submit;

	// search button
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchwaiter;

	// Result of search
	@FindBy(xpath = "//table[@id='Table']/tbody/tr/td[1]")
	WebElement SearchName;
	// edit button
	@FindBy(xpath = "//a[@data-original-title='Edit']")
	WebElement EditBtn;

	// back button when edit is clicked
	@FindBy(xpath = "//a[@class='btn btn-default float-right']")
	WebElement Backbtn;
	// delete button
	@FindBy(xpath = "//a[@data-toggle='popover']")
	WebElement Delete;
	// confirm delete
	@FindBy(xpath = "//a[contains(text(),'Yes, delete it!')]")
	WebElement CfmDel;

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement Nomatch;

	public boolean IsAddWaitersPresent() {
		return action.isDisplayed(getDriver(), AddWaiter);

	}

	public boolean IsFormHeaderPresent() {
		return action.isDisplayed(getDriver(), FormHeader);

	}

	public boolean IsEdiWaitersBackButonPresent() {
		return action.isDisplayed(getDriver(), Backbtn);

	}

	public void AddWaiterForm() {
		action.click1(People, "Clicking on people button");
		action.click1(Waiters, "Clicking on waiters");
		action.moveToElement(getDriver(), AddWaiter);
		action.click1(AddWaiter, "Clicking on Addwaiters");
		action.type(WaiterName, "kim Jacob");
		action.type(WaiterPhone, "8123334559");
		action.type(WaiterEmail, "kim@gmail.com");
		action.click1(Storedrop, "StoreDropdown");
		SelectStore();
		action.click1(Submit, "clicking on submit button");
	}

	public boolean SearchWaitersforAdd() {
		action.click1(People, "Clicking on people button");
		action.click1(Waiters, "Clicking on waiters");
		action.click1(searchwaiter, "Clicking on search");
		action.type(searchwaiter, "kim");
		String Result = SearchName.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("kim Jacob")) {
			status = true;
		}
		return status;
	}

	public void EditWaiters() {
		action.click1(People, "Clicking on people button");
		action.click1(Waiters, "Clicking on waiters");
		action.click1(searchwaiter, "clicking on search");
		action.type(searchwaiter, "Puma");
		action.click1(EditBtn, "click to edit Riny");
		action.type(WaiterName, "Puma Edited New");
		action.type(WaiterPhone, "8123334111");
		action.click1(Submit, "clicking on submit button");

	}

	public boolean WaiterConfirmEdit() {
		action.click1(People, "Clicking on people button");
		action.click1(Waiters, "Clicking on waiters");
		action.click1(searchwaiter, "clicking on search");
		action.type(searchwaiter, "Puma");
		String Result2 = SearchName.getText();
		boolean status = false;
		if (Result2.equalsIgnoreCase("Puma Edited New")) {
			status = true;
		}
		return status;

	}

	public void WaiterDelete() {
		action.click1(People, "Clicking on people button");
		action.click1(Waiters, "Clicking on waiters");
		action.click1(searchwaiter, "clicking on search");
		action.type(searchwaiter, "kedar");
		action.click1(Delete, "clicking on delete");
		action.click1(CfmDel, "Confirming the delete has happ");

	}

	public boolean ConfirmDelete() {
		action.click1(People, "Clicking on people button");
		action.click1(Waiters, "Clicking on waiters");
		action.click1(searchwaiter, "clicking on search");
		action.type(searchwaiter, "kedar");
		String Ress = Nomatch.getText();
		boolean status = false;
		if (Ress.equalsIgnoreCase("No matching records found")) {
			status = true;
		}
		return status;

	}

}
