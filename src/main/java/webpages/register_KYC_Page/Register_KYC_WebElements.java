package webpages.register_KYC_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

public class Register_KYC_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public Register_KYC_WebElements(WebDriver driver) {
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
    @FindBy(css = "button[data-axis-test-id = 'register-button']")
    WebElement register_Btn;
}
