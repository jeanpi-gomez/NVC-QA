package com.talos.nvc.test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.talos.nvc.objectpages.Login;

import utilities.Utilities;
import utilities.Init;

public class TestLogin {
	@BeforeSuite
	public void setup(){	
		Init.Initialition();
	}
	
	@Test
	public void checkLogin() throws Exception {
		Login.LogintoNVC("jean.pierre@talosdigital.com","hello123");
	}
	
	@AfterMethod
	public static void aftertest(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()) {		
			Utilities.captureScreenshot(Init.driver, result.getName());
		}
	}
	
	@AfterSuite
	public void closing() {	
		Init.finish();
	}
}
