package Invoice;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = "src/test/java/Tests/VerificationOfUpdatingInvoice",
        glue = {"Tests"},
        plugin = {"pretty" ,
                "html:target/cucumber-reports.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class InvoiceRunner {
}
