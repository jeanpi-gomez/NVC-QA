package com.talos.nvc.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utilities.Init;
import utilities.Utilities;

public class NewTest {
	
	@BeforeSuite
	public void setup(){	
		Init.Initialition();
	}
	
	@Test
	public void googleTest() throws TimeoutException {
	
		Init.driver.findElement(By.name("q")).sendKeys("Cheese!");;

		// Now submit the form. WebDriver will find the form for us from the element
		Init.driver.findElement(By.name("q")).submit();

		// Check the title of the page
		System.out.println("Page title is: " + Init.driver.getTitle());
      
		// Google's search is rendered dynamically with JavaScript.
		// Wait for the page to load, timeout after 10 seconds
		(new WebDriverWait(Init.driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("paste");
            }
        });

		// Should see: "cheese! - Google Search"
		System.out.println("Page title is: " + Init.driver.getTitle());
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
