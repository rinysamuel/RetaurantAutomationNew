package com.Restaurant.Pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Restaurant.Baseclass.Baseclass;

public class ProductPage extends Baseclass {

	public ProductPage() {

		PageFactory.initElements(getDriver(), this);
	}

	// For Product label in header
	@FindBy(xpath = "(//span[@class='menu-text'][normalize-space()='Product'])[1]")
	WebElement ProductLabelHeader;

	// For verifying Product is clicked or not
	@FindBy(xpath = "//label[contains(text(),'Product type')]")
	WebElement Producttype;

	// Add Product button
	@FindBy(xpath = "//button[contains(text(),'Add Product')]")
	WebElement AddProductButton;

	// Add Product Label on that form
	@FindBy(xpath = "//h4[@id='myModalLabel']")
	WebElement AddProductTextinForm;

	// Type Field
	@FindBy(xpath = "//select[@id='Type']")
	WebElement TypeDropdown;

	// Select class for Type Drop down
	public void SelectType() {
		Select SelectType = new Select(TypeDropdown);
		SelectType.selectByValue("1");
	}

	// Code Field
	@FindBy(xpath = "//input[@placeholder='Code']")
	WebElement Code;

	// Name Field
	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement Name;

	// Category Field
	@FindBy(xpath = "//select[@id='Category']")
	WebElement CategoryDropdown;

	// Select class for Category Drop down
	public void SelectCategory() {
		Select SelectCategory = new Select(CategoryDropdown);
		SelectCategory.selectByValue("Pizza");
	}

	// Tax % Field
	@FindBy(xpath = "//input[@placeholder='tax (%)']")
	WebElement Tax;

	// TaxMethod Field
	@FindBy(xpath = "//select[@id='taxType']")
	WebElement TaxMethodDropdown;

	// Select class for TaxMethod down
	public void SelectTaxMethod() {
		Select SelectTaxMethod = new Select(TaxMethodDropdown);
		SelectTaxMethod.selectByValue("1");
	}

	// Price Field
	@FindBy(xpath = "//input[@placeholder='Price']")
	WebElement Price;

	// Product Options
	@FindBy(xpath = "//textarea[@name='options']")
	WebElement ProductOptions;

	// Submit button
	@FindBy(xpath = "(//button[@type='submit'][normalize-space()='Submit'])[1]")
	WebElement SubmitButton;

	// Search box top right
	@FindBy(xpath = "//input[@type='search']")
	WebElement Searchbox1;

	// SearchResult
	@FindBy(xpath = "//table[@id='Table']/tbody/tr[1]/td[2]")
	WebElement SearchResult3;

	// Edit Button
	@FindBy(xpath = "//a[@data-original-title='Edit']")
	WebElement Edit;

	// Delete Icon
	@FindBy(xpath = "//a[@data-original-title='Are you sure ?']")
	WebElement DeleteIcon;

	// Confirm Delete
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	WebElement ConfirmDelete;

	// No Matching text
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement Nomatch;

	// View Product
	@FindBy(xpath = "//i[@data-original-title='View product']")
	WebElement ViewProduct;

	// View Product Text
	@FindBy(xpath = "//h4[contains(text(),'View product')]")
	WebElement ViewProductText;

	// Close for Product
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Close'])[6]")
	WebElement CloseProduct;

	// Print Barcode
	@FindBy(xpath = "//a[@data-target='#barcode']")
	WebElement PrintBarcode;

	// Submit for Barcode
	@FindBy(xpath = "(//button[@onclick='barcode()'])[1]")
	WebElement BarcodeSubmit;

	// Close for Barcode
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Close'])[8]")
	WebElement BarcodeClose;

	// secondClose for Barcode
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Close'])[7]")
	WebElement BarcodesecondClose;

	// Barcode Inside Page
	@FindBy(xpath = "//h4[@id='barcodeP']")
	WebElement StockText;

	public void AddProduct() throws InterruptedException {
		action.click1(ProductLabelHeader, "ClickproductLabelHeader");
		action.moveToElement(getDriver(), AddProductButton);
		action.click1(AddProductButton, "ClickAddProductButton");
		action.click1(TypeDropdown, "ClickTypeDropdown");
		SelectType();
		action.click1(Code, "ClickCode");
		action.type(Code, "BSL112");
		action.click1(Name, "ClickName");
		action.type(Name, "Mutton Kebab");
		action.click1(CategoryDropdown, "ClickCategory");
		SelectCategory();
		action.click1(Tax, "ClickTax");
		action.type(Tax, "14");
		action.click1(TaxMethodDropdown, "ClickTaxMethodDropdown");
		SelectTaxMethod();
		action.click1(Price, "ClickPrice");
		action.type(Price, "550");
		action.moveToElement(getDriver(), ProductOptions);
		action.click1(ProductOptions, "ClickProductOptions");
		action.type(ProductOptions, "Test Product Options");
		action.moveToElement(getDriver(), SubmitButton);
		action.click1(SubmitButton, "SubmitButton");
		action.explicitWait(getDriver(), ProductLabelHeader, Duration.ofSeconds(30));
	}

	public boolean SearchProductforAdd() {
		action.click1(ProductLabelHeader, "ProductLabelHeader");
		action.click1(Searchbox1, "Searchbox");
		action.type(Searchbox1, "Mutton");
		String Result = SearchResult3.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("Mutton Kebab")) {
			status = true;
		}
		return status;
	}

	public void EditProduct() {
		action.click1(ProductLabelHeader, "ProductLabelHeader");
		action.click1(Searchbox1, "Searchbox");
		action.type(Searchbox1, "Barbeque");
		action.click1(Edit, "Edit Product");
		action.type(Code, "BB000");
		action.click1(SubmitButton, "SubmitButton");

	}

	public boolean ConfirmEdit() {
		boolean status = false;
		action.click1(Searchbox1, "Searchbox");
		action.type(Searchbox1, "Barbeque");
		if (Code.getText().equalsIgnoreCase("BB000")) {
			status = true;

		}
		return status;
	}

	public void DeleteProduct() {
		action.click1(ProductLabelHeader, "ProductLabelHeader");
		action.click1(Searchbox1, "Searchbox");
		action.type(Searchbox1, "beef");
		action.click1(DeleteIcon, "Delete Button");
		action.click1(ConfirmDelete, "ConfirmDeleteButton");
	}

	public boolean ConfirmDelete() {
		boolean status = false;
		action.click1(Searchbox1, "Searchbox");
		action.type(Searchbox1, "beef");
		if (Nomatch.getText().equalsIgnoreCase("No matching records found")) {
			status = true;
		}
		return status;

	}

	public boolean IsProductPresent() {
		return action.isDisplayed(getDriver(), Producttype);

	}

	public boolean IsAddProductPresent() {
		return action.isDisplayed(getDriver(), AddProductTextinForm);

	}

	public void ViewProduct() {
		action.click1(ProductLabelHeader, "ProductLabelHeader");
		action.click1(Searchbox1, "Searchbox");
		action.type(Searchbox1, "almond");
		action.click1(ViewProduct, "View Product");
		action.explicitWait(getDriver(), ViewProductText, Duration.ofSeconds(30));

	}

	public void closeProduct() {
		action.click1(CloseProduct, "Close Product");
	}

	public void PrintBarcode() throws InterruptedException {
		action.click1(ProductLabelHeader, "ProductLabelHeader");
		action.click1(Searchbox1, "Searchbox");
		action.type(Searchbox1, "almond");
		action.click1(PrintBarcode, "Barcode");
		action.click1(BarcodeSubmit, "Barcode submit");
		action.explicitWait(getDriver(), StockText, Duration.ofSeconds(20));
	}

	public void closeBarcode() {
		action.click1(BarcodeClose, "Close for Barcode");
		action.click1(BarcodesecondClose, "Second Close");

	}

	public boolean IsViewProductPresent() {
		return action.isDisplayed(getDriver(), ViewProductText);

	}

	public boolean IsBarcodeDisplayed() {
		return action.isDisplayed(getDriver(), StockText);

	}

	public boolean IsAddproductDispalyed() {
		return action.isDisplayed(getDriver(), AddProductButton);
	}

}
