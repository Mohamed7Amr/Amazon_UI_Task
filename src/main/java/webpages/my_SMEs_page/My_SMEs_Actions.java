package webpages.my_SMEs_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class My_SMEs_Actions extends My_SMEs_WebElements{

    /*****************************************CONSTRUCTORS*******************************************/
    public My_SMEs_Actions(WebDriver driver) {
        super(driver);
    }

    /*****************************************ACTIONS**********************************************/
    @Step("Click \"Add New SME\" button")
    public void click_Add_New_SME()
    {
        clickWebElement(add_New_SME_Btn);
    }
}
