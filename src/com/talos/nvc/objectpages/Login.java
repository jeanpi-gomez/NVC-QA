package com.talos.nvc.objectpages;

import org.openqa.selenium.By;

import utilities.Init;

public class Login {
		
	//Locators from Login Page by XPATH
	public static By username = By.xpath
	("html/body/div[1]/div/div[1]/div[2]/div/div/div[2]/div/form/div[1]/input");
	public static By password = By.xpath
	("html/body/div[1]/div/div[1]/div[2]/div/div/div[2]/div/form/div[2]/input");
	public static By loginLink = By.xpath
	("html/body/div[1]/div/div[1]/div[1]/header/div/ul/li[3]/a");
	public static By SigninButton = By.xpath
	("html/body/div[1]/div/div[1]/div[2]/div/div/div[2]/div/form/div[4]/button");
	
	public static void LogintoNVC(String user, String pass) throws InterruptedException {	
		Init.driver.findElement(loginLink).click();
		Init.driver.findElement(username).sendKeys(user);
		Init.driver.findElement(password).sendKeys(pass);
		Init.driver.findElement(SigninButton).click();
	}
}