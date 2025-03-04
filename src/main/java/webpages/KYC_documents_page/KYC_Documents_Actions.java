package webpages.KYC_documents_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

/**
 * @author Mohamed_Amr
 */
public class KYC_Documents_Actions extends KYC_Documents_WebElements {

    /*************************************CONSTRUCTORS************************************************/
    public KYC_Documents_Actions(WebDriver driver)
    {
        super(driver);
    }

    /************************************METHODS*****************************************************/
    @Step("Clicks Add New KYC.")
    public void click_Add_New_KYC()
    {
        clickWebElement(add_New_KYC_Doc_Btn);
    }

}
