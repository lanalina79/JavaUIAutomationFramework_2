package online.opencart_automation.pageobjects;

import online.opencart_automation.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage extends Page{
    public RecruitmentPage(WebDriver driver){
        super(driver);
    }

    public void clickAddNewRecruitmentButton(){
        BrowserUtils.scrollAndClickButton(driver, By.xpath("//button[normalize-space()='Add']"));
    }


}
