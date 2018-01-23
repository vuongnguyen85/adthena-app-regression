package Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import static org.testng.internal.Utils.copyFile;

public class Utility {
    public static long startTime;
    public static WebDriver firefoxBrowser;

    public static WebDriver openFirefox(String url) {
        System.setProperty("webdriver.gecko.driver", "//Users//vuongnguyen//dev//WebDriver//geckodriver");
        firefoxBrowser = new FirefoxDriver();
        startTime = System.currentTimeMillis();
        firefoxBrowser.get(url);
        return firefoxBrowser;
    }

    public static void calculateScriptDuration() {
        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime)/1000;
        System.out.println(totalTime + " Seconds taken to complete script");
    }

    public static WebElement findElement(String path) {
        if (path.contains(".//")) {
            return firefoxBrowser.findElement(By.xpath(path));
        } else {
            return firefoxBrowser.findElement(By.cssSelector(path));
        }
    }

    public static void clickElement(String path) {
        findElement(path).click();
    }

    public static void pressEnter(String path) {
        findElement(path).sendKeys(Keys.ENTER);
    }

    public static void clearText(String path) {
        findElement(path).clear();
    }

    public static void enterText(String path, String textEntry) {
        findElement(path).sendKeys(textEntry);
    }

    public static void noOfTravellersExp(int number) {
        Select s = new Select(firefoxBrowser.findElement(By.id("flight-adults-hp-flight")));
        String s1 = Integer.toString(number);
        s.selectByValue(s1);
    }

    public static void takeScreenshot(String filename) {
        String path = "//Users//vuongnguyen//dev//Screenshots//" + filename + ".png";
        File src = ((TakesScreenshot)firefoxBrowser).getScreenshotAs(OutputType.FILE);
        copyFile(src,new File(path));
    }

    public static void quitFirefox() {
        firefoxBrowser.quit();
    }
}


