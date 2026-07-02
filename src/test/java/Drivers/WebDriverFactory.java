package Drivers;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static WebDriver  driver;

    public  static WebDriver getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = ChromeDriverClass.getChromeDriver();
                break;
            case "firefox":
                driver = FireFoxDriverClass.getFireFoxDriver();
                break;
            default:throw new IllegalArgumentException("Browser not supported");
        }
        return driver;
    }
}
