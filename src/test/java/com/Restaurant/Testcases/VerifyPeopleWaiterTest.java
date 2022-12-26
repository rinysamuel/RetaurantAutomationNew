package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyPeopleWaiterTest extends Baseclass {
	@Test(priority = 1, groups = {"Add"})

	public void VerifyWaiterAdd() throws InterruptedException {
		Log.startTestCase("VerifyAddWaiter");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Pw.AddWaiterForm();
		Assert.assertTrue(Pw.SearchWaitersforAdd(),"Waiter is not added");
		Log.endTestCase("VerifyAddWaiter");

	}

	@Test(priority = 2)
	public void verifyeditwaiter() throws InterruptedException {
		Log.startTestCase("VerifyEditWaiter");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Pw.EditWaiters();
		Assert.assertTrue(Pw.WaiterConfirmEdit(), "Waiter is not edited");
		Log.endTestCase("VerifyEditWaiter");

	}

	@Test(priority = 3)
	public void WaiterDelete() throws InterruptedException {
		Log.startTestCase("VerifyDeleteWaiter");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Pw.WaiterDelete();
		Assert.assertTrue(Pw.ConfirmDelete(), "Waiter not deleted");
		Log.endTestCase("VerifyDeleteWaiter");
	}

}