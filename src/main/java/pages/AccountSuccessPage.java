package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSuccessPage {
	WebDriver driver;
	WebDriverWait wait;

	public AccountSuccessPage(WebDriver driver){
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);

}
	/*@FindBy(xpath="//div[@id='content']//h1")
	private WebElement successfulreg;*/
	By successfulreg =
            By.xpath("//div[@id='content']//h1");
	
	public String successfulRrgistration() {
		//return successfulreg.getText();
		 return wait.until(
	                ExpectedConditions.visibilityOfElementLocated( successfulreg
	                        
	                )
	        ).getText().trim();
	}
}

