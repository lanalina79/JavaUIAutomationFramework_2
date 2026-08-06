package online.opencart_automation.pageobjects;

import online.opencart_automation.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Page{

    public DashboardPage(WebDriver driver){
        super(driver);
        //acest driver sa fie pasat catre clasa parinte superioare prin cuv cheie 'super'
    }


    @FindBy (xpath = "//span[normalize-space()='Recruitment']")
    public WebElement recruitmentButton;

    public void clickRecruitmentButton(){
        recruitmentButton.click();
    }

}
