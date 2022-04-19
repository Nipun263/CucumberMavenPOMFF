package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;

public class UserCredentialPage_NewUser {
	public static WebDriver driver ;
	
	public UserCredentialPage_NewUser(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public void passCredentialsForNewUser(String FirstName, String UserLastName, String Password, DataTable table) throws InterruptedException {
		
		Thread.sleep(3000);
		
		WebElement firstName =
		driver.findElement(By.xpath("//*[@id='customer_firstname']"));
		firstName.click();
		firstName.sendKeys(FirstName);
		
		WebElement lastName = driver.findElement(By.xpath("//*[@id='customer_lastname']"));
		lastName.click(); 
		lastName.sendKeys(UserLastName);
				 
		
		WebElement password = driver.findElement(By.xpath("//*[@id='passwd']"));
	    password.sendKeys(Password);
				  
		WebElement dateDD = driver.findElement(By.xpath("//*[@id='uniform-days']"));
	    WebElement date = driver.findElement(By.xpath("//*[@id='days']"));
				  
	    WebElement monthDD =driver.findElement(By.xpath("//*[@id='uniform-months']"));
	    WebElement month =driver.findElement(By.xpath("//*[@id='months']"));
		
	    
	    WebElement yearDD = driver.findElement(By.xpath("//*[@id='uniform-years']"));
		WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
		
		List<List<String>> data = table.asLists();
		String dateSelected =  data.get(0).get(0);
		String monthSelected =  data.get(0).get(1);
		String YearSelected =  data.get(0).get(2);
		String address_passed = data.get(0).get(3);
		String city_Passed = data.get(0).get(4);
		String state_Passed = data.get(0).get(5);
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0,300)");
		
		dateDD.click();
		Select selectDateFromDD = new Select(date);
		selectDateFromDD.selectByValue(dateSelected);
		
		monthDD.click();
		Select selectMonthFromDD = new Select(month);
		selectMonthFromDD.selectByValue(monthSelected);
		
		yearDD.click();
		Select selectYearFromDD = new Select(year);
		selectYearFromDD.selectByValue(YearSelected);
		
		JavascriptExecutor JSS = (JavascriptExecutor)driver;
		JSS.executeScript("window.scrollBy(0,500)");
		
		WebElement address = driver.findElement(By.name("address1"));
		address.sendKeys(address_passed);
		
		WebElement city = driver.findElement(By.name("city")); 
		city.sendKeys(city_Passed);
		  
		
		WebElement state = driver.findElement(By.name("id_state"));
		Select select1 = new Select(state);
		select1.selectByVisibleText(state_Passed);
		  
	}

}
