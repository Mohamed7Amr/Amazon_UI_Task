package pages.video_games_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

import java.util.List;

public class Video_Games_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public Video_Games_WebElements(WebDriver driver) {
        super(driver);
    }
    /****************************************LOCATORS*******************************************/
    /**
     * Naming of variables: camel-case convention naming, and will have underscore “_” as a delimiter between each word-syllabus.
     * The name of the variable should have a name same as the one displayed in the UI for the web-element.
     * Names-Suffix Notes:
     * 1)Txt:TextBox; 2)Link:WebLink; 3)Btn:Button; 4)Li:ListItem;
     * 5)Msg:Message; 6)DDL:DropDownList; 7)Opt:Option; 8)Checkbox:CheckBox;
     * 9)Rdo:RadioButton; 10)TxtArea:TextArea; 11)td:table-data(column)
     */
    By free_Shipping_Checkbox_Locator = By.xpath("//span[contains(text(),'All customers get FREE Shipping on orders shipped by Amazon')]");
    By new_Condition_Link_Locator = By.xpath("//span[@class='a-size-base a-color-base'][contains(text(),'New')]");
    By sort_DDL_Locator = By.xpath( "//span[@class='a-dropdown-label'][contains(text(),'Sort by:')]");
    By high_To_Low_Option_Locator = By.xpath( "//li[contains(.,'Price: High to Low')]");
//    By product_Price_Label_Locator = By.xpath("//span[@class='a-price']//span[@class='a-price-whole']");
    By product_Price_Label_Locator = By.xpath("//div[@data-cy='price-recipe']//span[@class='a-price']/span[@class='a-offscreen']");
//    By search_Result_Form_Locator = By.xpath("//form[@method='post']");//span[@data-component-type='s-search-results']//span[@class='a-price']/span[@class='a-offscreen']  //div[@data-cy='price-recipe']//span[@class='a-offscreen']
    By inner_Card_Of_Search_Result_Info_Locator = By.xpath("//div[@data-cy='price-recipe']/parent::div[@class='puisg-col-inner']");
    By add_To_Cart_Btn_Locator = By.xpath("//button[@class='a-button-text'][text()='Add to cart']");
    By next_Page_Btn_Locator = By.xpath("//a[contains(text(),'Next')]");
    By cart_Btn_Locator = By.id("nav-cart-count-container");



    /****************************************WEB-ELEMENTS*******************************************/
    @FindBy(xpath = "//div[@data-cy='price-recipe']//span[@class='a-price']/span[@class='a-offscreen']")
    WebElement product_Price;
    @FindBy(xpath = "//div[@data-cy='price-recipe']//span[@class='a-price']/span[@class='a-offscreen']")
    List<WebElement> products_Prices;
}
