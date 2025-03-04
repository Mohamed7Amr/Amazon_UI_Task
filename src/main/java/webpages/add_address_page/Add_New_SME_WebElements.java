package webpages.add_address_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

public class Add_New_SME_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public Add_New_SME_WebElements(WebDriver driver) {
        super(driver);
    }

    /*****************************************WEB-ELEMENTS******************************************/
    /**
     * Naming of variables: camel-case convention naming, and will have underscore “_” as a delimiter between each word-syllabus.
     * The name of the variable should have a name same as the one displayed in the UI for the web-element.
     * Names-Suffix Notes:
     * 1)Txt:TextBox; 2)Link:WebLink; 3)Btn:Button; 4)Li:ListItem;
     * 5)Msg:Message; 6)DDL:DropDownList; 7)Opt:Option; 8)Chbox:CheckBox;
     * 9)Rdo:RadioButton; 10)TxtArea:TextArea; 11)td:table-data(column)
     */
    @FindBy(css = "input[data-axis-test-id='first-name-in-english-input']")
    WebElement first_Name_In_English_Txt;
    @FindBy(css = "input[data-axis-test-id='last-name-in-english-input']")
    WebElement last_Name_In_English_Txt;
    @FindBy(css = "input[data-axis-test-id='client-zoho-id-input']")
    WebElement zoho_ID_Txt;
    @FindBy(css = "input[data-axis-test-id='client-name-in-english-input']")
    WebElement business_Name_Txt;
    @FindBy(css = "input[data-axis-test-id='client-name-in-arabic-input']")
    WebElement arabic_Business_Name_Txt;
    @FindBy(css = "input[data-axis-test-id='tax-id-input']")
    WebElement tax_ID_Txt;
    @FindBy(css = "input[data-axis-test-id='number-of-employees-input']")
    WebElement company_Size_Txt;
    @FindBy(id = "salaryAdvanceAccessLevel")
    WebElement salary_Advances_DDL;
    @FindBy (xpath = "//div[@data-axis-test-id='SMEAdvanceAccessLevel_FULL']")
    WebElement full_Access_Level_Opt;
    @FindBy (xpath = "//div[@data-axis-test-id='SMEAdvanceAccessLevel_LIMITED']")
    WebElement limited_Access_Level_Opt;
    @FindBy (xpath = "//div[@data-axis-test-id='SMEAdvanceAccessLevel_DISABLED']")
    WebElement disabled_Access_Level_Opt;
    @FindBy(id = "planId")
    WebElement plan_DDL;
    @FindBy(xpath =  "//div[@data-axis-test-id='Micro 300']")
    WebElement micro_300_plan;
    @FindBy(xpath = "//input[@data-axis-test-id='email-input']")
    WebElement email_Txt;
    @FindBy(xpath = "//input[@data-axis-test-id='mobile-number-input']")
    WebElement mobile_Number_Txt;

}
