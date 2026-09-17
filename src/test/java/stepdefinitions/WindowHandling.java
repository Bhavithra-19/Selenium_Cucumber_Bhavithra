package stepdefinitions;

import java.time.Duration;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");

        // Store parent window
        String parent = driver.getWindowHandle();

        // Wait until Register link is present (not clickable)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement registerLink = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[normalize-space()='Register'])[1]"))
        );

        // Use JavaScript to open in new tab (avoids ElementNotInteractableException)
        String href = registerLink.getAttribute("href");
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", href);
        //registerLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));

        // Handle new tab
        Set<String> windowIDs = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(windowIDs);

        for (String winID : tabs) {
            if (!winID.equals(parent)) {
                driver.switchTo().window(winID);
                System.out.println("Child: " + driver.getTitle());
                driver.close(); // close child tab
            }
        }

        // Switch back to parent
        driver.switchTo().window(parent);
        System.out.println("Parent: " + driver.getTitle());

        driver.quit();
    }
}
