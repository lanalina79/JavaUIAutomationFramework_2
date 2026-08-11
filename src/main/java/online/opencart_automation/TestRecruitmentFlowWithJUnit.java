package online.opencart_automation;

import online.opencart_automation.managers.DataGeneratorManager;
import online.opencart_automation.managers.DriverManager;
import online.opencart_automation.pageobjects.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestRecruitmentFlowWithJUnit {
    static WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    RecruitmentPage recruitmentPage;
    private static final String  emptyLastName="";


    @BeforeEach
    public void executeTheCodeBeforeEachTest() throws InterruptedException {
        driver = DriverManager.getInstance().getDriver();

        driver.get("http://172.23.176.163:8200/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
        loginPage.CompleteLogin("Elena", "Elena1122!");

        Thread.sleep(5000);

        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRecruitmentButton();


        recruitmentPage = new RecruitmentPage(driver);
        Thread.sleep(3000);
        recruitmentPage.clickAddNewRecruitmentButton();
        Thread.sleep(3000);

    }

    @Test
    @Disabled
    @DisplayName("Add a candidate with JUnit")
    public void addCandidate() throws InterruptedException {
        AddCandidatePage addCandidatePage = new AddCandidatePage(driver);
        addCandidatePage.textFieldInput(DataGeneratorManager.getRandomFirstName(), DataGeneratorManager.getRandomMiddleName(),
                DataGeneratorManager.getRandomLastName(), DataGeneratorManager.getRandomEmail(),
                DataGeneratorManager.getRandomKeyword(), DataGeneratorManager.getRandomNotes());
        addCandidatePage.selectVacancy("Tester");
        addCandidatePage.pickTheDate("June", "2026", "10");
        addCandidatePage.checkConsent();

        addCandidatePage.clickSaveRecruiterButton();
        CandidateCreatedPage candidateCreatedPage = new CandidateCreatedPage(driver);

        Assertions.assertTrue(candidateCreatedPage.isCandidateNameDisplayed(),"The name is displayed");
        Thread.sleep(10000);

    }

    @Test
    @Disabled
    @DisplayName("Validate Last Name Error")
    public void validateEmptyLastNameError() throws InterruptedException {
        AddCandidatePage addCandidatePage = new AddCandidatePage(driver);
        addCandidatePage.textFieldInput(DataGeneratorManager.getRandomFirstName(), DataGeneratorManager.getRandomMiddleName(),
                emptyLastName, DataGeneratorManager.getRandomEmail(),
                DataGeneratorManager.getRandomKeyword(), DataGeneratorManager.getRandomNotes());
        addCandidatePage.selectVacancy("Tester");
        addCandidatePage.pickTheDate("June", "2026", "10");
        addCandidatePage.checkConsent();

        addCandidatePage.clickSaveRecruiterButton();
        boolean isLastNameErrorDisplayed = addCandidatePage.isLastNameErrorMessageDisplayed();
        Assertions.assertTrue(isLastNameErrorDisplayed,"The Last Name is required");
        Thread.sleep(10000);

    }

    @Test
    @Disabled
    @DisplayName("Validate FirstName is not empty")
    public void validateFirstNameIsNotEmpty() throws InterruptedException {
        AddCandidatePage addCandidatePage = new AddCandidatePage(driver);
        addCandidatePage.textFieldInput(DataGeneratorManager.getRandomFirstName(), DataGeneratorManager.getRandomMiddleName(),
                DataGeneratorManager.getRandomLastName(), DataGeneratorManager.getRandomEmail(),
                DataGeneratorManager.getRandomKeyword(), DataGeneratorManager.getRandomNotes());
        addCandidatePage.selectVacancy("Tester");
        addCandidatePage.pickTheDate("June", "2026", "10");
        addCandidatePage.checkConsent();
        String actualFirstName = addCandidatePage.getActualFirstName();
        System.out.println("actualFirstName "+ actualFirstName);
        Assertions.assertNotEquals("",actualFirstName,"First name should not be empty");
        //addCandidatePage.clickSaveRecruiterButton();

         Thread.sleep(10000);




    }

    @Test
    @DisplayName("When entering valid email error is NOT be displayed")
    public void validateEmailFormat() throws InterruptedException {
        AddCandidatePage addCandidatePage = new AddCandidatePage(driver);
        addCandidatePage.textFieldInput(DataGeneratorManager.getRandomFirstName(), DataGeneratorManager.getRandomMiddleName(),
                DataGeneratorManager.getRandomLastName(), DataGeneratorManager.getRandomEmail(),
                DataGeneratorManager.getRandomKeyword(), DataGeneratorManager.getRandomNotes());
        addCandidatePage.selectVacancy("Tester");
        addCandidatePage.pickTheDate("June", "2026", "10");
        addCandidatePage.checkConsent();
        Boolean isEmailErrorMessageDisplayed = addCandidatePage.isEmailErrorDisplayed();
        Assertions.assertFalse(isEmailErrorMessageDisplayed,"The invalid email format error should NOT be displayed");
        //addCandidatePage.clickSaveRecruiterButton();

        Thread.sleep(10000);}

    @AfterEach
    public void executeCodeAfterEachTest() {
        DriverManager.getInstance().tearDownForBrowser();
        System.out.println("The test is finished and the driver is closed");
    }


}
