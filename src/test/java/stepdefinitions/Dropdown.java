package stepdefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.Set;

public class Dropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=product/category&path=25_28");

        
        WebElement componentsMenu = driver.findElement(By.linkText("Components"));
        Actions actions = new Actions(driver);
        actions.moveToElement(componentsMenu).perform();

        List<WebElement> options = driver.findElements(
            By.xpath("//a[text()='Components']/following-sibling::div//li/a")
        );

        for (WebElement op : options) {
            System.out.println(op.getText());
            if(op.equals("Monitors (2)")){
            	op.click();
            }
            		
        }

    }
}
