package online.opencart_automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CandidateCreatedPage extends Page {

    public CandidateCreatedPage(WebDriver driver) {
        super(driver);
    }

    private final By createdCandidateName = By.xpath("(//div[contains(@class,'oxd-grid-3')]//p[contains(@class,'oxd-text--p')])[1]");


    public void checkCandidateRegistration() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlMatches(".*/recruitment/addCandidate/\\d+$"));
        System.out.println("URL after waiting:");
        System.out.println(driver.getCurrentUrl());

        String actualName = wait.until(webDriver -> {
            try {
                String value = webDriver.findElement(createdCandidateName).getText().trim();
                System.out.println("Found name: " + value);
                return value.isEmpty() ? null : value;
            } catch (StaleElementReferenceException exception) {
                return null;
            }

        });
        System.out.println(
                "Candidate with the name " + actualName +
                        " was successfully created!");


    }
}




