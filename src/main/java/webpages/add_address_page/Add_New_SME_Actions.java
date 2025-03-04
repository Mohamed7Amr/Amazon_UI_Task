package webpages.add_address_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Add_New_SME_Actions extends Add_New_SME_WebElements{

    /*****************************************CONSTRUCTORS*******************************************/
    public Add_New_SME_Actions(WebDriver driver) {
        super(driver);
    }

    /****************************************ACTIONS***********************************************/
    @Step("Enter first name")
    public void enter_First_Name(String first_Name)
    {
        writeText(first_Name_In_English_Txt, first_Name);
    }
}
