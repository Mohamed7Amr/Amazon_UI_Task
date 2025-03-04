package webpages.enter_Consumer_Details_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

public class Enter_Consumer_Details_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public Enter_Consumer_Details_WebElements(WebDriver driver) {
        super(driver);
    }

    /****************************************WEB-ELEMENTS***********************************/
    @FindBy(css = "input[data-axis-test-id='wallet-number-input']")
    WebElement mobile_Number_Txt;
    @FindBy(css = "input[data-axis-test-id='last-five-digits-input']")
    WebElement last_Five_Digits_NID_Txt;
    @FindBy(css = "button[data-axis-test-id='wallet-number-submit-button']")
    WebElement submit_Btn;
}
