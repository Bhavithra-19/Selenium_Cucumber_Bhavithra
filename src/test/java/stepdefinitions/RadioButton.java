package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement male=driver.findElement(By.id("male"));
		WebElement female=driver.findElement(By.id("female"));
		male.click();
		if(male.isSelected()) {
			System.out.println("Male selected");
		}
		female.click();
		if(female.isSelected()) {
			System.out.println("Female selected");
		}
		

	}

}
