package online.opencart_automation.pageobjects;

import online.opencart_automation.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver)
    {super(driver);}

    @FindBy (name = "username")
    private WebElement usernameInput;

    @FindBy (name = "password")
    private WebElement passwordInput;


    public void CompleteLogin(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        BrowserUtils.scrollAndClickButton(driver,By.cssSelector("button[type='submit']"));
        System.out.println("The form was populated with username "+ username +" and password " +password);
        System.out.println("The Login button was clicked");
    }

    /*WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Name']"));
    String userNameRandom = DataGeneratorManager.getRandomUsername();
        usernameInput.sendKeys(userNameRandom);

        System.out.println("The username is "+userNameRandom);

    WebElement emailInput=driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
    String emailRandom=DataGeneratorManager.getRundomEmail();
        emailInput.sendKeys(emailRandom);
        System.out.println("email is "+emailRandom);

        BrowserUtils.safeClick(driver, By.cssSelector("button[data-qa='signup-button']"));
    //WebElement signUpButton=driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
    //signUpButton.click();*/



}
