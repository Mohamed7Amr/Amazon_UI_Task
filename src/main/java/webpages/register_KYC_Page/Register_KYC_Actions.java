package webpages.register_KYC_Page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Register_KYC_Actions extends Register_KYC_WebElements{
    /*****************************************CONSTRUCTORS*******************************************/
    public Register_KYC_Actions(WebDriver driver) {
        super(driver);
    }

    /***************************************METHODS*********************************************/

    @Step("Clicks \"Register\" button")
    public void click_Register()
    {
        clickWebElement(register_Btn);
    }
}
