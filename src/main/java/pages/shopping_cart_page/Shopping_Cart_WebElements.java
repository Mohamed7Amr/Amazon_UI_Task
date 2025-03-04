package pages.shopping_cart_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Page_Base;

public class Shopping_Cart_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public Shopping_Cart_WebElements(WebDriver driver) {
        super(driver);
    }

    /****************************************LOCATORS************************************************/
    By number_Of_Items_Label = By.id("sc-subtotal-label-buybox");
    By subtotal_Amount_Label = By.cssSelector("#sc-subtotal-amount-buybox>span");
}
