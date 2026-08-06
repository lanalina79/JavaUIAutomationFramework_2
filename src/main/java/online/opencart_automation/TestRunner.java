package online.opencart_automation;

import online.opencart_automation.managers.DataGeneratorManager;
import online.opencart_automation.managers.DriverManager;
import online.opencart_automation.pageobjects.*;
import org.openqa.selenium.WebDriver;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("http://172.23.176.163:8200/web/index.php/auth/login");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.CompleteLogin("Elena","Elena1122!");

        Thread.sleep(5000);

        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.clickRecruitmentButton();


        RecruitmentPage recruitmentPage= new RecruitmentPage(driver);
        Thread.sleep(3000);
        recruitmentPage.clickAddNewRecruitmentButton();
        Thread.sleep(3000);

        AddCandidatePage addCandidatePage=new AddCandidatePage(driver);
        addCandidatePage.textFieldInput(DataGeneratorManager.getRandomFirstName(),DataGeneratorManager.getRandomMiddleName(),
                DataGeneratorManager.getRandomLastName(),DataGeneratorManager.getRandomEmail(),
                DataGeneratorManager.getRandomKeyword(), DataGeneratorManager.getRandomNotes());
        addCandidatePage.selectVacancy("Tester");
        addCandidatePage.pickTheDate("June","2026","10");
        addCandidatePage.checkConsent();

        addCandidatePage.clickSaveRecruiterButton();


        CandidateCreatedPage candidateCreatedPage=new CandidateCreatedPage(driver);
        candidateCreatedPage.checkCandidateRegistration();



















        driver.quit();
        System.out.println("The test is finished and the driver is closed");
    }


    //System.out.println("The current URL is "+driver.getCurrentUrl());
    //System.out.println("The title of the page is "+ driver.getTitle());

    //WebElement userDropdownIcon= driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
    //userDropdownIcon.click();

      /*  WebElement lockButton =driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        lockButton.click();*/

    //System.out.println("The current URL is "+driver.getCurrentUrl());
    //System.out.println("The title of the page is "+ driver.getTitle());

    /*driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver/4.43.0");*/
    //driver.close();
    // driver.switchTo().window(currentTabName);
    //driver.get("https://automationexercise.com/");

        /*System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource().contains("/logout"));

        driver.findElement(By.cssSelector("a[href='/logout']")).click();
        WebElement loginEmailAddressInputButton = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        loginEmailAddressInputButton.sendKeys(emailRandom);

        WebElement loginPassInputButton = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        loginPassInputButton.sendKeys(passRandom);

        BrowserUtils.safeClick(driver, By.cssSelector("button[data-qa='login-button']"));

        System.out.println("The current URL is "+driver.getCurrentUrl());
        System.out.println("The title of the page is "+ driver.getTitle());*/

}

