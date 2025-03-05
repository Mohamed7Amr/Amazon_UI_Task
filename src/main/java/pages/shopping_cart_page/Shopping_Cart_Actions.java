package pages.shopping_cart_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static data_store.Map_Data.get_Map_Key_Data;

public class Shopping_Cart_Actions extends Shopping_Cart_WebElements{

    /*****************************************CONSTRUCTORS******************************************/
    public Shopping_Cart_Actions(WebDriver driver) {
        super(driver);
    }

    /******************************************VALIDATIONS***********************************************/
    @Step("Validate that all products are added to cart")
    public void validate_All_Products_Are_Added_To_Cart()
    {
        System.out.println(getText(find_Element(subtotal_Amount_Label)));
        Assert.assertEquals(get_Map_Key_Data("total_Price",0),
                convert_String_To_Double(replace_String_With_Regex(getText(find_Element(subtotal_Amount_Label)),
                        "[^0-9.]","")),"Total price should be calculated correctly in the added cart");

//        System.out.println(getText(find_Element(number_Of_Items_Label)));
//        Assert.assertEquals(get_Map_Key_Data("number_Of_Added_Items",0),
//                convert_String_To_Double(replace_String_With_Regex(getText(find_Element(number_Of_Items_Label)),"[^0-9]","")),
//                "Number of added items should be calculated correctly in the added cart");


    }
}
