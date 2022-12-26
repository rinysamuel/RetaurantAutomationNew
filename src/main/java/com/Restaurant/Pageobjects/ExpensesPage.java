
package com.Restaurant.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Restaurant.Baseclass.Baseclass;

public class ExpensesPage extends Baseclass {
	// WebDriver driver;

	public ExpensesPage() {

		PageFactory.initElements(getDriver(), this);
	}

	// For Expense label in header
	@FindBy(xpath = "//span[contains(text(),'Expense')]")
	WebElement ExpenseLabelHeader;

	// For Expense label text on that page
	@FindBy(xpath = "//h3[normalize-space()='Expence']")
	WebElement FormTopExpense;

	// Add Expense button
	@FindBy(xpath = "//button[@data-toggle='modal']")
	WebElement AddExpenceButton;

	// Add Expense Label on that form
	@FindBy(xpath = "//h4[@id='myModalLabel']")
	WebElement AddExpenceTextinForm;

	// Form Details
	// Date Field
	@FindBy(xpath = "//input[@id='Date']")
	WebElement FormDate;

	// Selecting Date
	@FindBy(xpath = "//table[@class=' table-condensed']/tbody/tr[4]/td[4]")
	WebElement SelectDate;

	// Reference Field
	@FindBy(xpath = " //input[@id='Reference']")
	WebElement Reference;

	// Category Field
	@FindBy(xpath = "//select[@id ='Category']")
	WebElement CategoryDropdown;

	// Select class for Category Drop down

	public void SelectCategory() {
		Select SelectCategory = new Select(CategoryDropdown);
		SelectCategory.selectByValue("17");
	}

	// Store Field
	@FindBy(xpath = "//select [@id='store_id']")
	WebElement StoreDropdown;

	// Select class for Store Drop down

	public void SelectStore() {
		Select SelectStore = new Select(StoreDropdown);
		SelectStore.selectByValue("168");
	}

	// Amount Field
	@FindBy(xpath = "//input[@id='Amount']")
	WebElement Amount;

	// Submit button
	@FindBy(xpath = "//button[@type ='submit']")
	WebElement SubmitButton;

	// Search box top right
	@FindBy(xpath = "//input[@type='search']")
	WebElement Searchbox;

	// SearchResult
	@FindBy(xpath = "//table[@id='table']/tbody/tr[1]/td[2]")
	WebElement SearchResult;

	// Delete Button
	@FindBy(xpath = "(//a[@title='Delete'])[1]")
	WebElement Delete;

	// YEs Delete Button
	@FindBy(xpath = "(//button[normalize-space()='Yes, delete it!'])[1]")
	WebElement ConfirmDeleteExpence;

	// Ok Button for Delete
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement DeleteOKButton;

	// SearchResult for Delete
	@FindBy(xpath = "//table[@id='table']/tbody/tr[1]/td[2]")
	WebElement SearchResult2;

	// Edit button
	@FindBy(xpath = "((//i[@class='fa fa-pencil'])[1]")
	WebElement EditExpense;
	
	//submit button for edit
	@FindBy(xpath = "((//i[@class='fa fa-pencil'])[1]")
	WebElement EditSubmit;

	// SearchResult for Edit
	@FindBy(xpath = "//table[@id='table']/tbody/tr[1]/td[2]")
	WebElement SearchResult3;

	// No Matching text
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement Nomatch;

	public void AddExpence() throws InterruptedException {
		action.click1(ExpenseLabelHeader, "ClickExpenseLabelHeader");
		action.moveToElement(getDriver(), AddExpenceButton);
		action.click1(AddExpenceButton, "ClickAddExpenceButton");
		action.click1(FormDate, "FormDate");
		action.click1(SelectDate, "SelectDate");
		action.type(Reference, "Kim Danny");
		action.click1(CategoryDropdown, "ClickCategoryDropdown");
		SelectCategory();
		action.click1(StoreDropdown, "StoreDropdown");
		SelectStore();
		action.click1(Amount, "ClickAmount");
		action.type(Amount, "2332");
		action.click1(SubmitButton, "SubmitButton");

	}

	public boolean SearchExpenceforAdd() {
		action.click1(ExpenseLabelHeader, "ExpenseLabelHeader");
		action.click1(Searchbox, "Searchbox");
		action.type(Searchbox, "Kim Danny");
		String Result = SearchResult.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("Kim Danny")) {
			status = true;
		}
		return status;
	}

	public void DeleteExpence() {
		action.click1(ExpenseLabelHeader, "ExpenseLabelHeader");
		action.click1(Searchbox, "Searchbox");
		action.type(Searchbox, "la Garcia");
		action.click1(Delete, "Delete Button");
		action.click1(ConfirmDeleteExpence, "ConfirmDeleteButton");
		action.click1(DeleteOKButton, "DeleteOKExpence");
	}

	public boolean ConfirmDelete() {
		boolean status = false;
		action.click1(Searchbox, "Searchbox");
		action.type(Searchbox, "la Garcia");
		if (Nomatch.getText().equalsIgnoreCase("No matching records found")) {
			status = true;
		}
		return status;

	}

	public void EditExpence() {
		action.click1(ExpenseLabelHeader, "ExpenseLabelHeader");
		action.click1(Searchbox, "Searchbox");
		action.type(Searchbox, "freddy joseph");
		action.click1(EditExpense, "Edit Expense");
		action.type(Reference, "Joseph Edited");
		action.click1(SubmitButton, "SubmitButton");

	}

	public boolean ConfirmEdit() {
		boolean status = false;
		action.click1(Searchbox, "Searchbox");
		action.type(Searchbox, "Joseph");
		if (Reference.getText().equalsIgnoreCase("Joseph Edited")) {
			status = true;

		}
		return status;
	}

	public boolean IsExpensePresent() {
		return action.isDisplayed(getDriver(), ExpenseLabelHeader);

	}

	public boolean IsAddExpensePresent() {
		return action.isDisplayed(getDriver(), AddExpenceTextinForm);

	}

}
