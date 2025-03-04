package pages.navigation_menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page_Base;

public class Navigation_Menu_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public Navigation_Menu_WebElements(WebDriver driver) {
        super(driver);
    }

    /****************************************LOCATORS*******************************************/
    /**
     * Naming of variables: camel-case convention naming, and will have underscore “_” as a delimiter between each word-syllabus.
     * The name of the variable should have a name same as the one displayed in the UI for the web-element.
     * Names-Suffix Notes:
     * 1)Txt:TextBox; 2)Link:WebLink; 3)Btn:Button; 4)Li:ListItem;
     * 5)Msg:Message; 6)DDL:DropDownList; 7)Opt:Option; 8)Chbox:CheckBox;
     * 9)Rdo:RadioButton; 10)TxtArea:TextArea; 11)td:table-data(column)
     */
    By localization_Btn_Locator = By.className("icp-nav-link-inner");
    By english_Option_Locator = By.xpath("(//span[text()='English'])[1]");

    /****************************************WEB-ELEMENTS*******************************************/
    @FindBy(id = "nav-hamburger-menu")
    WebElement all_Menu_DDL;
    @FindBy(xpath = "//div[contains(text(),'See all')]")
    WebElement see_All_Li;
    @FindBy(xpath = "//a[@class='hmenu-item'] /div[contains(text(),'Video Games')]")
    WebElement video_Games_Li;
    @FindBy (xpath = "//a[@class='hmenu-item'][contains(text(),'All Video Games')]")
    WebElement all_Video_Games_Li;
}
