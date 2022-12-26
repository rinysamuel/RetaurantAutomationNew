package com.Restaurant.Testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifySalesTest extends Baseclass {

	@Test
	public void VerifySalesPage() throws Exception {
		Log.startTestCase("VerfiySalesLabel");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Sp.VerifySales();
		Assert.assertTrue(Sp.IsSalesPresent(), "Sales Page is not loaded");
        //Excel Test 
		ArrayList Excel = Er.getData("Login");
		System.out.println(Excel.get(0));
		Log.endTestCase("VerfiySalesLabel");

	}

}
