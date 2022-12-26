package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyReportsTest extends Baseclass {

	@Test
	public void VerifyReportPageClientStat() throws InterruptedException {
		Log.startTestCase("VerifyReportClientStat");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Rp.SelectClient();
		Assert.assertTrue(Rp.IsReportStatusPresent(), "Report Seen or not");
		Log.endTestCase("VerifyReportClientStat");
	}

	@Test
	public void VerifyReportProductStat() throws InterruptedException {
		Log.startTestCase("VerifyReportProductStat");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Rp.SelectProduct();
		Assert.assertTrue(Rp.IsProductStatPresent(),"Report Seen or not");
		Log.endTestCase("VerifyReportProductStat");
	}

	@Test
	public void VerifyReportStoreStat() throws InterruptedException {
		Log.startTestCase("VerifyReportStoreStat");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Rp.SelectStore();
		Assert.assertTrue(Rp.IsReportStatusPresent(),"Report Seen or not");
		Log.endTestCase("VerifyReportStoreStat");
	}
}
