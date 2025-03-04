package webpages.cashOut_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CashOut_Actions extends CashOut_WebElements {

    /*****************************************CONSTRUCTORS*******************************************/
    public CashOut_Actions(WebDriver driver) {
        super(driver);
    }

    /*****************************************METHODS***********************************************/
    @Step("Enters a mobile number of a consumer with Axis wallet.")
    public void insert_Mobile_Number(String consumer_Wallet_Number)
    {
        writeText(find_Element(mobile_Number_Txt_Locator),consumer_Wallet_Number);
    }
    @Step("Enters Amount")
    public void insert_Amount(String amount)
    {
        writeText(find_Element(amount_Txt_Locator), amount);
    }
}
