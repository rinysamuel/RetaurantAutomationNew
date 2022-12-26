package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyLanguageTest extends Baseclass {
	@Test

	public void VerifyLanguagePage() throws InterruptedException {
		Log.startTestCase("VerifyLanguageChange");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Lp1.ClickOnSpanishLanguage();
		Assert.assertTrue(Lp1.IsSpanishLanguagePresent(), "Spanish lang is not present");
		Lp1.ClickOnGreekLanguage();
		Assert.assertTrue(Lp1.IsGreekLanguagePresent(), "Greek lang is not present");
		Lp1.ClickOnEnglishLanguage();
		Assert.assertTrue(Lp1.IsEnglishLanguagePresent(), "English is not present");
		Log.endTestCase("VerifyLanguageChange");

	}

}
