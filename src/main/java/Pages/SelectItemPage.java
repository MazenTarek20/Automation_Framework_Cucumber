package Pages;

import org.openqa.selenium.*;
        import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectItemPage extends BasePage{


    public List<String> selectedTitles = new ArrayList<>();
    public SelectItemPage(WebDriver driver) {
        super(driver);
    }



    public void clickAddToCart(String productKeyword) {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-qa,'" + productKeyword + "')]//button[.//img[@alt='add-to-cart']]")));
        addToCartBtn.click();
    }

    public void pickItems(String item1 , String item2, String item3) {
        clickAddToCart(item1);
        clickAddToCart(item2);
        clickAddToCart(item3);
    }
    public void clickRemoveItem(String productKeyword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement removeFromCartBtn =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//div[contains(@class,'CartItemDesktop')][.//div[contains(@class,'__title')]//*[contains(text(),'"
                        + productKeyword + "')]]//button[@data-qa='cart-remove_item']")));
        removeFromCartBtn.click();
    }

    public void removeItem(String item) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By productCard = By.xpath(
                "//div[contains(@class,'CartItemDesktop')]" +
                        "[.//div[contains(@class,'__title')]//*[contains(text(),'" + item + "')]]"
        );

        clickRemoveItem(item);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(productCard));
    }


}
