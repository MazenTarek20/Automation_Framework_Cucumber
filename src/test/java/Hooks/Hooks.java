package Hooks;
import BaseTest.BaseTest;
import Data.DataFileManager;
import Data.DataManagerFactory;
import Pages.*;
import Drivers.WebDriverFactory;
import ScreenShots.Screenshots;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.devtools.v141.page.model.Screenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Hooks extends BaseTest {
    public Logger log = LogManager.getLogger(Hooks.class);
    DataFileManager data = DataManagerFactory.getDataManager();
    @Before
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        log.debug("Assertion Manager Initialized");
        openNoonPage = new OpenMainPage(driver);
        samsungCategoryPage = new CategoryPage(driver);
        filterByRangeAndRatingsPage = new FilterationPage(driver);
        selectItemsPage = new SelectItemPage(driver);
        goToCartPage = new CartPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
        searchForHeadPhonesPage = new SearchPage(driver);
    }

    @After
    public void teardown() {
        try {
            Allure.addAttachment("log File", new FileInputStream("logs/application.log"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterStep
    public void checkFail(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            File scrshoot = Screenshots.takeScreenShot(driver, "screenshots/"+scenario.getName()+".png");
            Allure.addAttachment("ScreenShot" , new FileInputStream(scrshoot));
        }
    }

}
