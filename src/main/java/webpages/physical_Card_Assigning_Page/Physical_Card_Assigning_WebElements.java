package webpages.physical_Card_Assigning_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

public class Physical_Card_Assigning_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public Physical_Card_Assigning_WebElements(WebDriver driver) {
        super(driver);
    }

    /*****************************************WEB-ELEMENTS*******************************/
    @FindBy(css = "button[data-axis-test-id='proceed-button']")
    WebElement proceed_Btn;
    @FindBy(css = ".ant-table-row.ant-table-row-level-0>td>span")
    WebElement customer_Mobile_Number_Td;
    @FindBy(css = "button[data-axis-test-id='save-button']")
    WebElement save_And_Submit_Btn;


}
