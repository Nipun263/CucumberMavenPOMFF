package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.SignUpPage;
import com.pages.UserCredentialPage_NewUser;

import Utility.BrowserFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class AccountCreate {

	public static WebDriver driver;


@Given("Intial Set should be done")
public void browserCall() throws InterruptedException {
		driver = BrowserFactory.startApplication(driver, "Chrome");
	}

	@Given("^user clicks on SignIn Button$")
	public void UserSignIn() throws InterruptedException {
		Thread.sleep(3000);

		SignUpPage SPP = PageFactory.initElements(driver, SignUpPage.class);
		SPP.BasicSignIn();
	}

	@Then("^user is required to pass the credentials \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_is_required_to_pass_the_credentials(String FirstName, String UserLastName, String Password,
			DataTable table) throws InterruptedException {

		UserCredentialPage_NewUser USP = PageFactory.initElements(driver, UserCredentialPage_NewUser.class);
		USP.passCredentialsForNewUser(FirstName, UserLastName, Password, table);

	}


	@Given("User wants to login to Site {string}")
	public void user_wants_to_login_to_Site(String URL) throws Throwable {

		String URLL = URL;

		driver.get(URL);
	}

	public void user_has_to_pass_rest_of_the_details(String zipCode_Passed, String Mobile_NumPassed) {
		WebElement zipCode = driver.findElement(By.name("postcode"));
		zipCode.sendKeys(zipCode_Passed);

		WebElement mobile = driver.findElement(By.name("phone_mobile"));
		mobile.sendKeys(Mobile_NumPassed);

		WebElement registerButton = driver.findElement(By.name("submitAccount"));
		registerButton.click();

	}

	@And("^verify the account creation is successful$")
	public void verify_the_account_creation_is_successful() throws InterruptedException {
		Thread.sleep(3000);
		WebElement orderandHistory = driver.findElement(By.xpath("//*[contains(text(),'Order history and details')]"));
		Boolean presence = orderandHistory.isDisplayed();

	}

	@Then("^Logout user$")
	public void logout_user() {
		WebElement signOut = driver.findElement(By.xpath("//*[@class='logout']"));
		signOut.click();
	}

	@Then("^user wants to pass the existing user credentials \"([^\"]*)\" ,\"([^\"]*)\"$")
	public void user_wants_to_pass_the_existing_user_credentials(String ExsitingUserFirstName,
			String ExisitingUserLastName) {

		WebElement AlreadyExisitng = driver.findElement(By.xpath("//h3[contains(text(),'Already registered?')]"));
		Boolean Flag = AlreadyExisitng.isDisplayed();

		WebElement firstName = driver.findElement(By.name("email"));
		WebElement lastName = driver.findElement(By.name("passwd"));
		WebElement signInBtn = driver.findElement(By.id("SubmitLogin"));

		firstName.sendKeys(ExsitingUserFirstName);
		lastName.sendKeys(ExisitingUserLastName);
		signInBtn.click();

	}

}
