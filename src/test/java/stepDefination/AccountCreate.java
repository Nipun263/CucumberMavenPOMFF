package stepDefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.pages.SignUpPage;
import com.pages.UserCredentialPage_NewUser;

import Utility.BrowserFactory;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;

public class AccountCreate {

	public static WebDriver driver;

	
	@Before
	public void browserCall() {
	driver = BrowserFactory.startApplication(driver, "FireFox");
	}
	
	
	@Test
	@Given("^User wants to pass the user credentials$")
	public void user_wants_to_pass_the_user_credentials(DataTable table) throws Throwable {
		SignUpPage SPP = PageFactory.initElements(driver, SignUpPage.class);
		SPP.passUserCredentials(table);
		
		
	}
	
	
	
	@Test
	@Then("^user is required to pass the credentials \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_is_required_to_pass_the_credentials(String FirstName, String UserLastName, String Password, DataTable table ) {
		UserCredentialPage_NewUser USP = 	PageFactory.initElements(driver, UserCredentialPage_NewUser.class);
		USP.passCredentialsForNewUser(FirstName,UserLastName,Password,table);
		
			
		
	
	}
	
	@Test
	@And("^User has to pass rest of the details \"([^\"]*)\" ,\"([^\"]*)\"$")
	public void user_has_to_pass_rest_of_the_details(String zipCode_Passed , String Mobile_NumPassed)  {
		WebElement zipCode = driver.findElement(By.name("postcode"));
		zipCode.sendKeys(zipCode_Passed);
			  
		WebElement mobile = driver.findElement(By.name("phone_mobile"));
		mobile.sendKeys(Mobile_NumPassed);
		
		WebElement registerButton = driver.findElement(By.name("submitAccount"));
		registerButton.click();
	
	}
	
	@Test
	@And("^verify the account creation is successful$")
	public void verify_the_account_creation_is_successful() throws InterruptedException  {
		Thread.sleep(3000);
	    WebElement orderandHistory = driver.findElement(By.xpath("//*[contains(text(),'Order history and details')]"));
	    Boolean presence = orderandHistory.isDisplayed();
	  //  Assert.assertTrue("Account Created Success", true);
	    Assert.assertTrue(presence);
	   
	}
	
	@Test
	@Then("^Logout user$")
	public void logout_user()  {
	   WebElement signOut = driver.findElement(By.xpath("//*[@class='logout']"));
	   signOut.click();
	}

	@Test
	@Then("^user wants to pass the existing user credentials \"([^\"]*)\" ,\"([^\"]*)\"$")
	public void user_wants_to_pass_the_existing_user_credentials(String ExsitingUserFirstName, String ExisitingUserLastName) {
		
		WebElement AlreadyExisitng = driver.findElement(By.xpath("//h3[contains(text(),'Already registered?')]"));
		Boolean Flag = AlreadyExisitng.isDisplayed();
		
		
		WebElement firstName = driver.findElement(By.name("email"));
		WebElement lastName = driver.findElement(By.name("passwd"));
		WebElement signInBtn = driver.findElement(By.id("SubmitLogin"));
		
		firstName.sendKeys(ExsitingUserFirstName);
		lastName.sendKeys(ExisitingUserLastName);
		signInBtn.click();
	
	
		
	}
	

	
	@After
	public void tearDown() {
		driver.quit();

	}

}
