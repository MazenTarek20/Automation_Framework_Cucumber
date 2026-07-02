package Filteration;

import BaseTest.BaseTest;
import Data.ExcelFileManager;
import Drivers.WebDriverFactory;
import Category.CategoryStepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FilterationStepDef extends BaseTest {
    private static final Logger log = LogManager.getLogger(FilterationStepDef.class);

    @Given("open noon website home page")
    public void openNoonWebsiteHomePage() {
        log.info("Open noon website");
        openNoonPage.getNoonPage();
        log.info("Open noon page successful");
    }

    @When("move to category option and choose samsung")
    public void moveToCategoryOptionAndChooseSamsung() {
        log.debug("Move to category option");
        log.info("Wait until category menu is open");
        samsungCategoryPage.hoverOnElectronicsCategory();
        log.debug("Click Samsung in brand");
        samsungCategoryPage.clickSamsungCategory();
        softAssert.assertEquals(samsungCategoryPage.getSearchResult(),
                "Samsung Electronics & Mobiles",
                "Wrong search result");
        softAssert.assertAll();
        log.info("Move to category option successful");
    }



    @And("get filter by price and provide {string} and {string}")
    public void getFilterByPriceAndProvideAndProvide(String max, String min) {
        log.info("Opening the Price filter.");
        WebElement oldFirstPrice = driver.findElement(productPrice);
        filterByRangeAndRatingsPage.clickOnFilterByPrice();
        log.info("Applying price filter: Min & Max");
        filterByRangeAndRatingsPage.provideAmountOfMoney(ExcelFileManager.getValue(min) , ExcelFileManager.getValue(max));
        log.info("Waiting for the product list to refresh after applying the price filter.");
        wait.until(ExpectedConditions.stalenessOf(oldFirstPrice));
        log.info("Waiting for the filtered products to become visible.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        log.info("Verifying that all displayed products are within the selected price range.");
        softAssert.assertTrue(filterByRangeAndRatingsPage.verifyPorductsPricesAreInRange(ExcelFileManager.getValue(min), ExcelFileManager.getValue(max)),
                "Some displayed products are outside the selected price range.");
        softAssert.assertAll();
        log.info("Price range verification completed successfully.");
    }


    @Then("select filter by most recommended")
    public void selectFilterByMostRecommended() {
        log.info("Opening the sorting filter.");
        filterByRangeAndRatingsPage.clickOnFilterByRating();
        filterByRangeAndRatingsPage.selectFilterByCustomerRatings();
        log.info("Result sorted by best rated successfully.");
    }
}
