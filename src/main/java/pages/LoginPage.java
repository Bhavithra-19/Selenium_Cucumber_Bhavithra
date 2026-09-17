package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="input-email")
	private WebElement emailEnterText;
	
	@FindBy(id="input-password")
	private WebElement passEnterText;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement clickLogin;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement warningMessage;
	
	public void enterEmail(String emailText) {
	
	  emailEnterText.sendKeys(emailText);
	
	}
	
	public void enterPass(String passText) {
		passEnterText.sendKeys(passText);
		
	}
	
	public void clickLoginButton() {
		clickLogin.click();
	}
	
	public String getWarnmingMessage() {
		 return warningMessage.getText();
	}
	

}
