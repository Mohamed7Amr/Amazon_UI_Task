package webpages.my_SMEs_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

public class My_SMEs_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public My_SMEs_WebElements(WebDriver driver) {
        super(driver);
    }

    /*****************************************WEB-ELEMENTS*******************************************/
    @FindBy(css = "a[data-axis-test-id='add-sme-link']")
    WebElement add_New_SME_Btn;

}
