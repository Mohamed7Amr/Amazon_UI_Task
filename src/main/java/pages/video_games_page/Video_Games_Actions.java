package pages.video_games_page;

import static data_store.Map_Data.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Video_Games_Actions extends Video_Games_WebElements {

    /*****************************************CONSTRUCTORS******************************************/
    public Video_Games_Actions(WebDriver driver) {
        super(driver);
    }

    /*****************************************ACTIONS**********************************************/
    @Step("Filter with \"free shipping\"")
    public void filter_With_Free_Shipping() {
        clickWebElement(find_Element(free_Shipping_Checkbox_Locator));
    }

    @Step("Filter with \"New\" condition")
    public void filter_With_New_Condition() {
        clickWebElement(find_Element(new_Condition_Link_Locator));
    }

    @Step("Open sort menu")
    public void open_Sort_Menu() {
        clickWebElement(find_Element(sort_DDL_Locator));
    }

    @Step("Sort from high to low")
    public void sort_High_To_Low() {
        clickWebElement(find_Element(high_To_Low_Option_Locator));
    }

    @Step("add products with price less than cap-price")
    public void add_Products_with_Price_Less_Than_Cap_Price(double max_Price) {
        int number_Of_Added_Items = 0;
        int number_Of_Search_Results_Which_Has_AddCartBtn = 0;
        double total_Price = 0;
        while (number_Of_Added_Items == 0)
        {
            for (WebElement x : find_Elements(product_Price_Label_Locator))
            {
                System.out.println(js_Get_Text(x));
//                if (convert_String_To_Double(replace_String_With_Regex(js_Get_Text(x),"[^0-9.]","")) <= max_Price)
                if(find_Elements(inner_Card_Of_Search_Result_Info_Locator).get(number_Of_Search_Results_Which_Has_AddCartBtn).findElement(add_To_Cart_Btn_Locator).isEnabled())
                {
                    number_Of_Search_Results_Which_Has_AddCartBtn++;
                    System.out.println("Nouran Ahmed AKA Nono/Simba");

//                    System.out.println(find_Elements(inner_Card_Of_Search_Result_Info_Locator).get(number_Of_Added_Items).findElement(add_To_Cart_Btn_Locator));
//                    if(find_Elements(inner_Card_Of_Search_Result_Info_Locator).get(number_Of_Added_Items).findElement(add_To_Cart_Btn_Locator).isEnabled())//equals("Add to cart"))
                    if (convert_String_To_Double(replace_String_With_Regex(js_Get_Text(x),"[^0-9.]","")) <= max_Price)
                    {
                        clickWebElement(find_Elements(add_To_Cart_Btn_Locator).get(number_Of_Added_Items));
                        total_Price += convert_String_To_Double(replace_String_With_Regex(js_Get_Text(x),"[^0-9.]",""));
                        number_Of_Added_Items++;
                    }
                }
            }
            if (number_Of_Added_Items > 0) {
                add_Map_Key_Data("total_Price",total_Price);
                add_Map_Key_Data("number_Of_Added_Items",number_Of_Added_Items);
                break;
            } else {
                clickWebElement(find_Element(next_Page_Btn_Locator));
            }
        }
    }
    @Step("Open shopping cart")
    public void click_On_Cart()
    {
        clickWebElement(find_Element(cart_Btn_Locator));
    }

}