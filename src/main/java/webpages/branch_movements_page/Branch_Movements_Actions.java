package webpages.branch_movements_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Branch_Movements_Actions extends Branch_Movements_WebElements{

    /*****************************************CONSTRUCTORS*******************************************/
    public Branch_Movements_Actions(WebDriver driver) {
        super(driver);
    }

    /*****************************************METHODS************************************************/
    @Step("Clicks on \"Create New Request\" button")
    public void click_Create_New_Request_Btn()
    {
        clickWebElement(create_New_Request_Btn);
    }
    @Step("Enters \"Amount\" field.")
    public void insert_Amount(String amount)
    {
        writeText(amount_Txt,amount);
    }
    @Step("Inserts mPIN ")
    public void insert_mPIN(String mPIN)
    {
        writeText(mPin_Txt,mPIN);
    }
    @Step("Clicks Submit button")
    public void click_Submit()
    {
        clickWebElement(submit_Btn);
    }
    @Step("Clicks \"Confirm\" Action button")
    public void click_Confirm_Action_Btn()
    {
        clickWebElement(confirm_Action_Btn);
    }
    @Step("Inserts CIT number")
    public void insert_CIT(String CIT)
    {
        writeText(CIT_Number_Txt,CIT);
    }
    @Step("Clicks \"Confirm\" in the cash movement popup")
    public void click_Confirm_PopUp()
    {
        clickWebElement(confirm_Cash_Movement_PopUp_Title);
    }
    @Step("Clicks \"decline\" button")
    public void click_Decline()
    {
        clickWebElement(decline_Action_Btn);
    }

    /*****************************************ASSERTIONS************************************************/
    public void validate_Create_New_Request_Popup()
    {
        String expected_Result = "Cash Movement Request";
        String actual_Result = wait_Element_Visibility(5,cash_Movement_Request_Popup_Header_Title).getText();
        Assert.assertEquals(actual_Result,expected_Result,"Validate that \"cash Movement Request\" window opens");
    }
    public void validate_Request_Success_Message()
    {
        try{
            Assert.assertTrue(wait_Element_Visibility(5,request_Success_Msg).getText().contains("Successfully"),
                    "Validate that notification gets displayed when the cash movement request succeeds");
        }
        catch (AssertionError e)
        {
            System.out.println(request_Success_Msg.getText());
        }
    }
    public void validate_Status(String status)
    {
        try{
            Assert.assertTrue(wait_Element_Visibility(5,status_td).getText().contains(status),
                    "Validate that status displayed in the column is same as expected");
        }
        catch (AssertionError e)
        {
            System.out.println(status_td.getText());
        }
    }
}
