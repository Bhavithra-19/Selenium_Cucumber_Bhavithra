package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(css="a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")
	private WebElement MyAccountDrop;
	
	@FindBy(linkText="Login")
	private WebElement Login;
	
	@FindBy(xpath="(//a[normalize-space()='Register'])[1]")
	private WebElement registerClick;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement enterProduct;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement clickSerach;
	
	
	
	public void clickMyAccount() {
		MyAccountDrop.click();
		
	}
	
	public void clickLogin() {
		Login.click();
	}
	public void accountClickbutton() {
		registerClick.click();

}
	public void entervProduct(String validText) {
		enterProduct.sendKeys(validText);
	}
	public void clickSearchButton() {
		clickSerach.click();
	}
}

