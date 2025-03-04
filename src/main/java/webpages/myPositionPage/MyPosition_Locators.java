package webpages.myPositionPage;

import dataReader.Load_Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Page_Base;

public class MyPosition_Locators extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
//    String receiver_Agent = Load_Properties.Agent_Move_Cash_Data.getProperty("receiver_Agent");

    /*****************************************CONSTRUCTORS*******************************************/
    public MyPosition_Locators(WebDriver driver) {
        super(driver);
    }

    /*****************************************WEB-ELEMENTS*******************************************/
    By cash_On_Hand_Dashboard_Amount_Locator = By.xpath("//h4[following::span[contains(.,'Cash on hand')]]");
    By cash_On_Hand_Dashboard_Label_Locator = By.xpath("//span[contains(.,'Cash on hand')]");
    By move_Cash_Btn_Locator = By.xpath("//span[text()='Move Cash']");
    By current_Cash_Balance_Label_Locator = By.xpath("//span[contains(@class,'cash-balance')][preceding::h1[text()='Move Cash']]");
    By choose_Agent_Txt_Locator = By.id("toUserId");
//    By agent_Opt_Locator = By.xpath(String.format("//div[@class='ant-select-item-option-content'][text()='%s']",receiver_Agent));
    By amount_Txt_Locator = By.cssSelector("input[data-axis-test-id='amount-value']");
    By submit_Btn_Locator = By.xpath("//span[text()='SUBMIT']");
    By request_Sent_Successfully_Msg_Locator = By.xpath("//div[text()='Request Sent Successfully']");
    By insufficient_Cash_Msg_Locator = By.xpath("//div[text()='Insufficient Cash']");
    By status_Col_Locator = By.xpath("//tr[2]/td[8]/span");

}
