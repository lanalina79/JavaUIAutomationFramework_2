package online.opencart_automation.pageobjects;

import online.opencart_automation.utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddCandidatePage extends Page {

    public AddCandidatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameinput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "(//input[@placeholder='Type here'])[1]")
    private WebElement emailInput;

    @FindBy(xpath = "(//textarea[@placeholder='Type here'])[1]")
    private WebElement notesInput;

    @FindBy(css = ".oxd-icon.bi-check.oxd-checkbox-input-icon")
    private WebElement consentToKeepData;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[2]/textarea[1]")
    private WebElement keywordsInput;

    //@FindBy(xpath = "//div[@class='oxd-select-text-input']")
    //private WebElement vacancyDropdown;

    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    private WebElement calendarView;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement lastNameError;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement emailError;

    public void textFieldInput(String firstName, String middleName, String lastName, String email, String keywords,
                               String notes) {
        firstNameInput.sendKeys(firstName);
        middleNameinput.sendKeys(middleName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        keywordsInput.sendKeys(keywords);
        notesInput.sendKeys(notes);

        System.out.println(firstName + " " + middleName + " " + lastName);

    }

    public String getActualFirstName (){
       String actualFName= firstNameInput.getAttribute("value");
       return actualFName;
    }


    public void selectVacancy(String vacancy) {

        WebElement dropdown = driver.findElement(
                By.xpath("//div[@class='oxd-select-text-input']")
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                dropdown
        );

        new Actions(driver)
                .moveToElement(dropdown)
                .click()
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public void checkConsent() {
        consentToKeepData.click();
    }

    public void pickTheDate(String month, String year, String day) throws InterruptedException {

        calendarView.click();

        driver.findElement(
                By.cssSelector(".oxd-calendar-selector-month")
        ).click();

        Thread.sleep(1000);

        driver.findElement(
                By.xpath("//li[contains(@class,'oxd-calendar-dropdown--option') and normalize-space()='" + month + "']")
        ).click();

        driver.findElement(
                By.cssSelector(".oxd-calendar-selector-year")
        ).click();

        Thread.sleep(1000);

        driver.findElement(
                By.xpath("//li[contains(@class,'oxd-calendar-dropdown--option') and normalize-space()='" + year + "']")
        ).click();

        Thread.sleep(1000);

        driver.findElement(
                By.xpath("//div[@class='oxd-calendar-date' and normalize-space()='" + day + "']")
        ).click();
    }

    public void clickSaveRecruiterButton() {
        BrowserUtils.scrollAndClickButton(driver, By.xpath("//button[normalize-space()='Save']"));
    }

    public boolean isLastNameErrorMessageDisplayed(){
        System.out.println("the text is " + lastNameError.getText());
        return lastNameError.isDisplayed();

    }

    public boolean isEmailErrorDisplayed (){
        try {

            boolean emailErrorDisplayed = emailError.isDisplayed();
            if (emailErrorDisplayed) {
                System.out.println("The error message " + emailError.getText() + " is displayed");
            } else {
                System.out.println("The error message is NOT displayed");
            }
            return emailErrorDisplayed;
        }
        catch(NoSuchElementException e){
            System.out.println("The error message is NOT displayed");
            return false;
        }
    }


}
