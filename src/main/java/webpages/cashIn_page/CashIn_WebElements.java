package webpages.cashIn_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

public class CashIn_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public CashIn_WebElements(WebDriver driver) {
        super(driver);
    }

    /*****************************************WEB-ELEMENTS********************************************/
    /**
     * Names-Suffix Notes:
     * 1)Txt:TextBox; 2)Link:WebLink; 3)Btn:Button; 4)Li:ListItem;
     * 5)Msg:Message; 6)DDL:DropDownList; 7)Opt:Option; 8)CheckBox:CheckBox;
     * 9)Rdo:RadioButton; 10)TxtArea:TextArea;
     */

    @FindBy(id = "receiverMobileNumber")
    WebElement mobile_Number_Txt;
    @FindBy(css = "input[data-axis-test-id = 'cashin-amount-value']")
    WebElement amount_Txt;
    @FindBy(xpath = "(//input[@data-axis-test-id = 'mpin-input'])[1]")
    WebElement first_mPIN_Txt;
    @FindBy(css = "button.ant-btn.css-736nmc.ant-btn-primary.ant-btn-lg.ant-btn-block")
    WebElement review_Details_Btn;
    @FindBy(xpath = "//h1[contains(text(),'Review Details')]")
    WebElement review_Details_Popup;
    @FindBy(xpath = "(//span[text()='Amount'])[2]")
    WebElement amount_Label;
    @FindBy(xpath = "(//span[contains(@class,'_details-value')])[1]")
    WebElement amount_Value_EGP;
    @FindBy(xpath = "//span[text()='Fees']")
    WebElement fees_Label;
    @FindBy(xpath = "//span[starts-with(@class,'_fees-value_')]")
    WebElement fees_Value_EGP;
    @FindBy(xpath = "//span[text()='Total Amount']")
    WebElement totalAmount_Label;
    @FindBy(xpath = "(//span[contains(@class,'_details-value')])[2]")
    WebElement totalAmount_Value_EGP;
    @FindBy(xpath = "(//input[@data-axis-test-id = 'mpin-input'])[2]")
    WebElement second_mPIN_Txt;
    @FindBy(css = "input[data-axis-test-id='otp-input']")
    WebElement OTP_Txt;
    @FindBy(xpath = "//button/span[text()='Cash in']")
    WebElement cashIn_Btn;
    @FindBy(xpath = "//p[text()='Your transaction is processing...']")
    WebElement trx_Processing_PopUp;
    @FindBy(xpath = "//button/span[text()=' Print Receipt']")
    WebElement print_Receipt_Btn;
    @FindBy(xpath = "//p[starts-with(@class,'_receipt-value_')][preceding::p[text()='Amount']][following::p[text()='Fees']]")
    WebElement amount_Value_In_Trx_Slip;
    @FindBy(xpath = "//p[starts-with(@class,'_receipt-value_')][preceding::p[text()='Fees']][following::p[text()='Total Amount']]")
    WebElement fees_Value_In_Trx_Slip;
    @FindBy(xpath = "//p[starts-with(@class,'_receipt-value_')][preceding::p[text()='Total Amount']]")
    WebElement total_Amount_Value_In_Trx_Slip;
}
