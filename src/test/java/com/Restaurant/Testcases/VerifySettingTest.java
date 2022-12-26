package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifySettingTest extends Baseclass {
	@Test
	public void VerifyAddUser() throws InterruptedException {
		Log.startTestCase("VerfiyAddUser");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Stp.AddUser();
		Assert.assertTrue(Stp.ConfirmAddUser(), "Add new user not success");
		Log.endTestCase("VerfiyAddUser");
	}
	@Test
	public void VerifyAddWarehouse() throws InterruptedException {
		Log.startTestCase("VerfiyAddWarehouse");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Stp.AddWarehouse();
		Assert.assertTrue(Stp.ConfirmAddWarehouse(), "Add warehouse not success");
		Log.endTestCase("VerfiyAddWarehouse");
	}

}
