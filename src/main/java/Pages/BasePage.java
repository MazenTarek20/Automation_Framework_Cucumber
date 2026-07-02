package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement findElement (By locator){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20)) ;
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public void moveToSpecificItem(By  locator){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }
    public void doEnterAction() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
    }
}
