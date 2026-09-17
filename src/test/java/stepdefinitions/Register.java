package stepdefinitions;

import java.time.Duration;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.ComonUtils;

public class Register {
	WebDriver driver;
	HomePage hp;
	RegisterPage rp;
	AccountSuccessPage as;
	@Given("User navigates to the  registration page")
	public void user_navigates_to_the_registration_page() throws InterruptedException {
		driver=DriverFactory.getDriver();
		hp=new HomePage(driver);
		rp=new RegisterPage(driver);
		as=new AccountSuccessPage(driver);
		//driver.get("https://tutorialsninja.com/demo/");
		 /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//driver.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and normalize-space()='My Account']")).click();
		WebElement myAccount = wait.until(
		        ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")));//span[@class='hidden-xs hidden-sm hidden-md' and normalize-space()='My Account']\"")))
		    
		    myAccount.click();
		    //Thread.sleep(1000);		
	//driver.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and normalize-space()='My Account']")).click();
		    System.out.println("Account click");*/
		hp.clickMyAccount();
		hp.accountClickbutton();
		    
		//driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();
		//Thread.sleep(Duration.ofSeconds(1000));
	    
	}

	@When("User enters registration details into below field")
	public void user_enters_registration_details_into_below_field(io.cucumber.datatable.DataTable dataTable) {
		Map<String,String>dataMap=dataTable.asMap(String.class,String.class);
		rp.enterfname(dataMap.get("firstName"));
		rp.enterlname(dataMap.get("lastName"));
		rp.enteremail(ComonUtils.getEmailWithTimestamp());
		rp.entertelephone(dataMap.get("telephone"));
		rp.enterpassword(dataMap.get("password"));
		rp.entercpassword(dataMap.get("confirmPassword"));
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']"));
		rp.yesForNewletter();
		
	}

	@When("User selects the Privacy Policy")
	public void user_selects_the_privacy_policy() {
		//driver.findElement(By.name("agree")).click();
		rp.selectprivacypolicy();
	    
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		rp.clickContinueButton();
		
		    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    //wait.until(ExpectedConditions.elementToBeClickable(rp.clickContinueButton()));
		
	    
	}

	@Then("User should be successfully registered")
	public void user_should_be_successfully_registered() {
		//Assert.assertTrue(as.successfulRrgistration().contains("Your Account Has Been Created!"));
		 String actualMessage = as.successfulRrgistration();

		    System.out.println("Actual registration message: " + actualMessage);

		    Assert.assertTrue(
		        "Registration success message not displayed. Actual message: " + actualMessage,
		        actualMessage.contains("Your Account Has Been Created!")
		    );

	}
	





}
