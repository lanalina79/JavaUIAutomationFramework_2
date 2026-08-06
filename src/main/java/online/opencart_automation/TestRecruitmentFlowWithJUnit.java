package online.opencart_automation;

import online.opencart_automation.managers.DataGeneratorManager;
import online.opencart_automation.managers.DriverManager;
import online.opencart_automation.pageobjects.*;
import org.openqa.selenium.WebDriver;

public class TestRecruitmentFlowWithJUnit {
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

}
