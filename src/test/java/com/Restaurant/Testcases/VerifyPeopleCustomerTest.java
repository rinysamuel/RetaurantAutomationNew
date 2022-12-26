package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyPeopleCustomerTest extends Baseclass {
	@Test(priority = 1, groups = {"Add"})

	public void VerifyWaiterAdd() throws InterruptedException {
		Log.startTestCase("VerifyAddCustomer");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Pc.AddCustomerForm();
		Assert.assertTrue(Pc.SearchCustomersforAdd(),"Customer is not added");
		Log.endTestCase("VerifyAddCustomer");

	}

	@Test(priority = 2)
	public void verifyeditcustomer() throws InterruptedException {
		Log.startTestCase("VerifyEditCustomer");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Pc.EditCustomers();
		Assert.assertFalse(Pc.ConfirmEditCustomer(), "Customer is not edited");
		Log.endTestCase("VerifyEditCustomer");

	}

	@Test(priority = 3)
	public void WaiterDelete() throws InterruptedException {
		Log.startTestCase("VerifyDeleteCustomer");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Pc.CustomerDelete();
		Assert.assertTrue(Pc.ConfirmDelete(), "Customer is not deleted");
		Log.endTestCase("VerifyDeleteCustomer");
	}

}
