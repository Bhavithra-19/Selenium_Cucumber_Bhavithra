package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchPage;

public class Serach {
	WebDriver driver;
	HomePage hp;
	SearchPage sp;

	@Given("User opens the application")
	public void user_opens_the_application() {
		driver=DriverFactory.getDriver();
		sp=new SearchPage(driver);
		hp=new HomePage(driver);
		//driver.get("https://tutorialsninja.com/demo/");
	}

	@When("User enters a valid product {string} in search box")
	public void user_enters_a_valid_product_in_search_box(String validText) {
	 //driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(validText);
		hp.entervProduct(validText);
	}
	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
	    //driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		hp.clickSearchButton();
	}

	@Then("User should get a valid product display in the search field")
	public void user_should_get_a_valid_product_display_in_the_search_field() {
	    Assert.assertTrue(sp.validProductDisplay());
	}
	@When("User enters a invalid product {string} in search box")
	public void user_enters_a_invalid_product_in_search_box(String invalidText ) {
		
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(invalidText);
		hp.entervProduct(invalidText);
	}

	@Then("User should get a  message about  no product match")
	public void user_should_get_a_message_about_no_product_match() {
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement warningMessage = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//input[@id='button-search']/following-sibling::p")
		        )
		);

		String actualMessage = warningMessage.getText();

		System.out.println("Warning message: " + actualMessage);

		Assert.assertTrue(
		        actualMessage.contains(
		                "There is no product that matches the search criteria."
		        )
		);*/
		Assert.assertTrue(sp.noProductMessage().contains("There is no product that matches the search criteria."));
		

	    
	}

	@When("User didn't  enter a  product in search box")
	public void user_didn_t_enter_a_product_in_search_box() {
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("");
	   


}
}
