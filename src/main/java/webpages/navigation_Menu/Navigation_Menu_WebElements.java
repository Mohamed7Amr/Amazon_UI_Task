package webpages.navigation_Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

public class Navigation_Menu_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public Navigation_Menu_WebElements(WebDriver driver) {
        super(driver);
    }

    /****************************************NAVIGATION_MENU_WEB-ELEMENTS********************************/
    /**
     * Names-Suffix Notes:
     * 1)Txt:TextBox; 2)Link:WebLink; 3)Btn:Button; 4)Li:ListItem;
     * 5)Msg:Message; 6)DDL:DropDownList; 7)Opt:Option; 8)Chbox:CheckBox;
     * 9)Rdo:RadioButton; 10)TxtArea:TextArea;
     */
    @FindBy(css = "a[data-axis-test-id = 'dashboard-link']")
    WebElement dashboard_Link;
    @FindBy(css = "span[data-axis-test-id = 'kyc-management-link']")
    WebElement KYC_Management_NavigationLink;
    @FindBy(css = "a[data-axis-test-id = 'my-kyc-documents-link']")
    WebElement KYC_Documents_NavigationLink;
    @FindBy(css = "a[data-axis-test-id='my-bulk-kyc-documents-link']")
    WebElement bulk_KYCs_NavigationLink;
    @FindBy(css = "a[data-axis-test-id = 'cash-transactions-link']")
    WebElement cash_Transactions_NavigationLink;
    @FindBy(css = "span[data-axis-test-id = 'cash-management-link']")
    WebElement cash_Management_NavigationLink;
    @FindBy(css = "span[data-axis-test-id='physical-cards-link']")
    WebElement physical_Cards_NavLink;
    @FindBy(css = "a[data-axis-test-id='physical-cards-requests-link']")
    WebElement requests_NavLink;
    @FindBy(css = "a[data-axis-test-id='branch-movements-link']")
    WebElement branch_Movements_NavigationLink;
    @FindBy(css = "a[data-axis-test-id='my-position-link']")
    WebElement myPosition_NavLink;
    @FindBy(css = "span[data-axis-test-id='smes-link']")
    WebElement SMEs_NavigationLink;
    @FindBy(css = "a[data-axis-test-id='my-smes-link']")
    WebElement my_SMEs_NavigationLink;
}
