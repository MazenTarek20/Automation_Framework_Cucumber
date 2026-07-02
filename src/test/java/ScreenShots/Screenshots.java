package ScreenShots;

import org.openqa.selenium.WebDriver;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.IOException;

public class Screenshots {

    public static File takeScreenShot(WebDriver driver , String path ) throws IOException {
        TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        File scrshoot =  takeScreenShot.getScreenshotAs(OutputType.FILE);
        File dest = new File(path);
        FileHandler.copy(scrshoot , dest);
        return dest;

    }
}
