package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderDetailsPage extends BasePage {

    private By totalPrice = By.xpath("//*[normalize-space()='Total']/following::b[1]");
    private By productsPrice = By.xpath("//span[@style='font-weight: 700;']");
    public  OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public static double getTotalPrice() {

        String invoiceText= driver.findElement(totalPrice).getText().replace("," ,"")
                .replace("EGP","").trim();
        return Double.parseDouble(invoiceText);
    }

    public static double getTheSumOfProducts(){
        List<WebElement> prices =driver.findElements(productsPrice);
        double priceSum = 0.0;
        for (WebElement price : prices){

            String priceText = price.getText().replace(",","").trim();
            priceSum += Double.parseDouble(priceText);
        }
        return priceSum;
    }






}
