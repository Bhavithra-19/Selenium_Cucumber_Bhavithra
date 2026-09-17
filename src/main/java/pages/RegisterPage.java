package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement enterFirstName;
	@FindBy(id="input-lastname")
	private WebElement enterLastName;
	@FindBy(id="input-email")
	private WebElement enterEmail;
	@FindBy(id="input-telephone")
	private WebElement enterTelephone;
	@FindBy(id="input-password")
	private WebElement enterPassword;
	@FindBy(id="input-confirm")
	private WebElement enterConfirmPassword;
	@FindBy(name="agree")
	private WebElement selectPrivacy;
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesForNews;
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement clickContinue;
	
	
	public void enterfname(String firstName) {
		enterFirstName.clear();
		enterFirstName.sendKeys(firstName);
	}
	public void enterlname(String lastName) {
		enterLastName.clear();
		enterLastName.sendKeys(lastName);
	}
	public void enteremail(String email) {
		enterEmail.clear();
		enterEmail.sendKeys(email);
		
    }
	public void entertelephone(String telephone) {
		enterTelephone.clear();
		enterTelephone.sendKeys(telephone);
		
    }
	public void enterpassword(String password) {
		
		enterPassword.clear();
		enterPassword.sendKeys(password);
		
    }
	public void entercpassword(String cpassword) {
		enterConfirmPassword.clear();
		enterConfirmPassword.sendKeys(cpassword);
		
    }
	public void selectprivacypolicy() {
		selectPrivacy.click();
		
    }
	public void clickContinueButton() {
		//clickContinue.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    wait.until(ExpectedConditions.elementToBeClickable(clickContinue)).click();
		
		
    }
	
	
	public void yesForNewletter() {
		yesForNews.click();
	}
	
	
	
	
	
	
	
		
		
	}


