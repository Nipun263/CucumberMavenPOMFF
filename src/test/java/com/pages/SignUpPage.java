package com.pages;

import java.util.List;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;

public class SignUpPage {
	public static WebDriver driver ;
	
	public SignUpPage(WebDriver driver ) {
		this.driver= driver;
	}
	
	
	@FindBy(xpath = "//*[@class='login']")
	WebElement btnLogin;
		
	
	@FindBy(xpath = "//*[contains(text(),'Create an account')]")
	WebElement txtpresence;
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement SignInBtn;
	
	
	@FindBy(xpath = "//*[@id='email_create']")
	WebElement EmailTextBox;
	
	
	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement CreateAccount;
	
	
	public void BasicSignIn() throws InterruptedException {
		Thread.sleep(3000);
		
		driver.get("http://automationpractice.com/index.php");
		
		SignInBtn.click();
		
		Thread.sleep(3000);
		
		double RandomNUm = Math.random();
		
		EmailTextBox.sendKeys("Nipun" + RandomNUm + "@test.com");
		
		Thread.sleep(3000);
		
		CreateAccount.click();
		
		Thread.sleep(3000);
	}
	
	
	

}
