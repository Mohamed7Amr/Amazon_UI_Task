package webpages.create_KYC_page;

import dataReader.Load_Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

/**
 * @author MAmr
 * 1) This class is using PageFactory-class from Page_Base to locate web-elements for the "Add new KYC" webpage.
 * 2) This class extends Page_Base class where I declared the object WebDriver that I am using in all webpages classes.
 */
public class Create_KYC_WebElements extends Page_Base {

    /*************************************************CONSTRUCTORS***************************************************/
    public Create_KYC_WebElements(WebDriver driver)
    {
        super(driver);
    }

    /*************************************************LOCATORS_DATA**************************************************/
//    private static final String national_ID_Expiry_Date = Load_Properties.create_KYC_Test_Data.getProperty("national_ID_Expiry_Date");

    /*************************************************WEB_ELEMENTS***************************************************/
    /**
     * General_Notes:
     * Any element has Opacity as zero, makes it invisible.
     * Opacity of a WebElement is 0 makes the element fully transparent, i.e., invisible, but still intractable.
     * This means that even though the element is not visible, a user can still interact with it, such as clicking
     * or entering text.
     */

    /**
     * Names-Suffix Notes:
     * 1)Txt:TextBox; 2)Link:WebLink; 3)Btn:Button; 4)Li:ListItem;
     * 5)Msg:Message; 6)DDL:DropDownList; 7)Opt:Option; 8)Chbox:CheckBox;
     * 9)Rdo:RadioButton; 10)TxtArea:TextArea;
     */
    @FindBy(id = "walletNumber")
    WebElement enter_Wallet_Number_Txt;
    @FindBy(css = "button[type='submit']")
    WebElement submit_Btn;
    @FindBy(id = "kycReferenceNo")
    WebElement reference_No_Txt;
    @FindBy(id = "mobileNo")
    WebElement mobile_Number_Txt;
    @FindBy(id = "firstName")
    WebElement first_Name_Arabic_Txt;
    @FindBy(id = "firstName_help")
    WebElement enter_FirstName_In_Arabic_Msg;
    @FindBy(id = "lastName")
    WebElement last_Name_Arabic_Txt;
    @FindBy(id = "lastName_help")
    WebElement enter_LastName_In_Arabic_Msg;
    @FindBy(id = "customerNationalId")
    WebElement national_ID_Txt;
    @FindBy(id =  "customerNationalIdExpiryDate")
    WebElement national_ID_Expiry_Date_Txt;

//    @FindBy(css = "td[title ='" + national_ID_Expiry_Date + "']")
//    WebElement expiry_Date;
    @FindBy(css = "input[data-axis-test-id='birth-date-input']")
    WebElement birth_Date_Txt;

    /**
     * Has Opacity attribute as 0.
     */
    @FindBy(id = "maritalStatus")
    WebElement marital_Status_DDL;

//    @FindBy(xpath = "(//span[@class='ant-select-selection-search'])[1]")
//    WebElement marital_Status_DDL;
    @FindBy(xpath = "//div[contains(text(),'Divorced')]")
    WebElement divorced_Opt;
    @FindBy(xpath = "//div[contains(text(),'Widowed')]")
    WebElement widowed_Opt;
    @FindBy(xpath = "//div[contains(text(),'Single')]")
    WebElement single_Opt;
    @FindBy(xpath = "//div[contains(text(),'Married')]")
    WebElement married_Opt;
    @FindBy(id = "email")
    WebElement email_Address_Txt;
    @FindBy(id = "governate")
    WebElement governorate_Search_Input;
    @FindBy(css = "div[title='Cairo']")
    WebElement cairo_Governorate_Opt;
    @FindBy(id = "city")
    WebElement city_Search_Input;
    @FindBy(css = "div[title='Abbasia']")
    WebElement abbasia_City_Opt;
    @FindBy(id = "address")
    WebElement address_TxtArea;

    /**
     * Has Opacity in its CSS as zero.
     */
    @FindBy(css = "input[data-axis-test-id='current-address-same-as-personal-address-checkbox']")
    WebElement current_Address_As_Personal_Address_Chbox;
    @FindBy(id = "currentAddrress")
    WebElement current_Address_TxtArea;
    @FindBy(xpath = "(//input[@class='ant-radio-input'][@value='YES'])[1]")
    WebElement linked_To_SME_Yes_Rdo;
    @FindBy(xpath = "(//input[@class='ant-radio-input'][@value='NO'])[1]")
    WebElement linked_To_SME_No_Rdo;
    @FindBy(id = "clientId")
    WebElement SME_Name_Search_Input;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content'][text()='SHokry2']")
    WebElement SME_Name_Opt;
    @FindBy(id = "jobTitle")
    WebElement job_Title_Txt;
    @FindBy(id = "workEntityName")
    WebElement work_Entity_Txt;
    @FindBy(id = "workAddress")
    WebElement work_Address_TxtArea;
    @FindBy(id = "incomeSource")
    WebElement source_Of_Income_Txt;
    @FindBy(id = "monthlyIncome")
    WebElement monthly_Income_Txt;
    @FindBy(id = "partnerId")
    WebElement profile_Search_Input;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(text(),'AmrQC')]")
    WebElement profile_AmrQC_Opt;
    @FindBy(id = "transactionNature")
    WebElement transaction_Nature_Search_Input;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(text(),'Transfer Money')]")
    WebElement transaction_Nature_Transfer_Money_Opt;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(text(),'Payroll')]")
    WebElement transaction_Nature_Payroll_Opt;
    @FindBy(id = "walletRegObjective")
    WebElement wallet_Register_Objective_Search_Input;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(text(),'Bill Payment')]")
    WebElement bill_Payment_Opt;
    @FindBy(css = "div[data-axis-test-id='WalletRegObjective_PAYROLL']")
    WebElement wallet_Registration_Objective_Payroll_Opt;
    @FindBy(xpath = "(//input[@class='ant-radio-input'][@value='YES'])[2]")
    WebElement have_Diplomatic_Job_Yes_Rdo;
    @FindBy(xpath = "(//input[@class='ant-radio-input'][@value='NO'])[2]")
    WebElement have_Diplomatic_Job_No_Rdo;
    @FindBy(id = "diplomaticJob")
    WebElement diplomatic_Job_Description_Txt;
    @FindBy(xpath = "(//input[@class='ant-radio-input'][@value='YES'])[3]")
    WebElement relatives_have_Diplomatic_Job_Yes_Rdo;
    @FindBy(xpath = "(//input[@class='ant-radio-input'][@value='NO'])[3]")
    WebElement relatives_have_Diplomatic_Job_No_Rdo;
    @FindBy(id = "relativeDiplomaticJob")
    WebElement relatives_Diplomatic_Job_Description_Txt;
    @FindBy(css = "button[data-axis-test-id='upload-attachment-FileCategoryType_NATIONAL_ID_FRONT-button']")
    WebElement NID_Side1_Upload_Btn;
    @FindBy(css = "div[data-axis-test-id ='image-preview-FileCategoryType_NATIONAL_ID_FRONT-img']"
    + ">img[class='ant-image-img _image-preview_qvz4w_18 css-736nmc']")
    WebElement NID_Side1_Img;
    @FindBy(css = "button[data-axis-test-id='upload-attachment-FileCategoryType_NATIONAL_ID_BACK-button']")
    WebElement NID_Side2_Upload_Btn;
    @FindBy(css = "div[data-axis-test-id = 'image-preview-FileCategoryType_NATIONAL_ID_BACK-img']"
    + ">img[class='ant-image-img _image-preview_qvz4w_18 css-736nmc']")
    WebElement NID_Side2_Img;
    @FindBy(css = "button[data-axis-test-id='create-button']")
    WebElement create_Btn;
    @FindBy(css = "button[data-axis-test-id='cancel-button']")
    WebElement cancel_Btn;
}
