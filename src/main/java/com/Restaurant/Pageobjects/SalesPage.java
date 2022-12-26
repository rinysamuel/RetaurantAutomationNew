package com.Restaurant.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Baseclass.Baseclass;

public class SalesPage extends Baseclass{

		// WebDriver driver;

		public SalesPage() {

			PageFactory.initElements(getDriver(), this);
		}
		// For Sales label in header
		@FindBy(xpath = "//span[contains(text(),'Sales')]")
		WebElement SalesLabelHeader;
		
		// For Sales label text on that page
		@FindBy(xpath = "//h3[normalize-space()='Sales']")
		WebElement FormTopSales;
		

		public void VerifySales() throws InterruptedException {
			action.click1(SalesLabelHeader, "Click on Sales Label Header");

		}


		public boolean IsSalesPresent() {
			return action.isDisplayed(getDriver(), FormTopSales);

		}	
		
		
		
}
