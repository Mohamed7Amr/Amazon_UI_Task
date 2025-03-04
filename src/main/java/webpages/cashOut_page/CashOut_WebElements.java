package webpages.cashOut_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Page_Base;

public class CashOut_WebElements extends Page_Base {
    /*****************************************CONSTRUCTORS*******************************************/
    public CashOut_WebElements(WebDriver driver) {
        super(driver);
    }

    protected final By mobile_Number_Txt_Locator = By.id("receiverMobileNumber");
    protected final By amount_Txt_Locator = By.cssSelector("input[data-axis-test-id = 'cashout-amount-value']");
    protected final By mPIN_Txt_css_Locator = By.cssSelector("input[data-axis-test-id = 'mpin-input']");
    protected final By review_Details_Btn_css_Locator = By.cssSelector("button.ant-btn.css-736nmc.ant-btn-primary.ant-btn-lg.ant-btn-block");
    protected final By review_Details_Popup_xpath_Locator = By.xpath("//h1[contains(text(),'Review Details')]");
    protected final By amount_Label_xpath_Locator = By.xpath("(//span[@class = '_details-label_7mg0c_70'])[2]");
    protected final By amount_Value_EGP_xpath_Locator = By.xpath("(//span[@class = '_details-value_7mg0c_75'])[1]");
    protected final By fees_Label_css_Locator = By.cssSelector("span._fees-label_7mg0c_95");
    protected final By fees_Value_EGP_css_Locator = By.cssSelector("span._fees-value_7mg0c_101");
    protected final By totalAmount_Label_xpath_Locator = By.xpath("(//span[@class = '_details-label_7mg0c_70'])[3]");
    protected final By totalAmount_Value_EGP_xpath_Locator = By.xpath("(//span[@class = '_details-value_7mg0c_75'])[2]");
}
