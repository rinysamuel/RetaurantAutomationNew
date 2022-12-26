package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyExpenseTest extends Baseclass {

	@Test(priority = 1)
	public void VerifyAddExpense() throws InterruptedException {
		Log.startTestCase("VerifyAddExpense");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Ep.AddExpence();
		Assert.assertTrue(Ep.SearchExpenceforAdd(), "New Expense is not added");
		Log.endTestCase("VerifyAddExpense");

	}

	@Test(priority = 2)
	public void VerifyDeleteExpense() throws InterruptedException {
		Log.startTestCase("VerifyDeleteExpense");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Ep.DeleteExpence();
		Assert.assertTrue(Ep.ConfirmDelete(), "Searched expense not found");
		Log.endTestCase("VerifyDeleteExpense");

	}

	@Test(priority = 3)
	public void VerifyEditExpense() throws InterruptedException {
		Log.startTestCase("VerifyEditExpense");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Ep.EditExpence();
		Assert.assertTrue(Ep.ConfirmEdit(), "Edit not success");
		Log.endTestCase("VerifyEditExpense");

	}
}
