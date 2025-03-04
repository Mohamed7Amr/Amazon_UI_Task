package webpages.submit_KYC_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Submit_KYC_Actions extends Submit_KYC_WebElements {

    /*****************************************CONSTRUCTORS*******************************************/
    public Submit_KYC_Actions(WebDriver driver) {
        super(driver);
    }

    /**************************************METHODS***************************************************/
    @Step("Clicks \"Submit\" button")
    public void click_Submit()
    {
        clickWebElement(submit_Btn);
    }
}
