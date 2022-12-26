
package com.Restaurant.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Restaurant.Baseclass.Baseclass;

public class PeopleSupplierPage extends Baseclass {

	public PeopleSupplierPage() {

		PageFactory.initElements(getDriver(), this);
	}

	// people
	@FindBy(xpath = "//i[@class='fa fa-users']")
	WebElement people;

	// suppliers
	@FindBy(xpath = "//span[contains(text(),'Suppliers')]")
	WebElement Suppliers;

	// add suppliers
	@FindBy(xpath = "//button[contains(text(),'Add Supplier')]")
	WebElement AddSupp;

	// form header for suppliers
	@FindBy(xpath = "//h4[contains(text(),'Add Supplier')]")
	WebElement FormHeaderSupp;

	// add supplier for suppliername field
	@FindBy(xpath = "//input[@id='SupplierName']")
	WebElement SuppName;

	// add supplier for phone number
	@FindBy(xpath = "//input[@id='SupplierPhone']")
	WebElement SuppPhone;

	// add supplier for email
	@FindBy(xpath = "//input[@id='SupplierEmail']")
	WebElement SuppEmail;

	// add supplier submit
	@FindBy(xpath = "//button[@class='btn btn-add']")
	WebElement SubmitSupp;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchsupplier;

	// Result of search
	@FindBy(xpath = "//table[@id='Table']/tbody/tr/td[1]")
	WebElement SearchName;
	// edit button
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement edit;

	// number drop
	@FindBy(xpath = "//select[@name='Table_length']")
	WebElement Numdrop;

	public void SelectNum() {
		Select sel = new Select(Numdrop);
		sel.selectByIndex(1);

	}

	@FindBy(xpath = "//div[@class='dataTables_info']")
	WebElement ShowEntry;
	@FindBy(xpath = "//a[@class='btn btn-default float-right']")
	WebElement Back;

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

	public void ClickOnSuppliers() {
		action.click1(Suppliers, "Clicking on suppliers");
	}

	public boolean IsAddsuppliersPresent() {
		return action.isDisplayed(getDriver(), AddSupp);

	}

	public boolean IsFormHeaderPresent() {
		return action.isDisplayed(getDriver(), FormHeaderSupp);

	}

	public boolean IsEditSuppBackButonPresent() {
		return action.isDisplayed(getDriver(), Back);
	}

	public void ClickOnAddSupplier() {
		action.moveToElement(getDriver(), AddSupp);
		action.click1(AddSupp, "Clicking on Addwaiters");
	}

	public void AddSupplierForm() {
		action.click1(people, "Clicking on people button");
		action.click1(Suppliers, "Clicking on suppliers");
		action.moveToElement(getDriver(), AddSupp);
		action.click1(AddSupp, "Clicking on Addwaiters");
		action.type(SuppName, "Kuttan");
		action.type(SuppPhone, "9329662233");
		action.type(SuppEmail, "kuttan@gmail.com");
		action.click1(SubmitSupp, "clicking on submit button");

	}

	public void ClickOnSubmitSup() {
		action.click1(SubmitSupp, "clicking on submit button");
	}

	public boolean SearchsuppliersforAdd() {
		action.click1(people, "Clicking on people button");
		action.click1(Suppliers, "Clicking on suppliers");
		action.click1(searchsupplier, "Clicking on search");
		action.type(searchsupplier, "Kuttan");
		String Result = SearchName.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("Kuttan")) {
			status = true;
		}
		return status;
	}

	public void EditSuppliers() {
		action.click1(people, "Clicking on people button");
		action.click1(Suppliers, "Clicking on suppliers");
		action.click1(searchsupplier, "clicking on search");
		action.type(searchsupplier, "sreeja");
		action.click1(edit, "click to edit");
		action.type(SuppEmail, "sreeja111@gmail.com");
		action.click1(SubmitSupp, "clicking on submit button");
	}

	public boolean SuppConfirmEdit() {
		action.click1(people, "Clicking on people button");
		action.click1(Suppliers, "Clicking on suppliers");
		action.click1(searchsupplier, "clicking on search");
		action.type(searchsupplier, "sreeja");
		String Res = SuppEmail.getText();
		boolean status = false;
		if (Res.equalsIgnoreCase("sreeja111@gmail.com"))

		{
			status = true;
		}
		return status;

	}

	public void SupplierDelete() {
		action.click1(people, "Clicking on people button");
		action.click1(Suppliers, "Clicking on suppliers");
		action.click1(searchsupplier, "clicking on search");
		action.type(searchsupplier, "sdg");
		action.click1(Delete, "clicking on delete");
		action.click1(CfmDel, "Confirming the delete has happ");

	}

	public boolean ConfirmDelete() {
		action.click1(people, "Clicking on people button");
		action.click1(Suppliers, "Clicking on suppliers");
		action.click1(searchsupplier, "clicking on search");
		action.type(searchsupplier, "sdg");
		String Ress = Nomatch.getText();
		boolean status = false;
		if (Ress.equalsIgnoreCase("No matching records found")) {
			status = true;
		}
		return status;

	}

}
