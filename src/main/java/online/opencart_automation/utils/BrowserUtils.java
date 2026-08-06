package online.opencart_automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserUtils {

    public static void scrollAndClickButton(WebDriver driver, By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", element);
        javascriptExecutor.executeScript("arguments[0].click()",element);
    }

    /*public static void removeAds(WebDriver driver){
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll(\"iframe[id^='aswift'], iframe[title='Advertisement'], div[id^='aswift'][id$='_host'], ins.adsbygoogle\").forEach(e => e.remove());"
        );
    }

    public static void safeClick(WebDriver driver, By locator)
    {
        WebElement element=driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", element);
        removeAds(driver);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", element);
    }*/


}
