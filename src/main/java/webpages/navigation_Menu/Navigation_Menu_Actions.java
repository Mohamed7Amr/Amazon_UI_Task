package webpages.navigation_Menu;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Navigation_Menu_Actions extends Navigation_Menu_WebElements {

    /*****************************************CONSTRUCTORS*******************************************/
    public Navigation_Menu_Actions(WebDriver driver) {
        super(driver);
    }

    /*****************************************ACTIONS_ON_NAV_MENU_WEB-ELEMENTS******************************/
    @Step("clicks KYC Management Link.")
    public void click_KYC_Management_Link()
    {
        clickWebElement(KYC_Management_NavigationLink);
    }
    @Step("Clicks KYC Documents Link.")
    public void click_KYC_Documents_Link()
    {
        clickWebElement(KYC_Documents_NavigationLink);
    }
    @Step("Click \"Bulk KYCs\" link")
    public void click_Bulk_KYCs_Link()
    {
        clickWebElement(bulk_KYCs_NavigationLink);
    }
    @Step("Clicks Cash Transactions link in the nav menu.")
    public void click_Cash_Transactions_Link()
    {
        clickWebElement(cash_Transactions_NavigationLink);
    }
    @Step("Click \"Physical Cards\" link")
    public void click_Physical_Cards()
    {
        clickWebElement(physical_Cards_NavLink);
    }
    @Step("Click \"Requests\" link")
    public void click_Requests()
    {
        clickWebElement(requests_NavLink);
    }
    @Step("Clicks Cash Management link")
    public void click_Cash_Management_Link()
    {
        clickWebElement(cash_Management_NavigationLink);
    }
    @Step("Clicks Branch Movements link")
    public void click_Branch_Movements_Link()
    {
        clickWebElement(branch_Movements_NavigationLink);
    }
    @Step("Click on \"MyPosition\" link in navigation menu")
    public void click_MyPosition()
    {
        clickWebElement(myPosition_NavLink);
    }
}
