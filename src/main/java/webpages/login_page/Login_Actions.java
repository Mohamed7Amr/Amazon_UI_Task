package webpages.login_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Mohamed_Amr
 * This class has all the methods (Actions) that are done upon elements in the Login webpage.
 */
public class Login_Actions extends Login_WebElements {


    /**************************************CONSTRUCTORS********************************************/

    public Login_Actions(WebDriver driver)
    {
        super(driver);
    }

    /**************************************METHODS***************************************************/

    @Step("Inserts username.")
    public void insert_Username(String email_Address)
    {
        writeText(username_Txt, email_Address);
    }
    @Step("Inserts password")
    public void insert_Password(String password)
    {
        writeText(password_Txt, password);
    }
    @Step("Clicks sign-in button")
    public void click_SignIn_Btn()
    {
        clickWebElement(signIn_Btn);
        login_Assertion();
    }
    @Step("Inserts the sent OTP")
    public void insert_OTP(String OTP)
    {
            writeText(OTP_Txt, OTP);
            clickWebElement(verify_OTP_Btn);
    }

    /**
     * It sums-up several methods for the process of logging in to the Agent portal.
     * @param user_Name unique agent username he created while creating his account on Agent portal *not an email address or mobile number*
     * @param password unique password that was asked in an email to be created while creating the Agent account
     * @param OTP unique OTP that should be sent in an email *245345*
     */
    @Step("Agent signs in")
    public void signIn(String user_Name, String password, String OTP)
    {
        insert_Username(user_Name);
        insert_Password(password);
        click_SignIn_Btn();
        insert_OTP(OTP);
    }

    /****************************************ASSERTIONS********************************************/
    /**
     * In try code; If wrong credentials were inserted, invalid-login msg display should be asserted.
     * In catch code; If correct credentials were inserted, "verify OPT" btn existence should be asserted.
     */
    private void login_Assertion()
    {
        try{
            wait_Element_Visibility(5,invalid_Login_Msg);
            String expectedResult = "Invalid Login";
            String actualResult = invalid_Login_Msg.getText();
            Assert.assertTrue(actualResult.contains(expectedResult),"Invalid Login Msg Assertion");
        }
        catch (Exception e)
        {
            wait_Element_Visibility(5,verify_OTP_Btn);
            Assert.assertTrue(verify_OTP_Btn.isDisplayed(),"Sign-in with valid credentials to use OTP Assertion");
        }
    }

}
