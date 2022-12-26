
package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyStoresTest extends Baseclass {
	@Test(priority = 1)
	public void VerifyAddStore() throws InterruptedException {
		Log.startTestCase("VerifyAddStore");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Sr.AddStoreForm();
		Assert.assertFalse(Sr.SearchStoresforAdd(), "Add store is not success");
		Log.endTestCase("VerifyAddStore");
	}

	@Test(priority = 2)

	public void verifyeditstore() throws InterruptedException {
		Log.startTestCase("VerifyEditStore");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Sr.EditStores();
		Assert.assertFalse(Sr.ConfirmEdit(), "field is not edited");
		Log.endTestCase("VerifyEditStore");

	}

	@Test(priority = 3)
	public void verifyStoreDelete() {
		Log.startTestCase("VerifyStoreDelete");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Sr.StoreDelete();
		Assert.assertTrue(Sr.ConfirmDelete(), "not deleted");
		Log.endTestCase("VerifyStoreDelete");

	}

}
