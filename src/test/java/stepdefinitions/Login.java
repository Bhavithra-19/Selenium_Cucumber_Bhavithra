package stepdefinitions;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
//import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ComonUtils;


public class Login {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	AccountPage ap;
		
	@Given("User has navigated to login page")
	public void user_has_navigated_to_login_page() throws InterruptedException {
		driver=DriverFactory.getDriver();
		hp=new HomePage(driver);
		lp=new LoginPage(driver);
		
		ap=new AccountPage(driver);
		//driver.get("https://tutorialsninja.com/demo/");
		
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// WebElement myAccount = wait.until(
			        //ExpectedConditions.elementToBeClickable(hp.clickMyAccount()));//span[@class='hidden-xs hidden-sm hidden-md' and normalize-space()='My Account']\"")))
			hp.clickMyAccount();    
			    //myAccount.click();
			   		
		//driver.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and normalize-space()='My Account']")).click();
			   // System.out.println("Account click");
		//driver.findElement(By.linkText("Login")).click();
			hp.clickLogin();
		
	}

	@When("User enters valid email {string} into email field")
	public void user_enters_valid_email_into_email_field(String emailText) {
		
		lp.enterEmail(emailText);
	   //driver.findElement(By.id("input-email")).sendKeys(emailText);
	}
	@When("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String passText) {
		//driver.findElement(By.id("input-password")).sendKeys(passText);
		lp.enterPass(passText);
	}
	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	   //driver.findElement(By.xpath("//input[@value='Login']")).click();
		lp.clickLoginButton();
	}

	@Then("User should successfully logged in.")
	public void user_should_successfully_logged_in() {
	    //Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    WebElement myAccount = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//h2[normalize-space()='My Account']")
	            )
	    );*/

	    Assert.assertTrue(ap.displayStatusOfAccount());
	}
	
	@When("User enters invalid email into email field")
	public void user_enters_invalid_email_into_email_field() {
		//driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimestamp());
		lp.enterEmail(ComonUtils.getEmailWithTimestamp());

	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPassword) {
		//driver.findElement(By.id("input-password")).sendKeys(invalidPassword);
		lp.enterPass(invalidPassword);

	}



	@Then("User should get a warning message")
	public void user_should_get_a_warning_message() {
	   Assert.assertTrue(lp.getWarnmingMessage().contains("Warning: No match for E-Mail Address and/or Password."));
		
		
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement warningMessage = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(@class,'alert-danger')]")
		        )
		);

		String actualMessage = warningMessage.getText();

		System.out.println("Warning message: " + actualMessage);

		Assert.assertTrue(
		        actualMessage.contains(
		                "No match for E-Mail Address and/or Password."
		        )
		);*/
		

		}

	

	@When("User doesn't enter email into email field")
	public void user_doesn_t_enter_email_into_email_field() {
		
		 //driver.findElement(By.id("input-email")).sendKeys("");
		lp.enterEmail("");
			}
	

	@When("User doesn't enter password into password field")
	public void user_doesn_t_enter_password_into_password_field() {
		//driver.findElement(By.id("input-password")).sendKeys(""); 
		lp.enterPass("");
	}
	
	

	}


