package Category;

import BaseTest.BaseTest;
import Drivers.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;





public class CategoryStepDef extends BaseTest {
    private static final Logger log = LogManager.getLogger(CategoryStepDef.class);


    @Given("open noon website")
    public void openNoonWebsite() {
        openNoonPage.getNoonPage();
        log.debug("Open noon website");
    }

    @When("move to category option")
    public void moveToCategoryOption() {
        log.debug("Move to category option");
        log.info("Wait until category menu is open");
        samsungCategoryPage.hoverOnElectronicsCategory();
    }

    @Then("click samsung")
    public void clickSamsung() {
        log.debug("Click Samsung in brand");
        samsungCategoryPage.clickSamsungCategory();
        softAssert.assertEquals(samsungCategoryPage.getSearchResult(),
                "Samsung Electronics & Mobiles",
                "Wrong search result");
    }
}
