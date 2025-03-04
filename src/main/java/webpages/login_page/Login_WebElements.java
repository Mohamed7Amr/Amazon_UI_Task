package webpages.login_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

/**
 * @author MAmr
 * 1) This class is using PageFactory-class from Page_Base to locate web-elements for the "Add new KYC" webpage.
 * 2) This class extends Page_Base class where I declared the object WebDriver that I am using in all webpages classes.
 */
public class Login_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public Login_WebElements(WebDriver driver) {
        super(driver);
    }

    /***************************************WEB-ELEMENTS***********************************************/
    /**
     * General_Notes:
     * Any element has Opacity as zero, makes it invisible.
     * Opacity of a WebElement is 0 makes the element fully transparent, i.e., invisible, but still intractable.
     * This means that even though the element is not visible, a user can still interact with it, such as clicking
     * or entering text.
     */

    /**
     * Names-Suffix Notes:
     * 1)Txt:TextBox; 2)Link:WebLink; 3)Btn:Button; 4)Li:ListItem;
     * 5)Msg:Message; 6)DDL:DropDownList; 7)Opt:Option; 8)Chbox:CheckBox;
     * 9)Rdo:RadioButton; 10)TxtArea:TextArea;
     */
    @FindBy(id = "basic_login")
    WebElement username_Txt;
    @FindBy(id = "basic_password")
    WebElement password_Txt;
    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    WebElement signIn_Btn;
    @FindBy(id = "basic_otp")
    WebElement OTP_Txt;
    @FindBy(css = "div.ant-notification-notice-message")
    WebElement invalid_Login_Msg;
    @FindBy(xpath = "//span[contains(text(),'Verify OTP')]")
    WebElement verify_OTP_Btn;

    
}
