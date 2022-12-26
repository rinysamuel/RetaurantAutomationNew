package com.Restaurant.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Baseclass.Baseclass;

public class LanguagePage extends Baseclass {
	public LanguagePage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Language
	@FindBy(xpath = "(//span[@class='caret'])[3]")
	WebElement Language;
	// english language
	@FindBy(xpath = "//a[text()=' English']")
	WebElement English;
	// Heading of 'Choose a store in english'
	@FindBy(xpath = "//h1[contains(text(),' Choose a store ')]")
	WebElement Engheading;
	// Spanish
	@FindBy(xpath = "//a[text()=' Spanish']")
	WebElement Spanish;
	// Heading of 'Choose a store in Spanish'
	@FindBy(xpath = "//h1[contains(text(),' Elige una tienda ')]")
	WebElement SpanishHead;
	// Greek
	@FindBy(xpath = "//a[text()=' Greek']")
	WebElement Greek;
	// Heading of 'Choose a store in Greek'
	@FindBy(xpath = "//h1[contains(text(),' Επιλέξτε ένα κατάστημα ')]")
	WebElement GreekHead;

	public void ClickOnEnglishLanguage() {
		action.click1(Language, "clicking on language dropdown");
		action.click1(English, "clicking on English language ");
	}

	public void ClickOnSpanishLanguage() {
		action.click1(Language, "clicking on language dropdown");
		action.click1(Spanish, "clicking on Spanish language ");
	}

	public void ClickOnGreekLanguage() {
		action.click1(Language, "clicking on language dropdown");
		action.click1(Greek, "clicking on Portugese language ");
	}

	public boolean IsSpanishLanguagePresent() {
		return action.isDisplayed(getDriver(), SpanishHead);
	}

	public boolean IsGreekLanguagePresent() {
		return action.isDisplayed(getDriver(), GreekHead);
	}

	public boolean IsEnglishLanguagePresent() {
		return action.isDisplayed(getDriver(), Engheading);
	}
}
