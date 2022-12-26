package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyUserLoginTest extends Baseclass {
	@Test (priority =1)
	public void VerifyUserLogin() {
		Log.startTestCase("VerifyUserLogin");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Homepage is not loaded");
		
		Log.endTestCase("VerifyUserLogin");

	}

	@Test(dataProvider = "InvalidLoginDatas",priority =2)

	public void VerifyInvalidUserLogin(String Username, String password) {
		Log.startTestCase("VerifyInvalidUserLogin");
		//Assert.assertTrue(Lp.IsLogoPresent(), "LogInpage is not loaded");
		Lp.InvalidLogin(Username, password);
		Log.endTestCase("VerifyInvalidUserLogin");

	}
	@Test
	public void VerifyLogout()
	{
	Log.startTestCase("VerifyUserLogout");
	Lp.ValidLogin();
	Assert.assertTrue(Lp.IsLogoPresent(), "Homepage is not loaded");
	Lp.ClickLogOut();
	Log.endTestCase("VerifyUserLogout");

}
}