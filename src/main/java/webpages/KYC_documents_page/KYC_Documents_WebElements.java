package webpages.KYC_documents_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

/**
 * @author Mohamed_Amr
 * 1) This class is using PageFactory-class from Page_Base to locate web-elements for the "Add new KYC" webpage.
 * 2) This class extends Page_Base class where I declared the object WebDriver that i am using in all classes.
 */
public class KYC_Documents_WebElements extends Page_Base {
    
    /*****************************************CONSTRUCTORS*******************************************/
    public KYC_Documents_WebElements(WebDriver driver) {
        super(driver);
    }
    
    /*****************************************WEB-ELEMENTS*******************************************/
    @FindBy(css = "a[data-axis-test-id='create-kyc-link']")
    WebElement add_New_KYC_Doc_Btn;
    @FindBy(css = "input[placeholder='Customer Name']")
    WebElement customer_Name_Txt;

}
