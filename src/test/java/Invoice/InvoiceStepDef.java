package Invoice;


import BaseTest.BaseTest;
import Data.CSVFileManager;
import Data.DataFileManager;
import Data.DataManagerFactory;
import Data.ExcelFileManager;
import Pages.OrderDetailsPage;
import Drivers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InvoiceStepDef extends BaseTest {
    private static final Logger log = LogManager.getLogger(InvoiceStepDef.class);
    double invoiceTotalPriceAfterRemovingItem;
    DataFileManager data = DataManagerFactory.getDataManager();

    @Given("noon website opened")
    public void noonWebSiteOpened() {
        log.info("Opening website");
        WebDriverFactory.getDriver("chrome").get(CSVFileManager.getValue("url"));
        openNoonPage.getNoonPage();
        log.info("Noon website opened");
    }

    @When("user is searching for product")
    public void userIsSearchingForProduct() {
        log.info("Checking for product");
        searchForHeadPhonesPage.searchForHeadPhone("headphones");
        softAssert.assertEquals(searchForHeadPhonesPage.isHeadPhonesDisplayed(),
                "headphones","Wrong search result");
        softAssert.assertAll();
        log.info("headphones result is true");
    }

    @And("user added some items to cart {string} {string} {string}")
    public void userAddedSomeItemsToCart(String item1 , String item2, String item3) {
        log.info("User is adding items to cart");
        selectItemsPage.pickItems(ExcelFileManager.getValue(item1)
                , ExcelFileManager.getValue(item2),
                ExcelFileManager.getValue(item3));
        log.info("Items added successfully");
    }

    @And("user navigate cart page")
    public void userNavigateCartPage() {
        log.info("Navigating cart page");
        goToCartPage.moveToCartPage();
        log.info("Navigated to Cart page");
    }

    @And("user removed {string}")
    public void userRemoved(String itemName) {
        log.info("User is removed items from cart");
        selectItemsPage.removeItem(ExcelFileManager.getValue(itemName));
        log.info("Getting the sum of products after removing item");
        invoiceTotalPriceAfterRemovingItem = OrderDetailsPage.getTheSumOfProducts();
        log.info("Items removed successfully");
    }

    @Then("verify that the invoice updated")
    public void verifyThatTheInvoiceUpdated() {
        log.info("Verifying that the invoice updated");
        double updatedInvoiceTotalPrice = OrderDetailsPage.getTotalPrice();
        log.info("Getting the total invoice to compare " +
                "it with the sum of products after removing item");

        softAssert.assertEquals(updatedInvoiceTotalPrice,invoiceTotalPriceAfterRemovingItem,0.01,
                "The updated invoice is miscalculated");
        softAssert.assertAll();

        log.info("Invoice updated successfully");
    }


}
