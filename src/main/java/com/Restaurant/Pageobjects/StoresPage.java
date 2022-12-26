package com.Restaurant.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Baseclass.Baseclass;

public class StoresPage extends Baseclass {
	public StoresPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// store head
	@FindBy(xpath = "//span[contains(text(),'Stores')]")
	WebElement StoreHeader;
	// add store button
	@FindBy(xpath = "//button[contains(text(),'Add Store')]")
	WebElement AddStoreBtn;
	// Add Form Header
	@FindBy(xpath = "//h4[contains(text(),'Add Store')]")
	WebElement AddFormHeader;
	// store name
	@FindBy(xpath = "//input[@name='name']")
	WebElement StoreName;
	// store storename
	@FindBy(id = "email")
	WebElement StoreEmail;
	// storephonenumber
	@FindBy(id = "StorePhone")
	WebElement StorePhone;
	// storecountry
	@FindBy(id = "Country")
	WebElement StoreCountry;
	// Store StoreCity
	@FindBy(id = "City")
	WebElement StoreCity;
	@FindBy(name = "adresse")
	WebElement StoreAddress;
	// footer
	@FindBy(xpath = "//input[@name='footer_text']")
	WebElement ReceiptFooter;
	// submit form
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit;
	// search button
	@FindBy(xpath = "//input[@type='search']")
	WebElement Searchbtn;
	// Searchresult
	@FindBy(xpath = "//td[contains(text(),'OMStores')]")
	WebElement SearchResult;
	// edit button
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement EditButton;
	// BackButton
	@FindBy(xpath = "//a[@class='btn btn-default float-right']")
	WebElement BackButton;
	// delete button
	@FindBy(xpath = "//a[@data-original-title='Delete']")
	WebElement Delete;
	// No match records
	@FindBy(xpath = "//td[contains(text(),'No matching records found')]")
	WebElement Nomatch;
	// managetables
	@FindBy(xpath = "//a[@data-original-title='manage Tables']")
	WebElement ManageTable;

	public WebElement Stores() {
		return StoreHeader;

	}

	public WebElement AddStoreButton() {
		return AddStoreBtn;
	}

	public WebElement AddFormHeader() {
		return AddFormHeader;
	}

	public WebElement StoreName() {
		return StoreName;
	}

	public WebElement StoreEmail() {
		return StoreEmail;
	}

	public WebElement Storephone() {
		return StorePhone;
	}

	public WebElement StoreCountry() {
		return StoreCountry;
	}

	public WebElement StoreCity() {
		return StoreCity;
	}

	public WebElement StoreAddres() {
		return StoreAddress;
	}

	public WebElement Footer() {
		return ReceiptFooter;
	}

	public WebElement Search() {
		return Searchbtn;

	}

	public WebElement SearchResult() {
		return SearchResult;
	}

	public WebElement EditButton() {
		return EditButton;
	}

	public WebElement BackButton() {
		return BackButton;
	}

	public WebElement Deletebtn() {
		return Delete;
	}

	public WebElement Nomatchrecords() {
		return Nomatch;
	}

	public WebElement Manageelement() {
		return ManageTable;
	}

	public void ClickOnStores() {
		action.click1(StoreHeader, "Clicking on Stores");
	}

	public boolean IsAddStorePresent() {
		action.moveToElement(getDriver(), AddStoreBtn);
		return action.isDisplayed(getDriver(), AddStoreBtn);
	}

	public void ClickOnAddStore() {
		action.moveToElement(getDriver(), AddStoreBtn);
		action.click1(AddStoreBtn, "Clicking on AddStore");
	}

	public boolean IsAddFormHeaderPresent() {
		return action.isDisplayed(getDriver(), AddFormHeader);
	}

	public void AddStoreForm() {
		action.click1(StoreHeader, "Clicking on Stores");
		action.moveToElement(getDriver(), AddStoreBtn);
		action.click1(AddStoreBtn, "Clicking on AddStore");
		action.type(StoreName, "Omran Store");
		action.type(StoreEmail, "jaffar@gmail.com");
		action.type(StorePhone, "9823453322");
		action.type(StoreCountry, "Saudi Arabia");
		action.type(StoreCity, "Jaffar");
		action.type(StoreAddress, "Al Hassa");
		action.type(ReceiptFooter, "**Jaffar Stores**");
		action.click1(Submit, "clicking on submit button");

	}

	public boolean SearchStoresforAdd() {
		action.click1(StoreHeader, "Clicking on Stores");
		action.click1(Searchbtn, "Clicking on search");
		action.type(Searchbtn, "omran");
		String Result = StoreName.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("Omran Store")) {
			status = true;
		}
		return status;
	}

	public void EditStores() {
		action.click1(StoreHeader, "Clicking on Stores");
		action.click1(Searchbtn, "clicking on search");
		action.type(Searchbtn, "dd");
		action.click1(EditButton, "click to edit athul");
		action.type(StoreName, "DD New");
		//action.moveToElement(getDriver(), Submit);
		action.click1(Submit, "clicking on submit");

	}

	public boolean ConfirmEdit() {
		action.click1(StoreHeader, "Clicking on Stores");
		action.click1(Searchbtn, "cliking on search");
		action.type(Searchbtn, "dd");
		String Res = StoreName.getText();
		boolean status = false;
		if (Res.equalsIgnoreCase("DD New"))

		{
			status = true;
		}
		return status;

	}

	public boolean IsEditStoresBackButonPresent() {
		return action.isDisplayed(getDriver(), BackButton);

	}

	public void StoreDelete() {
		action.click1(StoreHeader, "Clicking on Stores");
		action.click1(Searchbtn, "clicking on search");
		action.type(Searchbtn, "hassa");
		action.click1(Delete, "clicking on delete");

	}

	public boolean ConfirmDelete() {
		action.click1(StoreHeader, "Clicking on Stores");
		action.click1(Searchbtn, "clicking on search");
		action.type(Searchbtn, "hassa");
		String Ress = Nomatch.getText();
		boolean status = false;
		if (Ress.equalsIgnoreCase("No matching records found")) {
			status = true;
		}
		return status;

	}
}
