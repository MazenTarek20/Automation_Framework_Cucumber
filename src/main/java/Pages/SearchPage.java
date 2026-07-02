package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    private By searchBar = By.xpath("//*[@id=\"search-input\"]");
    private By searchResult = By.xpath("//h1[normalize-space()= 'headphones']");

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void searchForHeadPhone(String headPhones) {
        findElement(searchBar).click();
        findElement(searchBar).sendKeys(headPhones);
        doEnterAction();
    }

    public String isHeadPhonesDisplayed() {
        return findElement(searchResult).getText();
    }


}
