package webpages.cash_transactions_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Cash_Transactions_Actions extends Cash_Transactions_WebElements{

    /*****************************************CONSTRUCTORS*******************************************/
    public Cash_Transactions_Actions(WebDriver driver) {
        super(driver);
    }

    /*****************************************METHODS************************************************/
    @Step("Clicks on \"Cash in\" link")
    public void clicks_CashIn()
    {
        clickWebElement(cashIn_Link);
    }
    @Step("Clicks on \"Cash out\" link")
    public void clicks_CashOut()
    {
        clickWebElement(cashOut_Link);
    }
}
