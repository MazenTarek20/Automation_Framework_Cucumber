package BaseTest;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BaseTest{
    protected static WebDriverWait wait;
    protected static SoftAssert softAssert;
    protected static WebDriver driver;
    protected static OpenMainPage openNoonPage;
    protected static CategoryPage samsungCategoryPage;
    protected static FilterationPage filterByRangeAndRatingsPage;
    protected static SearchPage searchForHeadPhonesPage;
    protected static SelectItemPage selectItemsPage;
    protected static CartPage goToCartPage;
    protected static OrderDetailsPage orderDetailsPage;
    public By productPrice = By.xpath("//strong[contains(@class,'Price-module')]");

}



