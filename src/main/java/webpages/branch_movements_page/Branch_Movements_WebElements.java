package webpages.branch_movements_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

public class Branch_Movements_WebElements extends Page_Base{

    /*****************************************CONSTRUCTORS*******************************************/
    public Branch_Movements_WebElements(WebDriver driver) {
        super(driver);
    }

    /*****************************************WEB_ELEMENTS********************************************/
    /**
     * Names-Suffix Notes:
     * 1)Txt:TextBox; 2)Link:WebLink; 3)Btn:Button; 4)Li:ListItem;
     * 5)Msg:Message; 6)DDL:DropDownList; 7)Opt:Option; 8)Chbox:CheckBox;
     * 9)Rdo:RadioButton; 10)TxtArea:TextArea; 11)td:table-data(column)
     */
    @FindBy(xpath = "//h1[text()='Branch Movements']")
    WebElement branch_Movements_Page_Header_title;
    @FindBy(xpath = "//span[contains(text(),'Create New Request')]")
    WebElement create_New_Request_Btn;
    @FindBy(xpath = "//h1[text()='Cash Movement Request']")
    WebElement cash_Movement_Request_Popup_Header_Title;
    @FindBy(id = "amount")
    WebElement amount_Txt;
    @FindBy(id = "mPin")
    WebElement mPin_Txt;
    @FindBy(xpath = "//button/span[text()='SUBMIT']")
    WebElement submit_Btn;
    @FindBy(xpath = "(//tbody/tr)[2]/td[5]//button[@data-axis-test-id='table-actions-approve-button']")
    WebElement confirm_Action_Btn;
    @FindBy(xpath = "(//tbody/tr)[2]/td[5]//button[@data-axis-test-id='table-actions-decline-button']")
    WebElement decline_Action_Btn;
    @FindBy(css = "input[data-axis-test-id='cit-input']")
    WebElement CIT_Number_Txt;
    @FindBy(xpath = "//h1[text()='Are you sure you want to confirm this movement?']")
    WebElement confirm_Cash_Movement_PopUp_Title;
    @FindBy(xpath = "//div[@class='ant-notification-notice-message'][contains(text(),'Successfully')]")
    WebElement request_Success_Msg;
    @FindBy(xpath = "(//tbody/tr)[2]/td[4]/span")
    WebElement status_td;
}
