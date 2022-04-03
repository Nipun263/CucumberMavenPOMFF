package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.DataTable;

public class SignUpPage {
	public static WebDriver driver ;
	
	public SignUpPage(WebDriver driver ) {
		this.driver= driver;
	}
	
	
	@FindBy(xpath = "//*[@class='login']")
	WebElement btnLogin;
		
	
	@FindBy(xpath = "//*[contains(text(),'Create an account')]")
	WebElement txtpresence;
	
	
	public void passUserCredentials(DataTable table) throws Throwable {
	
		
		List<List<String>> Data = table.raw();
		String URL = Data.get(0).get(0);
		driver.get(URL);
		btnLogin.click();
		Boolean flag = txtpresence.isDisplayed();
		Assert.assertTrue(flag);
		
	}

}
