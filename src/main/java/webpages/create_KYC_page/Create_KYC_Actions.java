package webpages.create_KYC_page;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Year;

/**
 * @author MAmr
 */
public class Create_KYC_Actions extends Create_KYC_WebElements {

    /**************************************CONSTRUCTORS*****************************************/
    public Create_KYC_Actions(WebDriver driver)
    {
        super(driver);
    }

    /***************************************METHODS*********************************************/
    @Step("Enters Wallet Number.")
    public void enter_Wallet_Number(String mobile_number)
    {
        writeText(enter_Wallet_Number_Txt, mobile_number);
    }
    @Step("Clicks Submit.")
    public void click_Submit()
    {
        clickWebElement(submit_Btn);
    }
    @Step("Enters First Name Arabic.")
    public void enter_First_Name_Arabic(String fName)
    {
        writeText(first_Name_Arabic_Txt,fName);
    }
    @Step("Enters Last Name Arabic.")
    public void enter_Last_Name_Arabic(String lName)
    {
        writeText(last_Name_Arabic_Txt, lName);
    }
    @Step("Enters National ID.")
    public void enter_National_ID(String NID)
    {
        writeText(national_ID_Txt,NID);
    }

    /**
     * 1) This method takes an expiry date in dd/mm/yyyy as this is the format that the input WebElement accepts.
     * 2) Then I need to findElement of the date in the picker-table, and it exists in the picker-table's DOM
     * in yyyy-mm-dd format, thus I need to change the format of the date that I wrote in the input TxtBox to one
     * that can be extracted from picker-table.
     * 3) Then I need to validate that the birthdate has been extracted correctly from the NID
     * @param expiry_Date of data-type String
     */
    @Step("Enters National ID Expiry Date.")
    public void enter_National_ID_Expiry_Date(String expiry_Date)
    {
        writeText(national_ID_Expiry_Date_Txt,expiry_Date);
        expiry_Date = fwdSlash_To_Hyphen_Date_Format(change_Date_Format(expiry_Date));
        clickWebElement(driver.findElement(By.cssSelector("td[title ='" + expiry_Date + "']")));
        validate_BirthDate();
    }

    @Step("Enters Martial Status.")
    public void enter_Martial_Status(String martial_Status)
    {
        clickWebElement(marital_Status_DDL);

        switch (martial_Status)
        {
            case "Divorced": clickWebElement(divorced_Opt);
            validate_Martial_Status(martial_Status); break;

            case "Widowed": clickWebElement(widowed_Opt);
            validate_Martial_Status(martial_Status); break;

            case "Single": clickWebElement(single_Opt); break;
//            validate_Martial_Status(martial_Status); break;
//            Check pesudo element that has hidden visibility
//            Remember after checking what's the problem with this validation to change also
//            in Axis_Integrations project

            case "Married": clickWebElement(married_Opt);
            validate_Martial_Status(martial_Status); break;

            default: System.out.println("wrong input"); break;
        }
    }
    @Step("Enters email address.")
    public void enter_Email(String email_Address)
    {
        writeText(email_Address_Txt,email_Address);
    }

    //validate_Gender_Method, do it if you want haha

    @Step("Enters Governorate.")
    public void enter_Governorate()
    {
        governorate_Search_Input.click();
        clickWebElement(governorate_Search_Input);
        clickWebElement(cairo_Governorate_Opt);
        validate_Governorate();
    }
    @Step("Enters City.")
    public void enter_City()
    {
        clickWebElement(city_Search_Input);
        clickWebElement(abbasia_City_Opt);
//        validate_City(city_Choice);
    }
    @Step("Enters Address.")
    public void enter_Address(String address)
    {
        writeText(address_TxtArea,address);
    }
    @Step("UnClicks Current Address Same As Personal Address.")
    public void unclick_Current_Address_SameAs_Personal_Address()
    {
        clickWebElement(current_Address_As_Personal_Address_Chbox);
    }
    @Step("Enters Current Address.")
    public void enter_Current_Address(String current_Address)
    {
        writeText(current_Address_TxtArea, current_Address);
    }
    @Step("Clicks No radio button to Linked To SME.")
    public void click_Not_Linked_To_SME()
    {
        clickWebElement(linked_To_SME_No_Rdo);
        Assert.assertFalse(SME_Name_Search_Input.isEnabled());
    }
    @Step("Clicks Yes radio button to Linked To SME.")
    public void click_Linked_To_SME()
    {
        clickWebElement(linked_To_SME_Yes_Rdo);
    }
    @Step("Enters SME Name.")
    public void enter_SME_Name(String SME_Name)
    {
        writeText(SME_Name_Search_Input, SME_Name);
        clickWebElement(SME_Name_Opt);
    }
    @Step("Enters Job Title.")
    public void enter_JobTitle(String job_Title)
    {
        writeText(job_Title_Txt, job_Title);
    }
    @Step("Enters Work Entity Name.")
    public void enter_Work_Entity_Name(String work_Entity)
    {
        writeText(work_Entity_Txt, work_Entity);
    }
    @Step("Enters Work Address.")
    public void enter_Work_Address(String work_Address)
    {
        writeText(work_Address_TxtArea, work_Address);
    }
    @Step("Enters Source Of Income.")
    public void enter_Source_Of_Income(String income_Source)
    {
        writeText(source_Of_Income_Txt, income_Source);
    }
    @Step("Enters Monthly Income.")
    public void enter_Monthly_Income(String monthly_Income)
    {
        writeText(monthly_Income_Txt, monthly_Income);
    }
    @Step("Enters Profile Name.")
    public void enter_Profile_Name(String profile_Name)
    {
        writeText(profile_Search_Input, profile_Name);
        clickWebElement(profile_AmrQC_Opt);
    }
    @Step("Enters Transaction Nature.")
    public void enter_Transaction_Nature(String transaction_Nature)
    {
        writeText(transaction_Nature_Search_Input, transaction_Nature);
        clickWebElement(transaction_Nature_Payroll_Opt);
//        clickWebElement(transaction_Nature_Transfer_Money_Opt); there's a bug here with options having a white-space
    }
    @Step("Enters Wallet Registration Objective.")
    public void enter_Wallet_Registration_Objective(String wallet_Objective)
    {
        writeText(wallet_Register_Objective_Search_Input, wallet_Objective);
        clickWebElement(wallet_Registration_Objective_Payroll_Opt);
//        clickWebElement(bill_Payment_Opt); there's a bug here with options having a white-space
    }

    /**
     *
     *<p></p>
     * @param yes_Or_No
     * @param diplomatic_Job_Description
     */
    @Step("Clicks yes/No have Diplomatic Job, and writes job description")
    public void click_Diplomatic_Job(char yes_Or_No, String diplomatic_Job_Description)
    {
        switch(yes_Or_No)
        {
            case 'Y':
                clickWebElement(have_Diplomatic_Job_Yes_Rdo);
                writeText(diplomatic_Job_Description_Txt,diplomatic_Job_Description);
                break;
            case 'N':
                clickWebElement(have_Diplomatic_Job_Yes_Rdo);
                clickWebElement(have_Diplomatic_Job_No_Rdo);
                break;
            default:
                System.out.println("wrong input");
                break;
        }
    }
    @Step("Clicks yes/No Relative has Diplomatic Job, and writes job description")
    public void click_Relative_Diplomatic_Job(char yes_Or_No, String relative_Diplomatic_Job_Description)
    {
        switch(yes_Or_No)
        {
            case 'Y':
                clickWebElement(relatives_have_Diplomatic_Job_Yes_Rdo);
                writeText(relatives_Diplomatic_Job_Description_Txt,relative_Diplomatic_Job_Description);
                break;
            case 'N':
                clickWebElement(relatives_have_Diplomatic_Job_Yes_Rdo);
                clickWebElement(relatives_have_Diplomatic_Job_No_Rdo);
                break;
            default:
                System.out.println("wrong input");
                break;
        }
    }
    @Step("upload NID Side1.")
    @SneakyThrows
    public void upload_NID_Side1(String NID_Front_Directory_Path, String img_Default_src_Attribute_Value)
    {
        clickWebElement(NID_Side1_Upload_Btn);
        upload_Robot(NID_Front_Directory_Path, NID_Side1_Img, "src", img_Default_src_Attribute_Value);
        validate_NID_Upload(NID_Side1_Img, img_Default_src_Attribute_Value, "NID Side1 was uploaded successfully assertion");
    }
    @Step("upload NID Side2 (optional).")
    @SneakyThrows
    public void upload_NID_Side2(String NID_Back_Directory_Path, String img_Default_src_Attribute_Value)
    {
        clickWebElement(NID_Side2_Upload_Btn);
        upload_Robot(NID_Back_Directory_Path, NID_Side2_Img, "src", img_Default_src_Attribute_Value);
        validate_NID_Upload(NID_Side2_Img, img_Default_src_Attribute_Value,"NID Side2 was uploaded successfully assertion");
    }
    @Step("Clicks Create")
    public void click_Create()
    {
        clickWebElement(create_Btn);
        validate_KYC_Creation();
    }

    /**
     * One big method that has all methods of creating KYC to put ot as a step before submitting kyc,
     * then even I am just considering to separate creating kyc methods into small cluster methods;
     * one for personal info, one for address, etc...
     * And I only use it in Axis_Integrations project...And I don't advice creating such big methods again
     * unless very needed!
     */
    public void create_KYC(String mobile_Number,String first_Name_Arabic,String last_Name_Arabic,String NID,String NID_Expiry_Date,
                           String martial_Status, String email_Address,String address,String current_Address,
                           String SME_Name,String job_Title,String work_Entity,String work_Address,String income_Source,
                           String monthly_Income,String profile_Name,String transaction_Nature,String wallet_Objective,
                           char yes_Or_No_Diplomatic_Job, String diplomatic_Job_Description, char yes_Or_No_Relative_Diplomatic,
                           String relative_Diplomatic_Job_Description, String NID_Front_Directory_Path,String img_Default_src_Attribute_Value,
                           String NID_Back_Directory_Path)
    {
        enter_Wallet_Number(mobile_Number);
        click_Submit();
        enter_First_Name_Arabic(first_Name_Arabic);
        enter_Last_Name_Arabic(last_Name_Arabic);
        enter_National_ID(NID);
        enter_National_ID_Expiry_Date(NID_Expiry_Date);
        enter_Martial_Status(martial_Status);
        enter_Email(email_Address);
        enter_Governorate();
        enter_City();
        enter_Address(address);
        unclick_Current_Address_SameAs_Personal_Address();
        enter_Current_Address(current_Address);
        click_Not_Linked_To_SME();
        click_Linked_To_SME();
        enter_SME_Name(SME_Name);
        enter_JobTitle(job_Title);
        enter_Work_Entity_Name(work_Entity);
        enter_Work_Address(work_Address);
        enter_Source_Of_Income(income_Source);
        enter_Monthly_Income(monthly_Income);
        enter_Profile_Name(profile_Name);
        enter_Transaction_Nature(transaction_Nature);
        enter_Wallet_Registration_Objective(wallet_Objective);
        click_Diplomatic_Job(yes_Or_No_Diplomatic_Job,diplomatic_Job_Description);
        click_Relative_Diplomatic_Job(yes_Or_No_Relative_Diplomatic,relative_Diplomatic_Job_Description);
        upload_NID_Side1(NID_Front_Directory_Path,img_Default_src_Attribute_Value);
        upload_NID_Side2(NID_Back_Directory_Path,img_Default_src_Attribute_Value);
        click_Create();
    }

    /********************************************ASSERTIONS*****************************************************/
    /**
     * 1) This method is to make sure that there is a restriction when calculating the birthdate from NID;
     * Restriction: person's age should be (age < 99 && age => 16)
     * 3) line-260: I use Year class to get the value of the exact year we are currently in.
     * 4) line-261: I get the NID's value from NID-element's value-attribute
     * 5) line-263: I use .split() method to change the String into Array of String.
     * 6) line-264: If first character is 2 -> concatenate the 2nd & 3rd characters then parse into integer to add 1900
     */
    private void validate_BirthDate()
    {
        int current_Year = Year.now().getValue();
        String NID_Value_String = national_ID_Txt.getAttribute("value");
        String input_Birth_date = birth_Date_Txt.getAttribute("value");
        String[] NID_Value_Array = NID_Value_String.split("");
        if(NID_Value_Array[0].equals("2"))
        {
            Integer year_Of_Birth = Integer.parseInt(NID_Value_Array[1]+NID_Value_Array[2]) + 1900;
            Assert.assertTrue((current_Year - year_Of_Birth) < 99, "year of birth (1900s') Assertion");

            String birth_Date = NID_Value_Array[5]+NID_Value_Array[6]+"-"+NID_Value_Array[3]+NID_Value_Array[4]
                    + "-" + year_Of_Birth.toString();
            Assert.assertEquals(input_Birth_date,birth_Date,"Date of Birth (1900s') is calculated correctly Assertion");
        }
        else if(NID_Value_Array[0].equals("3"))
        {
            Integer year_Of_Birth = Integer.getInteger(NID_Value_Array[1]+NID_Value_Array[2]) + 2000;
            Assert.assertTrue((current_Year - year_Of_Birth) >= 16, "year of birth (2000s') Assertion");

            String birth_Date = NID_Value_Array[5]+NID_Value_Array[6]+"-"+NID_Value_Array[3]+NID_Value_Array[4]
                    + "-" + year_Of_Birth.toString();
            Assert.assertEquals(NID_Value_String,birth_Date,"Date of Birth (2000s') is calculated correctly Assertion");
        }
    }

    private void validate_Governorate()
    {
        Assert.assertTrue((cairo_Governorate_Opt.getAttribute("aria-selected")).equals("true"));
    }

    /**
     * 1) It gets the value of an attribute "title" in the WebElement that contains the text of the
     * chosen marital_status.
     * 2) Then it compares that value with the passed String's value (martial_Status) to make sure that
     * the required one is the one got chosen.
     * @param martial_Status
     */
    @SneakyThrows
    private void validate_Martial_Status(String martial_Status)
    {
        Thread.sleep(3000);
        System.out.println("hi"+(driver.findElement(By.xpath("//span[contains(text(),'"+
                martial_Status +"')]")).getText()));

        Assert.assertEquals((driver.findElement(By.xpath("//span[contains(text(),'"+
                martial_Status +"')]")).getText()), martial_Status,
                "correct marital status is chosen assertion");
    }

    private void validate_City(String city)
    {
        Assert.assertEquals((driver.findElement(By.xpath("//span[contains(text(),'"+
                city +"')]")).getAttribute("title")),city,
                "correct city is chosen assertion");
    }

    private void validate_NID_Upload(WebElement NID_Side, String img_Default_src_Attribute, String assertion_Msg)
    {
        Assert.assertFalse(NID_Side.getAttribute("src").contains(img_Default_src_Attribute), assertion_Msg);
    }

    private void validate_KYC_Creation()
    {
        Assert.assertTrue(submit_Btn.isDisplayed());
        Assert.assertTrue(submit_Btn.isEnabled());
    }

}
