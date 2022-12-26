package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyProductTest extends Baseclass {
	@Test(priority =1)
	public void VerifyAddProduct() throws InterruptedException {
		Log.startTestCase("VerfiyAddProduct");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Pp.AddProduct();
		Assert.assertTrue(Pp.SearchProductforAdd(), "New product not added");
		Log.endTestCase("VerfiyAddProduct");
	}

	@Test (priority =2)
	public void VerifyEditProduct() throws InterruptedException {
		Log.startTestCase("VerfiyEditProduct");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Pp.EditProduct();
		Assert.assertFalse(Pp.ConfirmEdit(), "Product is not Edited");
		Log.endTestCase("VerfiyEditProduct");

	}

	@Test (priority =3)
	public void VerifyDeleteProduct() throws InterruptedException {
		Log.startTestCase("VerfiyDeleteProduct");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Pp.DeleteProduct();
		Assert.assertTrue(Pp.ConfirmDelete(), "Product not Deleted");
		Log.endTestCase("VerfiyDeleteProduct");

	}

	@Test(priority =4, dependsOnMethods = {"VerifyDeleteProduct"})
	public void VerifyProduct() throws InterruptedException {
		Log.startTestCase("VerifyProduct");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Pp.ViewProduct();
		Assert.assertTrue(Pp.IsViewProductPresent(), "View Product not Displayed");
		Pp.closeProduct();
		Assert.assertTrue(Pp.IsAddproductDispalyed(), "Add Product button not Displayed");
		Log.endTestCase("VerifyProduct");

	}
	@Test (priority =5, retryAnalyzer = com.Restaurant.Utilities.ReRunAutomation.class)
	public void VerifyBarcode() throws InterruptedException {
		Log.startTestCase("VerifyBarcode");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");;
		Pp.PrintBarcode();
		Assert.assertTrue(Pp.IsBarcodeDisplayed(), "Barcode not Displayed");
		Pp.closeBarcode();
		Assert.assertTrue(Pp.IsAddproductDispalyed(), "Add Product button not Displayed");
		Log.endTestCase("VerifyBarcode");

	}

}