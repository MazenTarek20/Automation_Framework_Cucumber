package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private By cartIcon = By.xpath("//*[@id=\"default-header-desktop\"]/header/div[2]/a[3]");
    private By OrderSummary = By.xpath("//div[normalize-space()='Order Summary']");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void moveToCartPage(){
        findElement(cartIcon).click();
    }

    public String isCartDisplayed() {
        return findElement(OrderSummary).getText();
    }
}
