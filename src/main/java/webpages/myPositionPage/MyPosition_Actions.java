package webpages.myPositionPage;

import dataWriter.TestData_PropertiesFile_Writer;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public class MyPosition_Actions extends MyPosition_Locators{

    /*****************************************CONSTRUCTORS*******************************************/
    public MyPosition_Actions(WebDriver driver) {
        super(driver);
    }

    /*****************************************ACTIONS*******************************************/
    /**
     * I made sure that the dashboard has loaded completely and retrieved the data before opening "Move Cash" window,
     * and that via visibility_Locating Cash-on-hand info in the dashboard.
     * Also, I used sleeping-thread because of performance issue regarding the "Current cash balance" in the "Move Cash"
     * window which is not reflecting the amount instantly from the dashboard once I open "Move Cash", which led to having
     * zero "current cash balance" every time during running the automated script, thus i make the thread asleep for
     * few seconds to reflect the right amount of "Current cash balance".
     */
    @SneakyThrows
    @Step("Click on \"Move Cash\" button.")
    public void click_MoveCash()
    {
        wait_Locator_Visibility(cash_On_Hand_Dashboard_Amount_Locator);
        clickWebElement(find_Element(move_Cash_Btn_Locator));
        Thread.sleep(3000);
    }
    @Step("Open \"Choose Agent\" DDL")
    public void Open_Choose_Agent()
    {
        clickWebElement(find_Element(choose_Agent_Txt_Locator));
    }
    @Step("Choose an agent from DDL.")
    public void choose_Agent(String agent_Name)
    {
        writeText(find_Element(choose_Agent_Txt_Locator),agent_Name);
//        clickWebElement(find_Element(agent_Opt_Locator));
    }
    @Step("Insert amount")
    public void insert_Amount(String amount_Relative_To_Cash_On_Hand)
    {
        String current_Cash_Balance = getText(find_Element(cash_On_Hand_Dashboard_Amount_Locator)).replace(",","");
        TestData_PropertiesFile_Writer.write_Properties("src/test/resources/Files_To_Write_In/Properties_Files/Move_Cash_Execution_Data.properties",
                "current_Cash_Balance",current_Cash_Balance);

        switch (amount_Relative_To_Cash_On_Hand)
        {
            case "equal" -> writeText(find_Element(amount_Txt_Locator),current_Cash_Balance);
            case "more" -> writeText(find_Element(amount_Txt_Locator),do_Math_Operation_On_String(current_Cash_Balance,'+',1));
            case "zero" -> writeText(find_Element(amount_Txt_Locator),do_Math_Operation_On_String(current_Cash_Balance,'-',
                    convert_String_To_Integer(current_Cash_Balance)));
        }
    }
    @Step("Click \"Submit\" button")
    public  void click_Submit()
    {
        clickWebElement(find_Element(submit_Btn_Locator));
    }


    /******************************************ASSERTIONS**************************************************/
    public void validate_Cash_On_Hand_Same_As_Current_Cash_Balance()
    {
        assert_Actual_Text_contains_Expected_Text(cash_On_Hand_Dashboard_Amount_Locator,current_Cash_Balance_Label_Locator,
                "Amount of \"Cash on Hand\" should be the same as \"Current Cash Balance\" Validation");
    }
    public void validate_Request_Sent_Successfully()
    {
        assert_Actual_Text_Contains_Expected_Text("Request Sent Successfully",request_Sent_Successfully_Msg_Locator,
                "Move Cash request has been sent successfully message display validation");
    }
    public void validate_Insufficient_Amount_Msg()
    {
        assert_Actual_Text_Contains_Expected_Text("Insufficient Cash",insufficient_Cash_Msg_Locator,
                "Insufficient cash should be displayed when writing amount exceeding \"Current cash Balance\" validation");
    }

    /**
     * I used Thread.sleep() in the fn because the table takes few seconds to get updated with latest request,
     * If I don't use it then it will assert on the status of an older request.
     */
    @SneakyThrows
    public void validate_Request_Status_Pending_Approval()
    {
        Thread.sleep(3000);
        assert_Actual_Text_Contains_Expected_Text("Pending Approval",status_Col_Locator,
                "Status has been updated to \"Pending Approval\" after successfully submit Move cash request validation");
    }

}