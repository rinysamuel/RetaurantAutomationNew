package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyPeopleSupplierTest extends Baseclass {
	@Test(priority = 1, groups = {"Add"})

	public void VerifyAddSupplier() {
		Log.startTestCase("VerifyAddSupplier");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Ps.AddSupplierForm();
		Assert.assertTrue(Ps.SearchsuppliersforAdd(),"Supplier is not added");
		Log.endTestCase("VerifyAddSupplier");

	}

	@Test(priority = 2)
	public void VerifyEditSupplier()  {
		Log.startTestCase("VerifyEditSupplier");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Ps.EditSuppliers();
		Assert.assertFalse(Ps.SuppConfirmEdit(), "Supplier is not edited");
		Log.endTestCase("VerifyEditSupplier");

	}

	@Test(priority = 3)
	public void SupplierDelete() {
		Log.startTestCase("VerifyDeleteSupplier");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Ps.SupplierDelete();
		Assert.assertTrue(Ps.ConfirmDelete(), "Supplier is not deleted");
		Log.endTestCase("VerifyDeleteSupplier");
	}

}

