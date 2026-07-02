package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage extends BasePage {
    private By electronicsCategory = By.xpath("//li[@data-qa='btn_main_menu_Electronics']");
    private By samsungCategory = By.xpath("//img[@alt='/electronics-and-mobiles/samsung']");
    private By title = By.xpath("//div[@id='catalog-page-container']//h1");
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOnElectronicsCategory() {
        moveToSpecificItem(electronicsCategory);
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(samsungCategory));
    }
    public  void clickSamsungCategory(){
        driver.findElement(samsungCategory).click();
    }
    public  WebElement getCategory(){
        return driver.findElement(electronicsCategory);
    }
    public String getSearchResult(){
        return findElement(title).getText();
    }

}
